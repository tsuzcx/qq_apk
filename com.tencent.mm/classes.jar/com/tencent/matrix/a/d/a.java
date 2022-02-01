package com.tencent.matrix.a.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public final class a
{
  private static String cvL = null;
  private static String sPackageName = null;
  
  public static String getPackageName()
  {
    return sPackageName;
  }
  
  public static String getProcessName()
  {
    return cvL;
  }
  
  public static String getThrowableStack(Throwable paramThrowable)
  {
    return stackTraceToString(paramThrowable.getStackTrace());
  }
  
  public static void setPackageName(Context paramContext)
  {
    if (sPackageName == null) {
      sPackageName = paramContext.getPackageName();
    }
  }
  
  public static void setProcessName(String paramString)
  {
    cvL = paramString;
  }
  
  public static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement == null) {
      return "";
    }
    Object localObject = new ArrayList(paramArrayOfStackTraceElement.length);
    int i = 0;
    while (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if ((!str.contains("com.tencent.matrix")) && (!str.contains("java.lang.reflect")) && (!str.contains("$Proxy2")) && (!str.contains("android.os"))) {
        ((ArrayList)localObject).add(paramArrayOfStackTraceElement[i]);
      }
      i += 1;
    }
    if ((((ArrayList)localObject).size() > 10) && (sPackageName != null))
    {
      paramArrayOfStackTraceElement = ((ArrayList)localObject).listIterator(((ArrayList)localObject).size());
      do
      {
        if (!paramArrayOfStackTraceElement.hasPrevious()) {
          break;
        }
        if (!((StackTraceElement)paramArrayOfStackTraceElement.previous()).getClassName().contains(sPackageName)) {
          paramArrayOfStackTraceElement.remove();
        }
      } while (((ArrayList)localObject).size() > 10);
    }
    paramArrayOfStackTraceElement = new StringBuffer(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfStackTraceElement.append((StackTraceElement)((Iterator)localObject).next()).append('\n');
    }
    return paramArrayOfStackTraceElement.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.d.a
 * JD-Core Version:    0.7.0.1
 */