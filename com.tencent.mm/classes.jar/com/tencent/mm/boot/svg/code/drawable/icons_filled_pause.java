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

public class icons_filled_pause
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
      ((Path)localObject).moveTo(19.5F, 13.5F);
      ((Path)localObject).lineTo(25.5F, 13.5F);
      ((Path)localObject).cubicTo(27.156855F, 13.5F, 28.5F, 14.843145F, 28.5F, 16.5F);
      ((Path)localObject).lineTo(28.5F, 55.5F);
      ((Path)localObject).cubicTo(28.5F, 57.156853F, 27.156855F, 58.5F, 25.5F, 58.5F);
      ((Path)localObject).lineTo(19.5F, 58.5F);
      ((Path)localObject).cubicTo(17.843145F, 58.5F, 16.5F, 57.156853F, 16.5F, 55.5F);
      ((Path)localObject).lineTo(16.5F, 16.5F);
      ((Path)localObject).cubicTo(16.5F, 14.843145F, 17.843145F, 13.5F, 19.5F, 13.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(46.5F, 13.5F);
      ((Path)localObject).lineTo(52.5F, 13.5F);
      ((Path)localObject).cubicTo(54.156853F, 13.5F, 55.5F, 14.843145F, 55.5F, 16.5F);
      ((Path)localObject).lineTo(55.5F, 55.5F);
      ((Path)localObject).cubicTo(55.5F, 57.156853F, 54.156853F, 58.5F, 52.5F, 58.5F);
      ((Path)localObject).lineTo(46.5F, 58.5F);
      ((Path)localObject).cubicTo(44.843147F, 58.5F, 43.5F, 57.156853F, 43.5F, 55.5F);
      ((Path)localObject).lineTo(43.5F, 16.5F);
      ((Path)localObject).cubicTo(43.5F, 14.843145F, 44.843147F, 13.5F, 46.5F, 13.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_pause
 * JD-Core Version:    0.7.0.1
 */