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

public final class ald
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
      ((Path)localObject).moveTo(3.0F, 36.0F);
      ((Path)localObject).cubicTo(9.08381F, 23.542883F, 21.576628F, 15.0F, 36.0F, 15.0F);
      ((Path)localObject).cubicTo(50.42337F, 15.0F, 62.916191F, 23.542883F, 69.0F, 36.0F);
      ((Path)localObject).cubicTo(62.916191F, 48.457119F, 50.42337F, 57.0F, 36.0F, 57.0F);
      ((Path)localObject).cubicTo(21.576628F, 57.0F, 9.08381F, 48.457119F, 3.0F, 36.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 46.5F);
      ((Path)localObject).cubicTo(41.798988F, 46.5F, 46.5F, 41.798988F, 46.5F, 36.0F);
      ((Path)localObject).cubicTo(46.5F, 30.20101F, 41.798988F, 25.5F, 36.0F, 25.5F);
      ((Path)localObject).cubicTo(30.20101F, 25.5F, 25.5F, 30.20101F, 25.5F, 36.0F);
      ((Path)localObject).cubicTo(25.5F, 41.798988F, 30.20101F, 46.5F, 36.0F, 46.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ald
 * JD-Core Version:    0.7.0.1
 */