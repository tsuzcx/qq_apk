package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.share.internal.ShareInternalUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebDialog
  extends Dialog
{
  private static final int API_EC_DIALOG_CANCEL = 4201;
  private static final int BACKGROUND_GRAY = -872415232;
  private static final int DEFAULT_THEME = 2131821742;
  static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
  private static final String DISPLAY_TOUCH = "touch";
  private static final String LOG_TAG = "FacebookSDK.WebDialog";
  private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
  private static final int MAX_PADDING_SCREEN_WIDTH = 800;
  private static final double MIN_SCALE_FACTOR = 0.5D;
  private static final int NO_PADDING_SCREEN_HEIGHT = 800;
  private static final int NO_PADDING_SCREEN_WIDTH = 480;
  private static volatile int webDialogTheme;
  private FrameLayout contentFrameLayout;
  private ImageView crossImageView;
  private String expectedRedirectUrl;
  private boolean isDetached;
  private boolean isPageFinished;
  private boolean listenerCalled;
  private OnCompleteListener onCompleteListener;
  private ProgressDialog spinner;
  private UploadStagingResourcesTask uploadTask;
  private String url;
  private WebView webView;
  private WindowManager.LayoutParams windowParams;
  
  protected WebDialog(Context paramContext, String paramString)
  {
    this(paramContext, paramString, getWebDialogTheme());
    AppMethodBeat.i(7700);
    AppMethodBeat.o(7700);
  }
  
  private WebDialog(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, i);
    AppMethodBeat.i(7701);
    this.expectedRedirectUrl = "fbconnect://success";
    this.listenerCalled = false;
    this.isDetached = false;
    this.isPageFinished = false;
    this.url = paramString;
    AppMethodBeat.o(7701);
  }
  
  private WebDialog(Context paramContext, String paramString, Bundle paramBundle, int paramInt, OnCompleteListener paramOnCompleteListener)
  {
    super(paramContext, i);
    AppMethodBeat.i(7702);
    this.expectedRedirectUrl = "fbconnect://success";
    this.listenerCalled = false;
    this.isDetached = false;
    this.isPageFinished = false;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (Utility.isChromeOS(paramContext)) {}
    for (paramContext = "fbconnect://chrome_os_success";; paramContext = "fbconnect://success")
    {
      this.expectedRedirectUrl = paramContext;
      localBundle.putString("redirect_uri", this.expectedRedirectUrl);
      localBundle.putString("display", "touch");
      localBundle.putString("client_id", FacebookSdk.getApplicationId());
      localBundle.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[] { FacebookSdk.getSdkVersion() }));
      this.onCompleteListener = paramOnCompleteListener;
      if ((!paramString.equals("share")) || (!localBundle.containsKey("media"))) {
        break;
      }
      this.uploadTask = new UploadStagingResourcesTask(paramString, localBundle);
      AppMethodBeat.o(7702);
      return;
    }
    this.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + paramString, localBundle).toString();
    AppMethodBeat.o(7702);
  }
  
  private void createCrossImage()
  {
    AppMethodBeat.i(7716);
    this.crossImageView = new ImageView(getContext());
    this.crossImageView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(7680);
        WebDialog.this.cancel();
        AppMethodBeat.o(7680);
      }
    });
    Drawable localDrawable = getContext().getResources().getDrawable(2131231885);
    this.crossImageView.setImageDrawable(localDrawable);
    this.crossImageView.setVisibility(4);
    AppMethodBeat.o(7716);
  }
  
  private int getScaledSize(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    double d = 0.5D;
    int i = (int)(paramInt1 / paramFloat);
    if (i <= paramInt2) {
      d = 1.0D;
    }
    for (;;)
    {
      return (int)(d * paramInt1);
      if (i < paramInt3) {
        d = 0.5D + (paramInt3 - i) / (paramInt3 - paramInt2) * 0.5D;
      }
    }
  }
  
  public static int getWebDialogTheme()
  {
    AppMethodBeat.i(7699);
    Validate.sdkInitialized();
    int i = webDialogTheme;
    AppMethodBeat.o(7699);
    return i;
  }
  
  protected static void initDefaultTheme(Context paramContext)
  {
    AppMethodBeat.i(7697);
    if (paramContext == null)
    {
      AppMethodBeat.o(7697);
      return;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext == null) || (paramContext.metaData == null))
      {
        AppMethodBeat.o(7697);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(7697);
      return;
    }
    if (webDialogTheme == 0) {
      setWebDialogTheme(paramContext.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
    }
    AppMethodBeat.o(7697);
  }
  
  public static WebDialog newInstance(Context paramContext, String paramString, Bundle paramBundle, int paramInt, OnCompleteListener paramOnCompleteListener)
  {
    AppMethodBeat.i(7698);
    initDefaultTheme(paramContext);
    paramContext = new WebDialog(paramContext, paramString, paramBundle, paramInt, paramOnCompleteListener);
    AppMethodBeat.o(7698);
    return paramContext;
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void setUpWebView(int paramInt)
  {
    AppMethodBeat.i(7717);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    this.webView = new WebView(getContext())
    {
      public void onWindowFocusChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(7681);
        try
        {
          super.onWindowFocusChanged(paramAnonymousBoolean);
          AppMethodBeat.o(7681);
          return;
        }
        catch (NullPointerException localNullPointerException)
        {
          AppMethodBeat.o(7681);
        }
      }
    };
    this.webView.setVerticalScrollBarEnabled(false);
    this.webView.setHorizontalScrollBarEnabled(false);
    this.webView.setWebViewClient(new DialogWebViewClient(null));
    this.webView.getSettings().setJavaScriptEnabled(true);
    this.webView.loadUrl(this.url);
    this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.webView.setVisibility(4);
    this.webView.getSettings().setSavePassword(false);
    this.webView.getSettings().setSaveFormData(false);
    this.webView.setFocusable(true);
    this.webView.setFocusableInTouchMode(true);
    this.webView.setOnTouchListener(new WebDialog.4(this));
    localLinearLayout.setPadding(paramInt, paramInt, paramInt, paramInt);
    localLinearLayout.addView(this.webView);
    localLinearLayout.setBackgroundColor(-872415232);
    this.contentFrameLayout.addView(localLinearLayout);
    AppMethodBeat.o(7717);
  }
  
  public static void setWebDialogTheme(int paramInt)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      webDialogTheme = paramInt;
      return;
      paramInt = DEFAULT_THEME;
    }
  }
  
  public void cancel()
  {
    AppMethodBeat.i(7715);
    if ((this.onCompleteListener != null) && (!this.listenerCalled)) {
      sendErrorToListener(new FacebookOperationCanceledException());
    }
    AppMethodBeat.o(7715);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(7704);
    if (this.webView != null) {
      this.webView.stopLoading();
    }
    if ((!this.isDetached) && (this.spinner != null) && (this.spinner.isShowing())) {
      this.spinner.dismiss();
    }
    super.dismiss();
    AppMethodBeat.o(7704);
  }
  
  public OnCompleteListener getOnCompleteListener()
  {
    return this.onCompleteListener;
  }
  
  protected WebView getWebView()
  {
    return this.webView;
  }
  
  protected boolean isListenerCalled()
  {
    return this.listenerCalled;
  }
  
  protected boolean isPageFinished()
  {
    return this.isPageFinished;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(7708);
    this.isDetached = false;
    if ((Utility.mustFixWindowParamsForAutofill(getContext())) && (this.windowParams != null) && (this.windowParams.token == null))
    {
      this.windowParams.token = getOwnerActivity().getWindow().getAttributes().token;
      Utility.logd("FacebookSDK.WebDialog", "Set token on onAttachedToWindow(): " + this.windowParams.token);
    }
    super.onAttachedToWindow();
    AppMethodBeat.o(7708);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7710);
    super.onCreate(paramBundle);
    this.spinner = new ProgressDialog(getContext());
    this.spinner.requestWindowFeature(1);
    this.spinner.setMessage(getContext().getString(2131757728));
    this.spinner.setCanceledOnTouchOutside(false);
    this.spinner.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(7679);
        WebDialog.this.cancel();
        AppMethodBeat.o(7679);
      }
    });
    requestWindowFeature(1);
    this.contentFrameLayout = new FrameLayout(getContext());
    resize();
    getWindow().setGravity(17);
    getWindow().setSoftInputMode(16);
    createCrossImage();
    if (this.url != null) {
      setUpWebView(this.crossImageView.getDrawable().getIntrinsicWidth() / 2 + 1);
    }
    this.contentFrameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
    setContentView(this.contentFrameLayout);
    AppMethodBeat.o(7710);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(7707);
    this.isDetached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(7707);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(7703);
    if (paramInt == 4) {
      cancel();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(7703);
    return bool;
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(7705);
    super.onStart();
    if ((this.uploadTask != null) && (this.uploadTask.getStatus() == AsyncTask.Status.PENDING))
    {
      this.uploadTask.execute(new Void[0]);
      this.spinner.show();
      AppMethodBeat.o(7705);
      return;
    }
    resize();
    AppMethodBeat.o(7705);
  }
  
  protected void onStop()
  {
    AppMethodBeat.i(7706);
    if (this.uploadTask != null)
    {
      this.uploadTask.cancel(true);
      this.spinner.dismiss();
    }
    super.onStop();
    AppMethodBeat.o(7706);
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(7709);
    if (paramLayoutParams.token == null) {
      this.windowParams = paramLayoutParams;
    }
    super.onWindowAttributesChanged(paramLayoutParams);
    AppMethodBeat.o(7709);
  }
  
  protected Bundle parseResponseUri(String paramString)
  {
    AppMethodBeat.i(7711);
    paramString = Uri.parse(paramString);
    Bundle localBundle = Utility.parseUrlQueryString(paramString.getQuery());
    localBundle.putAll(Utility.parseUrlQueryString(paramString.getFragment()));
    AppMethodBeat.o(7711);
    return localBundle;
  }
  
  public void resize()
  {
    AppMethodBeat.i(7712);
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    int i;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      i = localDisplayMetrics.widthPixels;
      if (localDisplayMetrics.widthPixels >= localDisplayMetrics.heightPixels) {
        break label153;
      }
    }
    label153:
    for (int j = localDisplayMetrics.heightPixels;; j = localDisplayMetrics.widthPixels)
    {
      i = Math.min(getScaledSize(i, localDisplayMetrics.density, 480, 800), localDisplayMetrics.widthPixels);
      j = Math.min(getScaledSize(j, localDisplayMetrics.density, 800, 1280), localDisplayMetrics.heightPixels);
      getWindow().setLayout(i, j);
      AppMethodBeat.o(7712);
      return;
      i = localDisplayMetrics.heightPixels;
      break;
    }
  }
  
  protected void sendErrorToListener(Throwable paramThrowable)
  {
    AppMethodBeat.i(7714);
    if ((this.onCompleteListener != null) && (!this.listenerCalled))
    {
      this.listenerCalled = true;
      if (!(paramThrowable instanceof FacebookException)) {
        break label59;
      }
    }
    label59:
    for (paramThrowable = (FacebookException)paramThrowable;; paramThrowable = new FacebookException(paramThrowable))
    {
      this.onCompleteListener.onComplete(null, paramThrowable);
      dismiss();
      AppMethodBeat.o(7714);
      return;
    }
  }
  
  protected void sendSuccessToListener(Bundle paramBundle)
  {
    AppMethodBeat.i(7713);
    if ((this.onCompleteListener != null) && (!this.listenerCalled))
    {
      this.listenerCalled = true;
      this.onCompleteListener.onComplete(paramBundle, null);
      dismiss();
    }
    AppMethodBeat.o(7713);
  }
  
  protected void setExpectedRedirectUrl(String paramString)
  {
    this.expectedRedirectUrl = paramString;
  }
  
  public void setOnCompleteListener(OnCompleteListener paramOnCompleteListener)
  {
    this.onCompleteListener = paramOnCompleteListener;
  }
  
  public static class Builder
  {
    private AccessToken accessToken;
    private String action;
    private String applicationId;
    private Context context;
    private WebDialog.OnCompleteListener listener;
    private Bundle parameters;
    private int theme;
    
    public Builder(Context paramContext, String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(7683);
      this.accessToken = AccessToken.getCurrentAccessToken();
      if (!AccessToken.isCurrentAccessTokenActive())
      {
        String str = Utility.getMetadataApplicationId(paramContext);
        if (str != null) {
          this.applicationId = str;
        }
      }
      else
      {
        finishInit(paramContext, paramString, paramBundle);
        AppMethodBeat.o(7683);
        return;
      }
      paramContext = new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
      AppMethodBeat.o(7683);
      throw paramContext;
    }
    
    public Builder(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    {
      AppMethodBeat.i(7684);
      String str = paramString1;
      if (paramString1 == null) {
        str = Utility.getMetadataApplicationId(paramContext);
      }
      Validate.notNullOrEmpty(str, "applicationId");
      this.applicationId = str;
      finishInit(paramContext, paramString2, paramBundle);
      AppMethodBeat.o(7684);
    }
    
    private void finishInit(Context paramContext, String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(7686);
      this.context = paramContext;
      this.action = paramString;
      if (paramBundle != null)
      {
        this.parameters = paramBundle;
        AppMethodBeat.o(7686);
        return;
      }
      this.parameters = new Bundle();
      AppMethodBeat.o(7686);
    }
    
    public WebDialog build()
    {
      AppMethodBeat.i(7685);
      if (this.accessToken != null)
      {
        this.parameters.putString("app_id", this.accessToken.getApplicationId());
        this.parameters.putString("access_token", this.accessToken.getToken());
      }
      for (;;)
      {
        WebDialog localWebDialog = WebDialog.newInstance(this.context, this.action, this.parameters, this.theme, this.listener);
        AppMethodBeat.o(7685);
        return localWebDialog;
        this.parameters.putString("app_id", this.applicationId);
      }
    }
    
    public String getApplicationId()
    {
      return this.applicationId;
    }
    
    public Context getContext()
    {
      return this.context;
    }
    
    public WebDialog.OnCompleteListener getListener()
    {
      return this.listener;
    }
    
    public Bundle getParameters()
    {
      return this.parameters;
    }
    
    public int getTheme()
    {
      return this.theme;
    }
    
    public Builder setOnCompleteListener(WebDialog.OnCompleteListener paramOnCompleteListener)
    {
      this.listener = paramOnCompleteListener;
      return this;
    }
    
    public Builder setTheme(int paramInt)
    {
      this.theme = paramInt;
      return this;
    }
  }
  
  class DialogWebViewClient
    extends WebViewClient
  {
    private byte _hellAccFlag_;
    
    private DialogWebViewClient() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7691);
      super.onPageFinished(paramWebView, paramString);
      if (!WebDialog.this.isDetached) {
        WebDialog.this.spinner.dismiss();
      }
      WebDialog.this.contentFrameLayout.setBackgroundColor(0);
      WebDialog.this.webView.setVisibility(0);
      WebDialog.this.crossImageView.setVisibility(0);
      WebDialog.access$702(WebDialog.this, true);
      AppMethodBeat.o(7691);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(7690);
      Utility.logd("FacebookSDK.WebDialog", "Webview loading URL: ".concat(String.valueOf(paramString)));
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (!WebDialog.this.isDetached) {
        WebDialog.this.spinner.show();
      }
      AppMethodBeat.o(7690);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(7688);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      WebDialog.this.sendErrorToListener(new FacebookDialogException(paramString1, paramInt, paramString2));
      AppMethodBeat.o(7688);
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      AppMethodBeat.i(7689);
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      paramSslErrorHandler.cancel();
      WebDialog.this.sendErrorToListener(new FacebookDialogException(null, -11, null));
      AppMethodBeat.o(7689);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(7687);
      Utility.logd("FacebookSDK.WebDialog", "Redirect URL: ".concat(String.valueOf(paramString)));
      Bundle localBundle;
      Object localObject;
      if (paramString.startsWith(WebDialog.this.expectedRedirectUrl))
      {
        localBundle = WebDialog.this.parseResponseUri(paramString);
        paramWebView = localBundle.getString("error");
        paramString = paramWebView;
        if (paramWebView == null) {
          paramString = localBundle.getString("error_type");
        }
        localObject = localBundle.getString("error_msg");
        paramWebView = (WebView)localObject;
        if (localObject == null) {
          paramWebView = localBundle.getString("error_message");
        }
        localObject = paramWebView;
        if (paramWebView == null) {
          localObject = localBundle.getString("error_description");
        }
        paramWebView = localBundle.getString("error_code");
        if (Utility.isNullOrEmpty(paramWebView)) {
          break label391;
        }
      }
      for (;;)
      {
        try
        {
          i = Integer.parseInt(paramWebView);
          if ((Utility.isNullOrEmpty(paramString)) && (Utility.isNullOrEmpty((String)localObject)) && (i == -1))
          {
            WebDialog.this.sendSuccessToListener(localBundle);
            AppMethodBeat.o(7687);
            return true;
          }
        }
        catch (NumberFormatException paramWebView)
        {
          i = -1;
          continue;
          if ((paramString != null) && ((paramString.equals("access_denied")) || (paramString.equals("OAuthAccessDeniedException"))))
          {
            WebDialog.this.cancel();
            continue;
          }
          if (i == 4201)
          {
            WebDialog.this.cancel();
            continue;
          }
          paramWebView = new FacebookRequestError(i, paramString, (String)localObject);
          WebDialog.this.sendErrorToListener(new FacebookServiceException(paramWebView, (String)localObject));
          continue;
        }
        if (paramString.startsWith("fbconnect://cancel"))
        {
          WebDialog.this.cancel();
          AppMethodBeat.o(7687);
          return true;
        }
        if (paramString.contains("touch"))
        {
          AppMethodBeat.o(7687);
          return false;
        }
        try
        {
          paramWebView = WebDialog.this.getContext();
          paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(paramWebView, paramString.axQ(), "com/facebook/internal/WebDialog$DialogWebViewClient", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramWebView.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramWebView, "com/facebook/internal/WebDialog$DialogWebViewClient", "shouldOverrideUrlLoading", "(Landroid/webkit/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(7687);
          return true;
        }
        catch (ActivityNotFoundException paramWebView)
        {
          AppMethodBeat.o(7687);
          return false;
        }
        label391:
        int i = -1;
      }
    }
  }
  
  public static abstract interface OnCompleteListener
  {
    public abstract void onComplete(Bundle paramBundle, FacebookException paramFacebookException);
  }
  
  class UploadStagingResourcesTask
    extends AsyncTask<Void, Void, String[]>
  {
    private String action;
    private Exception[] exceptions;
    private Bundle parameters;
    
    UploadStagingResourcesTask(String paramString, Bundle paramBundle)
    {
      this.action = paramString;
      this.parameters = paramBundle;
    }
    
    protected String[] doInBackground(Void... paramVarArgs)
    {
      AppMethodBeat.i(7693);
      Object localObject = this.parameters.getStringArray("media");
      final String[] arrayOfString = new String[localObject.length];
      this.exceptions = new Exception[localObject.length];
      final CountDownLatch localCountDownLatch = new CountDownLatch(localObject.length);
      paramVarArgs = new ConcurrentLinkedQueue();
      AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
      final int i = 0;
      label228:
      for (;;)
      {
        try
        {
          if (i < localObject.length) {
            if (isCancelled())
            {
              localObject = paramVarArgs.iterator();
              if (((Iterator)localObject).hasNext())
              {
                ((AsyncTask)((Iterator)localObject).next()).cancel(true);
                continue;
              }
            }
          }
          Uri localUri;
          i += 1;
        }
        catch (Exception localException)
        {
          paramVarArgs = paramVarArgs.iterator();
          if (paramVarArgs.hasNext())
          {
            ((AsyncTask)paramVarArgs.next()).cancel(true);
            continue;
            AppMethodBeat.o(7693);
            return null;
            localUri = Uri.parse(localException[i]);
            if (Utility.isWebUri(localUri))
            {
              arrayOfString[i] = localUri.toString();
              localCountDownLatch.countDown();
            }
            else
            {
              paramVarArgs.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(localAccessToken, localUri, new GraphRequest.Callback()
              {
                public void onCompleted(GraphResponse paramAnonymousGraphResponse)
                {
                  AppMethodBeat.i(7692);
                  try
                  {
                    Object localObject = paramAnonymousGraphResponse.getError();
                    if (localObject != null)
                    {
                      String str = ((FacebookRequestError)localObject).getErrorMessage();
                      localObject = str;
                      if (str == null) {
                        localObject = "Error staging photo.";
                      }
                      paramAnonymousGraphResponse = new FacebookGraphResponseException(paramAnonymousGraphResponse, (String)localObject);
                      AppMethodBeat.o(7692);
                      throw paramAnonymousGraphResponse;
                    }
                  }
                  catch (Exception paramAnonymousGraphResponse)
                  {
                    WebDialog.UploadStagingResourcesTask.this.exceptions[i] = paramAnonymousGraphResponse;
                  }
                  for (;;)
                  {
                    localCountDownLatch.countDown();
                    AppMethodBeat.o(7692);
                    return;
                    paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
                    if (paramAnonymousGraphResponse == null)
                    {
                      paramAnonymousGraphResponse = new FacebookException("Error staging photo.");
                      AppMethodBeat.o(7692);
                      throw paramAnonymousGraphResponse;
                    }
                    paramAnonymousGraphResponse = paramAnonymousGraphResponse.optString("uri");
                    if (paramAnonymousGraphResponse == null)
                    {
                      paramAnonymousGraphResponse = new FacebookException("Error staging photo.");
                      AppMethodBeat.o(7692);
                      throw paramAnonymousGraphResponse;
                    }
                    arrayOfString[i] = paramAnonymousGraphResponse;
                  }
                }
              }).executeAsync());
              break label228;
              localCountDownLatch.await();
              AppMethodBeat.o(7693);
              return arrayOfString;
            }
          }
          else
          {
            AppMethodBeat.o(7693);
            return null;
          }
        }
      }
    }
    
    protected void onPostExecute(String[] paramArrayOfString)
    {
      AppMethodBeat.i(7694);
      WebDialog.this.spinner.dismiss();
      Exception[] arrayOfException = this.exceptions;
      int j = arrayOfException.length;
      int i = 0;
      while (i < j)
      {
        Exception localException = arrayOfException[i];
        if (localException != null)
        {
          WebDialog.this.sendErrorToListener(localException);
          AppMethodBeat.o(7694);
          return;
        }
        i += 1;
      }
      if (paramArrayOfString == null)
      {
        WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
        AppMethodBeat.o(7694);
        return;
      }
      paramArrayOfString = Arrays.asList(paramArrayOfString);
      if (paramArrayOfString.contains(null))
      {
        WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
        AppMethodBeat.o(7694);
        return;
      }
      Utility.putJSONValueInBundle(this.parameters, "media", new JSONArray(paramArrayOfString));
      paramArrayOfString = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + this.action, this.parameters);
      WebDialog.access$902(WebDialog.this, paramArrayOfString.toString());
      i = WebDialog.this.crossImageView.getDrawable().getIntrinsicWidth();
      WebDialog.access$1000(WebDialog.this, i / 2 + 1);
      AppMethodBeat.o(7694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.WebDialog
 * JD-Core Version:    0.7.0.1
 */