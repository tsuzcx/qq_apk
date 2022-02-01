import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingManager;
import mqq.app.MobileQQ;

public class ibw
  implements Runnable
{
  public ibw(DatingManager paramDatingManager, appoint_define.LocaleInfo paramLocaleInfo) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a.a(), 0);
    String str = new String(Base64.encode(this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray(), 0));
    localSharedPreferences.edit().putString("publish_dep_local_msg", str).commit();
    long l = System.currentTimeMillis();
    localSharedPreferences.edit().putLong("publish_dep_local_time", l).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibw
 * JD-Core Version:    0.7.0.1
 */