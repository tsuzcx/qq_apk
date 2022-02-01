package com.tencent.mm.plugin.game.ui;

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
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameRoundImageView
  extends AppCompatImageView
{
  private static final PorterDuffXfermode oMn;
  private Bitmap bitmap;
  private RectF fV;
  private Bitmap oMm;
  private Rect rect;
  
  static
  {
    AppMethodBeat.i(42367);
    oMn = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(42367);
  }
  
  public GameRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42364);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(-1);
    if (this.rect == null) {
      this.rect = new Rect(0, 0, getWidth(), getHeight());
    }
    if (this.fV == null) {
      this.fV = new RectF(this.rect);
    }
    if ((this.bitmap != null) && (this.oMm != null))
    {
      int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
      paramCanvas.drawBitmap(this.oMm, this.rect, this.rect, localPaint);
      localPaint.setXfermode(oMn);
      paramCanvas.drawBitmap(this.bitmap, null, this.rect, localPaint);
      paramCanvas.restoreToCount(i);
      localPaint.setXfermode(null);
    }
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(1.0F);
    localPaint.setColor(getResources().getColor(2131100409));
    paramCanvas.drawRoundRect(this.fV, 18.0F, 18.0F, localPaint);
    AppMethodBeat.o(42364);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42365);
    this.fV = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    this.rect = new Rect(0, 0, paramInt1, paramInt2);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-1);
    localCanvas.drawRoundRect(this.fV, 18.0F, 18.0F, localPaint);
    this.oMm = localBitmap;
    AppMethodBeat.o(42365);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(42366);
    this.bitmap = paramBitmap;
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(42366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRoundImageView
 * JD-Core Version:    0.7.0.1
 */