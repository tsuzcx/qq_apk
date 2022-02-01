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

public class friendactivity_comment_writeicon_golden_pressed
  extends c
{
  private final int height = 48;
  private final int width = 54;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 54;
      return 48;
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
      localPaint.setColor(-7503);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(21.993774F, 38.0F);
      ((Path)localObject).lineTo(51.000439F, 38.0F);
      ((Path)localObject).cubicTo(52.665161F, 38.0F, 54.0F, 36.657902F, 54.0F, 35.002338F);
      ((Path)localObject).lineTo(54.0F, 2.99766F);
      ((Path)localObject).cubicTo(54.0F, 1.35244F, 52.657051F, 0.0F, 51.000439F, 0.0F);
      ((Path)localObject).lineTo(2.999561F, 0.0F);
      ((Path)localObject).cubicTo(1.334839F, 0.0F, 0.0F, 1.342098F, 0.0F, 2.99766F);
      ((Path)localObject).lineTo(0.0F, 35.002338F);
      ((Path)localObject).cubicTo(0.0F, 36.64756F, 1.342949F, 38.0F, 2.999561F, 38.0F);
      ((Path)localObject).lineTo(9.0F, 38.0F);
      ((Path)localObject).lineTo(9.0F, 47.950085F);
      ((Path)localObject).lineTo(21.993774F, 38.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.0F, 32.0F);
      ((Path)localObject).lineTo(48.0F, 32.0F);
      ((Path)localObject).lineTo(48.0F, 6.0F);
      ((Path)localObject).lineTo(6.0F, 6.0F);
      ((Path)localObject).lineTo(6.0F, 32.0F);
      ((Path)localObject).lineTo(15.0F, 32.0F);
      ((Path)localObject).lineTo(15.0F, 36.0F);
      ((Path)localObject).lineTo(19.0F, 32.0F);
      ((Path)localObject).lineTo(19.0F, 32.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.friendactivity_comment_writeicon_golden_pressed
 * JD-Core Version:    0.7.0.1
 */