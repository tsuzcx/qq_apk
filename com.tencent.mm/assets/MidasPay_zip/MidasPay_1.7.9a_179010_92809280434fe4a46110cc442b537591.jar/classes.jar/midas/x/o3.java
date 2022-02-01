package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class o3
  extends ob
{
  public String g;
  public String h;
  
  public o3(fc paramfc)
  {
    super(paramfc);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      this.g = paramJSONObject.optString("apply_permissions_token");
      this.h = paramJSONObject.optString("wx_appid");
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
  
  public String h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.o3
 * JD-Core Version:    0.7.0.1
 */