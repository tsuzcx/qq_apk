package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import drg;
import org.json.JSONObject;

public class ChatSettingForTroop$GetClassChoiceCallBack
  implements HttpCgiAsyncTask.Callback
{
  protected ChatSettingForTroop$GetClassChoiceCallBack(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, paramException.getMessage());
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "result " + paramJSONObject);
    }
    ThreadManager.c(new drg(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.GetClassChoiceCallBack
 * JD-Core Version:    0.7.0.1
 */