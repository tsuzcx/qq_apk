package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.as;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g
  extends j
  implements com.tencent.mm.plugin.appbrand.jsapi.h
{
  private final y qqV;
  private final com.tencent.mm.plugin.appbrand.b qzF;
  private ap qzG;
  private f qzH;
  
  public g(y paramy, com.tencent.mm.plugin.appbrand.b paramb)
  {
    this.qqV = paramy;
    this.qzF = paramb;
  }
  
  private ap getCustomViewContainer()
  {
    AppMethodBeat.i(134656);
    ap localap;
    if (this.qzG != null)
    {
      localap = this.qzG;
      AppMethodBeat.o(134656);
      return localap;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.qzG = new ap((ViewGroup)getContentView());
      localap = this.qzG;
      AppMethodBeat.o(134656);
      return localap;
    }
    AppMethodBeat.o(134656);
    return null;
  }
  
  public final <T extends com.tencent.luggage.a.b> T T(Class<T> paramClass)
  {
    AppMethodBeat.i(134654);
    paramClass = this.qqV.T(paramClass);
    AppMethodBeat.o(134654);
    return paramClass;
  }
  
  public final void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(134661);
    this.qqV.V(paramRunnable);
    AppMethodBeat.o(134661);
  }
  
  public final void a(final bc parambc)
  {
    AppMethodBeat.i(134664);
    this.qzF.a(new as()
    {
      public final void a(o paramAnonymouso, kotlin.r<Long, Long> paramAnonymousr, String paramAnonymousString)
      {
        AppMethodBeat.i(321271);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(321271);
          return;
        }
        parambc.i(g.this).b(paramAnonymouso);
        AppMethodBeat.o(321271);
      }
    });
    AppMethodBeat.o(134664);
  }
  
  public final void a(final bc parambc, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134665);
    this.qzF.a(new as()
    {
      public final void a(o paramAnonymouso, kotlin.r<Long, Long> paramAnonymousr, String paramAnonymousString)
      {
        AppMethodBeat.i(321269);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(321269);
          return;
        }
        parambc.i(g.a(g.this)).b(paramAnonymouso);
        AppMethodBeat.o(321269);
      }
    });
    AppMethodBeat.o(134665);
  }
  
  public final boolean a(n paramn)
  {
    return false;
  }
  
  public final boolean a(String paramString, o paramo)
  {
    return true;
  }
  
  public final <T extends m> T aN(Class<T> paramClass)
  {
    return null;
  }
  
  public final <T extends n> T aO(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(final String paramString1, final String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134666);
    this.qzF.a(new as()
    {
      public final void a(o paramAnonymouso, kotlin.r<Long, Long> paramAnonymousr, String paramAnonymousString)
      {
        AppMethodBeat.i(321270);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(321270);
          return;
        }
        di.a(paramAnonymouso, paramString1, paramString2, 0);
        AppMethodBeat.o(321270);
      }
    });
    AppMethodBeat.o(134666);
  }
  
  public final void cJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134663);
    f(paramString1, paramString2, 0);
    AppMethodBeat.o(134663);
  }
  
  public final void callback(int paramInt, String paramString)
  {
    AppMethodBeat.i(134662);
    this.qqV.callback(paramInt, paramString);
    AppMethodBeat.o(134662);
  }
  
  public final boolean cdZ()
  {
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(321300);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(321264);
          g.this.destroy();
          AppMethodBeat.o(321264);
        }
      });
      AppMethodBeat.o(321300);
      return;
    }
    Log.i("MicroMsg.AppBrandServiceAdComponentView[AppBrandSplashAd]", "destroy view containers");
    if (this.qzG != null)
    {
      this.qzG.clear();
      this.qzG = null;
    }
    if (this.qzH != null)
    {
      this.qzH.removeAllViews();
      this.qzH = null;
    }
    AppMethodBeat.o(321300);
  }
  
  public final void f(final String paramString1, final String paramString2, final int paramInt)
  {
    AppMethodBeat.i(321352);
    this.qzF.a(new as()
    {
      public final void a(o paramAnonymouso, kotlin.r<Long, Long> paramAnonymousr, String paramAnonymousString)
      {
        AppMethodBeat.i(321273);
        if (paramAnonymouso == null)
        {
          AppMethodBeat.o(321273);
          return;
        }
        di.a(paramAnonymouso, paramString1, paramString2, paramInt);
        AppMethodBeat.o(321273);
      }
    });
    AppMethodBeat.o(321352);
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(134658);
    String str = this.qqV.getAppId();
    AppMethodBeat.o(134658);
    return str;
  }
  
  public final com.tencent.mm.plugin.appbrand.b.b getAppState()
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
    if (this.qzH != null)
    {
      localViewGroup = this.qzH.getContentContainer();
      AppMethodBeat.o(134655);
      return localViewGroup;
    }
    if (this.qqV.getRuntime() != null)
    {
      this.qzH = this.qqV.getRuntime().getRuntimeAdViewContainer();
      if (this.qzH != null)
      {
        localViewGroup = this.qzH.getContentContainer();
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
    Context localContext = this.qqV.getContext();
    AppMethodBeat.o(134659);
    return localContext;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.r getDialogContainer()
  {
    return null;
  }
  
  public final w getFileSystem()
  {
    return null;
  }
  
  public final f.c getInterceptor()
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.n.i getJsRuntime()
  {
    return null;
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(321348);
    this.qqV.i(paramRunnable, paramLong);
    AppMethodBeat.o(321348);
  }
  
  public final h.a ic(boolean paramBoolean)
  {
    AppMethodBeat.i(321312);
    if (paramBoolean)
    {
      if (this.qqV.getRuntime().qsP != null)
      {
        localObject = this.qqV.getRuntime().qsP;
        AppMethodBeat.o(321312);
        return localObject;
      }
      AppMethodBeat.o(321312);
      return null;
    }
    Object localObject = getCustomViewContainer();
    AppMethodBeat.o(321312);
    return localObject;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(134660);
    if ((this.qqV.getRuntime() != null) && (!this.qqV.getRuntime().qsE.get()))
    {
      AppMethodBeat.o(134660);
      return true;
    }
    AppMethodBeat.o(134660);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.g
 * JD-Core Version:    0.7.0.1
 */