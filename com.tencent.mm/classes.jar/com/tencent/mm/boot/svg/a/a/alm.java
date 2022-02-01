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

public final class alm
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
      ((Path)localObject).moveTo(49.864876F, 45.515251F);
      ((Path)localObject).lineTo(62.598618F, 58.248997F);
      ((Path)localObject).lineTo(58.355976F, 62.491638F);
      ((Path)localObject).lineTo(45.637589F, 49.773251F);
      ((Path)localObject).cubicTo(42.121399F, 52.426655F, 37.744442F, 54.0F, 33.0F, 54.0F);
      ((Path)localObject).cubicTo(21.402F, 54.0F, 12.0F, 44.598F, 12.0F, 33.0F);
      ((Path)localObject).cubicTo(12.0F, 21.402F, 21.402F, 12.0F, 33.0F, 12.0F);
      ((Path)localObject).cubicTo(44.598F, 12.0F, 54.0F, 21.402F, 54.0F, 33.0F);
      ((Path)localObject).cubicTo(54.0F, 37.689571F, 52.462833F, 42.020115F, 49.864876F, 45.515251F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 33.0F);
      ((Path)localObject).cubicTo(48.0F, 24.715714F, 41.284286F, 18.0F, 33.0F, 18.0F);
      ((Path)localObject).cubicTo(24.715714F, 18.0F, 18.0F, 24.715714F, 18.0F, 33.0F);
      ((Path)localObject).cubicTo(18.0F, 41.284286F, 24.715714F, 48.0F, 33.0F, 48.0F);
      ((Path)localObject).cubicTo(41.284286F, 48.0F, 48.0F, 41.284286F, 48.0F, 33.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.alm
 * JD-Core Version:    0.7.0.1
 */