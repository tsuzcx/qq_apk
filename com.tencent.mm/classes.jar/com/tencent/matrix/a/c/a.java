package com.tencent.matrix.a.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public final class a
{
  private static String bNv = null;
  private static String sPackageName = null;
  
  public static String getPackageName()
  {
    return sPackageName;
  }
  
  public static String getProcessName()
  {
    return bNv;
  }
  
  public static String getThrowableStack(Throwable paramThrowable)
  {
    Object localObject = paramThrowable.getStackTrace();
    if (localObject == null) {
      return "";
    }
    paramThrowable = new ArrayList(localObject.length);
    int i = 0;
    while (i < localObject.length)
    {
      String str = localObject[i].getClassName();
      if ((!str.contains("com.tencent.matrix")) && (!str.contains("java.lang.reflect")) && (!str.contains("$Proxy2")) && (!str.contains("android.os"))) {
        paramThrowable.add(localObject[i]);
      }
      i += 1;
    }
    if ((paramThrowable.size() > 10) && (sPackageName != null))
    {
      localObject = paramThrowable.listIterator(paramThrowable.size());
      do
      {
        if (!((ListIterator)localObject).hasPrevious()) {
          break;
        }
        if (!((StackTraceElement)((ListIterator)localObject).previous()).getClassName().contains(sPackageName)) {
          ((ListIterator)localObject).remove();
        }
      } while (paramThrowable.size() > 10);
    }
    localObject = new StringBuffer(paramThrowable.size());
    paramThrowable = paramThrowable.iterator();
    while (paramThrowable.hasNext()) {
      ((StringBuffer)localObject).append((StackTraceElement)paramThrowable.next()).append('\n');
    }
    return ((StringBuffer)localObject).toString();
  }
  
  public static void setPackageName(Context paramContext)
  {
    if (sPackageName == null) {
      sPackageName = paramContext.getPackageName();
    }
  }
  
  public static void setProcessName(String paramString)
  {
    bNv = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.c.a
 * JD-Core Version:    0.7.0.1
 */