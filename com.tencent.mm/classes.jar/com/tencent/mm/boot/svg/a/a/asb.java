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

public final class asb
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(0.9F, 0.0F);
      ((Path)localObject2).lineTo(34.099998F, 0.0F);
      ((Path)localObject2).cubicTo(33.860001F, 7.5F, 29.440001F, 14.06F, 24.1F, 19.0F);
      ((Path)localObject2).cubicTo(29.209999F, 23.709999F, 33.380001F, 29.870001F, 34.09F, 36.939999F);
      ((Path)localObject2).cubicTo(23.030001F, 37.049999F, 11.96F, 37.009998F, 0.9F, 36.970001F);
      ((Path)localObject2).cubicTo(1.62F, 29.889999F, 5.78F, 23.719999F, 10.9F, 19.01F);
      ((Path)localObject2).cubicTo(5.57F, 14.06F, 1.14F, 7.5F, 0.9F, 0.0F);
      ((Path)localObject2).lineTo(0.9F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.270001F, 6.01F);
      ((Path)localObject2).cubicTo(10.16F, 10.93F, 16.030001F, 13.56F, 16.48F, 19.02F);
      ((Path)localObject2).cubicTo(16.190001F, 24.120001F, 10.8F, 26.530001F, 8.87F, 30.950001F);
      ((Path)localObject2).cubicTo(14.62F, 31.030001F, 20.370001F, 31.030001F, 26.120001F, 30.940001F);
      ((Path)localObject2).cubicTo(24.200001F, 26.52F, 18.799999F, 24.110001F, 18.52F, 19.01F);
      ((Path)localObject2).cubicTo(18.99F, 13.55F, 24.84F, 10.93F, 26.73F, 6.01F);
      ((Path)localObject2).cubicTo(20.58F, 6.0F, 14.42F, 6.0F, 8.270001F, 6.01F);
      ((Path)localObject2).lineTo(8.270001F, 6.01F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.asb
 * JD-Core Version:    0.7.0.1
 */