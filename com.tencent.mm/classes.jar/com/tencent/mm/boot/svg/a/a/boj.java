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

public final class boj
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(50.0F, 100.0F);
      ((Path)localObject2).cubicTo(22.385763F, 100.0F, 0.0F, 77.614235F, 0.0F, 50.0F);
      ((Path)localObject2).cubicTo(0.0F, 22.385763F, 22.385763F, 0.0F, 50.0F, 0.0F);
      ((Path)localObject2).cubicTo(77.614235F, 0.0F, 100.0F, 22.385763F, 100.0F, 50.0F);
      ((Path)localObject2).cubicTo(100.0F, 77.614235F, 77.614235F, 100.0F, 50.0F, 100.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(50.0F, 94.0F);
      ((Path)localObject2).cubicTo(74.300529F, 94.0F, 94.0F, 74.300529F, 94.0F, 50.0F);
      ((Path)localObject2).cubicTo(94.0F, 25.699471F, 74.300529F, 6.0F, 50.0F, 6.0F);
      ((Path)localObject2).cubicTo(25.699471F, 6.0F, 6.0F, 25.699471F, 6.0F, 50.0F);
      ((Path)localObject2).cubicTo(6.0F, 74.300529F, 25.699471F, 94.0F, 50.0F, 94.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(54.242641F, 49.999996F);
      ((Path)localObject2).lineTo(69.798988F, 65.556351F);
      ((Path)localObject2).lineTo(65.556351F, 69.798988F);
      ((Path)localObject2).lineTo(50.0F, 54.242638F);
      ((Path)localObject2).lineTo(34.443649F, 69.798988F);
      ((Path)localObject2).lineTo(30.20101F, 65.556351F);
      ((Path)localObject2).lineTo(45.757359F, 49.999996F);
      ((Path)localObject2).lineTo(30.201012F, 34.443649F);
      ((Path)localObject2).lineTo(34.443653F, 30.20101F);
      ((Path)localObject2).lineTo(50.0F, 45.757355F);
      ((Path)localObject2).lineTo(65.556351F, 30.20101F);
      ((Path)localObject2).lineTo(69.798988F, 34.443649F);
      ((Path)localObject2).lineTo(54.242641F, 49.999996F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.boj
 * JD-Core Version:    0.7.0.1
 */