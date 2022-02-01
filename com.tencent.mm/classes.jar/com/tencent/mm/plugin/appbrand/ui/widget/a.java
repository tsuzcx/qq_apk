package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.g;

public final class a
  implements b.h
{
  private final int fUY;
  private final int fVa;
  private final int fVb;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.fUY = paramInt1;
    this.fVa = paramInt2;
    this.fVb = paramInt3;
  }
  
  public final String BM()
  {
    return "WxaNearbyShowcaseIcon";
  }
  
  public final Bitmap F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(121083);
    Bitmap localBitmap = g.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, this.fUY, this.fUY, false);
    if (localBitmap != paramBitmap) {
      l.ayD().C(localBitmap);
    }
    localBitmap = Bitmap.createBitmap(this.fUY + this.fVa * 2, this.fUY + this.fVa * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, this.fVa, this.fVa, new Paint());
    l.ayD().C(paramBitmap);
    paramBitmap = new Paint();
    paramBitmap.setColor(this.fVb);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setStrokeWidth(this.fVa);
    localCanvas.drawCircle(this.fUY / 2 + this.fVa, this.fUY / 2 + this.fVa, this.fUY / 2, paramBitmap);
    AppMethodBeat.o(121083);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */