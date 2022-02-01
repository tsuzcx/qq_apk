package com.tencent.luggage.sdk.d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager;
import com.tencent.luggage.h.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.at;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.platform.window.g;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.k.j;
import d.l;
import d.v;
import junit.framework.AssertionFailedError;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "value", "", "_softOrientation", "set_softOrientation", "(Ljava/lang/String;)V", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "heightPx", "", "initConfig", "getInitConfig", "()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "setInitConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<set-?>", "", "isFold", "()Z", "isLastInMultiWindowMode", "lastOrientation", "lastScreenHDp", "lastScreenWDp", "lastVHeight", "getLastVHeight", "()I", "setLastVHeight", "(I)V", "lastVWidth", "getLastVWidth", "setLastVWidth", "maxEdge", "minEdge", "orientation", "resizable", "getResizable", "setResizable", "(Z)V", "scale", "", "systemRatio", "", "widthPx", "windowOrientation", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$WindowOrientation;", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "getOrientationHandler", "getScale", "getVDisplayMetrics", "init", "", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "parseOrientation", "configurationOrientation", "refreshDisplayInfo", "resetWindowOrientation", "setSoftOrientation", "name", "shouldInLargeScreenCompatMode", "tuningRtContentView", "waitViewMeasure", "forceWaitViewMeasure", "reason", "OnLayoutChangeListenerWithCounter", "WindowOrientation", "luggage-wechat-full-sdk_release"})
public class a<C extends AppBrandInitConfigLU>
  implements f<C>, g
{
  private final DisplayMetrics aJt;
  private double cpA;
  private a.b cpB;
  private String cpC;
  private final AppBrandRuntime cpD;
  private final e cpE;
  protected boolean cpl;
  private String cpm;
  public View cpn;
  protected C cpo;
  private int cpp;
  private int cpq;
  private int cpr;
  private int cps;
  private int cpt;
  private int cpu;
  private int cpv;
  private int cpw;
  private int cpx;
  private boolean cpy;
  private boolean cpz;
  private final Context ctx;
  private float scale;
  
  public a(AppBrandRuntime paramAppBrandRuntime, Context paramContext, e parame)
  {
    AppMethodBeat.i(220926);
    this.cpD = paramAppBrandRuntime;
    this.ctx = paramContext;
    this.cpE = parame;
    this.cpm = "portrait";
    this.scale = 1.0F;
    this.aJt = new DisplayMetrics();
    this.cpA = -1.0D;
    paramAppBrandRuntime = this.ctx.getResources();
    p.g(paramAppBrandRuntime, "ctx.resources");
    this.cpB = gC(paramAppBrandRuntime.getConfiguration().orientation);
    paramAppBrandRuntime = this.ctx.getResources();
    p.g(paramAppBrandRuntime, "ctx.resources");
    this.cpv = paramAppBrandRuntime.getConfiguration().orientation;
    paramAppBrandRuntime = this.ctx.getResources();
    p.g(paramAppBrandRuntime, "ctx.resources");
    this.cpu = paramAppBrandRuntime.getConfiguration().screenWidthDp;
    paramAppBrandRuntime = this.ctx.getResources();
    p.g(paramAppBrandRuntime, "ctx.resources");
    this.cpt = paramAppBrandRuntime.getConfiguration().screenHeightDp;
    EY();
    AppMethodBeat.o(220926);
  }
  
  private final void EY()
  {
    AppMethodBeat.i(220918);
    Object localObject1 = new Point();
    Object localObject2 = this.ctx.getSystemService("window");
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(220918);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
    if ((ai.dW(this.ctx)) && (i.cre.Fz()))
    {
      ((Display)localObject2).getRealSize((Point)localObject1);
      ((Display)localObject2).getRealMetrics(this.aJt);
    }
    for (;;)
    {
      this.cpp = ((Point)localObject1).x;
      this.cpq = ((Point)localObject1).y;
      this.cpr = Math.max(this.cpp, this.cpq);
      this.cps = Math.min(this.cpp, this.cpq);
      ae.i("Luggage.AppBrandWindowLayoutManager", "refreshDisplayInfo: system [w,h] = [%d,%d]", new Object[] { Integer.valueOf(this.cpp), Integer.valueOf(this.cpq) });
      AppMethodBeat.o(220918);
      return;
      ((Display)localObject2).getSize((Point)localObject1);
      ((Display)localObject2).getMetrics(this.aJt);
    }
  }
  
  private final void EZ()
  {
    AppMethodBeat.i(220922);
    if (!TextUtils.isEmpty((CharSequence)this.cpC))
    {
      ae.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation by softOrientation[%s]", new Object[] { this.cpC });
      this.cpE.a(e.b.UP(this.cpC), null);
      AppMethodBeat.o(220922);
      return;
    }
    e.b localb = this.cpE.aYg();
    p.g(localb, "activityOrientationHandler.getCurrentOrientation()");
    ae.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation with orientation[%s]", new Object[] { localb });
    this.cpE.a(localb, null);
    AppMethodBeat.o(220922);
  }
  
  private static a.b gC(int paramInt)
  {
    AppMethodBeat.i(220921);
    switch (paramInt)
    {
    default: 
      ae.w("Luggage.AppBrandWindowLayoutManager", "unexpected orientation [%d], fallback to portrait", new Object[] { Integer.valueOf(paramInt) });
      localb = a.b.cpH;
      AppMethodBeat.o(220921);
      return localb;
    case 2: 
      localb = a.b.cpG;
      AppMethodBeat.o(220921);
      return localb;
    }
    a.b localb = a.b.cpH;
    AppMethodBeat.o(220921);
    return localb;
  }
  
  public boolean EX()
  {
    AppMethodBeat.i(220917);
    boolean bool = ai.dW(ak.getContext());
    AppMethodBeat.o(220917);
    return bool;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b paramb)
  {
    AppMethodBeat.i(220924);
    if ((this.ctx instanceof Activity)) {}
    for (Activity localActivity = (Activity)this.ctx;; localActivity = null)
    {
      c localc = this.cpD.getWindowAndroid();
      p.g(localc, "rt.windowAndroid");
      paramb = (com.tencent.mm.plugin.appbrand.platform.window.d)new at(localc, paramb, localActivity);
      AppMethodBeat.o(220924);
      return paramb;
    }
  }
  
  public final void a(C paramC)
  {
    AppMethodBeat.i(220913);
    p.h(paramC, "initConfig");
    Object localObject = this.cpD.aWo();
    p.g(localObject, "rt.contentView");
    localObject = ((com.tencent.mm.plugin.appbrand.widget.d)localObject).getParent();
    if (localObject == null)
    {
      paramC = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(220913);
      throw paramC;
    }
    this.cpn = ((View)localObject);
    this.cpo = paramC;
    this.cpl = paramC.cmA.cpl;
    a(true, false, "init");
    AppMethodBeat.o(220913);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.config.a parama)
  {
    AppMethodBeat.i(220915);
    p.h(parama, "appConfig");
    this.cpm = "portrait";
    String str = parama.beo().jZz;
    int i;
    if (str == null)
    {
      str = parama.beq().cpm;
      if (str != null)
      {
        if (((CharSequence)str).length() == 0)
        {
          i = 1;
          if (i == 0) {
            break label147;
          }
        }
      }
      else {
        str = "portrait";
      }
    }
    label70:
    for (this.cpm = str;; this.cpm = str)
    {
      boolean bool1 = parama.cpl;
      boolean bool2 = this.cpl;
      if (bool2 != bool1)
      {
        this.cpl = bool1;
        a(true, false, "redundancy field check fail");
        ae.w("Luggage.AppBrandWindowLayoutManager", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      }
      AppMethodBeat.o(220915);
      return;
      i = 0;
      break;
      break label70;
    }
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(220919);
    if (!EX())
    {
      AppMethodBeat.o(220919);
      return;
    }
    DisplayMetrics localDisplayMetrics = getVDisplayMetrics();
    ae.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: orientation = [%s], vdmW = [%d], vdmH = [%d]", new Object[] { paramString, this.cpB, Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels) });
    this.cpD.aWQ();
    View localView = this.cpn;
    if (localView == null) {
      p.bdF("bgView");
    }
    if (((!localView.isLaidOut()) && (paramBoolean1)) || (paramBoolean2))
    {
      paramString = this.cpn;
      if (paramString == null) {
        p.bdF("bgView");
      }
      paramString.post((Runnable)new e(this));
      AppMethodBeat.o(220919);
      return;
    }
    localView = this.cpn;
    if (localView == null) {
      p.bdF("bgView");
    }
    int i = localView.getMeasuredWidth();
    localView = this.cpn;
    if (localView == null) {
      p.bdF("bgView");
    }
    int j = localView.getMeasuredHeight();
    ae.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: width [%d], height[%d]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
    float f1 = i * 1.0F / localDisplayMetrics.widthPixels;
    float f2 = j * 1.0F / localDisplayMetrics.heightPixels;
    float f3 = Math.min(f1, f2);
    ae.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: scaleMin = [%f], scaleMax = [%f]", new Object[] { paramString, Float.valueOf(f3), Float.valueOf(Math.max(f1, f2)) });
    this.scale = f3;
    paramString = new WxaWindowLayoutParams(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    paramString.gravity = 17;
    paramString.setScale(this.scale);
    this.cpD.getWindowAndroid().a(paramString, this.cpD);
    this.cpD.getWindowAndroid().a(b.n(this.ctx, 2131099651), this.cpD);
    AppMethodBeat.o(220919);
  }
  
  public final void b(C paramC)
  {
    AppMethodBeat.i(220914);
    p.h(paramC, "initConfig");
    this.cpo = paramC;
    this.cpl = paramC.cmA.cpl;
    if (EX())
    {
      paramC = this.ctx.getResources();
      p.g(paramC, "ctx.resources");
      paramC = paramC.getConfiguration();
      p.g(paramC, "ctx.resources.configuration");
      onConfigurationChanged(paramC);
    }
    a(true, true, "onInitConfigUpdated");
    AppMethodBeat.o(220914);
  }
  
  public final View getBgView()
  {
    AppMethodBeat.i(220912);
    View localView = this.cpn;
    if (localView == null) {
      p.bdF("bgView");
    }
    AppMethodBeat.o(220912);
    return localView;
  }
  
  public e getOrientationHandler()
  {
    AppMethodBeat.i(220923);
    Object localObject = this.cpD.getWindowAndroid();
    p.g(localObject, "rt.windowAndroid");
    localObject = (e)new com.tencent.mm.plugin.appbrand.platform.window.b.a.a((c)localObject);
    AppMethodBeat.o(220923);
    return localObject;
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    AppMethodBeat.i(220916);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(this.aJt);
    if ((!this.cpy) || (this.cpA == -1.0D)) {
      this.cpA = (this.cpr * 1.0D / (this.cps * 1.0D));
    }
    int j = this.cpr;
    int i = this.cps;
    View localView = this.cpn;
    if (localView == null) {
      p.bdF("bgView");
    }
    if (localView.isLaidOut())
    {
      localView = this.cpn;
      if (localView == null) {
        p.bdF("bgView");
      }
      i = localView.getMeasuredWidth();
      localView = this.cpn;
      if (localView == null) {
        p.bdF("bgView");
      }
      int k = j.lw(i, localView.getMeasuredHeight());
      localView = this.cpn;
      if (localView == null) {
        p.bdF("bgView");
      }
      i = localView.getMeasuredWidth();
      localView = this.cpn;
      if (localView == null) {
        p.bdF("bgView");
      }
      int m = j.lx(i, localView.getMeasuredHeight());
      if (this.cpy)
      {
        i = m;
        j = k;
        if (this.cpA != -1.0D) {}
      }
      else
      {
        this.cpA = (k * 1.0D / (m * 1.0D));
        j = k;
        i = m;
      }
    }
    if ((this.cpA > 1.333333333333333D) && (this.cpA < 2.666666666666667D)) {}
    double d2;
    float f1;
    for (double d1 = this.cpA;; d1 = 1.777777777777778D)
    {
      localDisplayMetrics.setTo(this.aJt);
      d2 = d1;
      if (this.cpB != a.b.cpH) {
        d2 = 1.0D / d1;
      }
      ae.i("Luggage.AppBrandWindowLayoutManager", "getVDisplayMetrics: contentRatio = [%f], systemRatio = [%f], isFold = [%b]", new Object[] { Double.valueOf(d2), Double.valueOf(this.cpA), Boolean.valueOf(this.cpy) });
      float f2 = 1.0F;
      f1 = f2;
      if (this.cpA >= 1.333333333333333D)
      {
        f1 = f2;
        if (!this.cpy) {
          f1 = 0.75F;
        }
      }
      if ((!this.cpy) || (this.cpx == 0) || (this.cpw == 0)) {
        break;
      }
      localDisplayMetrics.heightPixels = this.cpx;
      localDisplayMetrics.widthPixels = this.cpw;
      AppMethodBeat.o(220916);
      return localDisplayMetrics;
    }
    if (this.cpB == a.b.cpH) {
      localDisplayMetrics.heightPixels = ((int)(j * f1));
    }
    for (localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2));; localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2)))
    {
      this.cpx = localDisplayMetrics.heightPixels;
      this.cpw = localDisplayMetrics.widthPixels;
      break;
      localDisplayMetrics.heightPixels = ((int)(i * f1));
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(220920);
    p.h(paramConfiguration, "newConfig");
    if ((this.cpv != paramConfiguration.orientation) && (p.i(this.cpC, "auto")) && (EX()) && (!this.cpl)) {
      this.cpB = gC(paramConfiguration.orientation);
    }
    if ((this.cpv != paramConfiguration.orientation) || (paramConfiguration.screenHeightDp != this.cpt) || (paramConfiguration.screenWidthDp != this.cpu)) {
      if (((paramConfiguration.screenHeightDp == this.cpt) && (paramConfiguration.screenWidthDp == this.cpu)) || (this.cpv != paramConfiguration.orientation)) {
        break label302;
      }
    }
    label302:
    for (boolean bool = true;; bool = false)
    {
      this.cpy = bool;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject = this.cpD.getWindowAndroid();
        p.g(localObject, "rt.windowAndroid");
        if ((((c)localObject).isInMultiWindowMode()) || (this.cpz)) {
          this.cpy = false;
        }
        localObject = this.cpD.getWindowAndroid();
        p.g(localObject, "rt.windowAndroid");
        this.cpz = ((c)localObject).isInMultiWindowMode();
      }
      EY();
      if ((this.cpy) && ((paramConfiguration.screenHeightDp != this.cpt) || (paramConfiguration.screenWidthDp != this.cpu))) {
        EZ();
      }
      Object localObject = this.cpn;
      if (localObject == null) {
        p.bdF("bgView");
      }
      ((View)localObject).addOnLayoutChangeListener((View.OnLayoutChangeListener)new d(this));
      this.cpv = paramConfiguration.orientation;
      this.cpt = paramConfiguration.screenHeightDp;
      this.cpu = paramConfiguration.screenWidthDp;
      AppMethodBeat.o(220920);
      return;
    }
  }
  
  public void setSoftOrientation(String paramString)
  {
    localObject3 = null;
    AppMethodBeat.i(220925);
    p.h(paramString, "name");
    ae.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation = [%s]", new Object[] { paramString });
    if (paramString == null) {
      ae.w("Luggage.AppBrandWindowLayoutManager", "unhandled orientation = [%s]", new Object[] { paramString });
    }
    for (;;)
    {
      try
      {
        Object localObject4 = this.cpD.aWm();
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((t)localObject4).getPageView();
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((z)localObject4).getFullscreenImpl();
          }
        }
      }
      catch (AssertionFailedError localAssertionFailedError)
      {
        Object localObject1;
        int i;
        Object localObject2 = localObject3;
        continue;
      }
      if ((localObject1 == null) || (!(localObject1 instanceof at)) || (!((at)localObject1).jEw))
      {
        this.cpC = paramString;
        a(true, false, "set softOrientation");
        if (((EX()) || (this.cpl)) && ((this.ctx instanceof Activity)))
        {
          ae.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
          i = ((Activity)this.ctx).getRequestedOrientation();
          if ((i != 14) && (i != -1)) {
            this.cpE.a(e.b.mtE, (e.a)new c(this));
          }
        }
      }
      AppMethodBeat.o(220925);
      return;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 3005871: 
        if (!paramString.equals("auto")) {
          break;
        }
        localObject1 = this.ctx.getResources();
        p.g(localObject1, "ctx.resources");
        this.cpB = gC(((Resources)localObject1).getConfiguration().orientation);
        break;
      case 729267099: 
        if (!paramString.equals("portrait")) {
          break;
        }
        this.cpB = a.b.cpH;
        break;
      case 1430647483: 
        if (!paramString.equals("landscape")) {
          break;
        }
        this.cpB = a.b.cpG;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "success", "", "onOrientationChanged"})
  static final class c
    implements e.a
  {
    c(a parama) {}
    
    public final void a(e.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(220909);
      ae.i("Luggage.AppBrandWindowLayoutManager", "request orientation result: [%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      if (this.cpJ.cpo != null) {
        this.cpJ.a(true, false, "requestDeviceOrientation done");
      }
      AppMethodBeat.o(220909);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$onConfigurationChanged$1", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$OnLayoutChangeListenerWithCounter;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "counter", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends a.a
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(220910);
      if (paramInt9 == 10)
      {
        this.cpJ.getBgView().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(220910);
        return;
      }
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt4) && (paramInt1 == paramInt3)) {}
      for (paramInt9 = 1; (paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8) && (paramInt2 == paramInt6) && (paramInt9 == 0); paramInt9 = 0)
      {
        ae.i("Luggage.AppBrandWindowLayoutManager", "onLayoutChange: no changed, ignore");
        AppMethodBeat.o(220910);
        return;
      }
      if (this.cpJ.cpo != null) {
        this.cpJ.a(true, false, "onConfigurationChanged");
      }
      this.cpJ.getBgView().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(220910);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(220911);
      this.cpJ.a(false, false, "post");
      AppMethodBeat.o(220911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */