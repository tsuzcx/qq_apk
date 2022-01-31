package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends ae
{
  private final LinearLayoutManager iVA;
  private final int iVB;
  private final int iVC;
  
  public p(Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
    AppMethodBeat.i(133541);
    this.iVA = paramLinearLayoutManager;
    this.iVB = 3000;
    this.iVC = Math.round(paramContext.getResources().getDisplayMetrics().heightPixels * 0.75F);
    AppMethodBeat.o(133541);
  }
  
  public final PointF bI(int paramInt)
  {
    AppMethodBeat.i(133543);
    PointF localPointF = this.iVA.bI(paramInt);
    AppMethodBeat.o(133543);
    return localPointF;
  }
  
  public final int bM(int paramInt)
  {
    AppMethodBeat.i(133542);
    paramInt = Math.min(this.iVB, paramInt);
    paramInt = super.bM(Math.max(this.iVC, paramInt));
    AppMethodBeat.o(133542);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.p
 * JD-Core Version:    0.7.0.1
 */