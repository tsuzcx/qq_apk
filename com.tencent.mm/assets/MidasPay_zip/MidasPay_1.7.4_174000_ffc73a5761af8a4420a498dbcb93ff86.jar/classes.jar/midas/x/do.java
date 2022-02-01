package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class do
  extends bx
{
  public int a = 0;
  String b = "";
  String c = "";
  
  public do(String paramString)
  {
    this(paramString, 0);
  }
  
  public do(String paramString, int paramInt)
  {
    this.a = paramInt;
    if ("normal".equals(paramString))
    {
      this.b = fy.a().i();
      this.c = "";
    }
    else if ("portal".equals(paramString))
    {
      this.b = "";
      if ((em.b().n().e != null) && (!TextUtils.isEmpty(em.b().n().e.p))) {
        this.c = em.b().n().e.p;
      }
    }
    paramString = String.format("/v1/r/%s/get_pay_result", new Object[] { em.b().n().a.offerId });
    if (paramInt == 1)
    {
      this.k = 0;
      String str = bz.c();
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
    e("offer_id", em.b().f());
    fy localfy = fy.a();
    el localel = em.b().n();
    e("openid", localel.a.openId);
    e("openkey", localel.a.openKey);
    e("session_id", localel.a.sessionId);
    e("session_type", localel.a.sessionType);
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    if (!TextUtils.isEmpty(this.b)) {
      e("uuid", this.b);
    }
    if (!TextUtils.isEmpty(this.c)) {
      e("portal_serial_no", this.c);
    }
    e("zoneid", localel.a.zoneId);
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfy.y());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.do
 * JD-Core Version:    0.7.0.1
 */