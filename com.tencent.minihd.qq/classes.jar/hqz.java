import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.CheckPublicAccount;
import com.tencent.qphone.base.util.QLog;

public class hqz
  extends PublicAccountObserver
{
  private hqz(CheckPublicAccount paramCheckPublicAccount) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "PublicAccount onUpdateUserFollowList:" + paramBoolean + " " + paramInt);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      CheckPublicAccount.a(this.a).a.edit().putBoolean("isPublicAccountListOK", true).commit();
      this.a.a(7);
    }
    while (paramInt == 0) {
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hqz
 * JD-Core Version:    0.7.0.1
 */