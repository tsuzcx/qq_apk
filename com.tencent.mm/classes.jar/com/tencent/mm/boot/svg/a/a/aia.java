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

public final class aia
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 44.0F, 0.0F, 1.0F, 46.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(22.687244F, 25.113926F);
      ((Path)localObject2).lineTo(22.687244F, 17.929688F);
      ((Path)localObject2).cubicTo(22.687244F, 8.027395F, 30.660164F, 0.0F, 40.500088F, 0.0F);
      ((Path)localObject2).cubicTo(50.337849F, 0.0F, 58.312931F, 8.029507F, 58.312931F, 17.929688F);
      ((Path)localObject2).lineTo(58.312931F, 25.113926F);
      ((Path)localObject2).cubicTo(58.312931F, 30.056797F, 55.683815F, 37.087967F, 52.44355F, 40.815125F);
      ((Path)localObject2).lineTo(50.540165F, 43.004528F);
      ((Path)localObject2).cubicTo(47.94651F, 45.987915F, 48.729496F, 49.782131F, 52.289478F, 51.47937F);
      ((Path)localObject2).lineTo(74.857246F, 62.238659F);
      ((Path)localObject2).cubicTo(77.525391F, 63.510708F, 80.02758F, 66.931969F, 80.443771F, 69.864159F);
      ((Path)localObject2).lineTo(80.963943F, 73.529015F);
      ((Path)localObject2).cubicTo(81.243225F, 75.496643F, 79.869606F, 77.091721F, 77.896118F, 76.99588F);
      ((Path)localObject2).lineTo(3.104057F, 76.99588F);
      ((Path)localObject2).cubicTo(1.130463F, 77.091721F, -0.2438498F, 75.502281F, 0.03622916F, 73.529015F);
      ((Path)localObject2).lineTo(0.5564086F, 69.864159F);
      ((Path)localObject2).cubicTo(0.9736183F, 66.924759F, 3.480438F, 63.507545F, 6.124969F, 62.246185F);
      ((Path)localObject2).lineTo(28.710699F, 51.473454F);
      ((Path)localObject2).cubicTo(32.27047F, 49.775547F, 33.055141F, 45.98354F, 30.460012F, 42.999973F);
      ((Path)localObject2).lineTo(28.556623F, 40.811687F);
      ((Path)localObject2).cubicTo(25.315056F, 37.084923F, 22.687244F, 30.056068F, 22.687244F, 25.113926F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aia
 * JD-Core Version:    0.7.0.1
 */