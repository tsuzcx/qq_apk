package mqq.app;

import com.tencent.qphone.base.util.QLog;

public class CrashHandler
  implements Thread.UncaughtExceptionHandler
{
  private boolean isCrahing;
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      if (this.isCrahing) {
        return;
      }
      this.isCrahing = true;
      paramThread = (MobileQQ)MobileQQ.getContext();
      if (paramThread != null)
      {
        String str = paramThread.getProcessName();
        QLog.e("crash", 1, str + " has crashed.", paramThrowable);
        paramThread.closeAllActivitys();
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.CrashHandler
 * JD-Core Version:    0.7.0.1
 */