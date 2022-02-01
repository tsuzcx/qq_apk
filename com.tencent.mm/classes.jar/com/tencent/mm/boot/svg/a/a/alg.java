package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class alg
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(52.970562F, 22.029438F);
      ((Path)localObject).cubicTo(57.313709F, 26.372583F, 60.0F, 32.372581F, 60.0F, 39.0F);
      ((Path)localObject).cubicTo(60.0F, 52.254833F, 49.254833F, 63.0F, 36.0F, 63.0F);
      ((Path)localObject).cubicTo(22.745167F, 63.0F, 12.0F, 52.254833F, 12.0F, 39.0F);
      ((Path)localObject).cubicTo(12.0F, 25.745167F, 22.745167F, 15.0F, 36.0F, 15.0F);
      ((Path)localObject).lineTo(36.0F, 21.0F);
      ((Path)localObject).cubicTo(26.058874F, 21.0F, 18.0F, 29.058874F, 18.0F, 39.0F);
      ((Path)localObject).cubicTo(18.0F, 48.941124F, 26.058874F, 57.0F, 36.0F, 57.0F);
      ((Path)localObject).cubicTo(45.941124F, 57.0F, 54.0F, 48.941124F, 54.0F, 39.0F);
      ((Path)localObject).cubicTo(54.0F, 34.155792F, 52.085682F, 29.629839F, 48.727921F, 26.272078F);
      ((Path)localObject).lineTo(52.970562F, 22.029438F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(31.63806F, 15.395418F);
      ((Path)localObject).lineTo(26.485281F, 10.24264F);
      ((Path)localObject).lineTo(30.727922F, 6.0F);
      ((Path)localObject).lineTo(42.395184F, 17.667261F);
      ((Path)localObject).cubicTo(42.980972F, 18.253048F, 42.980972F, 19.202795F, 42.395184F, 19.788582F);
      ((Path)localObject).lineTo(30.727922F, 31.455845F);
      ((Path)localObject).lineTo(26.485281F, 27.213203F);
      ((Path)localObject).lineTo(32.322514F, 21.375973F);
      ((Path)localObject).cubicTo(24.145084F, 23.073561F, 18.0F, 30.319149F, 18.0F, 39.0F);
      ((Path)localObject).cubicTo(18.0F, 48.941124F, 26.058874F, 57.0F, 36.0F, 57.0F);
      ((Path)localObject).cubicTo(45.941124F, 57.0F, 54.0F, 48.941124F, 54.0F, 39.0F);
      ((Path)localObject).cubicTo(54.0F, 34.155792F, 52.085682F, 29.629839F, 48.727921F, 26.272078F);
      ((Path)localObject).lineTo(52.970562F, 22.029438F);
      ((Path)localObject).cubicTo(57.313709F, 26.372583F, 60.0F, 32.372581F, 60.0F, 39.0F);
      ((Path)localObject).cubicTo(60.0F, 52.254833F, 49.254833F, 63.0F, 36.0F, 63.0F);
      ((Path)localObject).cubicTo(22.745167F, 63.0F, 12.0F, 52.254833F, 12.0F, 39.0F);
      ((Path)localObject).cubicTo(12.0F, 27.234737F, 20.465796F, 17.446768F, 31.63806F, 15.395418F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.alg
 * JD-Core Version:    0.7.0.1
 */