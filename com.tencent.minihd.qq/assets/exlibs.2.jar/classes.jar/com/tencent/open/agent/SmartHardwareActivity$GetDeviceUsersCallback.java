package com.tencent.open.agent;

import android.os.Handler;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SmartHardwareActivity$GetDeviceUsersCallback
  implements HttpCgiAsyncTask.Callback
{
  public SmartHardwareActivity$GetDeviceUsersCallback(SmartHardwareActivity paramSmartHardwareActivity) {}
  
  public void a(Exception paramException)
  {
    LogUtility.c("SmartHardwareActivity", "GetDeviceUsersCallback exception");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    ToastUtil.a().a(2131362637);
    this.a.finish();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogUtility.a("SmartHardwareActivity", "GetDeviceUsersCallback success");
    int j = paramJSONObject.optInt("code", -1);
    if (j != 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      ToastUtil.a().a(2131362636);
      LogUtility.c("SmartHardwareActivity", "get_authorize_member_failed:" + paramJSONObject);
      this.a.finish();
    }
    for (;;)
    {
      SmartDeviceReport.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Get_Sharelist", 0, j, this.a.f);
      return;
      try
      {
        paramJSONObject.getJSONObject("device_info");
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        paramJSONObject = paramJSONObject.getJSONArray("frdlist");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          if (localJSONObject.optInt("is_din_admin", 2) != 1)
          {
            Friend localFriend = new Friend();
            localFriend.jdField_a_of_type_JavaLangString = localJSONObject.optString("openid");
            localFriend.b = localJSONObject.optString("nickname");
            localFriend.c = localJSONObject.optString("label");
            if (localJSONObject.has("is_din_admin")) {
              localFriend.jdField_a_of_type_Int = localJSONObject.optInt("is_din_admin");
            }
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localFriend);
          }
          i += 1;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        SmartHardwareActivity.a(this.a).sendEmptyMessage(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.SmartHardwareActivity.GetDeviceUsersCallback
 * JD-Core Version:    0.7.0.1
 */