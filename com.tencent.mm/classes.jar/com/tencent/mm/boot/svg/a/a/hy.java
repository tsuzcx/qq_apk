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

public final class hy
  extends c
{
  private final int height = 16;
  private final int width = 15;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 15;
      return 16;
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
      localPaint.setColor(-11048043);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(7.624182F, 0.02862168F);
      ((Path)localObject).cubicTo(8.509319F, 0.1604835F, 9.499581F, 1.017788F, 9.499581F, 2.610426F);
      ((Path)localObject).cubicTo(9.499581F, 3.775718F, 9.310068F, 4.471049F, 9.25998F, 5.016025F);
      ((Path)localObject).lineTo(9.250553F, 5.149321F);
      ((Path)localObject).lineTo(13.112538F, 5.149321F);
      ((Path)localObject).cubicTo(13.726087F, 5.149321F, 14.986115F, 5.921881F, 14.769511F, 7.332844F);
      ((Path)localObject).cubicTo(14.381703F, 9.859036F, 13.046923F, 12.510862F, 12.854087F, 12.918297F);
      ((Path)localObject).cubicTo(12.250458F, 14.193681F, 11.325146F, 15.007201F, 10.553953F, 15.093657F);
      ((Path)localObject).lineTo(10.419558F, 15.101312F);
      ((Path)localObject).lineTo(1.116654F, 15.101312F);
      ((Path)localObject).cubicTo(0.5391967F, 15.101312F, 0.05957106F, 14.221435F, 0.005142627F, 13.623581F);
      ((Path)localObject).lineTo(-9.094947E-013F, 13.515072F);
      ((Path)localObject).lineTo(-9.094947E-013F, 6.997379F);
      ((Path)localObject).cubicTo(-9.094947E-013F, 6.270741F, 0.5646098F, 5.710601F, 1.141133F, 5.643422F);
      ((Path)localObject).lineTo(1.256433F, 5.636656F);
      ((Path)localObject).lineTo(1.964519F, 5.636656F);
      ((Path)localObject).cubicTo(1.964519F, 5.636656F, 3.931452F, 5.946601F, 4.789839F, 4.523071F);
      ((Path)localObject).cubicTo(5.600806F, 3.178601F, 5.620325F, 2.147425F, 5.620325F, 1.171029F);
      ((Path)localObject).cubicTo(5.620325F, 0.1946325F, 6.757516F, -0.1004885F, 7.624182F, 0.02862168F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(2.665664F, 6.079402F);
      ((Path)localObject).cubicTo(2.389521F, 6.079402F, 2.165664F, 6.303259F, 2.165664F, 6.579402F);
      ((Path)localObject).lineTo(2.165664F, 6.579402F);
      ((Path)localObject).lineTo(2.165664F, 14.04999F);
      ((Path)localObject).cubicTo(2.165664F, 14.326133F, 2.389521F, 14.54999F, 2.665664F, 14.54999F);
      ((Path)localObject).cubicTo(2.941806F, 14.54999F, 3.165664F, 14.326133F, 3.165664F, 14.04999F);
      ((Path)localObject).lineTo(3.165664F, 14.04999F);
      ((Path)localObject).lineTo(3.165664F, 6.579402F);
      ((Path)localObject).cubicTo(3.165664F, 6.303259F, 2.941806F, 6.079402F, 2.665664F, 6.079402F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.hy
 * JD-Core Version:    0.7.0.1
 */