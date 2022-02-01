import android.os.SystemClock;
import android.util.Printer;
import com.tencent.mobileqq.app.LooperMonitorHelper;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;

public class hkz
  implements Printer
{
  public static final String a = ">>";
  public static final String b = "<<";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = false;
  private long b;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  
  private static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (!paramString.startsWith(">>>"))) {
      return null;
    }
    int i = paramString.indexOf('(');
    if (i == -1) {
      return null;
    }
    int j = paramString.indexOf(')', i);
    if (j == -1) {
      return null;
    }
    String str1 = paramString.substring(i + 1, j);
    int k = paramString.indexOf("} ", j);
    if (k == -1) {
      return null;
    }
    j = paramString.indexOf('@', k + 2);
    i = j;
    if (j == -1)
    {
      j = paramString.indexOf(':', k + 2);
      i = j;
      if (j == -1)
      {
        i = paramString.indexOf(' ', k + 2);
        if (i == -1) {
          break label150;
        }
      }
    }
    String str2 = paramString.substring(k + 2, i);
    i = paramString.indexOf(": ", i);
    if (i == -1)
    {
      return null;
      label150:
      return null;
    }
    return String.format("%s|%s|%s", new Object[] { str1, str2, paramString.substring(i + 2) });
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoMonitor", 2, "setting threshold, threshold=" + paramInt);
    }
    LooperMonitorHelper.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_c_of_type_JavaLangString = paramString;
      if (UnifiedMonitor.a().d) {
        UnifiedMonitor.a().b();
      }
    }
    long l;
    String str;
    do
    {
      do
      {
        return;
      } while ((this.jdField_c_of_type_Long == 0L) || (!paramString.startsWith("<<")));
      this.jdField_a_of_type_Long += 1L;
      l = SystemClock.uptimeMillis() - this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = 0L;
      this.b += l;
      if (l <= LooperMonitorHelper.jdField_a_of_type_Int) {
        break;
      }
      if (!UnifiedMonitor.a().a(0))
      {
        this.jdField_a_of_type_Int = 0;
        return;
      }
      str = a(this.jdField_c_of_type_JavaLangString);
      UnifiedMonitor.a().a(0, str, (int)l, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = 0;
    } while ((!QLog.isColorLevel()) || ((!paramString.contains("com.tencent")) && (!paramString.contains("qq"))));
    QLog.d("AutoMonitor", 2, "MainLooper, cost=" + l + ", " + str);
    return;
    if (UnifiedMonitor.a().d) {
      UnifiedMonitor.a().c();
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public String toString()
  {
    return super.toString() + "(msgCount = " + this.jdField_a_of_type_Long + ", totalCost = " + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hkz
 * JD-Core Version:    0.7.0.1
 */