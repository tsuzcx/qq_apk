package com.tencent.open.agent;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import org.json.JSONObject;

public class DeviceShareFriendChooser$SendBindListCallBack
  implements HttpCgiAsyncTask.Callback
{
  protected DeviceShareFriendChooser$SendBindListCallBack(DeviceShareFriendChooser paramDeviceShareFriendChooser) {}
  
  public void a(Exception paramException)
  {
    this.a.d();
    LogUtility.c(DeviceShareFriendChooser.a, "add_authorize_member exception");
    ToastUtil.a().a(2131362635);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.d();
    LogUtility.a(DeviceShareFriendChooser.a, "SendBindListCallBack success");
    if (paramJSONObject.optInt("code", -1) != 0)
    {
      ToastUtil.a().a(2131362634);
      LogUtility.c(DeviceShareFriendChooser.a, "add_authorize_member:" + paramJSONObject);
      return;
    }
    paramJSONObject = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_error_code", 0);
    localBundle.putParcelableArrayList("RESULT_BUDDIES_SELECTED", this.a.c);
    paramJSONObject.putExtras(localBundle);
    this.a.a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.DeviceShareFriendChooser.SendBindListCallBack
 * JD-Core Version:    0.7.0.1
 */