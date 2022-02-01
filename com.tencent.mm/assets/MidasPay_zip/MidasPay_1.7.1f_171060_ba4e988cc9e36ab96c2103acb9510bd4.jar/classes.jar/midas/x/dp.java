package midas.x;

import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class dp
  extends jw
{
  private String a;
  
  public dp(kl paramkl)
  {
    super(paramkl);
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
  
  protected boolean a(jo paramjo)
  {
    super.a(paramjo);
    Object localObject = new String(paramjo.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APSignAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.i = Integer.parseInt(((JSONObject)localObject).optString("ret").toString());
      if (this.i == 0)
      {
        a((JSONObject)localObject);
      }
      else
      {
        this.j = ((JSONObject)localObject).getString("msg").toString();
        localObject = ((JSONObject)localObject).getString("err_code").toString();
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
      localJSONException.printStackTrace();
    }
    return super.a(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dp
 * JD-Core Version:    0.7.0.1
 */