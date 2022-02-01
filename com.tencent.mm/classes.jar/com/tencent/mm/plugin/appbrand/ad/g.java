package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.s;
import java.util.Map;

public final class g
  extends j
  implements h
{
  private s kGT;
  public ao kGU;
  public f kGV;
  
  public g(s params)
  {
    AppMethodBeat.i(134653);
    this.kGT = params;
    AppMethodBeat.o(134653);
  }
  
  private ao getCustomViewContainer()
  {
    AppMethodBeat.i(134656);
    ao localao;
    if (this.kGU != null)
    {
      localao = this.kGU;
      AppMethodBeat.o(134656);
      return localao;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.kGU = new ao((ViewGroup)getContentView());
      localao = this.kGU;
      AppMethodBeat.o(134656);
      return localao;
    }
    AppMethodBeat.o(134656);
    return null;
  }
  
  public final <T extends com.tencent.luggage.a.b> T M(Class<T> paramClass)
  {
    AppMethodBeat.i(134654);
    paramClass = this.kGT.M(paramClass);
    AppMethodBeat.o(134654);
    return paramClass;
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
    AppMethodBeat.i(134661);
    this.kGT.P(paramRunnable);
    AppMethodBeat.o(134661);
  }
  
  public final void a(bc parambc)
  {
    AppMethodBeat.i(134664);
    this.kGT.a(parambc);
    AppMethodBeat.o(134664);
  }
  
  public final void a(bc parambc, o paramo)
  {
    AppMethodBeat.i(219299);
    this.kGT.a(parambc, paramo);
    AppMethodBeat.o(219299);
  }
  
  public final void a(bc parambc, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134665);
    this.kGT.a(parambc);
    AppMethodBeat.o(134665);
  }
  
  public final boolean a(n paramn)
  {
    return false;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m> T av(Class<T> paramClass)
  {
    return null;
  }
  
  public final <T extends n> T aw(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134666);
    this.kGT.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134666);
  }
  
  public final boolean bsV()
  {
    return this.kGT.kEa;
  }
  
  public final boolean btO()
  {
    return false;
  }
  
  public final void co(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134663);
    this.kGT.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134663);
  }
  
  public final h.a gA(boolean paramBoolean)
  {
    AppMethodBeat.i(219297);
    if (paramBoolean)
    {
      if (this.kGT.getRuntime().kAT != null)
      {
        localObject = this.kGT.getRuntime().kAT;
        AppMethodBeat.o(219297);
        return localObject;
      }
      AppMethodBeat.o(219297);
      return null;
    }
    Object localObject = getCustomViewContainer();
    AppMethodBeat.o(219297);
    return localObject;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(134658);
    String str = this.kGT.getAppId();
    AppMethodBeat.o(134658);
    return str;
  }
  
  public final com.tencent.mm.plugin.appbrand.a.b getAppState()
  {
    return null;
  }
  
  public final Handler getAsyncHandler()
  {
    return null;
  }
  
  public final int getComponentId()
  {
    AppMethodBeat.i(134657);
    int i = hashCode();
    AppMethodBeat.o(134657);
    return i;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(134655);
    ViewGroup localViewGroup;
    if (this.kGV != null)
    {
      localViewGroup = this.kGV.getContentContainer();
      AppMethodBeat.o(134655);
      return localViewGroup;
    }
    if (this.kGT.getRuntime() != null)
    {
      this.kGV = this.kGT.getRuntime().getRuntimeAdViewContainer();
      if (this.kGV != null)
      {
        localViewGroup = this.kGV.getContentContainer();
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
    Context localContext = this.kGT.getContext();
    AppMethodBeat.o(134659);
    return localContext;
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
  
  public final void i(int paramInt, String paramString)
  {
    AppMethodBeat.i(134662);
    this.kGT.i(paramInt, paramString);
    AppMethodBeat.o(134662);
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(219298);
    this.kGT.i(paramRunnable, paramLong);
    AppMethodBeat.o(219298);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(134660);
    if ((this.kGT.getRuntime() != null) && (!this.kGT.getRuntime().isDestroyed()))
    {
      AppMethodBeat.o(134660);
      return true;
    }
    AppMethodBeat.o(134660);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.g
 * JD-Core Version:    0.7.0.1
 */