package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class awj
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(55.091885F, 19.908117F);
      ((Path)localObject).cubicTo(59.977921F, 24.794155F, 63.0F, 31.544155F, 63.0F, 39.0F);
      ((Path)localObject).cubicTo(63.0F, 53.91169F, 50.91169F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(21.088312F, 66.0F, 9.0F, 53.91169F, 9.0F, 39.0F);
      ((Path)localObject).cubicTo(9.0F, 24.088312F, 21.088312F, 12.0F, 36.0F, 12.0F);
      ((Path)localObject).lineTo(36.0F, 15.6F);
      ((Path)localObject).cubicTo(23.076536F, 15.6F, 12.6F, 26.076536F, 12.6F, 39.0F);
      ((Path)localObject).cubicTo(12.6F, 51.923462F, 23.076536F, 62.400002F, 36.0F, 62.400002F);
      ((Path)localObject).cubicTo(48.923462F, 62.400002F, 59.400002F, 51.923462F, 59.400002F, 39.0F);
      ((Path)localObject).cubicTo(59.400002F, 32.706245F, 56.908665F, 26.816067F, 52.546299F, 22.453701F);
      ((Path)localObject).lineTo(55.091885F, 19.908117F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.730843F, 15.633832F);
      ((Path)localObject).cubicTo(22.397545F, 16.293022F, 12.6F, 26.502342F, 12.6F, 39.0F);
      ((Path)localObject).cubicTo(12.6F, 51.923462F, 23.076536F, 62.400002F, 36.0F, 62.400002F);
      ((Path)localObject).cubicTo(48.923462F, 62.400002F, 59.400002F, 51.923462F, 59.400002F, 39.0F);
      ((Path)localObject).cubicTo(59.400002F, 32.706245F, 56.908665F, 26.816067F, 52.546299F, 22.453701F);
      ((Path)localObject).lineTo(55.091885F, 19.908117F);
      ((Path)localObject).cubicTo(59.977921F, 24.794155F, 63.0F, 31.544155F, 63.0F, 39.0F);
      ((Path)localObject).cubicTo(63.0F, 53.91169F, 50.91169F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(21.088312F, 66.0F, 9.0F, 53.91169F, 9.0F, 39.0F);
      ((Path)localObject).cubicTo(9.0F, 24.928625F, 19.764284F, 13.371382F, 33.507618F, 12.113505F);
      ((Path)localObject).lineTo(29.939697F, 8.545585F);
      ((Path)localObject).lineTo(32.485283F, 6.0F);
      ((Path)localObject).lineTo(39.909904F, 13.424622F);
      ((Path)localObject).cubicTo(40.495689F, 14.010407F, 40.495689F, 14.960155F, 39.909904F, 15.545941F);
      ((Path)localObject).lineTo(38.424976F, 17.030867F);
      ((Path)localObject).lineTo(32.485283F, 22.970562F);
      ((Path)localObject).lineTo(29.939697F, 20.424978F);
      ((Path)localObject).lineTo(34.730843F, 15.633832F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.awj
 * JD-Core Version:    0.7.0.1
 */