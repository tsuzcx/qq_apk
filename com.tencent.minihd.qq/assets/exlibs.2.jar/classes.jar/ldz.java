import android.os.Bundle;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import org.json.JSONException;
import org.json.JSONObject;

public class ldz
  implements Runnable
{
  public ldz(BaseJsCallBack paramBaseJsCallBack, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      Bundle localBundle = new Bundle();
      localBundle.putString("iconType", localJSONObject.optString("iconType"));
      localBundle.putString("visible", localJSONObject.optString("visible"));
      localBundle.putString("callBackKey", localJSONObject.optString("callBackKey"));
      localBundle.putString("rightText", localJSONObject.optString("text"));
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity instanceof AppViewBaseActivity)) {
        ((AppViewBaseActivity)this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack.activity).b(localBundle);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ldz
 * JD-Core Version:    0.7.0.1
 */