package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class cz
  extends jw
{
  public String a;
  private String b = "";
  private String c = "";
  
  public cz(String paramString, kl paramkl)
  {
    super(paramkl);
    this.a = paramString;
  }
  
  public String a()
  {
    return this.b;
  }
  
  protected boolean a(jo paramjo)
  {
    super.a(paramjo);
    this.c = new String(paramjo.b);
    try
    {
      Object localObject2 = new JSONObject(this.c);
      APLog.i("APMobileConfigAns", this.c);
      Object localObject1 = V();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        APLog.e("MobileConfig", "Cannnot get decode key!");
      }
      this.i = ((JSONObject)localObject2).getInt("ret");
      if (this.i == 0)
      {
        localObject2 = ((JSONObject)localObject2).getString("encrypt_msg").split("_");
        this.b = fx.b(localObject2[0], (String)localObject1).substring(0, Integer.valueOf(localObject2[1]).intValue());
        localObject1 = new JSONObject(this.b.toString());
        ((JSONObject)localObject1).put("ret", this.i);
        APLog.d("decryptMsg", this.b);
        this.b = ((JSONObject)localObject1).toString();
      }
      else
      {
        if (((JSONObject)localObject2).has("msg")) {
          this.j = ((JSONObject)localObject2).getString("msg").toString();
        }
        if (((JSONObject)localObject2).has("err_code")) {
          this.i = ((JSONObject)localObject2).getInt("err_code");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return super.a(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cz
 * JD-Core Version:    0.7.0.1
 */