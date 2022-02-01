package com.tencent.matrix.hook;

import android.text.TextUtils;
import com.tencent.matrix.e.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HookManager
{
  public static final HookManager eUL = new HookManager();
  private volatile boolean eUM = false;
  private byte[] eUN = new byte[0];
  private final Set<a> eUO = new HashSet();
  private volatile boolean eUP = false;
  public b eUQ = null;
  
  private void axK()
  {
    a locala;
    for (;;)
    {
      synchronized (this.eUO)
      {
        Iterator localIterator1 = this.eUO.iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        locala = (a)localIterator1.next();
        String str = locala.axH();
        boolean bool = TextUtils.isEmpty(str);
        if (bool) {
          continue;
        }
        try
        {
          if (this.eUQ != null)
          {
            this.eUQ.loadLibrary(str);
            continue;
          }
        }
        finally
        {
          c.printErrStackTrace("Matrix.HookManager", localThrowable, "", new Object[0]);
          c.e("Matrix.HookManager", "Fail to load native library for %s, skip next steps.", new Object[] { locala.getClass().getName() });
          locala.eUE = a.a.eUH;
        }
      }
      com.tencent.mm.hellhoundlib.b.a locala1 = new com.tencent.mm.hellhoundlib.b.a().cG(localThrowable);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, locala1.aYi(), "com/tencent/matrix/hook/HookManager", "commitHooksLocked", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/matrix/hook/HookManager", "commitHooksLocked", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    }
    Iterator localIterator2 = this.eUO.iterator();
    while (localIterator2.hasNext())
    {
      locala = (a)localIterator2.next();
      if (locala.eUE != a.a.eUF)
      {
        c.e("Matrix.HookManager", "%s has failed steps before, skip calling onConfigure on it.", new Object[] { locala.getClass().getName() });
      }
      else if (!locala.axI())
      {
        c.e("Matrix.HookManager", "Fail to configure %s, skip next steps", new Object[] { locala.getClass().getName() });
        locala.eUE = a.a.eUI;
      }
    }
    localIterator2 = this.eUO.iterator();
    while (localIterator2.hasNext())
    {
      locala = (a)localIterator2.next();
      if (locala.eUE != a.a.eUF)
      {
        c.e("Matrix.HookManager", "%s has failed steps before, skip calling onHook on it.", new Object[] { locala.getClass().getName() });
      }
      else if (locala.dy(this.eUP))
      {
        c.i("Matrix.HookManager", "%s is committed successfully.", new Object[] { locala.getClass().getName() });
        locala.eUE = a.a.eUG;
      }
      else
      {
        c.e("Matrix.HookManager", "Fail to do hook in %s.", new Object[] { locala.getClass().getName() });
        locala.eUE = a.a.eUJ;
      }
    }
    this.eUO.clear();
  }
  
  private native void doFinalInitializeNative(boolean paramBoolean);
  
  private native boolean doPreHookInitializeNative(boolean paramBoolean);
  
  public static String getStack()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (!localStackTraceElement.getClassName().contains("java.lang.Thread")) {
        localStringBuilder.append(localStackTraceElement).append(';');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final HookManager a(a parama)
  {
    if ((parama != null) && (parama.eUE != a.a.eUG)) {}
    synchronized (this.eUO)
    {
      this.eUO.add(parama);
      return this;
    }
  }
  
  public final void axJ()
  {
    synchronized (this.eUN)
    {
      synchronized (this.eUO)
      {
        if (this.eUO.isEmpty()) {
          return;
        }
        boolean bool = this.eUM;
        if (bool) {
          break label203;
        }
      }
    }
    try
    {
      if (this.eUQ != null) {
        this.eUQ.loadLibrary("matrix-hookcommon");
      }
      while (!doPreHookInitializeNative(this.eUP))
      {
        throw new a("Fail to do hook common pre-hook initialize.");
        localObject1 = finally;
        throw localObject1;
        localObject2 = finally;
        throw localObject2;
        com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("matrix-hookcommon");
        Object localObject3 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, locala.aYi(), "com/tencent/matrix/hook/HookManager", "commitHooks", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)locala.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/matrix/hook/HookManager", "commitHooks", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      }
      axK();
    }
    finally
    {
      c.printErrStackTrace("Matrix.HookManager", localThrowable, "", new Object[0]);
      return;
    }
    doFinalInitializeNative(this.eUP);
    this.eUM = true;
    for (;;)
    {
      return;
      label203:
      axK();
    }
  }
  
  public static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  public static abstract interface b
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.hook.HookManager
 * JD-Core Version:    0.7.0.1
 */