package com.tencent.matrix.a.b;

import com.tencent.matrix.e.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class l
{
  private static boolean cXl;
  private static j.b cXm = new j.b()
  {
    public final Object b(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      return null;
    }
    
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      if ("startScan".equals(paramAnonymousMethod.getName())) {
        l.access$000();
      }
      while (!"getScanResults".equals(paramAnonymousMethod.getName())) {
        return;
      }
      l.access$100();
    }
  };
  private static j cXn = new j("wifi", "android.net.wifi.IWifiManager", cXm);
  private static List<a> cXo = new ArrayList();
  
  public static void a(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        if (cXo.contains(parama)) {
          continue;
        }
        cXo.add(parama);
        if ((cXl) || (cXo.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.WifiHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(cXn.doHook()) });
        cXl = true;
      }
      finally {}
    }
  }
  
  public static void b(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        cXo.remove(parama);
        if ((!cXl) || (!cXo.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.WifiHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(cXn.doUnHook()) });
        cXl = false;
      }
      finally {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void Wo();
    
    public abstract void Wy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.l
 * JD-Core Version:    0.7.0.1
 */