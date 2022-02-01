package com.pay.ui.payWeb.jsbridge;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView;
import midas.x.a;
import midas.x.c6;
import midas.x.c9;
import midas.x.e9;
import midas.x.f8;
import midas.x.g8;
import midas.x.j8;
import midas.x.o4;
import midas.x.r8;
import midas.x.v8;
import midas.x.y6;
import midas.x.y7;

public class APX5WebJSBridgeActivity
  extends APActivity
{
  public ProgressDialog d = null;
  public f8 e = null;
  public v8 f = null;
  public String g;
  public long h;
  public long i = 0L;
  public j8 j = new a();
  
  public final void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (this.f.a())
      {
        this.f.a(paramInt, paramString1);
        return;
      }
      d(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public final void a(Intent paramIntent, v8 paramv8)
  {
    if (paramIntent == null)
    {
      APLog.e("APX5WebJSBridgeActivity", "Cannot get risk control soft parameter, intent is null!");
      return;
    }
    if (paramv8 == null)
    {
      APLog.e("APX5WebJSBridgeActivity", "Cannot set risk control soft parameter, web page is null!");
      return;
    }
    r8 localr8 = (r8)paramIntent.getParcelableExtra("RiskControlSoftParam");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AFAIP1 = ");
    localStringBuilder.append(paramIntent.getExtras().toString());
    APLog.e("APX5WebJSBridgeActivity", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("AFAIP2 = ");
    localStringBuilder.append(paramIntent.getClass().getClassLoader());
    APLog.e("APX5WebJSBridgeActivity", localStringBuilder.toString());
    if (localr8 == null)
    {
      APLog.e("APX5WebJSBridgeActivity", "Get null risk control soft parameter!");
      return;
    }
    APLog.d("APX5WebJSBridgeActivity", "Get not null risk control soft parameter!");
    if ((paramv8 instanceof c9))
    {
      APLog.d("APX5WebJSBridgeActivity", "web page instanceof APWebRiskControlSoftPage!");
      ((c9)paramv8).a(localr8);
      getWindow().setSoftInputMode(16);
      return;
    }
    APLog.d("APX5WebJSBridgeActivity", "web page not instanceof APWebRiskControlSoftPage!");
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.f.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      this.f.b(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final void c(String paramString)
  {
    try
    {
      this.f.d(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final void d(final String paramString)
  {
    if (this.e != null)
    {
      View localView = LayoutInflater.from(this).inflate(2131165213, null);
      setContentView(localView);
      APDataReportManager.getInstance().insertData("sdk.web.common.error.page.show", this.c.b.saveType);
      localView.findViewById(2131099664).setOnClickListener(new c());
      localView.findViewById(2131099665).setOnClickListener(new d(paramString));
    }
  }
  
  public final void f()
  {
    this.d = new y6(this);
    this.d.setMessage("请稍候...");
    this.d.setOnCancelListener(new b());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    APLog.d("APX5WebJSBridgeActivity", "onCreate!");
    if ((c6.s0().i()) && (a.r().d != null)) {
      try
      {
        paramBundle = getIntent().getExtras();
        this.g = paramBundle.getString("pageName");
        this.f = g8.b(this.g);
        a(getIntent(), this.f);
        if (this.f == null) {
          return;
        }
        if (y7.u.equals(this.g))
        {
          String str = paramBundle.getString("signInfo");
          ((e9)this.f).e(str);
        }
        this.e = new f8(this, this.j);
        this.e.c(this.g);
        this.f.a(this, this.e, paramBundle);
        setContentView(this.e.a());
        f();
        this.f.a(this.d);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        APLog.e("initPage", paramBundle.toString());
        this.f.a(paramBundle);
        return;
      }
    }
    APLog.e("APX5WebJSBridgeActivity", "data is null");
  }
  
  public void onDestroy()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((f8)localObject).b();
    }
    localObject = this.d;
    if (localObject != null) {
      ((ProgressDialog)localObject).dismiss();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = this.f;
      if ((paramKeyEvent != null) && (!paramKeyEvent.e()))
      {
        paramKeyEvent = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(y7.T);
        localStringBuilder.append(this.g);
        paramKeyEvent.insertData(localStringBuilder.toString(), this.c.b.saveType);
        finish();
        APUICommonMethod.a(this);
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.i = System.currentTimeMillis();
      long l1 = this.i;
      long l2 = this.h;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("time=");
      ((StringBuilder)localObject).append(l1 - l2);
      localObject = ((StringBuilder)localObject).toString();
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(y7.S);
      localStringBuilder.append(this.g);
      localAPDataReportManager.insertData(localStringBuilder.toString(), this.c.b.saveType, null, null, (String)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.h = System.currentTimeMillis();
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(y7.R);
      localStringBuilder.append(this.g);
      localAPDataReportManager.insertData(localStringBuilder.toString(), this.c.b.saveType, null, null, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public class a
    implements j8
  {
    public a() {}
    
    public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      paramWebView = new StringBuilder();
      paramWebView.append("WebViewClientReceivedError: ");
      paramWebView.append(paramInt);
      APLog.e("TAG", paramWebView.toString());
      if (!APX5WebJSBridgeActivity.this.isFinishing())
      {
        paramWebView = APX5WebJSBridgeActivity.this.d;
        if ((paramWebView != null) && (paramWebView.isShowing())) {
          APX5WebJSBridgeActivity.this.d.dismiss();
        }
      }
      APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this, paramInt, paramString1, paramString2);
    }
    
    public void a(WebView paramWebView, String paramString)
    {
      if (!APX5WebJSBridgeActivity.this.isFinishing())
      {
        paramWebView = APX5WebJSBridgeActivity.this.d;
        if ((paramWebView != null) && (paramWebView.isShowing())) {
          APX5WebJSBridgeActivity.this.d.dismiss();
        }
      }
      APX5WebJSBridgeActivity.b(APX5WebJSBridgeActivity.this, paramString);
      APLog.e("TAG", "WebViewClientPageFinished");
    }
    
    public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      APLog.e("TAG", "WebViewClientPageStarted");
      APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this, paramString);
      APX5WebJSBridgeActivity.c(APX5WebJSBridgeActivity.this, paramString);
    }
    
    public boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this, paramString2);
      return true;
    }
    
    public boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      return true;
    }
    
    public void b(WebView paramWebView, String paramString)
    {
      APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this).c(paramString);
    }
  }
  
  public class b
    implements DialogInterface.OnCancelListener
  {
    public b() {}
    
    public void onCancel(DialogInterface paramDialogInterface) {}
  }
  
  public class c
    implements View.OnClickListener
  {
    public c() {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.web.common.error.page.back", APX5WebJSBridgeActivity.b(APX5WebJSBridgeActivity.this).b.saveType);
      if ((APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this) != null) && (!APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this).e()))
      {
        APX5WebJSBridgeActivity.this.finish();
        APUICommonMethod.a(APX5WebJSBridgeActivity.this);
      }
    }
  }
  
  public class d
    implements View.OnClickListener
  {
    public d(String paramString) {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.web.common.error.page.refresh", APX5WebJSBridgeActivity.c(APX5WebJSBridgeActivity.this).b.saveType);
      paramView = APX5WebJSBridgeActivity.this;
      if (paramView.e != null)
      {
        if (paramView.d == null) {
          APX5WebJSBridgeActivity.d(paramView);
        }
        APX5WebJSBridgeActivity.this.d.show();
        APX5WebJSBridgeActivity.this.e.e().loadUrl(paramString);
        paramView = APX5WebJSBridgeActivity.this;
        paramView.setContentView(paramView.e.d());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity
 * JD-Core Version:    0.7.0.1
 */