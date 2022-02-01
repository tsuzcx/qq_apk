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
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.wxa.a.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.bm;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.b.a;
import com.tencent.mm.plugin.appbrand.config.b.b;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.platform.window.g;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import junit.framework.AssertionFailedError;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "ctx", "Landroid/content/Context;", "activityOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "value", "", "_softOrientation", "set_softOrientation", "(Ljava/lang/String;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "heightPx", "", "initConfig", "getInitConfig", "()Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "setInitConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<set-?>", "", "isFold", "()Z", "isFoldDevice", "isLastInMultiWindowMode", "lastLandscapeVHeight", "getLastLandscapeVHeight", "()I", "setLastLandscapeVHeight", "(I)V", "lastLandscapeVWidth", "getLastLandscapeVWidth", "setLastLandscapeVWidth", "lastOrientation", "lastPortraitVHeight", "getLastPortraitVHeight", "setLastPortraitVHeight", "lastPortraitVWidth", "getLastPortraitVWidth", "setLastPortraitVWidth", "lastScreenHDp", "lastScreenWDp", "maxEdge", "minEdge", "orientation", "resizable", "getResizable", "setResizable", "(Z)V", "scale", "", "systemRatio", "", "widthPx", "windowOrientation", "Lcom/tencent/luggage/sdk/runtime/AppBrandCenterInsideWindowLayoutManager$WindowOrientation;", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "getBackgroundView", "Landroid/view/View;", "getOrientationHandler", "getScale", "getVDisplayMetrics", "orientationChanged", "init", "", "isLargeScreenWindow", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "parseOrientation", "configurationOrientation", "refreshDisplayInfo", "resetWindowOrientation", "setSoftOrientation", "name", "shouldInLargeScreenCompatMode", "tuningRtContentView", "waitViewMeasure", "forceWaitViewMeasure", "reason", "OnLayoutChangeListenerWithCounter", "WindowOrientation", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<C extends AppBrandInitConfigLU>
  implements f<C>, g
{
  private int bbG;
  private int bbH;
  private final Context ctx;
  private final AppBrandRuntime euM;
  private final com.tencent.mm.plugin.appbrand.platform.window.e euN;
  private boolean euO;
  private String euP;
  protected C euQ;
  private final boolean euR;
  private final DisplayMetrics euS;
  private int euT;
  private int euU;
  private int euV;
  private int euW;
  private int euX;
  private int euY;
  private int euZ;
  private int eva;
  private boolean evb;
  private boolean evc;
  private double evd;
  private a.b eve;
  private String evf;
  private int lastOrientation;
  private float scale;
  
  public a(AppBrandRuntime paramAppBrandRuntime, Context paramContext, com.tencent.mm.plugin.appbrand.platform.window.e parame)
  {
    this.euM = paramAppBrandRuntime;
    this.ctx = paramContext;
    this.euN = parame;
    this.euP = "portrait";
    this.scale = 1.0F;
    this.euR = com.tencent.luggage.l.k.exm.ato();
    this.euS = new DisplayMetrics();
    if ((this.euR) && (!this.euM.getWindowAndroid().ccm())) {}
    for (boolean bool = true;; bool = false)
    {
      this.evb = bool;
      this.evd = -1.0D;
      this.eve = mu(this.ctx.getResources().getConfiguration().orientation);
      this.lastOrientation = this.ctx.getResources().getConfiguration().orientation;
      this.euW = this.ctx.getResources().getConfiguration().screenWidthDp;
      this.euV = this.ctx.getResources().getConfiguration().screenHeightDp;
      asr();
      return;
    }
  }
  
  private static final void a(a parama)
  {
    s.u(parama, "this$0");
    parama.a(false, false, "post");
  }
  
  private static final void a(a parama, e.b paramb, boolean paramBoolean)
  {
    s.u(parama, "this$0");
    Log.i("Luggage.AppBrandWindowLayoutManager", "request orientation result: [%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (parama.euQ != null) {
      parama.a(true, false, "requestDeviceOrientation done");
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    View localView = getBackgroundView();
    if ((!asq()) || (localView == null)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = asp();
    Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: orientation = [%s], vdmW = [%d], vdmH = [%d]", new Object[] { paramString, this.eve, Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels) });
    this.euM.qsL = true;
    if (((!localView.isLaidOut()) && (paramBoolean1)) || (paramBoolean2))
    {
      localView.post(new a..ExternalSyntheticLambda1(this));
      return;
    }
    int i = localView.getMeasuredWidth();
    int j = localView.getMeasuredHeight();
    Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: width [%d], height[%d]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
    float f1 = i * 1.0F / localDisplayMetrics.widthPixels;
    float f2 = j * 1.0F / localDisplayMetrics.heightPixels;
    float f3 = Math.min(f1, f2);
    Log.i("Luggage.AppBrandWindowLayoutManager", "tuningRtContentView[%s]: scaleMin = [%f], scaleMax = [%f]", new Object[] { paramString, Float.valueOf(f3), Float.valueOf(Math.max(f1, f2)) });
    this.scale = f3;
    paramString = new WxaWindowLayoutParams(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    paramString.gravity = 17;
    paramString.scale = this.scale;
    this.euM.getWindowAndroid().a(paramString, this.euM);
    this.euM.getWindowAndroid().a(androidx.core.content.a.w(this.ctx, a.a.BG_3), this.euM);
    this.euM.qsk.setBackgroundColor(androidx.core.content.a.w(this.ctx, a.a.BG_3));
  }
  
  private final DisplayMetrics asp()
  {
    View localView = getBackgroundView();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(this.euS);
    int i;
    if (this.evb)
    {
      if (this.evd != -1.0D) {
        break label422;
      }
      i = 1;
      if (i == 0) {}
    }
    else
    {
      this.evd = (this.euT * 1.0D / (this.euU * 1.0D));
    }
    int k = this.euT;
    int j = this.euU;
    boolean bool;
    label89:
    double d1;
    label171:
    double d2;
    float f1;
    int m;
    if (localView == null)
    {
      bool = false;
      if (bool)
      {
        s.checkNotNull(localView);
        k = kotlin.k.k.qu(localView.getMeasuredWidth(), localView.getMeasuredHeight());
        j = kotlin.k.k.qv(localView.getMeasuredWidth(), localView.getMeasuredHeight());
        this.evd = (k * 1.0D / (j * 1.0D));
      }
      if ((this.evd <= 1.333333333333333D) || (this.evd >= 4.444444444444445D)) {
        break label438;
      }
      d1 = this.evd;
      localDisplayMetrics.setTo(this.euS);
      d2 = d1;
      if (this.eve != a.b.evi) {
        d2 = 1.0D / d1;
      }
      float f2 = 1.0F;
      f1 = f2;
      if (this.evd >= 1.333333333333333D)
      {
        f1 = f2;
        if (!this.evb) {
          f1 = 0.75F;
        }
      }
      Log.i("Luggage.AppBrandWindowLayoutManager", "getVDisplayMetrics: contentRatio = [%f], systemRatio = [%f], isFold = [%b], ratio = [%f]", new Object[] { Double.valueOf(d2), Double.valueOf(this.evd), Boolean.valueOf(this.evb), Float.valueOf(f1) });
      m = 0;
      i = m;
      if (this.evb)
      {
        if (this.eve != a.b.evi) {
          break label445;
        }
        i = m;
        if (this.euY != 0)
        {
          i = m;
          if (this.euX != 0)
          {
            localDisplayMetrics.heightPixels = this.euY;
            localDisplayMetrics.widthPixels = this.euX;
            i = 1;
          }
        }
      }
      label345:
      if (i == 0)
      {
        if (this.eve != a.b.evi) {
          break label491;
        }
        localDisplayMetrics.heightPixels = ((int)(k * f1));
      }
    }
    for (localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2));; localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2)))
    {
      if (bool)
      {
        if (this.eve != a.b.evi) {
          break label520;
        }
        this.euY = localDisplayMetrics.heightPixels;
        this.euX = localDisplayMetrics.widthPixels;
      }
      return localDisplayMetrics;
      label422:
      i = 0;
      break;
      bool = localView.isLaidOut();
      break label89;
      label438:
      d1 = 1.777777777777778D;
      break label171;
      label445:
      i = m;
      if (this.eva == 0) {
        break label345;
      }
      i = m;
      if (this.euZ == 0) {
        break label345;
      }
      localDisplayMetrics.heightPixels = this.eva;
      localDisplayMetrics.widthPixels = this.euZ;
      i = 1;
      break label345;
      label491:
      localDisplayMetrics.heightPixels = ((int)(j * f1));
    }
    label520:
    this.eva = localDisplayMetrics.heightPixels;
    this.euZ = localDisplayMetrics.widthPixels;
    return localDisplayMetrics;
  }
  
  private final void asr()
  {
    Point localPoint = new Point();
    Object localObject = this.ctx.getSystemService("window");
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if ((ac.fo(this.ctx)) && (com.tencent.luggage.l.k.exm.atm()))
    {
      ((Display)localObject).getRealSize(localPoint);
      ((Display)localObject).getRealMetrics(this.euS);
    }
    for (;;)
    {
      this.bbG = localPoint.x;
      this.bbH = localPoint.y;
      this.euT = Math.max(this.bbG, this.bbH);
      this.euU = Math.min(this.bbG, this.bbH);
      Log.i("Luggage.AppBrandWindowLayoutManager", "refreshDisplayInfo: system [w,h] = [%d,%d]", new Object[] { Integer.valueOf(this.bbG), Integer.valueOf(this.bbH) });
      return;
      ((Display)localObject).getSize(localPoint);
      ((Display)localObject).getMetrics(this.euS);
    }
  }
  
  private final void ass()
  {
    if (!this.euM.mResumed) {
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)this.evf))
    {
      Log.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation by softOrientation[%s]", new Object[] { this.evf });
      this.euN.a(e.b.afK(this.evf), null);
      return;
    }
    e.b localb = this.euN.cHQ();
    s.s(localb, "activityOrientationHandler.currentOrientation");
    Log.i("Luggage.AppBrandWindowLayoutManager", "resetWindowOrientation with orientation[%s]", new Object[] { localb });
    this.euN.a(localb, null);
  }
  
  private final View getBackgroundView()
  {
    Object localObject = this.euM.qsk;
    if (localObject == null) {}
    for (localObject = null; (localObject instanceof View); localObject = ((com.tencent.mm.plugin.appbrand.widget.e)localObject).getParent()) {
      return (View)localObject;
    }
    return null;
  }
  
  private static a.b mu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.w("Luggage.AppBrandWindowLayoutManager", "unexpected orientation [%d], fallback to portrait", new Object[] { Integer.valueOf(paramInt) });
      return a.b.evi;
    case 2: 
      return a.b.evh;
    }
    return a.b.evi;
  }
  
  public final d a(d.b paramb)
  {
    if ((this.ctx instanceof Activity)) {}
    for (Activity localActivity = (Activity)this.ctx;; localActivity = null)
    {
      c localc = this.euM.getWindowAndroid();
      s.s(localc, "rt.windowAndroid");
      return (d)new bm(localc, paramb, localActivity);
    }
  }
  
  public final void a(C paramC)
  {
    s.u(paramC, "initConfig");
    this.euQ = paramC;
    this.euO = paramC.epa.euO;
    a(true, false, "init");
  }
  
  public final void a(b paramb)
  {
    s.u(paramb, "appConfig");
    this.euP = "portrait";
    String str = paramb.ckt().qWy;
    int i;
    if (str == null)
    {
      str = paramb.qVI.euP;
      if (str != null)
      {
        if (((CharSequence)str).length() != 0) {
          break label130;
        }
        i = 1;
        if (i == 0) {}
      }
      else
      {
        str = "portrait";
      }
    }
    for (this.euP = str;; this.euP = str)
    {
      boolean bool1 = paramb.euO;
      boolean bool2 = this.euO;
      if (bool2 != bool1)
      {
        this.euO = bool1;
        a(true, false, "redundancy field check fail");
        Log.w("Luggage.AppBrandWindowLayoutManager", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      }
      return;
      label130:
      i = 0;
      break;
    }
  }
  
  protected final boolean aso()
  {
    return this.euO;
  }
  
  public boolean asq()
  {
    Context localContext = MMApplicationContext.getContext();
    s.s(localContext, "getContext()");
    return ac.fo(localContext);
  }
  
  public final boolean ast()
  {
    return false;
  }
  
  public final boolean asu()
  {
    return (ac.fo(this.ctx)) && (!asq());
  }
  
  public final void b(C paramC)
  {
    s.u(paramC, "initConfig");
    this.euQ = paramC;
    this.euO = paramC.epa.euO;
    if (asq())
    {
      paramC = this.ctx.getResources().getConfiguration();
      s.s(paramC, "ctx.resources.configuration");
      onConfigurationChanged(paramC);
    }
    a(true, true, "onInitConfigUpdated");
  }
  
  public com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler()
  {
    c localc = this.euM.getWindowAndroid();
    s.s(localc, "rt.windowAndroid");
    return (com.tencent.mm.plugin.appbrand.platform.window.e)new com.tencent.mm.plugin.appbrand.platform.window.c.a.a(localc);
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    return asp();
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    s.u(paramConfiguration, "newConfig");
    if ((this.lastOrientation != paramConfiguration.orientation) && (s.p(this.evf, "auto")) && (asq()) && (!this.euO)) {
      this.eve = mu(paramConfiguration.orientation);
    }
    if ((this.lastOrientation != paramConfiguration.orientation) || (paramConfiguration.screenHeightDp != this.euV) || (paramConfiguration.screenWidthDp != this.euW)) {
      if ((!this.euR) && (((paramConfiguration.screenHeightDp == this.euV) && (paramConfiguration.screenWidthDp == this.euW)) || (this.lastOrientation != paramConfiguration.orientation))) {
        break label274;
      }
    }
    label274:
    for (boolean bool = true;; bool = false)
    {
      this.evb = bool;
      if (Build.VERSION.SDK_INT >= 24)
      {
        if ((this.euM.getWindowAndroid().ccm()) || (this.evc)) {
          this.evb = false;
        }
        this.evc = this.euM.getWindowAndroid().ccm();
      }
      asr();
      if ((this.evb) && ((paramConfiguration.screenHeightDp != this.euV) || (paramConfiguration.screenWidthDp != this.euW))) {
        ass();
      }
      View localView = getBackgroundView();
      if (localView != null) {
        localView.addOnLayoutChangeListener((View.OnLayoutChangeListener)new a.c(localView, this));
      }
      this.lastOrientation = paramConfiguration.orientation;
      this.euV = paramConfiguration.screenHeightDp;
      this.euW = paramConfiguration.screenWidthDp;
      return;
    }
  }
  
  public void setSoftOrientation(String paramString)
  {
    localObject3 = null;
    s.u(paramString, "name");
    Log.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation = [%s]", new Object[] { paramString });
    if (paramString != null) {}
    switch (paramString.hashCode())
    {
    default: 
      Log.w("Luggage.AppBrandWindowLayoutManager", "unhandled orientation = [%s]", new Object[] { paramString });
    }
    for (;;)
    {
      try
      {
        localObject1 = this.euM.getPageContainer();
        if (localObject1 != null) {
          continue;
        }
        localObject1 = localObject3;
      }
      catch (AssertionFailedError localAssertionFailedError)
      {
        Object localObject1;
        int i;
        ad localad;
        Object localObject2 = localObject3;
        continue;
      }
      if ((localObject1 == null) || (!(localObject1 instanceof bm)) || (!((bm)localObject1).qyS))
      {
        this.evf = paramString;
        a(true, false, "set softOrientation");
        if (((asq()) || (this.euO)) && ((this.ctx instanceof Activity)))
        {
          Log.i("Luggage.AppBrandWindowLayoutManager", "_softOrientation: unlock orientation");
          i = ((Activity)this.ctx).getRequestedOrientation();
          if ((i != 14) && (i != -1)) {
            this.euN.a(e.b.tLi, new a..ExternalSyntheticLambda0(this));
          }
        }
      }
      return;
      if (!paramString.equals("auto")) {
        break;
      }
      this.eve = mu(this.ctx.getResources().getConfiguration().orientation);
      continue;
      if (!paramString.equals("portrait")) {
        break;
      }
      this.eve = a.b.evi;
      continue;
      if (!paramString.equals("landscape")) {
        break;
      }
      this.eve = a.b.evh;
      continue;
      localad = ((x)localObject1).getPageView();
      localObject1 = localObject3;
      if (localad != null) {
        localObject1 = localad.getFullscreenImpl();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.a
 * JD-Core Version:    0.7.0.1
 */