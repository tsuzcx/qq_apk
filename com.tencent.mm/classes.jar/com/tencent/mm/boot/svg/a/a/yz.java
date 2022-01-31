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

public final class yz
  extends c
{
  private final int height = 80;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 80;
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
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 32.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(28.0F, 38.0F);
      ((Path)localObject2).cubicTo(33.522846F, 38.0F, 38.0F, 33.522846F, 38.0F, 28.0F);
      ((Path)localObject2).cubicTo(38.0F, 22.477152F, 33.522846F, 18.0F, 28.0F, 18.0F);
      ((Path)localObject2).cubicTo(22.477152F, 18.0F, 18.0F, 22.477152F, 18.0F, 28.0F);
      ((Path)localObject2).cubicTo(18.0F, 33.522846F, 22.477152F, 38.0F, 28.0F, 38.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(26.0F, 0.0F);
      ((Path)localObject2).lineTo(30.0F, 0.0F);
      ((Path)localObject2).lineTo(30.0F, 9.0F);
      ((Path)localObject2).lineTo(26.0F, 9.0F);
      ((Path)localObject2).lineTo(26.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(26.0F, 47.0F);
      ((Path)localObject2).lineTo(30.0F, 47.0F);
      ((Path)localObject2).lineTo(30.0F, 56.0F);
      ((Path)localObject2).lineTo(26.0F, 56.0F);
      ((Path)localObject2).lineTo(26.0F, 47.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(47.0F, 25.0F);
      ((Path)localObject2).lineTo(56.0F, 25.0F);
      ((Path)localObject2).lineTo(56.0F, 29.0F);
      ((Path)localObject2).lineTo(47.0F, 29.0F);
      ((Path)localObject2).lineTo(47.0F, 25.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(-1.998401E-016F, 25.0F);
      ((Path)localObject1).lineTo(9.0F, 25.0F);
      ((Path)localObject1).lineTo(9.0F, 29.0F);
      ((Path)localObject1).lineTo(-1.998401E-016F, 29.0F);
      ((Path)localObject1).lineTo(-1.998401E-016F, 25.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.yz
 * JD-Core Version:    0.7.0.1
 */