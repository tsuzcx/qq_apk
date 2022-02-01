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

public final class axi
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
      ((Path)localObject).moveTo(63.0F, 12.0F);
      ((Path)localObject).cubicTo(64.656853F, 12.0F, 66.0F, 13.343145F, 66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 28.799999F);
      ((Path)localObject).lineTo(65.939766F, 28.798904F);
      ((Path)localObject).cubicTo(65.979263F, 28.993111F, 66.0F, 29.194134F, 66.0F, 29.4F);
      ((Path)localObject).lineTo(66.0F, 29.4F);
      ((Path)localObject).lineTo(66.0F, 30.0F);
      ((Path)localObject).lineTo(66.0F, 30.0F);
      ((Path)localObject).lineTo(66.0F, 42.0F);
      ((Path)localObject).lineTo(66.0F, 42.0F);
      ((Path)localObject).lineTo(66.0F, 42.599998F);
      ((Path)localObject).cubicTo(66.0F, 42.805511F, 65.979332F, 43.006199F, 65.939972F, 43.200092F);
      ((Path)localObject).lineTo(66.0F, 43.200001F);
      ((Path)localObject).lineTo(66.0F, 57.0F);
      ((Path)localObject).cubicTo(66.0F, 58.656853F, 64.656853F, 60.0F, 63.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 60.0F);
      ((Path)localObject).cubicTo(7.343146F, 60.0F, 6.0F, 58.656853F, 6.0F, 57.0F);
      ((Path)localObject).lineTo(6.0F, 15.0F);
      ((Path)localObject).cubicTo(6.0F, 13.343145F, 7.343146F, 12.0F, 9.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(62.400002F, 15.6F);
      ((Path)localObject).lineTo(9.6F, 15.6F);
      ((Path)localObject).lineTo(9.6F, 56.400002F);
      ((Path)localObject).lineTo(62.400002F, 56.400002F);
      ((Path)localObject).lineTo(62.398998F, 45.598999F);
      ((Path)localObject).lineTo(45.0F, 45.599998F);
      ((Path)localObject).cubicTo(39.789478F, 45.599998F, 35.548508F, 41.448864F, 35.403816F, 36.273327F);
      ((Path)localObject).lineTo(35.400002F, 36.0F);
      ((Path)localObject).cubicTo(35.400002F, 30.698067F, 39.698067F, 26.4F, 45.0F, 26.4F);
      ((Path)localObject).lineTo(45.0F, 26.4F);
      ((Path)localObject).lineTo(62.398998F, 26.399F);
      ((Path)localObject).lineTo(62.400002F, 15.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(62.400002F, 30.0F);
      ((Path)localObject).lineTo(45.0F, 30.0F);
      ((Path)localObject).cubicTo(41.686291F, 30.0F, 39.0F, 32.686291F, 39.0F, 36.0F);
      ((Path)localObject).cubicTo(39.0F, 39.313709F, 41.686291F, 42.0F, 45.0F, 42.0F);
      ((Path)localObject).lineTo(45.0F, 42.0F);
      ((Path)localObject).lineTo(62.400002F, 42.0F);
      ((Path)localObject).lineTo(62.400002F, 30.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.0F, 33.0F);
      ((Path)localObject).cubicTo(46.656853F, 33.0F, 48.0F, 34.343147F, 48.0F, 36.0F);
      ((Path)localObject).cubicTo(48.0F, 37.656853F, 46.656853F, 39.0F, 45.0F, 39.0F);
      ((Path)localObject).cubicTo(43.343147F, 39.0F, 42.0F, 37.656853F, 42.0F, 36.0F);
      ((Path)localObject).cubicTo(42.0F, 34.343147F, 43.343147F, 33.0F, 45.0F, 33.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.axi
 * JD-Core Version:    0.7.0.1
 */