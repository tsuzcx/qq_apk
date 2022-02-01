package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class cx
  extends lh
{
  private String a;
  
  public cx(lw paramlw)
  {
    super(paramlw);
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
    APLog.i("APHFPayBySMSAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.j = ((JSONObject)localObject).getInt("ret");
      if (this.j != 0)
      {
        if (((JSONObject)localObject).has("msg")) {
          this.k = ((JSONObject)localObject).getString("msg").toString();
        }
        if (TextUtils.isEmpty(this.k)) {
          this.k = "系统繁忙,请稍后再试";
        }
        this.l = this.k;
        if (((JSONObject)localObject).has("err_code")) {
          this.a = ((JSONObject)localObject).getString("err_code").toString();
        }
        if (!TextUtils.isEmpty(this.a))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.k);
          ((StringBuilder)localObject).append(" (");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append(")");
          this.k = ((StringBuilder)localObject).toString();
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
 * Qualified Name:     midas.x.cx
 * JD-Core Version:    0.7.0.1
 */