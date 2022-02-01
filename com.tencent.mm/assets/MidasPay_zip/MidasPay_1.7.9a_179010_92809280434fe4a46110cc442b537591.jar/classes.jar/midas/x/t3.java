package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.net.URLEncoder;

public class t3
  extends y1
{
  public String A;
  public String B;
  
  public t3(String paramString1, String paramString2)
  {
    String str = p4.p().e().b.offerId;
    this.A = paramString1;
    paramString1 = String.format("/v1/r/%s/receipt_proc", new Object[] { str });
    this.B = paramString2;
    a("https", paramString1, "442");
    G();
  }
  
  public void G()
  {
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    APBaseRequest localAPBaseRequest = localo4.b;
    b("openid", localAPBaseRequest.openId);
    b("session_id", localAPBaseRequest.sessionId);
    b("session_type", localAPBaseRequest.sessionType);
    b("offer_id", p4.p().c());
    e("openid", localAPBaseRequest.openId);
    e("openkey", localAPBaseRequest.openKey);
    if (this.A.equalsIgnoreCase("query_pay_receipt"))
    {
      APLog.d("APQueryType", "query_pay_receipt");
      e("action", "query_pay_receipt");
      e("transactionid", c6.s0().T());
    }
    else if (this.A.equalsIgnoreCase("query_unfinish_receipt"))
    {
      APLog.d("APQueryType", "query_unfinish_receipt");
      e("action", "query_unfinish_receipt");
      e("transactionid", "");
    }
    else if (this.A.equalsIgnoreCase("finish_receipt"))
    {
      APLog.d("APQueryType", "finish_receipt");
      e("action", "finish_receipt");
      e("receipt_info", URLEncoder.encode(this.B));
    }
    e("num", "");
    e("pay_method", localo4.f.e);
    b("xg_mid", APAppDataInterface.singleton().C());
    b("extend", localc6.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.t3
 * JD-Core Version:    0.7.0.1
 */