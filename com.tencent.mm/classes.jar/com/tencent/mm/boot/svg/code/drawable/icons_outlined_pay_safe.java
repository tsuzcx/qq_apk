package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_outlined_pay_safe
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 7.5F);
      ((Path)localObject).lineTo(60.0F, 16.5F);
      ((Path)localObject).lineTo(60.0F, 33.761368F);
      ((Path)localObject).cubicTo(60.0F, 48.30043F, 50.104965F, 60.973759F, 36.0F, 64.5F);
      ((Path)localObject).cubicTo(21.895035F, 60.973759F, 12.0F, 48.30043F, 12.0F, 33.761368F);
      ((Path)localObject).lineTo(12.0F, 16.5F);
      ((Path)localObject).lineTo(36.0F, 7.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 11.210795F);
      ((Path)localObject).lineTo(15.6F, 19.310795F);
      ((Path)localObject).lineTo(15.6F, 33.761368F);
      ((Path)localObject).cubicTo(15.6F, 46.346371F, 23.964329F, 57.354259F, 36.0F, 60.774364F);
      ((Path)localObject).cubicTo(48.035671F, 57.354259F, 56.400002F, 46.346371F, 56.400002F, 33.761368F);
      ((Path)localObject).lineTo(56.400734F, 30.980385F);
      ((Path)localObject).cubicTo(46.563309F, 36.305576F, 30.986734F, 44.73748F, 30.986734F, 44.73748F);
      ((Path)localObject).lineTo(30.807501F, 44.834969F);
      ((Path)localObject).cubicTo(30.586174F, 44.938831F, 30.337011F, 45.0F, 30.072912F, 45.0F);
      ((Path)localObject).cubicTo(29.45985F, 45.0F, 28.926901F, 44.683319F, 28.647186F, 44.21563F);
      ((Path)localObject).lineTo(28.540596F, 43.996437F);
      ((Path)localObject).lineTo(24.078075F, 34.806988F);
      ((Path)localObject).cubicTo(24.029873F, 34.706947F, 24.0F, 34.593529F, 24.0F, 34.483295F);
      ((Path)localObject).cubicTo(24.0F, 34.060207F, 24.365936F, 33.717403F, 24.816736F, 33.717403F);
      ((Path)localObject).cubicTo(25.001402F, 33.717403F, 25.169094F, 33.774113F, 25.306236F, 33.86969F);
      ((Path)localObject).lineTo(30.571238F, 37.387577F);
      ((Path)localObject).cubicTo(30.954824F, 37.623333F, 31.41581F, 37.762241F, 31.910061F, 37.762241F);
      ((Path)localObject).cubicTo(32.204033F, 37.762241F, 32.485783F, 37.711266F, 32.747166F, 37.621422F);
      ((Path)localObject).cubicTo(32.747166F, 37.621422F, 49.806355F, 30.513344F, 56.400188F, 27.771275F);
      ((Path)localObject).lineTo(56.400002F, 19.310795F);
      ((Path)localObject).lineTo(36.0F, 11.210795F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_pay_safe
 * JD-Core Version:    0.7.0.1
 */