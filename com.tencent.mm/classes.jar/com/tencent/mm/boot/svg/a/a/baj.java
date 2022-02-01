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

public final class baj
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject1 = c.m(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localObject3 = c.a((float[])localObject3, 2.4F, 0.0F, 0.0F, 0.0F, 2.4F, 0.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      localPaint = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(201326592);
      localPaint.setColor(-3552823);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(19.5F, 10.123457F);
      ((Path)localObject3).cubicTo(19.5F, 4.75318F, 15.24682F, 0.5F, 9.876543F, 0.5F);
      ((Path)localObject3).cubicTo(4.71725F, 0.5F, 0.5F, 4.789796F, 0.5F, 10.123457F);
      ((Path)localObject3).cubicTo(0.5F, 15.24682F, 4.75318F, 19.5F, 9.876543F, 19.5F);
      ((Path)localObject3).cubicTo(15.210204F, 19.5F, 19.5F, 15.28275F, 19.5F, 10.123457F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(5.456435F, 10.368831F);
      ((Path)localObject1).lineTo(5.506938F, 10.300112F);
      ((Path)localObject1).cubicTo(5.663359F, 10.087274F, 5.962703F, 10.041537F, 6.175542F, 10.197958F);
      ((Path)localObject1).cubicTo(6.178132F, 10.199862F, 6.180702F, 10.201791F, 6.183252F, 10.203745F);
      ((Path)localObject1).lineTo(8.341835F, 11.858175F);
      ((Path)localObject1).cubicTo(8.519239F, 11.994144F, 8.76716F, 11.989105F, 8.938891F, 11.846039F);
      ((Path)localObject1).lineTo(15.01762F, 6.781966F);
      ((Path)localObject1).cubicTo(15.194826F, 6.634339F, 15.455153F, 6.645353F, 15.619257F, 6.807421F);
      ((Path)localObject1).lineTo(15.619257F, 6.807421F);
      ((Path)localObject1).cubicTo(15.776759F, 6.962969F, 15.778342F, 7.216747F, 15.622794F, 7.37425F);
      ((Path)localObject1).cubicTo(15.621458F, 7.375602F, 15.620112F, 7.376945F, 15.618758F, 7.378278F);
      ((Path)localObject1).lineTo(8.989018F, 13.902933F);
      ((Path)localObject1).cubicTo(8.800759F, 14.088207F, 8.497951F, 14.085789F, 8.312676F, 13.897531F);
      ((Path)localObject1).cubicTo(8.311649F, 13.896486F, 8.310627F, 13.895438F, 8.309609F, 13.894385F);
      ((Path)localObject1).lineTo(5.497875F, 10.98438F);
      ((Path)localObject1).cubicTo(5.335879F, 10.816722F, 5.318373F, 10.556688F, 5.456435F, 10.368831F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.baj
 * JD-Core Version:    0.7.0.1
 */