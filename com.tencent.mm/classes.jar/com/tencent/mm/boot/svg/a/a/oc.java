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

public final class oc
  extends c
{
  private final int height = 48;
  private final int width = 60;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -6.0F, 0.0F, 1.0F, -12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(28.926662F, 15.6F);
      ((Path)localObject3).lineTo(22.926662F, 24.6F);
      ((Path)localObject3).lineTo(9.6F, 24.6F);
      ((Path)localObject3).lineTo(9.6F, 56.400002F);
      ((Path)localObject3).lineTo(62.400002F, 56.400002F);
      ((Path)localObject3).lineTo(62.400002F, 24.6F);
      ((Path)localObject3).lineTo(49.073338F, 24.6F);
      ((Path)localObject3).lineTo(43.073338F, 15.6F);
      ((Path)localObject3).lineTo(28.926662F, 15.6F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(44.197224F, 12.0F);
      ((Path)localObject3).cubicTo(44.698753F, 12.0F, 45.167103F, 12.250651F, 45.445301F, 12.66795F);
      ((Path)localObject3).lineTo(51.0F, 21.0F);
      ((Path)localObject3).lineTo(63.0F, 21.0F);
      ((Path)localObject3).cubicTo(64.656853F, 21.0F, 66.0F, 22.343145F, 66.0F, 24.0F);
      ((Path)localObject3).lineTo(66.0F, 57.0F);
      ((Path)localObject3).cubicTo(66.0F, 58.656853F, 64.656853F, 60.0F, 63.0F, 60.0F);
      ((Path)localObject3).lineTo(9.0F, 60.0F);
      ((Path)localObject3).cubicTo(7.343146F, 60.0F, 6.0F, 58.656853F, 6.0F, 57.0F);
      ((Path)localObject3).lineTo(6.0F, 24.0F);
      ((Path)localObject3).cubicTo(6.0F, 22.343145F, 7.343146F, 21.0F, 9.0F, 21.0F);
      ((Path)localObject3).lineTo(21.0F, 21.0F);
      ((Path)localObject3).lineTo(26.554701F, 12.66795F);
      ((Path)localObject3).cubicTo(26.832899F, 12.250651F, 27.301247F, 12.0F, 27.802776F, 12.0F);
      ((Path)localObject3).lineTo(44.197224F, 12.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(36.0F, 48.0F);
      ((Path)localObject2).cubicTo(40.970562F, 48.0F, 45.0F, 43.970562F, 45.0F, 39.0F);
      ((Path)localObject2).cubicTo(45.0F, 34.029438F, 40.970562F, 30.0F, 36.0F, 30.0F);
      ((Path)localObject2).cubicTo(31.029438F, 30.0F, 27.0F, 34.029438F, 27.0F, 39.0F);
      ((Path)localObject2).cubicTo(27.0F, 43.970562F, 31.029438F, 48.0F, 36.0F, 48.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 51.599998F);
      ((Path)localObject2).cubicTo(29.041212F, 51.599998F, 23.4F, 45.958786F, 23.4F, 39.0F);
      ((Path)localObject2).cubicTo(23.4F, 32.041214F, 29.041212F, 26.4F, 36.0F, 26.4F);
      ((Path)localObject2).cubicTo(42.958786F, 26.4F, 48.599998F, 32.041214F, 48.599998F, 39.0F);
      ((Path)localObject2).cubicTo(48.599998F, 45.958786F, 42.958786F, 51.599998F, 36.0F, 51.599998F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.oc
 * JD-Core Version:    0.7.0.1
 */