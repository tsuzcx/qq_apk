package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$1
  extends ae
{
  f$1(f paramf, Context paramContext)
  {
    super(paramContext);
  }
  
  public final PointF bI(int paramInt)
  {
    AppMethodBeat.i(14347);
    PointF localPointF = ((LinearLayoutManager)this.jZB.jZy.getLayoutManager()).bI(paramInt);
    AppMethodBeat.o(14347);
    return localPointF;
  }
  
  public final int bM(int paramInt)
  {
    AppMethodBeat.i(14346);
    paramInt = super.bM(paramInt);
    AppMethodBeat.o(14346);
    return paramInt;
  }
  
  public final float c(DisplayMetrics paramDisplayMetrics)
  {
    return 80.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final int iA()
  {
    return -1;
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(14348);
    super.onStop();
    AppMethodBeat.o(14348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.1
 * JD-Core Version:    0.7.0.1
 */