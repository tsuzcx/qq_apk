import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.troop.data.TroopBarPostLayoutBanner;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class kjl
  implements HttpWebCgiAsyncTask.Callback
{
  public kjl(TroopBarPostLayoutBanner paramTroopBarPostLayoutBanner) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    Object localObject;
    label86:
    do
    {
      Intent localIntent;
      do
      {
        return;
        localIntent = new Intent("refresh_page");
        localObject = "hide_loading";
        paramBundle = (Bundle)localObject;
        if (paramJSONObject != null) {
          paramBundle = (Bundle)localObject;
        }
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject("level");
          paramBundle = (Bundle)localObject;
          if (localJSONObject != null)
          {
            paramJSONObject = "sign_in";
            paramBundle = paramJSONObject;
            localIntent.putExtra("broadcast_data", localJSONObject.toString());
            paramBundle = paramJSONObject;
          }
        }
        catch (JSONException paramJSONObject)
        {
          break label86;
        }
        localIntent.putExtra("sub_action", paramBundle);
      } while (this.a.a.get() == null);
      ((Activity)this.a.a.get()).sendBroadcast(localIntent);
      return;
      paramBundle = "hide_loading";
      if (paramJSONObject.optInt("errno", -1) == 0) {
        paramBundle = "follow";
      }
      localObject = new Intent("refresh_page");
      ((Intent)localObject).putExtra("sub_action", paramBundle);
      if (paramJSONObject != null) {
        ((Intent)localObject).putExtra("broadcast_data", paramJSONObject.toString());
      }
    } while (this.a.a.get() == null);
    ((Activity)this.a.a.get()).sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kjl
 * JD-Core Version:    0.7.0.1
 */