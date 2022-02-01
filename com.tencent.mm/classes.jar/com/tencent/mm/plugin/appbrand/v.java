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
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.k.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner;", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "heightPx", "", "<set-?>", "", "isFold", "()Z", "isLastInMultiWindowMode", "lastOrientation", "lastScreenHDp", "lastScreenWDp", "lastVHeight", "getLastVHeight", "()I", "setLastVHeight", "(I)V", "lastVWidth", "getLastVWidth", "setLastVWidth", "maxEdge", "minEdge", "systemRatio", "", "widthPx", "value", "", "windowOrientation", "getWindowOrientation", "()Ljava/lang/String;", "setWindowOrientation", "(Ljava/lang/String;)V", "forceCloseSwipeBack", "", "can", "getActivity", "Landroid/app/Activity;", "getBgColor", "getHostView", "Landroid/view/ViewGroup;", "getRuntime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getVDisplayMetrics", "isResizable", "needScale", "needTuning", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "refreshDisplayInfo", "resetRtContentView", "rt", "resetWindowOrientation", "setBgColor", "tuningRtContentView", "waitViewMeasure", "Companion", "OnLayoutChangeListenerWithCounter", "luggage-wxa-app_release"})
public abstract class v
{
  public static final a jhx = new a((byte)0);
  private final DisplayMetrics aHC;
  private final Context ctx;
  int gud;
  private int jhl;
  private int jhm;
  private int jhn;
  private int jho;
  int jhp;
  int jhq;
  int jhr;
  int jhs;
  boolean jht;
  boolean jhu;
  private double jhv;
  String jhw;
  
  public v(Context paramContext)
  {
    this.ctx = paramContext;
    this.aHC = new DisplayMetrics();
    this.jhv = -1.0D;
    paramContext = this.ctx.getResources();
    k.g(paramContext, "ctx.resources");
    this.gud = paramContext.getConfiguration().orientation;
    paramContext = this.ctx.getResources();
    k.g(paramContext, "ctx.resources");
    this.jhq = paramContext.getConfiguration().screenWidthDp;
    paramContext = this.ctx.getResources();
    k.g(paramContext, "ctx.resources");
    this.jhp = paramContext.getConfiguration().screenHeightDp;
    aUv();
  }
  
  private static void K(AppBrandRuntime paramAppBrandRuntime)
  {
    Object localObject = paramAppBrandRuntime.aSB();
    k.g(localObject, "rt.contentView");
    ((d)localObject).setScaleY(1.0F);
    localObject = paramAppBrandRuntime.aSB();
    k.g(localObject, "rt.contentView");
    ((d)localObject).setScaleX(1.0F);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    paramAppBrandRuntime = paramAppBrandRuntime.aSB();
    k.g(paramAppBrandRuntime, "rt.contentView");
    paramAppBrandRuntime.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final boolean aUw()
  {
    if (this.jht) {
      return true;
    }
    return aTz();
  }
  
  private final void fB(boolean paramBoolean)
  {
    AppBrandRuntime localAppBrandRuntime = getRuntime();
    if (localAppBrandRuntime != null) {
      localAppBrandRuntime.fu(paramBoolean);
    }
  }
  
  public abstract void aTA();
  
  public abstract ViewGroup aTB();
  
  public final void aTD()
  {
    int i = getBgColor();
    ac.d("Luggage.AppBrandWindowTuner", "setBgColor: [%d]", new Object[] { Integer.valueOf(i) });
    ViewGroup localViewGroup;
    if (aUw())
    {
      localViewGroup = aTB();
      if (localViewGroup != null) {
        localViewGroup.setBackgroundColor(i);
      }
    }
    do
    {
      return;
      localViewGroup = aTB();
    } while (localViewGroup == null);
    localViewGroup.setBackgroundColor(b.n(this.ctx, 2131101053));
  }
  
  public abstract boolean aTz();
  
  final void aUv()
  {
    Point localPoint = new Point();
    Object localObject = this.ctx.getSystemService("window");
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if ((ad.dS(this.ctx)) && (i.cgk.DU()))
    {
      ((Display)localObject).getRealSize(localPoint);
      ((Display)localObject).getRealMetrics(this.aHC);
    }
    for (;;)
    {
      this.jhl = localPoint.x;
      this.jhm = localPoint.y;
      this.jhn = Math.max(this.jhl, this.jhm);
      this.jho = Math.min(this.jhl, this.jhm);
      ac.i("Luggage.AppBrandWindowTuner", "refreshDisplayInfo: system [w,h] = [%d,%d]", new Object[] { Integer.valueOf(this.jhl), Integer.valueOf(this.jhm) });
      return;
      ((Display)localObject).getSize(localPoint);
      ((Display)localObject).getMetrics(this.aHC);
    }
  }
  
  final void fA(boolean paramBoolean)
  {
    float f2 = 1.0F;
    Object localObject1 = Thread.currentThread();
    Object localObject2 = Looper.getMainLooper();
    k.g(localObject2, "Looper.getMainLooper()");
    if (localObject1 != ((Looper)localObject2).getThread()) {
      ap.f((Runnable)new d(this));
    }
    do
    {
      do
      {
        return;
        localObject1 = getRuntime();
      } while (localObject1 == null);
      localObject2 = getVDisplayMetrics();
      ac.i("Luggage.AppBrandWindowTuner", "tuningRtContentView: orientation = [%s], vdmH = [%d], vdmW = [%d]", new Object[] { this.jhw, Integer.valueOf(((DisplayMetrics)localObject2).heightPixels), Integer.valueOf(((DisplayMetrics)localObject2).widthPixels) });
      if (aUw()) {
        break label263;
      }
      fB(false);
      K((AppBrandRuntime)localObject1);
      localObject3 = ((AppBrandRuntime)localObject1).aSB();
      k.g(localObject3, "rt.contentView");
      f1 = f2;
      if (((d)localObject3).getScaleX() != 1.0F) {
        break;
      }
      localObject3 = ((AppBrandRuntime)localObject1).aSB();
      k.g(localObject3, "rt.contentView");
    } while (((d)localObject3).getScaleY() == 1.0F);
    float f1 = f2;
    localObject2 = new FrameLayout.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    Object localObject3 = ((AppBrandRuntime)localObject1).aSB();
    k.g(localObject3, "rt.contentView");
    ((d)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = ((AppBrandRuntime)localObject1).aSB();
    k.g(localObject2, "rt.contentView");
    ((d)localObject2).setScaleY(f1);
    localObject1 = ((AppBrandRuntime)localObject1).aSB();
    k.g(localObject1, "rt.contentView");
    ((d)localObject1).setScaleX(f1);
    return;
    label263:
    fB(true);
    localObject3 = aTB();
    if ((localObject3 != null) && (!((ViewGroup)localObject3).isLaidOut()) && (paramBoolean))
    {
      ((ViewGroup)localObject3).post((Runnable)new e(this));
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
    for (int j = ((ViewGroup)localObject3).getMeasuredHeight();; j = this.jhm)
    {
      ac.i("Luggage.AppBrandWindowTuner", "tuningRtContentView: [%d,%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      f2 = i * 1.0F / ((DisplayMetrics)localObject2).widthPixels;
      float f3 = j * 1.0F / ((DisplayMetrics)localObject2).heightPixels;
      f1 = Math.min(f2, f3);
      ac.i("Luggage.AppBrandWindowTuner", "tuningRtContentView: scaleMin = [%f], scaleMax = [%f]", new Object[] { Float.valueOf(f1), Float.valueOf(Math.max(f2, f3)) });
      break;
      i = this.jhl;
      break label321;
    }
  }
  
  public abstract Activity getActivity();
  
  public abstract int getBgColor();
  
  public abstract AppBrandRuntime getRuntime();
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(this.aHC);
    if ((!this.jht) || (this.jhv == -1.0D)) {
      this.jhv = (this.jhn * 1.0D / (this.jho * 1.0D));
    }
    int k = this.jhn;
    int m = this.jho;
    ViewGroup localViewGroup = aTB();
    int i = m;
    int j = k;
    if (localViewGroup != null)
    {
      i = m;
      j = k;
      if (localViewGroup.isLaidOut() == true)
      {
        k = h.la(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
        m = h.lb(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
        if (this.jht)
        {
          i = m;
          j = k;
          if (this.jhv != -1.0D) {}
        }
        else
        {
          this.jhv = (k * 1.0D / (m * 1.0D));
          j = k;
          i = m;
        }
      }
    }
    if ((this.jhv > 1.333333333333333D) && (this.jhv < 2.666666666666667D)) {}
    double d2;
    float f1;
    for (double d1 = this.jhv;; d1 = 1.777777777777778D)
    {
      localDisplayMetrics.setTo(this.aHC);
      d2 = d1;
      if ((k.g(this.jhw, "portrait") ^ true)) {
        d2 = 1.0D / d1;
      }
      ac.i("Luggage.AppBrandWindowTuner", "getVDisplayMetrics: contentRatio = [%f], systemRatio = [%f], isFold = [%b]", new Object[] { Double.valueOf(d2), Double.valueOf(this.jhv), Boolean.valueOf(this.jht) });
      float f2 = 1.0F;
      f1 = f2;
      if (this.jhv >= 1.333333333333333D)
      {
        f1 = f2;
        if (!this.jht) {
          f1 = 0.75F;
        }
      }
      if ((!this.jht) || (this.jhs == 0) || (this.jhr == 0)) {
        break;
      }
      localDisplayMetrics.heightPixels = this.jhs;
      localDisplayMetrics.widthPixels = this.jhr;
      return localDisplayMetrics;
    }
    if (k.g(this.jhw, "portrait")) {
      localDisplayMetrics.heightPixels = ((int)(j * f1));
    }
    for (localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2));; localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2)))
    {
      this.jhs = localDisplayMetrics.heightPixels;
      this.jhr = localDisplayMetrics.widthPixels;
      return localDisplayMetrics;
      localDisplayMetrics.heightPixels = ((int)(i * f1));
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner$OnLayoutChangeListenerWithCounter;", "Landroid/view/View$OnLayoutChangeListener;", "()V", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "luggage-wxa-app_release"})
  public static class b
    implements View.OnLayoutChangeListener
  {
    private int fqZ;
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(193264);
      this.fqZ += 1;
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, this.fqZ);
      AppMethodBeat.o(193264);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/AppBrandWindowTuner$onConfigurationChanged$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner$OnLayoutChangeListenerWithCounter;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "counter", "luggage-wxa-app_release"})
  public static final class c
    extends v.b
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(193265);
      if (paramInt9 == 10)
      {
        localViewGroup = this.jhy.aTB();
        if (localViewGroup != null)
        {
          localViewGroup.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
          AppMethodBeat.o(193265);
          return;
        }
        AppMethodBeat.o(193265);
        return;
      }
      this.jhy.aTD();
      ac.i("Luggage.AppBrandWindowTuner", "onLayoutChange: [%d,%d,%d,%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8) });
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt4) && (paramInt1 == paramInt3)) {}
      for (paramInt9 = 1; (paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8) && (paramInt2 == paramInt6) && (paramInt9 == 0); paramInt9 = 0)
      {
        ac.i("Luggage.AppBrandWindowTuner", "onLayoutChange: no changed, ignore");
        AppMethodBeat.o(193265);
        return;
      }
      this.jhy.fA(true);
      ViewGroup localViewGroup = this.jhy.aTB();
      if (localViewGroup != null)
      {
        localViewGroup.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(193265);
        return;
      }
      AppMethodBeat.o(193265);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(193266);
      this.jhy.fA(true);
      AppMethodBeat.o(193266);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(193267);
      v.a(this.jhy);
      AppMethodBeat.o(193267);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/AppBrandWindowTuner$windowOrientation$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "luggage-wxa-app_release"})
  public static final class f
    implements View.OnLayoutChangeListener
  {
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(193268);
      k.h(paramView, "v");
      this.jhy.fA(true);
      paramView = this.jhy.aTB();
      if (paramView != null)
      {
        paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(193268);
        return;
      }
      AppMethodBeat.o(193268);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v
 * JD-Core Version:    0.7.0.1
 */