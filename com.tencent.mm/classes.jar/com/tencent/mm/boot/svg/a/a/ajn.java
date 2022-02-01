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

public final class ajn
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
      ((Path)localObject).moveTo(44.197224F, 12.0F);
      ((Path)localObject).cubicTo(44.698753F, 12.0F, 45.167103F, 12.250651F, 45.445301F, 12.66795F);
      ((Path)localObject).lineTo(51.0F, 21.0F);
      ((Path)localObject).lineTo(63.0F, 21.0F);
      ((Path)localObject).cubicTo(64.656853F, 21.0F, 66.0F, 22.343145F, 66.0F, 24.0F);
      ((Path)localObject).lineTo(66.0F, 57.0F);
      ((Path)localObject).cubicTo(66.0F, 58.656853F, 64.656853F, 60.0F, 63.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 60.0F);
      ((Path)localObject).cubicTo(7.343146F, 60.0F, 6.0F, 58.656853F, 6.0F, 57.0F);
      ((Path)localObject).lineTo(6.0F, 24.0F);
      ((Path)localObject).cubicTo(6.0F, 22.343145F, 7.343146F, 21.0F, 9.0F, 21.0F);
      ((Path)localObject).lineTo(21.0F, 21.0F);
      ((Path)localObject).lineTo(26.554701F, 12.66795F);
      ((Path)localObject).cubicTo(26.832899F, 12.250651F, 27.301247F, 12.0F, 27.802776F, 12.0F);
      ((Path)localObject).lineTo(44.197224F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 49.5F);
      ((Path)localObject).cubicTo(41.798988F, 49.5F, 46.5F, 44.798988F, 46.5F, 39.0F);
      ((Path)localObject).cubicTo(46.5F, 33.201012F, 41.798988F, 28.5F, 36.0F, 28.5F);
      ((Path)localObject).cubicTo(30.20101F, 28.5F, 25.5F, 33.201012F, 25.5F, 39.0F);
      ((Path)localObject).cubicTo(25.5F, 44.798988F, 30.20101F, 49.5F, 36.0F, 49.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ajn
 * JD-Core Version:    0.7.0.1
 */