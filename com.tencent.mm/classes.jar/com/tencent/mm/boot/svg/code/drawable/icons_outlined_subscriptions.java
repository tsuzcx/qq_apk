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

public class icons_outlined_subscriptions
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
      ((Path)localObject).moveTo(12.0F, 9.0F);
      ((Path)localObject).cubicTo(12.0F, 7.343146F, 13.343145F, 6.0F, 15.0F, 6.0F);
      ((Path)localObject).lineTo(57.0F, 6.0F);
      ((Path)localObject).cubicTo(58.656853F, 6.0F, 60.0F, 7.343146F, 60.0F, 9.0F);
      ((Path)localObject).lineTo(60.0F, 63.0F);
      ((Path)localObject).cubicTo(60.0F, 64.656853F, 58.656853F, 66.0F, 57.0F, 66.0F);
      ((Path)localObject).lineTo(15.0F, 66.0F);
      ((Path)localObject).cubicTo(13.343145F, 66.0F, 12.0F, 64.656853F, 12.0F, 63.0F);
      ((Path)localObject).lineTo(12.0F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.6F, 9.6F);
      ((Path)localObject).lineTo(15.6F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 9.6F);
      ((Path)localObject).lineTo(15.6F, 9.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(25.5F, 24.0F);
      ((Path)localObject).cubicTo(23.014719F, 24.0F, 21.0F, 21.985281F, 21.0F, 19.5F);
      ((Path)localObject).cubicTo(21.0F, 17.014719F, 23.014719F, 15.0F, 25.5F, 15.0F);
      ((Path)localObject).cubicTo(27.985281F, 15.0F, 30.0F, 17.014719F, 30.0F, 19.5F);
      ((Path)localObject).cubicTo(30.0F, 21.985281F, 27.985281F, 24.0F, 25.5F, 24.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.0F, 30.0F);
      ((Path)localObject).lineTo(43.5F, 30.0F);
      ((Path)localObject).lineTo(43.5F, 33.599998F);
      ((Path)localObject).lineTo(21.0F, 33.599998F);
      ((Path)localObject).lineTo(21.0F, 30.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.0F, 39.0F);
      ((Path)localObject).lineTo(33.0F, 39.0F);
      ((Path)localObject).lineTo(33.0F, 42.599998F);
      ((Path)localObject).lineTo(21.0F, 42.599998F);
      ((Path)localObject).lineTo(21.0F, 39.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.0F, 48.0F);
      ((Path)localObject).lineTo(33.0F, 48.0F);
      ((Path)localObject).lineTo(33.0F, 51.599998F);
      ((Path)localObject).lineTo(21.0F, 51.599998F);
      ((Path)localObject).lineTo(21.0F, 48.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_subscriptions
 * JD-Core Version:    0.7.0.1
 */