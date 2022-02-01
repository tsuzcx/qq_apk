package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends ae
{
  private final LinearLayoutManager lJG;
  private final int lJH;
  private final int lJI;
  
  public o(Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
    AppMethodBeat.i(49269);
    this.lJG = paramLinearLayoutManager;
    this.lJH = 3000;
    this.lJI = Math.round(paramContext.getResources().getDisplayMetrics().heightPixels * 0.75F);
    AppMethodBeat.o(49269);
  }
  
  public final PointF bZ(int paramInt)
  {
    AppMethodBeat.i(49271);
    PointF localPointF = this.lJG.bZ(paramInt);
    AppMethodBeat.o(49271);
    return localPointF;
  }
  
  public final int ce(int paramInt)
  {
    AppMethodBeat.i(49270);
    paramInt = Math.min(this.lJH, paramInt);
    paramInt = super.ce(Math.max(this.lJI, paramInt));
    AppMethodBeat.o(49270);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o
 * JD-Core Version:    0.7.0.1
 */