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

public class icons_filled_open
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
      ((Path)localObject).moveTo(57.0F, 9.0F);
      ((Path)localObject).cubicTo(60.313709F, 9.0F, 63.0F, 11.686292F, 63.0F, 15.0F);
      ((Path)localObject).lineTo(63.0F, 57.0F);
      ((Path)localObject).cubicTo(63.0F, 60.313709F, 60.313709F, 63.0F, 57.0F, 63.0F);
      ((Path)localObject).lineTo(15.0F, 63.0F);
      ((Path)localObject).cubicTo(11.686292F, 63.0F, 9.0F, 60.313709F, 9.0F, 57.0F);
      ((Path)localObject).lineTo(9.0F, 15.0F);
      ((Path)localObject).cubicTo(9.0F, 11.686292F, 11.686292F, 9.0F, 15.0F, 9.0F);
      ((Path)localObject).lineTo(57.0F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(54.0F, 18.0F);
      ((Path)localObject).lineTo(18.0F, 18.0F);
      ((Path)localObject).lineTo(18.0F, 54.0F);
      ((Path)localObject).lineTo(54.0F, 54.0F);
      ((Path)localObject).lineTo(54.0F, 18.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 27.0F);
      ((Path)localObject).cubicTo(40.970562F, 27.0F, 45.0F, 31.029438F, 45.0F, 36.0F);
      ((Path)localObject).cubicTo(45.0F, 40.970562F, 40.970562F, 45.0F, 36.0F, 45.0F);
      ((Path)localObject).cubicTo(31.029438F, 45.0F, 27.0F, 40.970562F, 27.0F, 36.0F);
      ((Path)localObject).cubicTo(27.0F, 31.029438F, 31.029438F, 27.0F, 36.0F, 27.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_open
 * JD-Core Version:    0.7.0.1
 */