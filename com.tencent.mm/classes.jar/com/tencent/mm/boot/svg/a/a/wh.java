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

public final class wh
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
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
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(96.0F, 0.0F);
      ((Path)localObject).lineTo(96.0F, 96.0F);
      ((Path)localObject).lineTo(0.0F, 96.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15683841);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(63.79504F, 76.031357F);
      ((Path)localObject).cubicTo(66.123993F, 72.529205F, 68.779198F, 68.383102F, 71.20018F, 64.236443F);
      ((Path)localObject).cubicTo(75.004066F, 57.72113F, 67.963371F, 50.764866F, 69.061218F, 48.884483F);
      ((Path)localObject).lineTo(75.609398F, 37.668751F);
      ((Path)localObject).lineTo(77.458931F, 38.724712F);
      ((Path)localObject).lineTo(79.198235F, 35.745628F);
      ((Path)localObject).lineTo(65.822983F, 28.109241F);
      ((Path)localObject).lineTo(64.083672F, 31.088326F);
      ((Path)localObject).lineTo(65.308807F, 31.787794F);
      ((Path)localObject).lineTo(65.308807F, 31.787794F);
      ((Path)localObject).cubicTo(63.367702F, 35.112526F, 59.602104F, 41.562244F, 58.760628F, 43.003529F);
      ((Path)localObject).cubicTo(57.614784F, 44.966133F, 48.314522F, 42.273102F, 44.418648F, 48.945957F);
      ((Path)localObject).cubicTo(41.398506F, 54.118862F, 34.140175F, 64.833092F, 31.555475F, 68.623924F);
      ((Path)localObject).cubicTo(36.904846F, 68.188011F, 44.777954F, 68.44738F, 52.009232F, 72.136162F);
      ((Path)localObject).cubicTo(56.16449F, 74.255821F, 60.120087F, 75.473061F, 63.79504F, 76.031357F);
      ((Path)localObject).lineTo(63.79504F, 76.031357F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(74.7789F, 22.0F);
      ((Path)localObject).lineTo(71.040581F, 28.949007F);
      ((Path)localObject).lineTo(76.479958F, 32.174023F);
      ((Path)localObject).lineTo(84.061768F, 26.508453F);
      ((Path)localObject).lineTo(74.7789F, 22.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(87.909088F, 75.088982F);
      ((Path)localObject).cubicTo(87.909088F, 75.088982F, 77.715836F, 85.381821F, 65.847153F, 85.381821F);
      ((Path)localObject).cubicTo(40.000687F, 85.381821F, 50.014915F, 73.988922F, 20.0F, 72.81588F);
      ((Path)localObject).cubicTo(19.998188F, 72.818657F, 36.395184F, 68.369362F, 50.495522F, 75.088982F);
      ((Path)localObject).cubicTo(71.97876F, 85.326965F, 87.909088F, 75.088982F, 87.909088F, 75.088982F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.wh
 * JD-Core Version:    0.7.0.1
 */