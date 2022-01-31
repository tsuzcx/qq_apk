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

public final class ahw
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
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
      localPaint.setColor(-8617594);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(42.999401F, 66.0F);
      ((Path)localObject).cubicTo(41.342876F, 66.0F, 40.0F, 67.337914F, 40.0F, 68.999878F);
      ((Path)localObject).lineTo(40.0F, 114.00012F);
      ((Path)localObject).cubicTo(40.0F, 115.65691F, 41.344719F, 117.0F, 42.999401F, 117.0F);
      ((Path)localObject).lineTo(126.0006F, 117.0F);
      ((Path)localObject).cubicTo(127.65712F, 117.0F, 129.0F, 115.66209F, 129.0F, 114.00012F);
      ((Path)localObject).lineTo(129.0F, 68.999878F);
      ((Path)localObject).cubicTo(129.0F, 67.343094F, 127.65528F, 66.0F, 126.0006F, 66.0F);
      ((Path)localObject).lineTo(42.999401F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(58.952122F, 66.0F);
      ((Path)localObject).cubicTo(65.859573F, 66.0F, 69.570213F, 52.0F, 76.296402F, 52.0F);
      ((Path)localObject).lineTo(85.0F, 52.0F);
      ((Path)localObject).lineTo(85.0F, 66.0F);
      ((Path)localObject).lineTo(58.952122F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(111.04787F, 66.0F);
      ((Path)localObject).cubicTo(104.14043F, 66.0F, 100.42979F, 52.0F, 93.702103F, 52.0F);
      ((Path)localObject).lineTo(85.0F, 52.0F);
      ((Path)localObject).lineTo(85.0F, 66.0F);
      ((Path)localObject).lineTo(111.04787F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(84.5F, 70.0F);
      ((Path)localObject).cubicTo(95.269997F, 70.0F, 104.0F, 78.730003F, 104.0F, 89.5F);
      ((Path)localObject).cubicTo(104.0F, 100.27F, 95.269997F, 109.0F, 84.5F, 109.0F);
      ((Path)localObject).cubicTo(73.730003F, 109.0F, 65.0F, 100.27F, 65.0F, 89.5F);
      ((Path)localObject).cubicTo(65.0F, 78.730003F, 73.730003F, 70.0F, 84.5F, 70.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(84.5F, 74.0F);
      ((Path)localObject).cubicTo(93.060654F, 74.0F, 100.0F, 80.939346F, 100.0F, 89.5F);
      ((Path)localObject).cubicTo(100.0F, 98.060654F, 93.060654F, 105.0F, 84.5F, 105.0F);
      ((Path)localObject).cubicTo(75.939346F, 105.0F, 69.0F, 98.060654F, 69.0F, 89.5F);
      ((Path)localObject).cubicTo(69.0F, 80.939346F, 75.939346F, 74.0F, 84.5F, 74.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(47.0F, 58.0F);
      ((Path)localObject).lineTo(58.0F, 58.0F);
      ((Path)localObject).lineTo(58.0F, 63.0F);
      ((Path)localObject).lineTo(47.0F, 63.0F);
      ((Path)localObject).lineTo(47.0F, 58.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahw
 * JD-Core Version:    0.7.0.1
 */