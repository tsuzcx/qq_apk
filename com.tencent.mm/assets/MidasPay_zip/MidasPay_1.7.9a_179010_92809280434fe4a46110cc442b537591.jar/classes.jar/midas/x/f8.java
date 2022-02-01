package midas.x;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APUICommonMethod;
import com.pay.ui.payWeb.jsbridge.APX5RoundedWebView;
import com.tencent.midas.comm.APLog;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class f8
{
  public AP3PointsLoading a = null;
  public RelativeLayout b = null;
  public APX5RoundedWebView c = null;
  public Activity d = null;
  public j8 e = null;
  public String f = "";
  public LinearLayout g = null;
  public LinearLayout h = null;
  public View i = null;
  public int j;
  public int k = 0;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public WebChromeClient o = new a();
  public WebViewClient p = new b();
  
  public f8(Activity paramActivity, j8 paramj8)
  {
    this.d = paramActivity;
    this.e = paramj8;
  }
  
  public View a()
  {
    LayoutInflater localLayoutInflater = this.d.getLayoutInflater();
    if (y7.u.equals(this.f))
    {
      this.i = localLayoutInflater.inflate(2131165223, null);
      this.n = 0;
    }
    else if (y7.z.equals(this.f))
    {
      this.i = localLayoutInflater.inflate(2131165268, null);
      this.g = ((LinearLayout)this.i.findViewById(2131100026));
      this.h = ((LinearLayout)this.i.findViewById(2131100028));
      this.n = 12;
    }
    else if (y7.B.equals(this.f))
    {
      this.i = localLayoutInflater.inflate(2131165268, null);
      this.g = ((LinearLayout)this.i.findViewById(2131100026));
      this.h = ((LinearLayout)this.i.findViewById(2131100028));
      this.n = 12;
    }
    else
    {
      this.i = localLayoutInflater.inflate(2131165269, null);
      this.n = 15;
    }
    this.b = ((RelativeLayout)this.i.findViewById(2131100027));
    this.c = ((APX5RoundedWebView)this.i.findViewById(2131099770));
    this.a = ((AP3PointsLoading)this.i.findViewById(2131099699));
    this.c.setShouldBeRounded(this.n);
    j();
    g();
    return this.i;
  }
  
  public final void a(int paramInt)
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
  
  public final void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message: ");
    localStringBuilder.append(paramString);
    APLog.d("calculateAndUpdate", localStringBuilder.toString());
    try
    {
      paramString = new JSONObject(paramString.substring(9));
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
        if ((i1 == -2) || (i1 == -1)) {}
      }
      else
      {
        if (i1 >= 0)
        {
          i2 = this.m;
          if (i1 <= i2)
          {
            i1 = i2;
            break label171;
          }
        }
        i2 = this.l;
        if (i1 > i2) {
          i1 = i2;
        }
      }
      label171:
      a(i1);
      return;
    }
    catch (JSONException paramString)
    {
      APLog.d("calculateAndUpdate", "JSONException error");
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      localObject = new JSONTokener(paramString2).nextValue();
      if (localObject != null)
      {
        if ((localObject instanceof JSONObject)) {
          break label158;
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
    label158:
    for (int i1 = 0;; i1 = 1) {
      if (i1 == 0) {}
    }
  }
  
  public void b()
  {
    APX5RoundedWebView localAPX5RoundedWebView = this.c;
    if (localAPX5RoundedWebView != null)
    {
      ((ViewGroup)localAPX5RoundedWebView.getParent()).removeView(this.c);
      this.c.destroy();
      this.c = null;
    }
  }
  
  public void b(String paramString)
  {
    d(paramString);
    this.c.loadUrl(paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    APLog.i("updateWebSize", "========");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("w:　");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" h: ");
    ((StringBuilder)localObject).append(paramString2);
    APLog.i("updateWebSize", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if ((localObject != null) && ((((WebView)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams)))
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
    APLog.i("updateWebSize", "========");
  }
  
  public LinearLayout c()
  {
    return this.g;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public View d()
  {
    return this.i;
  }
  
  public final void d(String paramString)
  {
    Object localObject = this.c;
    if ((localObject != null) && ((((WebView)localObject).getLayoutParams() instanceof RelativeLayout.LayoutParams)))
    {
      localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      APLog.i("updateWebSize == ", paramString);
      String str = APTools.b(paramString, "mpwidth");
      if (!TextUtils.isEmpty(str)) {
        this.j = Integer.valueOf(str).intValue();
      }
      paramString = APTools.b(paramString, "mpheight");
      if (!TextUtils.isEmpty(paramString)) {
        this.k = Integer.valueOf(paramString).intValue();
      }
      if (this.k != 0)
      {
        int i1 = this.j;
        if (i1 != 0)
        {
          ((RelativeLayout.LayoutParams)localObject).width = APUICommonMethod.a(this.d, i1);
          ((RelativeLayout.LayoutParams)localObject).height = APUICommonMethod.a(this.d, this.k);
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public WebView e()
  {
    return this.c;
  }
  
  public ViewGroup f()
  {
    return this.h;
  }
  
  @SuppressLint({"NewApi"})
  public final void g()
  {
    WebSettings localWebSettings = this.c.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    if ((Build.VERSION.SDK_INT >= 19) && ((APAppDataInterface.singleton().h().equals("test")) || (APAppDataInterface.singleton().h().equals("dev")))) {
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
    h();
  }
  
  public final void h()
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
  
  public void i()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((AP3PointsLoading)localObject).d();
      this.a.setVisibility(8);
    }
    localObject = this.h;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(0);
    }
    localObject = this.c;
    if (localObject != null) {
      ((WebView)localObject).setVisibility(0);
    }
  }
  
  public final void j()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(4);
    }
    localObject = this.c;
    if (localObject != null) {
      ((WebView)localObject).setVisibility(4);
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).setVisibility(0);
      this.a.c();
    }
  }
  
  public class a
    extends WebChromeClient
  {
    public a() {}
    
    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      APLog.i("inner onJsAlert message", paramString2);
      APLog.i("inner onJsAlert mContext", f8.a(f8.this).toString());
      if (j.a(f8.a(f8.this), paramString1, paramString2) == 0)
      {
        APLog.i("inner onJsAlert h5PayHook", paramString2);
        paramJsResult.cancel();
        return true;
      }
      if ((!paramString2.startsWith("http://unipay.sdk.android/?")) && (!paramString2.startsWith("https://unipay.sdk.android/?")))
      {
        if (paramString2.startsWith("wsj://"))
        {
          f8.b(f8.this).a(paramWebView, paramString1, paramString2, paramJsResult);
          paramJsResult.cancel();
          return true;
        }
        if (paramString2.startsWith("midas://"))
        {
          f8.b(f8.this).a(paramWebView, paramString1, paramString2, paramJsResult);
          paramJsResult.cancel();
          return true;
        }
        if (paramString2.startsWith("layout://"))
        {
          f8.a(f8.this, paramString2);
          paramJsResult.cancel();
          return true;
        }
        if (paramString2.startsWith("rcs://"))
        {
          APLog.d("APInnerX5WebView", "enter rcs protocol!");
          f8.b(f8.this).a(paramWebView, paramString1, paramString2, paramJsResult);
          paramJsResult.cancel();
          return true;
        }
        return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
      }
      APLog.i("inner onJsAlert h5PayHook", paramString2);
      f8.b(f8.this).a(paramWebView, paramString1, paramString2, paramJsResult);
      paramJsResult.cancel();
      return true;
    }
    
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      return f8.b(f8.this).a(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      if ((paramString != null) && (!paramString.contains("html")) && (!paramString.contains("?"))) {
        f8.b(f8.this).b(paramWebView, paramString);
      }
    }
  }
  
  public class b
    extends WebViewClient
  {
    public b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      APLog.i("APWebView url == ", paramString);
      f8.this.i();
      APX5RoundedWebView localAPX5RoundedWebView = f8.c(f8.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append(j.a);
      localAPX5RoundedWebView.loadUrl(localStringBuilder.toString());
      f8.b(f8.this).a(paramWebView, paramString);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("=onPageStart url = ");
      localStringBuilder.append(paramString);
      APLog.d("APInnerX5WebView", localStringBuilder.toString());
      if ((paramString.startsWith("http://unipay.sdk.android/?")) || (paramString.startsWith("https://unipay.sdk.android/?"))) {
        paramWebView.stopLoading();
      }
      f8.b(f8.this).a(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode:");
      localStringBuilder.append(paramInt);
      APLog.e("onReceivedError", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("description:");
      localStringBuilder.append(paramString1);
      APLog.e("onReceivedError", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("failingUrl:");
      localStringBuilder.append(paramString2);
      APLog.e("onReceivedError", localStringBuilder.toString());
      if (!paramString2.startsWith("http://unipay.sdk.android/?"))
      {
        if (paramString2.startsWith("https://unipay.sdk.android/?")) {
          return;
        }
        if (f8.b(f8.this) != null) {
          f8.b(f8.this).a(paramWebView, paramInt, paramString1, paramString2);
        }
      }
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      paramWebView = new StringBuilder();
      paramWebView.append("getPrimaryError：");
      paramWebView.append(paramSslError.getPrimaryError());
      APLog.i("onReceivedSslError", paramWebView.toString());
      if (5 == paramSslError.getPrimaryError())
      {
        paramSslErrorHandler.proceed();
        return;
      }
      paramSslErrorHandler.cancel();
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("shouldOverrideUrlLoading url = ");
      localStringBuilder1.append(paramString);
      APLog.d("APInnerX5WebView", localStringBuilder1.toString());
      if ((paramString != null) && ((paramString.startsWith("mqqapi://")) || (paramString.startsWith("weixin://")) || (paramString.startsWith("sms:")))) {
        try
        {
          paramWebView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
          return true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          localActivityNotFoundException.printStackTrace();
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("activity not found: ");
          localStringBuilder2.append(paramString);
          APLog.e("shouldOverrideUrlLoading", localStringBuilder2.toString());
          APUICommonMethod.a(paramWebView.getContext(), "抱歉，你未安装相应客户端");
          return true;
        }
      }
      if ((!paramString.startsWith("http://unipay.sdk.android/?")) && (!paramString.startsWith("https://unipay.sdk.android/?")) && (!paramString.startsWith("wsj://")))
      {
        APLog.d("APInnerX5WebView", "shouldOverrideUrlLoading return false");
        return false;
      }
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.f8
 * JD-Core Version:    0.7.0.1
 */