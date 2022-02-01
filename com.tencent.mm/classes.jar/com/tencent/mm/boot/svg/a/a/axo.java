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

public final class axo
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(48.0F, 37.500957F);
      ((Path)localObject).cubicTo(44.632545F, 35.047546F, 40.485321F, 33.599998F, 36.0F, 33.599998F);
      ((Path)localObject).cubicTo(30.366695F, 33.599998F, 25.266695F, 35.883347F, 21.575022F, 39.57502F);
      ((Path)localObject).lineTo(19.029438F, 37.029438F);
      ((Path)localObject).cubicTo(23.372583F, 32.686291F, 29.372583F, 30.0F, 36.0F, 30.0F);
      ((Path)localObject).cubicTo(40.371445F, 30.0F, 44.469921F, 31.168732F, 48.0F, 33.210773F);
      ((Path)localObject).lineTo(48.0F, 37.500957F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 27.152483F);
      ((Path)localObject).cubicTo(44.335747F, 25.512175F, 40.274399F, 24.6F, 36.0F, 24.6F);
      ((Path)localObject).cubicTo(27.881414F, 24.6F, 20.531414F, 27.890707F, 15.211061F, 33.21106F);
      ((Path)localObject).lineTo(12.665476F, 30.665476F);
      ((Path)localObject).cubicTo(18.637302F, 24.693651F, 26.887302F, 21.0F, 36.0F, 21.0F);
      ((Path)localObject).cubicTo(40.233501F, 21.0F, 44.280811F, 21.79719F, 48.0F, 23.249641F);
      ((Path)localObject).lineTo(48.0F, 27.152483F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(31.757359F, 49.757359F);
      ((Path)localObject).cubicTo(32.843147F, 48.671574F, 34.343147F, 48.0F, 36.0F, 48.0F);
      ((Path)localObject).cubicTo(37.656853F, 48.0F, 39.156853F, 48.671574F, 40.242641F, 49.757359F);
      ((Path)localObject).lineTo(36.0F, 54.0F);
      ((Path)localObject).lineTo(31.757359F, 49.757359F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(44.061016F, 45.938984F);
      ((Path)localObject).cubicTo(41.998024F, 43.875988F, 39.148022F, 42.599998F, 36.0F, 42.599998F);
      ((Path)localObject).cubicTo(32.851978F, 42.599998F, 30.001976F, 43.875988F, 27.938982F, 45.938984F);
      ((Path)localObject).lineTo(25.393398F, 43.393398F);
      ((Path)localObject).cubicTo(28.107864F, 40.678932F, 31.857864F, 39.0F, 36.0F, 39.0F);
      ((Path)localObject).cubicTo(40.142136F, 39.0F, 43.892136F, 40.678932F, 46.606602F, 43.393398F);
      ((Path)localObject).lineTo(44.061016F, 45.938984F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(51.473682F, 25.5F);
      ((Path)localObject).lineTo(55.026318F, 25.5F);
      ((Path)localObject).lineTo(54.789474F, 44.526318F);
      ((Path)localObject).lineTo(51.710526F, 44.526318F);
      ((Path)localObject).lineTo(51.473682F, 25.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(53.25F, 54.177631F);
      ((Path)localObject).cubicTo(51.986843F, 54.177631F, 51.0F, 53.190788F, 51.0F, 51.927631F);
      ((Path)localObject).cubicTo(51.0F, 50.644737F, 51.986843F, 49.677631F, 53.25F, 49.677631F);
      ((Path)localObject).cubicTo(54.532894F, 49.677631F, 55.5F, 50.644737F, 55.5F, 51.927631F);
      ((Path)localObject).cubicTo(55.5F, 53.190788F, 54.532894F, 54.177631F, 53.25F, 54.177631F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.axo
 * JD-Core Version:    0.7.0.1
 */