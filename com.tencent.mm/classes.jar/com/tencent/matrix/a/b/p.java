package com.tencent.matrix.a.b;

import com.tencent.matrix.e.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class p
{
  private static boolean eTs;
  private static n.b eTt = new n.b()
  {
    public final Object a(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      return null;
    }
    
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      if ("startScan".equals(paramAnonymousMethod.getName())) {
        p.access$000();
      }
      while (!"getScanResults".equals(paramAnonymousMethod.getName())) {
        return;
      }
      p.access$100();
    }
  };
  private static n eTu = new n("wifi", "android.net.wifi.IWifiManager", eTt);
  private static List<a> eTv = new ArrayList();
  
  public static void a(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        if (eTv.contains(parama)) {
          continue;
        }
        eTv.add(parama);
        if ((eTs) || (eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.WifiHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(eTu.doHook()) });
        eTs = true;
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
        eTv.remove(parama);
        if ((!eTs) || (!eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.WifiHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(eTu.doUnHook()) });
        eTs = false;
      }
      finally {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void awW();
    
    public abstract void axn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.p
 * JD-Core Version:    0.7.0.1
 */