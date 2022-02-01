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

public class icons_outlined_note
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
      ((Path)localObject).moveTo(24.6F, 9.6F);
      ((Path)localObject).lineTo(24.6F, 53.427879F);
      ((Path)localObject).lineTo(54.0F, 53.427879F);
      ((Path)localObject).cubicTo(55.325485F, 53.427879F, 56.400002F, 52.353363F, 56.400002F, 51.027878F);
      ((Path)localObject).lineTo(56.400002F, 45.600037F);
      ((Path)localObject).lineTo(56.400002F, 12.0F);
      ((Path)localObject).cubicTo(56.400002F, 10.674517F, 55.325485F, 9.6F, 54.0F, 9.6F);
      ((Path)localObject).lineTo(24.6F, 9.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.0F, 9.6F);
      ((Path)localObject).lineTo(15.6F, 9.6F);
      ((Path)localObject).lineTo(15.6F, 53.427879F);
      ((Path)localObject).lineTo(21.0F, 53.427879F);
      ((Path)localObject).lineTo(21.0F, 9.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(56.400002F, 56.528625F);
      ((Path)localObject).cubicTo(55.665047F, 56.849739F, 54.853325F, 57.027878F, 54.0F, 57.027878F);
      ((Path)localObject).lineTo(15.6F, 57.027878F);
      ((Path)localObject).lineTo(15.6F, 62.400002F);
      ((Path)localObject).lineTo(54.0F, 62.400002F);
      ((Path)localObject).cubicTo(55.325485F, 62.400002F, 56.400002F, 61.325485F, 56.400002F, 60.0F);
      ((Path)localObject).lineTo(56.400002F, 56.528625F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 6.0F);
      ((Path)localObject).lineTo(54.0F, 6.0F);
      ((Path)localObject).cubicTo(57.313709F, 6.0F, 60.0F, 8.686292F, 60.0F, 12.0F);
      ((Path)localObject).lineTo(60.0F, 60.0F);
      ((Path)localObject).cubicTo(60.0F, 63.313709F, 57.313709F, 66.0F, 54.0F, 66.0F);
      ((Path)localObject).lineTo(12.0F, 66.0F);
      ((Path)localObject).lineTo(12.0F, 6.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_note
 * JD-Core Version:    0.7.0.1
 */