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
  private final LinearLayoutManager oel;
  private final int oem;
  private final int oen;
  
  public o(Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
    AppMethodBeat.i(49269);
    this.oel = paramLinearLayoutManager;
    this.oem = 3000;
    this.oen = Math.round(paramContext.getResources().getDisplayMetrics().heightPixels * 0.75F);
    AppMethodBeat.o(49269);
  }
  
  public final PointF bZ(int paramInt)
  {
    AppMethodBeat.i(49271);
    PointF localPointF = this.oel.bZ(paramInt);
    AppMethodBeat.o(49271);
    return localPointF;
  }
  
  public final int cd(int paramInt)
  {
    AppMethodBeat.i(49270);
    paramInt = Math.min(this.oem, paramInt);
    paramInt = super.cd(Math.max(this.oen, paramInt));
    AppMethodBeat.o(49270);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o
 * JD-Core Version:    0.7.0.1
 */