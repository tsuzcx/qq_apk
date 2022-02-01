package com.tencent.luggage.sdk.e;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager;
import com.tencent.luggage.k.j;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.bg;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.b.a;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.platform.window.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import junit.framework.AssertionFailedError;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "value", "", "_softOrientation", "set_softOrientation", "(Ljava/lang/String;)V", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "heightPx", "", "initConfig", "getInitConfig", "()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "setInitConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<set-?>", "", "isFold", "()Z", "isHWFolder", "isLastInMultiWindowMode", "lastLandscapeVHeight", "getLastLandscapeVHeight", "()I", "setLastLandscapeVHeight", "(I)V", "lastLandscapeVWidth", "getLastLandscapeVWidth", "setLastLandscapeVWidth", "lastOrientation", "lastPortraitVHeight", "getLastPortraitVHeight", "setLastPortraitVHeight", "lastPortraitVWidth", "getLastPortraitVWidth", "setLastPortraitVWidth", "lastScreenHDp", "lastScreenWDp", "maxEdge", "minEdge", "orientation", "resizable", "getResizable", "setResizable", "(Z)V", "scale", "", "systemRatio", "", "widthPx", "windowOrientation", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$WindowOrientation;", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "getOrientationHandler", "getScale", "getVDisplayMetrics", "orientationChanged", "init", "", "isLargeScreenWindow", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "parseOrientation", "configurationOrientation", "refreshDisplayInfo", "resetWindowOrientation", "setSoftOrientation", "name", "shouldInLargeScreenCompatMode", "tuningRtContentView", "waitViewMeasure", "forceWaitViewMeasure", "reason", "OnLayoutChangeListenerWithCounter", "WindowOrientation", "luggage-wechat-full-sdk_release"})
public abstract class a<C extends AppBrandInitConfigLU>
  implements f<C>, g
{
  private final AppBrandRuntime cCA;
  private final e cCB;
  private boolean cCh;
  private String cCi;
  public View cCj;
  protected C cCk;
  private final boolean cCl;
  private final DisplayMetrics cCm;
  private int cCn;
  private int cCo;
  private int cCp;
  private int cCq;
  private int cCr;
  private int cCs;
  private int cCt;
  private int cCu;
  private boolean cCv;
  private boolean cCw;
  private double cCx;
  private a.b cCy;
  private String cCz;
  private int cYh;
  private final Context ctx;
  private int dqi;
  private int lastOrientation;
  private float scale;
  
  public a(AppBrandRuntime paramAppBrandRuntime, Context paramContext, e parame)
  {
    this.cCA = paramAppBrandRuntime;
    this.ctx = paramContext;
    this.cCB = parame;
    this.cCi = "portrait";
    this.scale = 1.0F;
    this.cCl = j.cEc.SJ();
    this.cCm = new DisplayMetrics();
    if (this.cCl)
    {
      paramAppBrandRuntime = this.cCA.getWindowAndroid();
      p.j(paramAppBrandRuntime, "rt.windowAndroid");
      if (paramAppBrandRuntime.bCZ()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.cCv = bool;
      this.cCx = -1.0D;
      paramAppBrandRuntime = this.ctx.getResources();
      p.j(paramAppBrandRuntime, "ctx.resources");
      this.cCy = iT(paramAppBrandRuntime.getConfiguration().orientation);
      paramAppBrandRuntime = this.ctx.getResources();
      p.j(paramAppBrandRuntime, "ctx.resources");
      this.lastOrientation = paramAppBrandRuntime.getConfiguration().orientation;
      paramAppBrandRuntime = this.ctx.getResources();
      p.j(paramAppBrandRuntime, "ctx.resources");
      this.cCs = paramAppBrandRuntime.getConfiguration().screenWidthDp;
      paramAppBrandRuntime = this.ctx.getResources();
      p.j(paramAppBrandRuntime, "ctx.resources");
      this.cCr = paramAppBrandRuntime.getConfiguration().screenHeightDp;
      Sa();
      return;
    }
  }
  
  private final void Sa()
  {
    Point localPoint = new Point();
    Object localObject = this.ctx.getSystemService("window");
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if ((com.tencent.mm.plugin.appbrand.utils.x.es(this.ctx)) && (j.cEc.SI()))
    {
      ((Display)localObject).getRealSize(localPoint);
      ((Display)localObject).getRealMetrics(this.cCm);
    }
    for (;;)
    {
      this.cCn = localPoint.x;
      this.cCo = localPoint.y;
      this.cCp = Math.max(this.cCn, this.cCo);
      this.cCq = Math.min(this.cCn, this.cCo);
      Log.i("Luggage.AppBrandWindowLayoutManager", "refreshDisplayInfo: system [w,h] = [%d,%d]", new Object[] { Integer.valueOf(this.cCn), Integer.valueOf(this.cCo) });
      return;
      ((Display)localObject).getSize(localPoint);
      ((Display)localObject).getMetrics(this.cCm);
    }
  }
  
  private final void Sb()
  {
    if (!this.cCA.isResumed()) {
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)this.cCz))
    {
      Log.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation by softOrientation[%s]", new Object[] { this.cCz });
      this.cCB.a(e.b.amy(this.cCz), null);
      return;
    }
    e.b localb = this.cCB.cgS();
    p.j(localb, "activityOrientationHandler.currentOrientation");
    Log.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation with orientation[%s]", new Object[] { localb });
    this.cCB.a(localb, null);
  }
  
  private final DisplayMetrics WC()
  {
    int k = 1;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(this.cCm);
    if ((!this.cCv) || (this.cCx == -1.0D)) {
      this.cCx = (this.cCp * 1.0D / (this.cCq * 1.0D));
    }
    int j = this.cCp;
    int i = this.cCq;
    if (((a)this).cCj != null)
    {
      View localView = this.cCj;
      if (localView == null) {
        p.bGy("bgView");
      }
      if (localView.isLaidOut())
      {
        localView = this.cCj;
        if (localView == null) {
          p.bGy("bgView");
        }
        i = localView.getMeasuredWidth();
        localView = this.cCj;
        if (localView == null) {
          p.bGy("bgView");
        }
        j = i.ov(i, localView.getMeasuredHeight());
        localView = this.cCj;
        if (localView == null) {
          p.bGy("bgView");
        }
        i = localView.getMeasuredWidth();
        localView = this.cCj;
        if (localView == null) {
          p.bGy("bgView");
        }
        i = i.ow(i, localView.getMeasuredHeight());
        this.cCx = (j * 1.0D / (i * 1.0D));
      }
    }
    for (;;)
    {
      double d1;
      double d2;
      float f1;
      if ((this.cCx > 1.333333333333333D) && (this.cCx < 2.666666666666667D))
      {
        d1 = this.cCx;
        localDisplayMetrics.setTo(this.cCm);
        d2 = d1;
        if (this.cCy != a.b.cCE) {
          d2 = 1.0D / d1;
        }
        float f2 = 1.0F;
        f1 = f2;
        if (this.cCx >= 1.333333333333333D)
        {
          f1 = f2;
          if (!this.cCv) {
            f1 = 0.75F;
          }
        }
        Log.i("Luggage.AppBrandWindowLayoutManager", "getVDisplayMetrics: contentRatio = [%f], systemRatio = [%f], isFold = [%b], ratio = [%f]", new Object[] { Double.valueOf(d2), Double.valueOf(this.cCx), Boolean.valueOf(this.cCv), Float.valueOf(f1) });
        if (!this.cCv) {
          break label573;
        }
        if (this.cCy != a.b.cCE) {
          break label488;
        }
        if ((this.cCu == 0) || (this.cCt == 0)) {
          break label573;
        }
        localDisplayMetrics.heightPixels = this.cCu;
        localDisplayMetrics.widthPixels = this.cCt;
      }
      for (;;)
      {
        label409:
        if (k == 0)
        {
          if (this.cCy != a.b.cCE) {
            break label523;
          }
          localDisplayMetrics.heightPixels = ((int)(j * f1));
        }
        for (localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2));; localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2)))
        {
          if (this.cCy != a.b.cCE) {
            break label552;
          }
          this.cCu = localDisplayMetrics.heightPixels;
          this.cCt = localDisplayMetrics.widthPixels;
          return localDisplayMetrics;
          d1 = 1.777777777777778D;
          break;
          label488:
          if ((this.dqi == 0) || (this.cYh == 0)) {
            break label573;
          }
          localDisplayMetrics.heightPixels = this.dqi;
          localDisplayMetrics.widthPixels = this.cYh;
          break label409;
          label523:
          localDisplayMetrics.heightPixels = ((int)(i * f1));
        }
        label552:
        this.dqi = localDisplayMetrics.heightPixels;
        this.cYh = localDisplayMetrics.widthPixels;
        return localDisplayMetrics;
        label573:
        k = 0;
      }
    }
  }
  
  private static a.b iT(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.w("Luggage.AppBrandWindowLayoutManager", "unexpected orientation [%d], fallback to portrait", new Object[] { Integer.valueOf(paramInt) });
      return a.b.cCE;
    case 2: 
      return a.b.cCD;
    }
    return a.b.cCE;
  }
  
  protected final boolean RY()
  {
    return this.cCh;
  }
  
  public boolean RZ()
  {
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    return com.tencent.mm.plugin.appbrand.utils.x.es(localContext);
  }
  
  public final boolean Sc()
  {
    return false;
  }
  
  public final boolean Sd()
  {
    return (com.tencent.mm.plugin.appbrand.utils.x.es(this.ctx)) && (!RZ());
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b paramb)
  {
    if ((this.ctx instanceof Activity)) {}
    for (Activity localActivity = (Activity)this.ctx;; localActivity = null)
    {
      c localc = this.cCA.getWindowAndroid();
      p.j(localc, "rt.windowAndroid");
      return (com.tencent.mm.plugin.appbrand.platform.window.d)new bg(localc, paramb, localActivity);
    }
  }
  
  public final void a(C paramC)
  {
    p.k(paramC, "initConfig");
    Object localObject = this.cCA.bBZ();
    p.j(localObject, "rt.contentView");
    localObject = ((com.tencent.mm.plugin.appbrand.widget.d)localObject).getParent();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.view.View");
    }
    this.cCj = ((View)localObject);
    this.cCk = paramC;
    this.cCh = paramC.cwY.cCh;
    f(true, false, "init");
  }
  
  public final void a(b paramb)
  {
    p.k(paramb, "appConfig");
    this.cCi = "portrait";
    String str = paramb.bKU().nWK;
    int i;
    if (str == null)
    {
      str = paramb.bKW().cCi;
      if (str != null)
      {
        if (((CharSequence)str).length() == 0)
        {
          i = 1;
          if (i == 0) {
            break label135;
          }
        }
      }
      else {
        str = "portrait";
      }
    }
    label64:
    for (this.cCi = str;; this.cCi = str)
    {
      boolean bool1 = paramb.cCh;
      boolean bool2 = this.cCh;
      if (bool2 != bool1)
      {
        this.cCh = bool1;
        f(true, false, "redundancy field check fail");
        Log.w("Luggage.AppBrandWindowLayoutManager", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      }
      return;
      i = 0;
      break;
      break label64;
    }
  }
  
  public final void b(C paramC)
  {
    p.k(paramC, "initConfig");
    this.cCk = paramC;
    this.cCh = paramC.cwY.cCh;
    if (RZ())
    {
      paramC = this.ctx.getResources();
      p.j(paramC, "ctx.resources");
      paramC = paramC.getConfiguration();
      p.j(paramC, "ctx.resources.configuration");
      onConfigurationChanged(paramC);
    }
    f(true, true, "onInitConfigUpdated");
  }
  
  final void f(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (!RZ()) {
      return;
    }
    DisplayMetrics localDisplayMetrics = WC();
    Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: orientation = [%s], vdmW = [%d], vdmH = [%d]", new Object[] { paramString, this.cCy, Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels) });
    this.cCA.bCE();
    View localView = this.cCj;
    if (localView == null) {
      p.bGy("bgView");
    }
    if (((!localView.isLaidOut()) && (paramBoolean1)) || (paramBoolean2))
    {
      paramString = this.cCj;
      if (paramString == null) {
        p.bGy("bgView");
      }
      paramString.post((Runnable)new e(this));
      return;
    }
    localView = this.cCj;
    if (localView == null) {
      p.bGy("bgView");
    }
    int i = localView.getMeasuredWidth();
    localView = this.cCj;
    if (localView == null) {
      p.bGy("bgView");
    }
    int j = localView.getMeasuredHeight();
    Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: width [%d], height[%d]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
    float f1 = i * 1.0F / localDisplayMetrics.widthPixels;
    float f2 = j * 1.0F / localDisplayMetrics.heightPixels;
    float f3 = Math.min(f1, f2);
    Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: scaleMin = [%f], scaleMax = [%f]", new Object[] { paramString, Float.valueOf(f3), Float.valueOf(Math.max(f1, f2)) });
    this.scale = f3;
    paramString = new WxaWindowLayoutParams(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    paramString.gravity = 17;
    paramString.setScale(this.scale);
    this.cCA.getWindowAndroid().a(paramString, this.cCA);
    this.cCA.getWindowAndroid().a(androidx.core.content.a.w(this.ctx, com.tencent.luggage.wxa.a.a.BG_3), this.cCA);
    this.cCA.bBZ().setBackgroundColor(androidx.core.content.a.w(this.ctx, com.tencent.luggage.wxa.a.a.BG_3));
  }
  
  public final View getBgView()
  {
    View localView = this.cCj;
    if (localView == null) {
      p.bGy("bgView");
    }
    return localView;
  }
  
  public e getOrientationHandler()
  {
    c localc = this.cCA.getWindowAndroid();
    p.j(localc, "rt.windowAndroid");
    return (e)new com.tencent.mm.plugin.appbrand.platform.window.c.a.a(localc);
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    return WC();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    p.k(paramConfiguration, "newConfig");
    if ((this.lastOrientation != paramConfiguration.orientation) && (p.h(this.cCz, "auto")) && (RZ()) && (!this.cCh)) {
      this.cCy = iT(paramConfiguration.orientation);
    }
    if ((this.lastOrientation != paramConfiguration.orientation) || (paramConfiguration.screenHeightDp != this.cCr) || (paramConfiguration.screenWidthDp != this.cCs)) {
      if ((!this.cCl) && (((paramConfiguration.screenHeightDp == this.cCr) && (paramConfiguration.screenWidthDp == this.cCs)) || (this.lastOrientation != paramConfiguration.orientation))) {
        break label295;
      }
    }
    label295:
    for (boolean bool = true;; bool = false)
    {
      this.cCv = bool;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject = this.cCA.getWindowAndroid();
        p.j(localObject, "rt.windowAndroid");
        if ((((c)localObject).bCZ()) || (this.cCw)) {
          this.cCv = false;
        }
        localObject = this.cCA.getWindowAndroid();
        p.j(localObject, "rt.windowAndroid");
        this.cCw = ((c)localObject).bCZ();
      }
      Sa();
      if ((this.cCv) && ((paramConfiguration.screenHeightDp != this.cCr) || (paramConfiguration.screenWidthDp != this.cCs))) {
        Sb();
      }
      Object localObject = this.cCj;
      if (localObject == null) {
        p.bGy("bgView");
      }
      ((View)localObject).addOnLayoutChangeListener((View.OnLayoutChangeListener)new d(this));
      this.lastOrientation = paramConfiguration.orientation;
      this.cCr = paramConfiguration.screenHeightDp;
      this.cCs = paramConfiguration.screenWidthDp;
      return;
    }
  }
  
  public void setSoftOrientation(String paramString)
  {
    localObject3 = null;
    p.k(paramString, "name");
    Log.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation = [%s]", new Object[] { paramString });
    if (paramString == null) {
      Log.w("Luggage.AppBrandWindowLayoutManager", "unhandled orientation = [%s]", new Object[] { paramString });
    }
    for (;;)
    {
      try
      {
        Object localObject4 = this.cCA.bBX();
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.appbrand.page.x)localObject4).getPageView();
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((ad)localObject4).getFullscreenImpl();
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
      if ((localObject1 == null) || (!(localObject1 instanceof bg)) || (!((bg)localObject1).nzN))
      {
        this.cCz = paramString;
        f(true, false, "set softOrientation");
        if (((RZ()) || (this.cCh)) && ((this.ctx instanceof Activity)))
        {
          Log.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
          i = ((Activity)this.ctx).getRequestedOrientation();
          if ((i != 14) && (i != -1)) {
            this.cCB.a(e.b.qGw, (e.a)new c(this));
          }
        }
      }
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
        p.j(localObject1, "ctx.resources");
        this.cCy = iT(((Resources)localObject1).getConfiguration().orientation);
        break;
      case 729267099: 
        if (!paramString.equals("portrait")) {
          break;
        }
        this.cCy = a.b.cCE;
        break;
      case 1430647483: 
        if (!paramString.equals("landscape")) {
          break;
        }
        this.cCy = a.b.cCD;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "success", "", "onOrientationChanged"})
  static final class c
    implements e.a
  {
    c(a parama) {}
    
    public final void a(e.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(246050);
      Log.i("Luggage.AppBrandWindowLayoutManager", "request orientation result: [%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      if (this.cCG.cCk != null) {
        this.cCG.f(true, false, "requestDeviceOrientation done");
      }
      AppMethodBeat.o(246050);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$onConfigurationChanged$1", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$OnLayoutChangeListenerWithCounter;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "counter", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends a.a
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(237536);
      if (paramInt9 == 10)
      {
        this.cCG.getBgView().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(237536);
        return;
      }
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt4) && (paramInt1 == paramInt3)) {}
      for (paramInt9 = 1; (paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8) && (paramInt2 == paramInt6) && (paramInt9 == 0); paramInt9 = 0)
      {
        Log.i("Luggage.AppBrandWindowLayoutManager", "onLayoutChange: no changed, ignore");
        AppMethodBeat.o(237536);
        return;
      }
      if (this.cCG.cCk != null) {
        this.cCG.f(true, false, "onConfigurationChanged");
      }
      this.cCG.getBgView().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(237536);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(242935);
      this.cCG.f(false, false, "post");
      AppMethodBeat.o(242935);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.a
 * JD-Core Version:    0.7.0.1
 */