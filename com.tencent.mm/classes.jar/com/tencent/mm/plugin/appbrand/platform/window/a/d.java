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
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "windowActivity", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "handler", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "handler$delegate", "Lkotlin/Lazy;", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c
{
  private static final d.a tLA;
  final Activity activity;
  private final j rdm;
  private final o tLB;
  
  static
  {
    AppMethodBeat.i(176483);
    tLA = new d.a((byte)0);
    AppMethodBeat.o(176483);
  }
  
  public d(o paramo)
  {
    AppMethodBeat.i(177602);
    this.tLB = paramo;
    this.rdm = k.cm((a)new c(this));
    this.activity = AndroidContextUtil.castActivityOrNull(this.tLB.mContext);
    AppMethodBeat.o(177602);
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(317557);
    s.u(parame, "$callback");
    parame.invoke("timeout");
    AppMethodBeat.o(317557);
  }
  
  private static final void a(AtomicBoolean paramAtomicBoolean, View paramView, final com.tencent.mm.plugin.appbrand.platform.window.e.a parama, final d paramd, e.b paramb, final boolean paramBoolean)
  {
    AppMethodBeat.i(317574);
    s.u(paramAtomicBoolean, "$syncReturn");
    s.u(paramd, "this$0");
    Log.i("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, callback from AppBrandDeviceOrientationHandler, orientation:" + paramb + ", success:" + paramBoolean);
    parama = new e(paramb, paramBoolean, parama, paramd);
    if ((!paramBoolean) || (paramAtomicBoolean.get()))
    {
      parama.invoke("syncReturn");
      AppMethodBeat.o(317574);
      return;
    }
    paramAtomicBoolean = (a)new d(parama);
    paramd = new ah.d();
    paramView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new e.a(paramd, paramView, paramAtomicBoolean));
    paramView.postDelayed(new d..ExternalSyntheticLambda1(parama), 100L);
    AppMethodBeat.o(317574);
  }
  
  private final c cHS()
  {
    AppMethodBeat.i(177601);
    Object localObject = this.rdm.getValue();
    s.s(localObject, "<get-handler>(...)");
    localObject = (c)localObject;
    AppMethodBeat.o(177601);
    return localObject;
  }
  
  public final void a(e.b paramb, com.tencent.mm.plugin.appbrand.platform.window.e.a parama)
  {
    o localo = null;
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(176476);
    if (this.activity == null)
    {
      s.u(this, "this$0");
      if (parama != null) {
        parama.onOrientationChanged(cHQ(), false);
      }
      AppMethodBeat.o(176476);
      return;
    }
    if ((this.activity.isFinishing()) || (this.activity.isDestroyed()))
    {
      Log.e("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation but activity(" + this.activity + ") destroyed");
      if (parama != null) {
        parama.onOrientationChanged(cHS().cHQ(), false);
      }
      AppMethodBeat.o(176476);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (this.activity.isInPictureInPictureMode()))
    {
      localObject2 = this.tLB;
      if (paramb == null)
      {
        localObject1 = null;
        ((o)localObject2).setSoftOrientation((String)localObject1);
        if (paramb != null) {
          break label259;
        }
        i = -1;
        switch (i)
        {
        case 0: 
        default: 
          label169:
          this.activity.enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational(16, 9)).build());
          if (parama != null)
          {
            parama.onOrientationChanged(paramb, true);
            paramb = ah.aiuX;
          }
          break;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(176476);
        return;
        localObject1 = paramb.name();
        break;
        label259:
        i = b.$EnumSwitchMapping$0[paramb.ordinal()];
        break label169;
        if (parama == null) {}
        for (paramb = (e.b)localObject3; paramb == null; paramb = ah.aiuX)
        {
          AppMethodBeat.o(176476);
          return;
          parama.onOrientationChanged(cHS().cHQ(), false);
        }
        this.activity.enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational(9, 16)).build());
        if (parama == null) {}
        for (paramb = localo; paramb == null; paramb = ah.aiuX)
        {
          AppMethodBeat.o(176476);
          return;
          parama.onOrientationChanged(paramb, true);
        }
      }
    }
    Object localObject1 = this.activity.getWindow();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject3 = ((View)localObject1).getViewTreeObserver();
        if ((localObject3 == null) || (((ViewTreeObserver)localObject3).isAlive() != true)) {
          break label451;
        }
      }
    }
    label451:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label456;
      }
      cHS().a(paramb, parama);
      AppMethodBeat.o(176476);
      return;
      localObject1 = ((Window)localObject1).getDecorView();
      break;
    }
    label456:
    localObject3 = new AtomicBoolean(true);
    localo = this.tLB;
    if (paramb == null) {}
    for (;;)
    {
      localo.setSoftOrientation((String)localObject2);
      cHS().a(paramb, new d..ExternalSyntheticLambda0((AtomicBoolean)localObject3, (View)localObject1, parama, this));
      ((AtomicBoolean)localObject3).set(false);
      AppMethodBeat.o(176476);
      return;
      localObject2 = paramb.name();
    }
  }
  
  public final e.b cHQ()
  {
    AppMethodBeat.i(176481);
    if (this.activity != null)
    {
      localObject = cHS().cHQ();
      AppMethodBeat.o(176481);
      return localObject;
    }
    Object localObject = this.tLB.cIa();
    label49:
    label53:
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label98;
      }
      if (localObject != null) {
        break label110;
      }
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label123;
      }
      localObject = e.b.tLh;
      AppMethodBeat.o(176481);
      return localObject;
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = Integer.valueOf(((Display)localObject).getRotation());
      break;
      label98:
      if (((Integer)localObject).intValue() != 0) {
        break label49;
      }
      i = 1;
      continue;
      label110:
      if (((Integer)localObject).intValue() != 2) {
        break label53;
      }
      i = 1;
    }
    label123:
    if (localObject == null) {
      if (localObject != null) {
        break label159;
      }
    }
    label159:
    while (((Integer)localObject).intValue() != 3)
    {
      AppMethodBeat.o(176481);
      return null;
      if (((Integer)localObject).intValue() != 1) {
        break;
      }
      localObject = e.b.tLl;
      AppMethodBeat.o(176481);
      return localObject;
    }
    localObject = e.b.tLm;
    AppMethodBeat.o(176481);
    return localObject;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(176477);
    cHS().onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(176477);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(176479);
    cHS().onPause();
    AppMethodBeat.o(176479);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(176478);
    cHS().onResume();
    AppMethodBeat.o(176478);
  }
  
  public final void release()
  {
    AppMethodBeat.i(176480);
    if ((this.activity == null) || (this.activity.isDestroyed()) || (this.activity.isFinishing())) {
      cHS().release();
    }
    if (s.p(this.tLB.tMq, this)) {
      this.tLB.tMq = null;
    }
    AppMethodBeat.o(176480);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<c>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(d.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl$requestDeviceOrientation$2$callback$1", "Lkotlin/Function1;", "", "", "antiReentryGuard", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invoke", "reason", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements b<String, ah>
  {
    private final AtomicBoolean tLE;
    
    e(e.b paramb, boolean paramBoolean, com.tencent.mm.plugin.appbrand.platform.window.e.a parama, d paramd)
    {
      AppMethodBeat.i(317513);
      this.tLE = new AtomicBoolean(true);
      AppMethodBeat.o(317513);
    }
    
    public final void invoke(String paramString)
    {
      AppMethodBeat.i(317517);
      s.u(paramString, "reason");
      o localo;
      if (this.tLE.getAndSet(false))
      {
        Log.i("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, will invoke outer listener reason:[" + paramString + "], orientation:" + this.tLF + " success:" + paramBoolean);
        paramString = parama;
        if (paramString != null) {
          paramString.onOrientationChanged(this.tLF, paramBoolean);
        }
        localo = d.a(paramd);
        paramString = this.tLF;
        if (paramString != null) {
          break label120;
        }
      }
      label120:
      for (paramString = null;; paramString = paramString.name())
      {
        localo.setSoftOrientation(paramString);
        AppMethodBeat.o(317517);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.d
 * JD-Core Version:    0.7.0.1
 */