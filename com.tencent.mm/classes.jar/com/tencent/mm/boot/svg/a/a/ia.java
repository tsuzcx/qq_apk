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

public final class ia
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localPaint.setColor(-16139513);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(26.0F, 23.171574F);
      ((Path)localObject).lineTo(33.899494F, 31.071068F);
      ((Path)localObject).cubicTo(34.680542F, 31.852116F, 34.680542F, 33.118446F, 33.899494F, 33.899494F);
      ((Path)localObject).cubicTo(33.118446F, 34.680542F, 31.852116F, 34.680542F, 31.071068F, 33.899494F);
      ((Path)localObject).lineTo(22.585787F, 25.414213F);
      ((Path)localObject).cubicTo(22.390524F, 25.218952F, 22.244078F, 24.993359F, 22.146446F, 24.752602F);
      ((Path)localObject).cubicTo(22.055964F, 24.539213F, 22.0F, 24.276142F, 22.0F, 24.0F);
      ((Path)localObject).lineTo(22.0F, 16.0F);
      ((Path)localObject).cubicTo(22.0F, 14.895431F, 22.89543F, 14.0F, 24.0F, 14.0F);
      ((Path)localObject).cubicTo(25.10457F, 14.0F, 26.0F, 14.895431F, 26.0F, 16.0F);
      ((Path)localObject).lineTo(26.0F, 23.171574F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.727272F, 48.0F);
      ((Path)localObject).cubicTo(10.745166F, 48.0F, 0.0F, 37.254833F, 0.0F, 24.727272F);
      ((Path)localObject).cubicTo(0.0F, 10.745166F, 10.745166F, 0.0F, 24.727272F, 0.0F);
      ((Path)localObject).cubicTo(37.254833F, 0.0F, 48.0F, 10.745166F, 48.0F, 24.727272F);
      ((Path)localObject).cubicTo(48.0F, 37.254833F, 37.254833F, 48.0F, 24.727272F, 48.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 44.0F);
      ((Path)localObject).cubicTo(35.045696F, 44.0F, 44.0F, 35.045696F, 44.0F, 24.0F);
      ((Path)localObject).cubicTo(44.0F, 12.954305F, 35.045696F, 4.0F, 24.0F, 4.0F);
      ((Path)localObject).cubicTo(12.954305F, 4.0F, 4.0F, 12.954305F, 4.0F, 24.0F);
      ((Path)localObject).cubicTo(4.0F, 35.045696F, 12.954305F, 44.0F, 24.0F, 44.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ia
 * JD-Core Version:    0.7.0.1
 */