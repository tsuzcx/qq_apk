package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
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

public abstract class ig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected String a = "";
  protected String b = "";
  protected String c = hj.d;
  protected HashMap<String, String> d = new HashMap();
  protected boolean e = false;
  
  public ig()
  {
    c();
  }
  
  public void a(int paramInt, String paramString)
  {
    e();
  }
  
  public void a(Activity paramActivity, hq paramhq) {}
  
  public void a(ProgressDialog paramProgressDialog) {}
  
  public void a(String paramString) {}
  
  public void a(Throwable paramThrowable) {}
  
  public abstract boolean a();
  
  public String b()
  {
    return null;
  }
  
  public void b(String paramString) {}
  
  protected void c()
  {
    String str = APAppDataInterface.singleton().e();
    if (str.equals("release"))
    {
      this.c = hj.e;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().k())))
      {
        this.c = hj.f;
        return;
      }
      if (str.equals("testing"))
      {
        this.c = hj.f;
        return;
      }
      this.c = hj.e;
      return;
    }
    this.c = hj.f;
  }
  
  public void c(String paramString)
  {
    if (!this.e) {
      this.e = false;
    }
  }
  
  protected void d()
  {
    Object localObject1 = ed.b().n().e.f;
    this.d.put("reqFrom", hj.q);
    this.d.put("openId", ed.b().n().a.openId);
    this.d.put("openKey", ed.b().n().a.openKey);
    this.d.put("sessionId", ed.b().n().a.sessionId);
    this.d.put("sessionType", ed.b().n().a.sessionType);
    this.d.put("pf", ed.b().n().a.pf);
    this.d.put("pfKey", ed.b().n().a.pfKey);
    this.d.put("zoneId", ed.b().n().a.zoneId);
    this.d.put("offerId", ed.b().n().a.offerId);
    this.d.put("gameCoinName", APTools.a(ed.b().n().b.b, 1));
    this.d.put("recommendList", APTools.a(hc.a().b(), ","));
    this.d.put("minNumber", String.valueOf(ed.b().n().b.h));
    this.d.put("sdkVersion", "1.7.1f");
    this.d.put("sessionToken", ed.b().n().e.l);
    if (a.a().j()) {
      this.d.put("appId", fp.a().N());
    }
    if (!TextUtils.isEmpty(fp.a().N())) {
      this.d.put("appId", fp.a().N());
    }
    if (!TextUtils.isEmpty(fp.a().O())) {
      this.d.put("wxSignUrl", APTools.a(fp.a().O(), 1));
    }
    if (!TextUtils.isEmpty(fp.a().M())) {
      this.d.put("wxSignVersion", fp.a().M());
    }
    if (!TextUtils.isEmpty(fp.a().P())) {
      this.d.put("wxPreEntrustWebId", fp.a().P());
    }
    this.d.put("qqwalletSignUrl", APTools.a(fp.a().ah(), 1));
    this.d.put("uuid", APTools.a(fp.a().i(), 1));
    this.d.put("drm_resource", fv.b().e());
    this.d.put("payChannel", String.valueOf(gd.a((String)localObject1)));
    this.d.put("payChannelName", localObject1);
    if (((String)localObject1).equals("hfpay"))
    {
      if (((ed.b().n().a.saveType == 4) || (ed.b().n().a.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.o)) && ("0" != APHFChannel.o)) {
        this.d.put("gameCoinRate", APHFChannel.o);
      } else if ((ed.b().n().a.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.n)) && ("0" != APHFChannel.n)) {
        this.d.put("gameCoinRate", APHFChannel.n);
      } else {
        this.d.put("gameCoinRate", ed.b().n().b.e);
      }
    }
    else {
      this.d.put("gameCoinRate", ed.b().n().b.e);
    }
    localObject1 = fp.a().g();
    if ("AndroidPay".equals(localObject1)) {
      this.d.put("entry", "game");
    } else if ("APPayGameListNumActivity".equals(localObject1)) {
      this.d.put("entry", "sdk");
    }
    this.d.put("hasMpTuan", w.a().d());
    if (ed.b().n().d.b) {
      this.d.put("firstCharge", "1");
    } else {
      this.d.put("firstCharge", "0");
    }
    this.d.put("saveNumber", ed.b().n().e.g);
    this.d.put("PortalExtendField", fp.a().L());
    if (!fp.a().B()) {
      this.d.put("notShowContinueBuy", "1");
    }
    int i = ed.b().n().a.saveType;
    Object localObject2;
    if (i == 4)
    {
      localObject2 = ((APMonthRequest)ed.b().n().a).serviceCode;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.d.put("serviceCode", localObject1);
      return;
    }
    if (i == 5)
    {
      localObject2 = ((APSubscribeRequest)ed.b().n().a).serviceCode;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = ((APSubscribeRequest)ed.b().n().a).productId;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      this.d.put("serviceCode", localObject1);
      this.d.put("productId", localObject2);
      return;
    }
    if (i == 1)
    {
      localObject2 = ((APGoodsRequest)ed.b().n().a).prodcutId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.d.put("productId", localObject1);
    }
  }
  
  public void d(String paramString)
  {
    e();
  }
  
  protected void e()
  {
    this.e = true;
  }
  
  public boolean f()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ig
 * JD-Core Version:    0.7.0.1
 */