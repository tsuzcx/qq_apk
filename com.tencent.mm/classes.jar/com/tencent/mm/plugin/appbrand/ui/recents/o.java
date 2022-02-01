package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends p
{
  private final LinearLayoutManager rfX;
  private final int rfY;
  private final int rfZ;
  
  public o(Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
    AppMethodBeat.i(276428);
    this.rfX = paramLinearLayoutManager;
    this.rfY = 3000;
    this.rfZ = Math.round(paramContext.getResources().getDisplayMetrics().heightPixels * 0.75F);
    AppMethodBeat.o(276428);
  }
  
  public final PointF cB(int paramInt)
  {
    AppMethodBeat.i(49271);
    PointF localPointF = this.rfX.cB(paramInt);
    AppMethodBeat.o(49271);
    return localPointF;
  }
  
  public final int cF(int paramInt)
  {
    AppMethodBeat.i(49270);
    paramInt = Math.min(this.rfY, paramInt);
    paramInt = super.cF(Math.max(this.rfZ, paramInt));
    AppMethodBeat.o(49270);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o
 * JD-Core Version:    0.7.0.1
 */