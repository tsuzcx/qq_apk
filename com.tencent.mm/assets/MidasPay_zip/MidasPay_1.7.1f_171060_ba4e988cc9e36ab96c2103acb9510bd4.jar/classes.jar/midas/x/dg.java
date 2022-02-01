package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class dg
  extends br
{
  public int a = 0;
  String b = "";
  String c = "";
  
  public dg(String paramString)
  {
    this(paramString, 0);
  }
  
  public dg(String paramString, int paramInt)
  {
    this.a = paramInt;
    if ("normal".equals(paramString))
    {
      this.b = fp.a().i();
      this.c = "";
    }
    else if ("portal".equals(paramString))
    {
      this.b = "";
      if ((ed.b().n().e != null) && (!TextUtils.isEmpty(ed.b().n().e.p))) {
        this.c = ed.b().n().e.p;
      }
    }
    paramString = String.format("/v1/r/%s/get_pay_result", new Object[] { ed.b().n().a.offerId });
    if (paramInt == 1)
    {
      this.k = 0;
      String str = bt.c();
      this.u = false;
      a(str, "https", paramString, "442");
    }
    else
    {
      a("https", paramString, "442");
    }
    c();
  }
  
  public boolean a()
  {
    return this.a != 1;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return this.a != 1;
  }
  
  public void c()
  {
    e("offer_id", ed.b().f());
    fp localfp = fp.a();
    ec localec = ed.b().n();
    e("openid", localec.a.openId);
    e("openkey", localec.a.openKey);
    e("session_id", localec.a.sessionId);
    e("session_type", localec.a.sessionType);
    e("pf", localec.a.pf);
    e("pfkey", localec.a.pfKey);
    if (!TextUtils.isEmpty(this.b)) {
      e("uuid", this.b);
    }
    if (!TextUtils.isEmpty(this.c)) {
      e("portal_serial_no", this.c);
    }
    e("zoneid", localec.a.zoneId);
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfp.y());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dg
 * JD-Core Version:    0.7.0.1
 */