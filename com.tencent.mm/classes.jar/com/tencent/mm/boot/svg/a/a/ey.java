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

public final class ey
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-13882324);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -333.0F, 0.0F, 1.0F, -317.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 333.0F, 0.0F, 1.0F, 317.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(67.0F, 69.0F);
      ((Path)localObject2).lineTo(21.0F, 69.0F);
      ((Path)localObject2).lineTo(21.0F, 35.0F);
      ((Path)localObject2).lineTo(30.521F, 35.0F);
      ((Path)localObject2).cubicTo(31.823F, 32.063F, 33.368F, 29.768999F, 35.078999F, 28.0F);
      ((Path)localObject2).lineTo(17.0F, 28.0F);
      ((Path)localObject2).cubicTo(15.343F, 28.0F, 14.0F, 29.343F, 14.0F, 31.0F);
      ((Path)localObject2).lineTo(14.0F, 73.0F);
      ((Path)localObject2).cubicTo(14.0F, 74.656998F, 15.343F, 76.0F, 17.0F, 76.0F);
      ((Path)localObject2).lineTo(71.0F, 76.0F);
      ((Path)localObject2).cubicTo(72.655998F, 76.0F, 74.0F, 74.656998F, 74.0F, 73.0F);
      ((Path)localObject2).lineTo(74.0F, 51.220001F);
      ((Path)localObject2).lineTo(67.0F, 57.130001F);
      ((Path)localObject2).lineTo(67.0F, 69.0F);
      ((Path)localObject2).lineTo(67.0F, 69.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(59.0F, 17.0F);
      ((Path)localObject2).lineTo(59.0F, 28.018999F);
      ((Path)localObject2).cubicTo(57.325001F, 28.007999F, 55.583F, 28.0F, 54.0F, 28.0F);
      ((Path)localObject2).cubicTo(40.334F, 28.0F, 31.055F, 41.333F, 31.055F, 59.0F);
      ((Path)localObject2).cubicTo(35.721001F, 48.16F, 40.284F, 43.0F, 59.0F, 43.0F);
      ((Path)localObject2).lineTo(59.0F, 54.0F);
      ((Path)localObject2).lineTo(73.452003F, 41.848F);
      ((Path)localObject2).lineTo(74.0F, 42.356998F);
      ((Path)localObject2).lineTo(74.0F, 41.386002F);
      ((Path)localObject2).lineTo(81.0F, 35.5F);
      ((Path)localObject2).lineTo(59.0F, 17.0F);
      ((Path)localObject2).lineTo(59.0F, 17.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ey
 * JD-Core Version:    0.7.0.1
 */