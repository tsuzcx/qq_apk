package com.tencent.open.agent;

import android.os.Handler;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import org.json.JSONObject;

public class DeviceDeleteFriendChooserActivity$SendUnBindListCallBack
  implements HttpCgiAsyncTask.Callback
{
  protected DeviceDeleteFriendChooserActivity$SendUnBindListCallBack(DeviceDeleteFriendChooserActivity paramDeviceDeleteFriendChooserActivity) {}
  
  public void a(Exception paramException)
  {
    this.a.a();
    LogUtility.c("DeviceDeleteFriendChooserActivity", "SendBindListCallBack exception");
    ToastUtil.a().a(2131362633);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.a();
    LogUtility.a("DeviceDeleteFriendChooserActivity", "SendBindListCallBack success");
    if (paramJSONObject.optInt("code", -1) != 0)
    {
      ToastUtil.a().a(2131362632);
      return;
    }
    paramJSONObject = this.a.a.obtainMessage();
    paramJSONObject.what = 10000;
    this.a.a.sendMessage(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.DeviceDeleteFriendChooserActivity.SendUnBindListCallBack
 * JD-Core Version:    0.7.0.1
 */