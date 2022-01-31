package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class f$2
  extends ae
{
  f$2(f paramf, Context paramContext)
  {
    super(paramContext);
  }
  
  public final PointF bI(int paramInt)
  {
    AppMethodBeat.i(14349);
    PointF localPointF = ((LinearLayoutManager)this.jZB.jZy.getLayoutManager()).bI(paramInt);
    AppMethodBeat.o(14349);
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
    AppMethodBeat.i(14350);
    super.onStop();
    ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", new Object[] { Integer.valueOf(this.jZB.jZy.getScrollState()) });
    if (this.jZB.jZy.getScrollState() == 0) {
      this.jZB.aSk();
    }
    AppMethodBeat.o(14350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.2
 * JD-Core Version:    0.7.0.1
 */