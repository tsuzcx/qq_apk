package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONObject;

public class dn
  extends lh
{
  int a = -1;
  
  public dn(lw paramlw)
  {
    super(paramlw);
  }
  
  public int a()
  {
    return this.a;
  }
  
  protected boolean a(kz paramkz)
  {
    super.a(paramkz);
    Object localObject1 = new String(paramkz.b);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData == ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.i("APQueryMarketResultAns", ((StringBuilder)localObject2).toString());
    label264:
    try
    {
      localObject2 = new JSONObject((String)localObject1);
      this.j = Integer.parseInt(((JSONObject)localObject2).getString("ret").toString());
      if (this.j == 0)
      {
        int i = ((JSONObject)localObject2).getInt("present_flag");
        localObject1 = ((JSONObject)localObject2).getString("goods_name");
        String str = ((JSONObject)localObject2).getString("goods_num");
        fy.a().a(i);
        fy.a().e((String)localObject1);
        fy.a().f(str);
        if (((JSONObject)localObject2).has("provide_result")) {
          this.a = ((JSONObject)localObject2).getInt("provide_result");
        }
        localObject1 = "";
      }
    }
    catch (Exception localException1)
    {
      label177:
      label180:
      break label264;
    }
    try
    {
      localObject2 = ((JSONObject)localObject2).getString("extend");
    }
    catch (Exception localException3)
    {
      break label180;
    }
    try
    {
      fy.a().g((String)localObject2);
    }
    catch (Exception localException2)
    {
      break label177;
    }
    localObject1 = localObject2;
    APLog.i("APQueryMarketResultAns extend == ", (String)localObject1);
    break label264;
    this.k = ((JSONObject)localObject2).getString("msg").toString();
    localObject1 = ((JSONObject)localObject2).getString("err_code").toString();
    if (!((String)localObject1).equals(""))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 (");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      this.k = ((StringBuilder)localObject2).toString();
    }
    return super.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dn
 * JD-Core Version:    0.7.0.1
 */