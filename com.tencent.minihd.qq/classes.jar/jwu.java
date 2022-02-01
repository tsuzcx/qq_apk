import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class jwu
  extends Handler
{
  static final int jdField_a_of_type_Int = 0;
  
  public jwu(UnifiedMonitor paramUnifiedMonitor, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(HashMap paramHashMap, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UnifiedMonitor", 4, "addEvent, num=" + paramInt + ", extra=" + Arrays.toString(paramHashMap.entrySet().toArray()));
    }
    StatisticCollector.a(BaseApplicationImpl.a()).a(null, "unifiedMonitor", true, paramInt, 0L, paramHashMap, null);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramMessage.obj == null);
      try
      {
        a((HashMap)paramMessage.obj, paramMessage.arg1);
        return;
      }
      catch (Throwable paramMessage) {}
    } while (!QLog.isColorLevel());
    paramMessage.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwu
 * JD-Core Version:    0.7.0.1
 */