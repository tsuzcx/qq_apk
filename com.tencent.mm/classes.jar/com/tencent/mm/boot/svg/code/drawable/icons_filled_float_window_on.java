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

public class icons_filled_float_window_on
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
      ((Path)localObject).moveTo(36.0F, 60.0F);
      ((Path)localObject).cubicTo(49.254833F, 60.0F, 60.0F, 49.254833F, 60.0F, 36.0F);
      ((Path)localObject).cubicTo(60.0F, 22.745167F, 49.254833F, 12.0F, 36.0F, 12.0F);
      ((Path)localObject).cubicTo(22.745167F, 12.0F, 12.0F, 22.745167F, 12.0F, 36.0F);
      ((Path)localObject).cubicTo(12.0F, 49.254833F, 22.745167F, 60.0F, 36.0F, 60.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 48.0F);
      ((Path)localObject).cubicTo(42.627419F, 48.0F, 48.0F, 42.627419F, 48.0F, 36.0F);
      ((Path)localObject).cubicTo(48.0F, 29.372583F, 42.627419F, 24.0F, 36.0F, 24.0F);
      ((Path)localObject).cubicTo(29.372583F, 24.0F, 24.0F, 29.372583F, 24.0F, 36.0F);
      ((Path)localObject).cubicTo(24.0F, 42.627419F, 29.372583F, 48.0F, 36.0F, 48.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 54.0F);
      ((Path)localObject).cubicTo(26.058874F, 54.0F, 18.0F, 45.941124F, 18.0F, 36.0F);
      ((Path)localObject).cubicTo(18.0F, 26.058874F, 26.058874F, 18.0F, 36.0F, 18.0F);
      ((Path)localObject).cubicTo(45.941124F, 18.0F, 54.0F, 26.058874F, 54.0F, 36.0F);
      ((Path)localObject).cubicTo(54.0F, 45.941124F, 45.941124F, 54.0F, 36.0F, 54.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_float_window_on
 * JD-Core Version:    0.7.0.1
 */