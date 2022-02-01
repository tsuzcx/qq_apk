package cooperation.qzone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mbf;
import mqq.app.AppRuntime;

public class QZoneVideoDownloadActivity
  extends IphoneTitleBarActivity
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public static final String a;
  private static String jdField_b_of_type_JavaLangString = "https://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover.png";
  Handler jdField_a_of_type_AndroidOsHandler = new mbf(this);
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = QZoneVideoDownloadActivity.class.getSimpleName();
  }
  
  private void a()
  {
    setTitle("短视频");
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131302461));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302460));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131302462));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL(jdField_b_of_type_JavaLangString);
  }
  
  private void b()
  {
    if (getAppRuntime() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "startQZoneVideo, getAppRunime is null");
      }
      Toast.makeText(this, "短视频启动失败", 0).show();
      finish();
    }
    QZoneHelper.UserInfo localUserInfo;
    do
    {
      return;
      localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = getAppRuntime().getAccount();
      if (this.jdField_a_of_type_Boolean)
      {
        QZoneHelper.a(this, localUserInfo, 10009, this.jdField_b_of_type_Boolean);
        return;
      }
    } while (!this.jdField_b_of_type_Boolean);
    QZoneHelper.d(this, localUserInfo, 10009);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(-16777216);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      Toast.makeText(getApplicationContext(), "参数错误，无法启动", 1).show();
      return;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if (((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).d()))
    {
      Toast.makeText(getApplicationContext(), "正在通话中，请结束通话后再试", 1).show();
      finish();
      return;
    }
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("support_record", false);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("support_trim", false);
    PluginManagerHelper.getPluginInterface(this, this);
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient = paramPluginManagerClient;
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "do not support network, start directly");
    }
    b();
    if (!NetworkUtil.f(getApplicationContext())) {
      Toast.makeText(this, "网络无连接，请检查你的网络连接", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */