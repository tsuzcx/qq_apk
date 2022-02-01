import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import java.util.TimerTask;

public class gof
  extends TimerTask
{
  public gof(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    if (this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper = new MainAcitivityReportHelper(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.m);
    this.a.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.b(localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gof
 * JD-Core Version:    0.7.0.1
 */