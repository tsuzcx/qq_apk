package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class cf
  extends br
{
  public cf()
  {
    String str1 = String.format("/v1/r/%s/get_ip_list", new Object[] { ed.b().n().a.offerId });
    String str2 = bt.c();
    this.i = 3;
    a(str2, "https", str1, "443");
    b();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void b()
  {
    fp localfp = fp.a();
    e("offer_id", ed.b().f());
    ec localec = ed.b().n();
    if (localec != null)
    {
      e("openid", localec.a.openId);
      e("openkey", localec.a.openKey);
      e("session_id", localec.a.sessionId);
      e("session_type", localec.a.sessionType);
      e("pf", localec.a.pf);
      e("pfkey", localec.a.pfKey);
      e("format", "json");
      e("session_token", localec.e.l);
    }
    e("extend", localfp.y());
    e("sdkversion", fm.c());
    e("xg_mid", APAppDataInterface.singleton().l());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cf
 * JD-Core Version:    0.7.0.1
 */