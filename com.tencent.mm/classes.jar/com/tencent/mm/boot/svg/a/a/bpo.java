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

public final class bpo
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 30.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.776357E-015F, 0.0F);
      ((Path)localObject2).lineTo(6.0F, 0.0F);
      ((Path)localObject2).cubicTo(5.990017F, 2.0F, 5.990017F, 4.0F, 6.0F, 6.0F);
      ((Path)localObject2).lineTo(1.776357E-015F, 6.0F);
      ((Path)localObject2).lineTo(1.776357E-015F, 0.0F);
      ((Path)localObject2).lineTo(1.776357E-015F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(10.0F, 0.0F);
      ((Path)localObject2).lineTo(16.0F, 0.0F);
      ((Path)localObject2).lineTo(16.0F, 6.0F);
      ((Path)localObject2).lineTo(10.0F, 6.0F);
      ((Path)localObject2).cubicTo(10.009983F, 4.0F, 10.009983F, 2.0F, 10.0F, 0.0F);
      ((Path)localObject2).lineTo(10.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(21.0F, 0.0F);
      ((Path)localObject2).lineTo(27.0F, 0.0F);
      ((Path)localObject2).lineTo(27.0F, 6.0F);
      ((Path)localObject2).lineTo(21.0F, 6.0F);
      ((Path)localObject2).lineTo(21.0F, 0.0F);
      ((Path)localObject2).lineTo(21.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(31.0F, 0.0F);
      ((Path)localObject2).lineTo(37.0F, 0.0F);
      ((Path)localObject2).lineTo(37.0F, 6.0F);
      ((Path)localObject2).lineTo(31.0F, 6.0F);
      ((Path)localObject2).cubicTo(31.009983F, 4.0F, 31.009983F, 2.0F, 31.0F, 0.0F);
      ((Path)localObject2).lineTo(31.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(42.0F, 0.0F);
      ((Path)localObject2).lineTo(48.0F, 0.0F);
      ((Path)localObject2).cubicTo(47.990017F, 2.0F, 47.990017F, 4.0F, 48.0F, 6.0F);
      ((Path)localObject2).lineTo(42.0F, 6.0F);
      ((Path)localObject2).lineTo(42.0F, 0.0F);
      ((Path)localObject2).lineTo(42.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(52.0F, 0.0F);
      ((Path)localObject2).lineTo(58.0F, 0.0F);
      ((Path)localObject2).lineTo(58.0F, 6.0F);
      ((Path)localObject2).lineTo(52.0F, 6.0F);
      ((Path)localObject2).cubicTo(52.009983F, 4.0F, 52.009983F, 2.0F, 52.0F, 0.0F);
      ((Path)localObject2).lineTo(52.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.776357E-015F, 12.0F);
      ((Path)localObject2).lineTo(6.0F, 12.0F);
      ((Path)localObject2).cubicTo(5.990017F, 14.0F, 5.990017F, 16.0F, 6.0F, 18.0F);
      ((Path)localObject2).lineTo(1.776357E-015F, 18.0F);
      ((Path)localObject2).lineTo(1.776357E-015F, 12.0F);
      ((Path)localObject2).lineTo(1.776357E-015F, 12.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(10.0F, 12.0F);
      ((Path)localObject2).lineTo(16.0F, 12.0F);
      ((Path)localObject2).lineTo(16.0F, 18.0F);
      ((Path)localObject2).lineTo(10.0F, 18.0F);
      ((Path)localObject2).cubicTo(10.009983F, 16.0F, 10.009983F, 14.0F, 10.0F, 12.0F);
      ((Path)localObject2).lineTo(10.0F, 12.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(21.0F, 12.0F);
      ((Path)localObject2).lineTo(27.0F, 12.0F);
      ((Path)localObject2).lineTo(27.0F, 18.0F);
      ((Path)localObject2).lineTo(21.0F, 18.0F);
      ((Path)localObject2).lineTo(21.0F, 12.0F);
      ((Path)localObject2).lineTo(21.0F, 12.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(31.0F, 12.0F);
      ((Path)localObject2).lineTo(37.0F, 12.0F);
      ((Path)localObject2).lineTo(37.0F, 18.0F);
      ((Path)localObject2).lineTo(31.0F, 18.0F);
      ((Path)localObject2).lineTo(31.0F, 12.0F);
      ((Path)localObject2).lineTo(31.0F, 12.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(42.0F, 12.0F);
      ((Path)localObject2).lineTo(48.0F, 12.0F);
      ((Path)localObject2).lineTo(48.0F, 18.0F);
      ((Path)localObject2).lineTo(42.0F, 18.0F);
      ((Path)localObject2).lineTo(42.0F, 12.0F);
      ((Path)localObject2).lineTo(42.0F, 12.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(52.0F, 12.0F);
      ((Path)localObject2).lineTo(58.0F, 12.0F);
      ((Path)localObject2).lineTo(58.0F, 18.0F);
      ((Path)localObject2).lineTo(52.0F, 18.0F);
      ((Path)localObject2).cubicTo(52.009983F, 16.0F, 52.009983F, 14.0F, 52.0F, 12.0F);
      ((Path)localObject2).lineTo(52.0F, 12.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(10.0F, 24.0F);
      ((Path)localObject1).lineTo(48.0F, 24.0F);
      ((Path)localObject1).cubicTo(47.989872F, 25.99852F, 47.989872F, 27.99704F, 48.0F, 30.0F);
      ((Path)localObject1).cubicTo(35.329956F, 30.005552F, 22.670042F, 29.99556F, 10.0F, 30.0F);
      ((Path)localObject1).cubicTo(10.010128F, 27.99704F, 10.010128F, 25.99852F, 10.0F, 24.0F);
      ((Path)localObject1).lineTo(10.0F, 24.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bpo
 * JD-Core Version:    0.7.0.1
 */