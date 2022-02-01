import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.recent.Banner;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.qphone.base.util.QLog;

public class gun
  implements View.OnClickListener
{
  public gun(BannerManager paramBannerManager, View paramView, int paramInt, FrameLayout paramFrameLayout, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = (PushBanner)paramView.getTag();
    Object localObject;
    if (paramView != null)
    {
      localObject = BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).app.getAccount();
      ReportController.b(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).app, "CliOper", "", (String)localObject, "Push_Banner", "Click_Banner", 0, 0, "", "", "", "");
      ReportController.b(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).app, "CliOper", "", "", "0X80060C5", "0X80060C5", 0, 0, "", "", paramView.m, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "0X80060C5: md5 = " + paramView.m);
      }
      paramView.a.a();
      ADView localADView = (ADView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297804);
      if (localADView != null)
      {
        if (localADView.a(0) <= 1) {
          break label234;
        }
        localADView.a(0, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
    }
    for (;;)
    {
      ThreadManager.a().post(new guo(this, paramView));
      Config.a.b(this.jdField_a_of_type_JavaLangString);
      paramView = new ConfigManager(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).getApplicationContext(), ConfigServlet.d);
      if (paramView != null)
      {
        paramView.b();
        paramView.c();
      }
      return;
      label234:
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + (String)localObject, false).commit();
      localObject = BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager)[13];
      if ((localObject != null) && (((Banner)localObject).jdField_a_of_type_AndroidViewView != null))
      {
        localObject = (ADView)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131297804);
        if (localObject != null) {
          ((ADView)localObject).a();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(13, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gun
 * JD-Core Version:    0.7.0.1
 */