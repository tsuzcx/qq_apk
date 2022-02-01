package com.tencent.component.network.module.report;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.component.network.NetworkManager;
import java.util.ArrayList;
import java.util.Random;

public class BusinessReport
{
  private static long jdField_a_of_type_Long = SystemClock.uptimeMillis();
  private static SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(12);
  private static b jdField_a_of_type_ComTencentComponentNetworkModuleReportB = new b("BusinessReport");
  private static final Object jdField_a_of_type_JavaLangObject;
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  private static volatile boolean jdField_a_of_type_Boolean;
  private static final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[12];
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Boolean = false;
  }
  
  private static ArrayList a()
  {
    return new a();
  }
  
  public static void a()
  {
    int k = 0;
    if (jdField_a_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Boolean) {
        return;
      }
    }
    jdField_a_of_type_Boolean = true;
    int j = 0;
    break label100;
    jdField_a_of_type_AndroidUtilSparseArray.append(j, a());
    break label122;
    label53:
    jdField_a_of_type_AndroidUtilSparseArray.append(j, new ArrayList());
    break label122;
    label70:
    int i;
    while (i < jdField_a_of_type_ArrayOfJavaLangObject.length)
    {
      jdField_a_of_type_ArrayOfJavaLangObject[i] = new Object();
      i += 1;
    }
    return;
    for (;;)
    {
      label100:
      i = k;
      if (j >= 12) {
        break label70;
      }
      if (j == 1) {
        break;
      }
      if (j != 11) {
        break label53;
      }
      break;
      label122:
      j += 1;
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 < 0) || (paramInt1 > 11)) && (paramInt1 % 2 != 0)) {}
    int i;
    ArrayList localArrayList1;
    do
    {
      do
      {
        return;
      } while (((paramInt2 != 0) && (paramInt2 != 1)) || (!NetworkManager.d()));
      i = paramInt1 + paramInt2;
      localArrayList1 = (ArrayList)jdField_a_of_type_AndroidUtilSparseArray.get(i);
    } while (localArrayList1.isEmpty());
    synchronized (jdField_a_of_type_ArrayOfJavaLangObject[i])
    {
      ArrayList localArrayList2 = new ArrayList(localArrayList1);
      if ((i == 1) || (i == 11))
      {
        jdField_a_of_type_AndroidUtilSparseArray.setValueAt(i, a());
        localArrayList1.clear();
        jdField_a_of_type_Long = SystemClock.uptimeMillis();
        jdField_a_of_type_ComTencentComponentNetworkModuleReportB.a(new BusinessReport.ReportRunnable(localArrayList2, paramInt1, paramInt2));
        return;
      }
      jdField_a_of_type_AndroidUtilSparseArray.setValueAt(i, new ArrayList());
    }
  }
  
  public static void a(ReportObj paramReportObj, int paramInt1, int paramInt2)
  {
    if (((paramInt1 < 0) || (paramInt1 > 9)) && (paramInt1 % 2 != 0)) {}
    for (;;)
    {
      return;
      if ((paramInt2 == 0) || (paramInt2 == 1))
      {
        int i = paramInt1 + paramInt2;
        long l1 = SystemClock.uptimeMillis();
        long l2 = jdField_a_of_type_Long;
        ArrayList localArrayList = (ArrayList)jdField_a_of_type_AndroidUtilSparseArray.get(i);
        synchronized (jdField_a_of_type_ArrayOfJavaLangObject[i])
        {
          localArrayList.add(paramReportObj);
          switch (i)
          {
          case 0: 
          case 2: 
          case 3: 
          case 4: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          default: 
            return;
          case 1: 
          case 7: 
          case 11: 
            if ((localArrayList.size() >= 10) || (l1 - l2 >= 600000L))
            {
              a(paramInt1, paramInt2);
              return;
            }
            break;
          }
        }
      }
    }
    a(paramInt1, paramInt2);
  }
  
  private static int b()
  {
    int i = 100;
    int j = com.tencent.component.network.module.base.a.d();
    if (j < 0) {
      i = 5;
    }
    while (j > 100) {
      return i;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.report.BusinessReport
 * JD-Core Version:    0.7.0.1
 */