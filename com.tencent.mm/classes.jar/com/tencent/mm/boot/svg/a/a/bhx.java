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

public final class bhx
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
      ((Path)localObject).moveTo(44.104069F, 48.572086F);
      ((Path)localObject).lineTo(20.999926F, 35.231152F);
      ((Path)localObject).cubicTo(19.958965F, 34.62973F, 19.004F, 35.258579F, 19.0F, 36.462433F);
      ((Path)localObject).lineTo(19.004F, 62.93198F);
      ((Path)localObject).cubicTo(19.0F, 64.134819F, 19.846968F, 65.614998F, 20.88693F, 66.219467F);
      ((Path)localObject).lineTo(44.10907F, 79.740219F);
      ((Path)localObject).cubicTo(45.149033F, 80.345695F, 46.0F, 79.856033F, 46.0F, 78.653191F);
      ((Path)localObject).lineTo(46.0F, 51.852459F);
      ((Path)localObject).cubicTo(45.999001F, 50.648605F, 45.14603F, 49.172489F, 44.104069F, 48.572086F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(73.216934F, 29.458399F);
      ((Path)localObject).lineTo(50.073246F, 16.445101F);
      ((Path)localObject).cubicTo(49.02697F, 15.856779F, 47.311195F, 15.850846F, 46.259857F, 16.432247F);
      ((Path)localObject).lineTo(22.789015F, 29.413904F);
      ((Path)localObject).cubicTo(21.738686F, 29.994316F, 21.73666F, 30.948486F, 22.784964F, 31.533842F);
      ((Path)localObject).lineTo(46.143379F, 44.560982F);
      ((Path)localObject).cubicTo(47.191681F, 45.146339F, 48.907452F, 45.146339F, 49.956768F, 44.560982F);
      ((Path)localObject).lineTo(73.212883F, 31.591192F);
      ((Path)localObject).cubicTo(74.261185F, 31.006824F, 74.262199F, 30.046722F, 73.216934F, 29.458399F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(76.997002F, 36.350918F);
      ((Path)localObject).cubicTo(77.000999F, 35.147739F, 76.151001F, 34.6553F, 75.110001F, 35.256382F);
      ((Path)localObject).lineTo(51.895F, 48.66497F);
      ((Path)localObject).cubicTo(50.853001F, 49.267067F, 50.0F, 50.74337F, 50.0F, 51.946548F);
      ((Path)localObject).lineTo(50.0F, 78.644928F);
      ((Path)localObject).cubicTo(50.0F, 79.849121F, 50.854F, 80.344612F, 51.897999F, 79.74556F);
      ((Path)localObject).lineTo(74.994003F, 66.515671F);
      ((Path)localObject).cubicTo(76.037003F, 65.917633F, 76.996002F, 64.287003F, 77.0F, 63.082806F);
      ((Path)localObject).lineTo(76.997002F, 36.350918F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bhx
 * JD-Core Version:    0.7.0.1
 */