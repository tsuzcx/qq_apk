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
  private final int fBL;
  private final int fBN;
  private final int fBO;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.fBL = paramInt1;
    this.fBN = paramInt2;
    this.fBO = paramInt3;
  }
  
  public final String Ap()
  {
    return "WxaNearbyShowcaseIcon";
  }
  
  public final Bitmap F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(121083);
    Bitmap localBitmap = f.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, this.fBL, this.fBL, false);
    if (localBitmap != paramBitmap) {
      l.avQ().C(localBitmap);
    }
    localBitmap = Bitmap.createBitmap(this.fBL + this.fBN * 2, this.fBL + this.fBN * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, this.fBN, this.fBN, new Paint());
    l.avQ().C(paramBitmap);
    paramBitmap = new Paint();
    paramBitmap.setColor(this.fBO);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setStrokeWidth(this.fBN);
    localCanvas.drawCircle(this.fBL / 2 + this.fBN, this.fBL / 2 + this.fBN, this.fBL / 2, paramBitmap);
    AppMethodBeat.o(121083);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */