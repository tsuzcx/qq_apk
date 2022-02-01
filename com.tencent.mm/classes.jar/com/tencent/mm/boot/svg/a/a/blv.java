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

public final class blv
  extends c
{
  private final int height = 88;
  private final int width = 88;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 88;
      return 88;
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
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(20.0F, 53.0F);
      ((Path)localObject).lineTo(20.0F, 62.0F);
      ((Path)localObject).lineTo(32.0F, 62.0F);
      ((Path)localObject).lineTo(32.0F, 68.0F);
      ((Path)localObject).lineTo(17.0F, 68.0F);
      ((Path)localObject).cubicTo(15.343145F, 68.0F, 14.0F, 66.656853F, 14.0F, 65.0F);
      ((Path)localObject).lineTo(14.0F, 65.0F);
      ((Path)localObject).lineTo(14.0F, 53.0F);
      ((Path)localObject).lineTo(20.0F, 53.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(74.0F, 53.0F);
      ((Path)localObject).lineTo(74.0F, 65.0F);
      ((Path)localObject).cubicTo(74.0F, 66.656853F, 72.656853F, 68.0F, 71.0F, 68.0F);
      ((Path)localObject).lineTo(56.0F, 68.0F);
      ((Path)localObject).lineTo(56.0F, 62.0F);
      ((Path)localObject).lineTo(68.0F, 62.0F);
      ((Path)localObject).lineTo(68.0F, 53.0F);
      ((Path)localObject).lineTo(74.0F, 53.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(56.727921F, 32.514717F);
      ((Path)localObject).lineTo(60.970562F, 36.757359F);
      ((Path)localObject).lineTo(41.878681F, 55.849243F);
      ((Path)localObject).cubicTo(41.363186F, 56.364735F, 40.706768F, 56.653412F, 40.03344F, 56.715271F);
      ((Path)localObject).lineTo(39.84948F, 56.726517F);
      ((Path)localObject).lineTo(39.84948F, 56.726517F);
      ((Path)localObject).lineTo(39.665237F, 56.726517F);
      ((Path)localObject).cubicTo(38.928463F, 56.704021F, 38.198395F, 56.411598F, 37.63604F, 55.849243F);
      ((Path)localObject).lineTo(27.029438F, 45.242641F);
      ((Path)localObject).lineTo(31.272078F, 41.0F);
      ((Path)localObject).lineTo(39.757F, 49.485001F);
      ((Path)localObject).lineTo(56.727921F, 32.514717F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(32.0F, 20.0F);
      ((Path)localObject).lineTo(32.0F, 26.0F);
      ((Path)localObject).lineTo(20.0F, 26.0F);
      ((Path)localObject).lineTo(20.0F, 35.0F);
      ((Path)localObject).lineTo(14.0F, 35.0F);
      ((Path)localObject).lineTo(14.0F, 23.0F);
      ((Path)localObject).cubicTo(14.0F, 21.343145F, 15.343145F, 20.0F, 17.0F, 20.0F);
      ((Path)localObject).lineTo(32.0F, 20.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(71.0F, 20.0F);
      ((Path)localObject).cubicTo(72.656853F, 20.0F, 74.0F, 21.343145F, 74.0F, 23.0F);
      ((Path)localObject).lineTo(74.0F, 23.0F);
      ((Path)localObject).lineTo(74.0F, 35.0F);
      ((Path)localObject).lineTo(68.0F, 35.0F);
      ((Path)localObject).lineTo(68.0F, 26.0F);
      ((Path)localObject).lineTo(56.0F, 26.0F);
      ((Path)localObject).lineTo(56.0F, 20.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.blv
 * JD-Core Version:    0.7.0.1
 */