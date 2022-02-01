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

public final class bua
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      ((Path)localObject).moveTo(5.333334F, 4.0F);
      ((Path)localObject).lineTo(26.666666F, 4.0F);
      ((Path)localObject).cubicTo(27.403046F, 4.0F, 28.0F, 4.596954F, 28.0F, 5.333334F);
      ((Path)localObject).lineTo(28.0F, 26.666666F);
      ((Path)localObject).cubicTo(28.0F, 27.403046F, 27.403046F, 28.0F, 26.666666F, 28.0F);
      ((Path)localObject).lineTo(5.333334F, 28.0F);
      ((Path)localObject).cubicTo(4.596954F, 28.0F, 4.0F, 27.403046F, 4.0F, 26.666666F);
      ((Path)localObject).lineTo(4.0F, 5.333334F);
      ((Path)localObject).cubicTo(4.0F, 4.596954F, 4.596954F, 4.0F, 5.333334F, 4.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.0F, 10.666667F);
      ((Path)localObject).lineTo(8.0F, 21.495667F);
      ((Path)localObject).lineTo(16.038334F, 21.495667F);
      ((Path)localObject).lineTo(16.038334F, 20.085167F);
      ((Path)localObject).lineTo(9.653167F, 20.085167F);
      ((Path)localObject).lineTo(9.653167F, 16.642334F);
      ((Path)localObject).lineTo(15.4165F, 16.642334F);
      ((Path)localObject).lineTo(15.4165F, 15.231833F);
      ((Path)localObject).lineTo(9.653167F, 15.231833F);
      ((Path)localObject).lineTo(9.653167F, 12.077167F);
      ((Path)localObject).lineTo(15.7805F, 12.077167F);
      ((Path)localObject).lineTo(15.7805F, 10.666667F);
      ((Path)localObject).lineTo(8.0F, 10.666667F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.543833F, 13.442166F);
      ((Path)localObject).cubicTo(21.0585F, 13.442166F, 20.618668F, 13.533167F, 20.224333F, 13.7455F);
      ((Path)localObject).cubicTo(19.83F, 13.942667F, 19.481167F, 14.230833F, 19.177834F, 14.625167F);
      ((Path)localObject).lineTo(19.177834F, 13.6545F);
      ((Path)localObject).lineTo(17.570168F, 13.6545F);
      ((Path)localObject).lineTo(17.570168F, 21.495667F);
      ((Path)localObject).lineTo(19.177834F, 21.495667F);
      ((Path)localObject).lineTo(19.177834F, 16.778833F);
      ((Path)localObject).cubicTo(19.238501F, 16.141832F, 19.466F, 15.641334F, 19.83F, 15.277333F);
      ((Path)localObject).cubicTo(20.163666F, 14.943666F, 20.573166F, 14.792F, 21.028166F, 14.792F);
      ((Path)localObject).cubicTo(22.241501F, 14.792F, 22.863333F, 15.459333F, 22.863333F, 16.794001F);
      ((Path)localObject).lineTo(22.863333F, 21.495667F);
      ((Path)localObject).lineTo(24.471001F, 21.495667F);
      ((Path)localObject).lineTo(24.471001F, 16.657499F);
      ((Path)localObject).cubicTo(24.471001F, 14.503834F, 23.485167F, 13.442166F, 21.543833F, 13.442166F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bua
 * JD-Core Version:    0.7.0.1
 */