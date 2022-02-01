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

public final class bhv
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(24.450001F, 1.72F);
      ((Path)localObject2).cubicTo(40.07F, -2.09F, 57.259998F, 8.51F, 60.970001F, 24.120001F);
      ((Path)localObject2).cubicTo(65.190002F, 38.860001F, 56.540001F, 55.720001F, 42.150002F, 60.919998F);
      ((Path)localObject2).cubicTo(28.52F, 66.5F, 11.52F, 60.560001F, 4.31F, 47.73F);
      ((Path)localObject2).cubicTo(-2.87F, 36.0F, -0.8F, 19.65F, 9.09F, 10.08F);
      ((Path)localObject2).cubicTo(13.27F, 5.9F, 18.67F, 2.96F, 24.450001F, 1.72F);
      ((Path)localObject2).lineTo(24.450001F, 1.72F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.17F, 17.07F);
      ((Path)localObject2).cubicTo(13.49F, 18.92F, 13.95F, 25.17F, 17.950001F, 26.360001F);
      ((Path)localObject2).cubicTo(21.459999F, 27.530001F, 24.610001F, 23.5F, 23.559999F, 20.23F);
      ((Path)localObject2).cubicTo(23.049999F, 17.48F, 19.709999F, 15.55F, 17.17F, 17.07F);
      ((Path)localObject2).lineTo(17.17F, 17.07F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.360001F, 17.280001F);
      ((Path)localObject2).cubicTo(38.200001F, 19.32F, 38.580002F, 24.76F, 42.09F, 26.209999F);
      ((Path)localObject2).cubicTo(45.34F, 27.700001F, 48.799999F, 24.25F, 48.240002F, 20.98F);
      ((Path)localObject2).cubicTo(48.139999F, 17.74F, 44.139999F, 15.22F, 41.360001F, 17.280001F);
      ((Path)localObject2).lineTo(41.360001F, 17.280001F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.9F, 36.580002F);
      ((Path)localObject2).cubicTo(12.04F, 40.990002F, 14.08F, 45.330002F, 17.620001F, 48.330002F);
      ((Path)localObject2).cubicTo(23.73F, 53.549999F, 32.939999F, 54.150002F, 40.169998F, 51.040001F);
      ((Path)localObject2).cubicTo(46.02F, 48.470001F, 49.669998F, 42.619999F, 51.09F, 36.57F);
      ((Path)localObject2).cubicTo(44.43F, 35.73F, 37.759998F, 34.82F, 31.030001F, 34.740002F);
      ((Path)localObject2).cubicTo(24.290001F, 34.82F, 17.59F, 35.73F, 10.9F, 36.580002F);
      ((Path)localObject2).lineTo(10.9F, 36.580002F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bhv
 * JD-Core Version:    0.7.0.1
 */