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

public final class ki
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
      localPaint.setColor(-8683387);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(11.0F, 67.75325F);
      ((Path)localObject).lineTo(11.0F, 67.75325F);
      ((Path)localObject).lineTo(11.0F, 63.701298F);
      ((Path)localObject).cubicTo(11.007332F, 66.431679F, 12.668421F, 69.087723F, 15.0F, 70.792206F);
      ((Path)localObject).lineTo(15.0F, 70.792206F);
      ((Path)localObject).lineTo(43.0F, 87.0F);
      ((Path)localObject).cubicTo(43.626083F, 86.777901F, 43.811207F, 86.89193F, 44.0F, 87.0F);
      ((Path)localObject).lineTo(44.0F, 53.57143F);
      ((Path)localObject).lineTo(11.0F, 34.324677F);
      ((Path)localObject).lineTo(11.0F, 67.75325F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(52.0F, 53.57143F);
      ((Path)localObject).lineTo(52.0F, 87.0F);
      ((Path)localObject).cubicTo(52.188793F, 86.892921F, 52.373917F, 86.779457F, 53.0F, 87.0F);
      ((Path)localObject).lineTo(81.0F, 70.792206F);
      ((Path)localObject).lineTo(81.0F, 70.792206F);
      ((Path)localObject).cubicTo(83.331581F, 69.176964F, 84.992668F, 66.534088F, 85.0F, 63.701298F);
      ((Path)localObject).lineTo(85.0F, 68.766235F);
      ((Path)localObject).lineTo(85.0F, 68.766235F);
      ((Path)localObject).lineTo(85.0F, 34.324677F);
      ((Path)localObject).lineTo(52.0F, 53.57143F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(53.0F, 10.012987F);
      ((Path)localObject).cubicTo(51.805397F, 9.510585F, 50.266872F, 9.0F, 49.0F, 9.0F);
      ((Path)localObject).cubicTo(46.95472F, 9.0F, 45.416195F, 9.510585F, 44.0F, 10.012987F);
      ((Path)localObject).lineTo(16.0F, 27.233767F);
      ((Path)localObject).lineTo(48.0F, 46.480518F);
      ((Path)localObject).lineTo(81.0F, 27.233767F);
      ((Path)localObject).lineTo(53.0F, 10.012987F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ki
 * JD-Core Version:    0.7.0.1
 */