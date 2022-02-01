package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONObject;

public class q3
  extends ob
{
  public int g = -1;
  
  public q3(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    super.d(paramgb);
    Object localObject1 = new String(paramgb.b);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData == ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.i("APQueryMarketResultAns", ((StringBuilder)localObject2).toString());
    label268:
    try
    {
      localObject2 = new JSONObject((String)localObject1);
      this.a = Integer.parseInt(((JSONObject)localObject2).getString("ret").toString());
      int i = this.a;
      localObject1 = "";
      if (i == 0)
      {
        i = ((JSONObject)localObject2).getInt("present_flag");
        String str1 = ((JSONObject)localObject2).getString("goods_name");
        String str2 = ((JSONObject)localObject2).getString("goods_num");
        c6.s0().c(i);
        c6.s0().j(str1);
        c6.s0().k(str2);
        if (((JSONObject)localObject2).has("provide_result")) {
          this.g = ((JSONObject)localObject2).getInt("provide_result");
        }
      }
    }
    catch (Exception localException1)
    {
      label184:
      break label268;
    }
    try
    {
      localObject2 = ((JSONObject)localObject2).getString("extend");
      localObject1 = localObject2;
      c6.s0().i((String)localObject2);
    }
    catch (Exception localException2)
    {
      break label184;
    }
    APLog.i("APQueryMarketResultAns extend == ", (String)localObject1);
    break label268;
    this.b = ((JSONObject)localObject2).getString("msg").toString();
    localObject1 = ((JSONObject)localObject2).getString("err_code").toString();
    if (!((String)localObject1).equals(""))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 (");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      this.b = ((StringBuilder)localObject2).toString();
    }
    return super.d(paramgb);
  }
  
  public int g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.q3
 * JD-Core Version:    0.7.0.1
 */