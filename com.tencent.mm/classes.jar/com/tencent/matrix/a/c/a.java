package com.tencent.matrix.a.c;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public final class a
{
  private static String bnW = null;
  private static String bnX = null;
  
  public static void ag(Context paramContext)
  {
    if (bnW == null) {
      bnW = paramContext.getPackageName();
    }
  }
  
  public static void bw(String paramString)
  {
    bnX = paramString;
  }
  
  public static String getPackageName()
  {
    return bnW;
  }
  
  public static String getProcessName()
  {
    return bnX;
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
    if ((paramThrowable.size() > 10) && (bnW != null))
    {
      localObject = paramThrowable.listIterator(paramThrowable.size());
      do
      {
        if (!((ListIterator)localObject).hasPrevious()) {
          break;
        }
        if (!((StackTraceElement)((ListIterator)localObject).previous()).getClassName().contains(bnW)) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.c.a
 * JD-Core Version:    0.7.0.1
 */