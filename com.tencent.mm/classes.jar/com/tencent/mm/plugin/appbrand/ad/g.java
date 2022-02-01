package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.g
  implements e
{
  private r jFj;
  public al jFk;
  public f jFl;
  
  public g(r paramr)
  {
    AppMethodBeat.i(134653);
    this.jFj = paramr;
    AppMethodBeat.o(134653);
  }
  
  private al DG()
  {
    AppMethodBeat.i(134656);
    al localal;
    if (this.jFk != null)
    {
      localal = this.jFk;
      AppMethodBeat.o(134656);
      return localal;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.jFk = new al((ViewGroup)getContentView());
      localal = this.jFk;
      AppMethodBeat.o(134656);
      return localal;
    }
    AppMethodBeat.o(134656);
    return null;
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
    AppMethodBeat.i(134654);
    paramClass = this.jFj.K(paramClass);
    AppMethodBeat.o(134654);
    return paramClass;
  }
  
  public final void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(134661);
    this.jFj.K(paramRunnable);
    AppMethodBeat.o(134661);
  }
  
  public final void a(at paramat)
  {
    AppMethodBeat.i(134664);
    this.jFj.a(paramat);
    AppMethodBeat.o(134664);
  }
  
  public final void a(at paramat, o paramo)
  {
    AppMethodBeat.i(207748);
    this.jFj.a(paramat, paramo);
    AppMethodBeat.o(207748);
  }
  
  public final boolean a(k paramk)
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.a.b aWc()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m aWd()
  {
    return null;
  }
  
  public final boolean aXO()
  {
    return this.jFj.jCZ;
  }
  
  public final int aXX()
  {
    AppMethodBeat.i(134657);
    int i = hashCode();
    AppMethodBeat.o(134657);
    return i;
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
    return null;
  }
  
  public final <T extends k> T as(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(at paramat)
  {
    AppMethodBeat.i(160929);
    this.jFj.a(paramat);
    AppMethodBeat.o(160929);
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134666);
    this.jFj.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134666);
  }
  
  public final void cb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134663);
    this.jFj.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134663);
  }
  
  public final e.a fF(boolean paramBoolean)
  {
    AppMethodBeat.i(207746);
    if (paramBoolean)
    {
      if (this.jFj.getRuntime().jAc != null)
      {
        localObject = this.jFj.getRuntime().jAc;
        AppMethodBeat.o(207746);
        return localObject;
      }
      AppMethodBeat.o(207746);
      return null;
    }
    Object localObject = DG();
    AppMethodBeat.o(207746);
    return localObject;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(134658);
    String str = this.jFj.getAppId();
    AppMethodBeat.o(134658);
    return str;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(134655);
    Object localObject1;
    if (this.jFl != null)
    {
      localObject1 = this.jFl.getContentContainer();
      AppMethodBeat.o(134655);
      return localObject1;
    }
    Object localObject2;
    if (this.jFj.getRuntime() != null)
    {
      localObject2 = this.jFj.getRuntime();
      if ((((AppBrandRuntime)localObject2).jzG instanceof x))
      {
        ae.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use AdLoadingSplash RuntimeAdViewContainer", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
        localObject1 = ((x)((AppBrandRuntime)localObject2).jzG).getRuntimeAdViewContainer();
      }
    }
    for (;;)
    {
      String str = ((AppBrandRuntime)localObject2).mAppId;
      if (((AppBrandRuntime)localObject2).jzG == null) {}
      for (localObject2 = "null";; localObject2 = ((AppBrandRuntime)localObject2).jzG.getClass().getSimpleName())
      {
        ae.i("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer:%s, appId:%s, splash:%s", new Object[] { localObject1, str, localObject2 });
        this.jFl = ((f)localObject1);
        if (this.jFl == null) {
          break label198;
        }
        localObject1 = this.jFl.getContentContainer();
        AppMethodBeat.o(134655);
        return localObject1;
        if (((AppBrandRuntime)localObject2).jzI == null) {
          break label205;
        }
        ae.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use secondaryRuntimeAdViewContainer", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
        localObject1 = ((AppBrandRuntime)localObject2).jzI;
        break;
      }
      label198:
      AppMethodBeat.o(134655);
      return null;
      label205:
      localObject1 = null;
    }
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(134659);
    Context localContext = this.jFj.getContext();
    AppMethodBeat.o(134659);
    return localContext;
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(134662);
    this.jFj.h(paramInt, paramString);
    AppMethodBeat.o(134662);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(134660);
    if ((this.jFj.getRuntime() != null) && (!this.jFj.getRuntime().isDestroyed()))
    {
      AppMethodBeat.o(134660);
      return true;
    }
    AppMethodBeat.o(134660);
    return false;
  }
  
  public final void j(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(207747);
    this.jFj.j(paramRunnable, paramLong);
    AppMethodBeat.o(207747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.g
 * JD-Core Version:    0.7.0.1
 */