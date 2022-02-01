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

public class icons_filled_live_mark
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
      ((Path)localObject).moveTo(63.0F, 12.0F);
      ((Path)localObject).cubicTo(64.656853F, 12.0F, 66.0F, 13.343145F, 66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 57.0F);
      ((Path)localObject).cubicTo(66.0F, 58.656853F, 64.656853F, 60.0F, 63.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 60.0F);
      ((Path)localObject).cubicTo(7.343146F, 60.0F, 6.0F, 58.656853F, 6.0F, 57.0F);
      ((Path)localObject).lineTo(6.0F, 15.0F);
      ((Path)localObject).cubicTo(6.0F, 13.343145F, 7.343146F, 12.0F, 9.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.736328F, 28.089844F);
      ((Path)localObject).lineTo(14.197266F, 28.089844F);
      ((Path)localObject).lineTo(14.197266F, 45.0F);
      ((Path)localObject).lineTo(25.130859F, 45.0F);
      ((Path)localObject).lineTo(25.130859F, 42.070313F);
      ((Path)localObject).lineTo(17.736328F, 42.070313F);
      ((Path)localObject).lineTo(17.736328F, 28.089844F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.767578F, 28.089844F);
      ((Path)localObject).lineTo(27.228516F, 28.089844F);
      ((Path)localObject).lineTo(27.228516F, 45.0F);
      ((Path)localObject).lineTo(30.767578F, 45.0F);
      ((Path)localObject).lineTo(30.767578F, 28.089844F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.462891F, 28.089844F);
      ((Path)localObject).lineTo(32.501953F, 28.089844F);
      ((Path)localObject).lineTo(38.185547F, 45.0F);
      ((Path)localObject).lineTo(42.451172F, 45.0F);
      ((Path)localObject).lineTo(48.134766F, 28.089844F);
      ((Path)localObject).lineTo(44.279297F, 28.089844F);
      ((Path)localObject).lineTo(40.412109F, 41.355469F);
      ((Path)localObject).lineTo(40.330078F, 41.355469F);
      ((Path)localObject).lineTo(36.462891F, 28.089844F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(61.060547F, 28.089844F);
      ((Path)localObject).lineTo(49.857422F, 28.089844F);
      ((Path)localObject).lineTo(49.857422F, 45.0F);
      ((Path)localObject).lineTo(61.060547F, 45.0F);
      ((Path)localObject).lineTo(61.060547F, 42.070313F);
      ((Path)localObject).lineTo(53.396484F, 42.070313F);
      ((Path)localObject).lineTo(53.396484F, 37.804688F);
      ((Path)localObject).lineTo(60.626953F, 37.804688F);
      ((Path)localObject).lineTo(60.626953F, 35.085938F);
      ((Path)localObject).lineTo(53.396484F, 35.085938F);
      ((Path)localObject).lineTo(53.396484F, 31.007813F);
      ((Path)localObject).lineTo(61.060547F, 31.007813F);
      ((Path)localObject).lineTo(61.060547F, 28.089844F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_live_mark
 * JD-Core Version:    0.7.0.1
 */