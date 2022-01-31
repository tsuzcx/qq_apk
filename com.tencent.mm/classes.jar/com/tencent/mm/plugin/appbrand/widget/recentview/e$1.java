package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  extends ae
{
  e$1(e parame, Context paramContext)
  {
    super(paramContext);
  }
  
  public final PointF bI(int paramInt)
  {
    AppMethodBeat.i(134388);
    PointF localPointF = ((LinearLayoutManager)this.jwd.jvQ.getLayoutManager()).bI(paramInt);
    AppMethodBeat.o(134388);
    return localPointF;
  }
  
  public final int bM(int paramInt)
  {
    AppMethodBeat.i(134387);
    paramInt = super.bM(paramInt);
    AppMethodBeat.o(134387);
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
    AppMethodBeat.i(134389);
    super.onStop();
    AppMethodBeat.o(134389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.e.1
 * JD-Core Version:    0.7.0.1
 */