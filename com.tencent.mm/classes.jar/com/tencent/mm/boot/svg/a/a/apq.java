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

public final class apq
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(33.808594F, 24.5625F);
      ((Path)localObject).cubicTo(28.710938F, 24.5625F, 25.40625F, 28.886719F, 25.40625F, 35.53125F);
      ((Path)localObject).cubicTo(25.40625F, 42.140625F, 28.675781F, 46.429688F, 33.773438F, 46.429688F);
      ((Path)localObject).cubicTo(38.976563F, 46.429688F, 42.316406F, 42.070313F, 42.316406F, 35.355469F);
      ((Path)localObject).cubicTo(42.316406F, 28.746094F, 39.046875F, 24.5625F, 33.808594F, 24.5625F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.933594F, 6.0F);
      ((Path)localObject).cubicTo(50.339474F, 6.0F, 63.058594F, 16.582031F, 63.058594F, 32.15625F);
      ((Path)localObject).cubicTo(63.058594F, 43.335938F, 58.417969F, 50.507813F, 50.683594F, 50.507813F);
      ((Path)localObject).cubicTo(46.5F, 50.507813F, 43.195313F, 47.976563F, 42.667969F, 44.039063F);
      ((Path)localObject).lineTo(42.421875F, 44.039063F);
      ((Path)localObject).cubicTo(40.839844F, 48.046875F, 37.570313F, 50.261719F, 33.210938F, 50.261719F);
      ((Path)localObject).cubicTo(25.96875F, 50.261719F, 21.046875F, 44.285156F, 21.046875F, 35.425781F);
      ((Path)localObject).cubicTo(21.046875F, 26.777344F, 26.039063F, 20.800781F, 33.210938F, 20.800781F);
      ((Path)localObject).cubicTo(37.289063F, 20.800781F, 40.839844F, 23.015625F, 42.140625F, 26.460938F);
      ((Path)localObject).lineTo(42.386719F, 26.460938F);
      ((Path)localObject).lineTo(42.386719F, 21.503906F);
      ((Path)localObject).lineTo(46.464844F, 21.503906F);
      ((Path)localObject).lineTo(46.464844F, 41.613281F);
      ((Path)localObject).cubicTo(46.464844F, 44.8125F, 48.152344F, 46.921875F, 51.351563F, 46.921875F);
      ((Path)localObject).cubicTo(56.027344F, 46.921875F, 59.226563F, 41.542969F, 59.226563F, 32.085938F);
      ((Path)localObject).cubicTo(59.226563F, 18.65625F, 48.714588F, 9.527114F, 34.933594F, 9.527114F);
      ((Path)localObject).cubicTo(21.152599F, 9.527114F, 9.867188F, 19.576914F, 9.867188F, 35.320313F);
      ((Path)localObject).cubicTo(9.867188F, 49.944553F, 21.909554F, 61.089844F, 35.320313F, 61.089844F);
      ((Path)localObject).cubicTo(40.066406F, 61.089844F, 44.601563F, 60.492188F, 46.992188F, 59.542969F);
      ((Path)localObject).lineTo(46.992188F, 63.023438F);
      ((Path)localObject).cubicTo(44.144531F, 64.007813F, 39.996094F, 64.570313F, 35.285156F, 64.570313F);
      ((Path)localObject).cubicTo(18.593849F, 64.570313F, 6.0F, 51.976818F, 6.0F, 35.179688F);
      ((Path)localObject).cubicTo(6.0F, 18.382557F, 19.527716F, 6.0F, 34.933594F, 6.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.apq
 * JD-Core Version:    0.7.0.1
 */