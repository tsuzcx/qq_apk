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

public final class beg
  extends c
{
  private final int height = 240;
  private final int width = 180;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 180;
      return 240;
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(90.0F, 180.0F);
      ((Path)localObject).cubicTo(139.70563F, 180.0F, 180.0F, 139.70563F, 180.0F, 90.0F);
      ((Path)localObject).cubicTo(180.0F, 40.294373F, 139.70563F, 0.0F, 90.0F, 0.0F);
      ((Path)localObject).cubicTo(40.294373F, 0.0F, 0.0F, 40.294373F, 0.0F, 90.0F);
      ((Path)localObject).cubicTo(0.0F, 139.70563F, 40.294373F, 180.0F, 90.0F, 180.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(62.0F, 100.0F);
      ((Path)localObject).lineTo(84.0F, 115.0F);
      ((Path)localObject).lineTo(84.0F, 65.0F);
      ((Path)localObject).lineTo(62.0F, 80.0F);
      ((Path)localObject).lineTo(48.0F, 80.0F);
      ((Path)localObject).lineTo(48.0F, 100.0F);
      ((Path)localObject).lineTo(62.0F, 100.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(123.00751F, 126.11797F);
      ((Path)localObject).cubicTo(128.96204F, 115.44518F, 132.35507F, 103.14832F, 132.35507F, 90.058983F);
      ((Path)localObject).cubicTo(132.35507F, 76.969643F, 128.96204F, 64.672791F, 123.00751F, 54.0F);
      ((Path)localObject).lineTo(123.00751F, 54.0F);
      ((Path)localObject).lineTo(119.0F, 56.966599F);
      ((Path)localObject).cubicTo(124.36485F, 66.796432F, 127.41389F, 78.071632F, 127.41389F, 90.058983F);
      ((Path)localObject).cubicTo(127.41389F, 102.04633F, 124.36485F, 113.32154F, 119.0F, 123.15137F);
      ((Path)localObject).lineTo(123.00751F, 126.11797F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(110.93931F, 117.29133F);
      ((Path)localObject).cubicTo(115.13506F, 109.15772F, 117.50414F, 99.92836F, 117.50414F, 90.145668F);
      ((Path)localObject).cubicTo(117.50414F, 80.362968F, 115.13506F, 71.133606F, 110.93931F, 63.0F);
      ((Path)localObject).lineTo(110.93931F, 63.0F);
      ((Path)localObject).lineTo(107.0F, 65.916115F);
      ((Path)localObject).cubicTo(110.71647F, 73.272247F, 112.81003F, 81.587997F, 112.81003F, 90.392723F);
      ((Path)localObject).cubicTo(112.81003F, 99.053917F, 110.78417F, 107.24194F, 107.18047F, 114.5088F);
      ((Path)localObject).lineTo(110.93931F, 117.29133F);
      ((Path)localObject).lineTo(110.93931F, 117.29133F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(99.079292F, 108.3367F);
      ((Path)localObject).cubicTo(101.56525F, 102.78967F, 102.94785F, 96.640472F, 102.94785F, 90.16835F);
      ((Path)localObject).cubicTo(102.94785F, 83.696228F, 101.56525F, 77.547028F, 99.079292F, 72.0F);
      ((Path)localObject).lineTo(99.079292F, 72.0F);
      ((Path)localObject).lineTo(95.0F, 75.019737F);
      ((Path)localObject).cubicTo(96.937286F, 79.685188F, 98.006668F, 84.801888F, 98.006668F, 90.16835F);
      ((Path)localObject).cubicTo(98.006668F, 95.534813F, 96.937286F, 100.65151F, 95.0F, 105.31697F);
      ((Path)localObject).lineTo(99.079292F, 108.3367F);
      ((Path)localObject).lineTo(99.079292F, 108.3367F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.beg
 * JD-Core Version:    0.7.0.1
 */