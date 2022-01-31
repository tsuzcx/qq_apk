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

public final class gg
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
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
      localPaint.setColor(-8421505);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(101.0F, 91.0F);
      ((Path)localObject).lineTo(101.0F, 55.997814F);
      ((Path)localObject).cubicTo(101.0F, 54.350853F, 99.656708F, 53.0F, 97.999672F, 53.0F);
      ((Path)localObject).lineTo(94.000328F, 53.0F);
      ((Path)localObject).cubicTo(92.348648F, 53.0F, 91.0F, 54.342167F, 91.0F, 55.997814F);
      ((Path)localObject).lineTo(91.0F, 91.0F);
      ((Path)localObject).lineTo(55.997814F, 91.0F);
      ((Path)localObject).cubicTo(54.350853F, 91.0F, 53.0F, 92.343292F, 53.0F, 94.000328F);
      ((Path)localObject).lineTo(53.0F, 97.999672F);
      ((Path)localObject).cubicTo(53.0F, 99.651352F, 54.342167F, 101.0F, 55.997814F, 101.0F);
      ((Path)localObject).lineTo(91.0F, 101.0F);
      ((Path)localObject).lineTo(91.0F, 136.00218F);
      ((Path)localObject).cubicTo(91.0F, 137.64914F, 92.343292F, 139.0F, 94.000328F, 139.0F);
      ((Path)localObject).lineTo(97.999672F, 139.0F);
      ((Path)localObject).cubicTo(99.651352F, 139.0F, 101.0F, 137.65784F, 101.0F, 136.00218F);
      ((Path)localObject).lineTo(101.0F, 101.0F);
      ((Path)localObject).lineTo(136.00218F, 101.0F);
      ((Path)localObject).cubicTo(137.64914F, 101.0F, 139.0F, 99.656708F, 139.0F, 97.999672F);
      ((Path)localObject).lineTo(139.0F, 94.000328F);
      ((Path)localObject).cubicTo(139.0F, 92.348648F, 137.65784F, 91.0F, 136.00218F, 91.0F);
      ((Path)localObject).lineTo(101.0F, 91.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.gg
 * JD-Core Version:    0.7.0.1
 */