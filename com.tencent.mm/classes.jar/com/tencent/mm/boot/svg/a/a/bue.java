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

public final class bue
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localPaint1.setColor(-436207616);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 8.333333F, 0.0F, 1.0F, 4.166667F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(9.791667F, 9.375F);
      ((Path)localObject2).lineTo(9.791667F, 21.875F);
      ((Path)localObject2).cubicTo(9.791667F, 25.671957F, 12.869709F, 28.75F, 16.666666F, 28.75F);
      ((Path)localObject2).cubicTo(20.463625F, 28.75F, 23.541666F, 25.671957F, 23.541666F, 21.875F);
      ((Path)localObject2).lineTo(23.541666F, 9.375F);
      ((Path)localObject2).cubicTo(23.541666F, 5.578043F, 20.463625F, 2.5F, 16.666666F, 2.5F);
      ((Path)localObject2).cubicTo(12.869709F, 2.5F, 9.791667F, 5.578043F, 9.791667F, 9.375F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.541667F, 18.75F);
      ((Path)localObject2).lineTo(3.541667F, 21.875F);
      ((Path)localObject2).cubicTo(3.541667F, 29.123737F, 9.41793F, 35.0F, 16.666666F, 35.0F);
      ((Path)localObject2).cubicTo(23.915403F, 35.0F, 29.791666F, 29.123737F, 29.791666F, 21.875F);
      ((Path)localObject2).lineTo(29.791666F, 18.75F);
      ((Path)localObject2).lineTo(32.291668F, 18.75F);
      ((Path)localObject2).lineTo(32.291668F, 21.875F);
      ((Path)localObject2).cubicTo(32.291668F, 30.083839F, 25.961439F, 36.814175F, 17.916229F, 37.450764F);
      ((Path)localObject2).lineTo(17.916666F, 43.75F);
      ((Path)localObject2).lineTo(15.416666F, 43.75F);
      ((Path)localObject2).lineTo(15.416106F, 37.450684F);
      ((Path)localObject2).cubicTo(7.371371F, 36.813618F, 1.041667F, 30.0835F, 1.041667F, 21.875F);
      ((Path)localObject2).lineTo(1.041667F, 18.75F);
      ((Path)localObject2).lineTo(3.541667F, 18.75F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.666666F, 0.0F);
      ((Path)localObject2).cubicTo(21.844336F, 0.0F, 26.041666F, 4.197331F, 26.041666F, 9.375F);
      ((Path)localObject2).lineTo(26.041666F, 21.875F);
      ((Path)localObject2).cubicTo(26.041666F, 27.05267F, 21.844336F, 31.25F, 16.666666F, 31.25F);
      ((Path)localObject2).cubicTo(11.488997F, 31.25F, 7.291667F, 27.05267F, 7.291667F, 21.875F);
      ((Path)localObject2).lineTo(7.291667F, 9.375F);
      ((Path)localObject2).cubicTo(7.291667F, 4.197331F, 11.488997F, 0.0F, 16.666666F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bue
 * JD-Core Version:    0.7.0.1
 */