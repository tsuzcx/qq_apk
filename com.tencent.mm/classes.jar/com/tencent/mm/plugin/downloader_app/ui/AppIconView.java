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
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.e.b;

public class AppIconView
  extends AppCompatImageView
{
  private static final PorterDuffXfermode xtz;
  private RectF avO;
  private Bitmap bitmap;
  private Rect rect;
  private Bitmap xty;
  
  static
  {
    AppMethodBeat.i(8969);
    xtz = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    AppMethodBeat.o(8969);
  }
  
  public AppIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(8966);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(-1);
    if (this.rect == null) {
      this.rect = new Rect(0, 0, getWidth(), getHeight());
    }
    if (this.avO == null) {
      this.avO = new RectF(this.rect);
    }
    if ((this.bitmap != null) && (this.xty != null)) {
      if (Build.VERSION.SDK_INT < 21) {
        break label210;
      }
    }
    label210:
    for (int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null);; i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31))
    {
      paramCanvas.drawBitmap(this.xty, this.rect, this.rect, localPaint);
      localPaint.setXfermode(xtz);
      paramCanvas.drawBitmap(this.bitmap, null, this.rect, localPaint);
      paramCanvas.restoreToCount(i);
      localPaint.setXfermode(null);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setColor(getResources().getColor(e.b.xpE));
      paramCanvas.drawRoundRect(this.avO, 32.0F, 32.0F, localPaint);
      AppMethodBeat.o(8966);
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(8967);
    this.avO = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    this.rect = new Rect(0, 0, paramInt1, paramInt2);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(1);
    localPaint.setColor(getResources().getColor(e.b.xpD));
    localCanvas.drawRoundRect(this.avO, 32.0F, 32.0F, localPaint);
    this.xty = localBitmap;
    AppMethodBeat.o(8967);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(8968);
    this.bitmap = paramBitmap;
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(8968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.AppIconView
 * JD-Core Version:    0.7.0.1
 */