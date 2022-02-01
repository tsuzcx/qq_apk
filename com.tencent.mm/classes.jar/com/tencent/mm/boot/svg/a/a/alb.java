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

public final class alb
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
      ((Path)localObject).moveTo(31.757359F, 27.0F);
      ((Path)localObject).lineTo(37.242641F, 32.485283F);
      ((Path)localObject).lineTo(33.0F, 36.727921F);
      ((Path)localObject).lineTo(24.514719F, 28.242641F);
      ((Path)localObject).lineTo(22.393398F, 26.121321F);
      ((Path)localObject).cubicTo(21.221825F, 24.949747F, 21.221825F, 23.050253F, 22.393398F, 21.878679F);
      ((Path)localObject).lineTo(33.0F, 11.272078F);
      ((Path)localObject).lineTo(37.242641F, 15.514719F);
      ((Path)localObject).lineTo(31.757359F, 21.0F);
      ((Path)localObject).lineTo(45.0F, 21.0F);
      ((Path)localObject).cubicTo(54.941124F, 21.0F, 63.0F, 29.058874F, 63.0F, 39.0F);
      ((Path)localObject).cubicTo(63.0F, 48.941124F, 54.941124F, 57.0F, 45.0F, 57.0F);
      ((Path)localObject).lineTo(12.0F, 57.0F);
      ((Path)localObject).lineTo(12.0F, 51.0F);
      ((Path)localObject).lineTo(45.0F, 51.0F);
      ((Path)localObject).cubicTo(51.627419F, 51.0F, 57.0F, 45.627419F, 57.0F, 39.0F);
      ((Path)localObject).cubicTo(57.0F, 32.372581F, 51.627419F, 27.0F, 45.0F, 27.0F);
      ((Path)localObject).lineTo(31.757359F, 27.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.alb
 * JD-Core Version:    0.7.0.1
 */