package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.h;

public final class a
  implements b.h
{
  private final int fXe;
  private final int fXg;
  private final int fXh;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.fXe = paramInt1;
    this.fXg = paramInt2;
    this.fXh = paramInt3;
  }
  
  public final String BN()
  {
    return "WxaNearbyShowcaseIcon";
  }
  
  public final Bitmap G(Bitmap paramBitmap)
  {
    AppMethodBeat.i(121083);
    Bitmap localBitmap = h.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, this.fXe, this.fXe, false);
    if (localBitmap != paramBitmap) {
      l.ayS().D(localBitmap);
    }
    localBitmap = Bitmap.createBitmap(this.fXe + this.fXg * 2, this.fXe + this.fXg * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, this.fXg, this.fXg, new Paint());
    l.ayS().D(paramBitmap);
    paramBitmap = new Paint();
    paramBitmap.setColor(this.fXh);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setStrokeWidth(this.fXg);
    localCanvas.drawCircle(this.fXe / 2 + this.fXg, this.fXe / 2 + this.fXg, this.fXe / 2, paramBitmap);
    AppMethodBeat.o(121083);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */