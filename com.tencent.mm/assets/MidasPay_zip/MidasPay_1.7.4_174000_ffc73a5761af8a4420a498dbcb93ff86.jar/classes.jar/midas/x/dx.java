package midas.x;

import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class dx
  extends lh
{
  private String a;
  
  public dx(lw paramlw)
  {
    super(paramlw);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.a = APTools.b(paramJSONObject.optString("url"), 1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected boolean a(kz paramkz)
  {
    super.a(paramkz);
    Object localObject = new String(paramkz.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APSignAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.j = Integer.parseInt(((JSONObject)localObject).optString("ret").toString());
      if (this.j == 0)
      {
        a((JSONObject)localObject);
      }
      else
      {
        this.k = ((JSONObject)localObject).getString("msg").toString();
        localObject = ((JSONObject)localObject).getString("err_code").toString();
        if (!((String)localObject).equals(""))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("系统繁忙,请稍后再试 (");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(")");
          this.k = localStringBuilder.toString();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return super.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dx
 * JD-Core Version:    0.7.0.1
 */