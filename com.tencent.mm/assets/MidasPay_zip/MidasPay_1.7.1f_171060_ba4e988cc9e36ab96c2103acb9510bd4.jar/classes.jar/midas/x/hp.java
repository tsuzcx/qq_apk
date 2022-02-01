package midas.x;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APRoundedWebView;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class hp
{
  protected AP3PointsLoading a = null;
  private RelativeLayout b = null;
  private APRoundedWebView c = null;
  private Activity d = null;
  private ht e = null;
  private String f = "";
  private LinearLayout g = null;
  private LinearLayout h = null;
  private View i = null;
  private int j;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private WebChromeClient o = new WebChromeClient()
  {
    public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      APLog.i("inner onJsAlert message", paramAnonymousString2);
      APLog.i("inner onJsAlert mContext", hp.a(hp.this).toString());
      if (j.a(hp.a(hp.this), paramAnonymousString1, paramAnonymousString2) == 0)
      {
        APLog.i("inner onJsAlert h5PayHook", paramAnonymousString2);
        paramAnonymousJsResult.cancel();
        return true;
      }
      if ((!paramAnonymousString2.startsWith("http://unipay.sdk.android/?")) && (!paramAnonymousString2.startsWith("https://unipay.sdk.android/?")))
      {
        if (paramAnonymousString2.startsWith("wsj://"))
        {
          hp.b(hp.this).a(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
          paramAnonymousJsResult.cancel();
          return true;
        }
        if (paramAnonymousString2.startsWith("midas://"))
        {
          hp.b(hp.this).a(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
          paramAnonymousJsResult.cancel();
          return true;
        }
        if (paramAnonymousString2.startsWith("layout://"))
        {
          hp.a(hp.this, paramAnonymousString2);
          paramAnonymousJsResult.cancel();
          return true;
        }
        if (paramAnonymousString2.startsWith("rcs://"))
        {
          APLog.d("APInnerWebView", "enter rcs protocol!");
          hp.b(hp.this).a(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
          paramAnonymousJsResult.cancel();
          return true;
        }
        return super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
      }
      APLog.i("inner onJsAlert h5PayHook", paramAnonymousString2);
      hp.b(hp.this).a(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
      paramAnonymousJsResult.cancel();
      return true;
    }
    
    public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
    {
      return hp.b(hp.this).a(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousJsPromptResult);
    }
    
    public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      super.onReceivedTitle(paramAnonymousWebView, paramAnonymousString);
      if ((paramAnonymousString != null) && (!paramAnonymousString.contains("html")) && (!paramAnonymousString.contains("?"))) {
        hp.b(hp.this).b(paramAnonymousWebView, paramAnonymousString);
      }
    }
  };
  private WebViewClient p = new WebViewClient()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      APLog.i("APWebView url == ", paramAnonymousString);
      hp.this.e();
      if (hp.c(hp.this) != null)
      {
        APRoundedWebView localAPRoundedWebView = hp.c(hp.this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:");
        localStringBuilder.append(j.a);
        localAPRoundedWebView.loadUrl(localStringBuilder.toString());
      }
      if (hp.b(hp.this) != null) {
        hp.b(hp.this).a(paramAnonymousWebView, paramAnonymousString);
      }
    }
    
    public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("=onPageStart url = ");
      localStringBuilder.append(paramAnonymousString);
      APLog.d("APInnerWebView", localStringBuilder.toString());
      if ((paramAnonymousString.startsWith("http://unipay.sdk.android/?")) || (paramAnonymousString.startsWith("https://unipay.sdk.android/?"))) {
        paramAnonymousWebView.stopLoading();
      }
      if (hp.b(hp.this) != null) {
        hp.b(hp.this).a(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      }
    }
    
    public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode:");
      localStringBuilder.append(paramAnonymousInt);
      APLog.i("onReceivedError", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("description:");
      localStringBuilder.append(paramAnonymousString1);
      APLog.i("onReceivedError", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failingUrl:");
      localStringBuilder.append(paramAnonymousString2);
      APLog.i("onReceivedError", localStringBuilder.toString());
      if (!paramAnonymousString2.startsWith("http://unipay.sdk.android/?"))
      {
        if (paramAnonymousString2.startsWith("https://unipay.sdk.android/?")) {
          return;
        }
        if (hp.b(hp.this) != null) {
          hp.b(hp.this).a(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        }
        return;
      }
    }
    
    public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
    {
      paramAnonymousWebView = new StringBuilder();
      paramAnonymousWebView.append("getPrimaryError：");
      paramAnonymousWebView.append(paramAnonymousSslError.getPrimaryError());
      APLog.i("onReceivedSslError", paramAnonymousWebView.toString());
      if (5 == paramAnonymousSslError.getPrimaryError())
      {
        paramAnonymousSslErrorHandler.proceed();
        return;
      }
      paramAnonymousSslErrorHandler.cancel();
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("shouldOverrideUrlLoading url = ");
      localStringBuilder1.append(paramAnonymousString);
      APLog.d("APInnerWebView", localStringBuilder1.toString());
      if ((paramAnonymousString != null) && ((paramAnonymousString.startsWith("mqqapi://")) || (paramAnonymousString.startsWith("weixin://")) || (paramAnonymousString.startsWith("sms:")))) {
        try
        {
          paramAnonymousWebView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString)));
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          localActivityNotFoundException.printStackTrace();
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("activity not found: ");
          localStringBuilder2.append(paramAnonymousString);
          APLog.e("shouldOverrideUrlLoading", localStringBuilder2.toString());
          APUICommonMethod.a(paramAnonymousWebView.getContext(), "抱歉，你未安装相应客户端");
          return false;
        }
      }
      if ((!paramAnonymousString.startsWith("http://unipay.sdk.android/?")) && (!paramAnonymousString.startsWith("https://unipay.sdk.android/?")) && (!paramAnonymousString.startsWith("wsj://")))
      {
        APLog.d("APInnerWebView", "shouldOverrideUrlLoading return false");
        return false;
      }
      return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
    }
  };
  
  public hp(Activity paramActivity, ht paramht)
  {
    this.d = paramActivity;
    this.e = paramht;
  }
  
  private void a(int paramInt)
  {
    int i1 = APUICommonMethod.a(this.d, 20.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, paramInt);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(15, -1);
    if (paramInt != -1) {
      localLayoutParams.setMargins(i1, i1, i1, i1);
    }
    this.c.setLayoutParams(localLayoutParams);
    if (paramInt == -2) {
      this.c.setMinimumHeight(this.m);
    }
  }
  
  private void c(String paramString)
  {
    if ((this.c != null) && ((this.c.getLayoutParams() instanceof RelativeLayout.LayoutParams)))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      APLog.i("updateWebSize == ", paramString);
      String str = APTools.a(paramString, "mpwidth");
      if (!TextUtils.isEmpty(str)) {
        this.j = Integer.valueOf(str).intValue();
      }
      paramString = APTools.a(paramString, "mpheight");
      if (!TextUtils.isEmpty(paramString)) {
        this.k = Integer.valueOf(paramString).intValue();
      }
      if ((this.k != 0) && (this.j != 0))
      {
        localLayoutParams.width = APUICommonMethod.a(this.d, this.j);
        localLayoutParams.height = APUICommonMethod.a(this.d, this.k);
        this.c.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message: ");
    localStringBuilder.append(paramString);
    APLog.d("calculateAndUpdate", localStringBuilder.toString());
    try
    {
      paramString = new JSONObject(paramString.substring("layout://".length()));
      int i2 = paramString.optInt("height", -2);
      if (this.l == 0) {
        this.l = (this.b.getHeight() - APUICommonMethod.a(this.d, 40.0F));
      }
      if (this.m == 0) {
        this.m = APUICommonMethod.a(this.d, 80.0F);
      }
      int i1 = i2;
      if (i2 > 0) {
        i1 = APUICommonMethod.a(this.d, i2);
      }
      if (i1 < 0)
      {
        i2 = i1;
        if (i1 != -2)
        {
          i2 = i1;
          if (i1 == -1) {}
        }
      }
      else if ((i1 >= 0) && (i1 <= this.m))
      {
        i2 = this.m;
      }
      else
      {
        i2 = i1;
        if (i1 > this.l) {
          i2 = this.l;
        }
      }
      a(i2);
      return;
    }
    catch (JSONException paramString)
    {
      APLog.d("calculateAndUpdate", "JSONException error");
      paramString.printStackTrace();
    }
  }
  
  @SuppressLint({"NewApi"})
  private void h()
  {
    WebSettings localWebSettings = this.c.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    if ((Build.VERSION.SDK_INT >= 19) && ((APAppDataInterface.singleton().e().equals("test")) || (APAppDataInterface.singleton().e().equals("dev")))) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCachePath(this.d.getApplicationContext().getDir("cache", 0).getPath());
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setAppCacheEnabled(false);
    localWebSettings.setCacheMode(2);
    localWebSettings.setSavePassword(false);
    this.c.setScrollBarStyle(0);
    this.c.setWebChromeClient(this.o);
    this.c.setWebViewClient(this.p);
    i();
  }
  
  private void i()
  {
    try
    {
      Method localMethod = this.c.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
      if (localMethod != null)
      {
        localMethod.invoke(this.c, new Object[] { "searchBoxJavaBridge_" });
        localMethod.invoke(this.c, new Object[] { "accessibility" });
        localMethod.invoke(this.c, new Object[] { "accessibilityTraversal" });
        return;
      }
    }
    catch (Exception localException)
    {
      APLog.i("removeJavascriptInterface", localException.toString());
    }
  }
  
  private void j()
  {
    if (this.h != null) {
      this.h.setVisibility(4);
    }
    if (this.c != null) {
      this.c.setVisibility(4);
    }
    if (this.a != null)
    {
      this.a.setVisibility(0);
      this.a.b();
    }
  }
  
  public View a()
  {
    LayoutInflater localLayoutInflater = this.d.getLayoutInflater();
    if (hj.w.equals(this.f))
    {
      this.i = localLayoutInflater.inflate(2131165222, null);
      this.n = 0;
    }
    else if (hj.C.equals(this.f))
    {
      this.i = localLayoutInflater.inflate(2131165266, null);
      this.g = ((LinearLayout)this.i.findViewById(2131100026));
      this.h = ((LinearLayout)this.i.findViewById(2131100028));
      this.n = 12;
    }
    else if (hj.F.equals(this.f))
    {
      this.i = localLayoutInflater.inflate(2131165266, null);
      this.g = ((LinearLayout)this.i.findViewById(2131100026));
      this.h = ((LinearLayout)this.i.findViewById(2131100028));
      this.n = 12;
    }
    else
    {
      this.i = localLayoutInflater.inflate(2131165264, null);
      this.n = 15;
    }
    this.b = ((RelativeLayout)this.i.findViewById(2131100027));
    this.c = ((APRoundedWebView)this.i.findViewById(2131099770));
    this.a = ((AP3PointsLoading)this.i.findViewById(2131099699));
    this.c.setShouldBeRounded(this.n);
    j();
    h();
    return this.i;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      localObject = new JSONTokener(paramString2).nextValue();
      if (localObject != null)
      {
        if ((localObject instanceof JSONObject)) {
          break label163;
        }
        boolean bool = localObject instanceof JSONArray;
        if (!bool) {}
      }
    }
    catch (JSONException|Exception localJSONException)
    {
      for (;;)
      {
        try
        {
          paramString2 = String.format("typeof window[\"%s\"]==='function' && window[\"%s\"](%s);", new Object[] { paramString1, paramString1, paramString2 });
          continue;
          paramString2 = String.format("typeof window[\"%s\"]==='function' && window[\"%s\"](\"%s\");", new Object[] { paramString1, paramString1, paramString2 });
          APLog.i("callback", paramString1);
          APLog.i("cb", paramString2);
          paramString1 = this.c;
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("javascript:");
          ((StringBuilder)localObject).append(paramString2);
          paramString1.loadUrl(((StringBuilder)localObject).toString());
          return;
        }
        catch (Exception paramString1)
        {
          return;
        }
        localJSONException = localJSONException;
      }
    }
    label163:
    for (int i1 = 0;; i1 = 1) {
      if (i1 == 0) {}
    }
  }
  
  public ViewGroup b()
  {
    return this.h;
  }
  
  public void b(String paramString)
  {
    c(paramString);
    this.c.loadUrl(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    APLog.i("updateWebSize", "==================");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("w:　");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" h: ");
    ((StringBuilder)localObject).append(paramString2);
    APLog.i("updateWebSize", ((StringBuilder)localObject).toString());
    if ((this.c != null) && ((this.c.getLayoutParams() instanceof RelativeLayout.LayoutParams)))
    {
      localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      int i1;
      if (!TextUtils.isEmpty(paramString1))
      {
        i1 = Integer.valueOf(paramString1).intValue();
        paramString1 = new StringBuilder();
        paramString1.append("width: ");
        paramString1.append(i1);
        APLog.i("updateWebSize", paramString1.toString());
        ((RelativeLayout.LayoutParams)localObject).width = APUICommonMethod.a(this.d, i1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        i1 = Integer.valueOf(paramString2).intValue();
        paramString1 = new StringBuilder();
        paramString1.append("height: ");
        paramString1.append(i1);
        APLog.i("updateWebSize", paramString1.toString());
        ((RelativeLayout.LayoutParams)localObject).height = APUICommonMethod.a(this.d, i1);
      }
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    APLog.i("updateWebSize", "==================");
  }
  
  public WebView c()
  {
    return this.c;
  }
  
  public LinearLayout d()
  {
    return this.g;
  }
  
  public void e()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a.setVisibility(8);
    }
    if (this.h != null) {
      this.h.setVisibility(0);
    }
    if (this.c != null) {
      this.c.setVisibility(0);
    }
  }
  
  public void f()
  {
    if (this.c != null)
    {
      ((ViewGroup)this.c.getParent()).removeView(this.c);
      this.c.destroy();
      this.c = null;
    }
  }
  
  public View g()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.hp
 * JD-Core Version:    0.7.0.1
 */