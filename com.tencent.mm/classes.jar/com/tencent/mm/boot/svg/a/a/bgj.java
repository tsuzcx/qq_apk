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

public final class bgj
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      localPaint1.setColor(-13421773);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 30.0F, 0.0F, 1.0F, 36.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 0.8660254F, -0.5F, 48.0F, 0.5F, 0.8660254F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(33.0F, 18.0F);
      ((Path)localObject2).cubicTo(33.0F, 9.715729F, 39.715729F, 3.0F, 48.0F, 3.0F);
      ((Path)localObject2).lineTo(48.0F, 3.0F);
      ((Path)localObject2).cubicTo(56.284271F, 3.0F, 63.0F, 9.715729F, 63.0F, 18.0F);
      ((Path)localObject2).lineTo(63.0F, 42.0F);
      ((Path)localObject2).cubicTo(63.0F, 50.284271F, 56.284271F, 57.0F, 48.0F, 57.0F);
      ((Path)localObject2).lineTo(48.0F, 57.0F);
      ((Path)localObject2).cubicTo(39.715729F, 57.0F, 33.0F, 50.284271F, 33.0F, 42.0F);
      ((Path)localObject2).lineTo(33.0F, 18.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(27.0F, 33.0F);
      ((Path)localObject2).lineTo(27.0F, 42.0F);
      ((Path)localObject2).cubicTo(27.0F, 53.59798F, 36.40202F, 63.0F, 48.0F, 63.0F);
      ((Path)localObject2).cubicTo(59.59798F, 63.0F, 69.0F, 53.59798F, 69.0F, 42.0F);
      ((Path)localObject2).lineTo(69.0F, 33.0F);
      ((Path)localObject2).lineTo(75.0F, 33.0F);
      ((Path)localObject2).lineTo(75.0F, 42.0F);
      ((Path)localObject2).cubicTo(75.0F, 56.91169F, 62.91169F, 69.0F, 48.0F, 69.0F);
      ((Path)localObject2).cubicTo(33.08831F, 69.0F, 21.0F, 56.91169F, 21.0F, 42.0F);
      ((Path)localObject2).lineTo(21.0F, 33.0F);
      ((Path)localObject2).lineTo(27.0F, 33.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(45.0F, 66.0F);
      ((Path)localObject2).lineTo(51.0F, 66.0F);
      ((Path)localObject2).lineTo(51.0F, 75.0F);
      ((Path)localObject2).lineTo(45.0F, 75.0F);
      ((Path)localObject2).lineTo(45.0F, 66.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(45.0F, 78.0F);
      ((Path)localObject1).lineTo(51.0F, 78.0F);
      ((Path)localObject1).lineTo(48.55106F, 83.685822F);
      ((Path)localObject1).cubicTo(48.419975F, 83.990166F, 48.066994F, 84.130615F, 47.762653F, 83.999535F);
      ((Path)localObject1).cubicTo(47.621841F, 83.938881F, 47.50959F, 83.82663F, 47.44894F, 83.685822F);
      ((Path)localObject1).lineTo(45.0F, 78.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bgj
 * JD-Core Version:    0.7.0.1
 */