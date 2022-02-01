import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public final class cbu
  implements Runnable
{
  public cbu(QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "RedTouchExManager_GetTime", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_get_time", System.currentTimeMillis() / 1000L);
      ((SharedPreferences.Editor)localObject).putLong("interval_time", this.jdField_a_of_type_Long);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cbu
 * JD-Core Version:    0.7.0.1
 */