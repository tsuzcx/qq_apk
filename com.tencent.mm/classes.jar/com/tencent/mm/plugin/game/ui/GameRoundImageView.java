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
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.b;

public class GameRoundImageView
  extends AppCompatImageView
{
  private static final PorterDuffXfermode une;
  private Bitmap bitmap;
  private Rect byG;
  private RectF byj;
  private Bitmap und;
  
  static
  {
    AppMethodBeat.i(42367);
    une = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
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
    if (this.byG == null) {
      this.byG = new Rect(0, 0, getWidth(), getHeight());
    }
    if (this.byj == null) {
      this.byj = new RectF(this.byG);
    }
    if ((this.bitmap != null) && (this.und != null))
    {
      int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
      paramCanvas.drawBitmap(this.und, this.byG, this.byG, localPaint);
      localPaint.setXfermode(une);
      paramCanvas.drawBitmap(this.bitmap, null, this.byG, localPaint);
      paramCanvas.restoreToCount(i);
      localPaint.setXfermode(null);
    }
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(1.0F);
    localPaint.setColor(getResources().getColor(g.b.CgA));
    paramCanvas.drawRoundRect(this.byj, 18.0F, 18.0F, localPaint);
    AppMethodBeat.o(42364);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42365);
    this.byj = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    this.byG = new Rect(0, 0, paramInt1, paramInt2);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-1);
    localCanvas.drawRoundRect(this.byj, 18.0F, 18.0F, localPaint);
    this.und = localBitmap;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRoundImageView
 * JD-Core Version:    0.7.0.1
 */