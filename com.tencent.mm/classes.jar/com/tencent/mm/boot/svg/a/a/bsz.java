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

public final class bsz
  extends c
{
  private final int height = 63;
  private final int width = 63;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 63;
      return 63;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(21.0F, 21.0F);
      ((Path)localObject).lineTo(43.5F, 21.0F);
      ((Path)localObject).lineTo(43.5F, 21.127842F);
      ((Path)localObject).cubicTo(51.115696F, 22.108934F, 57.0F, 28.61729F, 57.0F, 36.5F);
      ((Path)localObject).cubicTo(57.0F, 44.209316F, 51.371719F, 50.604076F, 44.0F, 51.799438F);
      ((Path)localObject).lineTo(44.0F, 52.0F);
      ((Path)localObject).lineTo(20.0F, 52.0F);
      ((Path)localObject).lineTo(20.0F, 46.0F);
      ((Path)localObject).lineTo(44.0F, 46.0F);
      ((Path)localObject).lineTo(44.0F, 46.167912F);
      ((Path)localObject).cubicTo(47.531811F, 44.624798F, 50.0F, 41.100639F, 50.0F, 37.0F);
      ((Path)localObject).cubicTo(50.0F, 32.078758F, 46.445118F, 27.987804F, 41.763157F, 27.15494F);
      ((Path)localObject).lineTo(41.763157F, 27.0F);
      ((Path)localObject).lineTo(21.0F, 27.0F);
      ((Path)localObject).lineTo(21.0F, 32.99984F);
      ((Path)localObject).cubicTo(21.0F, 34.664913F, 19.933712F, 35.176052F, 18.61838F, 34.159657F);
      ((Path)localObject).lineTo(6.88162F, 25.090343F);
      ((Path)localObject).cubicTo(5.55725F, 24.066965F, 5.566288F, 22.42605F, 6.88162F, 21.409657F);
      ((Path)localObject).lineTo(18.61838F, 12.340343F);
      ((Path)localObject).cubicTo(19.942751F, 11.316965F, 21.0F, 11.843217F, 21.0F, 13.500159F);
      ((Path)localObject).lineTo(21.0F, 21.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bsz
 * JD-Core Version:    0.7.0.1
 */