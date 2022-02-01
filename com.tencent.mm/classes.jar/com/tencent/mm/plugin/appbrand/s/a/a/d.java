package com.tencent.mm.plugin.appbrand.s.a.a;

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
import com.tencent.mm.plugin.appbrand.s.a.e.a;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.a.a;
import d.g.a.b;
import d.g.b.u;
import d.g.b.v.c;
import d.g.b.w;
import d.y;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "windowActivity", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "handler", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "handler$delegate", "Lkotlin/Lazy;", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"})
public final class d
  implements c
{
  @Deprecated
  public static final a lne;
  public final Activity activity;
  private final f jgk;
  private final o lnd;
  
  static
  {
    AppMethodBeat.i(176483);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(d.class), "handler", "getHandler()Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;")) };
    lne = new a((byte)0);
    AppMethodBeat.o(176483);
  }
  
  public d(o paramo)
  {
    AppMethodBeat.i(177602);
    this.lnd = paramo;
    this.jgk = g.E((a)new b(this));
    this.activity = this.lnd.getActivity();
    AppMethodBeat.o(177602);
  }
  
  private final c blL()
  {
    AppMethodBeat.i(177601);
    c localc = (c)this.jgk.getValue();
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
      ad.e("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation but activity(" + this.activity + ") destroyed");
      if (parama != null)
      {
        parama.a(blL().aNL(), false);
        AppMethodBeat.o(176476);
        return;
      }
      AppMethodBeat.o(176476);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (this.activity.isInPictureInPictureMode()))
    {
      localObject2 = this.lnd;
      if (paramb != null) {
        localObject1 = paramb.name();
      }
      ((o)localObject2).setSoftOrientation((String)localObject1);
      if (paramb == null)
      {
        if (parama == null) {
          break label266;
        }
        parama.a(blL().aNL(), false);
        AppMethodBeat.o(176476);
      }
      switch (e.ciE[paramb.ordinal()])
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
      blL().a(paramb, parama);
      AppMethodBeat.o(176476);
      return;
    }
    Object localObject3 = new AtomicBoolean(true);
    o localo = this.lnd;
    if (paramb != null) {
      localObject2 = paramb.name();
    }
    localo.setSoftOrientation((String)localObject2);
    blL().a(paramb, (e.a)new d(this, parama, (AtomicBoolean)localObject3, (View)localObject1));
    ((AtomicBoolean)localObject3).set(false);
    AppMethodBeat.o(176476);
  }
  
  public final e.b aNL()
  {
    AppMethodBeat.i(176481);
    if (this.activity != null)
    {
      localObject = blL().aNL();
      AppMethodBeat.o(176481);
      return localObject;
    }
    Object localObject = this.lnd.blU();
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
        localObject = e.b.lmO;
        AppMethodBeat.o(176481);
        return localObject;
        if (((Integer)localObject).intValue() != 2) {
          break;
        }
      }
      if (((Integer)localObject).intValue() != 1) {
        break label74;
      }
      localObject = e.b.lmS;
      AppMethodBeat.o(176481);
      return localObject;
    }
    label141:
    localObject = e.b.lmT;
    AppMethodBeat.o(176481);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176477);
    blL().onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(176477);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(176479);
    blL().onPause();
    AppMethodBeat.o(176479);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(176478);
    blL().onResume();
    AppMethodBeat.o(176478);
  }
  
  public final void release()
  {
    AppMethodBeat.i(176480);
    if ((this.activity == null) || (this.activity.isDestroyed()) || (this.activity.isFinishing())) {
      blL().release();
    }
    if (d.g.b.k.g(this.lnd.lnW, (d)this)) {
      this.lnd.lnW = null;
    }
    AppMethodBeat.o(176480);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<c>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(d paramd, e.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "orientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "success", "", "onOrientationChanged"})
  static final class d
    implements e.a
  {
    d(d paramd, e.a parama, AtomicBoolean paramAtomicBoolean, View paramView) {}
    
    public final void a(final e.b paramb, final boolean paramBoolean)
    {
      AppMethodBeat.i(176475);
      d.blM();
      ad.i("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, callback from AppBrandDeviceOrientationHandler, orientation:" + paramb + ", success:" + paramBoolean);
      paramb = new a(this, paramb, paramBoolean);
      if ((!paramBoolean) || (this.lnh.get()))
      {
        paramb.invoke("syncReturn");
        AppMethodBeat.o(176475);
        return;
      }
      View localView = this.lni;
      a locala = (a)new d.g.b.l(paramb) {};
      v.c localc = new v.c();
      localc.Jhu = 0;
      localView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new f.a(localView, localc, locala));
      this.lni.postDelayed((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194376);
          this.lnj.invoke("timeout");
          AppMethodBeat.o(194376);
        }
      }, 100L);
      AppMethodBeat.o(176475);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl$requestDeviceOrientation$2$callback$1", "Lkotlin/Function1;", "", "", "antiReentryGuard", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invoke", "reason", "luggage-wxa-app_release"})
    public static final class a
      implements b<String, y>
    {
      private final AtomicBoolean lnk;
      
      a(e.b paramb, boolean paramBoolean)
      {
        AppMethodBeat.i(194379);
        this.lnk = new AtomicBoolean(true);
        AppMethodBeat.o(194379);
      }
      
      public final void invoke(String paramString)
      {
        AppMethodBeat.i(194377);
        d.g.b.k.h(paramString, "reason");
        o localo;
        if (this.lnk.getAndSet(false))
        {
          d.blM();
          ad.i("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, will invoke outer listener reason:[" + paramString + "], orientation:" + paramb + " success:" + paramBoolean);
          paramString = this.lnl.iHK;
          if (paramString != null) {
            paramString.a(paramb, paramBoolean);
          }
          localo = d.a(this.lnl.lnf);
          paramString = paramb;
          if (paramString == null) {
            break label133;
          }
        }
        label133:
        for (paramString = paramString.name();; paramString = null)
        {
          localo.setSoftOrientation(paramString);
          AppMethodBeat.o(194377);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.a.d
 * JD-Core Version:    0.7.0.1
 */