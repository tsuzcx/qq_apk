package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class y2
  extends ob
{
  public String g;
  
  public y2(fc paramfc)
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
    APLog.i("APHFPayBySMSAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.a = ((JSONObject)localObject).getInt("ret");
      if (this.a != 0)
      {
        if (((JSONObject)localObject).has("msg")) {
          this.b = ((JSONObject)localObject).getString("msg").toString();
        }
        if (TextUtils.isEmpty(this.b)) {
          this.b = "系统繁忙,请稍后再试";
        }
        this.c = this.b;
        if (((JSONObject)localObject).has("err_code")) {
          this.g = ((JSONObject)localObject).getString("err_code").toString();
        }
        if (!TextUtils.isEmpty(this.g))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.b);
          ((StringBuilder)localObject).append(" (");
          ((StringBuilder)localObject).append(this.g);
          ((StringBuilder)localObject).append(")");
          this.b = ((StringBuilder)localObject).toString();
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
 * Qualified Name:     midas.x.y2
 * JD-Core Version:    0.7.0.1
 */