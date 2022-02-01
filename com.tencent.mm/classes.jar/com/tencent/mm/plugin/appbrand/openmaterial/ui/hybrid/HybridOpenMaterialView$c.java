package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.graphics.Point;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;

final class HybridOpenMaterialView$c
{
  public final int qoA;
  public final Size qoz;
  
  public HybridOpenMaterialView$c(Context paramContext)
  {
    AppMethodBeat.i(272391);
    Point localPoint = ax.au(paramContext);
    this.qoz = new Size(localPoint.x, localPoint.y);
    this.qoA = ax.aB(paramContext);
    Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "ScreenInfo#<init>, navigationBarHeight: " + this.qoA);
    AppMethodBeat.o(272391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.c
 * JD-Core Version:    0.7.0.1
 */