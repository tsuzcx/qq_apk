import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jwv
  extends Thread
{
  private final int jdField_a_of_type_Int = UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor)[0].jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor.d);
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "java.", "android.", "com.android.", "dalvik.", "com.google", "libcore.", "sun.", "com.qihoo360.", "com.lbe." };
  private final int b = 100000;
  private final int c = 10;
  
  private jwv(UnifiedMonitor paramUnifiedMonitor) {}
  
  private String a()
  {
    int k;
    int j;
    label58:
    label88:
    int i;
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject1 = Looper.getMainLooper().getThread().getStackTrace();
      if (localObject1 != null) {
        break label224;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      Object localObject2;
      String str1;
      String[] arrayOfString;
      int m;
      String str2;
      if (!QLog.isDevelopLevel()) {
        break label214;
      }
      localThrowable.printStackTrace();
    }
    if (k < localObject1.length)
    {
      localObject2 = localObject1[k];
      str1 = localObject2.toString();
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      m = arrayOfString.length;
      j = 0;
      if (j < m)
      {
        str2 = arrayOfString[j];
        if (!localObject2.toString().startsWith(str2)) {
          break label244;
        }
        j = 1;
        break label231;
      }
    }
    else if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      localObject1 = "";
      i -= 1;
      while ((i >= 0) && (i > this.jdField_a_of_type_JavaUtilArrayList.size() - 1 - this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor.d))
      {
        localObject1 = (String)localObject1 + (String)this.jdField_a_of_type_JavaUtilArrayList.get(i) + ",";
        i -= 1;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(str1);
      label214:
      label224:
      label231:
      do
      {
        k += 1;
        i = j;
        break;
        return null;
        j = 0;
        break label231;
        return localThrowable;
        k = 0;
        i = 0;
        break;
        if (j == 0) {
          break label251;
        }
        j = i;
      } while (i == 0);
      break label88;
      label244:
      j += 1;
      break label58;
      label251:
      j = i;
      if (i == 0) {
        j = 1;
      }
    }
  }
  
  public void run()
  {
    try
    {
      for (;;)
      {
        sleep(this.jdField_a_of_type_Int);
        label8:
        if (UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor) != 0L)
        {
          long l = SystemClock.uptimeMillis() - UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor) - UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor)[0].jdField_a_of_type_Int;
          if (l <= 100000L)
          {
            if (l < -10L) {
              l = -l;
            }
            try
            {
              sleep(l);
              l = SystemClock.uptimeMillis() - UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor);
              if ((l >= UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor)[0].jdField_a_of_type_Int - 10) && (l <= 100000L))
              {
                UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor, a());
                UnifiedMonitor.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor, 0L);
              }
            }
            catch (InterruptedException localInterruptedException1) {}
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      break label8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwv
 * JD-Core Version:    0.7.0.1
 */