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

public final class ur
  extends c
{
  private final int height = 70;
  private final int width = 70;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 70;
      return 70;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.h(paramVarArgs);
      Object localObject3 = c.g(paramVarArgs);
      Object localObject1 = c.k(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 172, 4);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -145.0F, 0.0F, 1.0F, -231.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 144.0F, 0.0F, 1.0F, 230.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-5526613);
      ((Paint)localObject2).setStrokeWidth(3.6F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(33.0F, 27.0F);
      ((Path)localObject3).lineTo(33.0F, 36.0F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-5526613);
      ((Paint)localObject2).setStrokeWidth(3.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(24.0F, 42.0F);
      ((Path)localObject3).cubicTo(26.185297F, 43.986816F, 29.185297F, 44.980225F, 33.0F, 44.980225F);
      ((Path)localObject3).cubicTo(36.814701F, 44.980225F, 39.814701F, 43.986816F, 42.0F, 42.0F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-5526613);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(21.0F, 21.0F);
      ((Path)localObject3).cubicTo(22.656855F, 21.0F, 24.0F, 22.343145F, 24.0F, 24.0F);
      ((Path)localObject3).cubicTo(24.0F, 25.656855F, 22.656855F, 27.0F, 21.0F, 27.0F);
      ((Path)localObject3).cubicTo(19.343145F, 27.0F, 18.0F, 25.656855F, 18.0F, 24.0F);
      ((Path)localObject3).cubicTo(18.0F, 22.343145F, 19.343145F, 21.0F, 21.0F, 21.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-5526613);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(45.0F, 21.0F);
      ((Path)localObject2).cubicTo(46.656853F, 21.0F, 48.0F, 22.343145F, 48.0F, 24.0F);
      ((Path)localObject2).cubicTo(48.0F, 25.656855F, 46.656853F, 27.0F, 45.0F, 27.0F);
      ((Path)localObject2).cubicTo(43.343147F, 27.0F, 42.0F, 25.656855F, 42.0F, 24.0F);
      ((Path)localObject2).cubicTo(42.0F, 22.343145F, 43.343147F, 21.0F, 45.0F, 21.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-5526613);
      localPaint.setStrokeWidth(3.6F);
      localPaint.setStrokeCap(Paint.Cap.ROUND);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 18.0F);
      ((Path)localObject1).lineTo(0.0F, 9.0F);
      ((Path)localObject1).cubicTo(-6.661338E-016F, 4.029437F, 4.029437F, 6.661338E-016F, 9.0F, 0.0F);
      ((Path)localObject1).cubicTo(13.047688F, 0.0F, 15.976155F, 0.0F, 18.0F, 0.0F);
      ((Path)localObject1).moveTo(48.0F, 0.0F);
      ((Path)localObject1).cubicTo(49.891644F, 0.0F, 52.935345F, 0.0F, 57.0F, 0.0F);
      ((Path)localObject1).cubicTo(61.970562F, -9.992007E-016F, 66.0F, 4.029437F, 66.0F, 9.0F);
      ((Path)localObject1).cubicTo(66.0F, 13.024577F, 66.0F, 15.987712F, 66.0F, 18.0F);
      ((Path)localObject1).moveTo(66.0F, 48.0F);
      ((Path)localObject1).cubicTo(66.0F, 49.887749F, 66.0F, 52.944878F, 66.0F, 57.0F);
      ((Path)localObject1).cubicTo(66.0F, 61.970562F, 61.970562F, 66.0F, 57.0F, 66.0F);
      ((Path)localObject1).cubicTo(52.984539F, 66.0F, 50.007732F, 66.0F, 48.0F, 66.0F);
      ((Path)localObject1).moveTo(18.0F, 66.0F);
      ((Path)localObject1).cubicTo(16.081131F, 66.0F, 13.127518F, 66.0F, 9.0F, 66.0F);
      ((Path)localObject1).cubicTo(4.029437F, 66.0F, 6.661338E-016F, 61.970562F, 0.0F, 57.0F);
      ((Path)localObject1).lineTo(0.0F, 48.0F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ur
 * JD-Core Version:    0.7.0.1
 */