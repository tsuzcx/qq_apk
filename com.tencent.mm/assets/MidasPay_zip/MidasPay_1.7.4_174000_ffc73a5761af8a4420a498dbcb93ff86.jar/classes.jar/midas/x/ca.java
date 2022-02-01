package midas.x;

import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ca
  extends lh
{
  private String a = "";
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String n;
  private String o;
  
  public ca(lw paramlw)
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
    Object localObject = paramkz.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APActivityAbilityAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.j = Integer.parseInt(((JSONObject)localObject).optString("ret"));
      if (this.j == 0)
      {
        this.a = ((JSONObject)localObject).optString("order_id");
        localObject = ((JSONObject)localObject).optJSONObject("share_info");
        this.d = APTools.b(((JSONObject)localObject).optString("h5_url"), 1);
        this.c = ((JSONObject)localObject).optString("wx_appid");
        this.e = ((JSONObject)localObject).optString("wx_mini_appid");
        this.f = APTools.b(((JSONObject)localObject).optString("wx_mini_path"), 1);
        this.g = APTools.b(((JSONObject)localObject).optString("wx_mini_url"), 1);
        this.h = ((JSONObject)localObject).optString("wx_mini_origid");
        this.b = ((JSONObject)localObject).optString("qq_appid");
        this.i = ((JSONObject)localObject).optString("qq_mini_appid");
        this.o = APTools.b(((JSONObject)localObject).optString("qq_mini_url"), 1);
        this.n = APTools.b(((JSONObject)localObject).optString("qq_mini_path"), 1);
      }
      else
      {
        this.k = ((JSONObject)localObject).optString("msg");
        localObject = ((JSONObject)localObject).optString("err_code");
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
      localJSONException.printStackTrace();
    }
    return super.a(paramkz);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public String h()
  {
    return this.i;
  }
  
  public String i()
  {
    return this.n;
  }
  
  public String j()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ca
 * JD-Core Version:    0.7.0.1
 */