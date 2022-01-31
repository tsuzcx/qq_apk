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

public final class kc
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617851);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(53.000092F, 8.0F);
      ((Path)localObject2).lineTo(45.000092F, 0.0F);
      ((Path)localObject2).lineTo(20.00009F, 0.0F);
      ((Path)localObject2).lineTo(12.000091F, 8.0F);
      ((Path)localObject2).lineTo(9.027778E-005F, 8.0F);
      ((Path)localObject2).lineTo(9.027778E-005F, 16.0F);
      ((Path)localObject2).lineTo(65.000092F, 16.0F);
      ((Path)localObject2).lineTo(65.000092F, 8.0F);
      ((Path)localObject2).lineTo(53.000092F, 8.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.000091F, 67.0F);
      ((Path)localObject2).lineTo(20.00009F, 67.0F);
      ((Path)localObject2).lineTo(20.00009F, 31.0F);
      ((Path)localObject2).lineTo(12.000091F, 31.0F);
      ((Path)localObject2).lineTo(12.000091F, 67.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(28.00009F, 67.0F);
      ((Path)localObject2).lineTo(36.000092F, 67.0F);
      ((Path)localObject2).lineTo(36.000092F, 31.0F);
      ((Path)localObject2).lineTo(28.00009F, 31.0F);
      ((Path)localObject2).lineTo(28.00009F, 67.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.000092F, 67.0F);
      ((Path)localObject2).lineTo(53.000092F, 67.0F);
      ((Path)localObject2).lineTo(53.000092F, 31.0F);
      ((Path)localObject2).lineTo(45.000092F, 31.0F);
      ((Path)localObject2).lineTo(45.000092F, 67.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.00009F, 68.0F);
      ((Path)localObject2).cubicTo(4.00009F, 74.531616F, 9.468924F, 80.0F, 16.00009F, 80.0F);
      ((Path)localObject2).lineTo(49.000092F, 80.0F);
      ((Path)localObject2).cubicTo(55.531708F, 80.0F, 61.000092F, 74.531616F, 61.000092F, 68.0F);
      ((Path)localObject2).lineTo(61.000092F, 23.0F);
      ((Path)localObject2).lineTo(4.00009F, 23.0F);
      ((Path)localObject2).lineTo(4.00009F, 68.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.kc
 * JD-Core Version:    0.7.0.1
 */