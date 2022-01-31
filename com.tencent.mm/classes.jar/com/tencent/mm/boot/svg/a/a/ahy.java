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

public final class ahy
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617594);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 43.0F, 0.0F, 1.0F, 39.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(3.057009F, 20.547123F);
      ((Path)localObject2).lineTo(37.884998F, 40.385174F);
      ((Path)localObject2).cubicTo(39.327869F, 41.207031F, 41.674564F, 41.20285F, 43.110088F, 40.385174F);
      ((Path)localObject2).lineTo(77.93808F, 20.547123F);
      ((Path)localObject2).cubicTo(79.380943F, 19.725264F, 79.351913F, 18.46529F, 77.860435F, 17.726551F);
      ((Path)localObject2).lineTo(43.187733F, 0.5529894F);
      ((Path)localObject2).cubicTo(41.701981F, -0.1829102F, 39.298836F, -0.1857481F, 37.807354F, 0.5529894F);
      ((Path)localObject2).lineTo(3.134654F, 17.726551F);
      ((Path)localObject2).cubicTo(1.648904F, 18.462452F, 1.621486F, 19.729448F, 3.057009F, 20.547123F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.611893F, 45.124817F);
      ((Path)localObject2).cubicTo(44.169384F, 45.936329F, 43.0F, 47.939342F, 43.0F, 49.589432F);
      ((Path)localObject2).lineTo(43.0F, 86.194633F);
      ((Path)localObject2).cubicTo(43.0F, 87.848862F, 44.158012F, 88.494118F, 45.567139F, 87.647476F);
      ((Path)localObject2).lineTo(78.432861F, 67.90081F);
      ((Path)localObject2).cubicTo(79.850655F, 67.048965F, 81.0F, 65.012932F, 81.0F, 63.366447F);
      ((Path)localObject2).lineTo(81.0F, 28.208572F);
      ((Path)localObject2).cubicTo(81.0F, 26.55616F, 79.821068F, 25.879847F, 78.388107F, 26.685984F);
      ((Path)localObject2).lineTo(45.611893F, 45.124817F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(35.388107F, 45.124817F);
      ((Path)localObject2).cubicTo(36.830616F, 45.936329F, 38.0F, 47.939342F, 38.0F, 49.589432F);
      ((Path)localObject2).lineTo(38.0F, 86.194633F);
      ((Path)localObject2).cubicTo(38.0F, 87.848862F, 36.841988F, 88.494118F, 35.432861F, 87.647476F);
      ((Path)localObject2).lineTo(2.567138F, 67.90081F);
      ((Path)localObject2).cubicTo(1.149347F, 67.048965F, 0.0F, 65.012932F, 0.0F, 63.366447F);
      ((Path)localObject2).lineTo(0.0F, 28.208572F);
      ((Path)localObject2).cubicTo(0.0F, 26.55616F, 1.178934F, 25.879847F, 2.611894F, 26.685984F);
      ((Path)localObject2).lineTo(35.388107F, 45.124817F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahy
 * JD-Core Version:    0.7.0.1
 */