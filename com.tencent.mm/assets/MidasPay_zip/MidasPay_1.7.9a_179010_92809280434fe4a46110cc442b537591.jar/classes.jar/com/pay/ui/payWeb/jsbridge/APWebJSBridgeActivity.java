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
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import midas.x.a;
import midas.x.c6;
import midas.x.e8;
import midas.x.g8;
import midas.x.i8;
import midas.x.k8;
import midas.x.o4;
import midas.x.r8;
import midas.x.s8;
import midas.x.u8;
import midas.x.y6;
import midas.x.y7;

public class APWebJSBridgeActivity
  extends APActivity
{
  public ProgressDialog d = null;
  public e8 e = null;
  public k8 f = null;
  public String g;
  public long h;
  public long i = 0L;
  public i8 j = new a();
  
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
  
  public final void a(Intent paramIntent, k8 paramk8)
  {
    if (paramIntent == null)
    {
      APLog.e("APWebJSBridgeActivity", "Cannot get risk control soft parameter, intent is null!");
      return;
    }
    if (paramk8 == null)
    {
      APLog.e("APWebJSBridgeActivity", "Cannot set risk control soft parameter, web page is null!");
      return;
    }
    paramIntent = (r8)paramIntent.getParcelableExtra("RiskControlSoftParam");
    if (paramIntent == null)
    {
      APLog.e("APWebJSBridgeActivity", "Get null risk control soft parameter!");
      return;
    }
    APLog.d("APWebJSBridgeActivity", "Get not null risk control soft parameter!");
    if ((paramk8 instanceof s8))
    {
      APLog.d("APWebJSBridgeActivity", "web page instanceof APWebRiskControlSoftPage!");
      ((s8)paramk8).a(paramIntent);
      getWindow().setSoftInputMode(16);
      return;
    }
    APLog.d("APWebJSBridgeActivity", "web page not instanceof APWebRiskControlSoftPage!");
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
    APLog.d("APWebJSBridgeActivity", "onCreate!");
    if ((c6.s0().i()) && (a.r().d != null)) {
      try
      {
        paramBundle = getIntent().getExtras();
        this.g = paramBundle.getString("pageName");
        this.f = g8.a(this.g);
        a(getIntent(), this.f);
        if (this.f == null) {
          return;
        }
        if (y7.u.equals(this.g))
        {
          String str = paramBundle.getString("signInfo");
          ((u8)this.f).e(str);
        }
        this.e = new e8(this, this.j);
        this.e.c(this.g);
        this.f.a(this, this.e, paramBundle);
        setContentView(this.e.a());
        f();
        this.f.a(this.d);
        return;
      }
      finally
      {
        APLog.e("initPage", paramBundle.toString());
        this.f.a(paramBundle);
        return;
      }
    }
    APLog.e("APWebJSBridgeActivity", "data is null");
  }
  
  public void onDestroy()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((e8)localObject).b();
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
    implements i8
  {
    public a() {}
    
    public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      paramWebView = new StringBuilder();
      paramWebView.append("WebViewClientReceivedError: ");
      paramWebView.append(paramInt);
      APLog.e("TAG", paramWebView.toString());
      if (!APWebJSBridgeActivity.this.isFinishing())
      {
        paramWebView = APWebJSBridgeActivity.this.d;
        if ((paramWebView != null) && (paramWebView.isShowing())) {
          APWebJSBridgeActivity.this.d.dismiss();
        }
      }
      APWebJSBridgeActivity.a(APWebJSBridgeActivity.this, paramInt, paramString1, paramString2);
    }
    
    public void a(WebView paramWebView, String paramString)
    {
      if (!APWebJSBridgeActivity.this.isFinishing())
      {
        paramWebView = APWebJSBridgeActivity.this.d;
        if ((paramWebView != null) && (paramWebView.isShowing())) {
          APWebJSBridgeActivity.this.d.dismiss();
        }
      }
      APWebJSBridgeActivity.b(APWebJSBridgeActivity.this, paramString);
      APLog.e("TAG", "WebViewClientPageFinished");
    }
    
    public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      APLog.e("TAG", "WebViewClientPageStarted");
      APWebJSBridgeActivity.a(APWebJSBridgeActivity.this, paramString);
      APWebJSBridgeActivity.c(APWebJSBridgeActivity.this, paramString);
    }
    
    public boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      APWebJSBridgeActivity.a(APWebJSBridgeActivity.this, paramString2);
      return true;
    }
    
    public boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      return true;
    }
    
    public void b(WebView paramWebView, String paramString)
    {
      APWebJSBridgeActivity.a(APWebJSBridgeActivity.this).c(paramString);
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
      APDataReportManager.getInstance().insertData("sdk.web.common.error.page.back", APWebJSBridgeActivity.b(APWebJSBridgeActivity.this).b.saveType);
      if ((APWebJSBridgeActivity.a(APWebJSBridgeActivity.this) != null) && (!APWebJSBridgeActivity.a(APWebJSBridgeActivity.this).e()))
      {
        APWebJSBridgeActivity.this.finish();
        APUICommonMethod.a(APWebJSBridgeActivity.this);
      }
    }
  }
  
  public class d
    implements View.OnClickListener
  {
    public d(String paramString) {}
    
    public void onClick(View paramView)
    {
      APDataReportManager.getInstance().insertData("sdk.web.common.error.page.refresh", APWebJSBridgeActivity.c(APWebJSBridgeActivity.this).b.saveType);
      paramView = APWebJSBridgeActivity.this;
      if (paramView.e != null)
      {
        if (paramView.d == null) {
          APWebJSBridgeActivity.d(paramView);
        }
        APWebJSBridgeActivity.this.d.show();
        APWebJSBridgeActivity.this.e.e().loadUrl(paramString);
        paramView = APWebJSBridgeActivity.this;
        paramView.setContentView(paramView.e.d());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.jsbridge.APWebJSBridgeActivity
 * JD-Core Version:    0.7.0.1
 */