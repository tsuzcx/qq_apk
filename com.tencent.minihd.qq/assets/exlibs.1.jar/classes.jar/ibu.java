import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import mqq.app.MobileQQ;

public class ibu
  implements Runnable
{
  public ibu(DatingManager paramDatingManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.a.getApplication().getSharedPreferences(this.a.a.a(), 0).edit();
    localEditor.putString("inprocess_dating_id", DatingManager.a(this.a));
    localEditor.commit();
    DatingUtil.a("saveInProcessDatingId", new Object[] { DatingManager.a(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibu
 * JD-Core Version:    0.7.0.1
 */