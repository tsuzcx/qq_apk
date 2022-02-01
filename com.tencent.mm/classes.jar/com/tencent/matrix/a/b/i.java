package com.tencent.matrix.a.b;

import android.os.IBinder;
import android.os.WorkSource;
import com.tencent.matrix.e.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class i
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
      c.v("Matrix.battery.PowerHooker", "onServiceMethodInvoke: method name %s", new Object[] { paramAnonymousMethod.getName() });
      i.a(paramAnonymousMethod, paramAnonymousArrayOfObject);
    }
  };
  private static n eTu = new n("power", "android.os.IPowerManager", eTt);
  private static List<b> eTv = new ArrayList();
  
  public static void a(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        if (eTv.contains(paramb)) {
          continue;
        }
        eTv.add(paramb);
        if ((eTs) || (eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.PowerHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(eTu.doHook()) });
        eTs = true;
      }
      finally {}
    }
  }
  
  public static void b(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        eTv.remove(paramb);
        if ((!eTs) || (!eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.PowerHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(eTu.doUnHook()) });
        eTs = false;
      }
      finally {}
    }
  }
  
  static final class a
  {
    WorkSource eTI;
    String eTJ;
    IBinder eTc;
    int flags;
    String packageName;
    String tag;
  }
  
  public static abstract interface b
  {
    public abstract void a(IBinder paramIBinder, int paramInt);
    
    public abstract void a(IBinder paramIBinder, int paramInt, String paramString1, String paramString2, WorkSource paramWorkSource, String paramString3);
  }
  
  static final class c
  {
    IBinder eTc;
    int flags;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.i
 * JD-Core Version:    0.7.0.1
 */