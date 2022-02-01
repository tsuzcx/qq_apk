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

public final class bri
  extends c
{
  private final int height = 12;
  private final int width = 64;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 12;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Matrix localMatrix = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject1 = c.m(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      c.a((Paint)localObject1, paramVarArgs).setStrokeWidth(1.0F);
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-2565928);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      Object localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(6.0F, 12.0F);
      ((Path)localObject2).cubicTo(9.313708F, 12.0F, 12.0F, 9.313708F, 12.0F, 6.0F);
      ((Path)localObject2).cubicTo(12.0F, 2.686292F, 9.313708F, 0.0F, 6.0F, 0.0F);
      ((Path)localObject2).cubicTo(2.686292F, 0.0F, 0.0F, 2.686292F, 0.0F, 6.0F);
      ((Path)localObject2).cubicTo(0.0F, 9.313708F, 2.686292F, 12.0F, 6.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.0F, 12.0F);
      ((Path)localObject2).cubicTo(35.313709F, 12.0F, 38.0F, 9.313708F, 38.0F, 6.0F);
      ((Path)localObject2).cubicTo(38.0F, 2.686292F, 35.313709F, 0.0F, 32.0F, 0.0F);
      ((Path)localObject2).cubicTo(28.686291F, 0.0F, 26.0F, 2.686292F, 26.0F, 6.0F);
      ((Path)localObject2).cubicTo(26.0F, 9.313708F, 28.686291F, 12.0F, 32.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(58.0F, 12.0F);
      ((Path)localObject2).cubicTo(61.313709F, 12.0F, 64.0F, 9.313708F, 64.0F, 6.0F);
      ((Path)localObject2).cubicTo(64.0F, 2.686292F, 61.313709F, 0.0F, 58.0F, 0.0F);
      ((Path)localObject2).cubicTo(54.686291F, 0.0F, 52.0F, 2.686292F, 52.0F, 6.0F);
      ((Path)localObject2).cubicTo(52.0F, 9.313708F, 54.686291F, 12.0F, 58.0F, 12.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(6.0F, 12.0F);
      ((Path)localObject1).cubicTo(9.313708F, 12.0F, 12.0F, 9.313708F, 12.0F, 6.0F);
      ((Path)localObject1).cubicTo(12.0F, 2.686292F, 9.313708F, 0.0F, 6.0F, 0.0F);
      ((Path)localObject1).cubicTo(2.686292F, 0.0F, 0.0F, 2.686292F, 0.0F, 6.0F);
      ((Path)localObject1).cubicTo(0.0F, 9.313708F, 2.686292F, 12.0F, 6.0F, 12.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(32.0F, 12.0F);
      ((Path)localObject1).cubicTo(35.313709F, 12.0F, 38.0F, 9.313708F, 38.0F, 6.0F);
      ((Path)localObject1).cubicTo(38.0F, 2.686292F, 35.313709F, 0.0F, 32.0F, 0.0F);
      ((Path)localObject1).cubicTo(28.686291F, 0.0F, 26.0F, 2.686292F, 26.0F, 6.0F);
      ((Path)localObject1).cubicTo(26.0F, 9.313708F, 28.686291F, 12.0F, 32.0F, 12.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(58.0F, 12.0F);
      ((Path)localObject1).cubicTo(61.313709F, 12.0F, 64.0F, 9.313708F, 64.0F, 6.0F);
      ((Path)localObject1).cubicTo(64.0F, 2.686292F, 61.313709F, 0.0F, 58.0F, 0.0F);
      ((Path)localObject1).cubicTo(54.686291F, 0.0F, 52.0F, 2.686292F, 52.0F, 6.0F);
      ((Path)localObject1).cubicTo(52.0F, 9.313708F, 54.686291F, 12.0F, 58.0F, 12.0F);
      ((Path)localObject1).close();
      localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 64.0F, 0.0F, 0.0F, 0.0F, 12.0F, 0.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.5F, 0.0F, 0.5F, 1.0F, new int[] { -6556649, -9903790 }, new float[] { 0.0F, 1.0F }, localMatrix, 0);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bri
 * JD-Core Version:    0.7.0.1
 */