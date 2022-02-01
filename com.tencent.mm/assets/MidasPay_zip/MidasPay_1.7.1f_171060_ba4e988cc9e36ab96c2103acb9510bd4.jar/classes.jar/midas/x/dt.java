package midas.x;

import com.pay.tool.APAppDataInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class dt
  extends jw
{
  private String a = "";
  private String b = "";
  
  public dt(kl paramkl)
  {
    super(paramkl);
  }
  
  protected boolean a(jo paramjo)
  {
    Object localObject = new String(paramjo.b);
    try
    {
      localObject = new JSONObject((String)localObject);
      this.i = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
      if (this.i == 0)
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
        this.j = ((JSONObject)localObject).getString("msg").toString();
        localObject = ((JSONObject)localObject).getString("err_code").toString();
        if (!((String)localObject).equals("")) {
          this.j = ((String)localObject);
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
 * Qualified Name:     midas.x.dt
 * JD-Core Version:    0.7.0.1
 */