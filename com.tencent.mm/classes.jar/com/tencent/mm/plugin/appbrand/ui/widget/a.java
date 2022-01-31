package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.c;

public final class a
  implements b.f
{
  private final int hgL;
  private final int hgN;
  private final int hgO;
  
  public a(int paramInt1, int paramInt2)
  {
    this.hgL = paramInt1;
    this.hgN = paramInt2;
    this.hgO = -1;
  }
  
  public final String pU()
  {
    return "WxaNearbyShowcaseIcon";
  }
  
  public final Bitmap q(Bitmap paramBitmap)
  {
    Bitmap localBitmap = c.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, this.hgL, this.hgL, false);
    if (localBitmap != paramBitmap) {
      l.Fb().n(localBitmap);
    }
    localBitmap = Bitmap.createBitmap(this.hgL + this.hgN * 2, this.hgL + this.hgN * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, this.hgN, this.hgN, new Paint());
    l.Fb().n(paramBitmap);
    paramBitmap = new Paint();
    paramBitmap.setColor(this.hgO);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setStrokeWidth(this.hgN);
    localCanvas.drawCircle(this.hgL / 2 + this.hgN, this.hgL / 2 + this.hgN, this.hgL / 2, paramBitmap);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */