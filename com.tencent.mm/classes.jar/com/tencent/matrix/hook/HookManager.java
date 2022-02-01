package com.tencent.matrix.hook;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.matrix.e.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HookManager
{
  public static final HookManager cYg = new HookManager();
  private final Set<a> cYi = new HashSet();
  private volatile boolean cYj = false;
  public b cYk = null;
  private volatile boolean dql = false;
  
  private native void doFinalInitializeNative();
  
  private native boolean doPreHookInitializeNative();
  
  @Keep
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
  
  public final void WL()
  {
    if (this.cYi.isEmpty()) {}
    label182:
    do
    {
      return;
      if (!this.dql) {
        try
        {
          if (this.cYk != null) {
            this.cYk.loadLibrary("matrix-hookcommon");
          }
          while (!doPreHookInitializeNative())
          {
            throw new a("Fail to do hook common pre-hook initialize.");
            System.loadLibrary("matrix-hookcommon");
          }
          localIterator = this.cYi.iterator();
        }
        catch (Throwable localThrowable1)
        {
          c.printErrStackTrace("Matrix.HookManager", localThrowable1, "", new Object[0]);
          return;
        }
      }
      a locala;
      while (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        String str = locala.WJ();
        if (!TextUtils.isEmpty(str))
        {
          try
          {
            if (this.cYk == null) {
              break label182;
            }
            this.cYk.loadLibrary(str);
          }
          catch (Throwable localThrowable2)
          {
            c.printErrStackTrace("Matrix.HookManager", localThrowable2, "", new Object[0]);
            c.e("Matrix.HookManager", "Fail to load native library for %s, skip next steps.", new Object[] { locala.getClass().getName() });
            locala.cXZ = a.a.cYc;
          }
          continue;
          System.loadLibrary(localThrowable2);
        }
      }
      Iterator localIterator = this.cYi.iterator();
      while (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if (locala.cXZ != a.a.cYa) {
          c.e("Matrix.HookManager", "%s has failed steps before, skip calling onConfigure on it.", new Object[] { locala.getClass().getName() });
        } else {
          locala.WK();
        }
      }
      localIterator = this.cYi.iterator();
      while (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if (locala.cXZ != a.a.cYa)
        {
          c.e("Matrix.HookManager", "%s has failed steps before, skip calling onHook on it.", new Object[] { locala.getClass().getName() });
        }
        else if (locala.cR(this.cYj))
        {
          c.i("Matrix.HookManager", "%s is committed successfully.", new Object[] { locala.getClass().getName() });
          locala.cXZ = a.a.cYb;
        }
        else
        {
          c.e("Matrix.HookManager", "Fail to do hook in %s.", new Object[] { locala.getClass().getName() });
          locala.cXZ = a.a.cYe;
        }
      }
      this.cYi.clear();
    } while (this.dql);
    doFinalInitializeNative();
    this.dql = true;
  }
  
  public final HookManager a(a parama)
  {
    if ((parama != null) && (parama.cXZ != a.a.cYb)) {
      this.cYi.add(parama);
    }
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.hook.HookManager
 * JD-Core Version:    0.7.0.1
 */