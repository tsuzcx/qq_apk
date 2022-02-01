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

public class icons_filled_pause2
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 2.0F);
      ((Path)localObject).cubicTo(17.522848F, 2.0F, 22.0F, 6.477152F, 22.0F, 12.0F);
      ((Path)localObject).cubicTo(22.0F, 17.522848F, 17.522848F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject).cubicTo(6.477152F, 22.0F, 2.0F, 17.522848F, 2.0F, 12.0F);
      ((Path)localObject).cubicTo(2.0F, 6.477152F, 6.477152F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.25F, 8.25F);
      ((Path)localObject).lineTo(9.25F, 8.25F);
      ((Path)localObject).cubicTo(8.973858F, 8.25F, 8.75F, 8.473858F, 8.75F, 8.75F);
      ((Path)localObject).lineTo(8.75F, 8.75F);
      ((Path)localObject).lineTo(8.75F, 15.25F);
      ((Path)localObject).cubicTo(8.75F, 15.526142F, 8.973858F, 15.75F, 9.25F, 15.75F);
      ((Path)localObject).lineTo(9.25F, 15.75F);
      ((Path)localObject).lineTo(10.25F, 15.75F);
      ((Path)localObject).cubicTo(10.526142F, 15.75F, 10.75F, 15.526142F, 10.75F, 15.25F);
      ((Path)localObject).lineTo(10.75F, 15.25F);
      ((Path)localObject).lineTo(10.75F, 8.75F);
      ((Path)localObject).cubicTo(10.75F, 8.473858F, 10.526142F, 8.25F, 10.25F, 8.25F);
      ((Path)localObject).lineTo(10.25F, 8.25F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.75F, 8.25F);
      ((Path)localObject).lineTo(13.75F, 8.25F);
      ((Path)localObject).cubicTo(13.473858F, 8.25F, 13.25F, 8.473858F, 13.25F, 8.75F);
      ((Path)localObject).lineTo(13.25F, 8.75F);
      ((Path)localObject).lineTo(13.25F, 15.25F);
      ((Path)localObject).cubicTo(13.25F, 15.526142F, 13.473858F, 15.75F, 13.75F, 15.75F);
      ((Path)localObject).lineTo(13.75F, 15.75F);
      ((Path)localObject).lineTo(14.75F, 15.75F);
      ((Path)localObject).cubicTo(15.026142F, 15.75F, 15.25F, 15.526142F, 15.25F, 15.25F);
      ((Path)localObject).lineTo(15.25F, 15.25F);
      ((Path)localObject).lineTo(15.25F, 8.75F);
      ((Path)localObject).cubicTo(15.25F, 8.473858F, 15.026142F, 8.25F, 14.75F, 8.25F);
      ((Path)localObject).lineTo(14.75F, 8.25F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_pause2
 * JD-Core Version:    0.7.0.1
 */