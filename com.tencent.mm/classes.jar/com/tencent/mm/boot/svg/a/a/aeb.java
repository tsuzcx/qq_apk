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

public final class aeb
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
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(31.322699F, 25.5F);
      ((Path)localObject).lineTo(38.61396F, 32.791264F);
      ((Path)localObject).lineTo(35.43198F, 35.973244F);
      ((Path)localObject).lineTo(25.88604F, 26.427301F);
      ((Path)localObject).lineTo(23.764719F, 24.305983F);
      ((Path)localObject).cubicTo(23.178932F, 23.720196F, 23.178932F, 22.770449F, 23.764719F, 22.184662F);
      ((Path)localObject).lineTo(35.43198F, 10.5174F);
      ((Path)localObject).lineTo(38.61396F, 13.69938F);
      ((Path)localObject).lineTo(31.313341F, 21.0F);
      ((Path)localObject).lineTo(45.0F, 21.0F);
      ((Path)localObject).cubicTo(54.941124F, 21.0F, 63.0F, 29.058874F, 63.0F, 39.0F);
      ((Path)localObject).cubicTo(63.0F, 48.941124F, 54.941124F, 57.0F, 45.0F, 57.0F);
      ((Path)localObject).lineTo(12.0F, 57.0F);
      ((Path)localObject).lineTo(12.0F, 52.5F);
      ((Path)localObject).lineTo(45.0F, 52.5F);
      ((Path)localObject).cubicTo(52.455845F, 52.5F, 58.5F, 46.455845F, 58.5F, 39.0F);
      ((Path)localObject).cubicTo(58.5F, 31.544155F, 52.455845F, 25.5F, 45.0F, 25.5F);
      ((Path)localObject).lineTo(31.322699F, 25.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aeb
 * JD-Core Version:    0.7.0.1
 */