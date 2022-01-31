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

public final class sn
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
      localPaint1.setColor(-12632257);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(35.220001F, 1.24F);
      ((Path)localObject2).cubicTo(37.07F, 0.38F, 38.779999F, 1.74F, 39.990002F, 3.02F);
      ((Path)localObject2).cubicTo(46.299999F, 9.37F, 52.639999F, 15.71F, 59.0F, 22.030001F);
      ((Path)localObject2).cubicTo(60.279999F, 23.24F, 61.630001F, 24.959999F, 60.75F, 26.809999F);
      ((Path)localObject2).cubicTo(59.450001F, 28.82F, 57.57F, 30.34F, 55.919998F, 32.029999F);
      ((Path)localObject2).cubicTo(46.93F, 41.02F, 37.93F, 50.0F, 28.969999F, 59.009998F);
      ((Path)localObject2).cubicTo(27.92F, 60.060001F, 26.73F, 61.169998F, 25.110001F, 60.970001F);
      ((Path)localObject2).cubicTo(18.370001F, 61.029999F, 11.64F, 61.029999F, 4.91F, 60.970001F);
      ((Path)localObject2).cubicTo(2.69F, 61.259998F, 0.76F, 59.27F, 1.03F, 57.080002F);
      ((Path)localObject2).cubicTo(0.97F, 50.360001F, 0.97F, 43.630001F, 1.03F, 36.91F);
      ((Path)localObject2).cubicTo(0.83F, 35.27F, 1.97F, 34.09F, 3.01F, 33.02F);
      ((Path)localObject2).cubicTo(12.02F, 24.049999F, 21.0F, 15.05F, 29.99F, 6.06F);
      ((Path)localObject2).cubicTo(31.690001F, 4.41F, 33.200001F, 2.52F, 35.220001F, 1.24F);
      ((Path)localObject2).lineTo(35.220001F, 1.24F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.190001F, 38.290001F);
      ((Path)localObject2).cubicTo(12.01F, 39.419998F, 10.56F, 45.34F, 13.77F, 48.25F);
      ((Path)localObject2).cubicTo(16.68F, 51.439999F, 22.610001F, 49.990002F, 23.709999F, 45.810001F);
      ((Path)localObject2).cubicTo(25.360001F, 41.43F, 20.559999F, 36.650002F, 16.190001F, 38.290001F);
      ((Path)localObject2).lineTo(16.190001F, 38.290001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sn
 * JD-Core Version:    0.7.0.1
 */