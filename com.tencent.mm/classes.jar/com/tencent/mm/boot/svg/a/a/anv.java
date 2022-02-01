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

public final class anv
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
      ((Path)localObject).moveTo(12.0F, 45.0F);
      ((Path)localObject).lineTo(12.0F, 54.0F);
      ((Path)localObject).lineTo(24.0F, 54.0F);
      ((Path)localObject).lineTo(24.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 60.0F);
      ((Path)localObject).cubicTo(7.343146F, 60.0F, 6.0F, 58.656853F, 6.0F, 57.0F);
      ((Path)localObject).lineTo(6.0F, 57.0F);
      ((Path)localObject).lineTo(6.0F, 45.0F);
      ((Path)localObject).lineTo(12.0F, 45.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(66.0F, 45.0F);
      ((Path)localObject).lineTo(66.0F, 57.0F);
      ((Path)localObject).cubicTo(66.0F, 58.656853F, 64.656853F, 60.0F, 63.0F, 60.0F);
      ((Path)localObject).lineTo(48.0F, 60.0F);
      ((Path)localObject).lineTo(48.0F, 54.0F);
      ((Path)localObject).lineTo(60.0F, 54.0F);
      ((Path)localObject).lineTo(60.0F, 45.0F);
      ((Path)localObject).lineTo(66.0F, 45.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.727921F, 24.514719F);
      ((Path)localObject).lineTo(52.970562F, 28.757359F);
      ((Path)localObject).lineTo(33.878681F, 47.849243F);
      ((Path)localObject).cubicTo(33.363186F, 48.364735F, 32.706768F, 48.653412F, 32.03344F, 48.715271F);
      ((Path)localObject).lineTo(31.84948F, 48.726517F);
      ((Path)localObject).lineTo(31.84948F, 48.726517F);
      ((Path)localObject).lineTo(31.665239F, 48.726517F);
      ((Path)localObject).cubicTo(30.928463F, 48.704021F, 30.198395F, 48.411598F, 29.63604F, 47.849243F);
      ((Path)localObject).lineTo(19.029438F, 37.242641F);
      ((Path)localObject).lineTo(23.272078F, 33.0F);
      ((Path)localObject).lineTo(31.757F, 41.485001F);
      ((Path)localObject).lineTo(48.727921F, 24.514719F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 12.0F);
      ((Path)localObject).lineTo(24.0F, 18.0F);
      ((Path)localObject).lineTo(12.0F, 18.0F);
      ((Path)localObject).lineTo(12.0F, 27.0F);
      ((Path)localObject).lineTo(6.0F, 27.0F);
      ((Path)localObject).lineTo(6.0F, 15.0F);
      ((Path)localObject).cubicTo(6.0F, 13.343145F, 7.343146F, 12.0F, 9.0F, 12.0F);
      ((Path)localObject).lineTo(24.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(63.0F, 12.0F);
      ((Path)localObject).cubicTo(64.656853F, 12.0F, 66.0F, 13.343145F, 66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 27.0F);
      ((Path)localObject).lineTo(60.0F, 27.0F);
      ((Path)localObject).lineTo(60.0F, 18.0F);
      ((Path)localObject).lineTo(48.0F, 18.0F);
      ((Path)localObject).lineTo(48.0F, 12.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.anv
 * JD-Core Version:    0.7.0.1
 */