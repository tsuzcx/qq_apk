package midas.x;

import android.text.TextUtils;
import com.pay.api.ability.MidasActivityAbility;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;

public class cb
  extends bx
{
  private MidasActivityAbility a;
  
  public cb(MidasActivityAbility paramMidasActivityAbility)
  {
    this.a = paramMidasActivityAbility;
    a("https", String.format("/v1/r/%s/activity_mall_launch_front", new Object[] { em.b().n().a.offerId }), "442");
    b();
  }
  
  public void b()
  {
    e("offer_id", this.a.offerId);
    e("openid", this.a.openId);
    e("pf", this.a.pf);
    e("pfkey", this.a.pfKey);
    e("action", this.a.action);
    e("roleid", this.a.roleId);
    e("rolename", this.a.roleName);
    e("format", "json");
    e("sdkversion", fv.c());
    e("xg_mid", APAppDataInterface.singleton().l());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", this.a.offerId);
    }
    f("offer_id", this.a.offerId);
    f("openid", this.a.openId);
    f("openkey", this.a.openKey);
    f("session_id", this.a.sessionId);
    f("session_type", this.a.sessionType);
    f("payitem", this.a.payItem);
    f("platid", this.a.platId);
    f("area", this.a.area);
    f("partition", this.a.partition);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.a.sceneInfo))
    {
      localStringBuilder.append(this.a.sceneInfo);
      localStringBuilder.append("&");
    }
    if (!TextUtils.isEmpty(this.a.others))
    {
      localStringBuilder.append(this.a.others);
      localStringBuilder.append("&");
    }
    if (localStringBuilder.length() > 0) {
      f("extend", APTools.a(localStringBuilder.substring(0, localStringBuilder.length() - 1), 1));
    }
    if (!APAppDataInterface.singleton().e().equals("release"))
    {
      if (APAppDataInterface.singleton().z()) {
        f("encrypt_rsp", "1");
      }
    }
    else {
      f("encrypt_rsp", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cb
 * JD-Core Version:    0.7.0.1
 */