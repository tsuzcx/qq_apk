package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class r3
  extends y1
{
  public int A = 0;
  public String B = "";
  public String C = "";
  
  public r3(String paramString)
  {
    this(paramString, 0);
  }
  
  public r3(String paramString, int paramInt)
  {
    this.A = paramInt;
    if ("normal".equals(paramString))
    {
      this.B = c6.s0().Z();
      this.C = "";
    }
    else if ("portal".equals(paramString))
    {
      this.B = "";
      if ((p4.p().e().f != null) && (!TextUtils.isEmpty(p4.p().e().f.n))) {
        this.C = p4.p().e().f.n;
      }
    }
    paramString = String.format("/v1/r/%s/get_pay_result", new Object[] { p4.p().e().b.offerId });
    if (paramInt == 1)
    {
      this.h = 0;
      String str = a2.c();
      this.y = false;
      b(str, "https", paramString, "442");
    }
    else
    {
      a("https", paramString, "442");
    }
    G();
  }
  
  public boolean F()
  {
    return this.A != 1;
  }
  
  public void G()
  {
    b("offer_id", p4.p().c());
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    b("openid", localo4.b.openId);
    b("openkey", localo4.b.openKey);
    b("session_id", localo4.b.sessionId);
    b("session_type", localo4.b.sessionType);
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    if (!TextUtils.isEmpty(this.B)) {
      b("uuid", this.B);
    }
    if (!TextUtils.isEmpty(this.C)) {
      b("portal_serial_no", this.C);
    }
    b("zoneid", localo4.b.zoneId);
    b("xg_mid", APAppDataInterface.singleton().C());
    b("extend", localc6.e());
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return this.A != 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.r3
 * JD-Core Version:    0.7.0.1
 */