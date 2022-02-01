package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class g3
  extends ob
{
  public String g = "";
  public String h = "";
  public String i;
  
  public g3(String paramString, fc paramfc)
  {
    super(paramfc);
    this.i = paramString;
  }
  
  public boolean d(gb paramgb)
  {
    super.d(paramgb);
    this.h = new String(paramgb.b);
    try
    {
      Object localObject2 = new JSONObject(this.h);
      APLog.i("APMobileConfigAns", this.h);
      Object localObject1 = b();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        APLog.e("MobileConfig", "Cannnot get decode key!");
      }
      this.a = ((JSONObject)localObject2).getInt("ret");
      if (this.a == 0)
      {
        localObject2 = ((JSONObject)localObject2).getString("encrypt_msg").split("_");
        this.g = l6.a(localObject2[0], (String)localObject1).substring(0, Integer.valueOf(localObject2[1]).intValue());
        localObject1 = new JSONObject(this.g.toString());
        ((JSONObject)localObject1).put("ret", this.a);
        APLog.d("decryptMsg", this.g);
        this.g = ((JSONObject)localObject1).toString();
      }
      else
      {
        if (((JSONObject)localObject2).has("msg")) {
          this.b = ((JSONObject)localObject2).getString("msg").toString();
        }
        if (((JSONObject)localObject2).has("err_code")) {
          this.a = ((JSONObject)localObject2).getInt("err_code");
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
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.g3
 * JD-Core Version:    0.7.0.1
 */