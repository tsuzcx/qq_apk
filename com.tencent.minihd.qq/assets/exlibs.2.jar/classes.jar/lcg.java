import android.os.Bundle;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.SmartHardwareActivity;
import com.tencent.open.agent.SmartHardwareActivity.GetDeviceUsersCallback;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import mqq.observer.SSOAccountObserver;

public class lcg
  extends SSOAccountObserver
{
  public lcg(SmartHardwareActivity paramSmartHardwareActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    LogUtility.e("SSOAccountObserver", "get the V-Key info failed ret=" + paramInt2);
    ToastUtil.a().a(2131362638);
    this.a.finish();
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 131072)
    {
      LogUtility.c("SSOAccountObserver", "get the V-Key info! success");
      this.a.f = new String(paramArrayOfByte);
      paramString = new HttpCgiAsyncTask("https://fusion.qq.com/cgi-bin/qzapps/get_device_admin_info", "GET", new SmartHardwareActivity.GetDeviceUsersCallback(this.a));
      this.a.jdField_a_of_type_AndroidOsBundle.putString("vkey", this.a.f);
      paramArrayOfByte = new Bundle();
      paramArrayOfByte.putString("din", this.a.c);
      paramArrayOfByte.putString("appid", this.a.b);
      paramArrayOfByte.putString("openid", this.a.e);
      paramArrayOfByte.putString("vkey", this.a.f);
      paramArrayOfByte.putString("din", this.a.c);
      paramString.a(paramArrayOfByte);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    ToastUtil.a().a(2131362638);
    LogUtility.e("SSOAccountObserver", "Can't get the V-Key info!");
    this.a.finish();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lcg
 * JD-Core Version:    0.7.0.1
 */