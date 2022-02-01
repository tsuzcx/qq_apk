package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.net.URLEncoder;

public class dq
  extends bx
{
  public static String a = "query";
  private String b;
  private String c;
  
  public dq(String paramString1, String paramString2)
  {
    String str = em.b().n().a.offerId;
    this.b = paramString1;
    paramString1 = String.format("/v1/r/%s/receipt_proc", new Object[] { str });
    this.c = paramString2;
    a("https", paramString1, "442");
    c();
  }
  
  public void c()
  {
    fy localfy = fy.a();
    el localel = em.b().n();
    APBaseRequest localAPBaseRequest = localel.a;
    e("openid", localAPBaseRequest.openId);
    e("session_id", localAPBaseRequest.sessionId);
    e("session_type", localAPBaseRequest.sessionType);
    e("offer_id", em.b().f());
    f("openid", localAPBaseRequest.openId);
    f("openkey", localAPBaseRequest.openKey);
    if (this.b.equalsIgnoreCase("query_pay_receipt"))
    {
      APLog.d("APQueryType", "query_pay_receipt");
      f("action", "query_pay_receipt");
      f("transactionid", fy.a().U());
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
    f("pay_method", localel.e.f);
    e("xg_mid", APAppDataInterface.singleton().l());
    e("extend", localfy.y());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dq
 * JD-Core Version:    0.7.0.1
 */