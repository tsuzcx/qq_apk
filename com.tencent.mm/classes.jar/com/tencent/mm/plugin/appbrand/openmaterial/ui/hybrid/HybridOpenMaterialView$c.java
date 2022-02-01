package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.graphics.Point;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;

final class HybridOpenMaterialView$c
{
  public final int pvk;
  public final Size ttg;
  
  public HybridOpenMaterialView$c(Context paramContext)
  {
    AppMethodBeat.i(323702);
    Point localPoint = bf.bf(paramContext);
    this.ttg = new Size(localPoint.x, localPoint.y);
    this.pvk = bf.bk(paramContext);
    Log.i("MicroMsg.AppBrand.HybridOpenMaterialView", "ScreenInfo#<init>, navigationBarHeight: " + this.pvk);
    AppMethodBeat.o(323702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.HybridOpenMaterialView.c
 * JD-Core Version:    0.7.0.1
 */