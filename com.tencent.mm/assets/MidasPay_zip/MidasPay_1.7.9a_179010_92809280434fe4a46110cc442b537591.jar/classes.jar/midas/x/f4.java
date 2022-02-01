package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class f4
  extends y1
{
  public String A;
  public String B;
  public String C;
  
  public f4(String paramString1, String paramString2, String paramString3)
  {
    this.A = paramString1;
    this.B = paramString2;
    this.C = paramString3;
    a("https", String.format("/v1/r/%s/mobile_push_msg", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    b("offer_id", p4.p().c());
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    e("openid", localo4.b.openId);
    e("openkey", localo4.b.openKey);
    e("session_id", localo4.b.sessionId);
    e("session_type", localo4.b.sessionType);
    e("src_uuid", this.B);
    e("dst_uuid", this.C);
    e("pushtype", "NodeJS");
    try
    {
      e("pushmsg", URLEncoder.encode(this.A, "UTF-8"));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    e("pushcmd", "PayReq");
    e("pushstatus", "4");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("src_uuid:");
    localStringBuilder.append(this.B);
    APLog.i("APSyncOrderReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("dst_uuid:");
    localStringBuilder.append(this.C);
    APLog.i("APSyncOrderReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pushmsg:");
    localStringBuilder.append(this.A);
    APLog.i("APSyncOrderReq", localStringBuilder.toString());
    b("openid", localo4.b.openId);
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", localo4.f.k);
    b("buy_type", localo4.c.g);
    b("extend", localc6.e());
    b("xg_mid", APAppDataInterface.singleton().C());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.f4
 * JD-Core Version:    0.7.0.1
 */