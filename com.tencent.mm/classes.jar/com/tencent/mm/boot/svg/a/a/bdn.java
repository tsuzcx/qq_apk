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

public final class bdn
  extends c
{
  private final int height = 75;
  private final int width = 63;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 63;
      return 75;
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
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -366.0F, 0.0F, 1.0F, -536.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 377.0F, 0.0F, 1.0F, 537.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 3.084645F);
      ((Path)localObject3).cubicTo(0.0F, 1.842004F, 1.007359F, 0.8346449F, 2.25F, 0.8346449F);
      ((Path)localObject3).lineTo(4.646552F, 0.8346449F);
      ((Path)localObject3).cubicTo(5.889193F, 0.8346449F, 6.896552F, 1.842004F, 6.896552F, 3.084645F);
      ((Path)localObject3).lineTo(6.896552F, 69.939705F);
      ((Path)localObject3).cubicTo(6.896552F, 71.182343F, 5.889193F, 72.189705F, 4.646552F, 72.189705F);
      ((Path)localObject3).lineTo(2.25F, 72.189705F);
      ((Path)localObject3).cubicTo(1.007359F, 72.189705F, 0.0F, 71.182343F, 0.0F, 69.939705F);
      ((Path)localObject3).lineTo(0.0F, 3.084645F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(33.103447F, 3.088012F);
      ((Path)localObject2).cubicTo(33.103447F, 1.843512F, 34.106266F, 0.8346449F, 35.361637F, 0.8346449F);
      ((Path)localObject2).lineTo(37.74181F, 0.8346449F);
      ((Path)localObject2).cubicTo(38.988976F, 0.8346449F, 40.0F, 1.843342F, 40.0F, 3.088012F);
      ((Path)localObject2).lineTo(40.0F, 69.93634F);
      ((Path)localObject2).cubicTo(40.0F, 71.18084F, 38.997181F, 72.189705F, 37.74181F, 72.189705F);
      ((Path)localObject2).lineTo(35.361637F, 72.189705F);
      ((Path)localObject2).cubicTo(34.114475F, 72.189705F, 33.103447F, 71.181007F, 33.103447F, 69.93634F);
      ((Path)localObject2).lineTo(33.103447F, 3.088012F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bdn
 * JD-Core Version:    0.7.0.1
 */