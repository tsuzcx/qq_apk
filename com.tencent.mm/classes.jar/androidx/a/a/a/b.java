package androidx.a.a.a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  extends c
{
  private final Object mLock;
  private volatile Handler mMainHandler;
  private final ExecutorService yV;
  
  public b()
  {
    AppMethodBeat.i(201109);
    this.mLock = new Object();
    this.yV = Executors.newFixedThreadPool(4, new ThreadFactory()
    {
      private final AtomicInteger yW;
      
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(201151);
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable);
        paramAnonymousRunnable.setName(String.format("arch_disk_io_%d", new Object[] { Integer.valueOf(this.yW.getAndIncrement()) }));
        AppMethodBeat.o(201151);
        return paramAnonymousRunnable;
      }
    });
    AppMethodBeat.o(201109);
  }
  
  private static Handler b(Looper paramLooper)
  {
    AppMethodBeat.i(201122);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramLooper = Handler.createAsync(paramLooper);
      AppMethodBeat.o(201122);
      return paramLooper;
    }
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, null, Boolean.TRUE });
      AppMethodBeat.o(201122);
      return localHandler;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      paramLooper = new Handler(paramLooper);
      AppMethodBeat.o(201122);
      return paramLooper;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramLooper = new Handler(paramLooper);
      AppMethodBeat.o(201122);
      return paramLooper;
    }
    catch (InstantiationException localInstantiationException)
    {
      break label108;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label108:
      break label108;
    }
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(201135);
    this.yV.execute(paramRunnable);
    AppMethodBeat.o(201135);
  }
  
  public final boolean isMainThread()
  {
    AppMethodBeat.i(201152);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(201152);
      return true;
    }
    AppMethodBeat.o(201152);
    return false;
  }
  
  public final void postToMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(201144);
    if (this.mMainHandler == null) {}
    synchronized (this.mLock)
    {
      if (this.mMainHandler == null) {
        this.mMainHandler = b(Looper.getMainLooper());
      }
      this.mMainHandler.post(paramRunnable);
      AppMethodBeat.o(201144);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */