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

public class icons_filled_live_err_yellow
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
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
      localPaint.setColor(-15616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(32.0F, 5.333334F);
      ((Path)localObject).cubicTo(46.727592F, 5.333334F, 58.666668F, 17.272408F, 58.666668F, 32.0F);
      ((Path)localObject).cubicTo(58.666668F, 46.727592F, 46.727592F, 58.666668F, 32.0F, 58.666668F);
      ((Path)localObject).cubicTo(17.272408F, 58.666668F, 5.333334F, 46.727592F, 5.333334F, 32.0F);
      ((Path)localObject).cubicTo(5.333334F, 17.272408F, 17.272408F, 5.333334F, 32.0F, 5.333334F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(31.988022F, 40.903645F);
      ((Path)localObject).cubicTo(30.657293F, 40.903645F, 29.6F, 41.92448F, 29.6F, 43.255207F);
      ((Path)localObject).cubicTo(29.6F, 44.585938F, 30.657293F, 45.60677F, 31.988022F, 45.60677F);
      ((Path)localObject).cubicTo(33.355209F, 45.60677F, 34.394272F, 44.585938F, 34.394272F, 43.255207F);
      ((Path)localObject).cubicTo(34.394272F, 41.92448F, 33.355209F, 40.903645F, 31.988022F, 40.903645F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.02969F, 16.361979F);
      ((Path)localObject).lineTo(29.964584F, 16.361979F);
      ((Path)localObject).lineTo(30.25625F, 36.619793F);
      ((Path)localObject).lineTo(33.738022F, 36.619793F);
      ((Path)localObject).lineTo(34.02969F, 16.361979F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_live_err_yellow
 * JD-Core Version:    0.7.0.1
 */