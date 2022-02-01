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

public class voice_to_short
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(40.0F, 73.333336F);
      ((Path)localObject).cubicTo(21.590508F, 73.333336F, 6.666667F, 58.409492F, 6.666667F, 40.0F);
      ((Path)localObject).cubicTo(6.666667F, 21.590508F, 21.590508F, 6.666667F, 40.0F, 6.666667F);
      ((Path)localObject).cubicTo(58.409492F, 6.666667F, 73.333336F, 21.590508F, 73.333336F, 40.0F);
      ((Path)localObject).cubicTo(73.333336F, 58.409492F, 58.409492F, 73.333336F, 40.0F, 73.333336F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.45573F, 20.452475F);
      ((Path)localObject).lineTo(37.820313F, 45.774738F);
      ((Path)localObject).lineTo(42.172527F, 45.774738F);
      ((Path)localObject).lineTo(42.537109F, 20.452475F);
      ((Path)localObject).lineTo(37.45573F, 20.452475F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.985027F, 57.008465F);
      ((Path)localObject).cubicTo(41.694012F, 57.008465F, 42.99284F, 55.732422F, 42.99284F, 54.069012F);
      ((Path)localObject).cubicTo(42.99284F, 52.405598F, 41.694012F, 51.129559F, 39.985027F, 51.129559F);
      ((Path)localObject).cubicTo(38.321617F, 51.129559F, 37.0F, 52.405598F, 37.0F, 54.069012F);
      ((Path)localObject).cubicTo(37.0F, 55.732422F, 38.321617F, 57.008465F, 39.985027F, 57.008465F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.voice_to_short
 * JD-Core Version:    0.7.0.1
 */