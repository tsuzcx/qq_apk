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

public final class axa
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
      ((Path)localObject).moveTo(9.621321F, 42.621319F);
      ((Path)localObject).cubicTo(8.449747F, 41.449749F, 8.449747F, 39.550251F, 9.621321F, 38.378681F);
      ((Path)localObject).lineTo(38.121319F, 9.878679F);
      ((Path)localObject).cubicTo(38.683929F, 9.316071F, 39.446991F, 9.0F, 40.242641F, 9.0F);
      ((Path)localObject).lineTo(60.0F, 9.0F);
      ((Path)localObject).cubicTo(61.656853F, 9.0F, 63.0F, 10.343145F, 63.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 31.757359F);
      ((Path)localObject).cubicTo(63.0F, 32.553009F, 62.683929F, 33.316071F, 62.121319F, 33.878681F);
      ((Path)localObject).lineTo(33.621319F, 62.378681F);
      ((Path)localObject).cubicTo(32.449749F, 63.550251F, 30.550253F, 63.550251F, 29.378679F, 62.378681F);
      ((Path)localObject).lineTo(9.621321F, 42.621319F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(59.400002F, 31.508831F);
      ((Path)localObject).lineTo(59.400002F, 12.6F);
      ((Path)localObject).lineTo(40.491169F, 12.6F);
      ((Path)localObject).lineTo(12.591168F, 40.5F);
      ((Path)localObject).lineTo(31.5F, 59.408833F);
      ((Path)localObject).lineTo(59.400002F, 31.508831F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 28.5F);
      ((Path)localObject).cubicTo(45.514717F, 28.5F, 43.5F, 26.485281F, 43.5F, 24.0F);
      ((Path)localObject).cubicTo(43.5F, 21.514719F, 45.514717F, 19.5F, 48.0F, 19.5F);
      ((Path)localObject).cubicTo(50.485283F, 19.5F, 52.5F, 21.514719F, 52.5F, 24.0F);
      ((Path)localObject).cubicTo(52.5F, 26.485281F, 50.485283F, 28.5F, 48.0F, 28.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.axa
 * JD-Core Version:    0.7.0.1
 */