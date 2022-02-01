package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends FrameLayout
{
  private final a mXX;
  private final Set<Runnable> mer;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135389);
    this.mer = new HashSet();
    setWillNotDraw(false);
    this.mXX = ((a)e.M(a.class));
    AppMethodBeat.o(135389);
  }
  
  public final void Y(final Runnable paramRunnable)
  {
    AppMethodBeat.i(135391);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(135391);
      return;
    }
    if (!ag.Ck())
    {
      h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135388);
          d.this.Y(paramRunnable);
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
    this.mer.add(paramRunnable);
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
      ae.printErrStackTrace("Luggage.WXA.AppBrandRuntimeFrameLayout", paramCanvas, "", new Object[0]);
      if (!(paramCanvas instanceof NullPointerException)) {
        break label71;
      }
    }
    this.mXX.idkeyStat(1088L, 0L, 1L, false);
    for (;;)
    {
      AppMethodBeat.o(135390);
      throw paramCanvas;
      label71:
      this.mXX.idkeyStat(1088L, 1L, 1L, false);
    }
  }
  
  protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(208007);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(208007);
    return localLayoutParams;
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(135392);
    super.onAnimationEnd();
    Iterator localIterator = this.mer.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.mer.clear();
    AppMethodBeat.o(135392);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(135393);
    super.onViewRemoved(paramView);
    ae.i("Luggage.WXA.AppBrandRuntimeFrameLayout", "onViewRemoved %s", new Object[] { paramView });
    AppMethodBeat.o(135393);
  }
  
  public final void removeAllViews()
  {
    AppMethodBeat.i(135394);
    ae.d("Luggage.WXA.AppBrandRuntimeFrameLayout", "removeAllViews stack = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
    super.removeAllViews();
    AppMethodBeat.o(135394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d
 * JD-Core Version:    0.7.0.1
 */