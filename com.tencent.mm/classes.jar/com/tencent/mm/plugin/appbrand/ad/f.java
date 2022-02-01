package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Map;

public final class f
  extends g
  implements com.tencent.mm.plugin.appbrand.jsapi.e
{
  private q iIL;
  private com.tencent.mm.plugin.appbrand.page.ar iIM;
  private e iIN;
  
  public f(q paramq)
  {
    AppMethodBeat.i(134653);
    this.iIL = paramq;
    AppMethodBeat.o(134653);
  }
  
  public final i DI()
  {
    return null;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DJ()
  {
    return null;
  }
  
  public final p Ee()
  {
    return null;
  }
  
  public final <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass)
  {
    AppMethodBeat.i(134654);
    paramClass = this.iIL.K(paramClass);
    AppMethodBeat.o(134654);
    return paramClass;
  }
  
  public final void L(Runnable paramRunnable)
  {
    AppMethodBeat.i(134661);
    this.iIL.L(paramRunnable);
    AppMethodBeat.o(134661);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.ar paramar)
  {
    AppMethodBeat.i(134664);
    this.iIL.a(paramar);
    AppMethodBeat.o(134664);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.ar paramar, o paramo)
  {
    AppMethodBeat.i(194461);
    this.iIL.a(paramar, paramo);
    AppMethodBeat.o(194461);
  }
  
  public final boolean a(k paramk)
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.b aLA()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m aLB()
  {
    return null;
  }
  
  public final boolean aNu()
  {
    return this.iIL.iGT;
  }
  
  public final int aOd()
  {
    AppMethodBeat.i(134657);
    int i = hashCode();
    AppMethodBeat.o(134657);
    return i;
  }
  
  public final Handler aOe()
  {
    return null;
  }
  
  public final i aOf()
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
  
  public final void b(com.tencent.mm.plugin.appbrand.jsapi.ar paramar)
  {
    AppMethodBeat.i(160929);
    this.iIL.a(paramar);
    AppMethodBeat.o(160929);
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134666);
    this.iIL.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134666);
  }
  
  public final void bR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134663);
    this.iIL.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134663);
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(134658);
    String str = this.iIL.getAppId();
    AppMethodBeat.o(134658);
    return str;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(134655);
    ViewGroup localViewGroup;
    if (this.iIN != null)
    {
      localViewGroup = this.iIN.getContentContainer();
      AppMethodBeat.o(134655);
      return localViewGroup;
    }
    if (this.iIL.getRuntime() != null)
    {
      this.iIN = this.iIL.getRuntime().aMm();
      if (this.iIN != null)
      {
        localViewGroup = this.iIN.getContentContainer();
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
    Context localContext = this.iIL.getContext();
    AppMethodBeat.o(134659);
    return localContext;
  }
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(134662);
    this.iIL.h(paramInt, paramString);
    AppMethodBeat.o(134662);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(134660);
    if ((this.iIL.getRuntime() != null) && (!this.iIL.getRuntime().isDestroyed()))
    {
      AppMethodBeat.o(134660);
      return true;
    }
    AppMethodBeat.o(134660);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.f
 * JD-Core Version:    0.7.0.1
 */