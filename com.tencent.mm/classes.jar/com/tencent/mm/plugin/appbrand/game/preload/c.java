package com.tencent.mm.plugin.appbrand.game.preload;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.LinkedHashSet;
import junit.framework.Assert;

public final class c
  implements k
{
  private AppBrandRuntime qwG;
  public final LinkedHashSet<m> rsx;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45278);
    this.qwG = paramAppBrandRuntime;
    this.rsx = new LinkedHashSet();
    AppMethodBeat.o(45278);
  }
  
  public final <T extends com.tencent.luggage.a.b> T T(Class<T> paramClass)
  {
    return null;
  }
  
  public final void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(45281);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(45281);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(45281);
  }
  
  public final void a(bc parambc) {}
  
  public final void a(bc parambc, int[] paramArrayOfInt) {}
  
  public final boolean a(n paramn)
  {
    return false;
  }
  
  public final boolean a(String paramString, o paramo)
  {
    return false;
  }
  
  public final <T extends m> T aN(Class<T> paramClass)
  {
    AppMethodBeat.i(45280);
    Object localObject2 = null;
    Iterator localIterator = this.rsx.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (m)localIterator.next();
    } while (!paramClass.isInstance(localObject1));
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = (m)paramClass.newInstance();
      if (localObject2 != null)
      {
        bool = true;
        Assert.assertTrue(bool);
        AppMethodBeat.o(45280);
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.WAGamePreloadComponent", "Make sure %s has default constructor", new Object[] { paramClass.getName() });
        Object localObject3 = localObject1;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public final <T extends n> T aO(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt) {}
  
  public final void cJ(String paramString1, String paramString2) {}
  
  public final void callback(int paramInt, String paramString) {}
  
  public final ICommLibReader cbl()
  {
    return null;
  }
  
  public final void f(String paramString1, String paramString2, int paramInt) {}
  
  public final String getAppId()
  {
    return this.qwG.mAppId;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.b getAppState()
  {
    AppMethodBeat.i(45279);
    if (this.qwG == null)
    {
      localb = com.tencent.mm.plugin.appbrand.b.b.qKz;
      AppMethodBeat.o(45279);
      return localb;
    }
    com.tencent.mm.plugin.appbrand.b.b localb = this.qwG.qsB.qKC.chD();
    AppMethodBeat.o(45279);
    return localb;
  }
  
  public final Handler getAsyncHandler()
  {
    return null;
  }
  
  public final int getComponentId()
  {
    return 0;
  }
  
  public final Context getContext()
  {
    return null;
  }
  
  public final r getDialogContainer()
  {
    return null;
  }
  
  public final w getFileSystem()
  {
    return null;
  }
  
  public final f.c getInterceptor()
  {
    return null;
  }
  
  public final i getJsRuntime()
  {
    return null;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    return this.qwG;
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(318518);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(318518);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, l);
    AppMethodBeat.o(318518);
  }
  
  public final boolean isRunning()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.c
 * JD-Core Version:    0.7.0.1
 */