package midas.x;

import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class dj
  extends jw
{
  private String a = "";
  
  public dj(kl paramkl)
  {
    super(paramkl);
  }
  
  protected boolean a(jo paramjo)
  {
    if (paramjo.b == null)
    {
      this.i = -1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject).append(bq.a(20004));
      this.j = ((StringBuilder)localObject).toString();
      return super.a(paramjo);
    }
    Object localObject = paramjo.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APGetTokenAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.i = Integer.parseInt(((JSONObject)localObject).getString("ret"));
      if (this.i == 0)
      {
        this.a = ((JSONObject)localObject).getString("msg");
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
        this.j = ((JSONObject)localObject).getString("msg");
        localObject = ((JSONObject)localObject).getString("err_code");
        if (!((String)localObject).equals(""))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("系统繁忙,请稍后再试 (");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(")");
          this.j = localStringBuilder.toString();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("系统繁忙,请稍后再试 ");
      localStringBuilder.append(bq.a(20003));
      this.j = localStringBuilder.toString();
      localJSONException.printStackTrace();
    }
    return super.a(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dj
 * JD-Core Version:    0.7.0.1
 */