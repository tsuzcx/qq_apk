package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CircularImageView
  extends ImageView
{
  private Paint paint;
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113727);
    this.paint = new Paint();
    AppMethodBeat.o(113727);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113728);
    Object localObject1 = getDrawable();
    if (localObject1 != null)
    {
      Object localObject2 = ((BitmapDrawable)localObject1).getBitmap();
      localObject1 = Bitmap.createBitmap(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
      Object localObject3 = new Canvas((Bitmap)localObject1);
      Rect localRect = new Rect(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      RectF localRectF = new RectF(localRect);
      this.paint.setAntiAlias(true);
      this.paint.setDither(true);
      this.paint.setFlags(1);
      ((Canvas)localObject3).setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      ((Canvas)localObject3).drawARGB(0, 0, 0, 0);
      ((Canvas)localObject3).drawRoundRect(localRectF, 20.0F, 20.0F, this.paint);
      this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject3).drawBitmap((Bitmap)localObject2, localRect, localRect, this.paint);
      localObject2 = new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      localObject3 = new Rect(0, 0, getWidth(), getHeight());
      this.paint.reset();
      paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, (Rect)localObject3, this.paint);
      paramCanvas.save();
      AppMethodBeat.o(113728);
      return;
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(113728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.CircularImageView
 * JD-Core Version:    0.7.0.1
 */