package midas.x;

import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class w2
  extends ob
{
  public final String g;
  
  public w2(String paramString, fc paramfc)
  {
    super(paramfc);
    this.g = paramString;
  }
  
  public boolean d(gb paramgb)
  {
    super.d(paramgb);
    APUICommonMethod.b();
    String str = new String(paramgb.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append(str);
    APLog.i("APHFCouponsRollBackAns", localStringBuilder.toString());
    try
    {
      this.a = Integer.parseInt(new JSONObject(str).getString("ret").toString());
      if ("goldcouponsrollback".equals(this.g))
      {
        if (this.a == 0) {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "金券 回滚成功!");
        } else {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "金券 回滚失败!");
        }
      }
      else if ("supercouponsrollback".equals(this.g))
      {
        if (this.a == 0) {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "超级券 回滚成功!");
        } else {
          APLog.i("com.pay.network.modle.APHFCouponsRollBackAns", "超级券 回滚失败!");
        }
      }
      else if (this.a == 0) {
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
    return super.d(paramgb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.w2
 * JD-Core Version:    0.7.0.1
 */