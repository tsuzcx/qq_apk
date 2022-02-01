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

public class icons_filled_more2
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
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 40.5F);
      ((Path)localObject).cubicTo(38.485283F, 40.5F, 40.5F, 38.485283F, 40.5F, 36.0F);
      ((Path)localObject).cubicTo(40.5F, 33.514717F, 38.485283F, 31.5F, 36.0F, 31.5F);
      ((Path)localObject).cubicTo(33.514717F, 31.5F, 31.5F, 33.514717F, 31.5F, 36.0F);
      ((Path)localObject).cubicTo(31.5F, 38.485283F, 33.514717F, 40.5F, 36.0F, 40.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(49.5F, 40.5F);
      ((Path)localObject).cubicTo(51.985283F, 40.5F, 54.0F, 38.485283F, 54.0F, 36.0F);
      ((Path)localObject).cubicTo(54.0F, 33.514717F, 51.985283F, 31.5F, 49.5F, 31.5F);
      ((Path)localObject).cubicTo(47.014717F, 31.5F, 45.0F, 33.514717F, 45.0F, 36.0F);
      ((Path)localObject).cubicTo(45.0F, 38.485283F, 47.014717F, 40.5F, 49.5F, 40.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.5F, 40.5F);
      ((Path)localObject).cubicTo(24.985281F, 40.5F, 27.0F, 38.485283F, 27.0F, 36.0F);
      ((Path)localObject).cubicTo(27.0F, 33.514717F, 24.985281F, 31.5F, 22.5F, 31.5F);
      ((Path)localObject).cubicTo(20.014719F, 31.5F, 18.0F, 33.514717F, 18.0F, 36.0F);
      ((Path)localObject).cubicTo(18.0F, 38.485283F, 20.014719F, 40.5F, 22.5F, 40.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_more2
 * JD-Core Version:    0.7.0.1
 */