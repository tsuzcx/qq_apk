package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APProgressDialog;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;

public class APSystemWebPage
  implements IAPWebPage
{
  private static final int HEADER_BACK = 1;
  private static final int HEADER_CLOSE = 2;
  private static final int HEADER_REFRESH = 4;
  private static final String TAG = "APSystemWebPage";
  private Activity activity;
  private APProgressDialog waitDialog;
  private APWebView webView;
  private IAPWebViewCallback webviewCallback;
  
  public APSystemWebPage()
  {
    AppMethodBeat.i(192858);
    this.webviewCallback = new IAPWebViewCallback()
    {
      public boolean WebChromeClientJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        AppMethodBeat.i(192865);
        APLog.d("APSystemWebPage", "WebChromeClientJsAlert message=".concat(String.valueOf(paramAnonymousString2)));
        APWebProtocol.AnalyzeWebEntry(APSystemWebPage.this.activity, APSystemWebPage.this.webView.getWebView(), APSystemWebPage.this, paramAnonymousString2);
        AppMethodBeat.o(192865);
        return true;
      }
      
      public boolean WebChromeClientJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
      {
        return true;
      }
      
      public void WebViewClientPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        AppMethodBeat.i(192866);
        if ((!APSystemWebPage.this.activity.isFinishing()) && (APSystemWebPage.this.waitDialog != null) && (APSystemWebPage.this.waitDialog.isShowing())) {
          APSystemWebPage.this.waitDialog.dismiss();
        }
        AppMethodBeat.o(192866);
      }
      
      public void WebViewClientPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(192867);
        APSystemWebPage.this.waitDialog.show();
        AppMethodBeat.o(192867);
      }
      
      public void WebViewClientReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(192868);
        if ((!APSystemWebPage.this.activity.isFinishing()) && (APSystemWebPage.this.waitDialog != null) && (APSystemWebPage.this.waitDialog.isShowing())) {
          APSystemWebPage.this.waitDialog.dismiss();
        }
        AppMethodBeat.o(192868);
      }
    };
    AppMethodBeat.o(192858);
  }
  
  protected APProgressDialog createDialog()
  {
    AppMethodBeat.i(192864);
    APProgressDialog localAPProgressDialog = new APProgressDialog(this.activity);
    localAPProgressDialog.setMessage("请稍候...");
    AppMethodBeat.o(192864);
    return localAPProgressDialog;
  }
  
  public void initHead(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192862);
    for (;;)
    {
      try
      {
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.head.init", "", "headControl=" + paramString1 + "&headTitle=" + paramString2);
        int i;
        try
        {
          i = Integer.valueOf(paramString1).intValue();
          paramString1 = paramString2;
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = APMidasTools.urlDecode(paramString2, 1);
          }
          paramString2 = (LinearLayout)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_layout"));
          if ((i <= 0) && (TextUtils.isEmpty(paramString1)))
          {
            paramString2.setVisibility(8);
            AppMethodBeat.o(192862);
            return;
          }
        }
        catch (Exception paramString1)
        {
          i = 0;
          continue;
          paramString2.setVisibility(0);
          paramString2 = (TextView)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_title"));
          if (TextUtils.isEmpty(paramString1)) {
            break label282;
          }
        }
        paramString2.setVisibility(0);
        paramString2.setText(paramString1);
        paramString1 = (ImageButton)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_back"));
        if ((i & 0x1) != 1) {
          break label291;
        }
        paramString1.setVisibility(0);
        paramString1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(192834);
            APLog.d("APSystemWebPage", "backBtn() clicked");
            if ((APSystemWebPage.this.webView != null) && (APSystemWebPage.this.webView.getWebView() != null)) {}
            for (boolean bool = true;; bool = false)
            {
              APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.back", "", "webviewNotNull=".concat(String.valueOf(bool)));
              if ((bool) && (APSystemWebPage.this.webView.getWebView().canGoBack())) {
                APSystemWebPage.this.webView.getWebView().goBack();
              }
              AppMethodBeat.o(192834);
              return;
            }
          }
        });
        paramString1 = (ImageButton)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_close"));
        if ((i & 0x2) != 2) {
          break label300;
        }
        paramString1.setVisibility(0);
        paramString1.setOnClickListener(new APSystemWebPage.5(this, paramActivity));
        paramActivity = (ImageButton)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "midas_header_refresh"));
        if ((i & 0x4) != 4) {
          break;
        }
        paramActivity.setVisibility(0);
        paramActivity.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(192821);
            APLog.d("APSystemWebPage", "refreshBtn() clicked");
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.refresh", "", "");
            if ((APSystemWebPage.this.webView != null) && (APSystemWebPage.this.webView.getWebView() != null)) {
              APSystemWebPage.this.webView.getWebView().reload();
            }
            AppMethodBeat.o(192821);
          }
        });
        AppMethodBeat.o(192862);
        return;
      }
      catch (Throwable paramActivity)
      {
        AppMethodBeat.o(192862);
        return;
      }
      label282:
      paramString2.setVisibility(8);
      continue;
      label291:
      paramString1.setVisibility(8);
      continue;
      label300:
      paramString1.setVisibility(8);
    }
    paramActivity.setVisibility(8);
    AppMethodBeat.o(192862);
  }
  
  public void initUI(Activity paramActivity)
  {
    AppMethodBeat.i(192859);
    this.activity = paramActivity;
    paramActivity.setContentView(APMidasCommMethod.getLayoutId(paramActivity, "unipay_layout_activity_web"));
    this.webView = new APWebView(paramActivity, (WebView)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "unipay_id_WebView")), this.webviewCallback);
    this.waitDialog = createDialog();
    this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(192859);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(192861);
    this.webView.loadUrl(paramString);
    AppMethodBeat.o(192861);
  }
  
  public void toPureH5Pay(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(192860);
    this.activity = paramActivity;
    paramActivity.setContentView(APMidasCommMethod.getLayoutId(paramActivity, "unipay_layout_activity_web"));
    paramAPMidasBaseRequest = (WebView)paramActivity.findViewById(APMidasCommMethod.getId(paramActivity, "unipay_id_WebView"));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramAPMidasBaseRequest.getLayoutParams();
    localLayoutParams.width = ((int)(localDisplayMetrics.widthPixels * 0.85F));
    localLayoutParams.height = ((int)(localDisplayMetrics.heightPixels * 0.85F));
    paramAPMidasBaseRequest.setLayoutParams(localLayoutParams);
    this.webView = new APWebView(paramActivity, paramAPMidasBaseRequest, this.webviewCallback);
    this.waitDialog = createDialog();
    this.waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(192860);
  }
  
  public void updateWebViewSize(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(192863);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.webView.getWebView().getLayoutParams();
    APLog.i("webviewclient == ", "updateWebViewSize ");
    String str = APMidasTools.getUrlParamsValue(paramString, "mpwidth");
    if (!TextUtils.isEmpty(str)) {}
    for (int i = Integer.valueOf(str).intValue();; i = 0)
    {
      paramString = APMidasTools.getUrlParamsValue(paramString, "mpheight");
      if (!TextUtils.isEmpty(paramString)) {
        j = Integer.valueOf(paramString).intValue();
      }
      if ((j != 0) && (i != 0))
      {
        localLayoutParams.width = APMidasCommMethod.dip2px(this.activity, i);
        localLayoutParams.height = APMidasCommMethod.dip2px(this.activity, j);
        this.webView.getWebView().setLayoutParams(localLayoutParams);
      }
      AppMethodBeat.o(192863);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APSystemWebPage
 * JD-Core Version:    0.7.0.1
 */