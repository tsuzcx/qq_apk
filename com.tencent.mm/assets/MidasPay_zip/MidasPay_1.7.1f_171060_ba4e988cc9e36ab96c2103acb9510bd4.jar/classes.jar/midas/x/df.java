package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONObject;

public class df
  extends jw
{
  int a = -1;
  
  public df(kl paramkl)
  {
    super(paramkl);
  }
  
  public int a()
  {
    return this.a;
  }
  
  protected boolean a(jo paramjo)
  {
    super.a(paramjo);
    Object localObject1 = new String(paramjo.b);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData == ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.i("APQueryMarketResultAns", ((StringBuilder)localObject2).toString());
    label264:
    try
    {
      localObject2 = new JSONObject((String)localObject1);
      this.i = Integer.parseInt(((JSONObject)localObject2).getString("ret").toString());
      if (this.i == 0)
      {
        int i = ((JSONObject)localObject2).getInt("present_flag");
        localObject1 = ((JSONObject)localObject2).getString("goods_name");
        String str = ((JSONObject)localObject2).getString("goods_num");
        fp.a().a(i);
        fp.a().e((String)localObject1);
        fp.a().f(str);
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
      fp.a().g((String)localObject2);
    }
    catch (Exception localException2)
    {
      break label177;
    }
    localObject1 = localObject2;
    APLog.i("APQueryMarketResultAns extend == ", (String)localObject1);
    break label264;
    this.j = ((JSONObject)localObject2).getString("msg").toString();
    localObject1 = ((JSONObject)localObject2).getString("err_code").toString();
    if (!((String)localObject1).equals(""))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 (");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      this.j = ((StringBuilder)localObject2).toString();
    }
    return super.a(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.df
 * JD-Core Version:    0.7.0.1
 */