import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class eva
  extends ConfigObserver
{
  public eva(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    QQSettingSettingActivity.a(this.a, paramUpgradeDetailWrapper);
    QQSettingSettingActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eva
 * JD-Core Version:    0.7.0.1
 */