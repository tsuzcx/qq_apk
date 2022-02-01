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
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.plugin.APPluginActivity;
import java.util.HashMap;
import midas.x.a;
import midas.x.a8;
import midas.x.d5;
import midas.x.o4;
import midas.x.p4;
import midas.x.w7.a;
import midas.x.x7;
import midas.x.y7;
import midas.x.z5;
import org.json.JSONException;
import org.json.JSONObject;

public class APVmallBuyActivity
  extends APWebActivity
  implements w7.a
{
  public String k;
  public boolean l;
  public String m;
  public a8 n = new a();
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{\"ret\":0,\"productid\":\"");
    ((StringBuilder)localObject).append(this.m);
    ((StringBuilder)localObject).append("\"}");
    localObject = ((StringBuilder)localObject).toString();
    this.l = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("('");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("')");
    localObject = localStringBuilder.toString();
    this.d.loadUrl((String)localObject);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("productid");
      APDataReportManager.getInstance().insertData(this.f.f, 1, str, null, null, null);
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
      this.m = str;
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    new HashMap();
    paramString = APTools.n(paramString);
    String str1 = (String)paramString.get("page");
    String str2 = (String)paramString.get("action");
    String str3 = (String)paramString.get("goodsInfo");
    String str4 = (String)paramString.get("err");
    this.k = ((String)paramString.get("callback"));
    if ("mall".equals(str1))
    {
      if ("pay".equals(str2))
      {
        a(str3);
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
      label168:
      Object localObject3;
      break label168;
    }
    localObject2 = "";
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(APTools.a(this.f.n));
    ((StringBuilder)localObject3).append((String)localObject2);
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = APAppDataInterface.singleton().h();
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
  
  public void i()
  {
    String str = APAppDataInterface.singleton().h();
    if (str.equals("release"))
    {
      this.f.b = y7.e;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().f())))
      {
        this.f.b = y7.c;
        return;
      }
      this.f.b = y7.e;
      return;
    }
    this.f.b = y7.c;
  }
  
  public void j()
  {
    x7 localx7 = new x7();
    localx7.m = this.n;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(y7.g);
    localStringBuilder.append(p4.p().e().b.offerId);
    localx7.a = localStringBuilder.toString();
    localx7.c = "sdk.vmall.h5.show";
    localx7.f = "sdk.vmall.h5.pay";
    localx7.d = "sdk.vmall.h5.close";
    localx7.i = "sdk.vmall.h5.keyback";
    this.f = localx7;
  }
  
  public void k()
  {
    setContentView(2131165265);
    this.d = ((WebView)findViewById(2131099770));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(20, 20, 20, 20);
    this.d.setLayoutParams(localLayoutParams);
  }
  
  public final String o()
  {
    return y7.h;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.r().f = true;
    n();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.d.canGoBack())
      {
        APDataReportManager.getInstance().insertData(this.f.i, this.a);
        this.d.goBack();
        return true;
      }
      APDataReportManager.getInstance().insertData(this.f.d, this.a);
      if (this.l)
      {
        APUICommonMethod.f();
        z5.a(p4.p().e().f.a(), 0, -1);
      }
      else
      {
        APUICommonMethod.f();
        z5.a(2, "支付取消");
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    APDataReportManager.getInstance().insertData(this.f.c, this.a);
  }
  
  public class a
    implements a8
  {
    public a() {}
    
    public void a(WebView paramWebView)
    {
      APUICommonMethod.f();
      z5.a(2, "支付关闭");
    }
    
    public void a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      paramWebView = paramString2.toString();
      if (paramWebView.startsWith("http://unipay.sdk.android/?")) {
        APVmallBuyActivity.this.b(paramWebView);
      }
      paramJsResult.cancel();
    }
    
    public void a(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.ui.payWeb.APVmallBuyActivity
 * JD-Core Version:    0.7.0.1
 */