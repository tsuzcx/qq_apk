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

public final class af
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 23.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(2.11F, 1.14F);
      ((Path)localObject3).cubicTo(21.75F, 0.82F, 41.419998F, 1.08F, 61.060001F, 1.0F);
      ((Path)localObject3).cubicTo(62.34F, 0.79F, 64.150002F, 1.37F, 63.950001F, 2.98F);
      ((Path)localObject3).cubicTo(64.040001F, 17.98F, 64.029999F, 33.0F, 63.950001F, 48.009998F);
      ((Path)localObject3).cubicTo(64.139999F, 49.599998F, 62.389999F, 50.209999F, 61.110001F, 49.990002F);
      ((Path)localObject3).cubicTo(41.73F, 49.98F, 22.35F, 50.07F, 2.97F, 49.950001F);
      ((Path)localObject3).cubicTo(1.37F, 50.150002F, 0.79F, 48.349998F, 1.0F, 47.09F);
      ((Path)localObject3).cubicTo(0.98F, 33.07F, 1.02F, 19.040001F, 0.99F, 5.01F);
      ((Path)localObject3).cubicTo(1.1F, 3.66F, 0.63F, 1.9F, 2.11F, 1.14F);
      ((Path)localObject3).lineTo(2.11F, 1.14F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(40.119999F, 8.16F);
      ((Path)localObject3).cubicTo(39.869999F, 8.41F, 39.380001F, 8.92F, 39.130001F, 9.18F);
      ((Path)localObject3).cubicTo(38.91F, 14.42F, 38.889999F, 19.700001F, 39.139999F, 24.950001F);
      ((Path)localObject3).cubicTo(39.400002F, 25.18F, 39.93F, 25.629999F, 40.200001F, 25.860001F);
      ((Path)localObject3).cubicTo(45.41F, 26.110001F, 50.669998F, 26.09F, 55.880001F, 25.870001F);
      ((Path)localObject3).cubicTo(56.130001F, 25.620001F, 56.610001F, 25.120001F, 56.849998F, 24.870001F);
      ((Path)localObject3).cubicTo(57.110001F, 19.639999F, 57.110001F, 14.35F, 56.849998F, 9.12F);
      ((Path)localObject3).cubicTo(56.610001F, 8.87F, 56.130001F, 8.39F, 55.889999F, 8.15F);
      ((Path)localObject3).cubicTo(50.650002F, 7.9F, 45.360001F, 7.88F, 40.119999F, 8.16F);
      ((Path)localObject3).lineTo(40.119999F, 8.16F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(7.15F, 27.139999F);
      ((Path)localObject3).cubicTo(7.13F, 27.809999F, 7.1F, 29.15F, 7.08F, 29.82F);
      ((Path)localObject3).cubicTo(16.02F, 30.110001F, 24.98F, 30.129999F, 33.91F, 29.809999F);
      ((Path)localObject3).cubicTo(33.889999F, 29.139999F, 33.860001F, 27.82F, 33.84F, 27.15F);
      ((Path)localObject3).cubicTo(24.950001F, 26.9F, 16.040001F, 26.91F, 7.15F, 27.139999F);
      ((Path)localObject3).lineTo(7.15F, 27.139999F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(7.1F, 37.16F);
      ((Path)localObject3).cubicTo(7.12F, 37.84F, 7.14F, 39.189999F, 7.15F, 39.869999F);
      ((Path)localObject3).cubicTo(16.059999F, 40.060001F, 24.99F, 40.139999F, 33.900002F, 39.82F);
      ((Path)localObject3).cubicTo(33.880001F, 39.150002F, 33.84F, 37.790001F, 33.82F, 37.119999F);
      ((Path)localObject3).cubicTo(24.92F, 36.939999F, 16.0F, 36.880001F, 7.1F, 37.16F);
      ((Path)localObject3).lineTo(7.1F, 37.16F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(42.299999F, 11.32F);
      ((Path)localObject2).cubicTo(46.009998F, 10.77F, 49.939999F, 10.79F, 53.66F, 11.31F);
      ((Path)localObject2).cubicTo(54.259998F, 15.03F, 54.200001F, 18.98F, 53.689999F, 22.719999F);
      ((Path)localObject2).cubicTo(49.93F, 23.17F, 46.009998F, 23.26F, 42.279999F, 22.68F);
      ((Path)localObject2).cubicTo(41.82F, 18.940001F, 41.77F, 15.04F, 42.299999F, 11.32F);
      ((Path)localObject2).lineTo(42.299999F, 11.32F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.af
 * JD-Core Version:    0.7.0.1
 */