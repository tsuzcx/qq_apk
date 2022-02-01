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
  private final LinearLayoutManager mRi;
  private final int mRj;
  private final int mRk;
  
  public o(Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
    AppMethodBeat.i(49269);
    this.mRi = paramLinearLayoutManager;
    this.mRj = 3000;
    this.mRk = Math.round(paramContext.getResources().getDisplayMetrics().heightPixels * 0.75F);
    AppMethodBeat.o(49269);
  }
  
  public final PointF bZ(int paramInt)
  {
    AppMethodBeat.i(49271);
    PointF localPointF = this.mRi.bZ(paramInt);
    AppMethodBeat.o(49271);
    return localPointF;
  }
  
  public final int ce(int paramInt)
  {
    AppMethodBeat.i(49270);
    paramInt = Math.min(this.mRj, paramInt);
    paramInt = super.ce(Math.max(this.mRk, paramInt));
    AppMethodBeat.o(49270);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o
 * JD-Core Version:    0.7.0.1
 */