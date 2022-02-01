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

public final class bos
  extends c
{
  private final int height = 24;
  private final int width = 14;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 14;
      return 24;
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
      localPaint1 = c.a(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.SQUARE);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-7039852);
      localPaint1.setStrokeWidth(1.333333F);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -297.0F, 0.0F, 1.0F, -1097.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(309.19489F, 1109.0F);
      ((Path)localObject2).lineTo(309.33334F, 1108.8616F);
      ((Path)localObject2).lineTo(309.09744F, 1108.6256F);
      ((Path)localObject2).lineTo(298.70767F, 1098.2358F);
      ((Path)localObject2).lineTo(298.47177F, 1098.0F);
      ((Path)localObject2).lineTo(298.0F, 1098.4718F);
      ((Path)localObject2).lineTo(298.2359F, 1098.7076F);
      ((Path)localObject2).lineTo(308.52823F, 1109.0F);
      ((Path)localObject2).lineTo(298.2359F, 1119.2924F);
      ((Path)localObject2).lineTo(298.0F, 1119.5282F);
      ((Path)localObject2).lineTo(298.47177F, 1120.0F);
      ((Path)localObject2).lineTo(298.70767F, 1119.7642F);
      ((Path)localObject2).lineTo(309.09744F, 1109.3744F);
      ((Path)localObject2).lineTo(309.33334F, 1109.1384F);
      ((Path)localObject2).lineTo(309.19489F, 1109.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bos
 * JD-Core Version:    0.7.0.1
 */