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

public class actionbar_icon_light_clear
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(1291845631);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 60.0F);
      ((Path)localObject).cubicTo(22.745167F, 60.0F, 12.0F, 49.254833F, 12.0F, 36.0F);
      ((Path)localObject).cubicTo(12.0F, 22.745167F, 22.745167F, 12.0F, 36.0F, 12.0F);
      ((Path)localObject).cubicTo(49.254833F, 12.0F, 60.0F, 22.745167F, 60.0F, 36.0F);
      ((Path)localObject).cubicTo(60.0F, 49.254833F, 49.254833F, 60.0F, 36.0F, 60.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 32.938873F);
      ((Path)localObject).lineTo(27.061129F, 24.0F);
      ((Path)localObject).lineTo(24.0F, 27.061129F);
      ((Path)localObject).lineTo(32.938873F, 36.0F);
      ((Path)localObject).lineTo(24.0F, 44.938873F);
      ((Path)localObject).lineTo(27.061129F, 48.0F);
      ((Path)localObject).lineTo(36.0F, 39.061127F);
      ((Path)localObject).lineTo(44.938873F, 48.0F);
      ((Path)localObject).lineTo(48.0F, 44.938873F);
      ((Path)localObject).lineTo(39.061127F, 36.0F);
      ((Path)localObject).lineTo(48.0F, 27.061129F);
      ((Path)localObject).lineTo(44.938873F, 24.0F);
      ((Path)localObject).lineTo(36.0F, 32.938873F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.actionbar_icon_light_clear
 * JD-Core Version:    0.7.0.1
 */