import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class fcb
  implements Runnable
{
  public fcb(SplashActivity paramSplashActivity, int paramInt) {}
  
  public void run()
  {
    SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
    String str = SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
    if ((SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity) != null) && (SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity).getBoolean("theme_voice_setting_" + this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(), true))) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(this.jdField_a_of_type_Int + 1);
    }
    if (str != null)
    {
      SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, "消息", str);
      SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, "联系人", str);
      SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, "动态", str);
      SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, "发现", str);
      SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, "电话", str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     fcb
 * JD-Core Version:    0.7.0.1
 */