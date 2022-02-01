import android.os.Bundle;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class euw
  extends GameCenterObserver
{
  public euw(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QQSettingSettingActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     euw
 * JD-Core Version:    0.7.0.1
 */