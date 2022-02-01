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

public class icons_outlined_download
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
      ((Path)localObject).moveTo(56.400002F, 24.6F);
      ((Path)localObject).lineTo(48.0F, 24.6F);
      ((Path)localObject).lineTo(48.0F, 21.0F);
      ((Path)localObject).lineTo(57.003132F, 21.0F);
      ((Path)localObject).cubicTo(58.652611F, 21.0F, 60.0F, 22.337517F, 60.0F, 23.987425F);
      ((Path)localObject).lineTo(60.0F, 63.012573F);
      ((Path)localObject).cubicTo(60.0F, 64.653236F, 58.662483F, 66.0F, 57.012573F, 66.0F);
      ((Path)localObject).lineTo(14.987426F, 66.0F);
      ((Path)localObject).cubicTo(13.346761F, 66.0F, 12.0F, 64.662483F, 12.0F, 63.012573F);
      ((Path)localObject).lineTo(12.0F, 23.987425F);
      ((Path)localObject).cubicTo(12.0F, 22.34676F, 13.341744F, 21.0F, 14.99687F, 21.0F);
      ((Path)localObject).lineTo(24.0F, 21.0F);
      ((Path)localObject).lineTo(24.0F, 24.6F);
      ((Path)localObject).lineTo(15.6F, 24.6F);
      ((Path)localObject).lineTo(15.6F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 24.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.79998F, 37.85149F);
      ((Path)localObject).lineTo(44.061016F, 31.590454F);
      ((Path)localObject).lineTo(46.606602F, 34.13604F);
      ((Path)localObject).lineTo(38.121319F, 42.621319F);
      ((Path)localObject).cubicTo(36.949749F, 43.792892F, 35.050251F, 43.792892F, 33.878681F, 42.621319F);
      ((Path)localObject).lineTo(25.393398F, 34.13604F);
      ((Path)localObject).lineTo(27.938982F, 31.590454F);
      ((Path)localObject).lineTo(34.199982F, 37.851452F);
      ((Path)localObject).lineTo(34.199982F, 6.0F);
      ((Path)localObject).lineTo(37.79998F, 6.0F);
      ((Path)localObject).lineTo(37.79998F, 37.85149F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_download
 * JD-Core Version:    0.7.0.1
 */