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

public final class aid
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617594);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 39.0F, 0.0F, 1.0F, 51.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(84.0F, 42.341831F);
      ((Path)localObject2).lineTo(84.0F, 6.0F);
      ((Path)localObject2).lineTo(6.0F, 6.0F);
      ((Path)localObject2).lineTo(6.0F, 40.335194F);
      ((Path)localObject2).lineTo(29.0F, 18.0F);
      ((Path)localObject2).lineTo(60.023453F, 46.799316F);
      ((Path)localObject2).lineTo(56.0F, 38.0F);
      ((Path)localObject2).lineTo(68.1287F, 27.990351F);
      ((Path)localObject2).lineTo(84.0F, 42.341831F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2.994461F, 0.0F);
      ((Path)localObject2).cubicTo(1.340666F, 0.0F, 0.0F, 1.348283F, 0.0F, 3.007385F);
      ((Path)localObject2).lineTo(0.0F, 62.992615F);
      ((Path)localObject2).cubicTo(0.0F, 64.653549F, 1.342096F, 66.0F, 2.994461F, 66.0F);
      ((Path)localObject2).lineTo(87.005539F, 66.0F);
      ((Path)localObject2).cubicTo(88.659332F, 66.0F, 90.0F, 64.651718F, 90.0F, 62.992615F);
      ((Path)localObject2).lineTo(90.0F, 3.007385F);
      ((Path)localObject2).cubicTo(90.0F, 1.346452F, 88.657906F, 0.0F, 87.005539F, 0.0F);
      ((Path)localObject2).lineTo(2.994461F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aid
 * JD-Core Version:    0.7.0.1
 */