package com.pay.ui.payWeb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout.LayoutParams;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import midas.x.a;
import midas.x.ec;
import midas.x.ed;
import midas.x.fp;
import midas.x.hj;
import midas.x.hk;
import midas.x.ho;

public class APX5WebRecordActivity
  extends APX5WebActivity
{
  public ho a = new ho()
  {
    public void a(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      APLog.i("APWebBuyActivity", "WebReceivedError");
    }
    
    public void a(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      APLog.i("APWebBuyActivity", "WebShouldUrlLoading");
      paramAnonymousWebView.goBack();
    }
    
    public void a(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      APLog.i("APWebBuyActivity", "WebPageStarted");
      paramAnonymousWebView.goBack();
    }
    
    public void b(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      APLog.i("APWebBuyActivity", "WebPageFinished");
    }
  };
  hk u = null;
  private int v = -1;
  
  private String l()
  {
    if (this.v == 1) {
      return hj.j;
    }
    if (this.v == 2) {
      return hj.k;
    }
    return "-1";
  }
  
  public void a()
  {
    setContentView(2131165268);
    this.d = ((WebView)findViewById(2131099770));
    this.e = ((AP3PointsLoading)findViewById(2131099699));
    this.e.b();
    this.d.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(20, 20, 20, 20);
    this.d.setLayoutParams(localLayoutParams);
  }
  
  public void c()
  {
    this.u = new hk();
    if (this.v == 1)
    {
      this.u.c = "sdk.feedback.show";
      this.u.d = "sdk.feedback.back";
    }
    else if (this.v == 2)
    {
      this.u.c = "sdk.traderecord.show";
      this.u.d = "sdk.traderecord.back";
    }
    this.u.n = this.a;
    this.u.a = hj.i;
    this.q = this.u;
  }
  
  protected void d()
  {
    this.q.p.put("reqFrom", hj.q);
    this.q.p.put("openId", ed.b().n().a.openId);
    this.q.p.put("openKey", ed.b().n().a.openKey);
    this.q.p.put("sessionId", ed.b().n().a.sessionId);
    this.q.p.put("sessionType", ed.b().n().a.sessionType);
    this.q.p.put("pf", ed.b().n().a.pf);
    this.q.p.put("pfKey", ed.b().n().a.pfKey);
    this.q.p.put("zoneId", ed.b().n().a.zoneId);
    this.q.p.put("offerId", ed.b().n().a.offerId);
    this.q.p.put("extend", fp.a().y());
    HashMap localHashMap = this.q.p;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ed.b().n().a.saveType);
    localStringBuilder.append("");
    localHashMap.put("saveType", localStringBuilder.toString());
  }
  
  protected void h()
  {
    String str = APAppDataInterface.singleton().e();
    if (str.equals("release"))
    {
      this.q.b = hj.d;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().k())))
      {
        this.q.b = hj.c;
        return;
      }
      this.q.b = hj.d;
      return;
    }
    this.q.b = hj.c;
  }
  
  protected String i()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(hj.a);
    ((StringBuilder)localObject1).append(this.q.b);
    ((StringBuilder)localObject1).append(this.q.a);
    ((StringBuilder)localObject1).append(l());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    if (((String)localObject2).contains("?"))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).endsWith("?"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("?");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = "";
    try
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&random=");
      ((StringBuilder)localObject3).append(String.valueOf(Math.random() * 100.0D));
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject2 = localObject3;
    }
    catch (Exception localException)
    {
      Object localObject3;
      label169:
      break label169;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(APTools.a(this.q.p));
    ((StringBuilder)localObject3).append((String)localObject2);
    return ((StringBuilder)localObject3).toString();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.a().f = true;
    this.v = getIntent().getIntExtra("callType", -1);
    j();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.d.canGoBack())
      {
        this.d.goBack();
        return true;
      }
      APDataReportManager.getInstance().insertData(this.u.d, ed.b().n().a.saveType);
      finish();
      APUICommonMethod.b(this);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APX5WebRecordActivity
 * JD-Core Version:    0.7.0.1
 */