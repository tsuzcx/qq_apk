package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.f;

public final class a
  implements b.h
{
  private final int fye;
  private final int fyg;
  private final int fyh;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.fye = paramInt1;
    this.fyg = paramInt2;
    this.fyh = paramInt3;
  }
  
  public final String AL()
  {
    return "WxaNearbyShowcaseIcon";
  }
  
  public final Bitmap F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(121083);
    Bitmap localBitmap = f.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, this.fye, this.fye, false);
    if (localBitmap != paramBitmap) {
      l.aoZ().C(localBitmap);
    }
    localBitmap = Bitmap.createBitmap(this.fye + this.fyg * 2, this.fye + this.fyg * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, this.fyg, this.fyg, new Paint());
    l.aoZ().C(paramBitmap);
    paramBitmap = new Paint();
    paramBitmap.setColor(this.fyh);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setStrokeWidth(this.fyg);
    localCanvas.drawCircle(this.fye / 2 + this.fyg, this.fye / 2 + this.fyg, this.fye / 2, paramBitmap);
    AppMethodBeat.o(121083);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */