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

public final class byx
  extends c
{
  private final int height = 12;
  private final int width = 12;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 12;
      return 12;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -159.0F, 0.0F, 1.0F, -226.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 80.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 32.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 159.0F, 0.0F, 1.0F, 114.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(12.0F, 0.0F);
      ((Path)localObject).lineTo(12.0F, 12.0F);
      ((Path)localObject).lineTo(0.0F, 12.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-2130706433);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(6.339408F, 10.0F);
      ((Path)localObject).lineTo(6.339408F, 6.095469F);
      ((Path)localObject).lineTo(7.52F, 7.30973F);
      ((Path)localObject).lineTo(8.0F, 6.816041F);
      ((Path)localObject).lineTo(6.4F, 5.170411F);
      ((Path)localObject).cubicTo(6.179086F, 4.943196F, 5.820914F, 4.943196F, 5.6F, 5.170411F);
      ((Path)localObject).lineTo(4.0F, 6.816041F);
      ((Path)localObject).lineTo(4.48F, 7.30973F);
      ((Path)localObject).lineTo(5.660585F, 6.095476F);
      ((Path)localObject).lineTo(5.660585F, 10.0F);
      ((Path)localObject).lineTo(2.666667F, 10.0F);
      ((Path)localObject).cubicTo(1.193907F, 10.0F, 0.0F, 8.806092F, 0.0F, 7.333334F);
      ((Path)localObject).cubicTo(0.0F, 5.860574F, 1.193907F, 4.666667F, 2.666667F, 4.666667F);
      ((Path)localObject).cubicTo(2.688903F, 4.666667F, 2.711075F, 4.666939F, 2.733181F, 4.66748F);
      ((Path)localObject).cubicTo(3.041713F, 3.145581F, 4.387074F, 2.0F, 6.0F, 2.0F);
      ((Path)localObject).cubicTo(7.840949F, 2.0F, 9.333333F, 3.492384F, 9.333333F, 5.333334F);
      ((Path)localObject).cubicTo(9.333333F, 5.34122F, 9.333306F, 5.349101F, 9.333251F, 5.356975F);
      ((Path)localObject).cubicTo(9.442145F, 5.341395F, 9.553465F, 5.333334F, 9.666667F, 5.333334F);
      ((Path)localObject).cubicTo(10.955331F, 5.333334F, 12.0F, 6.378002F, 12.0F, 7.666667F);
      ((Path)localObject).cubicTo(12.0F, 8.955331F, 10.955331F, 10.0F, 9.666667F, 10.0F);
      ((Path)localObject).lineTo(6.339408F, 10.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.byx
 * JD-Core Version:    0.7.0.1
 */