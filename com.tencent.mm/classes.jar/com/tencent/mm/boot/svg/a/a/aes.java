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

public final class aes
  extends c
{
  private final int height = 14;
  private final int width = 57;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 57;
      return 14;
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-3684404);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -799.0F, 0.0F, 1.0F, -836.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 203.0F, 0.0F, 1.0F, 793.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 596.4823F, 0.0F, 1.0F, 43.304348F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(6.461538F, 0.0F);
      ((Path)localObject2).cubicTo(10.030148F, 0.0F, 12.923077F, 2.910149F, 12.923077F, 6.5F);
      ((Path)localObject2).cubicTo(12.923077F, 10.089851F, 10.030148F, 13.0F, 6.461538F, 13.0F);
      ((Path)localObject2).cubicTo(2.892929F, 13.0F, 0.0F, 10.089851F, 0.0F, 6.5F);
      ((Path)localObject2).cubicTo(0.0F, 2.910149F, 2.892929F, 0.0F, 6.461538F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(28.0F, 0.0F);
      ((Path)localObject2).cubicTo(31.568609F, 0.0F, 34.46154F, 2.910149F, 34.46154F, 6.5F);
      ((Path)localObject2).cubicTo(34.46154F, 10.089851F, 31.568609F, 13.0F, 28.0F, 13.0F);
      ((Path)localObject2).cubicTo(24.431391F, 13.0F, 21.538462F, 10.089851F, 21.538462F, 6.5F);
      ((Path)localObject2).cubicTo(21.538462F, 2.910149F, 24.431391F, 0.0F, 28.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(49.53846F, 0.0F);
      ((Path)localObject1).cubicTo(53.107071F, 0.0F, 56.0F, 2.910149F, 56.0F, 6.5F);
      ((Path)localObject1).cubicTo(56.0F, 10.089851F, 53.107071F, 13.0F, 49.53846F, 13.0F);
      ((Path)localObject1).cubicTo(45.969849F, 13.0F, 43.07692F, 10.089851F, 43.07692F, 6.5F);
      ((Path)localObject1).cubicTo(43.07692F, 2.910149F, 45.969849F, 0.0F, 49.53846F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aes
 * JD-Core Version:    0.7.0.1
 */