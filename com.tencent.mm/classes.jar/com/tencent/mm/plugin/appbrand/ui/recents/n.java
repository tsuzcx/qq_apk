package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends o
{
  private final LinearLayoutManager unY;
  private final int unZ;
  private final int uoa;
  
  public n(Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
    AppMethodBeat.i(323078);
    this.unY = paramLinearLayoutManager;
    this.unZ = 3000;
    this.uoa = Math.round(paramContext.getResources().getDisplayMetrics().heightPixels * 0.75F);
    AppMethodBeat.o(323078);
  }
  
  public final PointF fM(int paramInt)
  {
    AppMethodBeat.i(49271);
    PointF localPointF = this.unY.fM(paramInt);
    AppMethodBeat.o(49271);
    return localPointF;
  }
  
  public final int fP(int paramInt)
  {
    AppMethodBeat.i(49270);
    paramInt = Math.min(this.unZ, paramInt);
    paramInt = super.fP(Math.max(this.uoa, paramInt));
    AppMethodBeat.o(49270);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.n
 * JD-Core Version:    0.7.0.1
 */