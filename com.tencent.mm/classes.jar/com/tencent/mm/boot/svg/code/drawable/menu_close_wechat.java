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

public class menu_close_wechat
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint.setColor(-8617851);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 14.048469F);
      ((Path)localObject).lineTo(36.0F, 22.694517F);
      ((Path)localObject).cubicTo(26.540211F, 27.188381F, 20.0F, 36.830418F, 20.0F, 48.0F);
      ((Path)localObject).cubicTo(20.0F, 63.463974F, 32.536026F, 76.0F, 48.0F, 76.0F);
      ((Path)localObject).cubicTo(63.463974F, 76.0F, 76.0F, 63.463974F, 76.0F, 48.0F);
      ((Path)localObject).cubicTo(76.0F, 36.830418F, 69.459793F, 27.188381F, 60.0F, 22.694525F);
      ((Path)localObject).lineTo(60.0F, 14.048469F);
      ((Path)localObject).cubicTo(73.982307F, 18.990505F, 84.0F, 32.325375F, 84.0F, 48.0F);
      ((Path)localObject).cubicTo(84.0F, 67.882248F, 67.882248F, 84.0F, 48.0F, 84.0F);
      ((Path)localObject).cubicTo(28.117748F, 84.0F, 12.0F, 67.882248F, 12.0F, 48.0F);
      ((Path)localObject).cubicTo(12.0F, 32.325375F, 22.017691F, 18.990505F, 36.0F, 14.048469F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(44.0F, 6.0F);
      ((Path)localObject).lineTo(52.0F, 6.0F);
      ((Path)localObject).lineTo(52.0F, 48.0F);
      ((Path)localObject).lineTo(44.0F, 48.0F);
      ((Path)localObject).lineTo(44.0F, 6.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.menu_close_wechat
 * JD-Core Version:    0.7.0.1
 */