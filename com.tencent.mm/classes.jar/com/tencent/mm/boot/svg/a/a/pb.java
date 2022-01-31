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

public final class pb
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 6.006387F);
      ((Path)localObject2).cubicTo(0.0F, 2.689151F, 2.683541F, 0.0F, 6.006387F, 0.0F);
      ((Path)localObject2).lineTo(41.993614F, 0.0F);
      ((Path)localObject2).cubicTo(45.310848F, 0.0F, 48.0F, 2.683541F, 48.0F, 6.006387F);
      ((Path)localObject2).lineTo(48.0F, 41.993614F);
      ((Path)localObject2).cubicTo(48.0F, 45.310848F, 45.31646F, 48.0F, 41.993614F, 48.0F);
      ((Path)localObject2).lineTo(6.006387F, 48.0F);
      ((Path)localObject2).cubicTo(2.689151F, 48.0F, 1.776357E-015F, 45.31646F, 1.776357E-015F, 41.993614F);
      ((Path)localObject2).lineTo(0.0F, 6.006387F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 6.006387F);
      ((Path)localObject2).cubicTo(0.0F, 2.689151F, 2.683541F, 0.0F, 6.006387F, 0.0F);
      ((Path)localObject2).lineTo(41.993614F, 0.0F);
      ((Path)localObject2).cubicTo(45.310848F, 0.0F, 48.0F, 2.683541F, 48.0F, 6.006387F);
      ((Path)localObject2).lineTo(48.0F, 41.993614F);
      ((Path)localObject2).cubicTo(48.0F, 45.310848F, 45.31646F, 48.0F, 41.993614F, 48.0F);
      ((Path)localObject2).lineTo(6.006387F, 48.0F);
      ((Path)localObject2).cubicTo(2.689151F, 48.0F, 1.776357E-015F, 45.31646F, 1.776357E-015F, 41.993614F);
      ((Path)localObject2).lineTo(0.0F, 6.006387F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(12.0F, 32.576923F);
      ((Path)localObject1).lineTo(16.200001F, 28.538462F);
      ((Path)localObject1).lineTo(25.0F, 36.923077F);
      ((Path)localObject1).lineTo(43.799999F, 19.0F);
      ((Path)localObject1).lineTo(48.0F, 23.038462F);
      ((Path)localObject1).lineTo(25.0F, 45.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pb
 * JD-Core Version:    0.7.0.1
 */