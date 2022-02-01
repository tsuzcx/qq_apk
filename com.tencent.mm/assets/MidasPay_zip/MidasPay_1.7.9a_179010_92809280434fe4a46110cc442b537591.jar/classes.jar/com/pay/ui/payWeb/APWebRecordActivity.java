package com.pay.ui.payWeb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.AP3PointsLoading;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.HashMap;
import midas.x.a;
import midas.x.b8;
import midas.x.c6;
import midas.x.o4;
import midas.x.p4;
import midas.x.x7;
import midas.x.y7;

public class APWebRecordActivity
  extends APWebActivity
{
  public b8 k = new a();
  public x7 l = null;
  public int m = -1;
  
  public void g()
  {
    this.f.n.put("reqFrom", y7.p);
    this.f.n.put("openId", p4.p().e().b.openId);
    this.f.n.put("openKey", p4.p().e().b.openKey);
    this.f.n.put("sessionId", p4.p().e().b.sessionId);
    this.f.n.put("sessionType", p4.p().e().b.sessionType);
    this.f.n.put("pf", p4.p().e().b.pf);
    this.f.n.put("pfKey", p4.p().e().b.pfKey);
    this.f.n.put("zoneId", p4.p().e().b.zoneId);
    this.f.n.put("offerId", p4.p().e().b.offerId);
    this.f.n.put("extend", c6.s0().e());
    HashMap localHashMap = this.f.n;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(p4.p().e().b.saveType);
    localStringBuilder.append("");
    localHashMap.put("saveType", localStringBuilder.toString());
  }
  
  public String h()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(y7.a);
    ((StringBuilder)localObject1).append(this.f.b);
    ((StringBuilder)localObject1).append(this.f.a);
    ((StringBuilder)localObject1).append(o());
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
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&random=");
      ((StringBuilder)localObject2).append(String.valueOf(Math.random() * 100.0D));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    catch (Exception localException)
    {
      label167:
      StringBuilder localStringBuilder;
      break label167;
    }
    localObject2 = "";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(APTools.a(this.f.n));
    localStringBuilder.append((String)localObject2);
    return localStringBuilder.toString();
  }
  
  public void i()
  {
    String str = APAppDataInterface.singleton().h();
    if (str.equals("release"))
    {
      this.f.b = y7.d;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().f())))
      {
        this.f.b = y7.c;
        return;
      }
      this.f.b = y7.d;
      return;
    }
    this.f.b = y7.c;
  }
  
  public void j()
  {
    this.l = new x7();
    int i = this.m;
    if (i == 1)
    {
      localx7 = this.l;
      localx7.c = "sdk.feedback.show";
      localx7.d = "sdk.feedback.back";
    }
    else if (i == 2)
    {
      localx7 = this.l;
      localx7.c = "sdk.traderecord.show";
      localx7.d = "sdk.traderecord.back";
    }
    x7 localx7 = this.l;
    localx7.l = this.k;
    localx7.a = y7.i;
    this.f = localx7;
  }
  
  public void k()
  {
    setContentView(2131165265);
    this.d = ((WebView)findViewById(2131099770));
    this.e = ((AP3PointsLoading)findViewById(2131099699));
    this.e.c();
    this.d.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(20, 20, 20, 20);
    this.d.setLayoutParams(localLayoutParams);
  }
  
  public final String o()
  {
    int i = this.m;
    if (i == 1) {
      return y7.j;
    }
    if (i == 2) {
      return y7.k;
    }
    return "-1";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.r().f = true;
    this.m = getIntent().getIntExtra("callType", -1);
    n();
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
      APDataReportManager.getInstance().insertData(this.l.d, p4.p().e().b.saveType);
      finish();
      APUICommonMethod.a(this);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public class a
    implements b8
  {
    public a() {}
    
    public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      APLog.i("APWebBuyActivity", "WebReceivedError");
    }
    
    public void a(WebView paramWebView, String paramString)
    {
      APLog.i("APWebBuyActivity", "WebPageFinished");
    }
    
    public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      APLog.i("APWebBuyActivity", "WebPageStarted");
      paramWebView.goBack();
    }
    
    public void b(WebView paramWebView, String paramString)
    {
      APLog.i("APWebBuyActivity", "WebShouldUrlLoading");
      paramWebView.goBack();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APWebRecordActivity
 * JD-Core Version:    0.7.0.1
 */