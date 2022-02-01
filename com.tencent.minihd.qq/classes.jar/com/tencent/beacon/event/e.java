package com.tencent.beacon.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class e
  implements Cloneable
{
  private int a = 12;
  private int b = 60;
  private int c = 12;
  private int d = 60;
  private int e = 20;
  private int f = 2097152;
  private int g = 60;
  private int h = 600;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  private int l = 30;
  private boolean m = true;
  private boolean n = true;
  private Set<String> o = null;
  private Map<String, Float> p = null;
  private boolean q = false;
  private int r = 600;
  private boolean s = false;
  private int t = 25;
  private int u = 600;
  
  private void a(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.a = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.b = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.d = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.e = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f(int paramInt)
  {
    if (paramInt > 0) {}
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private e t()
  {
    try
    {
      e locale = new e();
      locale.d(this.d);
      locale.c(this.c);
      locale.e(this.e);
      locale.f(this.f);
      locale.b(this.b);
      locale.a(this.a);
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int a()
  {
    try
    {
      int i1 = this.a;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if (paramMap != null) {}
    for (;;)
    {
      String str;
      try
      {
        str = (String)paramMap.get("realNumUp");
        int i1;
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 > 0) && (i1 <= 50)) {
            this.a = i1;
          }
        }
        str = (String)paramMap.get("realDelayUp");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 10) && (i1 <= 600)) {
            this.b = i1;
          }
        }
        str = (String)paramMap.get("comNumDB");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 > 0) && (i1 <= 50)) {
            this.c = i1;
          }
        }
        str = (String)paramMap.get("comDelayDB");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 60) && (i1 <= 600)) {
            this.d = i1;
          }
        }
        str = (String)paramMap.get("comNumUp");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 > 0) && (i1 <= 100)) {
            this.e = i1;
          }
        }
        str = (String)paramMap.get("dailyNetFlowLimit");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 204800) && (i1 <= 10485760)) {
            this.f = i1;
          }
        }
        str = (String)paramMap.get("runInfoPeriod");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 30) && (i1 <= 300)) {
            this.g = i1;
          }
        }
        str = (String)paramMap.get("useTimeUpPeriod");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 300) && (i1 <= 1800)) {
            this.h = i1;
          }
        }
        str = (String)paramMap.get("useTimeOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            continue;
          }
          this.i = true;
        }
        str = (String)paramMap.get("proChangePeriod");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 10) && (i1 <= 300)) {
            this.l = i1;
          }
        }
        str = (String)paramMap.get("proChangeOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label953;
          }
          this.m = true;
        }
        str = (String)paramMap.get("heartOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label973;
          }
          this.n = true;
        }
        str = (String)paramMap.get("appLogUploadOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label993;
          }
          str = (String)paramMap.get("appLogRealTimeUpload");
          if ((str != null) && (!str.toLowerCase().equals("y"))) {
            str.toLowerCase().equals("n");
          }
          str = (String)paramMap.get("appLogOutDay");
          if (str != null) {
            Long.valueOf(str).longValue();
          }
          if ((String)paramMap.get("logDailyConsumeLimit") != null) {
            Integer.valueOf(str).intValue();
          }
          str = (String)paramMap.get("appLogSizeLimit");
          if (str != null) {
            Integer.valueOf(str).intValue();
          }
          str = (String)paramMap.get("appLogRecordMax");
          if (str != null) {
            Integer.valueOf(str).intValue();
          }
          str = (String)paramMap.get("appLogFileTotalMaxSize");
          if (str != null) {
            Integer.valueOf(str).intValue();
          }
        }
        str = (String)paramMap.get("appNetConOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label1006;
          }
          this.q = true;
        }
        str = (String)paramMap.get("netConQuePeriod");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 60) && (i1 <= 1200)) {
            this.r = i1;
          }
        }
        str = (String)paramMap.get("memOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label1026;
          }
          this.j = true;
        }
        str = (String)paramMap.get("cpuOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label1046;
          }
          this.k = true;
        }
        str = (String)paramMap.get("heatmapOnOff");
        if (str != null)
        {
          if (!str.toLowerCase().equals("y")) {
            break label1066;
          }
          this.s = true;
        }
        str = (String)paramMap.get("heatmapUpMax");
        if (str != null)
        {
          i1 = Integer.valueOf(str).intValue();
          if ((i1 >= 10) && (i1 <= 500)) {
            this.t = i1;
          }
        }
        paramMap = (String)paramMap.get("netConQuePeriod");
        if (paramMap != null)
        {
          i1 = Integer.valueOf(paramMap).intValue();
          if ((i1 >= 300) && (i1 <= 1800)) {
            this.u = i1;
          }
        }
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
        continue;
      }
      finally {}
      return;
      label1026:
      label1046:
      label1066:
      if (str.toLowerCase().equals("n"))
      {
        this.i = false;
        continue;
        label953:
        if (str.toLowerCase().equals("n"))
        {
          this.m = false;
          continue;
          label973:
          if (str.toLowerCase().equals("n"))
          {
            this.n = false;
            continue;
            label993:
            str.toLowerCase().equals("n");
            continue;
            label1006:
            if (str.toLowerCase().equals("n"))
            {
              this.q = false;
              continue;
              if (str.toLowerCase().equals("n"))
              {
                this.j = false;
                continue;
                if (str.toLowerCase().equals("n"))
                {
                  this.k = false;
                  continue;
                  if (str.toLowerCase().equals("n")) {
                    this.s = false;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(Set<String> paramSet)
  {
    try
    {
      this.o = paramSet;
      return;
    }
    finally
    {
      paramSet = finally;
      throw paramSet;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = false;
  }
  
  public final boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.o != null)
      {
        bool1 = bool2;
        if (this.o.size() > 0) {
          bool1 = this.o.contains(paramString);
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public final int b()
  {
    try
    {
      int i1 = this.b;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(Set<String> paramSet)
  {
    try
    {
      if (this.p == null) {
        this.p = new HashMap();
      }
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String[] arrayOfString = ((String)paramSet.next()).split(",");
        int i1 = arrayOfString.length;
        if (i1 == 3) {
          try
          {
            float f1 = Float.valueOf(arrayOfString[1]).floatValue() / Float.valueOf(arrayOfString[2]).floatValue();
            this.p.put(arrayOfString[0].toLowerCase(), Float.valueOf(f1));
          }
          catch (Exception localException) {}
        }
      }
      return;
    }
    finally {}
  }
  
  public final boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (this.p != null)
        {
          Object localObject = this.p.get(paramString);
          if (localObject != null) {}
        }
        else
        {
          bool = true;
          return bool;
        }
        int i1 = (int)(((Float)this.p.get(paramString.toLowerCase())).floatValue() * 1000.0F);
        int i2 = new Random().nextInt(1000);
        if (i2 + 1 > i1) {
          bool = false;
        } else {
          bool = true;
        }
      }
      finally {}
    }
  }
  
  public final int c()
  {
    try
    {
      int i1 = this.c;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int d()
  {
    try
    {
      int i1 = this.d;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int e()
  {
    try
    {
      int i1 = this.e;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int f()
  {
    try
    {
      int i1 = this.f;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int g()
  {
    try
    {
      int i1 = this.h;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int h()
  {
    return this.g;
  }
  
  public final boolean i()
  {
    return this.i;
  }
  
  public final int j()
  {
    return this.l;
  }
  
  public final boolean k()
  {
    return this.m;
  }
  
  public final boolean l()
  {
    return this.n;
  }
  
  public final boolean m()
  {
    return this.q;
  }
  
  public final int n()
  {
    return this.r;
  }
  
  public final boolean o()
  {
    return this.k;
  }
  
  public final boolean p()
  {
    return this.j;
  }
  
  public final boolean q()
  {
    return this.s;
  }
  
  public final int r()
  {
    return this.t;
  }
  
  public final int s()
  {
    return this.u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.e
 * JD-Core Version:    0.7.0.1
 */