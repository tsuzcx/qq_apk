package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;

public final class a
  implements b.f
{
  private final int eln;
  private final int elp;
  private final int elq;
  
  public a(int paramInt1, int paramInt2)
  {
    this.eln = paramInt1;
    this.elp = paramInt2;
    this.elq = -1;
  }
  
  public final String tX()
  {
    return "WxaNearbyShowcaseIcon";
  }
  
  public final Bitmap x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93769);
    Bitmap localBitmap = d.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, this.eln, this.eln, false);
    if (localBitmap != paramBitmap) {
      l.XQ().u(localBitmap);
    }
    localBitmap = Bitmap.createBitmap(this.eln + this.elp * 2, this.eln + this.elp * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, this.elp, this.elp, new Paint());
    l.XQ().u(paramBitmap);
    paramBitmap = new Paint();
    paramBitmap.setColor(this.elq);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setStrokeWidth(this.elp);
    localCanvas.drawCircle(this.eln / 2 + this.elp, this.eln / 2 + this.elp, this.eln / 2, paramBitmap);
    AppMethodBeat.o(93769);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */