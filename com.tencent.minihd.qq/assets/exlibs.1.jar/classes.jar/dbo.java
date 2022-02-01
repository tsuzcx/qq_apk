import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.LightAppUtil.GETLightAppSettingCallBack;
import com.tencent.device.utils.LightAppUtil.GetLightAppSettingListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.SSOAccountObserver;

public class dbo
  extends SSOAccountObserver
{
  public dbo(LightAppUtil paramLightAppUtil) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    if (QLog.isColorLevel()) {
      QLog.d("LightAppUtil", 2, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (this.a.jdField_a_of_type_AndroidAppActivity != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
      this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    int i = 0;
    if (paramInt == 4096)
    {
      paramBundle = new String(paramArrayOfByte);
      if (TextUtils.isEmpty(paramBundle)) {
        break label211;
      }
      LogUtility.d("LightAppUtil", "end getSkey");
      paramString = new HttpCgiAsyncTask("https://fusionbase.qzone.qq.com/cgi-bin/appstage/get_lightapp_info", "GET", new LightAppUtil.GETLightAppSettingCallBack(this.a));
      paramArrayOfByte = new Bundle();
      paramArrayOfByte.putString("skey", paramBundle);
      paramArrayOfByte.putString("uin", this.a.e);
      paramBundle = new StringBuilder();
      if (this.a.b != null)
      {
        paramInt = i;
        while (paramInt < this.a.b.size())
        {
          paramBundle.append(this.a.b.get(paramInt));
          if (paramInt != this.a.b.size() - 1) {
            paramBundle.append(",");
          }
          paramInt += 1;
        }
      }
      paramArrayOfByte.putString("pids", paramBundle.toString());
      paramString.a(paramArrayOfByte);
    }
    label211:
    while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (this.a.jdField_a_of_type_AndroidAppActivity == null) || (this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("code");
    if (QLog.isColorLevel()) {
      QLog.d("LightAppUtil", 2, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : on_user_cancel | code: " + paramInt);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (this.a.jdField_a_of_type_AndroidAppActivity != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
      this.a.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbo
 * JD-Core Version:    0.7.0.1
 */