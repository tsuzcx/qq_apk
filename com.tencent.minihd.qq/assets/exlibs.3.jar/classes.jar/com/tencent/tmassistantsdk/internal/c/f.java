package com.tencent.tmassistantsdk.internal.c;

import com.tencent.tmassistantbase.a.k;

class f
  implements com.tencent.tmassistantbase.network.b
{
  f(e parame) {}
  
  public void a()
  {
    k.c("LogReportManager", "onNetworkChanged,netState:" + com.tencent.tmassistantbase.a.f.m());
    Class[] arrayOfClass = e.e();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(b.class)) {
            b.h().d();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if ((com.tencent.tmassistantbase.a.f.n()) && (com.tencent.tmassistantbase.a.f.m().equalsIgnoreCase("wifi"))) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.c.f
 * JD-Core Version:    0.7.0.1
 */