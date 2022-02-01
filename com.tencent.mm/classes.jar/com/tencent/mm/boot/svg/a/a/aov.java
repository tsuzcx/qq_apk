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

public final class aov
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
      ((Path)localObject).moveTo(50.71693F, 17.040428F);
      ((Path)localObject).cubicTo(46.652882F, 13.881245F, 41.546135F, 12.0F, 36.0F, 12.0F);
      ((Path)localObject).cubicTo(22.745167F, 12.0F, 12.0F, 22.745167F, 12.0F, 36.0F);
      ((Path)localObject).cubicTo(12.0F, 49.254833F, 22.745167F, 60.0F, 36.0F, 60.0F);
      ((Path)localObject).cubicTo(49.254833F, 60.0F, 60.0F, 49.254833F, 60.0F, 36.0F);
      ((Path)localObject).cubicTo(60.0F, 30.453865F, 58.118755F, 25.34712F, 54.959572F, 21.283068F);
      ((Path)localObject).lineTo(50.672245F, 25.570396F);
      ((Path)localObject).cubicTo(52.767628F, 28.512854F, 54.0F, 32.112507F, 54.0F, 36.0F);
      ((Path)localObject).cubicTo(54.0F, 45.941124F, 45.941124F, 54.0F, 36.0F, 54.0F);
      ((Path)localObject).cubicTo(26.058874F, 54.0F, 18.0F, 45.941124F, 18.0F, 36.0F);
      ((Path)localObject).cubicTo(18.0F, 26.058874F, 26.058874F, 18.0F, 36.0F, 18.0F);
      ((Path)localObject).cubicTo(39.887493F, 18.0F, 43.487148F, 19.232372F, 46.429604F, 21.327757F);
      ((Path)localObject).lineTo(50.71693F, 17.040428F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(42.095901F, 25.661457F);
      ((Path)localObject).cubicTo(40.309361F, 24.605787F, 38.225426F, 24.0F, 36.0F, 24.0F);
      ((Path)localObject).cubicTo(29.372583F, 24.0F, 24.0F, 29.372583F, 24.0F, 36.0F);
      ((Path)localObject).cubicTo(24.0F, 42.627419F, 29.372583F, 48.0F, 36.0F, 48.0F);
      ((Path)localObject).cubicTo(42.627419F, 48.0F, 48.0F, 42.627419F, 48.0F, 36.0F);
      ((Path)localObject).cubicTo(48.0F, 33.774574F, 47.394211F, 31.690638F, 46.338543F, 29.904099F);
      ((Path)localObject).lineTo(41.796772F, 34.445869F);
      ((Path)localObject).cubicTo(41.929329F, 34.941551F, 42.0F, 35.462521F, 42.0F, 36.0F);
      ((Path)localObject).cubicTo(42.0F, 39.313709F, 39.313709F, 42.0F, 36.0F, 42.0F);
      ((Path)localObject).cubicTo(32.686291F, 42.0F, 30.0F, 39.313709F, 30.0F, 36.0F);
      ((Path)localObject).cubicTo(30.0F, 32.686291F, 32.686291F, 30.0F, 36.0F, 30.0F);
      ((Path)localObject).cubicTo(36.537479F, 30.0F, 37.058449F, 30.070671F, 37.554131F, 30.20323F);
      ((Path)localObject).lineTo(42.095901F, 25.661457F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aov
 * JD-Core Version:    0.7.0.1
 */