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

public final class aiy
  extends c
{
  private final int height = 240;
  private final int width = 240;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 240;
      return 240;
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
      localCanvas.saveLayerAlpha(null, 204, 4);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 83.0F, 0.0F, 1.0F, 91.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(32.851398F, 18.0F);
      ((Path)localObject2).lineTo(15.0F, 18.0F);
      ((Path)localObject2).lineTo(15.0F, 30.0F);
      ((Path)localObject2).lineTo(0.0F, 15.0F);
      ((Path)localObject2).lineTo(15.0F, 0.0F);
      ((Path)localObject2).lineTo(15.0F, 12.0F);
      ((Path)localObject2).lineTo(52.5F, 12.0F);
      ((Path)localObject2).cubicTo(64.926407F, 12.0F, 75.0F, 22.073593F, 75.0F, 34.5F);
      ((Path)localObject2).cubicTo(75.0F, 46.926407F, 64.926407F, 57.0F, 52.5F, 57.0F);
      ((Path)localObject2).lineTo(28.0F, 57.0F);
      ((Path)localObject2).lineTo(28.0F, 51.0F);
      ((Path)localObject2).lineTo(28.5F, 51.0F);
      ((Path)localObject2).lineTo(32.851398F, 51.0F);
      ((Path)localObject2).lineTo(37.202793F, 51.0F);
      ((Path)localObject2).lineTo(52.5F, 51.0F);
      ((Path)localObject2).cubicTo(61.612698F, 51.0F, 69.0F, 43.612698F, 69.0F, 34.5F);
      ((Path)localObject2).cubicTo(69.0F, 25.387302F, 61.612698F, 18.0F, 52.5F, 18.0F);
      ((Path)localObject2).lineTo(32.851398F, 18.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aiy
 * JD-Core Version:    0.7.0.1
 */