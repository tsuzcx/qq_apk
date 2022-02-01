package com.tencent.mm.plugin.appbrand.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
public final class a
  extends LinearLayout
  implements g
{
  private static volatile int pPi;
  private final ad cvo;
  public ap nAB;
  public LinearLayout pPh;
  public final Runnable pPj;
  
  public a(Context paramContext, ad paramad)
  {
    super(paramContext);
    AppMethodBeat.i(246576);
    this.pPj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(242618);
        Log.i("MicroMsg.AppBrandKeyBoardComponentView", "clear all views runnable");
        if (a.a(a.this) != null) {
          a.a(a.this).clear();
        }
        if (a.b(a.this) != null) {
          a.b(a.this).removeAllViews();
        }
        AppMethodBeat.o(242618);
      }
    };
    this.cvo = paramad;
    this.pPh = this;
    AppMethodBeat.o(246576);
  }
  
  public final <T extends com.tencent.luggage.a.b> T K(Class<T> paramClass)
  {
    AppMethodBeat.i(246609);
    paramClass = this.cvo.K(paramClass);
    AppMethodBeat.o(246609);
    return paramClass;
  }
  
  public final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(246607);
    this.cvo.P(paramRunnable);
    AppMethodBeat.o(246607);
  }
  
  public final void a(az paramaz)
  {
    AppMethodBeat.i(246592);
    this.cvo.ct(paramaz.getName(), paramaz.getData());
    AppMethodBeat.o(246592);
  }
  
  public final void a(az paramaz, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(246582);
    Log.d("MicroMsg.AppBrandKeyBoardComponentView", "publish JsApiEvent event, int[] dst");
    paramaz.b(this.cvo, getComponentId()).bPO();
    AppMethodBeat.o(246582);
  }
  
  public final void a(h.b paramb) {}
  
  public final void a(h.c paramc) {}
  
  public final void a(h.d paramd) {}
  
  public final boolean a(m paramm)
  {
    return false;
  }
  
  public final boolean a(String paramString, o paramo)
  {
    AppMethodBeat.i(246590);
    boolean bool = this.cvo.a(paramString, paramo);
    AppMethodBeat.o(246590);
    return bool;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.l> T au(Class<T> paramClass)
  {
    return null;
  }
  
  public final <T extends m> T av(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(h.b paramb) {}
  
  public final void b(h.c paramc) {}
  
  public final void b(h.d paramd) {}
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(246581);
    Log.d("MicroMsg.AppBrandKeyBoardComponentView", "publish String event, String data, int[] dst");
    this.cvo.ct(paramString1, paramString2);
    AppMethodBeat.o(246581);
  }
  
  public final boolean bEN()
  {
    return false;
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(246598);
    this.cvo.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(246598);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(246596);
    this.cvo.ct(paramString1, paramString2);
    AppMethodBeat.o(246596);
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(246586);
    String str = this.cvo.getAppId();
    AppMethodBeat.o(246586);
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
    AppMethodBeat.i(246585);
    int i = hashCode();
    AppMethodBeat.o(246585);
    return i;
  }
  
  public final View getContentView()
  {
    return this.pPh;
  }
  
  public final ap getCustomViewContainer()
  {
    AppMethodBeat.i(246578);
    ap localap;
    if (this.nAB != null)
    {
      Log.d("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, existed ViewContainer");
      localap = this.nAB;
      AppMethodBeat.o(246578);
      return localap;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.nAB = new ap((ViewGroup)getContentView());
      Log.d("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, create customViewContainer");
      localap = this.nAB;
      AppMethodBeat.o(246578);
      return localap;
    }
    AppMethodBeat.o(246578);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.l getDialogContainer()
  {
    return null;
  }
  
  public final r getFileSystem()
  {
    return null;
  }
  
  public final g.a getGlobalCustomViewContainer()
  {
    AppMethodBeat.i(246579);
    if (getRuntime().nuf != null)
    {
      k localk = getRuntime().nuf;
      AppMethodBeat.o(246579);
      return localk;
    }
    AppMethodBeat.o(246579);
    return null;
  }
  
  public final e.c getInterceptor()
  {
    return null;
  }
  
  public final i getJsRuntime()
  {
    return null;
  }
  
  public final FrameLayout getPageArea()
  {
    return null;
  }
  
  public final int getRootContainerViewId()
  {
    return pPi;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    AppMethodBeat.i(246577);
    AppBrandRuntime localAppBrandRuntime = this.cvo.getRuntime();
    AppMethodBeat.o(246577);
    return localAppBrandRuntime;
  }
  
  public final void h(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(246608);
    this.cvo.h(paramRunnable, paramLong);
    AppMethodBeat.o(246608);
  }
  
  public final g.a hl(boolean paramBoolean)
  {
    AppMethodBeat.i(246580);
    if (paramBoolean)
    {
      localObject = getGlobalCustomViewContainer();
      AppMethodBeat.o(246580);
      return localObject;
    }
    Object localObject = getCustomViewContainer();
    AppMethodBeat.o(246580);
    return localObject;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(246588);
    if ((getRuntime() != null) && (!getRuntime().ntU.get()))
    {
      AppMethodBeat.o(246588);
      return true;
    }
    AppMethodBeat.o(246588);
    return false;
  }
  
  public final void j(int paramInt, String paramString)
  {
    AppMethodBeat.i(246583);
    this.cvo.j(paramInt, paramString);
    AppMethodBeat.o(246583);
  }
  
  public final void setEvalInterceptor(e.a parama) {}
  
  public final void setInterceptor(e.c paramc) {}
  
  public final void setRootContainerViewId(int paramInt)
  {
    pPi = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a
 * JD-Core Version:    0.7.0.1
 */