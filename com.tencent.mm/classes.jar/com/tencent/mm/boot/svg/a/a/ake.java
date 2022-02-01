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

public final class ake
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
      ((Path)localObject).moveTo(36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.974991F, 23.549999F);
      ((Path)localObject).lineTo(35.549999F, 23.549999F);
      ((Path)localObject).lineTo(35.553001F, 48.450001F);
      ((Path)localObject).lineTo(40.053001F, 48.450001F);
      ((Path)localObject).lineTo(40.053001F, 35.031773F);
      ((Path)localObject).lineTo(43.125687F, 42.450001F);
      ((Path)localObject).lineTo(47.476822F, 42.450001F);
      ((Path)localObject).lineTo(50.553001F, 35.043182F);
      ((Path)localObject).lineTo(50.553001F, 48.450001F);
      ((Path)localObject).lineTo(55.053001F, 48.450001F);
      ((Path)localObject).lineTo(55.053001F, 23.549999F);
      ((Path)localObject).lineTo(50.646057F, 23.549999F);
      ((Path)localObject).lineTo(45.30732F, 36.265926F);
      ((Path)localObject).lineTo(39.974991F, 23.549999F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(25.202999F, 23.549999F);
      ((Path)localObject).lineTo(16.952999F, 23.549999F);
      ((Path)localObject).lineTo(16.950001F, 48.450001F);
      ((Path)localObject).lineTo(21.450001F, 48.450001F);
      ((Path)localObject).lineTo(21.45285F, 39.450001F);
      ((Path)localObject).lineTo(23.652817F, 39.450001F);
      ((Path)localObject).lineTo(29.219999F, 48.450001F);
      ((Path)localObject).lineTo(34.4935F, 48.450001F);
      ((Path)localObject).lineTo(28.499161F, 38.736671F);
      ((Path)localObject).cubicTo(31.297434F, 37.461887F, 33.153F, 34.655556F, 33.153F, 31.5F);
      ((Path)localObject).cubicTo(33.153F, 27.109337F, 29.593664F, 23.549999F, 25.202999F, 23.549999F);
      ((Path)localObject).lineTo(25.202999F, 23.549999F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.452999F, 27.447321F);
      ((Path)localObject).lineTo(25.202999F, 27.450001F);
      ((Path)localObject).lineTo(25.593042F, 27.46854F);
      ((Path)localObject).cubicTo(27.646803F, 27.664789F, 29.253F, 29.394821F, 29.253F, 31.5F);
      ((Path)localObject).cubicTo(29.253F, 33.736752F, 27.439753F, 35.549999F, 25.202999F, 35.549999F);
      ((Path)localObject).lineTo(25.202999F, 35.549999F);
      ((Path)localObject).lineTo(21.452999F, 35.547321F);
      ((Path)localObject).lineTo(21.452999F, 27.447321F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ake
 * JD-Core Version:    0.7.0.1
 */