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

public final class m
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -30.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(48.870228F, 11.038835F);
      ((Path)localObject2).lineTo(46.0F, 13.90906F);
      ((Path)localObject2).lineTo(47.16861F, 15.077669F);
      ((Path)localObject2).lineTo(50.038834F, 12.207443F);
      ((Path)localObject2).lineTo(52.909061F, 15.077669F);
      ((Path)localObject2).lineTo(54.077671F, 13.90906F);
      ((Path)localObject2).lineTo(51.207443F, 11.038835F);
      ((Path)localObject2).lineTo(54.077671F, 8.168609F);
      ((Path)localObject2).lineTo(52.909061F, 7.0F);
      ((Path)localObject2).lineTo(50.038834F, 9.870226F);
      ((Path)localObject2).lineTo(47.16861F, 7.0F);
      ((Path)localObject2).lineTo(46.0F, 8.168609F);
      ((Path)localObject2).lineTo(48.870228F, 11.038835F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(37.997028F, 7.0F);
      ((Path)localObject2).cubicTo(37.446384F, 7.0F, 37.0F, 7.453036F, 37.0F, 7.99703F);
      ((Path)localObject2).lineTo(37.0F, 14.00297F);
      ((Path)localObject2).cubicTo(37.0F, 14.553615F, 37.453037F, 15.0F, 37.997028F, 15.0F);
      ((Path)localObject2).lineTo(44.002972F, 15.0F);
      ((Path)localObject2).cubicTo(44.553616F, 15.0F, 45.0F, 14.546964F, 45.0F, 14.00297F);
      ((Path)localObject2).lineTo(45.0F, 7.99703F);
      ((Path)localObject2).cubicTo(45.0F, 7.446385F, 44.546963F, 7.0F, 44.002972F, 7.0F);
      ((Path)localObject2).lineTo(37.997028F, 7.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(37.997028F, 16.0F);
      ((Path)localObject2).cubicTo(37.446384F, 16.0F, 37.0F, 16.453035F, 37.0F, 16.99703F);
      ((Path)localObject2).lineTo(37.0F, 23.00297F);
      ((Path)localObject2).cubicTo(37.0F, 23.553614F, 37.453037F, 24.0F, 37.997028F, 24.0F);
      ((Path)localObject2).lineTo(44.002972F, 24.0F);
      ((Path)localObject2).cubicTo(44.553616F, 24.0F, 45.0F, 23.546965F, 45.0F, 23.00297F);
      ((Path)localObject2).lineTo(45.0F, 16.99703F);
      ((Path)localObject2).cubicTo(45.0F, 16.446386F, 44.546963F, 16.0F, 44.002972F, 16.0F);
      ((Path)localObject2).lineTo(37.997028F, 16.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(46.997028F, 16.0F);
      ((Path)localObject2).cubicTo(46.446384F, 16.0F, 46.0F, 16.453035F, 46.0F, 16.99703F);
      ((Path)localObject2).lineTo(46.0F, 23.00297F);
      ((Path)localObject2).cubicTo(46.0F, 23.553614F, 46.453037F, 24.0F, 46.997028F, 24.0F);
      ((Path)localObject2).lineTo(53.002972F, 24.0F);
      ((Path)localObject2).cubicTo(53.553616F, 24.0F, 54.0F, 23.546965F, 54.0F, 23.00297F);
      ((Path)localObject2).lineTo(54.0F, 16.99703F);
      ((Path)localObject2).cubicTo(54.0F, 16.446386F, 53.546963F, 16.0F, 53.002972F, 16.0F);
      ((Path)localObject2).lineTo(46.997028F, 16.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.m
 * JD-Core Version:    0.7.0.1
 */