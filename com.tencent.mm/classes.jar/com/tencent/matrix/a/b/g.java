package com.tencent.matrix.a.b;

import android.os.IBinder;
import android.os.WorkSource;
import com.tencent.matrix.e.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class g
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
      c.v("Matrix.battery.PowerHooker", "onServiceMethodInvoke: method name %s", new Object[] { paramAnonymousMethod.getName() });
      g.a(paramAnonymousMethod, paramAnonymousArrayOfObject);
    }
  };
  private static j cXn = new j("power", "android.os.IPowerManager", cXm);
  private static List<b> cXo = new ArrayList();
  
  public static void a(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        if (cXo.contains(paramb)) {
          continue;
        }
        cXo.add(paramb);
        if ((cXl) || (cXo.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.PowerHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(cXn.doHook()) });
        cXl = true;
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
        cXo.remove(paramb);
        if ((!cXl) || (!cXo.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.PowerHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(cXn.doUnHook()) });
        cXl = false;
      }
      finally {}
    }
  }
  
  static final class a
  {
    IBinder cWV;
    WorkSource cXx;
    String cXy;
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
    IBinder cWV;
    int flags;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.g
 * JD-Core Version:    0.7.0.1
 */