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
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView;
import midas.x.a;
import midas.x.el;
import midas.x.fy;
import midas.x.gu;
import midas.x.hu;
import midas.x.ib;
import midas.x.ic;
import midas.x.if;
import midas.x.in;
import midas.x.ir;
import midas.x.iy;
import midas.x.ja;

public class APX5WebJSBridgeActivity
  extends APActivity
{
  protected ProgressDialog a = null;
  protected ib b = null;
  private final int c = 0;
  private final int d = -2;
  private final int e = -100;
  private ir q = null;
  private String r;
  private long s;
  private long t = 0L;
  private if u = new if()
  {
    public void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      paramAnonymousWebView = new StringBuilder();
      paramAnonymousWebView.append("WebViewClientReceivedError: ");
      paramAnonymousWebView.append(paramAnonymousInt);
      APLog.e("TAG", paramAnonymousWebView.toString());
      if ((!APX5WebJSBridgeActivity.this.isFinishing()) && (APX5WebJSBridgeActivity.this.a != null) && (APX5WebJSBridgeActivity.this.a.isShowing())) {
        APX5WebJSBridgeActivity.this.a.dismiss();
      }
      APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
    }
    
    public void a(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if ((!APX5WebJSBridgeActivity.this.isFinishing()) && (APX5WebJSBridgeActivity.this.a != null) && (APX5WebJSBridgeActivity.this.a.isShowing())) {
        APX5WebJSBridgeActivity.this.a.dismiss();
      }
      APX5WebJSBridgeActivity.b(APX5WebJSBridgeActivity.this, paramAnonymousString);
      APLog.e("TAG", "WebViewClientPageFinished");
    }
    
    public void a(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      APLog.e("TAG", "WebViewClientPageStarted");
      APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this, paramAnonymousString);
      APX5WebJSBridgeActivity.c(APX5WebJSBridgeActivity.this, paramAnonymousString);
    }
    
    public boolean a(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this, paramAnonymousString2);
      return true;
    }
    
    public boolean a(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
    {
      return true;
    }
    
    public void b(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this).b(paramAnonymousString);
    }
  };
  
  private void a()
  {
    this.a = new gu(this);
    this.a.setMessage("请稍候...");
    this.a.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (this.q.f())
      {
        this.q.a(paramInt, paramString1);
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
  
  private void a(Intent paramIntent, ir paramir)
  {
    if (paramIntent == null)
    {
      APLog.e("APX5WebJSBridgeActivity", "Cannot get risk control soft parameter, intent is null!");
      return;
    }
    if (paramir == null)
    {
      APLog.e("APX5WebJSBridgeActivity", "Cannot set risk control soft parameter, web page is null!");
      return;
    }
    paramIntent = (in)paramIntent.getParcelableExtra("RiskControlSoftParam");
    if (paramIntent == null)
    {
      APLog.e("APX5WebJSBridgeActivity", "Get null risk control soft parameter!");
      return;
    }
    APLog.d("APX5WebJSBridgeActivity", "Get not null risk control soft parameter!");
    if ((paramir instanceof iy))
    {
      APLog.d("APX5WebJSBridgeActivity", "web page instanceof APWebRiskControlSoftPage!");
      ((iy)paramir).a(paramIntent);
      getWindow().setSoftInputMode(16);
      return;
    }
    APLog.d("APX5WebJSBridgeActivity", "web page not instanceof APWebRiskControlSoftPage!");
  }
  
  private void a(String paramString)
  {
    try
    {
      this.q.a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(String paramString)
  {
    try
    {
      this.q.c(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      this.q.d(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void d(final String paramString)
  {
    if (this.b != null)
    {
      View localView = LayoutInflater.from(this).inflate(2131165213, null);
      setContentView(localView);
      APDataReportManager.getInstance().insertData("sdk.web.common.error.page.show", this.p.a.saveType);
      localView.findViewById(2131099664).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          APDataReportManager.getInstance().insertData("sdk.web.common.error.page.back", APX5WebJSBridgeActivity.b(APX5WebJSBridgeActivity.this).a.saveType);
          if ((APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this) != null) && (!APX5WebJSBridgeActivity.a(APX5WebJSBridgeActivity.this).a()))
          {
            APX5WebJSBridgeActivity.this.finish();
            APUICommonMethod.b(APX5WebJSBridgeActivity.this);
          }
        }
      });
      localView.findViewById(2131099665).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          APDataReportManager.getInstance().insertData("sdk.web.common.error.page.refresh", APX5WebJSBridgeActivity.c(APX5WebJSBridgeActivity.this).a.saveType);
          if (APX5WebJSBridgeActivity.this.b != null)
          {
            if (APX5WebJSBridgeActivity.this.a == null) {
              APX5WebJSBridgeActivity.d(APX5WebJSBridgeActivity.this);
            }
            APX5WebJSBridgeActivity.this.a.show();
            APX5WebJSBridgeActivity.this.b.c().loadUrl(paramString);
            APX5WebJSBridgeActivity.this.setContentView(APX5WebJSBridgeActivity.this.b.g());
          }
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    APLog.d("APX5WebJSBridgeActivity", "onCreate!");
    if ((fy.a().f()) && (a.a().d != null)) {
      try
      {
        paramBundle = getIntent().getExtras();
        this.r = paramBundle.getString("pageName");
        this.q = ic.b(this.r);
        a(getIntent(), this.q);
        if (this.q == null) {
          return;
        }
        if (hu.w.equals(this.r))
        {
          String str = paramBundle.getString("signInfo");
          ((ja)this.q).e(str);
        }
        this.b = new ib(this, this.u);
        this.b.a(this.r);
        this.q.a(this, this.b, paramBundle);
        setContentView(this.b.a());
        a();
        this.q.a(this.a);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        APLog.e("initPage", paramBundle.toString());
        this.q.a(paramBundle);
        return;
      }
    }
    APLog.e("APX5WebJSBridgeActivity", "data is null");
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      this.b.f();
    }
    if (this.a != null) {
      this.a.dismiss();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.q != null) && (!this.q.a()))
      {
        paramKeyEvent = APDataReportManager.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(hu.ab);
        localStringBuilder.append(this.r);
        paramKeyEvent.insertData(localStringBuilder.toString(), this.p.a.saveType);
        finish();
        APUICommonMethod.b(this);
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
      this.t = System.currentTimeMillis();
      long l1 = this.t;
      long l2 = this.s;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("time=");
      ((StringBuilder)localObject).append(l1 - l2);
      localObject = ((StringBuilder)localObject).toString();
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hu.aa);
      localStringBuilder.append(this.r);
      localAPDataReportManager.insertData(localStringBuilder.toString(), this.p.a.saveType, null, null, (String)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.s = System.currentTimeMillis();
      APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hu.Z);
      localStringBuilder.append(this.r);
      localAPDataReportManager.insertData(localStringBuilder.toString(), this.p.a.saveType, null, null, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.jsbridge.APX5WebJSBridgeActivity
 * JD-Core Version:    0.7.0.1
 */