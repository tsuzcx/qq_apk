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

public final class lo
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
      localPaint.setColor(-8683387);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(68.0F, 68.0F);
      ((Path)localObject).lineTo(68.0F, 73.0F);
      ((Path)localObject).cubicTo(62.753819F, 77.365776F, 55.755802F, 80.0F, 48.0F, 80.0F);
      ((Path)localObject).cubicTo(43.030067F, 80.0F, 38.205288F, 78.816002F, 34.0F, 77.0F);
      ((Path)localObject).lineTo(48.0F, 52.0F);
      ((Path)localObject).lineTo(44.0F, 48.0F);
      ((Path)localObject).lineTo(36.0F, 48.0F);
      ((Path)localObject).lineTo(28.0F, 40.0F);
      ((Path)localObject).lineTo(44.0F, 24.0F);
      ((Path)localObject).lineTo(38.0F, 18.0F);
      ((Path)localObject).cubicTo(40.952587F, 16.616444F, 44.470387F, 16.0F, 48.0F, 16.0F);
      ((Path)localObject).cubicTo(52.408031F, 16.0F, 56.485584F, 16.82889F, 60.0F, 18.0F);
      ((Path)localObject).lineTo(60.0F, 24.0F);
      ((Path)localObject).lineTo(64.0F, 28.0F);
      ((Path)localObject).lineTo(73.0F, 28.0F);
      ((Path)localObject).cubicTo(75.216011F, 30.406666F, 76.816513F, 33.097332F, 78.0F, 36.0F);
      ((Path)localObject).lineTo(64.0F, 36.0F);
      ((Path)localObject).lineTo(56.0F, 44.0F);
      ((Path)localObject).lineTo(56.0F, 56.0F);
      ((Path)localObject).lineTo(68.0F, 68.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 69.0F);
      ((Path)localObject).cubicTo(19.024445F, 63.343204F, 16.0F, 55.918941F, 16.0F, 48.0F);
      ((Path)localObject).cubicTo(16.0F, 46.501648F, 16.083111F, 45.241016F, 16.0F, 44.0F);
      ((Path)localObject).lineTo(24.0F, 52.0F);
      ((Path)localObject).lineTo(24.0F, 69.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 8.0F);
      ((Path)localObject).cubicTo(25.908443F, 8.0F, 8.0F, 25.908443F, 8.0F, 48.0F);
      ((Path)localObject).cubicTo(8.0F, 70.091553F, 25.908443F, 88.0F, 48.0F, 88.0F);
      ((Path)localObject).cubicTo(70.091553F, 88.0F, 88.0F, 70.091553F, 88.0F, 48.0F);
      ((Path)localObject).cubicTo(88.0F, 25.908443F, 70.091553F, 8.0F, 48.0F, 8.0F);
      ((Path)localObject).lineTo(48.0F, 8.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.lo
 * JD-Core Version:    0.7.0.1
 */