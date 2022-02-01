package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class du
  extends br
{
  private String a;
  private String b;
  private String c;
  
  public du(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    a("https", String.format("/v1/r/%s/mobile_push_msg", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    e("offer_id", ed.b().f());
    fp localfp = fp.a();
    ec localec = ed.b().n();
    f("openid", localec.a.openId);
    f("openkey", localec.a.openKey);
    f("session_id", localec.a.sessionId);
    f("session_type", localec.a.sessionType);
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
    e("openid", localec.a.openId);
    e("pf", localec.a.pf);
    e("pfkey", localec.a.pfKey);
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", localec.e.l);
    e("buy_type", localec.b.j);
    e("extend", localfp.y());
    e("xg_mid", APAppDataInterface.singleton().l());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.du
 * JD-Core Version:    0.7.0.1
 */