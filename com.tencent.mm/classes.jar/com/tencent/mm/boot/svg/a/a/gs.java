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

public final class gs
  extends c
{
  private final int height = 53;
  private final int width = 53;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 53;
      return 53;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 0.9842154F, 0.0F, -8.857939F, 0.0F, 0.9842154F, -8.857939F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(51.487F, 48.305F);
      ((Path)localObject2).lineTo(62.849998F, 59.667F);
      ((Path)localObject2).lineTo(59.667999F, 62.849998F);
      ((Path)localObject2).lineTo(48.305F, 51.487F);
      ((Path)localObject2).cubicTo(44.150002F, 54.93F, 38.817001F, 57.0F, 33.0F, 57.0F);
      ((Path)localObject2).cubicTo(19.745001F, 57.0F, 9.0F, 46.255001F, 9.0F, 33.0F);
      ((Path)localObject2).cubicTo(9.0F, 19.744999F, 19.745001F, 9.0F, 33.0F, 9.0F);
      ((Path)localObject2).cubicTo(46.254997F, 9.0F, 57.0F, 19.744999F, 57.0F, 33.0F);
      ((Path)localObject2).cubicTo(57.0F, 38.817001F, 54.93F, 44.150002F, 51.487F, 48.305F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(52.542999F, 33.007F);
      ((Path)localObject2).cubicTo(52.542999F, 22.237F, 43.813F, 13.507F, 33.042999F, 13.507F);
      ((Path)localObject2).cubicTo(22.272999F, 13.507F, 13.542999F, 22.237F, 13.542999F, 33.007F);
      ((Path)localObject2).cubicTo(13.542999F, 43.777F, 22.272999F, 52.507F, 33.042999F, 52.507F);
      ((Path)localObject2).cubicTo(43.812F, 52.507F, 52.542999F, 43.776001F, 52.542999F, 33.007F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.gs
 * JD-Core Version:    0.7.0.1
 */