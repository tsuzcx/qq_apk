package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import java.io.Serializable;
import java.util.HashMap;

public abstract class v8
  implements g9, Serializable
{
  public static final long serialVersionUID = 1L;
  public String a = "";
  public String b = y7.d;
  public HashMap<String, String> c = new HashMap();
  public boolean d = false;
  
  public v8()
  {
    c();
  }
  
  public void a(int paramInt, String paramString)
  {
    d();
  }
  
  public void a(Activity paramActivity, f8 paramf8, Bundle paramBundle) {}
  
  public void a(ProgressDialog paramProgressDialog) {}
  
  public void a(String paramString) {}
  
  public void a(Throwable paramThrowable) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    Object localObject1 = p4.p().e().f.e;
    this.c.put("reqFrom", y7.p);
    this.c.put("openId", p4.p().e().b.openId);
    this.c.put("openKey", p4.p().e().b.openKey);
    this.c.put("sessionId", p4.p().e().b.sessionId);
    this.c.put("sessionType", p4.p().e().b.sessionType);
    this.c.put("pf", p4.p().e().b.pf);
    this.c.put("pfKey", p4.p().e().b.pfKey);
    this.c.put("zoneId", p4.p().e().b.zoneId);
    this.c.put("offerId", p4.p().e().b.offerId);
    this.c.put("gameCoinName", APTools.b(p4.p().e().c.b, 1));
    this.c.put("recommendList", APTools.a(r7.e().c(), ","));
    this.c.put("minNumber", String.valueOf(p4.p().e().c.e));
    this.c.put("sdkVersion", "1.7.9a");
    this.c.put("sessionToken", p4.p().e().f.k);
    if (a.r().e()) {
      this.c.put("appId", c6.s0().b0());
    }
    if (!TextUtils.isEmpty(c6.s0().b0())) {
      this.c.put("appId", c6.s0().b0());
    }
    if (!TextUtils.isEmpty(c6.s0().d0())) {
      this.c.put("wxSignUrl", APTools.b(c6.s0().d0(), 1));
    }
    if (!TextUtils.isEmpty(c6.s0().e0())) {
      this.c.put("wxSignVersion", c6.s0().e0());
    }
    if (!TextUtils.isEmpty(c6.s0().c0())) {
      this.c.put("wxPreEntrustWebId", c6.s0().c0());
    }
    this.c.put("qqwalletSignUrl", APTools.b(c6.s0().I(), 1));
    this.c.put("uuid", APTools.b(c6.s0().Z(), 1));
    this.c.put("drm_resource", j6.e().b());
    this.c.put("payChannel", String.valueOf(r6.e((String)localObject1)));
    this.c.put("payChannelName", localObject1);
    if (((String)localObject1).equals("hfpay"))
    {
      if (((p4.p().e().b.saveType == 4) || (p4.p().e().b.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.w)))
      {
        localObject1 = APHFChannel.w;
        if ("0" != localObject1)
        {
          this.c.put("gameCoinRate", localObject1);
          break label702;
        }
      }
      if ((p4.p().e().b.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.v)))
      {
        localObject1 = APHFChannel.v;
        if ("0" != localObject1)
        {
          this.c.put("gameCoinRate", localObject1);
          break label702;
        }
      }
      this.c.put("gameCoinRate", p4.p().e().c.c);
    }
    else
    {
      this.c.put("gameCoinRate", p4.p().e().c.c);
    }
    label702:
    localObject1 = c6.s0().Q();
    if ("AndroidPay".equals(localObject1)) {
      this.c.put("entry", "game");
    } else if ("APPayGameListNumActivity".equals(localObject1)) {
      this.c.put("entry", "sdk");
    }
    this.c.put("hasMpTuan", x.f().e());
    if (p4.p().e().e.b) {
      this.c.put("firstCharge", "1");
    } else {
      this.c.put("firstCharge", "0");
    }
    this.c.put("saveNumber", p4.p().e().f.f);
    this.c.put("PortalExtendField", c6.s0().D());
    if (!c6.s0().z()) {
      this.c.put("notShowContinueBuy", "1");
    }
    int i = p4.p().e().b.saveType;
    Object localObject2;
    if (i == 4)
    {
      localObject2 = ((APMonthRequest)p4.p().e().b).serviceCode;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.c.put("serviceCode", localObject1);
      return;
    }
    if (i == 5)
    {
      localObject2 = ((APSubscribeRequest)p4.p().e().b).serviceCode;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = ((z4)p4.p().e().c).k;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      this.c.put("serviceCode", localObject1);
      this.c.put("productId", localObject2);
      return;
    }
    if (i == 1)
    {
      localObject2 = ((APGoodsRequest)p4.p().e().b).prodcutId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.c.put("productId", localObject1);
    }
  }
  
  public void b(String paramString)
  {
    d();
  }
  
  public void c()
  {
    String str = APAppDataInterface.singleton().h();
    if (str.equals("release"))
    {
      this.b = y7.e;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().f())))
      {
        this.b = y7.f;
        return;
      }
      if (str.equals("testing"))
      {
        this.b = y7.f;
        return;
      }
      this.b = y7.e;
      return;
    }
    this.b = y7.f;
  }
  
  public void c(String paramString) {}
  
  public void d()
  {
    this.d = true;
  }
  
  public void d(String paramString)
  {
    if (!this.d) {
      this.d = false;
    }
  }
  
  public abstract boolean e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.v8
 * JD-Core Version:    0.7.0.1
 */