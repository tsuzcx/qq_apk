package com.tencent.mm.flutter.a.a;

import com.tencent.mm.flutter.a;
import com.tencent.mm.flutter.c;
import com.tencent.mm.flutter.e;

public abstract class b
  extends a
{
  public final void a(c paramc)
  {
    String str = paramc.fXI;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new e();
        if (str.equals("androidStartNativeActivity"))
        {
          i = 0;
          continue;
          if (str.equals("androidStartNativeActivityForResult"))
          {
            i = 1;
            continue;
            if (str.equals("androidStartFlutterActivity"))
            {
              i = 2;
              continue;
              if (str.equals("androidFinishActivity"))
              {
                i = 3;
                continue;
                if (str.equals("onNavigationObserverPushRoute"))
                {
                  i = 4;
                  continue;
                  if (str.equals("onNavigationObserverPopRoute")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    paramc.tn("plugin");
    paramc.tn("entry");
    paramc.tn("arguments");
    k(paramc);
    return;
    paramc.tn("plugin");
    paramc.tn("entry");
    paramc.tn("arguments");
    paramc.tn("name");
    ((Integer)paramc.tn("requestCode")).intValue();
    l(paramc);
    return;
    c((String)paramc.tn("route"), paramc);
    return;
    tp((String)paramc.tn("route"));
    return;
    d((String)paramc.tn("route"), paramc);
    return;
    paramc.tn("route");
    m(paramc);
  }
  
  public final String adQ()
  {
    return "Route";
  }
  
  public abstract void c(String paramString, c paramc);
  
  public abstract void d(String paramString, c paramc);
  
  public abstract void k(c paramc);
  
  public abstract void l(c paramc);
  
  public abstract void m(c paramc);
  
  public abstract void tp(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.flutter.a.a.b
 * JD-Core Version:    0.7.0.1
 */