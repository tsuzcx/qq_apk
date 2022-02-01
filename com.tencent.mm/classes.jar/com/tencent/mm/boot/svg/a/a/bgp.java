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

public final class bgp
  extends c
{
  private final int height = 10;
  private final int width = 9;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 9;
      return 10;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
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
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -162.0F, 0.0F, 1.0F, -172.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 162.0F, 0.0F, 1.0F, 172.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 1.0F);
      ((Path)localObject3).cubicTo(0.0F, 0.4477152F, 0.4477152F, 0.0F, 1.0F, 0.0F);
      ((Path)localObject3).lineTo(2.0F, 0.0F);
      ((Path)localObject3).cubicTo(2.552285F, 0.0F, 3.0F, 0.4477152F, 3.0F, 1.0F);
      ((Path)localObject3).lineTo(3.0F, 9.0F);
      ((Path)localObject3).cubicTo(3.0F, 9.552285F, 2.552285F, 10.0F, 2.0F, 10.0F);
      ((Path)localObject3).lineTo(1.0F, 10.0F);
      ((Path)localObject3).cubicTo(0.4477152F, 10.0F, 0.0F, 9.552285F, 0.0F, 9.0F);
      ((Path)localObject3).lineTo(0.0F, 1.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(6.0F, 1.0F);
      ((Path)localObject2).cubicTo(6.0F, 0.4477152F, 6.447715F, 0.0F, 7.0F, 0.0F);
      ((Path)localObject2).lineTo(8.0F, 0.0F);
      ((Path)localObject2).cubicTo(8.552285F, 0.0F, 9.0F, 0.4477152F, 9.0F, 1.0F);
      ((Path)localObject2).lineTo(9.0F, 9.0F);
      ((Path)localObject2).cubicTo(9.0F, 9.552285F, 8.552285F, 10.0F, 8.0F, 10.0F);
      ((Path)localObject2).lineTo(7.0F, 10.0F);
      ((Path)localObject2).cubicTo(6.447715F, 10.0F, 6.0F, 9.552285F, 6.0F, 9.0F);
      ((Path)localObject2).lineTo(6.0F, 1.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bgp
 * JD-Core Version:    0.7.0.1
 */