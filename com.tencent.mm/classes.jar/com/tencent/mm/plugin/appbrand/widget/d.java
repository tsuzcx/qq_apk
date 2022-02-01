package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.e.h;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.appbrand.w.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class d
  extends FrameLayout
{
  private final Set<Runnable> qqv;
  private final a rnt;
  private b rnu;
  private i rnv;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135389);
    this.rnu = new b();
    this.rnv = null;
    this.qqv = new HashSet();
    setWillNotDraw(false);
    this.rnt = ((a)e.M(a.class));
    AppMethodBeat.o(135389);
  }
  
  public final void ai(final Runnable paramRunnable)
  {
    AppMethodBeat.i(135391);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(135391);
      return;
    }
    if (!ai.Or())
    {
      h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135388);
          d.this.ai(paramRunnable);
          AppMethodBeat.o(135388);
        }
      });
      AppMethodBeat.o(135391);
      return;
    }
    if (getAnimation() == null)
    {
      paramRunnable.run();
      AppMethodBeat.o(135391);
      return;
    }
    this.qqv.add(paramRunnable);
    AppMethodBeat.o(135391);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(135390);
    if (willNotDraw())
    {
      AppMethodBeat.o(135390);
      return;
    }
    try
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(135390);
      return;
    }
    catch (Exception paramCanvas)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("Luggage.WXA.AppBrandRuntimeFrameLayout", paramCanvas, "", new Object[0]);
      if (!(paramCanvas instanceof NullPointerException)) {
        break label71;
      }
    }
    this.rnt.idkeyStat(1088L, 0L, 1L, false);
    for (;;)
    {
      AppMethodBeat.o(135390);
      throw paramCanvas;
      label71:
      this.rnt.idkeyStat(1088L, 1L, 1L, false);
    }
  }
  
  protected FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(246106);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(246106);
    return localLayoutParams;
  }
  
  protected void onAnimationEnd()
  {
    AppMethodBeat.i(135392);
    super.onAnimationEnd();
    Iterator localIterator = this.qqv.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.qqv.clear();
    AppMethodBeat.o(135392);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(246108);
    b localb = this.rnu;
    if (localb.rnx != null)
    {
      float[] arrayOfFloat = localb.rnx.cmV();
      localb.byG.setEmpty();
      localb.rnw.getGlobalVisibleRect(localb.byG);
      RectF localRectF = new RectF(0.0F, 0.0F, localb.byG.right - localb.byG.left, localb.byG.bottom - localb.byG.top);
      localb.rny.setEmpty();
      localb.rny.left = 0.0F;
      localb.rny.top = 0.0F;
      localb.rny.right = (localb.byG.right - localb.byG.left);
      localb.rny.bottom = (localb.byG.bottom - localb.byG.top);
      localb.aBZ.rewind();
      localb.aBZ.addRoundRect(localRectF, arrayOfFloat, Path.Direction.CW);
      localb.aBZ.close();
      paramCanvas.clipPath(localb.aBZ);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(246108);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(246112);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.rnv != null) {
      this.rnv.C(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(246112);
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(135393);
    super.onViewRemoved(paramView);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandRuntimeFrameLayout", "onViewRemoved %s", new Object[] { paramView });
    AppMethodBeat.o(135393);
  }
  
  public void removeAllViews()
  {
    AppMethodBeat.i(135394);
    com.tencent.mm.sdk.platformtools.Log.d("Luggage.WXA.AppBrandRuntimeFrameLayout", "removeAllViews stack = %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    super.removeAllViews();
    AppMethodBeat.o(135394);
  }
  
  public void setRoundCornerProvider(d.a parama)
  {
    this.rnu.rnx = parama;
  }
  
  public void setWxaHalfScreenGestureController(i parami)
  {
    this.rnv = parami;
  }
  
  final class b
  {
    Path aBZ;
    Rect byG;
    public d.a rnx;
    RectF rny;
    
    public b()
    {
      AppMethodBeat.i(246753);
      this.rnx = null;
      this.byG = new Rect();
      this.rny = new RectF();
      this.aBZ = new Path();
      AppMethodBeat.o(246753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d
 * JD-Core Version:    0.7.0.1
 */