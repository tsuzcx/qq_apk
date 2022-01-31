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

public final class ko
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-8617851);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(69.0F, 73.0F);
      ((Path)localObject).cubicTo(69.0F, 75.188713F, 67.164108F, 77.0F, 65.0F, 77.0F);
      ((Path)localObject).lineTo(57.0F, 77.0F);
      ((Path)localObject).lineTo(57.0F, 57.0F);
      ((Path)localObject).lineTo(40.0F, 57.0F);
      ((Path)localObject).lineTo(40.0F, 77.0F);
      ((Path)localObject).lineTo(32.0F, 77.0F);
      ((Path)localObject).cubicTo(29.835434F, 77.0F, 28.0F, 75.188713F, 28.0F, 73.0F);
      ((Path)localObject).lineTo(28.0F, 38.0F);
      ((Path)localObject).lineTo(49.0F, 18.0F);
      ((Path)localObject).lineTo(69.0F, 38.0F);
      ((Path)localObject).lineTo(69.0F, 73.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(52.0F, 9.0F);
      ((Path)localObject).lineTo(52.0F, 9.0F);
      ((Path)localObject).cubicTo(50.789879F, 8.532246F, 49.708397F, 8.0F, 49.0F, 8.0F);
      ((Path)localObject).cubicTo(47.291603F, 8.0F, 46.210121F, 8.532246F, 45.0F, 9.0F);
      ((Path)localObject).lineTo(45.0F, 9.0F);
      ((Path)localObject).lineTo(8.0F, 47.0F);
      ((Path)localObject).lineTo(14.0F, 53.0F);
      ((Path)localObject).lineTo(20.0F, 46.0F);
      ((Path)localObject).lineTo(20.0F, 73.0F);
      ((Path)localObject).cubicTo(20.146534F, 79.556862F, 25.5868F, 85.0F, 32.0F, 85.0F);
      ((Path)localObject).lineTo(40.0F, 85.0F);
      ((Path)localObject).lineTo(57.0F, 85.0F);
      ((Path)localObject).lineTo(65.0F, 85.0F);
      ((Path)localObject).cubicTo(71.4132F, 85.0F, 76.853462F, 79.556862F, 77.0F, 73.0F);
      ((Path)localObject).lineTo(77.0F, 46.0F);
      ((Path)localObject).lineTo(83.0F, 53.0F);
      ((Path)localObject).lineTo(89.0F, 47.0F);
      ((Path)localObject).lineTo(52.0F, 9.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ko
 * JD-Core Version:    0.7.0.1
 */