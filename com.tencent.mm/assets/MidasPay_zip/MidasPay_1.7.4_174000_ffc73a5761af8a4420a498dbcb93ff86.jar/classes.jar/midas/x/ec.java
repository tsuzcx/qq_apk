package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ec
  extends bx
{
  private String a;
  private String b;
  private String c;
  
  public ec(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    a("https", String.format("/v1/r/%s/mobile_push_msg", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    e("offer_id", em.b().f());
    fy localfy = fy.a();
    el localel = em.b().n();
    f("openid", localel.a.openId);
    f("openkey", localel.a.openKey);
    f("session_id", localel.a.sessionId);
    f("session_type", localel.a.sessionType);
    f("src_uuid", this.b);
    f("dst_uuid", this.c);
    f("pushtype", "NodeJS");
    try
    {
      f("pushmsg", URLEncoder.encode(this.a, "UTF-8"));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    f("pushcmd", "PayReq");
    f("pushstatus", "4");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("src_uuid:");
    localStringBuilder.append(this.b);
    APLog.i("APSyncOrderReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("dst_uuid:");
    localStringBuilder.append(this.c);
    APLog.i("APSyncOrderReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pushmsg:");
    localStringBuilder.append(this.a);
    APLog.i("APSyncOrderReq", localStringBuilder.toString());
    e("openid", localel.a.openId);
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", localel.e.l);
    e("buy_type", localel.b.j);
    e("extend", localfy.y());
    e("xg_mid", APAppDataInterface.singleton().l());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ec
 * JD-Core Version:    0.7.0.1
 */