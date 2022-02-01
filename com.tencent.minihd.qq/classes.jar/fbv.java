import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.qphone.base.util.QLog;

public class fbv
  implements QQTabWidget.onTabWidgetTouchMoveListener
{
  public fbv(SplashActivity paramSplashActivity) {}
  
  public void a()
  {
    int i = GesturePWDUtils.getGesturePWDState(this.a, this.a.app.a());
    int j = GesturePWDUtils.getGesturePWDMode(this.a, this.a.app.a());
    if ((i == 2) && (j == 20))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mainactivity", 2, "gesturepwd manual move.");
      }
      SplashActivity.b(this.a);
      this.a.overridePendingTransition(2130968595, 2130968592);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     fbv
 * JD-Core Version:    0.7.0.1
 */