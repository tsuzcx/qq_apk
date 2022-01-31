package com.tencent.matrix.a.b;

import android.os.IBinder;
import android.os.WorkSource;
import com.tencent.matrix.a.c.b.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class e
{
  private static boolean bmY;
  private static b.b bmZ = new b.b()
  {
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      com.tencent.matrix.d.b.v("Matrix.PowerManagerServiceHooker", "onServiceMethodInvoke: method name %s", new Object[] { paramAnonymousMethod.getName() });
      e.a(paramAnonymousMethod, paramAnonymousArrayOfObject);
    }
  };
  private static com.tencent.matrix.a.c.b bna = new com.tencent.matrix.a.c.b("power", "android.os.IPowerManager", bmZ);
  private static List<b> bnb = new ArrayList();
  
  public static void a(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        if (bnb.contains(paramb)) {
          continue;
        }
        bnb.add(paramb);
        if ((bmY) || (bnb.isEmpty())) {
          continue;
        }
        com.tencent.matrix.d.b.i("Matrix.PowerManagerServiceHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(bna.doHook()) });
        bmY = true;
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
        bnb.remove(paramb);
        if ((!bmY) || (!bnb.isEmpty())) {
          continue;
        }
        com.tencent.matrix.d.b.i("Matrix.PowerManagerServiceHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(bna.doUnHook()) });
        bmY = false;
      }
      finally {}
    }
  }
  
  private static final class a
  {
    String bnA;
    WorkSource bnz;
    int flags;
    String packageName;
    String tag;
    IBinder token;
  }
  
  public static abstract interface b
  {
    public abstract void a(IBinder paramIBinder, int paramInt);
    
    public abstract void a(IBinder paramIBinder, int paramInt, String paramString1, String paramString2, WorkSource paramWorkSource, String paramString3);
  }
  
  private static final class c
  {
    int flags;
    IBinder token;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.b.e
 * JD-Core Version:    0.7.0.1
 */