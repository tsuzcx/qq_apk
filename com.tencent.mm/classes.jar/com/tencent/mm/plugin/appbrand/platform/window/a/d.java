package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.app.PictureInPictureParams.Builder;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "windowActivity", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "handler", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "handler$delegate", "Lkotlin/Lazy;", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class d
  implements c
{
  @Deprecated
  public static final d.a qGP;
  final Activity activity;
  private final f ocu;
  private final o qGO;
  
  static
  {
    AppMethodBeat.i(176483);
    qGP = new d.a((byte)0);
    AppMethodBeat.o(176483);
  }
  
  public d(o paramo)
  {
    AppMethodBeat.i(177602);
    this.qGO = paramo;
    this.ocu = g.ar((a)new b(this));
    this.activity = this.qGO.getActivity();
    AppMethodBeat.o(177602);
  }
  
  private final c cgU()
  {
    AppMethodBeat.i(177601);
    c localc = (c)this.ocu.getValue();
    AppMethodBeat.o(177601);
    return localc;
  }
  
  public final void a(e.b paramb, final e.a parama)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(176476);
    if (this.activity == null)
    {
      ((a)new c(this, parama)).invoke();
      AppMethodBeat.o(176476);
      return;
    }
    if ((this.activity.isFinishing()) || (this.activity.isDestroyed()))
    {
      Log.e("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation but activity(" + this.activity + ") destroyed");
      if (parama != null)
      {
        parama.a(cgU().cgS(), false);
        AppMethodBeat.o(176476);
        return;
      }
      AppMethodBeat.o(176476);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (this.activity.isInPictureInPictureMode()))
    {
      localObject2 = this.qGO;
      if (paramb != null) {
        localObject1 = paramb.name();
      }
      ((o)localObject2).setSoftOrientation((String)localObject1);
      if (paramb == null)
      {
        if (parama == null) {
          break label266;
        }
        parama.a(cgU().cgS(), false);
        AppMethodBeat.o(176476);
      }
      switch (e.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        this.activity.enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational(16, 9)).build());
        if (parama != null)
        {
          parama.a(paramb, true);
          AppMethodBeat.o(176476);
          return;
          AppMethodBeat.o(176476);
          return;
        }
        break;
      case 1: 
        label266:
        this.activity.enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational(9, 16)).build());
        if (parama != null)
        {
          parama.a(paramb, true);
          AppMethodBeat.o(176476);
          return;
        }
        AppMethodBeat.o(176476);
        return;
      }
      AppMethodBeat.o(176476);
      return;
    }
    localObject1 = this.activity.getWindow();
    if (localObject1 != null) {}
    for (localObject1 = ((Window)localObject1).getDecorView();; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject3 = ((View)localObject1).getViewTreeObserver();
        if ((localObject3 != null) && (((ViewTreeObserver)localObject3).isAlive() == true)) {
          break;
        }
      }
      cgU().a(paramb, parama);
      AppMethodBeat.o(176476);
      return;
    }
    Object localObject3 = new AtomicBoolean(true);
    o localo = this.qGO;
    if (paramb != null) {
      localObject2 = paramb.name();
    }
    localo.setSoftOrientation((String)localObject2);
    cgU().a(paramb, (e.a)new d(this, parama, (AtomicBoolean)localObject3, (View)localObject1));
    ((AtomicBoolean)localObject3).set(false);
    AppMethodBeat.o(176476);
  }
  
  public final e.b cgS()
  {
    AppMethodBeat.i(176481);
    if (this.activity != null)
    {
      localObject = cgU().cgS();
      AppMethodBeat.o(176481);
      return localObject;
    }
    Object localObject = this.qGO.chd();
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      if (localObject != null)
      {
        localObject = Integer.valueOf(((Display)localObject).getRotation());
        if (localObject != null) {
          break label91;
        }
        label66:
        if (localObject != null) {
          break label110;
        }
        if (localObject != null) {
          break label121;
        }
        label74:
        if (localObject != null) {
          break label141;
        }
      }
    }
    label91:
    label110:
    label121:
    while (((Integer)localObject).intValue() != 3)
    {
      AppMethodBeat.o(176481);
      return null;
      localObject = null;
      break;
      if (((Integer)localObject).intValue() != 0) {
        break label66;
      }
      for (;;)
      {
        localObject = e.b.qGv;
        AppMethodBeat.o(176481);
        return localObject;
        if (((Integer)localObject).intValue() != 2) {
          break;
        }
      }
      if (((Integer)localObject).intValue() != 1) {
        break label74;
      }
      localObject = e.b.qGz;
      AppMethodBeat.o(176481);
      return localObject;
    }
    label141:
    localObject = e.b.qGA;
    AppMethodBeat.o(176481);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176477);
    cgU().onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(176477);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(176479);
    cgU().onPause();
    AppMethodBeat.o(176479);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(176478);
    cgU().onResume();
    AppMethodBeat.o(176478);
  }
  
  public final void release()
  {
    AppMethodBeat.i(176480);
    if ((this.activity == null) || (this.activity.isDestroyed()) || (this.activity.isFinishing())) {
      cgU().release();
    }
    if (p.h(this.qGO.qHH, (d)this)) {
      this.qGO.qHH = null;
    }
    AppMethodBeat.o(176480);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<c>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(d paramd, e.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "orientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "success", "", "onOrientationChanged"})
  static final class d
    implements e.a
  {
    d(d paramd, e.a parama, AtomicBoolean paramAtomicBoolean, View paramView) {}
    
    public final void a(final e.b paramb, final boolean paramBoolean)
    {
      AppMethodBeat.i(176475);
      d.cgV();
      Log.i("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, callback from AppBrandDeviceOrientationHandler, orientation:" + paramb + ", success:" + paramBoolean);
      paramb = new a(this, paramb, paramBoolean);
      if ((!paramBoolean) || (this.qGS.get()))
      {
        paramb.invoke("syncReturn");
        AppMethodBeat.o(176475);
        return;
      }
      View localView = this.qGT;
      a locala = (a)new q(paramb) {};
      aa.d locald = new aa.d();
      locald.aaBA = 0;
      localView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new f.a(localView, locald, locala));
      this.qGT.postDelayed((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(245951);
          this.qGU.invoke("timeout");
          AppMethodBeat.o(245951);
        }
      }, 100L);
      AppMethodBeat.o(176475);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl$requestDeviceOrientation$2$callback$1", "Lkotlin/Function1;", "", "", "antiReentryGuard", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invoke", "reason", "luggage-wxa-app_release"})
    public static final class a
      implements b<String, x>
    {
      private final AtomicBoolean qGV;
      
      a(e.b paramb, boolean paramBoolean)
      {
        AppMethodBeat.i(244182);
        this.qGV = new AtomicBoolean(true);
        AppMethodBeat.o(244182);
      }
      
      public final void invoke(String paramString)
      {
        AppMethodBeat.i(244180);
        p.k(paramString, "reason");
        o localo;
        if (this.qGV.getAndSet(false))
        {
          d.cgV();
          Log.i("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, will invoke outer listener reason:[" + paramString + "], orientation:" + paramb + " success:" + paramBoolean);
          paramString = this.qGW.qGR;
          if (paramString != null) {
            paramString.a(paramb, paramBoolean);
          }
          localo = d.a(this.qGW.qGQ);
          paramString = paramb;
          if (paramString == null) {
            break label133;
          }
        }
        label133:
        for (paramString = paramString.name();; paramString = null)
        {
          localo.setSoftOrientation(paramString);
          AppMethodBeat.o(244180);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.d
 * JD-Core Version:    0.7.0.1
 */