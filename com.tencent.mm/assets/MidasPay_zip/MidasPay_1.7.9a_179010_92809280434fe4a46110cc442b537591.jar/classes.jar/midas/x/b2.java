package midas.x;

import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class b2
  extends ob
{
  public String g = "";
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  
  public b2(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    super.d(paramgb);
    Object localObject = paramgb.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APActivityAbilityAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject);
      this.a = Integer.parseInt(((JSONObject)localObject).optString("ret"));
      if (this.a == 0)
      {
        this.g = ((JSONObject)localObject).optString("order_id");
        localObject = ((JSONObject)localObject).optJSONObject("share_info");
        this.j = APTools.a(((JSONObject)localObject).optString("h5_url"), 1);
        this.i = ((JSONObject)localObject).optString("wx_appid");
        ((JSONObject)localObject).optString("wx_mini_appid");
        this.k = APTools.a(((JSONObject)localObject).optString("wx_mini_path"), 1);
        this.l = APTools.a(((JSONObject)localObject).optString("wx_mini_url"), 1);
        this.m = ((JSONObject)localObject).optString("wx_mini_origid");
        this.h = ((JSONObject)localObject).optString("qq_appid");
        this.n = ((JSONObject)localObject).optString("qq_mini_appid");
        this.p = APTools.a(((JSONObject)localObject).optString("qq_mini_url"), 1);
        this.o = APTools.a(((JSONObject)localObject).optString("qq_mini_path"), 1);
      }
      else
      {
        this.b = ((JSONObject)localObject).optString("msg");
        localObject = ((JSONObject)localObject).optString("err_code");
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
      localJSONException.printStackTrace();
    }
    return super.d(paramgb);
  }
  
  public String g()
  {
    return this.j;
  }
  
  public String h()
  {
    return this.g;
  }
  
  public String i()
  {
    return this.h;
  }
  
  public String j()
  {
    return this.n;
  }
  
  public String k()
  {
    return this.o;
  }
  
  public String l()
  {
    return this.p;
  }
  
  public String m()
  {
    return this.i;
  }
  
  public String n()
  {
    return this.m;
  }
  
  public String o()
  {
    return this.k;
  }
  
  public String p()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.b2
 * JD-Core Version:    0.7.0.1
 */