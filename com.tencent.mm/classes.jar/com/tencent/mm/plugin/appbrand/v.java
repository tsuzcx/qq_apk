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
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.k.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner;", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "heightPx", "", "<set-?>", "", "isFold", "()Z", "isLastInMultiWindowMode", "setLastInMultiWindowMode", "(Z)V", "lastOrientation", "lastScreenHDp", "lastScreenWDp", "lastVHeight", "getLastVHeight", "()I", "setLastVHeight", "(I)V", "lastVWidth", "getLastVWidth", "setLastVWidth", "maxEdge", "minEdge", "systemRatio", "", "widthPx", "value", "", "windowOrientation", "getWindowOrientation", "()Ljava/lang/String;", "setWindowOrientation", "(Ljava/lang/String;)V", "forceCloseSwipeBack", "", "can", "getActivity", "Landroid/app/Activity;", "getBgColor", "getHostView", "Landroid/view/ViewGroup;", "getRuntime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getVDisplayMetrics", "isResizable", "needScale", "needTuning", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "refreshDisplayInfo", "resetRtContentView", "rt", "resetWindowOrientation", "setBgColor", "tuningRtContentView", "waitViewMeasure", "Companion", "OnLayoutChangeListenerWithCounter", "luggage-wxa-app_release"})
public abstract class v
{
  public static final a iHv = new a((byte)0);
  private final DisplayMetrics aGM;
  private final Context ctx;
  private int iHi;
  private int iHj;
  private int iHk;
  private int iHl;
  int iHm;
  int iHn;
  int iHo;
  int iHp;
  int iHq;
  boolean iHr;
  boolean iHs;
  private double iHt;
  String iHu;
  
  public v(Context paramContext)
  {
    this.ctx = paramContext;
    this.aGM = new DisplayMetrics();
    this.iHt = -1.0D;
    paramContext = this.ctx.getResources();
    k.g(paramContext, "ctx.resources");
    this.iHo = paramContext.getConfiguration().orientation;
    paramContext = this.ctx.getResources();
    k.g(paramContext, "ctx.resources");
    this.iHn = paramContext.getConfiguration().screenWidthDp;
    paramContext = this.ctx.getResources();
    k.g(paramContext, "ctx.resources");
    this.iHm = paramContext.getConfiguration().screenHeightDp;
    aNF();
  }
  
  private static void K(AppBrandRuntime paramAppBrandRuntime)
  {
    Object localObject = paramAppBrandRuntime.aLL();
    k.g(localObject, "rt.contentView");
    ((d)localObject).setScaleY(1.0F);
    localObject = paramAppBrandRuntime.aLL();
    k.g(localObject, "rt.contentView");
    ((d)localObject).setScaleX(1.0F);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    paramAppBrandRuntime = paramAppBrandRuntime.aLL();
    k.g(paramAppBrandRuntime, "rt.contentView");
    paramAppBrandRuntime.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final boolean aNG()
  {
    if (this.iHr) {
      return true;
    }
    return aMJ();
  }
  
  private final void fg(boolean paramBoolean)
  {
    AppBrandRuntime localAppBrandRuntime = getRuntime();
    if (localAppBrandRuntime != null) {
      localAppBrandRuntime.fa(paramBoolean);
    }
  }
  
  public abstract boolean aMJ();
  
  public abstract void aMK();
  
  public abstract ViewGroup aML();
  
  public final void aMN()
  {
    int i = getBgColor();
    ad.d("Luggage.AppBrandWindowTuner", "setBgColor: [%d]", new Object[] { Integer.valueOf(i) });
    ViewGroup localViewGroup;
    if (aNG())
    {
      localViewGroup = aML();
      if (localViewGroup != null) {
        localViewGroup.setBackgroundColor(i);
      }
    }
    do
    {
      return;
      localViewGroup = aML();
    } while (localViewGroup == null);
    localViewGroup.setBackgroundColor(b.n(this.ctx, 2131101053));
  }
  
  final void aNF()
  {
    Point localPoint = new Point();
    Object localObject = this.ctx.getSystemService("window");
    if (localObject == null) {
      throw new d.v("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if ((ac.dK(this.ctx)) && (i.cjn.Er()))
    {
      ((Display)localObject).getRealSize(localPoint);
      ((Display)localObject).getRealMetrics(this.aGM);
    }
    for (;;)
    {
      this.iHi = localPoint.x;
      this.iHj = localPoint.y;
      this.iHk = Math.max(this.iHi, this.iHj);
      this.iHl = Math.min(this.iHi, this.iHj);
      ad.i("Luggage.AppBrandWindowTuner", "refreshDisplayInfo: system [w,h] = [%d,%d]", new Object[] { Integer.valueOf(this.iHi), Integer.valueOf(this.iHj) });
      return;
      ((Display)localObject).getSize(localPoint);
      ((Display)localObject).getMetrics(this.aGM);
    }
  }
  
  final void ff(boolean paramBoolean)
  {
    float f2 = 1.0F;
    Object localObject1 = Thread.currentThread();
    Object localObject2 = Looper.getMainLooper();
    k.g(localObject2, "Looper.getMainLooper()");
    if (localObject1 != ((Looper)localObject2).getThread()) {
      aq.f((Runnable)new d(this));
    }
    do
    {
      do
      {
        return;
        localObject1 = getRuntime();
      } while (localObject1 == null);
      localObject2 = getVDisplayMetrics();
      ad.i("Luggage.AppBrandWindowTuner", "tuningRtContentView: orientation = [%s], vdmH = [%d], vdmW = [%d]", new Object[] { this.iHu, Integer.valueOf(((DisplayMetrics)localObject2).heightPixels), Integer.valueOf(((DisplayMetrics)localObject2).widthPixels) });
      if (aNG()) {
        break label263;
      }
      fg(false);
      K((AppBrandRuntime)localObject1);
      localObject3 = ((AppBrandRuntime)localObject1).aLL();
      k.g(localObject3, "rt.contentView");
      f1 = f2;
      if (((d)localObject3).getScaleX() != 1.0F) {
        break;
      }
      localObject3 = ((AppBrandRuntime)localObject1).aLL();
      k.g(localObject3, "rt.contentView");
    } while (((d)localObject3).getScaleY() == 1.0F);
    float f1 = f2;
    localObject2 = new FrameLayout.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    Object localObject3 = ((AppBrandRuntime)localObject1).aLL();
    k.g(localObject3, "rt.contentView");
    ((d)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = ((AppBrandRuntime)localObject1).aLL();
    k.g(localObject2, "rt.contentView");
    ((d)localObject2).setScaleY(f1);
    localObject1 = ((AppBrandRuntime)localObject1).aLL();
    k.g(localObject1, "rt.contentView");
    ((d)localObject1).setScaleX(f1);
    return;
    label263:
    fg(true);
    localObject3 = aML();
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
    for (int j = ((ViewGroup)localObject3).getMeasuredHeight();; j = this.iHj)
    {
      ad.i("Luggage.AppBrandWindowTuner", "tuningRtContentView: [%d,%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      f2 = i * 1.0F / ((DisplayMetrics)localObject2).widthPixels;
      float f3 = j * 1.0F / ((DisplayMetrics)localObject2).heightPixels;
      f1 = Math.min(f2, f3);
      ad.i("Luggage.AppBrandWindowTuner", "tuningRtContentView: scaleMin = [%f], scaleMax = [%f]", new Object[] { Float.valueOf(f1), Float.valueOf(Math.max(f2, f3)) });
      break;
      i = this.iHi;
      break label321;
    }
  }
  
  public abstract Activity getActivity();
  
  public abstract int getBgColor();
  
  public abstract AppBrandRuntime getRuntime();
  
  public final DisplayMetrics getVDisplayMetrics()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(this.aGM);
    if ((!this.iHr) || (this.iHt == -1.0D)) {
      this.iHt = (this.iHk * 1.0D / (this.iHl * 1.0D));
    }
    int k = this.iHk;
    int m = this.iHl;
    ViewGroup localViewGroup = aML();
    int i = m;
    int j = k;
    if (localViewGroup != null)
    {
      i = m;
      j = k;
      if (localViewGroup.isLaidOut() == true)
      {
        k = h.kK(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
        m = h.kL(localViewGroup.getMeasuredWidth(), localViewGroup.getMeasuredHeight());
        if (this.iHr)
        {
          i = m;
          j = k;
          if (this.iHt != -1.0D) {}
        }
        else
        {
          this.iHt = (k * 1.0D / (m * 1.0D));
          j = k;
          i = m;
        }
      }
    }
    if ((this.iHt > 1.333333333333333D) && (this.iHt < 2.666666666666667D)) {}
    double d2;
    float f1;
    for (double d1 = this.iHt;; d1 = 1.777777777777778D)
    {
      localDisplayMetrics.setTo(this.aGM);
      d2 = d1;
      if ((k.g(this.iHu, "portrait") ^ true)) {
        d2 = 1.0D / d1;
      }
      ad.i("Luggage.AppBrandWindowTuner", "getVDisplayMetrics: contentRatio = [%f], systemRatio = [%f], isFold = [%b]", new Object[] { Double.valueOf(d2), Double.valueOf(this.iHt), Boolean.valueOf(this.iHr) });
      float f2 = 1.0F;
      f1 = f2;
      if (this.iHt >= 1.333333333333333D)
      {
        f1 = f2;
        if (!this.iHr) {
          f1 = 0.75F;
        }
      }
      if ((!this.iHr) || (this.iHq == 0) || (this.iHp == 0)) {
        break;
      }
      localDisplayMetrics.heightPixels = this.iHq;
      localDisplayMetrics.widthPixels = this.iHp;
      return localDisplayMetrics;
    }
    if (k.g(this.iHu, "portrait")) {
      localDisplayMetrics.heightPixels = ((int)(j * f1));
    }
    for (localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2));; localDisplayMetrics.widthPixels = ((int)(localDisplayMetrics.heightPixels / d2)))
    {
      this.iHq = localDisplayMetrics.heightPixels;
      this.iHp = localDisplayMetrics.widthPixels;
      return localDisplayMetrics;
      localDisplayMetrics.heightPixels = ((int)(i * f1));
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner$OnLayoutChangeListenerWithCounter;", "Landroid/view/View$OnLayoutChangeListener;", "()V", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "luggage-wxa-app_release"})
  public static class b
    implements View.OnLayoutChangeListener
  {
    private int fnF;
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9) {}
    
    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(194354);
      this.fnF += 1;
      a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, this.fnF);
      AppMethodBeat.o(194354);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/AppBrandWindowTuner$onConfigurationChanged$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandWindowTuner$OnLayoutChangeListenerWithCounter;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "counter", "luggage-wxa-app_release"})
  public static final class c
    extends v.b
  {
    public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(194355);
      if (paramInt9 == 10)
      {
        localViewGroup = this.iHw.aML();
        if (localViewGroup != null)
        {
          localViewGroup.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
          AppMethodBeat.o(194355);
          return;
        }
        AppMethodBeat.o(194355);
        return;
      }
      this.iHw.aMN();
      ad.i("Luggage.AppBrandWindowTuner", "onLayoutChange: [%d,%d,%d,%d,%d,%d,%d,%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8) });
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt4) && (paramInt1 == paramInt3)) {}
      for (paramInt9 = 1; (paramInt1 == paramInt5) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8) && (paramInt2 == paramInt6) && (paramInt9 == 0); paramInt9 = 0)
      {
        ad.i("Luggage.AppBrandWindowTuner", "onLayoutChange: no changed, ignore");
        AppMethodBeat.o(194355);
        return;
      }
      this.iHw.ff(true);
      ViewGroup localViewGroup = this.iHw.aML();
      if (localViewGroup != null)
      {
        localViewGroup.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(194355);
        return;
      }
      AppMethodBeat.o(194355);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(194356);
      this.iHw.ff(true);
      AppMethodBeat.o(194356);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(194357);
      v.a(this.iHw);
      AppMethodBeat.o(194357);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/AppBrandWindowTuner$windowOrientation$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "luggage-wxa-app_release"})
  public static final class f
    implements View.OnLayoutChangeListener
  {
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(194358);
      k.h(paramView, "v");
      this.iHw.ff(true);
      paramView = this.iHw.aML();
      if (paramView != null)
      {
        paramView.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        AppMethodBeat.o(194358);
        return;
      }
      AppMethodBeat.o(194358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v
 * JD-Core Version:    0.7.0.1
 */