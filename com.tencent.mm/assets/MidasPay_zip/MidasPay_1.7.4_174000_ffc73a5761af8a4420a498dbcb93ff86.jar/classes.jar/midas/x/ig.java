package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APDataReportManager;
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
  protected String c = hu.d;
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
  
  public void a(Activity paramActivity, ia paramia, Bundle paramBundle) {}
  
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
      this.c = hu.e;
      return;
    }
    if ((!str.equals("test")) && (!str.equals("dev")))
    {
      if ((str.equals("custom")) && ("dev".equals(APAppDataInterface.singleton().k())))
      {
        this.c = hu.f;
        return;
      }
      if (str.equals("testing"))
      {
        this.c = hu.f;
        return;
      }
      this.c = hu.e;
      return;
    }
    this.c = hu.f;
  }
  
  public void c(String paramString)
  {
    if (!this.e) {
      this.e = false;
    }
  }
  
  protected void d()
  {
    try
    {
      Object localObject1 = em.b().n().e.f;
      this.d.put("reqFrom", hu.q);
      this.d.put("openId", em.b().n().a.openId);
      this.d.put("openKey", em.b().n().a.openKey);
      this.d.put("sessionId", em.b().n().a.sessionId);
      this.d.put("sessionType", em.b().n().a.sessionType);
      this.d.put("pf", em.b().n().a.pf);
      this.d.put("pfKey", em.b().n().a.pfKey);
      this.d.put("zoneId", em.b().n().a.zoneId);
      this.d.put("offerId", em.b().n().a.offerId);
      this.d.put("gameCoinName", APTools.a(em.b().n().b.b, 1));
      this.d.put("recommendList", APTools.a(hn.a().b(), ","));
      this.d.put("minNumber", String.valueOf(em.b().n().b.h));
      this.d.put("sdkVersion", "1.7.4");
      this.d.put("sessionToken", em.b().n().e.l);
      if (a.a().j()) {
        this.d.put("appId", fy.a().N());
      }
      if (!TextUtils.isEmpty(fy.a().N())) {
        this.d.put("appId", fy.a().N());
      }
      if (!TextUtils.isEmpty(fy.a().O())) {
        this.d.put("wxSignUrl", APTools.a(fy.a().O(), 1));
      }
      if (!TextUtils.isEmpty(fy.a().M())) {
        this.d.put("wxSignVersion", fy.a().M());
      }
      if (!TextUtils.isEmpty(fy.a().P())) {
        this.d.put("wxPreEntrustWebId", fy.a().P());
      }
      this.d.put("qqwalletSignUrl", APTools.a(fy.a().ah(), 1));
      this.d.put("uuid", APTools.a(fy.a().i(), 1));
      this.d.put("drm_resource", gf.b().e());
      this.d.put("payChannel", String.valueOf(gn.a((String)localObject1)));
      this.d.put("payChannelName", localObject1);
      if (((String)localObject1).equals("hfpay"))
      {
        if (((em.b().n().a.saveType == 4) || (em.b().n().a.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.p)) && ("0" != APHFChannel.p)) {
          this.d.put("gameCoinRate", APHFChannel.p);
        } else if ((em.b().n().a.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.o)) && ("0" != APHFChannel.o)) {
          this.d.put("gameCoinRate", APHFChannel.o);
        } else {
          this.d.put("gameCoinRate", em.b().n().b.e);
        }
      }
      else {
        this.d.put("gameCoinRate", em.b().n().b.e);
      }
      if (((String)localObject1).equals("hfpay"))
      {
        if (((em.b().n().a.saveType == 4) || (em.b().n().a.saveType == 5)) && (!TextUtils.isEmpty(APHFChannel.p)) && ("0" != APHFChannel.p)) {
          this.d.put("gameCoinRate", APHFChannel.p);
        } else if ((em.b().n().a.saveType == 0) && (!TextUtils.isEmpty(APHFChannel.o)) && ("0" != APHFChannel.o)) {
          this.d.put("gameCoinRate", APHFChannel.o);
        } else {
          this.d.put("gameCoinRate", em.b().n().b.e);
        }
      }
      else {
        this.d.put("gameCoinRate", em.b().n().b.e);
      }
      localObject1 = fy.a().g();
      if ("AndroidPay".equals(localObject1)) {
        this.d.put("entry", "game");
      } else if ("APPayGameListNumActivity".equals(localObject1)) {
        this.d.put("entry", "sdk");
      }
      this.d.put("hasMpTuan", w.a().d());
      if (em.b().n().d.b) {
        this.d.put("firstCharge", "1");
      } else {
        this.d.put("firstCharge", "0");
      }
      this.d.put("saveNumber", em.b().n().e.g);
      this.d.put("PortalExtendField", fy.a().L());
      if (!fy.a().B()) {
        this.d.put("notShowContinueBuy", "1");
      }
      int i = em.b().n().a.saveType;
      if (i == 4)
      {
        localObject2 = ((APMonthRequest)em.b().n().a).serviceCode;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        this.d.put("serviceCode", localObject1);
        return;
      }
      if (i == 5)
      {
        localObject2 = ((APSubscribeRequest)em.b().n().a).serviceCode;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = ((ew)em.b().n().b).k;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        this.d.put("serviceCode", localObject1);
        this.d.put("productId", localObject2);
        return;
      }
      if (i == 1)
      {
        localObject2 = ((APGoodsRequest)em.b().n().a).prodcutId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        this.d.put("productId", localObject1);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      Object localObject2 = APDataReportManager.getInstance();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("APWebBasePage_setCommonParams_");
      ((StringBuilder)localObject3).append(APTools.d(localThrowable));
      ((APDataReportManager)localObject2).a("sdk.err.view", ((StringBuilder)localObject3).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ig
 * JD-Core Version:    0.7.0.1
 */