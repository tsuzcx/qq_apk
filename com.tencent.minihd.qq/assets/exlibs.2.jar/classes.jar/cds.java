import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class cds
  extends Thread
{
  cds(cdr paramcdr) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "retry download " + cdq.b(this.a.a));
    }
    if (cdq.b(this.a.a) == 1) {}
    for (;;)
    {
      try
      {
        Thread.sleep(5000L);
        this.a.a.a.sendEmptyMessage(1);
        return;
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
        continue;
      }
      try
      {
        Thread.sleep(10000L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cds
 * JD-Core Version:    0.7.0.1
 */