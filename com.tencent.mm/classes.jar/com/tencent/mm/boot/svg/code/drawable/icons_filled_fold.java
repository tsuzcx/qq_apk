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

public class icons_filled_fold
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
      ((Path)localObject).moveTo(8.498932F, 14.5F);
      ((Path)localObject).cubicTo(9.051217F, 14.5F, 9.498932F, 14.947716F, 9.498932F, 15.5F);
      ((Path)localObject).lineTo(9.498932F, 21.002014F);
      ((Path)localObject).lineTo(7.498932F, 21.002014F);
      ((Path)localObject).lineTo(7.498932F, 16.5F);
      ((Path)localObject).lineTo(3.003082F, 16.5F);
      ((Path)localObject).lineTo(3.003082F, 14.5F);
      ((Path)localObject).lineTo(8.498932F, 14.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.002014F, 14.5F);
      ((Path)localObject).lineTo(21.002014F, 16.5F);
      ((Path)localObject).lineTo(16.5F, 16.5F);
      ((Path)localObject).lineTo(16.5F, 20.99585F);
      ((Path)localObject).lineTo(14.5F, 20.99585F);
      ((Path)localObject).lineTo(14.5F, 15.5F);
      ((Path)localObject).cubicTo(14.5F, 14.947716F, 14.947716F, 14.5F, 15.5F, 14.5F);
      ((Path)localObject).lineTo(21.002014F, 14.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.5F, 2.996918F);
      ((Path)localObject).lineTo(16.5F, 7.498932F);
      ((Path)localObject).lineTo(20.99585F, 7.498932F);
      ((Path)localObject).lineTo(20.99585F, 9.498932F);
      ((Path)localObject).lineTo(15.5F, 9.498932F);
      ((Path)localObject).cubicTo(14.947716F, 9.498932F, 14.5F, 9.051217F, 14.5F, 8.498932F);
      ((Path)localObject).lineTo(14.5F, 2.996918F);
      ((Path)localObject).lineTo(16.5F, 2.996918F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.502014F, 3.0F);
      ((Path)localObject).lineTo(9.502014F, 8.49585F);
      ((Path)localObject).cubicTo(9.502014F, 9.048135F, 9.054299F, 9.49585F, 8.502014F, 9.49585F);
      ((Path)localObject).lineTo(3.0F, 9.49585F);
      ((Path)localObject).lineTo(3.0F, 7.49585F);
      ((Path)localObject).lineTo(7.502014F, 7.49585F);
      ((Path)localObject).lineTo(7.502014F, 3.0F);
      ((Path)localObject).lineTo(9.502014F, 3.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_fold
 * JD-Core Version:    0.7.0.1
 */