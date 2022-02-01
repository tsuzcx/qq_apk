package midas.x;

import android.text.TextUtils;
import com.pay.tool.APAppDataInterface;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class c4
  extends ob
{
  public String g = "";
  public String h = "0";
  
  public c4(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject1 = new String(paramgb.b);
    Object localObject2 = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject1);
    ((PrintStream)localObject2).println(localStringBuilder.toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.a = Integer.parseInt(((JSONObject)localObject1).getString("ret").toString());
      if (this.a == 0)
      {
        this.g = ((JSONObject)localObject1).getString("mobile").toString();
        this.h = ((JSONObject)localObject1).getString("remain").toString();
        if (((JSONObject)localObject1).has("need_change_key")) {
          if (((JSONObject)localObject1).getInt("need_change_key") == 1) {
            APAppDataInterface.singleton().a(true);
          } else {
            APAppDataInterface.singleton().a(false);
          }
        }
      }
      else
      {
        if (((JSONObject)localObject1).has("msg")) {
          this.b = ((JSONObject)localObject1).getString("msg").toString();
        }
        if (((JSONObject)localObject1).has("err_code"))
        {
          localObject1 = ((JSONObject)localObject1).getString("err_code").toString();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 (");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(")");
            this.b = ((StringBuilder)localObject2).toString();
          }
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
    return this.h;
  }
  
  public String h()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.c4
 * JD-Core Version:    0.7.0.1
 */