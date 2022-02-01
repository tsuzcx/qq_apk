package com.tencent.open.agent;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.datamodel.FriendResponseInfo;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import org.json.JSONObject;

public class SmartHardwareActivity$FriendsManager
  implements OpenSdkFriendService.GetFriendInfoListener, HttpCgiAsyncTask.Callback
{
  public SmartHardwareActivity$FriendsManager(SmartHardwareActivity paramSmartHardwareActivity) {}
  
  public void a(Bundle paramBundle, String paramString)
  {
    new HttpCgiAsyncTask(paramString, "GET", this).a(paramBundle);
  }
  
  public void a(FriendResponseInfo paramFriendResponseInfo) {}
  
  public void a(Exception paramException) {}
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.SmartHardwareActivity.FriendsManager
 * JD-Core Version:    0.7.0.1
 */