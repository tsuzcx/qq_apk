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

public final class dp
  extends c
{
  private final int height = 96;
  private final int width = 130;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 130;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -238.0F, 0.0F, 1.0F, -292.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 238.0F, 0.0F, 1.0F, 292.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(61.0F, 44.0F);
      ((Path)localObject2).lineTo(61.0F, 50.0F);
      ((Path)localObject2).cubicTo(61.0F, 58.22929F, 67.939583F, 65.0F, 77.0F, 65.0F);
      ((Path)localObject2).cubicTo(85.060417F, 65.0F, 92.0F, 58.22929F, 92.0F, 50.0F);
      ((Path)localObject2).lineTo(92.0F, 44.0F);
      ((Path)localObject2).lineTo(94.996758F, 44.0F);
      ((Path)localObject2).cubicTo(95.562012F, 44.0F, 96.0F, 44.450371F, 96.0F, 45.005928F);
      ((Path)localObject2).lineTo(96.0F, 50.25F);
      ((Path)localObject2).cubicTo(96.0F, 60.017532F, 88.365898F, 67.913139F, 79.0F, 68.896767F);
      ((Path)localObject2).lineTo(79.0F, 72.0F);
      ((Path)localObject2).lineTo(91.003685F, 72.0F);
      ((Path)localObject2).cubicTo(91.561775F, 72.0F, 92.0F, 72.451912F, 92.0F, 73.009369F);
      ((Path)localObject2).lineTo(92.0F, 74.990631F);
      ((Path)localObject2).cubicTo(92.0F, 75.556648F, 91.553932F, 76.0F, 91.003685F, 76.0F);
      ((Path)localObject2).lineTo(61.996315F, 76.0F);
      ((Path)localObject2).cubicTo(61.438225F, 76.0F, 61.0F, 75.548088F, 61.0F, 74.990631F);
      ((Path)localObject2).lineTo(61.0F, 73.009369F);
      ((Path)localObject2).cubicTo(61.0F, 72.443352F, 61.446064F, 72.0F, 61.996315F, 72.0F);
      ((Path)localObject2).lineTo(74.0F, 72.0F);
      ((Path)localObject2).lineTo(74.0F, 68.796776F);
      ((Path)localObject2).cubicTo(64.208183F, 67.464806F, 57.0F, 59.741146F, 57.0F, 50.25F);
      ((Path)localObject2).lineTo(57.0F, 44.997505F);
      ((Path)localObject2).cubicTo(57.0F, 44.447468F, 57.449165F, 44.0F, 58.003242F, 44.0F);
      ((Path)localObject2).lineTo(61.0F, 44.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(76.5F, 21.0F);
      ((Path)localObject2).cubicTo(82.300262F, 21.0F, 87.0F, 25.705276F, 87.0F, 31.509529F);
      ((Path)localObject2).lineTo(87.0F, 50.490471F);
      ((Path)localObject2).cubicTo(87.0F, 56.293869F, 82.298988F, 61.0F, 76.5F, 61.0F);
      ((Path)localObject2).cubicTo(70.699738F, 61.0F, 66.0F, 56.294724F, 66.0F, 50.490471F);
      ((Path)localObject2).lineTo(66.0F, 31.509529F);
      ((Path)localObject2).cubicTo(66.0F, 25.706133F, 70.701012F, 21.0F, 76.5F, 21.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.dp
 * JD-Core Version:    0.7.0.1
 */