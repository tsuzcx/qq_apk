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

public final class ml
  extends c
{
  private final int height = 115;
  private final int width = 115;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 115;
      return 115;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.i(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -1018.0F, 0.0F, 1.0F, -386.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 1018.0F, 0.0F, 1.0F, 386.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(1275068416);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(57.5F, 0.0F);
      ((Path)localObject3).cubicTo(89.256378F, 0.0F, 115.0F, 25.743626F, 115.0F, 57.5F);
      ((Path)localObject3).cubicTo(115.0F, 89.256378F, 89.256378F, 115.0F, 57.5F, 115.0F);
      ((Path)localObject3).cubicTo(25.743626F, 115.0F, 0.0F, 89.256378F, 0.0F, 57.5F);
      ((Path)localObject3).cubicTo(0.0F, 25.743626F, 25.743626F, 0.0F, 57.5F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      ((Paint)localObject1).setStrokeWidth(6.0F);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(57.5F, 3.0F);
      ((Path)localObject2).cubicTo(87.599518F, 3.0F, 112.0F, 27.40048F, 112.0F, 57.5F);
      ((Path)localObject2).cubicTo(112.0F, 87.599518F, 87.599518F, 112.0F, 57.5F, 112.0F);
      ((Path)localObject2).cubicTo(27.40048F, 112.0F, 3.0F, 87.599518F, 3.0F, 57.5F);
      ((Path)localObject2).cubicTo(3.0F, 27.40048F, 27.40048F, 3.0F, 57.5F, 3.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(41.0F, 43.0F);
      ((Path)localObject1).cubicTo(41.0F, 41.895432F, 41.895432F, 41.0F, 43.0F, 41.0F);
      ((Path)localObject1).lineTo(72.0F, 41.0F);
      ((Path)localObject1).cubicTo(73.104568F, 41.0F, 74.0F, 41.895432F, 74.0F, 43.0F);
      ((Path)localObject1).lineTo(74.0F, 72.0F);
      ((Path)localObject1).cubicTo(74.0F, 73.104568F, 73.104568F, 74.0F, 72.0F, 74.0F);
      ((Path)localObject1).lineTo(43.0F, 74.0F);
      ((Path)localObject1).cubicTo(41.895432F, 74.0F, 41.0F, 73.104568F, 41.0F, 72.0F);
      ((Path)localObject1).lineTo(41.0F, 43.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ml
 * JD-Core Version:    0.7.0.1
 */