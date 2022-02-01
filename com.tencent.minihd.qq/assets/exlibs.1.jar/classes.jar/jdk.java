import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate.WebJsInfo;
import java.util.Queue;

public final class jdk
  extends Thread
{
  public void run()
  {
    for (;;)
    {
      if ((VipWebViewReportLog.a() == VipWebViewReportLog.b()) && (!VipWebViewReportLog.jdField_a_of_type_Boolean)) {
        return;
      }
      synchronized (VipWebViewReportLog.a())
      {
        PreloadInfoCheckUpdate.WebJsInfo localWebJsInfo = (PreloadInfoCheckUpdate.WebJsInfo)VipWebViewReportLog.jdField_a_of_type_JavaUtilQueue.poll();
        if (localWebJsInfo != null) {
          VipWebViewReportLog.a(localWebJsInfo);
        }
        int i = VipWebViewReportLog.jdField_a_of_type_JavaUtilQueue.size();
        if (i > 0) {}
      }
      try
      {
        VipWebViewReportLog.a().wait();
        continue;
        localObject = finally;
        throw localObject;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jdk
 * JD-Core Version:    0.7.0.1
 */