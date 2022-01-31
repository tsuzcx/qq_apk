package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class sl
  extends c
{
  private final int height = 84;
  private final int width = 84;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 84;
      return 84;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-5460820);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(35.18F, 1.25F);
      ((Path)localObject2).cubicTo(37.029999F, 0.39F, 38.77F, 1.7F, 39.98F, 3.0F);
      ((Path)localObject2).cubicTo(46.580002F, 9.72F, 53.34F, 16.290001F, 59.91F, 23.030001F);
      ((Path)localObject2).cubicTo(61.610001F, 24.5F, 61.139999F, 27.15F, 59.490002F, 28.450001F);
      ((Path)localObject2).cubicTo(49.330002F, 38.639999F, 39.130001F, 48.779999F, 28.98F, 58.990002F);
      ((Path)localObject2).cubicTo(27.92F, 60.049999F, 26.719999F, 61.200001F, 25.07F, 60.98F);
      ((Path)localObject2).cubicTo(19.040001F, 61.07F, 13.0F, 60.939999F, 6.97F, 61.029999F);
      ((Path)localObject2).cubicTo(5.32F, 60.880001F, 3.3F, 61.34F, 2.04F, 59.98F);
      ((Path)localObject2).cubicTo(0.69F, 58.720001F, 1.09F, 56.700001F, 0.97F, 55.060001F);
      ((Path)localObject2).cubicTo(1.06F, 49.009998F, 0.93F, 42.950001F, 1.02F, 36.900002F);
      ((Path)localObject2).cubicTo(0.82F, 35.290001F, 1.94F, 34.09F, 2.99F, 33.049999F);
      ((Path)localObject2).cubicTo(12.19F, 23.879999F, 21.370001F, 14.69F, 30.540001F, 5.51F);
      ((Path)localObject2).cubicTo(32.040001F, 4.04F, 33.400002F, 2.39F, 35.18F, 1.25F);
      ((Path)localObject2).lineTo(35.18F, 1.25F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.16F, 38.299999F);
      ((Path)localObject2).cubicTo(12.0F, 39.439999F, 10.56F, 45.349998F, 13.77F, 48.240002F);
      ((Path)localObject2).cubicTo(16.690001F, 51.439999F, 22.639999F, 49.970001F, 23.719999F, 45.779999F);
      ((Path)localObject2).cubicTo(25.35F, 41.389999F, 20.52F, 36.639999F, 16.16F, 38.299999F);
      ((Path)localObject2).lineTo(16.16F, 38.299999F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sl
 * JD-Core Version:    0.7.0.1
 */