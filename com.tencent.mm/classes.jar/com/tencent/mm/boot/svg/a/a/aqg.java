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

public final class aqg
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617594);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 46.0F, 0.0F, 1.0F, 41.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(58.043381F, 85.021919F);
      ((Path)localObject2).cubicTo(68.832481F, 74.173447F, 75.5F, 59.221767F, 75.5F, 42.712807F);
      ((Path)localObject2).cubicTo(75.5F, 25.998095F, 68.665253F, 10.879722F, 57.638073F, 5.118483E-011F);
      ((Path)localObject2).lineTo(50.213249F, 7.424826F);
      ((Path)localObject2).cubicTo(59.340397F, 16.404242F, 65.0F, 28.897589F, 65.0F, 42.712807F);
      ((Path)localObject2).cubicTo(65.0F, 56.322273F, 59.507717F, 68.648949F, 50.618725F, 77.59726F);
      ((Path)localObject2).lineTo(58.043381F, 85.021919F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.012039F, 66.990578F);
      ((Path)localObject2).cubicTo(46.186604F, 60.756802F, 50.0F, 52.180138F, 50.0F, 42.712807F);
      ((Path)localObject2).cubicTo(50.0F, 33.039722F, 46.019051F, 24.29644F, 39.606136F, 18.031939F);
      ((Path)localObject2).lineTo(32.180779F, 25.457294F);
      ((Path)localObject2).cubicTo(36.693905F, 29.821022F, 39.5F, 35.939213F, 39.5F, 42.712807F);
      ((Path)localObject2).cubicTo(39.5F, 49.280643F, 36.86179F, 55.232292F, 32.587296F, 59.565834F);
      ((Path)localObject2).lineTo(40.012039F, 66.990578F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.0F, 55.5F);
      ((Path)localObject2).cubicTo(20.179701F, 55.5F, 26.0F, 49.679703F, 26.0F, 42.5F);
      ((Path)localObject2).cubicTo(26.0F, 35.320297F, 20.179701F, 29.5F, 13.0F, 29.5F);
      ((Path)localObject2).cubicTo(5.820298F, 29.5F, 0.0F, 35.320297F, 0.0F, 42.5F);
      ((Path)localObject2).cubicTo(0.0F, 49.679703F, 5.820298F, 55.5F, 13.0F, 55.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqg
 * JD-Core Version:    0.7.0.1
 */