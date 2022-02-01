package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a
  implements b.h
{
  private final int gCk;
  private final int gCm;
  private final int gCn;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.gCk = paramInt1;
    this.gCm = paramInt2;
    this.gCn = paramInt3;
  }
  
  public final Bitmap J(Bitmap paramBitmap)
  {
    AppMethodBeat.i(121083);
    Bitmap localBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, this.gCk, this.gCk, false);
    if (localBitmap != paramBitmap) {
      l.aRY().x(localBitmap);
    }
    localBitmap = Bitmap.createBitmap(this.gCk + this.gCm * 2, this.gCk + this.gCm * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, this.gCm, this.gCm, new Paint());
    l.aRY().x(paramBitmap);
    paramBitmap = new Paint();
    paramBitmap.setColor(this.gCn);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setStrokeWidth(this.gCm);
    localCanvas.drawCircle(this.gCk / 2 + this.gCm, this.gCk / 2 + this.gCm, this.gCk / 2, paramBitmap);
    AppMethodBeat.o(121083);
    return localBitmap;
  }
  
  public final String Lb()
  {
    return "WxaNearbyShowcaseIcon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */