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

public final class mw
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617594);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(73.0F, 34.000179F);
      ((Path)localObject2).lineTo(73.0F, 57.000179F);
      ((Path)localObject2).cubicTo(72.900002F, 59.034679F, 71.086502F, 60.857323F, 69.0F, 61.000179F);
      ((Path)localObject2).lineTo(12.0F, 61.000179F);
      ((Path)localObject2).cubicTo(9.91305F, 60.857323F, 8.1F, 59.034679F, 8.0F, 57.000179F);
      ((Path)localObject2).lineTo(8.0F, 24.000181F);
      ((Path)localObject2).cubicTo(8.1F, 21.966133F, 9.91305F, 20.143038F, 12.0F, 20.000181F);
      ((Path)localObject2).lineTo(19.0F, 20.000181F);
      ((Path)localObject2).cubicTo(19.35F, 20.133989F, 21.7467F, 16.067085F, 29.0F, 12.00018F);
      ((Path)localObject2).lineTo(12.0F, 12.00018F);
      ((Path)localObject2).cubicTo(5.4396F, 12.00018F, 0.0F, 17.468561F, 0.0F, 24.000181F);
      ((Path)localObject2).lineTo(0.0F, 57.000179F);
      ((Path)localObject2).cubicTo(0.0F, 63.531799F, 5.4396F, 69.000183F, 12.0F, 69.000183F);
      ((Path)localObject2).lineTo(69.0F, 69.000183F);
      ((Path)localObject2).cubicTo(75.560402F, 69.000183F, 81.0F, 63.531799F, 81.0F, 57.000179F);
      ((Path)localObject2).lineTo(81.0F, 28.000181F);
      ((Path)localObject2).lineTo(73.0F, 34.000179F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(53.0F, 29.000181F);
      ((Path)localObject2).lineTo(53.0F, 41.000179F);
      ((Path)localObject2).lineTo(77.0F, 20.000181F);
      ((Path)localObject2).lineTo(53.0F, 0.0001803922F);
      ((Path)localObject2).lineTo(53.0F, 12.00018F);
      ((Path)localObject2).cubicTo(32.732662F, 12.273722F, 16.57688F, 28.172049F, 16.0F, 48.000179F);
      ((Path)localObject2).cubicTo(24.494049F, 36.795803F, 37.671848F, 29.378492F, 53.0F, 29.000181F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.mw
 * JD-Core Version:    0.7.0.1
 */