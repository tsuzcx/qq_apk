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

public final class abs
  extends c
{
  private final int height = 191;
  private final int width = 191;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 191;
      return 191;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      Paint localPaint2 = c.a((Paint)localObject, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint1, paramVarArgs);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localPaint2.setColor(-6842473);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(3.5F, 7.5F);
      localPath.lineTo(178.5F, 7.5F);
      localPath.lineTo(178.5F, 177.5F);
      localPath.lineTo(3.5F, 177.5F);
      localPath.lineTo(3.5F, 7.5F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-686547);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(191.0F, 0.0F);
      ((Path)localObject).lineTo(191.0F, 191.0F);
      ((Path)localObject).lineTo(0.0F, 191.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(191.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(143.50204F, 51.924061F);
      ((Path)localObject).lineTo(55.177776F, 79.673218F);
      ((Path)localObject).lineTo(55.177776F, 108.65085F);
      ((Path)localObject).lineTo(71.7024F, 113.94841F);
      ((Path)localObject).lineTo(70.504662F, 117.91833F);
      ((Path)localObject).cubicTo(68.771225F, 123.66382F, 71.968994F, 129.74753F, 77.638115F, 131.50388F);
      ((Path)localObject).lineTo(96.88131F, 137.46565F);
      ((Path)localObject).cubicTo(102.55444F, 139.22325F, 108.55855F, 135.99077F, 110.29208F, 130.24493F);
      ((Path)localObject).lineTo(111.37189F, 126.66589F);
      ((Path)localObject).lineTo(143.50204F, 136.96637F);
      ((Path)localObject).cubicTo(146.29303F, 137.86111F, 148.55556F, 136.22597F, 148.55556F, 133.26476F);
      ((Path)localObject).lineTo(148.55556F, 55.658081F);
      ((Path)localObject).cubicTo(148.55556F, 52.718987F, 146.29359F, 51.047031F, 143.50204F, 51.924061F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(77.583252F, 115.83372F);
      ((Path)localObject).lineTo(105.58923F, 124.81204F);
      ((Path)localObject).lineTo(104.67921F, 127.8698F);
      ((Path)localObject).cubicTo(103.85574F, 130.63673F, 101.00234F, 132.19417F, 98.304535F, 131.34686F);
      ((Path)localObject).lineTo(80.015739F, 125.60284F);
      ((Path)localObject).cubicTo(77.320267F, 124.75626F, 75.800682F, 121.82336F, 76.623596F, 119.05828F);
      ((Path)localObject).lineTo(77.583252F, 115.83372F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(42.444443F, 80.420219F);
      ((Path)localObject).lineTo(42.444443F, 108.45738F);
      ((Path)localObject).cubicTo(42.444443F, 111.37789F, 44.490372F, 112.57163F, 47.036919F, 111.11062F);
      ((Path)localObject).lineTo(53.055557F, 107.65758F);
      ((Path)localObject).lineTo(53.055557F, 81.220032F);
      ((Path)localObject).lineTo(47.036919F, 77.766991F);
      ((Path)localObject).cubicTo(44.500565F, 76.311821F, 42.444443F, 77.518471F, 42.444443F, 80.420219F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abs
 * JD-Core Version:    0.7.0.1
 */