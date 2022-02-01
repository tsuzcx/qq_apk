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

public final class bas
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.m(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.a((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(32.0F, 0.0F);
      ((Path)localObject3).lineTo(32.0F, 32.0F);
      ((Path)localObject3).lineTo(0.0F, 32.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 1.0F);
      ((Path)localObject2).cubicTo(0.0F, 0.4477152F, 0.4477152F, 0.0F, 1.0F, 0.0F);
      ((Path)localObject2).lineTo(3.0F, 0.0F);
      ((Path)localObject2).cubicTo(3.552285F, 0.0F, 4.0F, 0.4477152F, 4.0F, 1.0F);
      ((Path)localObject2).lineTo(4.0F, 13.0F);
      ((Path)localObject2).cubicTo(4.0F, 13.552285F, 3.552285F, 14.0F, 3.0F, 14.0F);
      ((Path)localObject2).lineTo(1.0F, 14.0F);
      ((Path)localObject2).cubicTo(0.4477152F, 14.0F, 0.0F, 13.552285F, 0.0F, 13.0F);
      ((Path)localObject2).lineTo(0.0F, 1.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(8.0F, 1.0F);
      ((Path)localObject2).cubicTo(8.0F, 0.4477152F, 8.447715F, 0.0F, 9.0F, 0.0F);
      ((Path)localObject2).lineTo(11.0F, 0.0F);
      ((Path)localObject2).cubicTo(11.552285F, 0.0F, 12.0F, 0.4477152F, 12.0F, 1.0F);
      ((Path)localObject2).lineTo(12.0F, 13.0F);
      ((Path)localObject2).cubicTo(12.0F, 13.552285F, 11.552285F, 14.0F, 11.0F, 14.0F);
      ((Path)localObject2).lineTo(9.0F, 14.0F);
      ((Path)localObject2).cubicTo(8.447715F, 14.0F, 8.0F, 13.552285F, 8.0F, 13.0F);
      ((Path)localObject2).lineTo(8.0F, 1.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bas
 * JD-Core Version:    0.7.0.1
 */