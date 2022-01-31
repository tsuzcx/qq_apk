package com.tencent.mm.plugin.appbrand.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends FrameLayout
{
  private final com.tencent.mm.plugin.appbrand.o.a jal;
  public final Set<Runnable> jam;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(87440);
    this.jam = new HashSet();
    setWillNotDraw(false);
    this.jal = ((com.tencent.mm.plugin.appbrand.o.a)e.s(com.tencent.mm.plugin.appbrand.o.a.class));
    AppMethodBeat.o(87440);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(87441);
    if (willNotDraw())
    {
      AppMethodBeat.o(87441);
      return;
    }
    try
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(87441);
      return;
    }
    catch (Exception paramCanvas)
    {
      com.tencent.luggage.g.d.printErrStackTrace("Luggage.WXA.AppBrandRuntimeFrameLayout", paramCanvas, "", new Object[0]);
      if (!(paramCanvas instanceof NullPointerException)) {
        break label71;
      }
    }
    this.jal.idkeyStat(1088L, 0L, 1L, false);
    for (;;)
    {
      AppMethodBeat.o(87441);
      throw paramCanvas;
      label71:
      this.jal.idkeyStat(1088L, 1L, 1L, false);
    }
  }
  
  public final void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(141713);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    Object localObject;
    if ((isShown()) && (t.aw(this)) && (Build.VERSION.SDK_INT >= 26) && ((getWindowSystemUiVisibility() & 0x2) == 0))
    {
      localObject = com.tencent.mm.sdk.f.a.hr(getContext());
      if ((localObject != null) && (((Activity)localObject).getWindow() != null))
      {
        bool = aj.Ow(((Activity)localObject).getWindow().getNavigationBarColor());
        localObject = ((Activity)localObject).getWindow();
        if (bool) {
          break label93;
        }
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      af.d((Window)localObject, bool);
      AppMethodBeat.o(141713);
      return;
    }
  }
  
  protected final void onAnimationEnd()
  {
    AppMethodBeat.i(87442);
    super.onAnimationEnd();
    Iterator localIterator = this.jam.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.jam.clear();
    AppMethodBeat.o(87442);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(155596);
    super.onViewRemoved(paramView);
    com.tencent.luggage.g.d.i("Luggage.WXA.AppBrandRuntimeFrameLayout", "onViewRemoved %s", new Object[] { paramView });
    AppMethodBeat.o(155596);
  }
  
  public final void removeAllViews()
  {
    AppMethodBeat.i(141712);
    com.tencent.luggage.g.d.d("Luggage.WXA.AppBrandRuntimeFrameLayout", "removeAllViews stack = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
    super.removeAllViews();
    AppMethodBeat.o(141712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d
 * JD-Core Version:    0.7.0.1
 */