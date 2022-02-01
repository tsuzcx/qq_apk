package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.w;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

public final class f
  extends g
  implements com.tencent.mm.plugin.appbrand.jsapi.e
{
  private q jCl;
  public am jCm;
  public e jCn;
  
  public f(q paramq)
  {
    AppMethodBeat.i(134653);
    this.jCl = paramq;
    AppMethodBeat.o(134653);
  }
  
  private am DD()
  {
    AppMethodBeat.i(134656);
    am localam;
    if (this.jCm != null)
    {
      localam = this.jCm;
      AppMethodBeat.o(134656);
      return localam;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.jCm = new am((ViewGroup)getContentView());
      localam = this.jCm;
      AppMethodBeat.o(134656);
      return localam;
    }
    AppMethodBeat.o(134656);
    return null;
  }
  
  public final i EK()
  {
    return null;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> EL()
  {
    return null;
  }
  
  public final p Fg()
  {
    return null;
  }
  
  public final <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass)
  {
    AppMethodBeat.i(134654);
    paramClass = this.jCl.K(paramClass);
    AppMethodBeat.o(134654);
    return paramClass;
  }
  
  public final void M(Runnable paramRunnable)
  {
    AppMethodBeat.i(134661);
    this.jCl.M(paramRunnable);
    AppMethodBeat.o(134661);
  }
  
  public final void a(at paramat)
  {
    AppMethodBeat.i(134664);
    this.jCl.a(paramat);
    AppMethodBeat.o(134664);
  }
  
  public final void a(at paramat, o paramo)
  {
    AppMethodBeat.i(197268);
    this.jCl.a(paramat, paramo);
    AppMethodBeat.o(197268);
  }
  
  public final boolean a(k paramk)
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.a.b aVD()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m aVE()
  {
    return null;
  }
  
  public final int aXC()
  {
    AppMethodBeat.i(134657);
    int i = hashCode();
    AppMethodBeat.o(134657);
    return i;
  }
  
  public final boolean aXt()
  {
    return this.jCl.jzW;
  }
  
  public final Handler aYg()
  {
    return null;
  }
  
  public final i aYh()
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
    this.jCl.a(paramat);
    AppMethodBeat.o(160929);
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134666);
    this.jCl.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134666);
  }
  
  public final void cb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134663);
    this.jCl.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134663);
  }
  
  public final e.a fG(boolean paramBoolean)
  {
    AppMethodBeat.i(197266);
    if (paramBoolean)
    {
      if (this.jCl.getRuntime().jxe != null)
      {
        localObject = this.jCl.getRuntime().jxe;
        AppMethodBeat.o(197266);
        return localObject;
      }
      AppMethodBeat.o(197266);
      return null;
    }
    Object localObject = DD();
    AppMethodBeat.o(197266);
    return localObject;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(134658);
    String str = this.jCl.getAppId();
    AppMethodBeat.o(134658);
    return str;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(134655);
    Object localObject1;
    if (this.jCn != null)
    {
      localObject1 = this.jCn.getContentContainer();
      AppMethodBeat.o(134655);
      return localObject1;
    }
    Object localObject2;
    if (this.jCl.getRuntime() != null)
    {
      localObject2 = this.jCl.getRuntime();
      if ((((AppBrandRuntime)localObject2).jwK instanceof w))
      {
        ad.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use AdLoadingSplash RuntimeAdViewContainer", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
        localObject1 = ((w)((AppBrandRuntime)localObject2).jwK).getRuntimeAdViewContainer();
      }
    }
    for (;;)
    {
      String str = ((AppBrandRuntime)localObject2).mAppId;
      if (((AppBrandRuntime)localObject2).jwK == null) {}
      for (localObject2 = "null";; localObject2 = ((AppBrandRuntime)localObject2).jwK.getClass().getSimpleName())
      {
        ad.i("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer:%s, appId:%s, splash:%s", new Object[] { localObject1, str, localObject2 });
        this.jCn = ((e)localObject1);
        if (this.jCn == null) {
          break label198;
        }
        localObject1 = this.jCn.getContentContainer();
        AppMethodBeat.o(134655);
        return localObject1;
        if (((AppBrandRuntime)localObject2).jwL == null) {
          break label205;
        }
        ad.d("MicroMsg.AppBrandRuntime", "getRuntimeAdViewContainer, appId:%s, use secondaryRuntimeAdViewContainer", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
        localObject1 = ((AppBrandRuntime)localObject2).jwL;
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
    Context localContext = this.jCl.getContext();
    AppMethodBeat.o(134659);
    return localContext;
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(134662);
    this.jCl.h(paramInt, paramString);
    AppMethodBeat.o(134662);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(134660);
    if ((this.jCl.getRuntime() != null) && (!this.jCl.getRuntime().isDestroyed()))
    {
      AppMethodBeat.o(134660);
      return true;
    }
    AppMethodBeat.o(134660);
    return false;
  }
  
  public final void j(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(197267);
    this.jCl.j(paramRunnable, paramLong);
    AppMethodBeat.o(197267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.f
 * JD-Core Version:    0.7.0.1
 */