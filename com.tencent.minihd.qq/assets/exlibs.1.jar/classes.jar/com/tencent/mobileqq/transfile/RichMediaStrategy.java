package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;

public class RichMediaStrategy
{
  public static final int a = 2;
  public static RichMediaStrategy.NetPolicy a = new RichMediaStrategy.G2();
  public static final int b = 9;
  public static RichMediaStrategy.NetPolicy b = new RichMediaStrategy.G3();
  public static final int c = 3;
  public static RichMediaStrategy.NetPolicy c = new RichMediaStrategy.WIFI();
  public static final int d = 480000;
  public static final int e = 25;
  public static final int f = 450000;
  public static final int g = 2;
  public static final int h = 90000;
  public static final int i = 89500;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 5;
  
  public static int a(int paramInt)
  {
    int m = paramInt;
    if (paramInt == 0) {
      m = 1;
    }
    return (int)(6000 * Math.pow(2.0D, (m - 1) / 2));
  }
  
  public static int a(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    int n = 1;
    int m = 0;
    boolean bool;
    int i1;
    if (!d(paramInt1))
    {
      bool = false;
      i1 = paramNetPolicy.f();
      if (paramInt2 != 0) {
        break label259;
      }
      paramInt2 = n;
    }
    label259:
    for (;;)
    {
      n = (int)(i1 * Math.pow(2.0D, (paramInt2 - 1) / 2));
      if (!a(paramInt1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RichMediaStrategy", 2, "policy:" + paramNetPolicy.getClass().getSimpleName() + " errCode:" + paramInt1 + " tryCount:" + paramInt2 + " elapse:" + paramLong + "isGroup:" + paramBoolean + " flowTimes:" + paramInt3 + " canRetry:" + bool + " sleeptime:" + m);
        }
        if (bool)
        {
          return m;
          if (paramInt2 < paramNetPolicy.c())
          {
            bool = true;
            break;
          }
          if (paramInt2 >= paramNetPolicy.b())
          {
            bool = false;
            break;
          }
          if (paramBoolean)
          {
            if ((paramInt3 < 3) && (paramLong < paramNetPolicy.a()))
            {
              bool = true;
              break;
            }
            bool = false;
            break;
          }
          if (paramLong < paramNetPolicy.a())
          {
            bool = true;
            break;
          }
          bool = false;
          break;
        }
        return -1;
        m = n;
      }
    }
  }
  
  public static RichMediaStrategy.NetPolicy a(int paramInt)
  {
    RichMediaStrategy.NetPolicy localNetPolicy = a;
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return localNetPolicy;
    case 1: 
    case 5: 
      return c;
    }
    return b;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9052) || (paramInt == 9050) || (paramInt == 9051) || (paramInt == 9054) || (paramInt == 9053) || (paramInt == 9055) || (paramInt == 9014) || (paramInt == 9047)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    int n = 1;
    int m = 0;
    boolean bool;
    int i1;
    if (!d(paramInt1))
    {
      bool = false;
      i1 = paramNetPolicy.f();
      if (paramInt2 != 0) {
        break label278;
      }
      paramInt2 = n;
    }
    label278:
    for (;;)
    {
      n = (int)(i1 * Math.pow(2.0D, (paramInt2 - 1) / 2));
      if (!a(paramInt1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RichMediaStrategy", 2, "policy:" + paramNetPolicy.getClass().getSimpleName() + " errCode:" + paramInt1 + " tryCount:" + paramInt2 + " elapse:" + paramLong + "isGroup:" + paramBoolean + " flowTimes:" + paramInt3 + " canRetry:" + bool + " sleeptime:" + m);
        }
        if ((bool) && (m > 0)) {
          paramLong = m;
        }
        try
        {
          Thread.sleep(paramLong);
          return bool;
        }
        catch (InterruptedException paramNetPolicy)
        {
          paramNetPolicy.printStackTrace();
          return bool;
        }
        if (paramInt2 < paramNetPolicy.c())
        {
          bool = true;
          break;
        }
        if (paramInt2 >= paramNetPolicy.b())
        {
          bool = false;
          break;
        }
        if (paramBoolean)
        {
          if ((paramInt3 < 3) && (paramLong < paramNetPolicy.a()))
          {
            bool = true;
            break;
          }
          bool = false;
          break;
        }
        if (paramLong < paramNetPolicy.a())
        {
          bool = true;
          break;
        }
        bool = false;
        break;
        m = n;
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9052) || (paramInt == 9050) || (paramInt == 9055) || (paramInt == 9053) || (paramInt == 9054) || (paramInt == 9014) || (paramInt == 9051) || (paramInt == 9047) || (paramInt == 9360)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(RichMediaStrategy.NetPolicy paramNetPolicy, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3)
  {
    boolean bool;
    if (!d(paramInt1)) {
      bool = false;
    }
    for (;;)
    {
      int n = paramNetPolicy.f();
      int m = paramInt2;
      if (paramInt2 == 0) {
        m = 1;
      }
      paramInt2 = (int)(n * Math.pow(2.0D, (m - 1) / 2));
      if (!a(paramInt1)) {
        paramInt2 = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaStrategy", 2, "msgDown policy:" + paramNetPolicy.getClass().getSimpleName() + " errCode:" + paramInt1 + " tryCount:" + m + " elapse:" + paramLong + "isGroup:" + paramBoolean + " flowTimes:" + paramInt3 + " canRetry:" + bool + " sleeptime:" + paramInt2);
      }
      if ((bool) && (paramInt2 > 0)) {
        paramLong = paramInt2;
      }
      try
      {
        Thread.sleep(paramLong);
        return bool;
      }
      catch (InterruptedException paramNetPolicy)
      {
        paramNetPolicy.printStackTrace();
      }
      if (paramInt2 < 2) {
        bool = true;
      } else {
        bool = false;
      }
    }
    return bool;
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 9361) || (paramInt == 9037)) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean d(int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 9020) || (paramInt == 9048) || (paramInt == 9042) || (paramInt == 9070) || (paramInt == 9036) || (paramInt == 9063) || (paramInt == 9071) || (paramInt == 9302) || (paramInt == 9072) || (paramInt == 9041) || (paramInt == 9040) || (paramInt == 9037)) {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaStrategy
 * JD-Core Version:    0.7.0.1
 */