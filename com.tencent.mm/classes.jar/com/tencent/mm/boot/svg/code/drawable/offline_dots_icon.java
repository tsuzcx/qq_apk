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

public class offline_dots_icon
  extends c
{
  private final int height = 58;
  private final int width = 9;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 9;
      return 58;
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
      localPaint.setColor(-3552823);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 3.0F);
      ((Path)localObject).lineTo(0.0F, 12.0F);
      ((Path)localObject).lineTo(9.0F, 12.0F);
      ((Path)localObject).lineTo(9.0F, 3.0F);
      ((Path)localObject).lineTo(0.0F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 33.0F);
      ((Path)localObject).lineTo(9.0F, 33.0F);
      ((Path)localObject).lineTo(9.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(0.0F, 45.0F);
      ((Path)localObject).lineTo(0.0F, 54.0F);
      ((Path)localObject).lineTo(9.0F, 54.0F);
      ((Path)localObject).lineTo(9.0F, 45.0F);
      ((Path)localObject).lineTo(0.0F, 45.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.offline_dots_icon
 * JD-Core Version:    0.7.0.1
 */