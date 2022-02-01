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

public final class er
  extends c
{
  private final int height = 58;
  private final int width = 58;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 58;
      return 58;
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
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -58.0F, 0.0F, 1.0F, -148.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 58.0F, 0.0F, 1.0F, 148.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(29.0F, 58.0F);
      ((Path)localObject3).cubicTo(45.016258F, 58.0F, 58.0F, 45.016258F, 58.0F, 29.0F);
      ((Path)localObject3).cubicTo(58.0F, 12.983743F, 45.016258F, 0.0F, 29.0F, 0.0F);
      ((Path)localObject3).cubicTo(12.983743F, 0.0F, 0.0F, 12.983743F, 0.0F, 29.0F);
      ((Path)localObject3).cubicTo(0.0F, 45.016258F, 12.983743F, 58.0F, 29.0F, 58.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(29.0F, 52.0F);
      ((Path)localObject3).cubicTo(41.702549F, 52.0F, 52.0F, 41.702549F, 52.0F, 29.0F);
      ((Path)localObject3).cubicTo(52.0F, 16.297451F, 41.702549F, 6.0F, 29.0F, 6.0F);
      ((Path)localObject3).cubicTo(16.297451F, 6.0F, 6.0F, 16.297451F, 6.0F, 29.0F);
      ((Path)localObject3).cubicTo(6.0F, 41.702549F, 16.297451F, 52.0F, 29.0F, 52.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(29.974895F, 27.246653F);
      ((Path)localObject2).lineTo(29.217737F, 14.251846F);
      ((Path)localObject2).cubicTo(29.19401F, 13.844625F, 28.835377F, 13.5F, 28.417751F, 13.5F);
      ((Path)localObject2).lineTo(27.1628F, 13.5F);
      ((Path)localObject2).cubicTo(26.745947F, 13.5F, 26.387007F, 13.836613F, 26.362814F, 14.251846F);
      ((Path)localObject2).lineTo(25.53224F, 28.506634F);
      ((Path)localObject2).cubicTo(25.501184F, 29.039612F, 25.755342F, 29.50647F, 26.163542F, 29.770678F);
      ((Path)localObject2).cubicTo(26.252584F, 30.036236F, 26.423479F, 30.280165F, 26.672367F, 30.466492F);
      ((Path)localObject2).lineTo(39.0047F, 39.699009F);
      ((Path)localObject2).cubicTo(39.340405F, 39.950333F, 39.827724F, 39.897633F, 40.089073F, 39.58617F);
      ((Path)localObject2).lineTo(40.949707F, 38.560509F);
      ((Path)localObject2).cubicTo(41.212883F, 38.246868F, 41.180317F, 37.761848F, 40.872528F, 37.473019F);
      ((Path)localObject2).lineTo(29.974895F, 27.246653F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.er
 * JD-Core Version:    0.7.0.1
 */