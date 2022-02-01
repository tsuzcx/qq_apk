package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class r2
  extends ob
{
  public byte[] g = null;
  public String h = "";
  
  public r2(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    super.d(paramgb);
    Object localObject = new String(paramgb.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APVerifyCodeAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.a = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
      if (this.a == 0)
      {
        this.h = ((JSONObject)localObject).getString("verify_session").toString();
        this.g = e.a(((JSONObject)localObject).getString("bin").toString());
      }
      else
      {
        this.b = ((JSONObject)localObject).getString("msg");
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
      this.g = e.a("");
      localJSONException.printStackTrace();
    }
    return super.d(paramgb);
  }
  
  public byte[] g()
  {
    return this.g;
  }
  
  public String h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.r2
 * JD-Core Version:    0.7.0.1
 */