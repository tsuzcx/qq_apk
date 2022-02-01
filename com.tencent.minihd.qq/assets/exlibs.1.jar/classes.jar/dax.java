import android.widget.CompoundButton;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class dax
  implements HttpCgiAsyncTask.Callback
{
  private int jdField_a_of_type_Int;
  private CompoundButton jdField_a_of_type_AndroidWidgetCompoundButton;
  
  public dax(DeviceMsgSettingActivity paramDeviceMsgSettingActivity, int paramInt, CompoundButton paramCompoundButton)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetCompoundButton = paramCompoundButton;
  }
  
  public void a(Exception paramException)
  {
    paramException = this.jdField_a_of_type_AndroidWidgetCompoundButton;
    if (!this.jdField_a_of_type_AndroidWidgetCompoundButton.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramException.setChecked(bool);
      ToastUtil.a().a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDeviceMsgSettingActivity.getString(2131362340));
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDeviceMsgSettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    int j = 1;
    if (paramJSONObject.optInt("ret", -1) == 0)
    {
      paramJSONObject = this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDeviceMsgSettingActivity.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramJSONObject.hasNext())
      {
        localObject = (day)paramJSONObject.next();
        if (((day)localObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int)
        {
          if (this.jdField_a_of_type_AndroidWidgetCompoundButton.isChecked()) {}
          for (i = 1;; i = 0)
          {
            ((day)localObject).b = i;
            break;
          }
        }
      }
      paramJSONObject = this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDeviceMsgSettingActivity.app;
      int i = j;
      if (this.jdField_a_of_type_AndroidWidgetCompoundButton.isChecked()) {
        i = 2;
      }
      SmartDeviceReport.a(paramJSONObject, "Usr_MsgMgr_Setting", i, 0, DeviceMsgSettingActivity.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDeviceMsgSettingActivity).productId);
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDeviceMsgSettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetCompoundButton;
    if (!this.jdField_a_of_type_AndroidWidgetCompoundButton.isChecked()) {}
    for (;;)
    {
      ((CompoundButton)localObject).setChecked(bool);
      LogUtility.a("IphoneTitleBarActivity", "msg:" + paramJSONObject.optString("msg"));
      ToastUtil.a().a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDeviceMsgSettingActivity.getString(2131362340));
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dax
 * JD-Core Version:    0.7.0.1
 */