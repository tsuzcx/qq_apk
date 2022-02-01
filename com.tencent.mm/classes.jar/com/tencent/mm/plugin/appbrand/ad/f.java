package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Map;

public final class f
  extends g
  implements com.tencent.mm.plugin.appbrand.jsapi.e
{
  private q jiP;
  private am jiQ;
  private e jiR;
  
  public f(q paramq)
  {
    AppMethodBeat.i(134653);
    this.jiP = paramq;
    AppMethodBeat.o(134653);
  }
  
  private am Ce()
  {
    AppMethodBeat.i(134656);
    am localam;
    if (this.jiQ != null)
    {
      localam = this.jiQ;
      AppMethodBeat.o(134656);
      return localam;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.jiQ = new am((ViewGroup)getContentView());
      localam = this.jiQ;
      AppMethodBeat.o(134656);
      return localam;
    }
    AppMethodBeat.o(134656);
    return null;
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
    AppMethodBeat.i(134654);
    paramClass = this.jiP.K(paramClass);
    AppMethodBeat.o(134654);
    return paramClass;
  }
  
  public final void N(Runnable paramRunnable)
  {
    AppMethodBeat.i(134661);
    this.jiP.N(paramRunnable);
    AppMethodBeat.o(134661);
  }
  
  public final void a(ar paramar)
  {
    AppMethodBeat.i(134664);
    this.jiP.a(paramar);
    AppMethodBeat.o(134664);
  }
  
  public final void a(ar paramar, o paramo)
  {
    AppMethodBeat.i(193377);
    this.jiP.a(paramar, paramo);
    AppMethodBeat.o(193377);
  }
  
  public final boolean a(k paramk)
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.b aSr()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m aSs()
  {
    return null;
  }
  
  public final int aUT()
  {
    AppMethodBeat.i(134657);
    int i = hashCode();
    AppMethodBeat.o(134657);
    return i;
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
    return this.jiP.jgW;
  }
  
  public final <T extends j> T ar(Class<T> paramClass)
  {
    return null;
  }
  
  public final <T extends k> T as(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(ar paramar)
  {
    AppMethodBeat.i(160929);
    this.jiP.a(paramar);
    AppMethodBeat.o(160929);
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134666);
    this.jiP.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134666);
  }
  
  public final void bZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134663);
    this.jiP.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134663);
  }
  
  public final e.a fC(boolean paramBoolean)
  {
    AppMethodBeat.i(193375);
    if (paramBoolean)
    {
      if (this.jiP.getRuntime().jdW != null)
      {
        localObject = this.jiP.getRuntime().jdW;
        AppMethodBeat.o(193375);
        return localObject;
      }
      AppMethodBeat.o(193375);
      return null;
    }
    Object localObject = Ce();
    AppMethodBeat.o(193375);
    return localObject;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(134658);
    String str = this.jiP.getAppId();
    AppMethodBeat.o(134658);
    return str;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(134655);
    ViewGroup localViewGroup;
    if (this.jiR != null)
    {
      localViewGroup = this.jiR.getContentContainer();
      AppMethodBeat.o(134655);
      return localViewGroup;
    }
    if (this.jiP.getRuntime() != null)
    {
      this.jiR = this.jiP.getRuntime().aTc();
      if (this.jiR != null)
      {
        localViewGroup = this.jiR.getContentContainer();
        AppMethodBeat.o(134655);
        return localViewGroup;
      }
    }
    AppMethodBeat.o(134655);
    return null;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(134659);
    Context localContext = this.jiP.getContext();
    AppMethodBeat.o(134659);
    return localContext;
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(134662);
    this.jiP.h(paramInt, paramString);
    AppMethodBeat.o(134662);
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(193376);
    this.jiP.i(paramRunnable, paramLong);
    AppMethodBeat.o(193376);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(134660);
    if ((this.jiP.getRuntime() != null) && (!this.jiP.getRuntime().isDestroyed()))
    {
      AppMethodBeat.o(134660);
      return true;
    }
    AppMethodBeat.o(134660);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.f
 * JD-Core Version:    0.7.0.1
 */