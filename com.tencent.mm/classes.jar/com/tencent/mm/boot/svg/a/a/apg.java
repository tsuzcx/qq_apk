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

public final class apg
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
      ((Path)localObject).moveTo(22.5F, 21.0F);
      ((Path)localObject).lineTo(22.5F, 19.5F);
      ((Path)localObject).cubicTo(22.5F, 12.044156F, 28.544155F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(43.455845F, 6.0F, 49.5F, 12.044156F, 49.5F, 19.5F);
      ((Path)localObject).lineTo(49.5F, 21.0F);
      ((Path)localObject).lineTo(56.997383F, 21.0F);
      ((Path)localObject).cubicTo(58.655682F, 21.0F, 60.0F, 22.34676F, 60.0F, 24.004917F);
      ((Path)localObject).lineTo(60.0F, 60.001087F);
      ((Path)localObject).cubicTo(60.0F, 63.314194F, 57.31646F, 66.0F, 53.993614F, 66.0F);
      ((Path)localObject).lineTo(18.006386F, 66.0F);
      ((Path)localObject).cubicTo(14.689151F, 66.0F, 12.0F, 63.319809F, 12.0F, 60.001087F);
      ((Path)localObject).lineTo(12.0F, 24.004917F);
      ((Path)localObject).cubicTo(12.0F, 22.345346F, 13.333893F, 21.0F, 15.002615F, 21.0F);
      ((Path)localObject).lineTo(22.5F, 21.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.0F, 21.0F);
      ((Path)localObject).lineTo(45.0F, 21.0F);
      ((Path)localObject).lineTo(45.0F, 19.5F);
      ((Path)localObject).cubicTo(45.0F, 14.529437F, 40.970562F, 10.5F, 36.0F, 10.5F);
      ((Path)localObject).cubicTo(31.029438F, 10.5F, 27.0F, 14.529437F, 27.0F, 19.5F);
      ((Path)localObject).lineTo(27.0F, 21.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.5F, 21.0F);
      ((Path)localObject).lineTo(22.5F, 33.0F);
      ((Path)localObject).lineTo(27.0F, 33.0F);
      ((Path)localObject).lineTo(27.0F, 21.0F);
      ((Path)localObject).lineTo(22.5F, 21.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.0F, 21.0F);
      ((Path)localObject).lineTo(45.0F, 33.0F);
      ((Path)localObject).lineTo(49.5F, 33.0F);
      ((Path)localObject).lineTo(49.5F, 21.0F);
      ((Path)localObject).lineTo(45.0F, 21.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.apg
 * JD-Core Version:    0.7.0.1
 */