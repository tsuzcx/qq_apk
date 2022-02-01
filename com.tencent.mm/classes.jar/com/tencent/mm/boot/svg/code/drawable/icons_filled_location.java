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

public class icons_filled_location
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
      ((Path)localObject).moveTo(33.785156F, 66.403427F);
      ((Path)localObject).cubicTo(33.785156F, 66.403427F, 12.0F, 48.054832F, 12.0F, 30.0F);
      ((Path)localObject).cubicTo(12.0F, 16.745167F, 22.745167F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(49.254833F, 6.0F, 60.0F, 16.745167F, 60.0F, 30.0F);
      ((Path)localObject).cubicTo(60.0F, 48.054832F, 38.225567F, 66.39341F, 38.225567F, 66.39341F);
      ((Path)localObject).cubicTo(37.000694F, 67.518059F, 35.008381F, 67.506104F, 33.785156F, 66.403427F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 40.5F);
      ((Path)localObject).cubicTo(41.798988F, 40.5F, 46.5F, 35.798988F, 46.5F, 30.0F);
      ((Path)localObject).cubicTo(46.5F, 24.20101F, 41.798988F, 19.5F, 36.0F, 19.5F);
      ((Path)localObject).cubicTo(30.20101F, 19.5F, 25.5F, 24.20101F, 25.5F, 30.0F);
      ((Path)localObject).cubicTo(25.5F, 35.798988F, 30.20101F, 40.5F, 36.0F, 40.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_location
 * JD-Core Version:    0.7.0.1
 */