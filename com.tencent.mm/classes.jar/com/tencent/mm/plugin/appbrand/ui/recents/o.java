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
  private final LinearLayoutManager mlD;
  private final int mlE;
  private final int mlF;
  
  public o(Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
    AppMethodBeat.i(49269);
    this.mlD = paramLinearLayoutManager;
    this.mlE = 3000;
    this.mlF = Math.round(paramContext.getResources().getDisplayMetrics().heightPixels * 0.75F);
    AppMethodBeat.o(49269);
  }
  
  public final PointF bZ(int paramInt)
  {
    AppMethodBeat.i(49271);
    PointF localPointF = this.mlD.bZ(paramInt);
    AppMethodBeat.o(49271);
    return localPointF;
  }
  
  public final int ce(int paramInt)
  {
    AppMethodBeat.i(49270);
    paramInt = Math.min(this.mlE, paramInt);
    paramInt = super.ce(Math.max(this.mlF, paramInt));
    AppMethodBeat.o(49270);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o
 * JD-Core Version:    0.7.0.1
 */