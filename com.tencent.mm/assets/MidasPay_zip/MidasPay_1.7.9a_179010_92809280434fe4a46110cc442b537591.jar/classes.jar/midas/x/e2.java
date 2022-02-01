package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;

public abstract class e2
  extends y1
{
  public void G()
  {
    e("app_pkg_name", APAppDataInterface.singleton().b());
    e("app_sign", APAppDataInterface.singleton().c());
    e("mobile", APTools.p(a.r().a()));
    e("operator", APTools.o(a.r().a()));
    e("mccmnc", APTools.n(a.r().a()));
    try
    {
      String str = p4.p().e().b.mpInfo.payChannel;
      if (!TextUtils.isEmpty(str)) {
        e("pay_method", str);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.e2
 * JD-Core Version:    0.7.0.1
 */