package midas.x;

import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ct
  extends jw
{
  public ct(kl paramkl)
  {
    super(paramkl);
  }
  
  protected boolean a(jo paramjo)
  {
    Object localObject = new String(paramjo.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append((String)localObject);
    APLog.i("APInitReportAns", localStringBuilder.toString());
    try
    {
      localObject = new JSONObject((String)localObject).getJSONObject("info");
      new ap().a((JSONObject)localObject);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return super.a(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ct
 * JD-Core Version:    0.7.0.1
 */