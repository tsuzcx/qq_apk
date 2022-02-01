package com.tencent.mm.plugin.appbrand.game.preload;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.LinkedHashSet;
import junit.framework.Assert;

public final class c
  implements j
{
  private AppBrandRuntime nxs;
  public final LinkedHashSet<com.tencent.mm.plugin.appbrand.jsapi.l> ooP;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45278);
    this.nxs = paramAppBrandRuntime;
    this.ooP = new LinkedHashSet();
    AppMethodBeat.o(45278);
  }
  
  public final <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass)
  {
    return null;
  }
  
  public final void P(Runnable paramRunnable)
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
  
  public final void a(az paramaz) {}
  
  public final void a(az paramaz, int[] paramArrayOfInt) {}
  
  public final boolean a(m paramm)
  {
    return false;
  }
  
  public final boolean a(String paramString, o paramo)
  {
    return false;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.l> T au(Class<T> paramClass)
  {
    AppMethodBeat.i(45280);
    Object localObject2 = null;
    Iterator localIterator = this.ooP.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.l)localIterator.next();
    } while (!paramClass.isInstance(localObject1));
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.l)paramClass.newInstance();
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
  
  public final <T extends m> T av(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt) {}
  
  public final ICommLibReader bBP()
  {
    return null;
  }
  
  public final void c(String paramString1, String paramString2, int paramInt) {}
  
  public final void ct(String paramString1, String paramString2) {}
  
  public final String getAppId()
  {
    return this.nxs.mAppId;
  }
  
  public final com.tencent.mm.plugin.appbrand.a.b getAppState()
  {
    AppMethodBeat.i(45279);
    if (this.nxs == null)
    {
      localb = com.tencent.mm.plugin.appbrand.a.b.nKS;
      AppMethodBeat.o(45279);
      return localb;
    }
    com.tencent.mm.plugin.appbrand.a.b localb = this.nxs.ntR.nKU.bIg();
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
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.l getDialogContainer()
  {
    return null;
  }
  
  public final r getFileSystem()
  {
    return null;
  }
  
  public final e.c getInterceptor()
  {
    return null;
  }
  
  public final i getJsRuntime()
  {
    return null;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    return this.nxs;
  }
  
  public final void h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(272960);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(272960);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, l);
    AppMethodBeat.o(272960);
  }
  
  public final boolean isRunning()
  {
    return false;
  }
  
  public final void j(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.c
 * JD-Core Version:    0.7.0.1
 */