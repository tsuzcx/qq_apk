package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Looper;
import android.support.v4.content.b;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.k.h;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner;", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "heightPx", "", "<set-?>", "", "isFold", "()Z", "isLastInMultiWindowMode", "lastOrientation", "lastScreenHDp", "lastScreenWDp", "lastVHeight", "getLastVHeight", "()I", "setLastVHeight", "(I)V", "lastVWidth", "getLastVWidth", "setLastVWidth", "maxEdge", "minEdge", "value", "", "softOrientation", "getSoftOrientation", "()Ljava/lang/String;", "setSoftOrientation", "(Ljava/lang/String;)V", "systemRatio", "", "widthPx", "windowOrientation", "Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner$WindowOrientation;", "forceCloseSwipeBack", "", "can", "getActivity", "Landroid/app/Activity;", "getBgColor", "getHostView", "Landroid/view/ViewGroup;", "getRuntime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getVDisplayMetrics", "isResizable", "needScale", "needTuning", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "parseOrientation", "configurationOrientation", "refreshDisplayInfo", "resetRtContentView", "rt", "resetWindowOrientation", "setBgColor", "tuningRtContentView", "waitViewMeasure", "Companion", "OnLayoutChangeListenerWithCounter", "WindowOrientation", "luggage-wxa-app_release"})
public abstract class v
{
  public static final v.a jAD = new v.a((byte)0);
  private final DisplayMetrics aJt;
  final Context ctx;
  int gNO;
  private double jAA;
  v.c jAB;
  String jAC;
  private int jAq;
  private int jAr;
  private int jAs;
  private int jAt;
  int jAu;
  int jAv;
  int jAw;
  int jAx;
  boolean jAy;
  boolean jAz;
  
  public v(Context paramContext)
  {
    this.ctx = paramContext;
    this.aJt = new DisplayMetrics();
    this.jAA = -1.0D;
    paramContext = this.ctx.getResources();
    p.g(paramContext, "ctx.resources");
    this.jAB = rF(paramContext.getConfiguration().orientation);
    paramContext = this.ctx.getResources();
    p.g(paramContext, "ctx.resources");
    this.gNO = paramContext.getConfiguration().orientation;
    paramContext = this.ctx.getResources();
    p.g(paramContext, "ctx.resources");
    this.jAv = paramContext.getConfiguration().screenWidthDp;
    paramContext = this.ctx.getResources();
    p.g(paramContext, "ctx.resources");
    this.jAu = paramContext.getConfiguration().screenHeightDp;
    aXH();
  }
  
  private static void H(AppBrandRuntime paramAppBrandRuntime)
  {
    Object localObject = paramAppBrandRuntime.aVO();
    p.g(localObject, "rt.contentView");
    ((d)localObject).setScaleY(1.0F);
    localObject = paramAppBrandRuntime.aVO();
    p.g(localObject, "rt.contentView");
    ((d)localObject).setScaleX(1.0F);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    paramAppBrandRuntime = paramAppBrandRuntime.aVO();
    p.g(paramAppBrandRuntime, "rt.contentView");
    paramAppBrandRuntime.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final boolean aXI()
  {
    if (this.jAy) {
      return true;
    }
    return aWH();
  }
  
  private final void fF(boolean paramBoolean)
  {
    AppBrandRuntime localAppBrandRuntime = getRuntime();
    if (localAppBrandRuntime != null) {
      localAppBrandRuntime.fy(paramBoolean);
    }
  }
  
  static v.c rF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ad.w("Luggage.AppBrandWindowTuner", "unexpected orientation [%d], fallback to portrait", new Object[] { Integer.valueOf(paramInt) });
      return v.c.jAF;
    case 2: 
      return v.c.jAE;
    }
    return v.c.jAF;
  }
  
  public abstract boolean aWG();
  
  public abstract boolean aWH();
  
  public abstract void aWI();
  
  public abstract ViewGroup aWJ();
  
  public final void aWL()
  {
    int i = getBgColor();
    ViewGroup localViewGroup;
    if (aXI())
    {
      localViewGroup = aWJ();
      if (localViewGroup != null) {
        localViewGroup.setBackgroundColor(i);
      }
    }
    do
    {
      return;
      localViewGroup = aWJ();
    } while (localViewGroup == null);
    localViewGroup.setBackgroundColor(b.n(this.ctx, 2131101053));
  }
  
  final void aXH()
  {
    Point localPoint = new Point();
    Object localObject = this.ctx.getSystemService("window");
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if ((af.dS(this.ctx)) && (i.cqA.Ft()))
    {
      ((Display)localObject).getRealSize(localPoint);
      ((Display)localObject).getRealMetrics(this.aJt);
    }
    for (;;)
    {
      this.jAq = localPoint.x;
      this.jAr = localPoint.y;
      this.jAs = Math.max(this.jAq, this.jAr);
      this.jAt = Math.min(this.jAq, this.jAr);
      ad.i("Luggage.AppBrandWindowTuner", "refreshDisplayInfo: system [w,h] = [%d,%d]", new Object[] { Integer.valueOf(this.jAq), Integer.valueOf(this.jAr) });
      return;
      ((Display)localObject).getSize(localPoint);
      ((Display)localObject).getMetrics(this.aJt);
    }
  }
  
  final void fE(boolean paramBoolean)
  {
    float f2 = 1.0F;
    Object localObject1 = Thread.currentThread();
    Object localObject2 = Looper.getMainLooper();
    p.g(localObject2, "Looper.getMainLooper()");
    if (localObject1 != ((Looper)localObject2).getThread()) {
      aq.f((Runnable)new f(this));
    }
    do
    {
      do
      {
        return;
        localObject1 = getRuntime();
      } while (localObject1 == null);
      localObject2 = getVDisplayMetrics();
      ad.i("Luggage.AppBrandWindowTuner", "tuningRtContentView: orientation = [%s], vdmH = [%d], vdmW = [%d]", new Object[] { this.jAB, Integer.valueOf(((DisplayMetrics)localObject2).heightPixels), Integer.valueOf(((DisplayMetrics)localObject2).widthPixels) });
      if (aXI()) {
        break label263;
      }
      fF(false);
      H((AppBrandRuntime)localObject1);
      localObject3 = ((AppBrandRuntime)localObject1).aVO();
      p.g(localObject3, "rt.contentView");
      f1 = f2;
      if (((d)localObject3).getScaleX() != 1.0F) {
        break;
      }
      localObject3 = ((AppBrandRuntime)localObject1).aVO();
      p.g(localObject3, "rt.contentView");
    } while (((d)localObject3).getScaleY() == 1.0F);
    float f1 = f2;
    localObject2 = new FrameLayout.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    Object localObject3 = ((AppBrandRuntime)localObject1).aVO();
    p.g(localObject3, "rt.contentView");
    ((d)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = ((AppBrandRuntime)localObject1).aVO();
    p.g(localObject2, "rt.contentView");
    ((d)localObject2).setScaleY(f1);
    localObject1 = ((AppBrandRuntime)localObject1).aVO();
    p.g(localObject1, "rt.contentView");
    ((d)localObject1).setScaleX(f1);
    return;
    label263:
    fF(true);
    localObject3 = aWJ();
    if ((localObject3 != null) && (!((ViewGroup)localObject3).isLaidOut()) && (paramBoolean))
    {
      ((ViewGroup)localObject3).post((Runnable)new g(this));
      return;
    }
    int i;
    if (localObject3 != null)
    {
      i = ((ViewGroup)localObject3).getMeasuredWidth();
      label321:
      if (localObject3 == null) {
        break label438;
      }
    }
    label438:
    for (int j = ((ViewGroup)localObject3).getMeasuredHeight();; j = this.jAr)
    {
      ad.i("Luggage.AppBrandWindowTuner", "tuningRtContentView: [%d,%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      f2 = i * 1.0F / ((DisplayMetrics)localObject2).widthPixels;
      float f3 = j * 1.0F / ((DisplayMetrics)localObject2).heightPixels;
      f1 = Math.min(f2, f3);
      ad.i("Luggage.AppBrandWindowTuner", "tuningRtContentView: scaleMin = [%f], scaleMax = [%f]", new Object[] { Float.valueOf(f1), Float.valueOf(Math.max(f2, f3)) });
      break;
      i = this.jAq;
      break label321;
    }
  }
  
  public abstract Activity getActivity();
  
  public abstract int getBgColor();
  
  public abstract AppBrandRuntime getRuntime();
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(this.aJt);
    if ((!this.jAy) || (this.jAA == -1.0D)) {
      this.jAA = (this.jAs * 1.0D / (this.jAt * 1.0D));
    }
    int k = this.jAs;
    int m = this.jAt;
    ViewGroup localViewGroup = aWJ();
    int i = m;
    int j = k;
    if (localViewGroup != null)
    {
      i = m;
      j = k;
      if (localViewGroup.isLaidOut() == true)
      {
        k = h.lp(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
        m = h.lq(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
        if (this.jAy)
        {
          i = m;
          j = k;
          if (this.jAA != -1.0D) {}
        }
        else
        {
          this.jAA = (k * 1.0D / (m * 1.0D));
          j = k;
          i = m;
        }
      }
    }
    if ((this.jAA > 1.333333333333333D) && (this.jAA < 2.666666666666667D)) {}
    double d2;
    float f1;
    for (double d1 = this.jAA;; d1 = 1.777777777777778D)
    {
      localDisplayMetrics.setTo(this.aJt);
      d2 = d1;
      if (this.jAB != v.c.jAF) {
        d2 = 1.0D / d1;
      }
      ad.i("Luggage.AppBrandWindowTuner", "getVDisplayMetrics: contentRatio = [%f], systemRatio = [%f], isFold = [%b]", new Object[] { Double.valueOf(d2), Double.valueOf(this.jAA), Boolean.valueOf(this.jAy) });
      float f2 = 1.0F;
      f1 = f2;
      if (this.jAA >= 1.333333333333333D)
      {
        f1 = f2;
        if (!this.jAy) {
          f1 = 0.75F;
        }
      }
      if ((!this.jAy) || (this.jAx == 0) || (this.jAw == 0)) {
        break;
      }
      localDisplayMetrics.heightPixels = this.jAx;
      localDisplayMetrics.widthPixels = this.jAw;
      return localDisplayMetrics;
    }
    if (this.jAB == v.c.jAF) {
      localDisplayMetrics.heightPixels = ((int)(j * f1));
    }
    for (localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2));; localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2)))
    {
      this.jAx = localDisplayMetrics.heightPixels;
      this.jAw = localDisplayMetrics.widthPixels;
      return localDisplayMetrics;
      localDisplayMetrics.heightPixels = ((int)(i * f1));
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/AppBrandWindowTuner$onConfigurationChanged$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner$OnLayoutChangeListenerWithCounter;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "counter", "luggage-wxa-app_release"})
  public static final class d
    extends v.b
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(197484);
      if (paramInt9 == 10)
      {
        localViewGroup = this.jAH.aWJ();
        if (localViewGroup != null)
        {
          localViewGroup.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
          AppMethodBeat.o(197484);
          return;
        }
        AppMethodBeat.o(197484);
        return;
      }
      this.jAH.aWL();
      ad.i("Luggage.AppBrandWindowTuner", "onLayoutChange: [%d,%d,%d,%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8) });
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt4) && (paramInt1 == paramInt3)) {}
      for (paramInt9 = 1; (paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8) && (paramInt2 == paramInt6) && (paramInt9 == 0); paramInt9 = 0)
      {
        ad.i("Luggage.AppBrandWindowTuner", "onLayoutChange: no changed, ignore");
        AppMethodBeat.o(197484);
        return;
      }
      this.jAH.fE(true);
      ViewGroup localViewGroup = this.jAH.aWJ();
      if (localViewGroup != null)
      {
        localViewGroup.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(197484);
        return;
      }
      AppMethodBeat.o(197484);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/AppBrandWindowTuner$softOrientation$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "luggage-wxa-app_release"})
  public static final class e
    implements View.OnLayoutChangeListener
  {
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(197485);
      p.h(paramView, "v");
      this.jAH.fE(true);
      paramView = this.jAH.aWJ();
      if (paramView != null)
      {
        paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(197485);
        return;
      }
      AppMethodBeat.o(197485);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(197486);
      this.jAH.fE(true);
      AppMethodBeat.o(197486);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(197487);
      v.a(this.jAH);
      AppMethodBeat.o(197487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v
 * JD-Core Version:    0.7.0.1
 */