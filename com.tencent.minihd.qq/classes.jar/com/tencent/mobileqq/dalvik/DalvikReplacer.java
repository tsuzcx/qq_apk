package com.tencent.mobileqq.dalvik;

import android.content.Context;
import android.os.Build.VERSION;

public class DalvikReplacer
{
  public static final int a = 8;
  public static final long a = 0L;
  private static String a = DalvikReplacer.class.getSimpleName();
  public static final int b = 9;
  public static final long b = 1L;
  public static final int c = 5242880;
  public static final long c = 2L;
  public static final int d = 8388608;
  public static final long d = 3L;
  public static final int e = 16777216;
  public static final long e = 4L;
  private static final int f = 4096;
  public static final long f = 5L;
  public static final long g = 6L;
  public static final long h = 7L;
  private static long i = 8L;
  
  private static int a()
  {
    int j = Build.VERSION.SDK_INT;
    if (j < 11) {
      return 5242880;
    }
    if (j < 16) {
      return 8388608;
    }
    return 16777216;
  }
  
  public static long a()
  {
    return i;
  }
  
  public static long a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt);
    return i;
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    i = 9L;
    DalvikInternals.a(paramContext);
    if (DalvikInternals.a) {
      try
      {
        l = b();
        if (l <= 0L) {
          return;
        }
      }
      catch (Exception paramContext)
      {
        long l;
        do
        {
          for (;;)
          {
            i = 6L;
            l = 0L;
          }
          try
          {
            l = DalvikInternals.replace(l, paramInt, 4096);
            if (l == 1L)
            {
              i = 0L;
              return;
            }
          }
          catch (Exception paramContext)
          {
            i = 7L;
            return;
          }
          if (l == 0L)
          {
            i = 2L;
            return;
          }
        } while (l >= 0L);
        i = l;
        return;
      }
    }
    i = 5L;
  }
  
  public static boolean a(int paramInt)
  {
    return (i != 0L) && (i != 9L) && (a() < paramInt);
  }
  
  private static long b()
  {
    Object localObject = new MappingReader();
    long[] arrayOfLong = ((MappingReader)localObject).a();
    int j;
    Mapping localMapping;
    long l1;
    switch (Build.VERSION.SDK_INT)
    {
    default: 
      j = 0;
      localMapping = ((MappingReader)localObject).a("LinearAlloc");
      if (localMapping == null)
      {
        i = 3L;
        l1 = 0L;
      }
      break;
    }
    long l2;
    do
    {
      return l1;
      j = 20;
      break;
      j = 24;
      break;
      localObject = ((MappingReader)localObject).a("[heap]");
      long l3 = 0L;
      long l4 = 0L;
      l2 = l3;
      l1 = l4;
      if (localObject != null)
      {
        l2 = l3;
        l1 = l4;
        if (((Mapping)localObject).a())
        {
          l2 = ((Mapping)localObject).a();
          l1 = ((Mapping)localObject).b();
        }
      }
      l2 = DalvikInternals.find(arrayOfLong, 704, 1480, j, 3, 524288, 16777216, l2, l1, 5242880, 16777216, 4100, localMapping.a());
      if (l2 == 0L) {
        i = 1L;
      }
      l1 = l2;
    } while (l2 >= 0L);
    i = l2;
    return l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.DalvikReplacer
 * JD-Core Version:    0.7.0.1
 */