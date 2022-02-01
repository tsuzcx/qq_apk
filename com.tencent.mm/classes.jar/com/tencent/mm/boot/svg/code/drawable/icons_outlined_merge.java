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

public class icons_outlined_merge
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
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(57.012573F, 12.0F);
      ((Path)localObject).cubicTo(58.65324F, 12.0F, 60.0F, 13.337516F, 60.0F, 14.987426F);
      ((Path)localObject).lineTo(60.0F, 57.012573F);
      ((Path)localObject).cubicTo(60.0F, 58.65324F, 58.662483F, 60.0F, 57.012573F, 60.0F);
      ((Path)localObject).lineTo(38.987427F, 60.0F);
      ((Path)localObject).cubicTo(37.34676F, 60.0F, 36.0F, 58.658257F, 36.0F, 57.003132F);
      ((Path)localObject).lineTo(36.0F, 48.0F);
      ((Path)localObject).lineTo(39.599998F, 48.0F);
      ((Path)localObject).lineTo(39.599998F, 56.400002F);
      ((Path)localObject).lineTo(56.400002F, 56.400002F);
      ((Path)localObject).lineTo(56.400002F, 15.6F);
      ((Path)localObject).lineTo(39.599998F, 15.6F);
      ((Path)localObject).lineTo(39.599998F, 24.0F);
      ((Path)localObject).lineTo(36.0F, 24.0F);
      ((Path)localObject).lineTo(36.0F, 14.99687F);
      ((Path)localObject).cubicTo(36.0F, 13.347391F, 37.337517F, 12.0F, 38.987427F, 12.0F);
      ((Path)localObject).lineTo(57.012573F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.012575F, 12.0F);
      ((Path)localObject).cubicTo(31.65324F, 12.0F, 33.0F, 13.341744F, 33.0F, 14.99687F);
      ((Path)localObject).lineTo(33.0F, 24.0F);
      ((Path)localObject).lineTo(29.4F, 24.0F);
      ((Path)localObject).lineTo(29.4F, 15.6F);
      ((Path)localObject).lineTo(12.6F, 15.6F);
      ((Path)localObject).lineTo(12.6F, 56.400002F);
      ((Path)localObject).lineTo(29.4F, 56.400002F);
      ((Path)localObject).lineTo(29.4F, 48.0F);
      ((Path)localObject).lineTo(33.0F, 48.0F);
      ((Path)localObject).lineTo(33.0F, 57.003132F);
      ((Path)localObject).cubicTo(33.0F, 58.652611F, 31.662483F, 60.0F, 30.012575F, 60.0F);
      ((Path)localObject).lineTo(11.987426F, 60.0F);
      ((Path)localObject).cubicTo(10.346761F, 60.0F, 9.0F, 58.662483F, 9.0F, 57.012573F);
      ((Path)localObject).lineTo(9.0F, 14.987426F);
      ((Path)localObject).cubicTo(9.0F, 13.346761F, 10.337516F, 12.0F, 11.987426F, 12.0F);
      ((Path)localObject).lineTo(30.012575F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(25.263962F, 25.5F);
      ((Path)localObject).lineTo(27.809546F, 28.045584F);
      ((Path)localObject).lineTo(21.548546F, 34.306583F);
      ((Path)localObject).lineTo(50.400002F, 34.306583F);
      ((Path)localObject).lineTo(50.400002F, 37.906582F);
      ((Path)localObject).lineTo(21.54851F, 37.906582F);
      ((Path)localObject).lineTo(27.809546F, 44.167618F);
      ((Path)localObject).lineTo(25.263962F, 46.713203F);
      ((Path)localObject).lineTo(16.778679F, 38.227921F);
      ((Path)localObject).cubicTo(15.607107F, 37.056351F, 15.607107F, 35.156853F, 16.778679F, 33.985283F);
      ((Path)localObject).lineTo(25.263962F, 25.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_merge
 * JD-Core Version:    0.7.0.1
 */