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

public final class aob
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(60.0F, 15.0F);
      ((Path)localObject).cubicTo(61.656853F, 15.0F, 63.0F, 16.343145F, 63.0F, 18.0F);
      ((Path)localObject).lineTo(63.0F, 30.0F);
      ((Path)localObject).cubicTo(59.686291F, 30.0F, 57.0F, 32.686291F, 57.0F, 36.0F);
      ((Path)localObject).cubicTo(57.0F, 39.313709F, 59.686291F, 42.0F, 63.0F, 42.0F);
      ((Path)localObject).lineTo(63.0F, 54.0F);
      ((Path)localObject).cubicTo(63.0F, 55.656853F, 61.656853F, 57.0F, 60.0F, 57.0F);
      ((Path)localObject).lineTo(12.0F, 57.0F);
      ((Path)localObject).cubicTo(10.343145F, 57.0F, 9.0F, 55.656853F, 9.0F, 54.0F);
      ((Path)localObject).lineTo(9.0F, 42.0F);
      ((Path)localObject).cubicTo(12.313708F, 42.0F, 15.0F, 39.313709F, 15.0F, 36.0F);
      ((Path)localObject).cubicTo(15.0F, 32.686291F, 12.313708F, 30.0F, 9.0F, 30.0F);
      ((Path)localObject).lineTo(9.0F, 18.0F);
      ((Path)localObject).cubicTo(9.0F, 16.343145F, 10.343145F, 15.0F, 12.0F, 15.0F);
      ((Path)localObject).lineTo(60.0F, 15.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.0F, 44.400002F);
      ((Path)localObject).lineTo(27.0F, 44.400002F);
      ((Path)localObject).lineTo(27.0F, 51.599998F);
      ((Path)localObject).lineTo(33.0F, 51.599998F);
      ((Path)localObject).lineTo(33.0F, 44.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.0F, 32.400002F);
      ((Path)localObject).lineTo(27.0F, 32.400002F);
      ((Path)localObject).lineTo(27.0F, 39.599998F);
      ((Path)localObject).lineTo(33.0F, 39.599998F);
      ((Path)localObject).lineTo(33.0F, 32.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.0F, 20.4F);
      ((Path)localObject).lineTo(27.0F, 20.4F);
      ((Path)localObject).lineTo(27.0F, 27.6F);
      ((Path)localObject).lineTo(33.0F, 27.6F);
      ((Path)localObject).lineTo(33.0F, 20.4F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aob
 * JD-Core Version:    0.7.0.1
 */