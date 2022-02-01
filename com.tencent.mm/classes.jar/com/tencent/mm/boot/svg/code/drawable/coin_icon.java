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

public class coin_icon
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      ((Path)localObject).moveTo(18.626717F, 6.572781F);
      ((Path)localObject).cubicTo(17.614721F, 5.560786F, 16.293728F, 4.994788F, 14.843735F, 4.844789F);
      ((Path)localObject).cubicTo(14.660735F, 5.292787F, 14.376737F, 5.798784F, 13.947739F, 6.390782F);
      ((Path)localObject).cubicTo(12.732745F, 8.068773F, 10.871754F, 8.86377F, 10.871754F, 8.86377F);
      ((Path)localObject).cubicTo(10.871754F, 8.86377F, 12.822744F, 6.78678F, 13.053743F, 4.799789F);
      ((Path)localObject).cubicTo(13.168742F, 3.810794F, 12.965744F, 2.5788F, 12.525745F, 2.133802F);
      ((Path)localObject).cubicTo(12.263747F, 1.866803F, 11.814749F, 2.022802F, 11.777749F, 2.394801F);
      ((Path)localObject).cubicTo(11.718749F, 3.004798F, 11.491751F, 3.839794F, 10.897754F, 4.63179F);
      ((Path)localObject).cubicTo(10.421756F, 5.266787F, 9.41176F, 5.998784F, 9.050762F, 6.249783F);
      ((Path)localObject).cubicTo(8.180766F, 6.76078F, 7.34177F, 7.400777F, 6.570774F, 8.171773F);
      ((Path)localObject).cubicTo(2.800792F, 11.941755F, 2.084796F, 17.339729F, 4.972782F, 20.227716F);
      ((Path)localObject).cubicTo(7.859768F, 23.114702F, 13.257742F, 22.399706F, 17.027725F, 18.628723F);
      ((Path)localObject).cubicTo(20.798706F, 14.857741F, 21.514704F, 9.460767F, 18.626717F, 6.572781F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.coin_icon
 * JD-Core Version:    0.7.0.1
 */