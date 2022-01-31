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

public final class lx
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
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
      ((Paint)localObject2).setColor(-6118750);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 13.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(11.145517F, 1.512209F);
      ((Path)localObject3).cubicTo(12.139298F, 0.841187F, 13.13308F, 0.8311717F, 14.12686F, 1.472148F);
      ((Path)localObject3).cubicTo(23.139763F, 9.654614F, 23.316874F, 25.448673F, 14.490918F, 33.851475F);
      ((Path)localObject3).cubicTo(12.719824F, 34.492451F, 10.663386F, 32.970131F, 11.224233F, 30.987112F);
      ((Path)localObject3).cubicTo(12.493517F, 28.503328F, 14.372846F, 26.299971F, 15.051764F, 23.525745F);
      ((Path)localObject3).cubicTo(16.891735F, 17.586697F, 15.199356F, 10.946582F, 11.234072F, 6.309517F);
      ((Path)localObject3).cubicTo(9.905751F, 5.03758F, 9.335065F, 2.623903F, 11.145517F, 1.512209F);
      ((Path)localObject3).lineTo(11.145517F, 1.512209F);
      ((Path)localObject3).lineTo(11.145517F, 1.512209F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(1.07772F, 8.738578F);
      ((Path)localObject2).cubicTo(2.165072F, 7.761998F, 4.146697F, 7.722934F, 5.173077F, 8.806938F);
      ((Path)localObject2).cubicTo(9.786705F, 13.738669F, 10.426922F, 21.83452F, 6.006375F, 27.068993F);
      ((Path)localObject2).cubicTo(4.268643F, 29.139343F, 0.3358808F, 27.469391F, 0.6813948F, 24.871687F);
      ((Path)localObject2).cubicTo(1.301288F, 22.488831F, 3.912967F, 20.809113F, 3.445507F, 18.133282F);
      ((Path)localObject2).cubicTo(3.628426F, 14.725016F, -2.387583F, 11.961293F, 1.07772F, 8.738578F);
      ((Path)localObject2).lineTo(1.07772F, 8.738578F);
      ((Path)localObject2).lineTo(1.07772F, 8.738578F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.lx
 * JD-Core Version:    0.7.0.1
 */