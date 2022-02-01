package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class cq
  extends lh
{
  private byte[] a = null;
  private String b = "";
  
  public cq(lw paramlw)
  {
    super(paramlw);
  }
  
  protected boolean a(kz paramkz)
  {
    super.a(paramkz);
    Object localObject = new String(paramkz.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APVerifyCodeAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.j = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
      if (this.j == 0)
      {
        this.b = ((JSONObject)localObject).getString("verify_session").toString();
        this.a = e.a(((JSONObject)localObject).getString("bin").toString());
      }
      else
      {
        this.k = ((JSONObject)localObject).getString("msg");
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
      this.a = e.a("");
      localJSONException.printStackTrace();
    }
    return super.a(paramkz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cq
 * JD-Core Version:    0.7.0.1
 */