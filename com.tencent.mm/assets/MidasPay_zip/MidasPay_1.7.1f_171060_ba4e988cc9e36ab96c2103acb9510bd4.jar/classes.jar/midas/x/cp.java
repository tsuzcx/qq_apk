package midas.x;

import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class cp
  extends jw
{
  private final String a = "com.pay.network.modle.APHFCouponsRollBackAns";
  private final String b;
  
  public cp(String paramString, kl paramkl)
  {
    super(paramkl);
    this.b = paramString;
  }
  
  protected boolean a(jo paramjo)
  {
    super.a(paramjo);
    APUICommonMethod.g();
    String str = new String(paramjo.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append(str);
    APLog.i("APHFCouponsRollBackAns", localStringBuilder.toString());
    try
    {
      this.i = Integer.parseInt(new JSONObject(str).getString("ret").toString());
      if ("goldcouponsrollback".equals(this.b))
      {
        if (this.i == 0) {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "金券 回滚成功!");
        } else {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "金券 回滚失败!");
        }
      }
      else if ("supercouponsrollback".equals(this.b))
      {
        if (this.i == 0) {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "超级券 回滚成功!");
        } else {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "超级券 回滚失败!");
        }
      }
      else if (this.i == 0) {
        APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "话费券 回滚成功!");
      } else {
        APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "话费券 回滚失败!");
      }
    }
    catch (JSONException localJSONException)
    {
      label179:
      break label179;
    }
    APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "回滚json解析异常!");
    return super.a(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cp
 * JD-Core Version:    0.7.0.1
 */