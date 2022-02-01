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

public final class nw
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(37.073338F, 3.6F);
      ((Path)localObject2).lineTo(22.926662F, 3.6F);
      ((Path)localObject2).lineTo(16.926662F, 12.6F);
      ((Path)localObject2).lineTo(3.6F, 12.6F);
      ((Path)localObject2).lineTo(3.6F, 44.400002F);
      ((Path)localObject2).lineTo(56.400002F, 44.400002F);
      ((Path)localObject2).lineTo(56.400002F, 12.6F);
      ((Path)localObject2).lineTo(43.073338F, 12.6F);
      ((Path)localObject2).lineTo(37.073338F, 3.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(38.197224F, 0.0F);
      ((Path)localObject2).cubicTo(38.698753F, 1.332268E-015F, 39.167103F, 0.2506517F, 39.445301F, 0.6679497F);
      ((Path)localObject2).lineTo(45.0F, 9.0F);
      ((Path)localObject2).lineTo(57.0F, 9.0F);
      ((Path)localObject2).cubicTo(58.656853F, 9.0F, 60.0F, 10.343145F, 60.0F, 12.0F);
      ((Path)localObject2).lineTo(60.0F, 45.0F);
      ((Path)localObject2).cubicTo(60.0F, 46.656853F, 58.656853F, 48.0F, 57.0F, 48.0F);
      ((Path)localObject2).lineTo(3.0F, 48.0F);
      ((Path)localObject2).cubicTo(1.343146F, 48.0F, 0.0F, 46.656853F, 0.0F, 45.0F);
      ((Path)localObject2).lineTo(0.0F, 12.0F);
      ((Path)localObject2).cubicTo(0.0F, 10.343145F, 1.343146F, 9.0F, 3.0F, 9.0F);
      ((Path)localObject2).lineTo(15.0F, 9.0F);
      ((Path)localObject2).lineTo(20.554701F, 0.6679497F);
      ((Path)localObject2).cubicTo(20.832899F, 0.2506517F, 21.301247F, 2.664535E-015F, 21.802776F, 2.664535E-015F);
      ((Path)localObject2).lineTo(38.197224F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 35.400002F);
      ((Path)localObject2).cubicTo(34.639191F, 35.400002F, 38.400002F, 31.639193F, 38.400002F, 27.0F);
      ((Path)localObject2).cubicTo(38.400002F, 22.360807F, 34.639191F, 18.6F, 30.0F, 18.6F);
      ((Path)localObject2).cubicTo(25.360807F, 18.6F, 21.6F, 22.360807F, 21.6F, 27.0F);
      ((Path)localObject2).cubicTo(21.6F, 31.639193F, 25.360807F, 35.400002F, 30.0F, 35.400002F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 39.0F);
      ((Path)localObject2).cubicTo(23.372583F, 39.0F, 18.0F, 33.627419F, 18.0F, 27.0F);
      ((Path)localObject2).cubicTo(18.0F, 20.372583F, 23.372583F, 15.0F, 30.0F, 15.0F);
      ((Path)localObject2).cubicTo(36.627419F, 15.0F, 42.0F, 20.372583F, 42.0F, 27.0F);
      ((Path)localObject2).cubicTo(42.0F, 33.627419F, 36.627419F, 39.0F, 30.0F, 39.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.nw
 * JD-Core Version:    0.7.0.1
 */