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

public final class bgk
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
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 48.0F, 0.0F, 1.0F, 48.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-13421773);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(3.0F, 0.0F);
      ((Path)localObject3).lineTo(57.0F, 0.0F);
      ((Path)localObject3).cubicTo(58.656853F, -3.043592E-016F, 60.0F, 1.343146F, 60.0F, 3.0F);
      ((Path)localObject3).lineTo(60.0F, 45.0F);
      ((Path)localObject3).cubicTo(60.0F, 46.656853F, 58.656853F, 48.0F, 57.0F, 48.0F);
      ((Path)localObject3).lineTo(3.0F, 48.0F);
      ((Path)localObject3).cubicTo(1.343146F, 48.0F, 2.029061E-016F, 46.656853F, 0.0F, 45.0F);
      ((Path)localObject3).lineTo(0.0F, 3.0F);
      ((Path)localObject3).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(87.0F, 6.172391F);
      ((Path)localObject2).lineTo(87.0F, 41.82761F);
      ((Path)localObject2).cubicTo(87.0F, 43.484463F, 85.656853F, 44.82761F, 84.0F, 44.82761F);
      ((Path)localObject2).cubicTo(83.327805F, 44.82761F, 82.675095F, 44.601856F, 82.146538F, 44.186565F);
      ((Path)localObject2).lineTo(66.0F, 31.5F);
      ((Path)localObject2).lineTo(66.0F, 24.0F);
      ((Path)localObject2).lineTo(66.0F, 16.5F);
      ((Path)localObject2).lineTo(82.146538F, 3.813437F);
      ((Path)localObject2).cubicTo(83.449348F, 2.789796F, 85.335312F, 3.016112F, 86.358955F, 4.318927F);
      ((Path)localObject2).cubicTo(86.774246F, 4.847484F, 87.0F, 5.5002F, 87.0F, 6.172391F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bgk
 * JD-Core Version:    0.7.0.1
 */