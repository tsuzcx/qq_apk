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

public final class aqa
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(72.0F, 0.0F);
      ((Path)localObject2).lineTo(72.0F, 72.0F);
      ((Path)localObject2).lineTo(0.0F, 72.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      arrayOfFloat = c.a(arrayOfFloat, -1.83697E-016F, -1.0F, 72.0F, 1.0F, -1.83697E-016F, 6.613092E-015F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(57.57888F, 13.5F);
      ((Path)localObject1).cubicTo(58.738678F, 13.5F, 59.678879F, 14.440202F, 59.678879F, 15.6F);
      ((Path)localObject1).cubicTo(59.678879F, 16.190689F, 59.430107F, 16.754065F, 58.993565F, 17.151989F);
      ((Path)localObject1).lineTo(38.315105F, 36.0F);
      ((Path)localObject1).lineTo(58.993565F, 54.848011F);
      ((Path)localObject1).cubicTo(59.850704F, 55.629322F, 59.912174F, 56.957546F, 59.130867F, 57.814686F);
      ((Path)localObject1).cubicTo(58.732944F, 58.251228F, 58.169567F, 58.5F, 57.57888F, 58.5F);
      ((Path)localObject1).lineTo(14.421122F, 58.5F);
      ((Path)localObject1).cubicTo(13.261323F, 58.5F, 12.321121F, 57.559799F, 12.321121F, 56.400002F);
      ((Path)localObject1).cubicTo(12.321121F, 55.809311F, 12.569893F, 55.245934F, 13.006436F, 54.848011F);
      ((Path)localObject1).lineTo(33.684109F, 36.0F);
      ((Path)localObject1).lineTo(13.006436F, 17.151989F);
      ((Path)localObject1).cubicTo(12.149298F, 16.37068F, 12.087824F, 15.042455F, 12.869133F, 14.185315F);
      ((Path)localObject1).cubicTo(13.267056F, 13.748772F, 13.830432F, 13.5F, 14.421122F, 13.5F);
      ((Path)localObject1).lineTo(57.57888F, 13.5F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqa
 * JD-Core Version:    0.7.0.1
 */