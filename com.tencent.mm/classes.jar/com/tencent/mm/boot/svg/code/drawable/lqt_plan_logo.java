package com.tencent.mm.boot.svg.code.drawable;

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

public class lqt_plan_logo
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.333333F, 0.0F, 1.0F, 5.333333F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-871936);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(32.360928F, 33.960926F);
      ((Path)localObject2).lineTo(25.066666F, 26.666666F);
      ((Path)localObject2).lineTo(25.066666F, 10.666667F);
      ((Path)localObject2).lineTo(28.266666F, 10.666667F);
      ((Path)localObject2).lineTo(28.266666F, 25.341183F);
      ((Path)localObject2).lineTo(34.67662F, 31.751137F);
      ((Path)localObject2).cubicTo(34.125797F, 32.04063F, 33.630104F, 32.437782F, 33.222229F, 32.927273F);
      ((Path)localObject2).lineTo(32.360928F, 33.960926F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(52.44347F, 33.523678F);
      ((Path)localObject2).lineTo(51.836155F, 32.832275F);
      ((Path)localObject2).cubicTo(51.246536F, 32.161018F, 50.48835F, 31.675097F, 49.652542F, 31.415672F);
      ((Path)localObject2).cubicTo(49.967758F, 29.881962F, 50.133335F, 28.29365F, 50.133335F, 26.666666F);
      ((Path)localObject2).cubicTo(50.133335F, 13.706385F, 39.626949F, 3.2F, 26.666666F, 3.2F);
      ((Path)localObject2).cubicTo(13.706385F, 3.2F, 3.2F, 13.706385F, 3.2F, 26.666666F);
      ((Path)localObject2).cubicTo(3.2F, 39.626949F, 13.706385F, 50.133335F, 26.666666F, 50.133335F);
      ((Path)localObject2).cubicTo(29.255632F, 50.133335F, 31.746675F, 49.714081F, 34.075607F, 48.939762F);
      ((Path)localObject2).lineTo(36.17955F, 51.586544F);
      ((Path)localObject2).cubicTo(33.224854F, 52.71513F, 30.017956F, 53.333332F, 26.666666F, 53.333332F);
      ((Path)localObject2).cubicTo(11.939074F, 53.333332F, 0.0F, 41.39426F, 0.0F, 26.666666F);
      ((Path)localObject2).cubicTo(0.0F, 11.939074F, 11.939074F, 0.0F, 26.666666F, 0.0F);
      ((Path)localObject2).cubicTo(41.39426F, 0.0F, 53.333332F, 11.939074F, 53.333332F, 26.666666F);
      ((Path)localObject2).cubicTo(53.333332F, 29.037308F, 53.023991F, 31.335699F, 52.44347F, 33.523678F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(35.680626F, 34.975758F);
      ((Path)localObject2).cubicTo(35.984615F, 34.610939F, 36.434952F, 34.400002F, 36.909824F, 34.400002F);
      ((Path)localObject2).lineTo(48.229839F, 34.400002F);
      ((Path)localObject2).cubicTo(48.690151F, 34.400002F, 49.128166F, 34.598251F, 49.431946F, 34.944092F);
      ((Path)localObject2).lineTo(53.202106F, 39.236256F);
      ((Path)localObject2).cubicTo(53.714092F, 39.819126F, 53.734158F, 40.68531F, 53.249714F, 41.291267F);
      ((Path)localObject2).lineTo(43.889675F, 52.999107F);
      ((Path)localObject2).cubicTo(43.248005F, 53.801727F, 42.026894F, 53.800026F, 41.387466F, 52.995617F);
      ((Path)localObject2).lineTo(32.080837F, 41.287781F);
      ((Path)localObject2).cubicTo(31.608892F, 40.694069F, 31.618622F, 39.850586F, 32.104134F, 39.267921F);
      ((Path)localObject2).lineTo(35.680626F, 34.975758F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(35.396164F, 40.315956F);
      ((Path)localObject2).lineTo(42.643543F, 49.433231F);
      ((Path)localObject2).lineTo(49.912876F, 40.340515F);
      ((Path)localObject2).lineTo(47.505653F, 37.599998F);
      ((Path)localObject2).lineTo(37.659264F, 37.599998F);
      ((Path)localObject2).lineTo(35.396164F, 40.315956F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.lqt_plan_logo
 * JD-Core Version:    0.7.0.1
 */