package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class btz
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(5.333334F, 4.0F);
      ((Path)localObject).lineTo(26.666666F, 4.0F);
      ((Path)localObject).cubicTo(27.403046F, 4.0F, 28.0F, 4.596954F, 28.0F, 5.333334F);
      ((Path)localObject).lineTo(28.0F, 26.666666F);
      ((Path)localObject).cubicTo(28.0F, 27.403046F, 27.403046F, 28.0F, 26.666666F, 28.0F);
      ((Path)localObject).lineTo(5.333334F, 28.0F);
      ((Path)localObject).cubicTo(4.596954F, 28.0F, 4.0F, 27.403046F, 4.0F, 26.666666F);
      ((Path)localObject).lineTo(4.0F, 5.333334F);
      ((Path)localObject).cubicTo(4.0F, 4.596954F, 4.596954F, 4.0F, 5.333334F, 4.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.597333F, 11.797334F);
      ((Path)localObject).lineTo(9.597333F, 13.322667F);
      ((Path)localObject).lineTo(11.826667F, 13.322667F);
      ((Path)localObject).cubicTo(12.442667F, 15.449333F, 13.542666F, 17.312F, 15.126667F, 18.925333F);
      ((Path)localObject).cubicTo(13.601334F, 20.216F, 11.665334F, 21.154667F, 9.333333F, 21.756001F);
      ((Path)localObject).lineTo(10.154667F, 23.105333F);
      ((Path)localObject).cubicTo(12.545333F, 22.430666F, 14.569333F, 21.360001F, 16.212F, 19.908001F);
      ((Path)localObject).cubicTo(17.766666F, 21.198668F, 19.717333F, 22.284F, 22.063999F, 23.164F);
      ((Path)localObject).lineTo(22.914667F, 21.858667F);
      ((Path)localObject).cubicTo(20.685333F, 21.037333F, 18.808001F, 20.040001F, 17.297333F, 18.837334F);
      ((Path)localObject).cubicTo(18.646667F, 17.356001F, 19.673334F, 15.522667F, 20.377333F, 13.322667F);
      ((Path)localObject).lineTo(22.591999F, 13.322667F);
      ((Path)localObject).lineTo(22.591999F, 11.797334F);
      ((Path)localObject).lineTo(17.048F, 11.797334F);
      ((Path)localObject).cubicTo(16.608F, 10.844F, 16.124001F, 10.022667F, 15.596F, 9.333333F);
      ((Path)localObject).lineTo(14.056F, 9.890667F);
      ((Path)localObject).cubicTo(14.584F, 10.492F, 15.038667F, 11.122666F, 15.405334F, 11.797334F);
      ((Path)localObject).lineTo(9.597333F, 11.797334F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.293333F, 13.322667F);
      ((Path)localObject).lineTo(18.793333F, 13.322667F);
      ((Path)localObject).cubicTo(18.221333F, 15.097333F, 17.356001F, 16.622667F, 16.212F, 17.884001F);
      ((Path)localObject).cubicTo(14.862667F, 16.563999F, 13.894667F, 15.053333F, 13.293333F, 13.322667F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.btz
 * JD-Core Version:    0.7.0.1
 */