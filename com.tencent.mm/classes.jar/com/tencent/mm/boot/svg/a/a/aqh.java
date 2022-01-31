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

public final class aqh
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(125.0608F, 0.0F);
      ((Path)localObject).cubicTo(144.336F, 0.0F, 153.97121F, 0.0F, 164.3472F, 3.28F);
      ((Path)localObject).cubicTo(175.6752F, 7.4032F, 184.5968F, 16.3248F, 188.72F, 27.6528F);
      ((Path)localObject).cubicTo(192.0F, 38.027199F, 192.0F, 47.6656F, 192.0F, 66.939201F);
      ((Path)localObject).lineTo(192.0F, 125.0608F);
      ((Path)localObject).cubicTo(192.0F, 144.336F, 192.0F, 153.97121F, 188.72F, 164.3472F);
      ((Path)localObject).cubicTo(184.5968F, 175.6752F, 175.6752F, 184.5968F, 164.3472F, 188.7184F);
      ((Path)localObject).cubicTo(153.97121F, 192.0F, 144.336F, 192.0F, 125.0608F, 192.0F);
      ((Path)localObject).lineTo(66.939201F, 192.0F);
      ((Path)localObject).cubicTo(47.664001F, 192.0F, 38.027199F, 192.0F, 27.6528F, 188.7184F);
      ((Path)localObject).cubicTo(16.3248F, 184.5968F, 7.4032F, 175.6752F, 3.28F, 164.3472F);
      ((Path)localObject).cubicTo(0.0F, 153.97121F, 0.0F, 144.336F, 0.0F, 125.0608F);
      ((Path)localObject).lineTo(0.0F, 66.939201F);
      ((Path)localObject).cubicTo(0.0F, 47.6656F, 0.0F, 38.027199F, 3.28F, 27.6528F);
      ((Path)localObject).cubicTo(7.4032F, 16.3248F, 16.3248F, 7.4032F, 27.6528F, 3.28F);
      ((Path)localObject).cubicTo(38.027199F, 0.0F, 47.664001F, 0.0F, 66.939201F, 0.0F);
      ((Path)localObject).lineTo(125.0608F, 0.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqh
 * JD-Core Version:    0.7.0.1
 */