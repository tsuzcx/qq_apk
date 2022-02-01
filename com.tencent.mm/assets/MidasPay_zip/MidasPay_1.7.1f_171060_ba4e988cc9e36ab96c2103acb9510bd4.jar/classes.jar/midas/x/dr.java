package midas.x;

import android.text.TextUtils;
import com.pay.tool.APAppDataInterface;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class dr
  extends jw
{
  String a = "";
  String b = "0";
  
  public dr(kl paramkl)
  {
    super(paramkl);
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected boolean a(jo paramjo)
  {
    Object localObject1 = new String(paramjo.b);
    Object localObject2 = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject1);
    ((PrintStream)localObject2).println(localStringBuilder.toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.i = Integer.parseInt(((JSONObject)localObject1).getString("ret").toString());
      if (this.i == 0)
      {
        this.a = ((JSONObject)localObject1).getString("mobile").toString();
        this.b = ((JSONObject)localObject1).getString("remain").toString();
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
          this.j = ((JSONObject)localObject1).getString("msg").toString();
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
            this.j = ((StringBuilder)localObject2).toString();
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return super.a(paramjo);
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dr
 * JD-Core Version:    0.7.0.1
 */