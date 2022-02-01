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

public final class byw
  extends c
{
  private final int height = 8;
  private final int width = 10;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 10;
      return 8;
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
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -1.0F, 0.0F, 1.0F, -2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(2.267767F, 2.889087F);
      ((Path)localObject2).cubicTo(3.244078F, 1.912777F, 4.82699F, 1.912777F, 5.803301F, 2.889087F);
      ((Path)localObject2).cubicTo(5.894704F, 2.980491F, 6.012555F, 3.094171F, 6.156854F, 3.230127F);
      ((Path)localObject2).cubicTo(6.301153F, 3.094171F, 6.419004F, 2.980491F, 6.510407F, 2.889087F);
      ((Path)localObject2).cubicTo(7.486718F, 1.912777F, 9.069631F, 1.912777F, 10.045941F, 2.889087F);
      ((Path)localObject2).cubicTo(11.01317F, 3.856316F, 11.022168F, 5.418914F, 10.072933F, 6.39722F);
      ((Path)localObject2).lineTo(6.863924F, 9.606565F);
      ((Path)localObject2).cubicTo(6.473457F, 9.997147F, 5.840292F, 9.99718F, 5.449748F, 9.606676F);
      ((Path)localObject2).cubicTo(5.449735F, 9.606664F, 5.449723F, 9.606651F, 5.449748F, 9.606602F);
      ((Path)localObject2).lineTo(2.240571F, 6.397425F);
      ((Path)localObject2).lineTo(2.240571F, 6.397425F);
      ((Path)localObject2).cubicTo(1.291541F, 5.418914F, 1.300538F, 3.856316F, 2.267767F, 2.889087F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.byw
 * JD-Core Version:    0.7.0.1
 */