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

public class multitask_indicator_full_scale_icon
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
      ((Path)localObject).moveTo(49.5F, 30.0F);
      ((Path)localObject).cubicTo(52.813709F, 30.0F, 55.5F, 32.686291F, 55.5F, 36.0F);
      ((Path)localObject).cubicTo(55.5F, 39.313709F, 52.813709F, 42.0F, 49.5F, 42.0F);
      ((Path)localObject).cubicTo(46.186291F, 42.0F, 43.5F, 39.313709F, 43.5F, 36.0F);
      ((Path)localObject).cubicTo(43.5F, 32.686291F, 46.186291F, 30.0F, 49.5F, 30.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.5F, 30.0F);
      ((Path)localObject).cubicTo(25.813709F, 30.0F, 28.5F, 32.686291F, 28.5F, 36.0F);
      ((Path)localObject).cubicTo(28.5F, 39.313709F, 25.813709F, 42.0F, 22.5F, 42.0F);
      ((Path)localObject).cubicTo(19.186291F, 42.0F, 16.5F, 39.313709F, 16.5F, 36.0F);
      ((Path)localObject).cubicTo(16.5F, 32.686291F, 19.186291F, 30.0F, 22.5F, 30.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.multitask_indicator_full_scale_icon
 * JD-Core Version:    0.7.0.1
 */