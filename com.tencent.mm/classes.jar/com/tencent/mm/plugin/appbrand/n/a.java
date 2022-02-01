package com.tencent.mm.plugin.appbrand.n;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class a
  extends LinearLayout
  implements h
{
  private static volatile int mOp;
  private ac cwK;
  public ao kGU;
  public LinearLayout mOo;
  public Runnable mOq;
  
  public a(Context paramContext, ac paramac)
  {
    super(paramContext);
    AppMethodBeat.i(219312);
    this.mOq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219311);
        Log.i("MicroMsg.AppBrandKeyBoardComponentView", "clear all views runnable");
        if (a.a(a.this) != null) {
          a.a(a.this).clear();
        }
        if (a.b(a.this) != null) {
          a.b(a.this).removeAllViews();
        }
        AppMethodBeat.o(219311);
      }
    };
    this.cwK = paramac;
    this.mOo = this;
    AppMethodBeat.o(219312);
  }
  
  public final <T extends com.tencent.luggage.a.b> T M(Class<T> paramClass)
  {
    AppMethodBeat.i(219329);
    paramClass = this.cwK.M(paramClass);
    AppMethodBeat.o(219329);
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
    AppMethodBeat.i(219327);
    this.cwK.P(paramRunnable);
    AppMethodBeat.o(219327);
  }
  
  public final void a(bc parambc)
  {
    AppMethodBeat.i(219325);
    this.cwK.a(parambc);
    AppMethodBeat.o(219325);
  }
  
  public final void a(bc parambc, o paramo)
  {
    AppMethodBeat.i(219326);
    this.cwK.a(parambc, paramo);
    AppMethodBeat.o(219326);
  }
  
  public final void a(bc parambc, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(219318);
    Log.d("MicroMsg.AppBrandKeyBoardComponentView", "publish JsApiEvent event, int[] dst");
    this.cwK.a(parambc);
    AppMethodBeat.o(219318);
  }
  
  public final void a(i.b paramb) {}
  
  public final void a(i.c paramc) {}
  
  public final void a(i.d paramd) {}
  
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
  
  public final void b(i.b paramb) {}
  
  public final void b(i.c paramc) {}
  
  public final void b(i.d paramd) {}
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(219317);
    Log.d("MicroMsg.AppBrandKeyBoardComponentView", "publish String event, String data, int[] dst");
    this.cwK.c(paramString1, paramString2, 0);
    AppMethodBeat.o(219317);
  }
  
  public final boolean bsV()
  {
    AppMethodBeat.i(219323);
    boolean bool = this.cwK.bsV();
    AppMethodBeat.o(219323);
    return bool;
  }
  
  public final boolean btO()
  {
    return false;
  }
  
  public final void co(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219324);
    this.cwK.c(paramString1, paramString2, 0);
    AppMethodBeat.o(219324);
  }
  
  public final h.a gA(boolean paramBoolean)
  {
    AppMethodBeat.i(219316);
    if (paramBoolean)
    {
      localObject = getGlobalCustomViewContainer();
      AppMethodBeat.o(219316);
      return localObject;
    }
    Object localObject = getCustomViewContainer();
    AppMethodBeat.o(219316);
    return localObject;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(219321);
    String str = this.cwK.getAppId();
    AppMethodBeat.o(219321);
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
    AppMethodBeat.i(219320);
    int i = hashCode();
    AppMethodBeat.o(219320);
    return i;
  }
  
  public final View getContentView()
  {
    return this.mOo;
  }
  
  public final ao getCustomViewContainer()
  {
    AppMethodBeat.i(219314);
    ao localao;
    if (this.kGU != null)
    {
      Log.d("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, existed ViewContainer");
      localao = this.kGU;
      AppMethodBeat.o(219314);
      return localao;
    }
    if ((getContentView() instanceof ViewGroup))
    {
      this.kGU = new ao((ViewGroup)getContentView());
      Log.d("MicroMsg.AppBrandKeyBoardComponentView", "getCustomViewContainer, create customViewContainer");
      localao = this.kGU;
      AppMethodBeat.o(219314);
      return localao;
    }
    AppMethodBeat.o(219314);
    return null;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.dialog.m getDialogContainer()
  {
    return null;
  }
  
  public final q getFileSystem()
  {
    return null;
  }
  
  public final h.a getGlobalCustomViewContainer()
  {
    AppMethodBeat.i(219315);
    if (getRuntime().kAT != null)
    {
      j localj = getRuntime().kAT;
      AppMethodBeat.o(219315);
      return localj;
    }
    AppMethodBeat.o(219315);
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
    return mOp;
  }
  
  public final AppBrandRuntime getRuntime()
  {
    AppMethodBeat.i(219313);
    AppBrandRuntime localAppBrandRuntime = this.cwK.getRuntime();
    AppMethodBeat.o(219313);
    return localAppBrandRuntime;
  }
  
  public final void i(int paramInt, String paramString)
  {
    AppMethodBeat.i(219319);
    this.cwK.i(paramInt, paramString);
    AppMethodBeat.o(219319);
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(219328);
    this.cwK.i(paramRunnable, paramLong);
    AppMethodBeat.o(219328);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(219322);
    if ((getRuntime() != null) && (!getRuntime().isDestroyed()))
    {
      AppMethodBeat.o(219322);
      return true;
    }
    AppMethodBeat.o(219322);
    return false;
  }
  
  public final void setInterceptor(f.b paramb) {}
  
  public final void setRootContainerViewId(int paramInt)
  {
    mOp = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a
 * JD-Core Version:    0.7.0.1
 */