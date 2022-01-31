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

public final class st
  extends c
{
  private final int height = 84;
  private final int width = 84;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 84;
      return 84;
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
      ((Paint)localObject2).setColor(-5460820);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(46.009998F, 0.02F);
      ((Path)localObject3).cubicTo(53.349998F, 6.17F, 60.669998F, 12.34F, 68.0F, 18.5F);
      ((Path)localObject3).cubicTo(60.700001F, 24.700001F, 53.34F, 30.82F, 46.009998F, 36.98F);
      ((Path)localObject3).cubicTo(45.990002F, 33.310001F, 46.0F, 29.65F, 46.0F, 25.98F);
      ((Path)localObject3).cubicTo(39.099998F, 26.16F, 31.549999F, 26.35F, 25.780001F, 30.639999F);
      ((Path)localObject3).cubicTo(21.98F, 33.450001F, 19.950001F, 37.860001F, 17.969999F, 42.0F);
      ((Path)localObject3).cubicTo(18.18F, 31.950001F, 21.110001F, 20.879999F, 29.610001F, 14.67F);
      ((Path)localObject3).cubicTo(34.25F, 11.05F, 40.349998F, 10.71F, 46.0F, 11.03F);
      ((Path)localObject3).cubicTo(46.0F, 7.36F, 45.990002F, 3.69F, 46.009998F, 0.02F);
      ((Path)localObject3).lineTo(46.009998F, 0.02F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(1.0F, 14.9F);
      ((Path)localObject2).cubicTo(0.7F, 13.12F, 1.87F, 10.94F, 3.88F, 11.05F);
      ((Path)localObject2).cubicTo(9.91F, 10.9F, 15.95F, 11.07F, 21.98F, 10.99F);
      ((Path)localObject2).cubicTo(20.17F, 13.1F, 18.65F, 15.45F, 17.469999F, 17.98F);
      ((Path)localObject2).cubicTo(14.32F, 18.01F, 11.16F, 18.0F, 8.0F, 18.0F);
      ((Path)localObject2).lineTo(8.0F, 52.0F);
      ((Path)localObject2).lineTo(54.0F, 52.0F);
      ((Path)localObject2).lineTo(54.0F, 40.150002F);
      ((Path)localObject2).cubicTo(56.32F, 38.16F, 58.650002F, 36.200001F, 60.990002F, 34.240002F);
      ((Path)localObject2).cubicTo(60.959999F, 41.529999F, 61.080002F, 48.82F, 60.950001F, 56.099998F);
      ((Path)localObject2).cubicTo(61.009998F, 58.07F, 58.919998F, 59.330002F, 57.119999F, 59.0F);
      ((Path)localObject2).cubicTo(39.380001F, 58.970001F, 21.620001F, 59.07F, 3.88F, 58.950001F);
      ((Path)localObject2).cubicTo(1.87F, 59.049999F, 0.69F, 56.860001F, 1.0F, 55.07F);
      ((Path)localObject2).lineTo(1.0F, 14.9F);
      ((Path)localObject2).lineTo(1.0F, 14.9F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.st
 * JD-Core Version:    0.7.0.1
 */