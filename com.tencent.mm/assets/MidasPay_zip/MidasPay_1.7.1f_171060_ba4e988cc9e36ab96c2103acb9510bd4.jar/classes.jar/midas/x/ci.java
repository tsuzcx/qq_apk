package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ci
  extends jw
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  public ci(kl paramkl)
  {
    super(paramkl);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      String str = paramJSONObject.getString("friends_pay_msg");
      this.c = paramJSONObject.getString("wx_appid");
      this.d = paramJSONObject.getString("qq_appid");
      this.e = paramJSONObject.getString("friends_pay_url");
      if (!TextUtils.isEmpty(str))
      {
        this.b = str;
        return;
      }
    }
    catch (JSONException paramJSONObject)
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
    Object localObject = paramjo.b;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.i = -1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject).append(bq.a(20004));
      this.j = ((StringBuilder)localObject).toString();
      return super.a(paramjo);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APGetTokenAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.i = Integer.parseInt(((JSONObject)localObject).getString("ret"));
      if (this.i == 0)
      {
        this.a = ((JSONObject)localObject).getString("token");
        a((JSONObject)localObject);
      }
      else
      {
        this.j = ((JSONObject)localObject).getString("msg");
        localObject = ((JSONObject)localObject).getString("err_code");
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("系统繁忙,请稍后再试 ");
      localStringBuilder.append(bq.a(20003));
      this.j = localStringBuilder.toString();
      localJSONException.printStackTrace();
    }
    return super.a(paramjo);
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ci
 * JD-Core Version:    0.7.0.1
 */