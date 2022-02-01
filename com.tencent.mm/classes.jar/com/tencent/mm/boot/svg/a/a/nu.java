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

public final class nu
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(20.001331F, 33.0F);
      ((Path)localObject).cubicTo(17.239172F, 33.0F, 15.0F, 35.236286F, 15.0F, 38.005322F);
      ((Path)localObject).lineTo(15.0F, 67.994675F);
      ((Path)localObject).cubicTo(15.0F, 70.759041F, 17.233757F, 73.0F, 20.001331F, 73.0F);
      ((Path)localObject).lineTo(75.998665F, 73.0F);
      ((Path)localObject).cubicTo(78.760826F, 73.0F, 81.0F, 70.763718F, 81.0F, 67.994675F);
      ((Path)localObject).lineTo(81.0F, 38.005322F);
      ((Path)localObject).cubicTo(81.0F, 35.240959F, 78.766243F, 33.0F, 75.998665F, 33.0F);
      ((Path)localObject).lineTo(20.001331F, 33.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(41.230534F, 24.0F);
      ((Path)localObject).lineTo(48.0F, 24.0F);
      ((Path)localObject).lineTo(48.0F, 33.0F);
      ((Path)localObject).lineTo(27.74054F, 33.0F);
      ((Path)localObject).cubicTo(33.113003F, 33.0F, 35.999054F, 24.0F, 41.230534F, 24.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(68.25946F, 33.0F);
      ((Path)localObject).cubicTo(62.886997F, 33.0F, 60.000946F, 24.0F, 54.768299F, 24.0F);
      ((Path)localObject).lineTo(48.0F, 24.0F);
      ((Path)localObject).lineTo(48.0F, 33.0F);
      ((Path)localObject).lineTo(68.25946F, 33.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 36.0F);
      ((Path)localObject).cubicTo(56.836922F, 36.0F, 64.0F, 43.163078F, 64.0F, 52.0F);
      ((Path)localObject).cubicTo(64.0F, 60.836922F, 56.836922F, 68.0F, 48.0F, 68.0F);
      ((Path)localObject).cubicTo(39.163078F, 68.0F, 32.0F, 60.836922F, 32.0F, 52.0F);
      ((Path)localObject).cubicTo(32.0F, 43.163078F, 39.163078F, 36.0F, 48.0F, 36.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(58.0F, 52.0F);
      ((Path)localObject).cubicTo(58.0F, 57.522999F, 53.522999F, 62.0F, 48.0F, 62.0F);
      ((Path)localObject).cubicTo(42.477001F, 62.0F, 38.0F, 57.522999F, 38.0F, 52.0F);
      ((Path)localObject).cubicTo(38.0F, 46.477001F, 42.477001F, 42.0F, 48.0F, 42.0F);
      ((Path)localObject).cubicTo(53.522999F, 42.0F, 58.0F, 46.477001F, 58.0F, 52.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.0F, 27.0F);
      ((Path)localObject).lineTo(27.0F, 27.0F);
      ((Path)localObject).lineTo(27.0F, 30.0F);
      ((Path)localObject).lineTo(18.0F, 30.0F);
      ((Path)localObject).lineTo(18.0F, 27.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.nu
 * JD-Core Version:    0.7.0.1
 */