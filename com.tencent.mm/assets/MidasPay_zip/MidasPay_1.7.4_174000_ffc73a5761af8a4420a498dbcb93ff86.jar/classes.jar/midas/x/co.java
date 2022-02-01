package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class co
  extends lh
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  public co(lw paramlw)
  {
    super(paramlw);
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
  
  protected boolean a(kz paramkz)
  {
    Object localObject = paramkz.b;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.j = -1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject).append(bw.a(20004));
      this.k = ((StringBuilder)localObject).toString();
      return super.a(paramkz);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APGetTokenAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.j = Integer.parseInt(((JSONObject)localObject).getString("ret"));
      if (this.j == 0)
      {
        this.a = ((JSONObject)localObject).getString("token");
        a((JSONObject)localObject);
      }
      else
      {
        this.k = ((JSONObject)localObject).getString("msg");
        localObject = ((JSONObject)localObject).getString("err_code");
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("系统繁忙,请稍后再试 ");
      localStringBuilder.append(bw.a(20003));
      this.k = localStringBuilder.toString();
      localJSONException.printStackTrace();
    }
    return super.a(paramkz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.co
 * JD-Core Version:    0.7.0.1
 */