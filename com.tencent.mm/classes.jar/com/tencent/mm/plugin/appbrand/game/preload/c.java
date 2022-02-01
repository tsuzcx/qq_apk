package com.tencent.mm.plugin.appbrand.game.preload;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import junit.framework.Assert;

public final class c
  implements h
{
  public final LinkedHashSet<j> jSD;
  private AppBrandRuntime jgY;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45278);
    this.jgY = paramAppBrandRuntime;
    this.jSD = new LinkedHashSet();
    AppMethodBeat.o(45278);
  }
  
  public final p DH()
  {
    return null;
  }
  
  public final i Dl()
  {
    return null;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> Dm()
  {
    return null;
  }
  
  public final <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass)
  {
    return null;
  }
  
  public final void N(Runnable paramRunnable)
  {
    AppMethodBeat.i(45281);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(45281);
      return;
    }
    ap.f(paramRunnable);
    AppMethodBeat.o(45281);
  }
  
  public final void a(ar paramar) {}
  
  public final void a(ar paramar, o paramo) {}
  
  public final boolean a(k paramk)
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.b aSr()
  {
    AppMethodBeat.i(45279);
    if (this.jgY == null)
    {
      localb = com.tencent.mm.plugin.appbrand.b.b.jqX;
      AppMethodBeat.o(45279);
      return localb;
    }
    com.tencent.mm.plugin.appbrand.b.b localb = this.jgY.jdK.jqZ.aXJ();
    AppMethodBeat.o(45279);
    return localb;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m aSs()
  {
    return null;
  }
  
  public final ICommLibReader aSt()
  {
    return null;
  }
  
  public final int aUT()
  {
    return 0;
  }
  
  public final Handler aUU()
  {
    return null;
  }
  
  public final i aUV()
  {
    return null;
  }
  
  public final boolean aUk()
  {
    return false;
  }
  
  public final <T extends j> T ar(Class<T> paramClass)
  {
    AppMethodBeat.i(45280);
    Object localObject2 = null;
    Iterator localIterator = this.jSD.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (j)localIterator.next();
    } while (!paramClass.isInstance(localObject1));
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = (j)paramClass.newInstance();
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
        ac.e("MicroMsg.WAGamePreloadComponent", "Make sure %s has default constructor", new Object[] { paramClass.getName() });
        Object localObject3 = localObject1;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public final <T extends k> T as(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(ar paramar) {}
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt) {}
  
  public final void bZ(String paramString1, String paramString2) {}
  
  public final String getAppId()
  {
    return this.jgY.mAppId;
  }
  
  public final Context getContext()
  {
    return null;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    return this.jgY;
  }
  
  public final void h(int paramInt, String paramString) {}
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(186535);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(186535);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    ap.n(paramRunnable, l);
    AppMethodBeat.o(186535);
  }
  
  public final boolean isRunning()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.c
 * JD-Core Version:    0.7.0.1
 */