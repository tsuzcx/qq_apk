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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.plugin.appbrand.w.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class c
  extends FrameLayout
{
  private final Set<Runnable> noL;
  private final a olb;
  private b olc;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135389);
    this.olc = new b();
    this.noL = new HashSet();
    setWillNotDraw(false);
    this.olb = ((a)e.O(a.class));
    AppMethodBeat.o(135389);
  }
  
  public final void af(final Runnable paramRunnable)
  {
    AppMethodBeat.i(135391);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(135391);
      return;
    }
    if (!ag.LB())
    {
      h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135388);
          c.this.af(paramRunnable);
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
    this.noL.add(paramRunnable);
    AppMethodBeat.o(135391);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
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
    this.olb.idkeyStat(1088L, 0L, 1L, false);
    for (;;)
    {
      AppMethodBeat.o(135390);
      throw paramCanvas;
      label71:
      this.olb.idkeyStat(1088L, 1L, 1L, false);
    }
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(219613);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(219613);
    return localLayoutParams;
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(135392);
    super.onAnimationEnd();
    Iterator localIterator = this.noL.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.noL.clear();
    AppMethodBeat.o(135392);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(219614);
    b localb = this.olc;
    if (localb.ole != null)
    {
      float[] arrayOfFloat = localb.ole.bOp();
      localb.rect.setEmpty();
      localb.old.getGlobalVisibleRect(localb.rect);
      RectF localRectF = new RectF(0.0F, 0.0F, localb.rect.right - localb.rect.left, localb.rect.bottom - localb.rect.top);
      localb.olf.setEmpty();
      localb.olf.left = 0.0F;
      localb.olf.top = 0.0F;
      localb.olf.right = (localb.rect.right - localb.rect.left);
      localb.olf.bottom = (localb.rect.bottom - localb.rect.top);
      localb.lR.rewind();
      localb.lR.addRoundRect(localRectF, arrayOfFloat, Path.Direction.CW);
      localb.lR.close();
      paramCanvas.clipPath(localb.lR);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(219614);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(135393);
    super.onViewRemoved(paramView);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandRuntimeFrameLayout", "onViewRemoved %s", new Object[] { paramView });
    AppMethodBeat.o(135393);
  }
  
  public final void removeAllViews()
  {
    AppMethodBeat.i(135394);
    com.tencent.mm.sdk.platformtools.Log.d("Luggage.WXA.AppBrandRuntimeFrameLayout", "removeAllViews stack = %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    super.removeAllViews();
    AppMethodBeat.o(135394);
  }
  
  public final void setRoundCornerProvider(a parama)
  {
    this.olc.ole = parama;
  }
  
  public static abstract interface a
  {
    public abstract float[] bOp();
  }
  
  final class b
  {
    Path lR;
    public c.a ole;
    RectF olf;
    Rect rect;
    
    public b()
    {
      AppMethodBeat.i(219612);
      this.ole = null;
      this.rect = new Rect();
      this.olf = new RectF();
      this.lR = new Path();
      AppMethodBeat.o(219612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c
 * JD-Core Version:    0.7.0.1
 */