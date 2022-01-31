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

public final class mv
  extends c
{
  private final int height = 117;
  private final int width = 117;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 117;
      return 117;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -1420.0F, 0.0F, 1.0F, -201.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-16139513);
      ((Paint)localObject1).setStrokeWidth(6.0F);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(1423.0F, 259.5F);
      ((Path)localObject2).cubicTo(1423.0F, 228.84819F, 1447.8481F, 204.0F, 1478.5F, 204.0F);
      ((Path)localObject2).lineTo(1478.5F, 204.0F);
      ((Path)localObject2).cubicTo(1509.1519F, 204.0F, 1534.0F, 228.84819F, 1534.0F, 259.5F);
      ((Path)localObject2).lineTo(1534.0F, 259.5F);
      ((Path)localObject2).cubicTo(1534.0F, 290.15179F, 1509.1519F, 315.0F, 1478.5F, 315.0F);
      ((Path)localObject2).lineTo(1478.5F, 315.0F);
      ((Path)localObject2).cubicTo(1447.8481F, 315.0F, 1423.0F, 290.15179F, 1423.0F, 259.5F);
      ((Path)localObject2).lineTo(1423.0F, 259.5F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16139513);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(1475.762F, 276.99985F);
      ((Path)localObject1).cubicTo(1480.2301F, 272.53815F, 1483.0F, 266.33554F, 1483.0F, 259.47748F);
      ((Path)localObject1).cubicTo(1483.0F, 252.50348F, 1480.1356F, 246.20723F, 1475.5338F, 241.7303F);
      ((Path)localObject1).lineTo(1470.5934F, 246.6707F);
      ((Path)localObject1).cubicTo(1473.9595F, 249.87605F, 1476.0616F, 254.42805F, 1476.0616F, 259.47748F);
      ((Path)localObject1).cubicTo(1476.0616F, 264.41092F, 1474.0549F, 268.86954F, 1470.8234F, 272.06125F);
      ((Path)localObject1).lineTo(1475.762F, 276.99985F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(1464.6487F, 265.88657F);
      ((Path)localObject1).cubicTo(1466.3352F, 264.2836F, 1467.3888F, 262.00519F, 1467.3888F, 259.47748F);
      ((Path)localObject1).cubicTo(1467.3888F, 256.83368F, 1466.2362F, 254.46259F, 1464.4122F, 252.85182F);
      ((Path)localObject1).lineTo(1458.0131F, 259.25101F);
      ((Path)localObject1).lineTo(1464.6487F, 265.88657F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.mv
 * JD-Core Version:    0.7.0.1
 */