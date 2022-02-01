import android.os.Process;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.qphone.base.util.QLog;

public class hjk
  implements Runnable
{
  public hjk(EmoticonManagerImp paramEmoticonManagerImp, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      Thread.sleep(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Boolean) {
        EmoticonManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerImp", 2, "asyncReloadEmoticonKeyword,isChanged=" + this.jdField_a_of_type_Boolean);
      }
      EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp);
      this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(-1);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hjk
 * JD-Core Version:    0.7.0.1
 */