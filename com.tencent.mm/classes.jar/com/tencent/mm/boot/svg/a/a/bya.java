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

public final class bya
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
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      Paint localPaint2 = c.a(localPaint1, paramVarArgs);
      Paint localPaint3 = c.a((Paint)localObject, paramVarArgs);
      localPaint2.setColor(-1);
      localPaint3.setColor(855638016);
      localPaint3.setStrokeWidth(1.5F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.75F, 0.75F);
      ((Path)localObject).lineTo(71.25F, 0.75F);
      ((Path)localObject).lineTo(71.25F, 71.25F);
      ((Path)localObject).lineTo(0.75F, 71.25F);
      ((Path)localObject).lineTo(0.75F, 0.75F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint3 = c.a(localPaint3, paramVarArgs);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.drawPath((Path)localObject, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(24.0F, 27.0F);
      ((Path)localObject).lineTo(24.0F, 30.6F);
      ((Path)localObject).lineTo(15.6F, 30.6F);
      ((Path)localObject).lineTo(15.6F, 56.400002F);
      ((Path)localObject).lineTo(56.400002F, 56.400002F);
      ((Path)localObject).lineTo(56.400002F, 30.6F);
      ((Path)localObject).lineTo(48.0F, 30.6F);
      ((Path)localObject).lineTo(48.0F, 27.0F);
      ((Path)localObject).lineTo(57.003132F, 27.0F);
      ((Path)localObject).cubicTo(58.652611F, 27.0F, 60.0F, 28.337517F, 60.0F, 29.987425F);
      ((Path)localObject).lineTo(60.0F, 57.012573F);
      ((Path)localObject).cubicTo(60.0F, 58.65324F, 58.662483F, 60.0F, 57.012573F, 60.0F);
      ((Path)localObject).lineTo(14.987426F, 60.0F);
      ((Path)localObject).cubicTo(13.346761F, 60.0F, 12.0F, 58.662483F, 12.0F, 57.012573F);
      ((Path)localObject).lineTo(12.0F, 29.987425F);
      ((Path)localObject).cubicTo(12.0F, 28.34676F, 13.341744F, 27.0F, 14.99687F, 27.0F);
      ((Path)localObject).lineTo(24.0F, 27.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.121319F, 11.014719F);
      ((Path)localObject).lineTo(46.606602F, 19.5F);
      ((Path)localObject).lineTo(44.061016F, 22.045584F);
      ((Path)localObject).lineTo(37.79998F, 15.784549F);
      ((Path)localObject).lineTo(37.79998F, 43.5F);
      ((Path)localObject).lineTo(34.199982F, 43.5F);
      ((Path)localObject).lineTo(34.199982F, 15.784586F);
      ((Path)localObject).lineTo(27.938982F, 22.045584F);
      ((Path)localObject).lineTo(25.393398F, 19.5F);
      ((Path)localObject).lineTo(33.878681F, 11.014719F);
      ((Path)localObject).cubicTo(35.050251F, 9.843145F, 36.949749F, 9.843145F, 38.121319F, 11.014719F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bya
 * JD-Core Version:    0.7.0.1
 */