import android.os.Process;
import com.tencent.mobileqq.app.ProcessExitReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class hmz
  extends Thread
{
  public hmz(ProcessExitReceiver paramProcessExitReceiver) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProcessExitReceiver", 2, "Kill process " + MobileQQ.getMobileQQ().getProcessName());
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmz
 * JD-Core Version:    0.7.0.1
 */