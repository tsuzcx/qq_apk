import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.RecentSaidActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ewb
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public ewb(RecentSaidActivity paramRecentSaidActivity) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.a();
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.a.obtainMessage(0, localList);
    localMessage.arg1 = this.jdField_a_of_type_Int;
    if ((localList == null) || (localList.isEmpty())) {
      localMessage.arg2 = 11;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.a.sendMessage(localMessage);
      return;
      localMessage.arg2 = 10;
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        QLog.d("Recent Said", 2, "More messages loaded. Costs " + (l2 - l1) + " ms.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ewb
 * JD-Core Version:    0.7.0.1
 */