package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$2
  extends ae
{
  e$2(e parame, Context paramContext)
  {
    super(paramContext);
  }
  
  public final PointF bI(int paramInt)
  {
    AppMethodBeat.i(134390);
    PointF localPointF = ((LinearLayoutManager)this.jwd.jvQ.getLayoutManager()).bI(paramInt);
    AppMethodBeat.o(134390);
    return localPointF;
  }
  
  public final float c(DisplayMetrics paramDisplayMetrics)
  {
    return 40.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final int iA()
  {
    return -1;
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(134391);
    super.onStop();
    ab.i("ViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", new Object[] { Integer.valueOf(this.jwd.jvQ.getScrollState()) });
    if (this.jwd.jvQ.getScrollState() == 0) {
      this.jwd.aSk();
    }
    AppMethodBeat.o(134391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.e.2
 * JD-Core Version:    0.7.0.1
 */