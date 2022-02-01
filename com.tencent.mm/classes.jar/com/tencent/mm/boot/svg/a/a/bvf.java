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

public final class bvf
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 0.96F, 0.0F, 0.0F, 0.0F, 0.96F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.2F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(23.4F, 12.148149F);
      ((Path)localObject2).cubicTo(23.4F, 5.703816F, 18.296185F, 0.6000004F, 11.851851F, 0.6000004F);
      ((Path)localObject2).cubicTo(5.660699F, 0.6000004F, 0.5999994F, 5.747756F, 0.5999994F, 12.148149F);
      ((Path)localObject2).cubicTo(0.5999994F, 18.296185F, 5.703815F, 23.400002F, 11.851851F, 23.400002F);
      ((Path)localObject2).cubicTo(18.252245F, 23.400002F, 23.4F, 18.339302F, 23.4F, 12.148149F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.drawPath((Path)localObject2, c.a((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bvf
 * JD-Core Version:    0.7.0.1
 */