package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class brp
  extends c
{
  private final int height = 42;
  private final int width = 42;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 42;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -109.0F, 0.0F, 1.0F, -88.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 109.0F, 0.0F, 1.0F, 88.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(14211288);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(42.0F, 0.0F);
      ((Path)localObject2).lineTo(42.0F, 42.0F);
      ((Path)localObject2).lineTo(0.0F, 42.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16339626);
      ((Paint)localObject1).setStrokeWidth(3.0F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 9.0F);
      ((Path)localObject2).lineTo(19.939341F, 19.939341F);
      ((Path)localObject2).cubicTo(20.525126F, 20.525126F, 21.474874F, 20.525126F, 22.060659F, 19.939341F);
      ((Path)localObject2).lineTo(33.0F, 9.0F);
      ((Path)localObject2).lineTo(33.0F, 9.0F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16339626);
      localPaint.setStrokeWidth(3.0F);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(9.0F, 24.0F);
      ((Path)localObject1).lineTo(19.939341F, 34.939339F);
      ((Path)localObject1).cubicTo(20.525126F, 35.525127F, 21.474874F, 35.525127F, 22.060659F, 34.939339F);
      ((Path)localObject1).lineTo(33.0F, 24.0F);
      ((Path)localObject1).lineTo(33.0F, 24.0F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.brp
 * JD-Core Version:    0.7.0.1
 */