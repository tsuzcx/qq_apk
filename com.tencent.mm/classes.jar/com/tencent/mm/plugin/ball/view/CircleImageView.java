package com.tencent.mm.plugin.ball.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.content.b;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class CircleImageView
  extends AppCompatImageView
{
  private int defaultHeight;
  private int defaultWidth;
  private long progress;
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106377);
    this.progress = -2147483648L;
    eH(paramContext);
    AppMethodBeat.o(106377);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106376);
    this.progress = -2147483648L;
    eH(paramContext);
    AppMethodBeat.o(106376);
  }
  
  private void eH(Context paramContext)
  {
    AppMethodBeat.i(106378);
    this.defaultWidth = a.aH(paramContext, 2131166458);
    this.defaultHeight = a.aH(paramContext, 2131166458);
    AppMethodBeat.o(106378);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106379);
    int i;
    int j;
    label31:
    Bitmap localBitmap;
    Object localObject;
    if (getWidth() > 0)
    {
      i = getWidth();
      if (getWidth() <= 0) {
        break label443;
      }
      j = getWidth();
      localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(localBitmap);
      if (!localBitmap.isRecycled()) {
        break label568;
      }
      localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(localBitmap);
    }
    label282:
    label543:
    label568:
    for (;;)
    {
      super.draw((Canvas)localObject);
      label113:
      label126:
      Paint localPaint;
      if (this.progress >= 0L)
      {
        if (getWidth() > 0)
        {
          i = getWidth();
          if (getWidth() <= 0) {
            break label493;
          }
          j = getWidth();
          float f1 = i / 2.0F;
          float f2 = j / 2.0F;
          float f3 = a.fromDPToPix(getContext(), 1.5F);
          float f4 = i * 0.7083333F / 2.0F - f3;
          localPaint = new Paint();
          localPaint.setAntiAlias(true);
          localPaint.setStyle(Paint.Style.STROKE);
          localPaint.setStrokeWidth(f3);
          localPaint.setColor(b.n(getContext(), 2131099657));
          ((Canvas)localObject).drawCircle(f1, f2, f4, localPaint);
          localPaint.setColor(b.n(getContext(), 2131101414));
          ((Canvas)localObject).drawArc(f1 - f4, f2 - f4, f1 + f4, f2 + f4, -90.0F, (float)this.progress / 100.0F * 360.0F, false, localPaint);
        }
      }
      else
      {
        if (getWidth() <= 0) {
          break label518;
        }
        i = getWidth();
        if (getWidth() <= 0) {
          break label543;
        }
        j = getWidth();
      }
      for (;;)
      {
        localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Path localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, i, j), i, j, Path.Direction.CW);
        localPath.setFillType(Path.FillType.INVERSE_WINDING);
        ((Canvas)localObject).drawPath(localPath, localPaint);
        localObject = new Paint();
        ((Paint)localObject).setXfermode(null);
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, (Paint)localObject);
        localBitmap.recycle();
        AppMethodBeat.o(106379);
        return;
        if (getMeasuredWidth() > 0)
        {
          i = getMeasuredWidth();
          break;
        }
        i = this.defaultWidth;
        break;
        label443:
        if (getMeasuredHeight() > 0)
        {
          j = getMeasuredHeight();
          break label31;
        }
        j = this.defaultHeight;
        break label31;
        if (getMeasuredWidth() > 0)
        {
          i = getMeasuredWidth();
          break label113;
        }
        i = this.defaultWidth;
        break label113;
        label493:
        if (getMeasuredHeight() > 0)
        {
          j = getMeasuredHeight();
          break label126;
        }
        j = this.defaultHeight;
        break label126;
        if (getMeasuredWidth() > 0)
        {
          i = getMeasuredWidth();
          break label282;
        }
        i = this.defaultWidth;
        break label282;
        if (getMeasuredHeight() > 0) {
          j = getMeasuredHeight();
        } else {
          j = this.defaultHeight;
        }
      }
    }
  }
  
  public void setProgress(long paramLong)
  {
    AppMethodBeat.i(176975);
    this.progress = paramLong;
    postInvalidate();
    AppMethodBeat.o(176975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.CircleImageView
 * JD-Core Version:    0.7.0.1
 */