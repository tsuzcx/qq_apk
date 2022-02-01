package midas.x;

import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class u3
  extends ob
{
  public u3(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject = paramgb.b;
    if (localObject == null)
    {
      this.a = -1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject).append(x1.a(20004));
      this.b = ((StringBuilder)localObject).toString();
      return super.d(paramgb);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APGetTokenAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.a = Integer.parseInt(((JSONObject)localObject).getString("ret"));
      int i = this.a;
      if (i == 0)
      {
        ((JSONObject)localObject).getString("msg");
        if (((JSONObject)localObject).has("need_change_key")) {
          if (((JSONObject)localObject).getInt("need_change_key") == 1) {
            APAppDataInterface.singleton().a(true);
          } else {
            APAppDataInterface.singleton().a(false);
          }
        }
      }
      else
      {
        this.b = ((JSONObject)localObject).getString("msg");
        localObject = ((JSONObject)localObject).getString("err_code");
        if (!((String)localObject).equals(""))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("系统繁忙,请稍后再试 (");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(")");
          this.b = localStringBuilder.toString();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("系统繁忙,请稍后再试 ");
      localStringBuilder.append(x1.a(20003));
      this.b = localStringBuilder.toString();
      localJSONException.printStackTrace();
    }
    return super.d(paramgb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.u3
 * JD-Core Version:    0.7.0.1
 */