package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.k;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a
  implements b.h
{
  private final int lPo;
  private final int lPq;
  private final int lPr;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.lPo = paramInt1;
    this.lPq = paramInt2;
    this.lPr = paramInt3;
  }
  
  public final Bitmap P(Bitmap paramBitmap)
  {
    AppMethodBeat.i(121083);
    Bitmap localBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, this.lPo, this.lPo, false);
    if (localBitmap != paramBitmap) {
      k.bvO().N(localBitmap);
    }
    localBitmap = Bitmap.createBitmap(this.lPo + this.lPq * 2, this.lPo + this.lPq * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, this.lPq, this.lPq, new Paint());
    k.bvO().N(paramBitmap);
    paramBitmap = new Paint();
    paramBitmap.setColor(this.lPr);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setStrokeWidth(this.lPq);
    localCanvas.drawCircle(this.lPo / 2 + this.lPq, this.lPo / 2 + this.lPq, this.lPo / 2, paramBitmap);
    AppMethodBeat.o(121083);
    return localBitmap;
  }
  
  public final String key()
  {
    return "WxaNearbyShowcaseIcon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */