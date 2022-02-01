package com.tencent.open.agent;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.settings.OpensdkPreference;
import lby;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkFriendService$CheckAvatarUpdateCallback
  implements HttpCgiAsyncTask.Callback
{
  protected OpenSdkFriendService$CheckAvatarUpdateCallback(OpenSdkFriendService paramOpenSdkFriendService) {}
  
  public void a(Exception paramException)
  {
    LogUtility.c("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + paramException.getMessage(), paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.getInt("ret");
      Object localObject = paramJSONObject.getString("msg");
      if (i == 0)
      {
        localObject = paramJSONObject.getJSONArray("update_list");
        i = ((JSONArray)localObject).length();
        if (i > 0) {
          ThreadManager.b(new lby(this, i, (JSONArray)localObject));
        }
        localObject = OpensdkPreference.a(CommonDataAdapter.a().a(), "prefer_last_avatar_update_time").edit();
        ((SharedPreferences.Editor)localObject).putString(this.a.g, paramJSONObject.getString("time"));
        ((SharedPreferences.Editor)localObject).commit();
        if (this.a.a != null) {
          this.a.a.a();
        }
      }
      else
      {
        LogUtility.e("OpenSdkFriendService", "CheckAvatarUpdateCallback error. ret=" + i + ", msg=" + (String)localObject);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      LogUtility.c("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + paramJSONObject.getMessage(), paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback
 * JD-Core Version:    0.7.0.1
 */