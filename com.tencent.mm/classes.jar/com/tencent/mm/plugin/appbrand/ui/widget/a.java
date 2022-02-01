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
  private final int jmq;
  private final int jms;
  private final int jmt;
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jmq = paramInt1;
    this.jms = paramInt2;
    this.jmt = paramInt3;
  }
  
  public final Bitmap H(Bitmap paramBitmap)
  {
    AppMethodBeat.i(121083);
    Bitmap localBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, this.jmq, this.jmq, false);
    if (localBitmap != paramBitmap) {
      l.baT().s(localBitmap);
    }
    localBitmap = Bitmap.createBitmap(this.jmq + this.jms * 2, this.jmq + this.jms * 2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap, this.jms, this.jms, new Paint());
    l.baT().s(paramBitmap);
    paramBitmap = new Paint();
    paramBitmap.setColor(this.jmt);
    paramBitmap.setAntiAlias(true);
    paramBitmap.setStyle(Paint.Style.STROKE);
    paramBitmap.setStrokeWidth(this.jms);
    localCanvas.drawCircle(this.jmq / 2 + this.jms, this.jmq / 2 + this.jms, this.jmq / 2, paramBitmap);
    AppMethodBeat.o(121083);
    return localBitmap;
  }
  
  public final String key()
  {
    return "WxaNearbyShowcaseIcon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */