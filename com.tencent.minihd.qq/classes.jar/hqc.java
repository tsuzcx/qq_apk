import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;

public final class hqc
  extends Timer
{
  public hqc(String paramString)
  {
    super(paramString);
  }
  
  public void cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ThreadManager", 2, "Can't cancel Global Timer");
    }
  }
  
  public void schedule(TimerTask paramTimerTask, long paramLong)
  {
    try
    {
      super.schedule(paramTimerTask, paramLong);
      return;
    }
    catch (Exception paramTimerTask)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ThreadManager", 2, "timer schedule err", paramTimerTask);
    }
  }
  
  public void schedule(TimerTask paramTimerTask, long paramLong1, long paramLong2)
  {
    try
    {
      super.schedule(paramTimerTask, paramLong1, paramLong2);
      return;
    }
    catch (Exception paramTimerTask)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ThreadManager", 2, "timer schedule2 err", paramTimerTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hqc
 * JD-Core Version:    0.7.0.1
 */