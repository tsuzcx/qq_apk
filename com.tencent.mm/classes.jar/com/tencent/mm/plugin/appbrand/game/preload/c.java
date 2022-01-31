package com.tencent.mm.plugin.appbrand.game.preload;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import junit.framework.Assert;

public final class c
  implements h
{
  private com.tencent.mm.plugin.appbrand.i gRG;
  public final LinkedHashSet<j> htV;
  
  public c(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(130289);
    this.gRG = parami;
    this.htV = new LinkedHashSet();
    AppMethodBeat.o(130289);
  }
  
  public final void A(Runnable paramRunnable)
  {
    AppMethodBeat.i(130292);
    al.d(paramRunnable);
    AppMethodBeat.o(130292);
  }
  
  public final <T extends j> T U(Class<T> paramClass)
  {
    AppMethodBeat.i(130291);
    Object localObject2 = null;
    Iterator localIterator = this.htV.iterator();
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
        AppMethodBeat.o(130291);
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.WAGamePreloadComponent", "Make sure %s has default constructor", new Object[] { paramClass.getName() });
        Object localObject3 = localObject1;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public final <T extends k> T V(Class<T> paramClass)
  {
    return null;
  }
  
  public final void a(ai paramai) {}
  
  public final int aAN()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.appbrand.i.i aAO()
  {
    return null;
  }
  
  public final Handler aAP()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.b asW()
  {
    AppMethodBeat.i(130290);
    if (this.gRG == null)
    {
      localb = com.tencent.mm.plugin.appbrand.b.b.gYh;
      AppMethodBeat.o(130290);
      return localb;
    }
    com.tencent.mm.plugin.appbrand.b.b localb = this.gRG.gPL.gYj.awr();
    AppMethodBeat.o(130290);
    return localb;
  }
  
  public final l asX()
  {
    return null;
  }
  
  public final n asY()
  {
    return null;
  }
  
  public final void b(ai paramai) {}
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt) {}
  
  public final void bY(String paramString1, String paramString2) {}
  
  public final String getAppId()
  {
    return this.gRG.mAppId;
  }
  
  public final Context getContext()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.i getRuntime()
  {
    return this.gRG;
  }
  
  public final void h(int paramInt, String paramString) {}
  
  public final boolean isRunning()
  {
    return false;
  }
  
  public final <T extends com.tencent.luggage.a.b> T q(Class<T> paramClass)
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.i.i wB()
  {
    return null;
  }
  
  public final Map<String, m> wC()
  {
    return null;
  }
  
  public final o wX()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.c
 * JD-Core Version:    0.7.0.1
 */