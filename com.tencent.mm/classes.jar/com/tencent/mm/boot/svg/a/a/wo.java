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

public final class wo
  extends c
{
  private final int height = 43;
  private final int width = 43;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 43;
      return 43;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.i(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      localCanvas.save();
      localObject3 = c.a((Paint)localObject4, paramVarArgs);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      localObject4 = c.a((float[])localObject2, 1.0F, 0.0F, -57.0F, 0.0F, 1.0F, -1296.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject3, paramVarArgs);
      ((Paint)localObject2).setColor(-6710887);
      ((Paint)localObject2).setStrokeWidth(4.6F);
      localObject3 = c.a((float[])localObject4, 1.0F, 0.0F, 60.0F, 0.0F, 1.0F, 1299.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(15.0F, 0.0F);
      ((Path)localObject3).cubicTo(23.284271F, 0.0F, 30.0F, 6.715729F, 30.0F, 15.0F);
      ((Path)localObject3).cubicTo(30.0F, 23.284271F, 23.284271F, 30.0F, 15.0F, 30.0F);
      ((Path)localObject3).cubicTo(6.715729F, 30.0F, 0.0F, 23.284271F, 0.0F, 15.0F);
      ((Path)localObject3).cubicTo(0.0F, 6.715729F, 6.715729F, 0.0F, 15.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.SQUARE);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(26.5F, 26.5F);
      ((Path)localObject2).lineTo(36.0F, 36.0F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.wo
 * JD-Core Version:    0.7.0.1
 */