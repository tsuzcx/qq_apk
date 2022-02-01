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

public final class kr
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(16777215);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(10.0F, 0.0F);
      ((Path)localObject2).cubicTo(15.522848F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      ((Path)localObject2).cubicTo(20.0F, 15.522848F, 15.522848F, 20.0F, 10.0F, 20.0F);
      ((Path)localObject2).cubicTo(4.477152F, 20.0F, 0.0F, 15.522848F, 0.0F, 10.0F);
      ((Path)localObject2).cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(1.2F);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(10.0F, 19.4F);
      ((Path)localObject1).cubicTo(15.191477F, 19.4F, 19.4F, 15.191477F, 19.4F, 10.0F);
      ((Path)localObject1).cubicTo(19.4F, 4.808523F, 15.191477F, 0.6F, 10.0F, 0.6F);
      ((Path)localObject1).cubicTo(4.808523F, 0.6F, 0.6F, 4.808523F, 0.6F, 10.0F);
      ((Path)localObject1).cubicTo(0.6F, 15.191477F, 4.808523F, 19.4F, 10.0F, 19.4F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.drawPath((Path)localObject1, c.a(localPaint, paramVarArgs));
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.kr
 * JD-Core Version:    0.7.0.1
 */