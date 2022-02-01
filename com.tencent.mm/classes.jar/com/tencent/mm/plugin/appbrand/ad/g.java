package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.i
  implements com.tencent.mm.plugin.appbrand.jsapi.g
{
  private final com.tencent.mm.plugin.appbrand.b nAA;
  private ap nAB;
  private f nAC;
  private final v nAz;
  
  public g(v paramv, com.tencent.mm.plugin.appbrand.b paramb)
  {
    this.nAz = paramv;
    this.nAA = paramb;
  }
  
  private ap getCustomViewContainer()
  {
    AppMethodBeat.i(134656);
    ap localap;
    if (this.nAB != null)
    {
      localap = this.nAB;
      AppMethodBeat.o(134656);
      return localap;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.nAB = new ap((ViewGroup)getContentView());
      localap = this.nAB;
      AppMethodBeat.o(134656);
      return localap;
    }
    AppMethodBeat.o(134656);
    return null;
  }
  
  public final <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass)
  {
    AppMethodBeat.i(134654);
    paramClass = this.nAz.K(paramClass);
    AppMethodBeat.o(134654);
    return paramClass;
  }
  
  public final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(134661);
    this.nAz.P(paramRunnable);
    AppMethodBeat.o(134661);
  }
  
  public final void a(final az paramaz)
  {
    AppMethodBeat.i(134664);
    this.nAA.a(new b.b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.m.o paramAnonymouso, kotlin.o<Long, Long> paramAnonymouso1)
      {
        AppMethodBeat.i(242886);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(242886);
          return;
        }
        paramaz.j(g.this).b(paramAnonymouso);
        AppMethodBeat.o(242886);
      }
    });
    AppMethodBeat.o(134664);
  }
  
  public final void a(final az paramaz, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134665);
    this.nAA.a(new b.b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.m.o paramAnonymouso, kotlin.o<Long, Long> paramAnonymouso1)
      {
        AppMethodBeat.i(244271);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(244271);
          return;
        }
        paramaz.j(g.a(g.this)).b(paramAnonymouso);
        AppMethodBeat.o(244271);
      }
    });
    AppMethodBeat.o(134665);
  }
  
  public final boolean a(m paramm)
  {
    return false;
  }
  
  public final boolean a(String paramString, com.tencent.mm.plugin.appbrand.m.o paramo)
  {
    return true;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.l> T au(Class<T> paramClass)
  {
    return null;
  }
  
  public final <T extends m> T av(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(final String paramString1, final String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134666);
    this.nAA.a(new b.b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.m.o paramAnonymouso, kotlin.o<Long, Long> paramAnonymouso1)
      {
        AppMethodBeat.i(245593);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(245593);
          return;
        }
        cy.a(paramAnonymouso, paramString1, paramString2, 0);
        AppMethodBeat.o(245593);
      }
    });
    AppMethodBeat.o(134666);
  }
  
  public final boolean bEN()
  {
    return false;
  }
  
  public final void c(final String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(245265);
    this.nAA.a(new b.b()
    {
      public final void a(com.tencent.mm.plugin.appbrand.m.o paramAnonymouso, kotlin.o<Long, Long> paramAnonymouso1)
      {
        AppMethodBeat.i(245449);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(245449);
          return;
        }
        cy.a(paramAnonymouso, paramString1, paramString2, paramInt);
        AppMethodBeat.o(245449);
      }
    });
    AppMethodBeat.o(245265);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134663);
    c(paramString1, paramString2, 0);
    AppMethodBeat.o(134663);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(245240);
    Log.i("MicroMsg.AppBrandServiceAdComponentView[AppBrandSplashAd]", "destroy view containers");
    if (this.nAB != null)
    {
      this.nAB.clear();
      this.nAB = null;
    }
    if (this.nAC != null)
    {
      this.nAC.removeAllViews();
      this.nAC = null;
    }
    AppMethodBeat.o(245240);
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(134658);
    String str = this.nAz.getAppId();
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
    if (this.nAC != null)
    {
      localViewGroup = this.nAC.getContentContainer();
      AppMethodBeat.o(134655);
      return localViewGroup;
    }
    if (this.nAz.getRuntime() != null)
    {
      this.nAC = this.nAz.getRuntime().getRuntimeAdViewContainer();
      if (this.nAC != null)
      {
        localViewGroup = this.nAC.getContentContainer();
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
    Context localContext = this.nAz.getContext();
    AppMethodBeat.o(134659);
    return localContext;
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
  
  public final com.tencent.mm.plugin.appbrand.m.i getJsRuntime()
  {
    return null;
  }
  
  public final void h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(245259);
    this.nAz.h(paramRunnable, paramLong);
    AppMethodBeat.o(245259);
  }
  
  public final g.a hl(boolean paramBoolean)
  {
    AppMethodBeat.i(245246);
    if (paramBoolean)
    {
      if (this.nAz.getRuntime().nuf != null)
      {
        localObject = this.nAz.getRuntime().nuf;
        AppMethodBeat.o(245246);
        return localObject;
      }
      AppMethodBeat.o(245246);
      return null;
    }
    Object localObject = getCustomViewContainer();
    AppMethodBeat.o(245246);
    return localObject;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(134660);
    if ((this.nAz.getRuntime() != null) && (!this.nAz.getRuntime().ntU.get()))
    {
      AppMethodBeat.o(134660);
      return true;
    }
    AppMethodBeat.o(134660);
    return false;
  }
  
  public final void j(int paramInt, String paramString)
  {
    AppMethodBeat.i(134662);
    this.nAz.j(paramInt, paramString);
    AppMethodBeat.o(134662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.g
 * JD-Core Version:    0.7.0.1
 */