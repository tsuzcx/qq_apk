package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bgb
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      localPaint1.setColor(-13421773);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 48.0F, 0.0F, 1.0F, 48.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(45.781845F, 85.015457F);
      ((Path)localObject2).cubicTo(45.781845F, 85.015457F, 18.0F, 61.568542F, 18.0F, 39.0F);
      ((Path)localObject2).cubicTo(18.0F, 22.431458F, 31.431458F, 9.0F, 48.0F, 9.0F);
      ((Path)localObject2).cubicTo(64.568542F, 9.0F, 78.0F, 22.431458F, 78.0F, 39.0F);
      ((Path)localObject2).cubicTo(78.0F, 61.568542F, 50.230366F, 85.004189F, 50.230366F, 85.004189F);
      ((Path)localObject2).cubicTo(49.015343F, 86.108948F, 47.006897F, 86.111488F, 45.781845F, 85.015457F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(48.0F, 51.0F);
      ((Path)localObject2).cubicTo(54.627419F, 51.0F, 60.0F, 45.627419F, 60.0F, 39.0F);
      ((Path)localObject2).cubicTo(60.0F, 32.372581F, 54.627419F, 27.0F, 48.0F, 27.0F);
      ((Path)localObject2).cubicTo(41.372581F, 27.0F, 36.0F, 32.372581F, 36.0F, 39.0F);
      ((Path)localObject2).cubicTo(36.0F, 45.627419F, 41.372581F, 51.0F, 48.0F, 51.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bgb
 * JD-Core Version:    0.7.0.1
 */