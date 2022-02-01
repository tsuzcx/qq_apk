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

public class checkbox_unselected_white
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(60.0F, 0.0F);
      ((Path)localObject).lineTo(60.0F, 60.0F);
      ((Path)localObject).lineTo(0.0F, 60.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(6.0F, 12.0F);
      ((Path)localObject).cubicTo(6.0F, 8.689151F, 8.683541F, 6.0F, 12.0F, 6.0F);
      ((Path)localObject).lineTo(48.0F, 6.0F);
      ((Path)localObject).cubicTo(51.310848F, 6.0F, 54.0F, 8.683541F, 54.0F, 12.0F);
      ((Path)localObject).lineTo(54.0F, 48.0F);
      ((Path)localObject).cubicTo(54.0F, 51.310848F, 51.31646F, 54.0F, 48.0F, 54.0F);
      ((Path)localObject).lineTo(12.0F, 54.0F);
      ((Path)localObject).cubicTo(8.689151F, 54.0F, 6.0F, 51.31646F, 6.0F, 48.0F);
      ((Path)localObject).lineTo(6.0F, 12.0F);
      ((Path)localObject).lineTo(6.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.0F, 11.0F);
      ((Path)localObject).cubicTo(9.0F, 9.938929F, 9.936117F, 9.0F, 11.0F, 9.0F);
      ((Path)localObject).lineTo(49.0F, 9.0F);
      ((Path)localObject).cubicTo(50.061069F, 9.0F, 51.0F, 9.936117F, 51.0F, 11.0F);
      ((Path)localObject).lineTo(51.0F, 49.0F);
      ((Path)localObject).cubicTo(51.0F, 50.061069F, 50.063885F, 51.0F, 49.0F, 51.0F);
      ((Path)localObject).lineTo(11.0F, 51.0F);
      ((Path)localObject).cubicTo(9.938929F, 51.0F, 9.0F, 50.063885F, 9.0F, 49.0F);
      ((Path)localObject).lineTo(9.0F, 11.0F);
      ((Path)localObject).lineTo(9.0F, 11.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.checkbox_unselected_white
 * JD-Core Version:    0.7.0.1
 */