package midas.x;

import com.pay.tool.APAppDataInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class eb
  extends lh
{
  private String a = "";
  private String b = "";
  
  public eb(lw paramlw)
  {
    super(paramlw);
  }
  
  protected boolean a(kz paramkz)
  {
    Object localObject = new String(paramkz.b);
    try
    {
      localObject = new JSONObject((String)localObject);
      this.j = Integer.parseInt(((JSONObject)localObject).getString("ret").toString());
      if (this.j == 0)
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
        this.k = ((JSONObject)localObject).getString("msg").toString();
        localObject = ((JSONObject)localObject).getString("err_code").toString();
        if (!((String)localObject).equals("")) {
          this.k = ((String)localObject);
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
 * Qualified Name:     midas.x.eb
 * JD-Core Version:    0.7.0.1
 */