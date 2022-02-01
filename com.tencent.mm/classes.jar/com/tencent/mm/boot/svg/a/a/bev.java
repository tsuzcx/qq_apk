package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class bev
  extends c
{
  private final int height = 240;
  private final int width = 180;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 180;
      return 240;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint1 = c.a(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localPaint1.setStrokeWidth(4.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 44.0F, 0.0F, 1.0F, 63.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 4.996532F);
      ((Path)localObject2).cubicTo(0.0F, 3.341593F, 1.344991F, 2.0F, 2.996238F, 2.0F);
      ((Path)localObject2).lineTo(60.003761F, 2.0F);
      ((Path)localObject2).cubicTo(61.658539F, 2.0F, 63.0F, 3.337379F, 63.0F, 4.996532F);
      ((Path)localObject2).lineTo(63.0F, 49.003468F);
      ((Path)localObject2).cubicTo(63.0F, 50.658405F, 61.65501F, 52.0F, 60.003761F, 52.0F);
      ((Path)localObject2).lineTo(2.996238F, 52.0F);
      ((Path)localObject2).cubicTo(1.341462F, 52.0F, 0.0F, 50.662621F, 0.0F, 49.003468F);
      ((Path)localObject2).lineTo(0.0F, 4.996532F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(87.5F, 53.797123F);
      ((Path)localObject2).cubicTo(89.915451F, 54.568535F, 92.0F, 53.052441F, 92.0F, 50.732754F);
      ((Path)localObject2).lineTo(92.0F, 3.235053F);
      ((Path)localObject2).cubicTo(92.0F, 0.6385606F, 89.694824F, -0.4511346F, 87.5F, 0.1706852F);
      ((Path)localObject2).cubicTo(86.19809F, 1.306465F, 75.559074F, 11.176803F, 68.0F, 18.057119F);
      ((Path)localObject2).lineTo(68.0F, 35.728115F);
      ((Path)localObject2).cubicTo(75.743423F, 42.702545F, 86.619827F, 52.864586F, 87.5F, 53.797123F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bev
 * JD-Core Version:    0.7.0.1
 */