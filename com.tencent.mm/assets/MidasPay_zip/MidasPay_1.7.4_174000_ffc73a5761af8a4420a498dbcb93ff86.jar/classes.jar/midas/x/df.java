package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class df
  extends lh
{
  public String a;
  private String b = "";
  private String c = "";
  
  public df(String paramString, lw paramlw)
  {
    super(paramlw);
    this.a = paramString;
  }
  
  public String a()
  {
    return this.b;
  }
  
  protected boolean a(kz paramkz)
  {
    super.a(paramkz);
    this.c = new String(paramkz.b);
    try
    {
      Object localObject2 = new JSONObject(this.c);
      APLog.i("APMobileConfigAns", this.c);
      Object localObject1 = X();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        APLog.e("MobileConfig", "Cannnot get decode key!");
      }
      this.j = ((JSONObject)localObject2).getInt("ret");
      if (this.j == 0)
      {
        localObject2 = ((JSONObject)localObject2).getString("encrypt_msg").split("_");
        this.b = gh.b(localObject2[0], (String)localObject1).substring(0, Integer.valueOf(localObject2[1]).intValue());
        localObject1 = new JSONObject(this.b.toString());
        ((JSONObject)localObject1).put("ret", this.j);
        APLog.d("decryptMsg", this.b);
        this.b = ((JSONObject)localObject1).toString();
      }
      else
      {
        if (((JSONObject)localObject2).has("msg")) {
          this.k = ((JSONObject)localObject2).getString("msg").toString();
        }
        if (((JSONObject)localObject2).has("err_code")) {
          this.j = ((JSONObject)localObject2).getInt("err_code");
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
 * Qualified Name:     midas.x.df
 * JD-Core Version:    0.7.0.1
 */