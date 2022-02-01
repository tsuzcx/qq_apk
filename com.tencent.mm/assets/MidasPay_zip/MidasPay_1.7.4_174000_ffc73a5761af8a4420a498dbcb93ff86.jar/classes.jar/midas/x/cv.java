package midas.x;

import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class cv
  extends lh
{
  private final String a = "com.pay.network.modle.APHFCouponsRollBackAns";
  private final String b;
  
  public cv(String paramString, lw paramlw)
  {
    super(paramlw);
    this.b = paramString;
  }
  
  protected boolean a(kz paramkz)
  {
    super.a(paramkz);
    APUICommonMethod.g();
    String str = new String(paramkz.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append(str);
    APLog.i("APHFCouponsRollBackAns", localStringBuilder.toString());
    try
    {
      this.j = Integer.parseInt(new JSONObject(str).getString("ret").toString());
      if ("goldcouponsrollback".equals(this.b))
      {
        if (this.j == 0) {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "金券 回滚成功!");
        } else {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "金券 回滚失败!");
        }
      }
      else if ("supercouponsrollback".equals(this.b))
      {
        if (this.j == 0) {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "超级券 回滚成功!");
        } else {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "超级券 回滚失败!");
        }
      }
      else if (this.j == 0) {
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
    return super.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cv
 * JD-Core Version:    0.7.0.1
 */