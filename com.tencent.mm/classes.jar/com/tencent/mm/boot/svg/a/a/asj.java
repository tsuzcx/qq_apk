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

public final class asj
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
      ((Paint)localObject2).setColor(-15683841);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -12.0F, 0.0F, 1.0F, -12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(20.03616F, 23.6F);
      ((Path)localObject3).lineTo(21.609674F, 27.926605F);
      ((Path)localObject3).cubicTo(21.760666F, 28.341833F, 21.546461F, 28.800842F, 21.131235F, 28.951836F);
      ((Path)localObject3).cubicTo(21.043606F, 28.9837F, 20.951082F, 29.0F, 20.85784F, 29.0F);
      ((Path)localObject3).lineTo(11.14216F, 29.0F);
      ((Path)localObject3).cubicTo(10.700333F, 29.0F, 10.34216F, 28.641829F, 10.34216F, 28.200001F);
      ((Path)localObject3).cubicTo(10.34216F, 28.106758F, 10.35846F, 28.014235F, 10.390326F, 27.926605F);
      ((Path)localObject3).lineTo(11.96316F, 23.6F);
      ((Path)localObject3).lineTo(20.03616F, 23.6F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(28.1F, 3.0F);
      ((Path)localObject2).cubicTo(28.873199F, 3.0F, 29.5F, 3.626801F, 29.5F, 4.4F);
      ((Path)localObject2).lineTo(29.5F, 20.6F);
      ((Path)localObject2).cubicTo(29.5F, 21.373199F, 28.873199F, 22.0F, 28.1F, 22.0F);
      ((Path)localObject2).lineTo(3.9F, 22.0F);
      ((Path)localObject2).cubicTo(3.126801F, 22.0F, 2.5F, 21.373199F, 2.5F, 20.6F);
      ((Path)localObject2).lineTo(2.5F, 4.4F);
      ((Path)localObject2).cubicTo(2.5F, 3.626801F, 3.126801F, 3.0F, 3.9F, 3.0F);
      ((Path)localObject2).lineTo(28.1F, 3.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.411257F, 7.548846F);
      ((Path)localObject2).cubicTo(16.169971F, 7.321715F, 15.790246F, 7.33319F, 15.563115F, 7.574474F);
      ((Path)localObject2).lineTo(15.563115F, 7.574474F);
      ((Path)localObject2).lineTo(11.0F, 12.421952F);
      ((Path)localObject2).lineTo(12.25F, 13.749849F);
      ((Path)localObject2).lineTo(15.117F, 10.704729F);
      ((Path)localObject2).lineTo(15.116117F, 17.614271F);
      ((Path)localObject2).lineTo(16.883884F, 17.614271F);
      ((Path)localObject2).lineTo(16.884001F, 10.703729F);
      ((Path)localObject2).lineTo(19.75F, 13.749849F);
      ((Path)localObject2).lineTo(21.0F, 12.421952F);
      ((Path)localObject2).lineTo(17.25F, 8.438261F);
      ((Path)localObject2).lineTo(16.436884F, 7.574474F);
      ((Path)localObject2).cubicTo(16.428602F, 7.565676F, 16.420055F, 7.557129F, 16.411257F, 7.548846F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.asj
 * JD-Core Version:    0.7.0.1
 */