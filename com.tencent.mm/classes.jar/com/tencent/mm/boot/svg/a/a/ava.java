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

public final class ava
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
      ((Path)localObject).moveTo(15.6F, 30.0F);
      ((Path)localObject).lineTo(15.6F, 33.598999F);
      ((Path)localObject).lineTo(15.6F, 33.599998F);
      ((Path)localObject).lineTo(15.6F, 56.400002F);
      ((Path)localObject).lineTo(56.400002F, 56.400002F);
      ((Path)localObject).lineTo(56.400002F, 30.0F);
      ((Path)localObject).lineTo(60.0F, 30.0F);
      ((Path)localObject).lineTo(60.0F, 56.400002F);
      ((Path)localObject).lineTo(63.0F, 56.400002F);
      ((Path)localObject).lineTo(63.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 56.400002F);
      ((Path)localObject).lineTo(12.0F, 56.400002F);
      ((Path)localObject).lineTo(12.0F, 30.0F);
      ((Path)localObject).lineTo(15.6F, 30.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.857143F, 31.5F);
      ((Path)localObject).lineTo(34.970001F, 39.404999F);
      ((Path)localObject).lineTo(37.028999F, 39.404999F);
      ((Path)localObject).lineTo(41.142857F, 31.5F);
      ((Path)localObject).lineTo(45.0F, 31.5F);
      ((Path)localObject).lineTo(40.886002F, 39.404999F);
      ((Path)localObject).lineTo(45.0F, 39.405914F);
      ((Path)localObject).lineTo(45.0F, 42.370617F);
      ((Path)localObject).lineTo(37.542F, 42.369999F);
      ((Path)localObject).lineTo(37.542F, 45.088001F);
      ((Path)localObject).lineTo(45.0F, 45.088234F);
      ((Path)localObject).lineTo(45.0F, 48.05294F);
      ((Path)localObject).lineTo(37.542F, 48.051998F);
      ((Path)localObject).lineTo(37.542919F, 52.5F);
      ((Path)localObject).lineTo(34.457207F, 52.5F);
      ((Path)localObject).lineTo(34.457001F, 48.051998F);
      ((Path)localObject).lineTo(27.0F, 48.05294F);
      ((Path)localObject).lineTo(27.0F, 45.088234F);
      ((Path)localObject).lineTo(34.457001F, 45.088001F);
      ((Path)localObject).lineTo(34.457001F, 42.369999F);
      ((Path)localObject).lineTo(27.0F, 42.370617F);
      ((Path)localObject).lineTo(27.0F, 39.405914F);
      ((Path)localObject).lineTo(31.113001F, 39.404999F);
      ((Path)localObject).lineTo(27.0F, 31.5F);
      ((Path)localObject).lineTo(30.857143F, 31.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.218414F, 9.541518F);
      ((Path)localObject).lineTo(61.218414F, 20.208185F);
      ((Path)localObject).cubicTo(62.3018F, 20.689688F, 63.0F, 21.764053F, 63.0F, 22.949619F);
      ((Path)localObject).lineTo(63.0F, 27.0F);
      ((Path)localObject).lineTo(9.0F, 27.0F);
      ((Path)localObject).lineTo(9.0F, 22.949619F);
      ((Path)localObject).cubicTo(9.0F, 21.764053F, 9.6982F, 20.689688F, 10.781585F, 20.208185F);
      ((Path)localObject).lineTo(34.781586F, 9.541518F);
      ((Path)localObject).cubicTo(35.557281F, 9.196764F, 36.442719F, 9.196764F, 37.218414F, 9.541518F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.073689F, 12.906794F);
      ((Path)localObject).lineTo(12.6F, 23.339542F);
      ((Path)localObject).lineTo(12.6F, 23.4F);
      ((Path)localObject).lineTo(59.306702F, 23.4F);
      ((Path)localObject).lineTo(36.073689F, 12.906794F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ava
 * JD-Core Version:    0.7.0.1
 */