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

public final class aqf
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
      ((Path)localObject).moveTo(45.0F, 43.5F);
      ((Path)localObject).lineTo(61.5F, 43.5F);
      ((Path)localObject).lineTo(61.5F, 28.5F);
      ((Path)localObject).lineTo(45.0F, 28.5F);
      ((Path)localObject).cubicTo(40.857864F, 28.5F, 37.5F, 31.857864F, 37.5F, 36.0F);
      ((Path)localObject).cubicTo(37.5F, 40.142136F, 40.857864F, 43.5F, 45.0F, 43.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 12.0F);
      ((Path)localObject).cubicTo(64.656853F, 12.0F, 66.0F, 13.343145F, 66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 57.0F);
      ((Path)localObject).cubicTo(66.0F, 58.656853F, 64.656853F, 60.0F, 63.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 60.0F);
      ((Path)localObject).cubicTo(7.343146F, 60.0F, 6.0F, 58.656853F, 6.0F, 57.0F);
      ((Path)localObject).lineTo(6.0F, 15.0F);
      ((Path)localObject).cubicTo(6.0F, 13.343145F, 7.343146F, 12.0F, 9.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.0F, 39.0F);
      ((Path)localObject).cubicTo(43.343147F, 39.0F, 42.0F, 37.656853F, 42.0F, 36.0F);
      ((Path)localObject).cubicTo(42.0F, 34.343147F, 43.343147F, 33.0F, 45.0F, 33.0F);
      ((Path)localObject).cubicTo(46.656853F, 33.0F, 48.0F, 34.343147F, 48.0F, 36.0F);
      ((Path)localObject).cubicTo(48.0F, 37.656853F, 46.656853F, 39.0F, 45.0F, 39.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqf
 * JD-Core Version:    0.7.0.1
 */