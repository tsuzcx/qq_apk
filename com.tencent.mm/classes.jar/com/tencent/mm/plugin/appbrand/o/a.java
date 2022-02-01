package com.tencent.mm.plugin.appbrand.o;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  extends LinearLayout
  implements h
{
  private static volatile int sTI;
  private final ad enm;
  public ap qzG;
  public LinearLayout sTH;
  public final Runnable sTJ;
  
  public a(Context paramContext, ad paramad)
  {
    super(paramContext);
    AppMethodBeat.i(317290);
    this.sTJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317295);
        Log.i("MicroMsg.AppBrandKeyBoardComponentView", "clear all views runnable");
        if (a.a(a.this) != null) {
          a.a(a.this).clear();
        }
        if (a.b(a.this) != null) {
          a.b(a.this).removeAllViews();
        }
        AppMethodBeat.o(317295);
      }
    };
    this.enm = paramad;
    this.sTH = this;
    AppMethodBeat.o(317290);
  }
  
  public final <T extends com.tencent.luggage.a.b> T T(Class<T> paramClass)
  {
    AppMethodBeat.i(317375);
    paramClass = this.enm.T(paramClass);
    AppMethodBeat.o(317375);
    return paramClass;
  }
  
  public final void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(317363);
    this.enm.V(paramRunnable);
    AppMethodBeat.o(317363);
  }
  
  public final void a(bc parambc)
  {
    AppMethodBeat.i(317332);
    this.enm.cJ(parambc.getName(), parambc.getData());
    AppMethodBeat.o(317332);
  }
  
  public final void a(bc parambc, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(317305);
    Log.d("MicroMsg.AppBrandKeyBoardComponentView", "publish JsApiEvent event, int[] dst");
    parambc.b(this.enm, getComponentId()).cpV();
    AppMethodBeat.o(317305);
  }
  
  public final void a(i.b paramb) {}
  
  public final void a(i.c paramc) {}
  
  public final void a(i.d paramd) {}
  
  public final boolean a(n paramn)
  {
    return false;
  }
  
  public final boolean a(String paramString, o paramo)
  {
    AppMethodBeat.i(317330);
    boolean bool = this.enm.a(paramString, paramo);
    AppMethodBeat.o(317330);
    return bool;
  }
  
  public final <T extends m> T aN(Class<T> paramClass)
  {
    return null;
  }
  
  public final <T extends n> T aO(Class<T> paramClass)
  {
    return null;
  }
  
  public final void b(i.b paramb) {}
  
  public final void b(i.c paramc) {}
  
  public final void b(i.d paramd) {}
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(317303);
    Log.d("MicroMsg.AppBrandKeyBoardComponentView", "publish String event, String data, int[] dst");
    this.enm.cJ(paramString1, paramString2);
    AppMethodBeat.o(317303);
  }
  
  public final void cJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(317335);
    this.enm.cJ(paramString1, paramString2);
    AppMethodBeat.o(317335);
  }
  
  public final void callback(int paramInt, String paramString)
  {
    AppMethodBeat.i(317310);
    this.enm.callback(paramInt, paramString);
    AppMethodBeat.o(317310);
  }
  
  public final boolean cdZ()
  {
    return false;
  }
  
  public final void f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(317338);
    this.enm.f(paramString1, paramString2, paramInt);
    AppMethodBeat.o(317338);
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(317322);
    String str = this.enm.getAppId();
    AppMethodBeat.o(317322);
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
    AppMethodBeat.i(317318);
    int i = hashCode();
    AppMethodBeat.o(317318);
    return i;
  }
  
  public final View getContentView()
  {
    return this.sTH;
  }
  
  public final ap getCustomViewContainer()
  {
    AppMethodBeat.i(317298);
    ap localap;
    if (this.qzG != null)
    {
      Log.d("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, existed ViewContainer");
      localap = this.qzG;
      AppMethodBeat.o(317298);
      return localap;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.qzG = new ap((ViewGroup)getContentView());
      Log.d("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, create customViewContainer");
      localap = this.qzG;
      AppMethodBeat.o(317298);
      return localap;
    }
    AppMethodBeat.o(317298);
    return null;
  }
  
  public final r getDialogContainer()
  {
    return null;
  }
  
  public final w getFileSystem()
  {
    return null;
  }
  
  public final h.a getGlobalCustomViewContainer()
  {
    AppMethodBeat.i(317300);
    if (getRuntime().qsP != null)
    {
      k localk = getRuntime().qsP;
      AppMethodBeat.o(317300);
      return localk;
    }
    AppMethodBeat.o(317300);
    return null;
  }
  
  public final f.c getInterceptor()
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
    return sTI;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    AppMethodBeat.i(317294);
    AppBrandRuntime localAppBrandRuntime = this.enm.getRuntime();
    AppMethodBeat.o(317294);
    return localAppBrandRuntime;
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(317370);
    this.enm.i(paramRunnable, paramLong);
    AppMethodBeat.o(317370);
  }
  
  public final h.a ic(boolean paramBoolean)
  {
    AppMethodBeat.i(317302);
    if (paramBoolean)
    {
      localObject = getGlobalCustomViewContainer();
      AppMethodBeat.o(317302);
      return localObject;
    }
    Object localObject = getCustomViewContainer();
    AppMethodBeat.o(317302);
    return localObject;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(317324);
    if ((getRuntime() != null) && (!getRuntime().qsE.get()))
    {
      AppMethodBeat.o(317324);
      return true;
    }
    AppMethodBeat.o(317324);
    return false;
  }
  
  public final void setEvalInterceptor(f.a parama) {}
  
  public final void setInterceptor(f.c paramc) {}
  
  public final void setRootContainerViewId(int paramInt)
  {
    sTI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.a
 * JD-Core Version:    0.7.0.1
 */