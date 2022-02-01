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

public final class bzc
  extends c
{
  private final int height = 255;
  private final int width = 255;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 255;
      return 255;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 74.0F, 0.0F, 1.0F, 65.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(98.000374F, 0.0F);
      ((Path)localObject2).lineTo(21.999622F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 0.0F);
      ((Path)localObject2).lineTo(12.0F, 12.0F);
      ((Path)localObject2).lineTo(12.0F, 10.000714F);
      ((Path)localObject2).lineTo(12.0F, 126.0F);
      ((Path)localObject2).lineTo(108.0F, 126.0F);
      ((Path)localObject2).lineTo(108.0F, 10.000714F);
      ((Path)localObject2).lineTo(108.0F, 12.0F);
      ((Path)localObject2).lineTo(96.0F, 0.0F);
      ((Path)localObject2).lineTo(98.000374F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(108.0F, 114.0F);
      ((Path)localObject2).lineTo(96.0F, 126.0F);
      ((Path)localObject2).lineTo(108.0F, 126.0F);
      ((Path)localObject2).lineTo(108.0F, 114.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 48.0F);
      ((Path)localObject2).lineTo(12.0F, 48.0F);
      ((Path)localObject2).lineTo(12.0F, 126.0F);
      ((Path)localObject2).lineTo(0.0F, 126.0F);
      ((Path)localObject2).lineTo(0.0F, 48.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 114.0F);
      ((Path)localObject2).lineTo(12.0F, 126.0F);
      ((Path)localObject2).lineTo(0.0F, 126.0F);
      ((Path)localObject2).lineTo(0.0F, 114.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 60.0F);
      ((Path)localObject2).lineTo(12.0F, 48.0F);
      ((Path)localObject2).lineTo(0.0F, 48.0F);
      ((Path)localObject2).lineTo(0.0F, 60.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 12.0F);
      ((Path)localObject2).lineTo(48.0F, 12.0F);
      ((Path)localObject2).lineTo(48.0F, 42.0F);
      ((Path)localObject2).lineTo(36.0F, 42.0F);
      ((Path)localObject2).lineTo(36.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(54.0F, 12.0F);
      ((Path)localObject2).lineTo(66.0F, 12.0F);
      ((Path)localObject2).lineTo(66.0F, 42.0F);
      ((Path)localObject2).lineTo(54.0F, 42.0F);
      ((Path)localObject2).lineTo(54.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(72.0F, 12.0F);
      ((Path)localObject2).lineTo(84.0F, 12.0F);
      ((Path)localObject2).lineTo(84.0F, 42.0F);
      ((Path)localObject2).lineTo(72.0F, 42.0F);
      ((Path)localObject2).lineTo(72.0F, 12.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bzc
 * JD-Core Version:    0.7.0.1
 */