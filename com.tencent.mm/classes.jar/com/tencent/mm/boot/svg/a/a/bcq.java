package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bcq
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-6710887);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 13.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(31.405348F, 0.6570585F);
      ((Path)localObject2).cubicTo(37.566891F, -1.20349F, 44.896828F, 0.947144F, 48.581768F, 6.348736F);
      ((Path)localObject2).cubicTo(51.937164F, 11.160154F, 51.617603F, 17.371986F, 51.178207F, 22.95363F);
      ((Path)localObject2).cubicTo(50.618973F, 28.435247F, 46.864128F, 32.65649F, 44.437458F, 37.357876F);
      ((Path)localObject2).cubicTo(42.91954F, 40.128693F, 44.397514F, 43.429668F, 46.874115F, 45.050144F);
      ((Path)localObject2).cubicTo(53.934422F, 49.75153F, 62.003345F, 52.942471F, 68.534378F, 58.454098F);
      ((Path)localObject2).cubicTo(71.050926F, 60.494698F, 71.190735F, 64.015739F, 70.881157F, 66.98661F);
      ((Path)localObject2).cubicTo(70.691422F, 68.817154F, 68.873917F, 70.117531F, 67.096352F, 69.977493F);
      ((Path)localObject2).cubicTo(46.364815F, 70.0075F, 25.63327F, 70.0075F, 4.901729F, 69.977493F);
      ((Path)localObject2).cubicTo(3.124169F, 70.127541F, 1.31665F, 68.807152F, 1.12691F, 66.996613F);
      ((Path)localObject2).cubicTo(0.7973627F, 64.00573F, 0.9571434F, 60.484695F, 3.483675F, 58.43409F);
      ((Path)localObject2).cubicTo(9.82497F, 53.092514F, 17.574333F, 49.841557F, 24.55475F, 45.460266F);
      ((Path)localObject2).cubicTo(26.681831F, 44.069855F, 28.67909F, 41.70916F, 28.089899F, 38.978355F);
      ((Path)localObject2).cubicTo(27.071297F, 35.09721F, 24.04545F, 32.17635F, 22.477602F, 28.535276F);
      ((Path)localObject2).cubicTo(20.200727F, 23.713856F, 20.370495F, 18.20223F, 20.849836F, 13.020703F);
      ((Path)localObject2).cubicTo(21.468987F, 7.249002F, 25.74312F, 2.067474F, 31.405348F, 0.6570585F);
      ((Path)localObject2).lineTo(31.405348F, 0.6570585F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bcq
 * JD-Core Version:    0.7.0.1
 */