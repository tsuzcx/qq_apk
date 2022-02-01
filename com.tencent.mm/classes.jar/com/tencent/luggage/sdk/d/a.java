package com.tencent.luggage.sdk.d;

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
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.be;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.b.a;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.platform.window.g;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import junit.framework.AssertionFailedError;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "value", "", "_softOrientation", "set_softOrientation", "(Ljava/lang/String;)V", "bgView", "Landroid/view/View;", "getBgView", "()Landroid/view/View;", "setBgView", "(Landroid/view/View;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "heightPx", "", "initConfig", "getInitConfig", "()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "setInitConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<set-?>", "", "isFold", "()Z", "isLastInMultiWindowMode", "lastOrientation", "lastScreenHDp", "lastScreenWDp", "lastVHeight", "getLastVHeight", "()I", "setLastVHeight", "(I)V", "lastVWidth", "getLastVWidth", "setLastVWidth", "maxEdge", "minEdge", "orientation", "resizable", "getResizable", "setResizable", "(Z)V", "scale", "", "systemRatio", "", "widthPx", "windowOrientation", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$WindowOrientation;", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "getOrientationHandler", "getScale", "getVDisplayMetrics", "init", "", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "parseOrientation", "configurationOrientation", "refreshDisplayInfo", "resetWindowOrientation", "setSoftOrientation", "name", "shouldInLargeScreenCompatMode", "tuningRtContentView", "waitViewMeasure", "forceWaitViewMeasure", "reason", "OnLayoutChangeListenerWithCounter", "WindowOrientation", "luggage-wechat-full-sdk_release"})
public abstract class a<C extends AppBrandInitConfigLU>
  implements f<C>, g
{
  private final DisplayMetrics aJm;
  protected boolean cBF;
  private String cBG;
  public View cBH;
  protected C cBI;
  private int cBJ;
  private int cBK;
  private int cBL;
  private int cBM;
  private int cBN;
  private int cBO;
  private int cBP;
  private int cBQ;
  private boolean cBR;
  private boolean cBS;
  private double cBT;
  private b cBU;
  private String cBV;
  private final AppBrandRuntime cBW;
  private final e cBX;
  private final Context ctx;
  private int lastOrientation;
  private float scale;
  
  public a(AppBrandRuntime paramAppBrandRuntime, Context paramContext, e parame)
  {
    this.cBW = paramAppBrandRuntime;
    this.ctx = paramContext;
    this.cBX = parame;
    this.cBG = "portrait";
    this.scale = 1.0F;
    this.aJm = new DisplayMetrics();
    this.cBT = -1.0D;
    paramAppBrandRuntime = this.ctx.getResources();
    p.g(paramAppBrandRuntime, "ctx.resources");
    this.cBU = hR(paramAppBrandRuntime.getConfiguration().orientation);
    paramAppBrandRuntime = this.ctx.getResources();
    p.g(paramAppBrandRuntime, "ctx.resources");
    this.lastOrientation = paramAppBrandRuntime.getConfiguration().orientation;
    paramAppBrandRuntime = this.ctx.getResources();
    p.g(paramAppBrandRuntime, "ctx.resources");
    this.cBO = paramAppBrandRuntime.getConfiguration().screenWidthDp;
    paramAppBrandRuntime = this.ctx.getResources();
    p.g(paramAppBrandRuntime, "ctx.resources");
    this.cBN = paramAppBrandRuntime.getConfiguration().screenHeightDp;
    OE();
  }
  
  private final void OE()
  {
    Point localPoint = new Point();
    Object localObject = this.ctx.getSystemService("window");
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if ((ai.et(this.ctx)) && (com.tencent.luggage.h.j.cDv.Pi()))
    {
      ((Display)localObject).getRealSize(localPoint);
      ((Display)localObject).getRealMetrics(this.aJm);
    }
    for (;;)
    {
      this.cBJ = localPoint.x;
      this.cBK = localPoint.y;
      this.cBL = Math.max(this.cBJ, this.cBK);
      this.cBM = Math.min(this.cBJ, this.cBK);
      Log.i("Luggage.AppBrandWindowLayoutManager", "refreshDisplayInfo: system [w,h] = [%d,%d]", new Object[] { Integer.valueOf(this.cBJ), Integer.valueOf(this.cBK) });
      return;
      ((Display)localObject).getSize(localPoint);
      ((Display)localObject).getMetrics(this.aJm);
    }
  }
  
  private final void OF()
  {
    if (!TextUtils.isEmpty((CharSequence)this.cBV))
    {
      Log.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation by softOrientation[%s]", new Object[] { this.cBV });
      this.cBX.a(e.b.aeE(this.cBV), null);
      return;
    }
    e.b localb = this.cBX.btm();
    p.g(localb, "activityOrientationHandler.getCurrentOrientation()");
    Log.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation with orientation[%s]", new Object[] { localb });
    this.cBX.a(localb, null);
  }
  
  private static b hR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.w("Luggage.AppBrandWindowLayoutManager", "unexpected orientation [%d], fallback to portrait", new Object[] { Integer.valueOf(paramInt) });
      return b.cCa;
    case 2: 
      return b.cBZ;
    }
    return b.cCa;
  }
  
  public boolean OD()
  {
    return ai.et(MMApplicationContext.getContext());
  }
  
  public final boolean OG()
  {
    return false;
  }
  
  public final d a(d.b paramb)
  {
    if ((this.ctx instanceof Activity)) {}
    for (Activity localActivity = (Activity)this.ctx;; localActivity = null)
    {
      com.tencent.mm.plugin.appbrand.platform.window.c localc = this.cBW.getWindowAndroid();
      p.g(localc, "rt.windowAndroid");
      return (d)new be(localc, paramb, localActivity);
    }
  }
  
  public final void a(C paramC)
  {
    p.h(paramC, "initConfig");
    Object localObject = this.cBW.brj();
    p.g(localObject, "rt.contentView");
    localObject = ((com.tencent.mm.plugin.appbrand.widget.c)localObject).getParent();
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.view.View");
    }
    this.cBH = ((View)localObject);
    this.cBI = paramC;
    this.cBF = paramC.cyv.cBF;
    a(true, false, "init");
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.config.b paramb)
  {
    p.h(paramb, "appConfig");
    this.cBG = "portrait";
    String str = paramb.bzF().lcB;
    int i;
    if (str == null)
    {
      str = paramb.bzH().cBG;
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
    for (this.cBG = str;; this.cBG = str)
    {
      boolean bool1 = paramb.cBF;
      boolean bool2 = this.cBF;
      if (bool2 != bool1)
      {
        this.cBF = bool1;
        a(true, false, "redundancy field check fail");
        Log.w("Luggage.AppBrandWindowLayoutManager", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      }
      return;
      i = 0;
      break;
      break label64;
    }
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (!OD()) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getVDisplayMetrics();
    Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: orientation = [%s], vdmW = [%d], vdmH = [%d]", new Object[] { paramString, this.cBU, Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels) });
    this.cBW.brO();
    View localView = this.cBH;
    if (localView == null) {
      p.btv("bgView");
    }
    if (((!localView.isLaidOut()) && (paramBoolean1)) || (paramBoolean2))
    {
      paramString = this.cBH;
      if (paramString == null) {
        p.btv("bgView");
      }
      paramString.post((Runnable)new e(this));
      return;
    }
    localView = this.cBH;
    if (localView == null) {
      p.btv("bgView");
    }
    int i = localView.getMeasuredWidth();
    localView = this.cBH;
    if (localView == null) {
      p.btv("bgView");
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
    this.cBW.getWindowAndroid().a(paramString, this.cBW);
    this.cBW.getWindowAndroid().a(android.support.v4.content.b.n(this.ctx, 2131099651), this.cBW);
  }
  
  public final void b(C paramC)
  {
    p.h(paramC, "initConfig");
    this.cBI = paramC;
    this.cBF = paramC.cyv.cBF;
    if (OD())
    {
      paramC = this.ctx.getResources();
      p.g(paramC, "ctx.resources");
      paramC = paramC.getConfiguration();
      p.g(paramC, "ctx.resources.configuration");
      onConfigurationChanged(paramC);
    }
    a(true, true, "onInitConfigUpdated");
  }
  
  public final View getBgView()
  {
    View localView = this.cBH;
    if (localView == null) {
      p.btv("bgView");
    }
    return localView;
  }
  
  public e getOrientationHandler()
  {
    com.tencent.mm.plugin.appbrand.platform.window.c localc = this.cBW.getWindowAndroid();
    p.g(localc, "rt.windowAndroid");
    return (e)new com.tencent.mm.plugin.appbrand.platform.window.c.a.a(localc);
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(this.aJm);
    if ((!this.cBR) || (this.cBT == -1.0D)) {
      this.cBT = (this.cBL * 1.0D / (this.cBM * 1.0D));
    }
    int j = this.cBL;
    int i = this.cBM;
    View localView = this.cBH;
    if (localView == null) {
      p.btv("bgView");
    }
    if (localView.isLaidOut())
    {
      localView = this.cBH;
      if (localView == null) {
        p.btv("bgView");
      }
      i = localView.getMeasuredWidth();
      localView = this.cBH;
      if (localView == null) {
        p.btv("bgView");
      }
      int k = kotlin.k.j.mZ(i, localView.getMeasuredHeight());
      localView = this.cBH;
      if (localView == null) {
        p.btv("bgView");
      }
      i = localView.getMeasuredWidth();
      localView = this.cBH;
      if (localView == null) {
        p.btv("bgView");
      }
      int m = kotlin.k.j.na(i, localView.getMeasuredHeight());
      if (this.cBR)
      {
        i = m;
        j = k;
        if (this.cBT != -1.0D) {}
      }
      else
      {
        this.cBT = (k * 1.0D / (m * 1.0D));
        j = k;
        i = m;
      }
    }
    if ((this.cBT > 1.333333333333333D) && (this.cBT < 2.666666666666667D)) {}
    double d2;
    float f1;
    for (double d1 = this.cBT;; d1 = 1.777777777777778D)
    {
      localDisplayMetrics.setTo(this.aJm);
      d2 = d1;
      if (this.cBU != b.cCa) {
        d2 = 1.0D / d1;
      }
      Log.i("Luggage.AppBrandWindowLayoutManager", "getVDisplayMetrics: contentRatio = [%f], systemRatio = [%f], isFold = [%b]", new Object[] { Double.valueOf(d2), Double.valueOf(this.cBT), Boolean.valueOf(this.cBR) });
      float f2 = 1.0F;
      f1 = f2;
      if (this.cBT >= 1.333333333333333D)
      {
        f1 = f2;
        if (!this.cBR) {
          f1 = 0.75F;
        }
      }
      if ((!this.cBR) || (this.cBQ == 0) || (this.cBP == 0)) {
        break;
      }
      localDisplayMetrics.heightPixels = this.cBQ;
      localDisplayMetrics.widthPixels = this.cBP;
      return localDisplayMetrics;
    }
    if (this.cBU == b.cCa) {
      localDisplayMetrics.heightPixels = ((int)(j * f1));
    }
    for (localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2));; localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2)))
    {
      this.cBQ = localDisplayMetrics.heightPixels;
      this.cBP = localDisplayMetrics.widthPixels;
      return localDisplayMetrics;
      localDisplayMetrics.heightPixels = ((int)(i * f1));
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    p.h(paramConfiguration, "newConfig");
    if ((this.lastOrientation != paramConfiguration.orientation) && (p.j(this.cBV, "auto")) && (OD()) && (!this.cBF)) {
      this.cBU = hR(paramConfiguration.orientation);
    }
    if ((this.lastOrientation != paramConfiguration.orientation) || (paramConfiguration.screenHeightDp != this.cBN) || (paramConfiguration.screenWidthDp != this.cBO)) {
      if (((paramConfiguration.screenHeightDp == this.cBN) && (paramConfiguration.screenWidthDp == this.cBO)) || (this.lastOrientation != paramConfiguration.orientation)) {
        break label290;
      }
    }
    label290:
    for (boolean bool = true;; bool = false)
    {
      this.cBR = bool;
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject = this.cBW.getWindowAndroid();
        p.g(localObject, "rt.windowAndroid");
        if ((((com.tencent.mm.plugin.appbrand.platform.window.c)localObject).isInMultiWindowMode()) || (this.cBS)) {
          this.cBR = false;
        }
        localObject = this.cBW.getWindowAndroid();
        p.g(localObject, "rt.windowAndroid");
        this.cBS = ((com.tencent.mm.plugin.appbrand.platform.window.c)localObject).isInMultiWindowMode();
      }
      OE();
      if ((this.cBR) && ((paramConfiguration.screenHeightDp != this.cBN) || (paramConfiguration.screenWidthDp != this.cBO))) {
        OF();
      }
      Object localObject = this.cBH;
      if (localObject == null) {
        p.btv("bgView");
      }
      ((View)localObject).addOnLayoutChangeListener((View.OnLayoutChangeListener)new d(this));
      this.lastOrientation = paramConfiguration.orientation;
      this.cBN = paramConfiguration.screenHeightDp;
      this.cBO = paramConfiguration.screenWidthDp;
      return;
    }
  }
  
  public void setSoftOrientation(String paramString)
  {
    localObject3 = null;
    p.h(paramString, "name");
    Log.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation = [%s]", new Object[] { paramString });
    if (paramString == null) {
      Log.w("Luggage.AppBrandWindowLayoutManager", "unhandled orientation = [%s]", new Object[] { paramString });
    }
    for (;;)
    {
      try
      {
        Object localObject4 = this.cBW.brh();
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((w)localObject4).getPageView();
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((ac)localObject4).getFullscreenImpl();
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
      if ((localObject1 == null) || (!(localObject1 instanceof be)) || (!((be)localObject1).kGg))
      {
        this.cBV = paramString;
        a(true, false, "set softOrientation");
        if (((OD()) || (this.cBF)) && ((this.ctx instanceof Activity)))
        {
          Log.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
          i = ((Activity)this.ctx).getRequestedOrientation();
          if ((i != 14) && (i != -1)) {
            this.cBX.a(e.b.nEm, (e.a)new c(this));
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
        p.g(localObject1, "ctx.resources");
        this.cBU = hR(((Resources)localObject1).getConfiguration().orientation);
        break;
      case 729267099: 
        if (!paramString.equals("portrait")) {
          break;
        }
        this.cBU = b.cCa;
        break;
      case 1430647483: 
        if (!paramString.equals("landscape")) {
          break;
        }
        this.cBU = b.cBZ;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$WindowOrientation;", "", "(Ljava/lang/String;I)V", "LANDSCAPE", "PORTRAIT", "luggage-wechat-full-sdk_release"})
  static enum b
  {
    static
    {
      AppMethodBeat.i(230031);
      b localb1 = new b("LANDSCAPE", 0);
      cBZ = localb1;
      b localb2 = new b("PORTRAIT", 1);
      cCa = localb2;
      cCb = new b[] { localb1, localb2 };
      AppMethodBeat.o(230031);
    }
    
    private b() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "success", "", "onOrientationChanged"})
  static final class c
    implements e.a
  {
    c(a parama) {}
    
    public final void a(e.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(230034);
      Log.i("Luggage.AppBrandWindowLayoutManager", "request orientation result: [%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      if (this.cCc.cBI != null) {
        this.cCc.a(true, false, "requestDeviceOrientation done");
      }
      AppMethodBeat.o(230034);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$onConfigurationChanged$1", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$OnLayoutChangeListenerWithCounter;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "counter", "luggage-wechat-full-sdk_release"})
  public static final class d
    extends a.a
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(230035);
      if (paramInt9 == 10)
      {
        this.cCc.getBgView().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(230035);
        return;
      }
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt4) && (paramInt1 == paramInt3)) {}
      for (paramInt9 = 1; (paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8) && (paramInt2 == paramInt6) && (paramInt9 == 0); paramInt9 = 0)
      {
        Log.i("Luggage.AppBrandWindowLayoutManager", "onLayoutChange: no changed, ignore");
        AppMethodBeat.o(230035);
        return;
      }
      if (this.cCc.cBI != null) {
        this.cCc.a(true, false, "onConfigurationChanged");
      }
      this.cCc.getBgView().removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
      AppMethodBeat.o(230035);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(230036);
      this.cCc.a(false, false, "post");
      AppMethodBeat.o(230036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */