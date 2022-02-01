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

public class icons_filled_link
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(52.970562F, 36.0F);
      ((Path)localObject).lineTo(48.727921F, 31.757359F);
      ((Path)localObject).lineTo(55.091885F, 25.393398F);
      ((Path)localObject).cubicTo(57.435028F, 23.050253F, 57.435028F, 19.251263F, 55.091885F, 16.908117F);
      ((Path)localObject).cubicTo(52.748737F, 14.564971F, 48.949749F, 14.564971F, 46.606602F, 16.908117F);
      ((Path)localObject).lineTo(33.878681F, 29.63604F);
      ((Path)localObject).cubicTo(31.535534F, 31.979185F, 31.535534F, 35.778175F, 33.878681F, 38.121319F);
      ((Path)localObject).lineTo(29.63604F, 42.36396F);
      ((Path)localObject).cubicTo(24.949747F, 37.67767F, 24.949747F, 30.079689F, 29.63604F, 25.393398F);
      ((Path)localObject).lineTo(42.36396F, 12.665476F);
      ((Path)localObject).cubicTo(47.050251F, 7.979185F, 54.648232F, 7.979185F, 59.334522F, 12.665476F);
      ((Path)localObject).cubicTo(64.020813F, 17.351768F, 64.020813F, 24.949747F, 59.334522F, 29.63604F);
      ((Path)localObject).lineTo(52.970562F, 36.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.029438F, 36.0F);
      ((Path)localObject).lineTo(23.272078F, 40.242641F);
      ((Path)localObject).lineTo(16.908117F, 46.606602F);
      ((Path)localObject).cubicTo(14.564971F, 48.949749F, 14.564971F, 52.748737F, 16.908117F, 55.091885F);
      ((Path)localObject).cubicTo(19.251263F, 57.435028F, 23.050253F, 57.435028F, 25.393398F, 55.091885F);
      ((Path)localObject).lineTo(38.121319F, 42.36396F);
      ((Path)localObject).cubicTo(40.464466F, 40.020817F, 40.464466F, 36.221825F, 38.121319F, 33.878681F);
      ((Path)localObject).lineTo(42.36396F, 29.63604F);
      ((Path)localObject).cubicTo(47.050251F, 34.32233F, 47.050251F, 41.920311F, 42.36396F, 46.606602F);
      ((Path)localObject).lineTo(29.63604F, 59.334522F);
      ((Path)localObject).cubicTo(24.949747F, 64.020813F, 17.351768F, 64.020813F, 12.665476F, 59.334522F);
      ((Path)localObject).cubicTo(7.979185F, 54.648232F, 7.979185F, 47.050251F, 12.665476F, 42.36396F);
      ((Path)localObject).lineTo(19.029438F, 36.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_link
 * JD-Core Version:    0.7.0.1
 */