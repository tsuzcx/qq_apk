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

public final class bxt
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 0.7071068F, 0.7071068F, 0.29111F, -0.7071068F, 0.7071068F, 45.54594F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(26.0F, 0.5F);
      ((Path)localObject2).cubicTo(28.485281F, 0.5F, 30.5F, 2.514719F, 30.5F, 5.0F);
      ((Path)localObject2).cubicTo(30.5F, 7.339088F, 28.715336F, 9.261346F, 26.43338F, 9.479401F);
      ((Path)localObject2).lineTo(26.0F, 9.5F);
      ((Path)localObject2).lineTo(18.112997F, 9.5F);
      ((Path)localObject2).cubicTo(13.385933F, 9.5F, 9.5F, 13.500617F, 9.5F, 18.5F);
      ((Path)localObject2).cubicTo(9.5F, 23.320833F, 13.113322F, 27.212967F, 17.609884F, 27.484829F);
      ((Path)localObject2).lineTo(18.112997F, 27.5F);
      ((Path)localObject2).lineTo(26.0F, 27.5F);
      ((Path)localObject2).cubicTo(28.485281F, 27.5F, 30.5F, 29.514719F, 30.5F, 32.0F);
      ((Path)localObject2).cubicTo(30.5F, 34.339088F, 28.715336F, 36.261345F, 26.43338F, 36.479401F);
      ((Path)localObject2).lineTo(26.0F, 36.5F);
      ((Path)localObject2).lineTo(18.112997F, 36.5F);
      ((Path)localObject2).cubicTo(8.355846F, 36.5F, 0.5F, 28.412306F, 0.5F, 18.5F);
      ((Path)localObject2).cubicTo(0.5F, 8.812974F, 8.002819F, 0.868565F, 17.450754F, 0.512459F);
      ((Path)localObject2).lineTo(18.112997F, 0.5F);
      ((Path)localObject2).lineTo(26.0F, 0.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.887001F, 0.5F);
      ((Path)localObject2).cubicTo(55.644154F, 0.5F, 63.5F, 8.587694F, 63.5F, 18.5F);
      ((Path)localObject2).cubicTo(63.5F, 28.187027F, 55.997181F, 36.131435F, 46.549248F, 36.487541F);
      ((Path)localObject2).lineTo(45.887001F, 36.5F);
      ((Path)localObject2).lineTo(38.0F, 36.5F);
      ((Path)localObject2).cubicTo(35.514717F, 36.5F, 33.5F, 34.485283F, 33.5F, 32.0F);
      ((Path)localObject2).cubicTo(33.5F, 29.660912F, 35.284664F, 27.738653F, 37.56662F, 27.520599F);
      ((Path)localObject2).lineTo(38.0F, 27.5F);
      ((Path)localObject2).lineTo(45.887001F, 27.5F);
      ((Path)localObject2).cubicTo(50.614067F, 27.5F, 54.5F, 23.499382F, 54.5F, 18.5F);
      ((Path)localObject2).cubicTo(54.5F, 13.679167F, 50.886677F, 9.787032F, 46.390118F, 9.515172F);
      ((Path)localObject2).lineTo(45.887001F, 9.5F);
      ((Path)localObject2).lineTo(38.0F, 9.5F);
      ((Path)localObject2).cubicTo(35.514717F, 9.5F, 33.5F, 7.485282F, 33.5F, 5.0F);
      ((Path)localObject2).cubicTo(33.5F, 2.660912F, 35.284664F, 0.738654F, 37.56662F, 0.5205997F);
      ((Path)localObject2).lineTo(38.0F, 0.5F);
      ((Path)localObject2).lineTo(45.887001F, 0.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.5F, 14.0F);
      ((Path)localObject2).cubicTo(47.985283F, 14.0F, 50.0F, 16.014719F, 50.0F, 18.5F);
      ((Path)localObject2).cubicTo(50.0F, 20.839088F, 48.215336F, 22.761347F, 45.93338F, 22.979401F);
      ((Path)localObject2).lineTo(45.5F, 23.0F);
      ((Path)localObject2).lineTo(18.5F, 23.0F);
      ((Path)localObject2).cubicTo(16.014719F, 23.0F, 14.0F, 20.985281F, 14.0F, 18.5F);
      ((Path)localObject2).cubicTo(14.0F, 16.160912F, 15.784664F, 14.238654F, 18.06662F, 14.020599F);
      ((Path)localObject2).lineTo(18.5F, 14.0F);
      ((Path)localObject2).lineTo(45.5F, 14.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bxt
 * JD-Core Version:    0.7.0.1
 */