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

public final class awh
  extends c
{
  private final int height = 45;
  private final int width = 45;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 45;
      return 45;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-9312);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 1.0F);
      ((Path)localObject2).lineTo(3.0F, 1.0F);
      ((Path)localObject2).lineTo(3.0F, 34.0F);
      ((Path)localObject2).lineTo(0.0F, 34.0F);
      ((Path)localObject2).lineTo(0.0F, 1.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 12.0F);
      ((Path)localObject2).lineTo(3.0F, 12.0F);
      ((Path)localObject2).lineTo(3.0F, 16.0F);
      ((Path)localObject2).lineTo(0.0F, 16.0F);
      ((Path)localObject2).lineTo(0.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 20.0F);
      ((Path)localObject2).lineTo(3.0F, 20.0F);
      ((Path)localObject2).lineTo(3.0F, 24.0F);
      ((Path)localObject2).lineTo(0.0F, 24.0F);
      ((Path)localObject2).lineTo(0.0F, 20.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 1.0F);
      ((Path)localObject2).lineTo(39.0F, 1.0F);
      ((Path)localObject2).lineTo(39.0F, 34.0F);
      ((Path)localObject2).lineTo(36.0F, 34.0F);
      ((Path)localObject2).lineTo(36.0F, 1.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 20.0F);
      ((Path)localObject2).lineTo(39.0F, 20.0F);
      ((Path)localObject2).lineTo(39.0F, 24.0F);
      ((Path)localObject2).lineTo(36.0F, 24.0F);
      ((Path)localObject2).lineTo(36.0F, 20.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 12.0F);
      ((Path)localObject2).lineTo(39.0F, 12.0F);
      ((Path)localObject2).lineTo(39.0F, 16.0F);
      ((Path)localObject2).lineTo(36.0F, 16.0F);
      ((Path)localObject2).lineTo(36.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.0F, 29.5F);
      ((Path)localObject2).cubicTo(16.461456F, 29.5F, 13.079865F, 34.0F, 10.5F, 34.0F);
      ((Path)localObject2).cubicTo(10.5F, 34.0F, 23.911882F, 34.0F, 25.5F, 34.0F);
      ((Path)localObject2).cubicTo(25.5F, 34.0F, 20.594971F, 29.5F, 18.0F, 29.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.400916F, 5.933368F);
      ((Path)localObject2).cubicTo(13.413912F, 8.198693F, 15.042143F, 9.521335F, 16.935621F, 11.160607F);
      ((Path)localObject2).cubicTo(18.481054F, 12.498559F, 18.704428F, 13.840594F, 18.704428F, 13.840594F);
      ((Path)localObject2).cubicTo(18.704428F, 13.840594F, 22.41539F, 9.37187F, 24.088566F, 8.198693F);
      ((Path)localObject2).cubicTo(25.761744F, 7.025516F, 26.796274F, 2.669922F, 26.796274F, 2.669922F);
      ((Path)localObject2).cubicTo(26.796274F, 2.669922F, 23.044596F, 5.933368F, 19.713867F, 5.933368F);
      ((Path)localObject2).cubicTo(16.383139F, 5.933368F, 16.935621F, 6.775316F, 12.400916F, 5.933368F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-9312);
      ((Paint)localObject1).setStrokeWidth(3.0F);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(7.531052F, 0.8899055F);
      ((Path)localObject2).cubicTo(7.5F, 10.796076F, 9.671387F, 9.194105F, 15.0F, 15.2649F);
      ((Path)localObject2).cubicTo(17.19315F, 17.659187F, 16.830078F, 19.011608F, 15.0F, 21.053797F);
      ((Path)localObject2).cubicTo(12.047792F, 24.348173F, 7.5F, 24.034626F, 7.5F, 34.089428F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-9312);
      localPaint.setStrokeWidth(3.0F);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(29.968988F, 1.0F);
      ((Path)localObject1).cubicTo(30.0F, 10.90617F, 27.83145F, 9.304199F, 22.509796F, 15.374994F);
      ((Path)localObject1).cubicTo(20.31951F, 17.769281F, 20.682108F, 19.121702F, 22.509796F, 21.163891F);
      ((Path)localObject1).cubicTo(25.458147F, 24.458267F, 30.0F, 24.14472F, 30.0F, 34.199524F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.awh
 * JD-Core Version:    0.7.0.1
 */