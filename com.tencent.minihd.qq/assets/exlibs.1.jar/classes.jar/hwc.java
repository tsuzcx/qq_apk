import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.qphone.base.util.QLog;

public class hwc
  implements Runnable
{
  public hwc(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void run()
  {
    try
    {
      String str = this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this.a.c);
      Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
      localMessage.obj = new Object[] { this.a.c, str };
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(ConditionSearchFriendActivity.a(), 2, "fillLocationData | exception ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hwc
 * JD-Core Version:    0.7.0.1
 */