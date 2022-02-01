package midas.x;

import android.text.TextUtils;
import com.pay.api.ability.MidasActivityAbility;
import com.pay.api.ability.MidasBaseAbility;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;

public class c2
  extends y1
{
  public MidasActivityAbility A;
  
  public c2(MidasActivityAbility paramMidasActivityAbility)
  {
    this.A = paramMidasActivityAbility;
    a("https", String.format("/v1/r/%s/activity_mall_launch_front", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    b("offer_id", this.A.offerId);
    b("openid", this.A.openId);
    b("pf", this.A.pf);
    b("pfkey", this.A.pfKey);
    b("action", this.A.action);
    b("roleid", this.A.roleId);
    b("rolename", this.A.roleName);
    b("format", "json");
    b("sdkversion", z5.c());
    b("xg_mid", APAppDataInterface.singleton().C());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", this.A.offerId);
    }
    e("offer_id", this.A.offerId);
    e("openid", this.A.openId);
    e("openkey", this.A.openKey);
    e("session_id", this.A.sessionId);
    e("session_type", this.A.sessionType);
    e("payitem", this.A.payItem);
    e("platid", this.A.platId);
    e("area", this.A.area);
    e("partition", this.A.partition);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.A.sceneInfo))
    {
      localStringBuilder.append(this.A.sceneInfo);
      localStringBuilder.append("&");
    }
    if (!TextUtils.isEmpty(this.A.others))
    {
      localStringBuilder.append(this.A.others);
      localStringBuilder.append("&");
    }
    if (localStringBuilder.length() > 0) {
      e("extend", APTools.b(localStringBuilder.substring(0, localStringBuilder.length() - 1), 1));
    }
    if (!APAppDataInterface.singleton().h().equals("release"))
    {
      if (APAppDataInterface.singleton().F()) {
        e("encrypt_rsp", "1");
      }
    }
    else {
      e("encrypt_rsp", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.c2
 * JD-Core Version:    0.7.0.1
 */