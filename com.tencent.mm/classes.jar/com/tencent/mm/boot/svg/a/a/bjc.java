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

public final class bjc
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
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 48.0F, 0.0F, 1.0F, 48.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 18.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-13421773);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(64.663895F, 28.437271F);
      ((Path)localObject2).cubicTo(62.816101F, 26.772472F, 59.729828F, 26.66011F, 57.775352F, 28.182531F);
      ((Path)localObject2).lineTo(49.720131F, 34.457081F);
      ((Path)localObject2).lineTo(53.791866F, 42.888355F);
      ((Path)localObject2).lineTo(28.658388F, 19.66337F);
      ((Path)localObject2).cubicTo(26.833735F, 17.977272F, 23.881802F, 17.995331F, 22.078856F, 19.690735F);
      ((Path)localObject2).lineTo(0.0F, 40.452621F);
      ((Path)localObject2).lineTo(0.0F, 57.0F);
      ((Path)localObject2).lineTo(78.0F, 57.0F);
      ((Path)localObject2).lineTo(78.0F, 40.452621F);
      ((Path)localObject2).lineTo(64.663895F, 28.437271F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-13421773);
      localPaint.setStrokeWidth(6.0F);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(3.0F, 6.0F);
      ((Path)localObject1).cubicTo(3.0F, 4.343145F, 4.343145F, 3.0F, 6.0F, 3.0F);
      ((Path)localObject1).lineTo(72.0F, 3.0F);
      ((Path)localObject1).cubicTo(73.656853F, 3.0F, 75.0F, 4.343145F, 75.0F, 6.0F);
      ((Path)localObject1).lineTo(75.0F, 54.0F);
      ((Path)localObject1).cubicTo(75.0F, 55.656853F, 73.656853F, 57.0F, 72.0F, 57.0F);
      ((Path)localObject1).lineTo(6.0F, 57.0F);
      ((Path)localObject1).cubicTo(4.343145F, 57.0F, 3.0F, 55.656853F, 3.0F, 54.0F);
      ((Path)localObject1).lineTo(3.0F, 6.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bjc
 * JD-Core Version:    0.7.0.1
 */