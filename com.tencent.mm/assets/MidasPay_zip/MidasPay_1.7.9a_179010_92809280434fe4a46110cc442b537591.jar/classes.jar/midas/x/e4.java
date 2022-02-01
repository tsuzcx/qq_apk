package midas.x;

import com.pay.tool.APAppDataInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class e4
  extends ob
{
  public e4(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject = new String(paramgb.b);
    try
    {
      localObject = new JSONObject((String)localObject);
      this.a = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
      if (this.a == 0)
      {
        if (((JSONObject)localObject).has("need_change_key")) {
          if (((JSONObject)localObject).getInt("need_change_key") == 1) {
            APAppDataInterface.singleton().a(true);
          } else {
            APAppDataInterface.singleton().a(false);
          }
        }
      }
      else
      {
        this.b = ((JSONObject)localObject).getString("msg").toString();
        localObject = ((JSONObject)localObject).getString("err_code").toString();
        if (!((String)localObject).equals("")) {
          this.b = ((String)localObject);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return super.d(paramgb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.e4
 * JD-Core Version:    0.7.0.1
 */