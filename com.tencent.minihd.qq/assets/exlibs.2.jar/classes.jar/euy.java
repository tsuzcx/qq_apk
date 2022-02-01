import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class euy
  implements Runnable
{
  public euy(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.a.getSharedPreferences("SecurityDetectActivity", 0);
    long l1 = localSharedPreferences.getLong("PimscureStatus" + this.a.app.getAccount(), 2L);
    long l2 = localSharedPreferences.getLong("AccountStatus" + this.a.app.getAccount(), 1L);
    long l3 = localSharedPreferences.getLong("LastDetectTime" + this.a.app.getAccount(), 0L);
    boolean bool = SettingCloneUtil.readValue(this.a, null, "security_scan_key", "qqsetting_security_scan_key", false);
    if (System.currentTimeMillis() - l3 < 604800000L) {
      this.a.runOnUiThread(new euz(this, l2, l1, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     euy
 * JD-Core Version:    0.7.0.1
 */