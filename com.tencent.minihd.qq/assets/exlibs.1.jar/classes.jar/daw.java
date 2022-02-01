import android.os.Bundle;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import mqq.observer.SSOAccountObserver;

public class daw
  extends SSOAccountObserver
{
  public daw(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    LogUtility.e("SSOAccountObserver", "Can't get the V-Key info onFailed!");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    ToastUtil.a().a(this.a.getString(2131362338));
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 131072)
    {
      LogUtility.c("SSOAccountObserver", "get the V-Key info! success");
      this.a.d = new String(paramArrayOfByte);
      paramString = new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/get_lightapp_property", "GET", new daz(this.a, null));
      paramArrayOfByte = new Bundle();
      paramArrayOfByte.putString("vkey", this.a.d);
      paramArrayOfByte.putString("uin", this.a.jdField_a_of_type_JavaLangString);
      paramArrayOfByte.putString("din", this.a.c);
      paramArrayOfByte.putString("pid", this.a.b);
      paramArrayOfByte.putString("appid", "1300000607");
      paramString.a(paramArrayOfByte);
      return;
    }
    LogUtility.e("SSOAccountObserver", "Can't get the V-Key info!");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    ToastUtil.a().a(this.a.getString(2131362338));
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    LogUtility.e("SSOAccountObserver", "Can't get the V-Key info onUserCancel!");
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    ToastUtil.a().a(this.a.getString(2131362338));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     daw
 * JD-Core Version:    0.7.0.1
 */