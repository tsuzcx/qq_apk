package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.net.URLEncoder;

public class di
  extends br
{
  public static String a = "query";
  private String b;
  private String c;
  
  public di(String paramString1, String paramString2)
  {
    String str = ed.b().n().a.offerId;
    this.b = paramString1;
    paramString1 = String.format("/v1/r/%s/receipt_proc", new Object[] { str });
    this.c = paramString2;
    a("https", paramString1, "442");
    c();
  }
  
  public void c()
  {
    fp localfp = fp.a();
    ec localec = ed.b().n();
    APBaseRequest localAPBaseRequest = localec.a;
    e("openid", localAPBaseRequest.openId);
    e("session_id", localAPBaseRequest.sessionId);
    e("session_type", localAPBaseRequest.sessionType);
    e("offer_id", ed.b().f());
    f("openid", localAPBaseRequest.openId);
    f("openkey", localAPBaseRequest.openKey);
    if (this.b.equalsIgnoreCase("query_pay_receipt"))
    {
      APLog.d("APQueryType", "query_pay_receipt");
      f("action", "query_pay_receipt");
      f("transactionid", fp.a().U());
    }
    else if (this.b.equalsIgnoreCase("query_unfinish_receipt"))
    {
      APLog.d("APQueryType", "query_unfinish_receipt");
      f("action", "query_unfinish_receipt");
      f("transactionid", "");
    }
    else if (this.b.equalsIgnoreCase("finish_receipt"))
    {
      APLog.d("APQueryType", "finish_receipt");
      f("action", "finish_receipt");
      f("receipt_info", URLEncoder.encode(this.c));
    }
    f("num", "");
    f("pay_method", localec.e.f);
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfp.y());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.di
 * JD-Core Version:    0.7.0.1
 */