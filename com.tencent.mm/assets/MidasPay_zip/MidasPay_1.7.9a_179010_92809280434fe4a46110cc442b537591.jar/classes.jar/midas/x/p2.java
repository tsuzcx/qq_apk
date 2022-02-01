package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class p2
  extends ob
{
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  
  public p2(fc paramfc)
  {
    super(paramfc);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      String str = paramJSONObject.getString("friends_pay_msg");
      this.i = paramJSONObject.getString("wx_appid");
      this.j = paramJSONObject.getString("qq_appid");
      this.k = paramJSONObject.getString("friends_pay_url");
      if (!TextUtils.isEmpty(str)) {
        this.h = str;
      }
      this.l = paramJSONObject.optString("friends_pay_url_v2");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject = paramgb.b;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.a = -1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject).append(x1.a(20004));
      this.b = ((StringBuilder)localObject).toString();
      return super.d(paramgb);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APGetTokenAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.a = Integer.parseInt(((JSONObject)localObject).getString("ret"));
      if (this.a == 0)
      {
        this.g = ((JSONObject)localObject).getString("token");
        a((JSONObject)localObject);
      }
      else
      {
        this.b = ((JSONObject)localObject).getString("msg");
        localObject = ((JSONObject)localObject).getString("err_code");
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("系统繁忙,请稍后再试 ");
      localStringBuilder.append(x1.a(20003));
      this.b = localStringBuilder.toString();
      localJSONException.printStackTrace();
    }
    return super.d(paramgb);
  }
  
  public String g()
  {
    return this.h;
  }
  
  public String h()
  {
    return this.k;
  }
  
  public String i()
  {
    return this.l;
  }
  
  public String j()
  {
    return this.j;
  }
  
  public String k()
  {
    return this.g;
  }
  
  public String l()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.p2
 * JD-Core Version:    0.7.0.1
 */