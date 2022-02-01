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
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.b;
import com.tencent.mm.plugin.ball.a.c;
import com.tencent.mm.plugin.gif.MMAnimateView;

public class CircleAnimateView
  extends MMAnimateView
{
  private int defaultHeight;
  private int defaultWidth;
  private long hQO;
  
  public CircleAnimateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106371);
    this.hQO = -2147483648L;
    fF(paramContext);
    AppMethodBeat.o(106371);
  }
  
  public CircleAnimateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106370);
    this.hQO = -2147483648L;
    fF(paramContext);
    AppMethodBeat.o(106370);
  }
  
  private void fF(Context paramContext)
  {
    AppMethodBeat.i(106372);
    this.defaultWidth = com.tencent.mm.cd.a.bs(paramContext, a.c.float_ball_default_icon_size);
    this.defaultHeight = com.tencent.mm.cd.a.bs(paramContext, a.c.float_ball_default_icon_size);
    AppMethodBeat.o(106372);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106373);
    int i;
    int j;
    label31:
    Bitmap localBitmap;
    Object localObject;
    if (getWidth() > 0)
    {
      i = getWidth();
      if (getWidth() <= 0) {
        break label445;
      }
      j = getWidth();
      localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(localBitmap);
      if (!localBitmap.isRecycled()) {
        break label570;
      }
      localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(localBitmap);
    }
    label284:
    label545:
    label570:
    for (;;)
    {
      super.draw((Canvas)localObject);
      label113:
      label126:
      Paint localPaint;
      if (this.hQO >= 0L)
      {
        if (getWidth() > 0)
        {
          i = getWidth();
          if (getWidth() <= 0) {
            break label495;
          }
          j = getWidth();
          float f1 = i / 2.0F;
          float f2 = j / 2.0F;
          float f3 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 1.5F);
          float f4 = i * 0.75F / 2.0F - f3;
          localPaint = new Paint();
          localPaint.setAntiAlias(true);
          localPaint.setStyle(Paint.Style.STROKE);
          localPaint.setStrokeWidth(f3);
          localPaint.setColor(androidx.core.content.a.w(getContext(), a.b.BW_0_Alpha_0_1));
          ((Canvas)localObject).drawCircle(f1, f2, f4, localPaint);
          localPaint.setColor(androidx.core.content.a.w(getContext(), a.b.wechat_green));
          ((Canvas)localObject).drawArc(f1 - f4, f2 - f4, f1 + f4, f2 + f4, -90.0F, (float)this.hQO / 100.0F * 360.0F, false, localPaint);
        }
      }
      else
      {
        if (getWidth() <= 0) {
          break label520;
        }
        i = getWidth();
        if (getWidth() <= 0) {
          break label545;
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
        AppMethodBeat.o(106373);
        return;
        if (getMeasuredWidth() > 0)
        {
          i = getMeasuredWidth();
          break;
        }
        i = this.defaultWidth;
        break;
        label445:
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
        label495:
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
          break label284;
        }
        i = this.defaultWidth;
        break label284;
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
    AppMethodBeat.i(176974);
    this.hQO = paramLong;
    postInvalidate();
    AppMethodBeat.o(176974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.CircleAnimateView
 * JD-Core Version:    0.7.0.1
 */