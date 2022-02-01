package midas.x;

import android.text.TextUtils;
import com.pay.tool.APAppDataInterface;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class dz
  extends lh
{
  String a = "";
  String b = "0";
  
  public dz(lw paramlw)
  {
    super(paramlw);
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected boolean a(kz paramkz)
  {
    Object localObject1 = new String(paramkz.b);
    Object localObject2 = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject1);
    ((PrintStream)localObject2).println(localStringBuilder.toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.j = Integer.parseInt(((JSONObject)localObject1).getString("ret").toString());
      if (this.j == 0)
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
          this.k = ((JSONObject)localObject1).getString("msg").toString();
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
            this.k = ((StringBuilder)localObject2).toString();
          }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dz
 * JD-Core Version:    0.7.0.1
 */