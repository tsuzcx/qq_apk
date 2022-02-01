import android.os.Handler;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class daz
  implements HttpCgiAsyncTask.Callback
{
  private daz(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void a(Exception paramException)
  {
    LogUtility.e("IphoneTitleBarActivity", "get msg setting faild exception!");
    ToastUtil.a().a(this.a.getString(2131362338));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogUtility.a("IphoneTitleBarActivity", "GetDevMsgSettingCallback success " + paramJSONObject);
    if (paramJSONObject.optInt("ret", -1) != 0)
    {
      ToastUtil.a().a(this.a.getString(2131362338));
      LogUtility.a("IphoneTitleBarActivity", "msg:" + paramJSONObject.optString("msg"));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new dba(this));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("data");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          day localday = new day(this.a, null);
          localday.jdField_a_of_type_Int = localJSONObject.getInt("id");
          localday.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
          localday.b = localJSONObject.getInt("enable");
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localday);
          i += 1;
        }
      }
      catch (JSONException paramJSONObject)
      {
        LogUtility.e("IphoneTitleBarActivity", "get msg setting json format faild!");
        ToastUtil.a().a(this.a.getString(2131362338));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     daz
 * JD-Core Version:    0.7.0.1
 */