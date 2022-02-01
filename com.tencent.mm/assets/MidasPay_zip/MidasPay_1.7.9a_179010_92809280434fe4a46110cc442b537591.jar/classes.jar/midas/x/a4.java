package midas.x;

import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class a4
  extends ob
{
  public String g;
  
  public a4(fc paramfc)
  {
    super(paramfc);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      this.g = APTools.a(paramJSONObject.optString("url"), 1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean d(gb paramgb)
  {
    super.d(paramgb);
    Object localObject = new String(paramgb.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APSignAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.a = Integer.parseInt(((JSONObject)localObject).optString("ret").toString());
      if (this.a == 0)
      {
        a((JSONObject)localObject);
      }
      else
      {
        this.b = ((JSONObject)localObject).getString("msg").toString();
        localObject = ((JSONObject)localObject).getString("err_code").toString();
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
      localJSONException.printStackTrace();
    }
    return super.d(paramgb);
  }
  
  public String g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.a4
 * JD-Core Version:    0.7.0.1
 */