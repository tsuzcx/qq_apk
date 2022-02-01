import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.ShareToQZone;
import com.tencent.qphone.base.util.QLog;

public final class cee
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(ShareToQZone.jdField_a_of_type_JavaLangString, 2, "======httpThread:run =========");
    }
    int i = ShareToQZone.a();
    Message localMessage = ShareToQZone.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.arg1 = i;
    ShareToQZone.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    ShareToQZone.jdField_a_of_type_AndroidOsHandler.removeCallbacks(ShareToQZone.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cee
 * JD-Core Version:    0.7.0.1
 */