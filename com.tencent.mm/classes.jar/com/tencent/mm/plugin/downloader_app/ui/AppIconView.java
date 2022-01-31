package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppIconView
  extends AppCompatImageView
{
  private static final PorterDuffXfermode lbM;
  private Bitmap bitmap;
  private RectF jrU;
  private Bitmap lbL;
  private Rect rect;
  
  static
  {
    AppMethodBeat.i(136208);
    lbM = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(136208);
  }
  
  public AppIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(136205);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(-1);
    if (this.rect == null) {
      this.rect = new Rect(0, 0, getWidth(), getHeight());
    }
    if (this.jrU == null) {
      this.jrU = new RectF(this.rect);
    }
    if ((this.bitmap != null) && (this.lbL != null)) {
      if (Build.VERSION.SDK_INT < 21) {
        break label207;
      }
    }
    label207:
    for (int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null);; i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31))
    {
      paramCanvas.drawBitmap(this.lbL, this.rect, this.rect, localPaint);
      localPaint.setXfermode(lbM);
      paramCanvas.drawBitmap(this.bitmap, null, this.rect, localPaint);
      paramCanvas.restoreToCount(i);
      localPaint.setXfermode(null);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setColor(getResources().getColor(2131689730));
      paramCanvas.drawRoundRect(this.jrU, 32.0F, 32.0F, localPaint);
      AppMethodBeat.o(136205);
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136206);
    this.jrU = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    this.rect = new Rect(0, 0, paramInt1, paramInt2);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setColor(getResources().getColor(2131689729));
    localCanvas.drawRoundRect(this.jrU, 32.0F, 32.0F, localPaint);
    this.lbL = localBitmap;
    AppMethodBeat.o(136206);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(136207);
    this.bitmap = paramBitmap;
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(136207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.AppIconView
 * JD-Core Version:    0.7.0.1
 */