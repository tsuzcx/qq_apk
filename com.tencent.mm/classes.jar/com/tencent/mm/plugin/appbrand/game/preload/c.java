package com.tencent.mm.plugin.appbrand.game.preload;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import junit.framework.Assert;

public final class c
  implements k
{
  private AppBrandRuntime kEc;
  public final LinkedHashSet<com.tencent.mm.plugin.appbrand.jsapi.m> ltP;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45278);
    this.kEc = paramAppBrandRuntime;
    this.ltP = new LinkedHashSet();
    AppMethodBeat.o(45278);
  }
  
  public final <T extends com.tencent.luggage.a.b> T M(Class<T> paramClass)
  {
    return null;
  }
  
  public final i Oo()
  {
    return null;
  }
  
  public final Map<String, p> Op()
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
  
  public final void a(bc parambc) {}
  
  public final void a(bc parambc, o paramo) {}
  
  public final void a(bc parambc, int[] paramArrayOfInt) {}
  
  public final boolean a(n paramn)
  {
    return false;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m> T av(Class<T> paramClass)
  {
    AppMethodBeat.i(45280);
    Object localObject2 = null;
    Iterator localIterator = this.ltP.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.m)localIterator.next();
    } while (!paramClass.isInstance(localObject1));
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.m)paramClass.newInstance();
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
  
  public final <T extends n> T aw(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt) {}
  
  public final ICommLibReader bqZ()
  {
    return null;
  }
  
  public final boolean bsV()
  {
    return false;
  }
  
  public final void co(String paramString1, String paramString2) {}
  
  public final String getAppId()
  {
    return this.kEc.mAppId;
  }
  
  public final com.tencent.mm.plugin.appbrand.a.b getAppState()
  {
    AppMethodBeat.i(45279);
    if (this.kEc == null)
    {
      localb = com.tencent.mm.plugin.appbrand.a.b.kQK;
      AppMethodBeat.o(45279);
      return localb;
    }
    com.tencent.mm.plugin.appbrand.a.b localb = this.kEc.kAH.kQM.bwY();
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
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m getDialogContainer()
  {
    return null;
  }
  
  public final q getFileSystem()
  {
    return null;
  }
  
  public final i getJsRuntime()
  {
    return null;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    return this.kEc;
  }
  
  public final void i(int paramInt, String paramString) {}
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(226632);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(226632);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    MMHandlerThread.postToMainThreadDelayed(paramRunnable, l);
    AppMethodBeat.o(226632);
  }
  
  public final boolean isRunning()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.c
 * JD-Core Version:    0.7.0.1
 */