package com.tencent.mm.plugin.appbrand.game.preload;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import junit.framework.Assert;

public final class c
  implements h
{
  private AppBrandRuntime jDb;
  public final LinkedHashSet<j> kqh;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45278);
    this.jDb = paramAppBrandRuntime;
    this.kqh = new LinkedHashSet();
    AppMethodBeat.o(45278);
  }
  
  public final i EM()
  {
    return null;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> EN()
  {
    return null;
  }
  
  public final q Fl()
  {
    return null;
  }
  
  public final <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass)
  {
    return null;
  }
  
  public final void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(45281);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(45281);
      return;
    }
    ar.f(paramRunnable);
    AppMethodBeat.o(45281);
  }
  
  public final void a(at paramat) {}
  
  public final void a(at paramat, o paramo) {}
  
  public final boolean a(k paramk)
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.a.b aWc()
  {
    AppMethodBeat.i(45279);
    if (this.jDb == null)
    {
      localb = com.tencent.mm.plugin.appbrand.a.b.jOd;
      AppMethodBeat.o(45279);
      return localb;
    }
    com.tencent.mm.plugin.appbrand.a.b localb = this.jDb.jzQ.jOf.bbI();
    AppMethodBeat.o(45279);
    return localb;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m aWd()
  {
    return null;
  }
  
  public final ICommLibReader aWe()
  {
    return null;
  }
  
  public final boolean aXO()
  {
    return false;
  }
  
  public final int aXX()
  {
    return 0;
  }
  
  public final Handler aYA()
  {
    return null;
  }
  
  public final i aYB()
  {
    return null;
  }
  
  public final <T extends j> T ar(Class<T> paramClass)
  {
    AppMethodBeat.i(45280);
    Object localObject2 = null;
    Iterator localIterator = this.kqh.iterator();
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
        ae.e("MicroMsg.WAGamePreloadComponent", "Make sure %s has default constructor", new Object[] { paramClass.getName() });
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
  
  public final void b(at paramat) {}
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt) {}
  
  public final void cb(String paramString1, String paramString2) {}
  
  public final String getAppId()
  {
    return this.jDb.mAppId;
  }
  
  public final Context getContext()
  {
    return null;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    return this.jDb;
  }
  
  public final void h(int paramInt, String paramString) {}
  
  public final boolean isRunning()
  {
    return false;
  }
  
  public final void j(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(222360);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(222360);
      return;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    ar.o(paramRunnable, l);
    AppMethodBeat.o(222360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.c
 * JD-Core Version:    0.7.0.1
 */