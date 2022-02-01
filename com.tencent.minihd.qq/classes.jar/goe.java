import android.content.res.Resources;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import java.util.TimerTask;

public class goe
  extends TimerTask
{
  public goe(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    try
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper = new MainAcitivityReportHelper(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.b(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
      MultiMsgManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app);
      Object localObject = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
      float f = MemoryConfigs.a().a;
      ((MQLruCache)localObject).setLargeSize((int)(j * i * 4 * f));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     goe
 * JD-Core Version:    0.7.0.1
 */