package cooperation.qzone.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TimeCostTrace
{
  public static final String a = "qzone_launch";
  public static HashMap a;
  public static final String b = "qzone_refresh";
  public static final String c = "qzone_refresh_more";
  private long jdField_a_of_type_Long = 0L;
  private Map jdField_a_of_type_JavaUtilMap;
  private long b = 0L;
  private String d;
  
  private TimeCostTrace(String paramString)
  {
    this.d = paramString;
  }
  
  private static long a()
  {
    return SystemClock.uptimeMillis();
  }
  
  public static TimeCostTrace a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    TimeCostTrace localTimeCostTrace2 = (TimeCostTrace)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    TimeCostTrace localTimeCostTrace1 = localTimeCostTrace2;
    if (localTimeCostTrace2 == null)
    {
      localTimeCostTrace1 = new TimeCostTrace(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localTimeCostTrace1);
    }
    return localTimeCostTrace1;
  }
  
  public static void c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    TimeCostTrace localTimeCostTrace;
    do
    {
      return;
      localTimeCostTrace = (TimeCostTrace)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while (localTimeCostTrace == null);
    localTimeCostTrace.b();
    jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public int a()
  {
    int i;
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_Long <= 0L)) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = (int)(a() - this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = 0L;
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d(this.d, 2, "getTimeCost:" + j);
    return j;
  }
  
  public String a()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() <= 0)) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject1 = new StringBuilder();
      localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        int[] arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilMap.get(str);
        if (arrayOfInt != null)
        {
          ((StringBuilder)localObject1).append(str).append(":");
          if (arrayOfInt.length > 0)
          {
            ((StringBuilder)localObject1).append(arrayOfInt[0]);
            ((StringBuilder)localObject1).append(",");
          }
          if (arrayOfInt.length > 1) {
            ((StringBuilder)localObject1).append(arrayOfInt[1]);
          }
          ((StringBuilder)localObject1).append(";");
        }
      }
      localObject2 = ((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d(this.d, 2, "dump step cost detail:" + (String)localObject2);
    return localObject2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = a();
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "TimeCostTrace--markFirst");
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_Long <= 0L));
      i = (int)(a() - this.jdField_a_of_type_Long);
      int[] arrayOfInt2 = (int[])this.jdField_a_of_type_JavaUtilMap.get(paramString);
      int[] arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2 == null)
      {
        arrayOfInt1 = new int[2];
        this.jdField_a_of_type_JavaUtilMap.put(paramString, arrayOfInt1);
      }
      arrayOfInt1[0] = i;
    } while (!QLog.isColorLevel());
    QLog.d(this.d, 2, paramString + " start:" + i);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_Long <= 0L));
      i = (int)(a() - this.jdField_a_of_type_Long);
      int[] arrayOfInt2 = (int[])this.jdField_a_of_type_JavaUtilMap.get(paramString);
      int[] arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2 == null)
      {
        arrayOfInt1 = new int[2];
        this.jdField_a_of_type_JavaUtilMap.put(paramString, arrayOfInt1);
      }
      arrayOfInt1[1] = i;
    } while (!QLog.isColorLevel());
    QLog.d(this.d, 2, paramString + " stop:" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qzone.util.TimeCostTrace
 * JD-Core Version:    0.7.0.1
 */