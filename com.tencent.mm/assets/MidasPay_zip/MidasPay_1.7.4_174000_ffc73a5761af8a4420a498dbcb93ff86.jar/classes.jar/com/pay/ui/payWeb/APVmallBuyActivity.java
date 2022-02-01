package com.pay.ui.payWeb;

import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import java.util.HashMap;
import midas.x.a;
import midas.x.el;
import midas.x.em;
import midas.x.fa;
import midas.x.fv;
import midas.x.hs.a;
import midas.x.ht;
import midas.x.hu;
import midas.x.hw;
import org.json.JSONException;
import org.json.JSONObject;

public class APVmallBuyActivity
  extends APWebActivity
  implements hs.a
{
  hw a = new hw()
  {
    public void a(WebView paramAnonymousWebView)
    {
      APUICommonMethod.b();
      fv.a(2, "支付关闭");
    }
    
    public void a(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
    {
      paramAnonymousWebView = paramAnonymousString2.toString();
      if (paramAnonymousWebView.startsWith("http://unipay.sdk.android/?")) {
        APVmallBuyActivity.this.a(paramAnonymousWebView);
      }
      paramAnonymousJsResult.cancel();
    }
    
    public void a(WebView paramAnonymousWebView, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, Message paramAnonymousMessage) {}
  };
  private String u;
  private boolean v;
  private String w;
  
  private String l()
  {
    return hu.h;
  }
  
  public void a()
  {
    setContentView(2131165265);
    this.d = ((WebView)findViewById(2131099770));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(20, 20, 20, 20);
    this.d.setLayoutParams(localLayoutParams);
  }
  
  public void a(String paramString)
  {
    new HashMap();
    paramString = APTools.b(paramString);
    String str1 = (String)paramString.get("page");
    String str2 = (String)paramString.get("action");
    String str3 = (String)paramString.get("goodsInfo");
    String str4 = (String)paramString.get("err");
    this.u = ((String)paramString.get("callback"));
    if ("mall".equals(str1))
    {
      if ("pay".equals(str2))
      {
        b(str3);
        return;
      }
      if ("load".equals(str2))
      {
        if ("relogin".equals(str4))
        {
          a.a("登录过期，请重新登录", this);
          return;
        }
        APUICommonMethod.a(this, "加载失败");
      }
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("productid");
      APDataReportManager.getInstance().insertData(this.q.g, 1, str, null, null, null);
      paramString.getString("itemnum");
      paramString.getString("goodsmeta");
      paramString.getString("discountid");
      paramString.getString("pay_method");
      paramString.getString("zoneid");
      paramString.getString("gameid");
      paramString.getString("goodsid");
      paramString.getString("provide_uin");
      paramString.getString("appmode");
      paramString.getString("game_platform_id");
      this.w = str;
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b_()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{\"ret\":0,\"productid\":\"");
    ((StringBuilder)localObject).append(this.w);
    ((StringBuilder)localObject).append("\"}");
    localObject = ((StringBuilder)localObject).toString();
    this.v = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:");
    localStringBuilder.append(this.u);
    localStringBuilder.append("('");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("')");
    localObject = localStringBuilder.toString();
    this.d.loadUrl((String)localObject);
  }
  
  public void c()
  {
    ht localht = new ht();
    localht.o = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hu.g);
    localStringBuilder.append(em.b().n().a.offerId);
    localht.a = localStringBuilder.toString();
    localht.c = "sdk.vmall.h5.show";
    localht.g = "sdk.vmall.h5.pay";
    localht.d = "sdk.vmall.h5.close";
    localht.j = "sdk.vmall.h5.keyback";
    this.q = localht;
  }
  
  protected void d()
  {
    this.q.p.put("reqFrom", hu.q);
    this.q.p.put("openId", em.b().n().a.openId);
    this.q.p.put("openKey", em.b().n().a.openKey);
    this.q.p.put("sessionId", em.b().n().a.sessionId);
    this.q.p.put("sessionType", em.b().n().a.sessionType);
    this.q.p.put("pf", em.b().n().a.pf);
    this.q.p.put("pfKey", em.b().n().a.pfKey);
    this.q.p.put("zoneId", em.b().n().a.zoneId);
    this.q.p.put("offerId", em.b().n().a.offerId);
  }
  
  protected void h()
  {
    String str = APAppDataInterface.singleton().e();
    if (str.equals("release"))
    {
      this.q.b = hu.e;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().k())))
      {
        this.q.b = hu.c;
        return;
      }
      this.q.b = hu.e;
      return;
    }
    this.q.b = hu.c;
  }
  
  protected String i()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(hu.a);
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
      label175:
      break label175;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(APTools.a(this.q.p));
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = APAppDataInterface.singleton().e();
    if (!((String)localObject3).equals("test"))
    {
      localObject1 = localObject2;
      if (!((String)localObject3).equals("dev")) {}
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&sandbox=1");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.a().f = true;
    j();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.d.canGoBack())
      {
        APDataReportManager.getInstance().insertData(this.q.j, this.f);
        this.d.goBack();
        return true;
      }
      APDataReportManager.getInstance().insertData(this.q.d, this.f);
      if (this.v)
      {
        APUICommonMethod.b();
        fv.a(em.b().n().e.a(), 0, -1);
      }
      else
      {
        APUICommonMethod.b();
        fv.a(2, "支付取消");
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData(this.q.c, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APVmallBuyActivity
 * JD-Core Version:    0.7.0.1
 */