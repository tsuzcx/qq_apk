package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class cr
  extends jw
{
  private String a;
  
  public cr(kl paramkl)
  {
    super(paramkl);
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
    APLog.i("APHFPayBySMSAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.i = ((JSONObject)localObject).getInt("ret");
      if (this.i != 0)
      {
        if (((JSONObject)localObject).has("msg")) {
          this.j = ((JSONObject)localObject).getString("msg").toString();
        }
        if (TextUtils.isEmpty(this.j)) {
          this.j = "系统繁忙,请稍后再试";
        }
        this.k = this.j;
        if (((JSONObject)localObject).has("err_code")) {
          this.a = ((JSONObject)localObject).getString("err_code").toString();
        }
        if (!TextUtils.isEmpty(this.a))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.j);
          ((StringBuilder)localObject).append(" (");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append(")");
          this.j = ((StringBuilder)localObject).toString();
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
 * Qualified Name:     midas.x.cr
 * JD-Core Version:    0.7.0.1
 */