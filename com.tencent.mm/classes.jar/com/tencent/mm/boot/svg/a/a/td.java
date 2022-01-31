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

public final class td
  extends c
{
  private final int height = 8;
  private final int width = 242;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 242;
      return 8;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1498304079);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(119.5F, 0.0F);
      ((Path)localObject2).cubicTo(121.433F, 0.0F, 123.0F, 1.567003F, 123.0F, 3.5F);
      ((Path)localObject2).cubicTo(123.0F, 5.432997F, 121.433F, 7.0F, 119.5F, 7.0F);
      ((Path)localObject2).cubicTo(117.567F, 7.0F, 116.0F, 5.432997F, 116.0F, 3.5F);
      ((Path)localObject2).cubicTo(116.0F, 1.567003F, 117.567F, 0.0F, 119.5F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1716407887);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.SQUARE);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(130.5F, 3.5F);
      ((Path)localObject2).lineTo(238.51852F, 3.5F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1716407887);
      localPaint.setStrokeCap(Paint.Cap.SQUARE);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(0.5F, 3.5F);
      ((Path)localObject1).lineTo(108.51852F, 3.5F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.td
 * JD-Core Version:    0.7.0.1
 */