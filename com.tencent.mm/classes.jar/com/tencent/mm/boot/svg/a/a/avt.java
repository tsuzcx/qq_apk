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

public final class avt
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 204, 4);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(31.0F, 0.0F);
      ((Path)localObject2).cubicTo(33.465939F, 1.562686F, 35.156239F, 3.626233F, 37.0F, 6.0F);
      ((Path)localObject2).cubicTo(29.64526F, 12.992331F, 22.293955F, 20.395054F, 15.0F, 28.0F);
      ((Path)localObject2).cubicTo(32.385746F, 28.008139F, 49.688816F, 27.938019F, 67.0F, 28.0F);
      ((Path)localObject2).cubicTo(67.011887F, 30.642668F, 67.001884F, 33.307247F, 67.0F, 36.0F);
      ((Path)localObject2).cubicTo(49.678814F, 36.001877F, 32.375744F, 35.951794F, 15.0F, 36.0F);
      ((Path)localObject2).cubicTo(22.273951F, 43.614964F, 29.795286F, 50.917515F, 37.0F, 59.0F);
      ((Path)localObject2).cubicTo(35.156239F, 60.353733F, 33.365921F, 62.166851F, 32.0F, 64.0F);
      ((Path)localObject2).cubicTo(20.973721F, 53.421818F, 10.531868F, 42.653309F, 0.0F, 32.0F);
      ((Path)localObject2).cubicTo(10.401845F, 21.266552F, 21.023729F, 10.778525F, 31.0F, 0.0F);
      ((Path)localObject2).lineTo(31.0F, 0.0F);
      ((Path)localObject2).lineTo(31.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.avt
 * JD-Core Version:    0.7.0.1
 */