package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ck
  extends jw
{
  private byte[] a = null;
  private String b = "";
  
  public ck(kl paramkl)
  {
    super(paramkl);
  }
  
  protected boolean a(jo paramjo)
  {
    super.a(paramjo);
    Object localObject = new String(paramjo.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APVerifyCodeAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.i = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
      if (this.i == 0)
      {
        this.b = ((JSONObject)localObject).getString("verify_session").toString();
        this.a = e.a(((JSONObject)localObject).getString("bin").toString());
      }
      else
      {
        this.j = ((JSONObject)localObject).getString("msg");
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
      this.a = e.a("");
      localJSONException.printStackTrace();
    }
    return super.a(paramjo);
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ck
 * JD-Core Version:    0.7.0.1
 */