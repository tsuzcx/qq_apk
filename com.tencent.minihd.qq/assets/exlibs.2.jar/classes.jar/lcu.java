import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.agent.report.ReportCenter;

public class lcu
  extends Handler
{
  public lcu(ReportCenter paramReportCenter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      ReportCenter localReportCenter = this.a;
      if (paramMessage.obj == null) {}
      for (String str = null;; str = (String)paramMessage.obj)
      {
        localReportCenter.a(str);
        break;
      }
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lcu
 * JD-Core Version:    0.7.0.1
 */