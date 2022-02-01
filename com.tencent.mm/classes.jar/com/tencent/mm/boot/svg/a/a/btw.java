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

public final class btw
  extends c
{
  private final int height = 101;
  private final int width = 200;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 200;
      return 101;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Object localObject3 = c.m(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      localPaint = c.a(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localPaint.setColor(436207616);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -192.0F, 0.0F, 1.0F, -236.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject3, paramVarArgs);
      localObject2 = c.a(localPaint, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(192.5F, 244.5F);
      ((Path)localObject3).cubicTo(192.5F, 240.08173F, 196.08173F, 236.5F, 200.5F, 236.5F);
      ((Path)localObject3).lineTo(383.5F, 236.5F);
      ((Path)localObject3).cubicTo(387.91827F, 236.5F, 391.5F, 240.08173F, 391.5F, 244.5F);
      ((Path)localObject3).lineTo(391.5F, 328.5F);
      ((Path)localObject3).cubicTo(391.5F, 332.91827F, 387.91827F, 336.5F, 383.5F, 336.5F);
      ((Path)localObject3).lineTo(200.5F, 336.5F);
      ((Path)localObject3).cubicTo(196.08173F, 336.5F, 192.5F, 332.91827F, 192.5F, 328.5F);
      ((Path)localObject3).lineTo(192.5F, 244.5F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.btw
 * JD-Core Version:    0.7.0.1
 */