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

public class finder_icons_filled_topic
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
      localPaint.setColor(-15132391);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.299999F, 21.0F);
      ((Path)localObject).lineTo(28.799999F, 21.0F);
      ((Path)localObject).lineTo(28.08F, 26.999001F);
      ((Path)localObject).lineTo(21.0F, 27.0F);
      ((Path)localObject).lineTo(21.0F, 31.5F);
      ((Path)localObject).lineTo(27.540001F, 31.499001F);
      ((Path)localObject).lineTo(26.459999F, 40.499001F);
      ((Path)localObject).lineTo(21.0F, 40.5F);
      ((Path)localObject).lineTo(21.0F, 45.0F);
      ((Path)localObject).lineTo(25.92F, 44.999001F);
      ((Path)localObject).lineTo(25.200001F, 51.0F);
      ((Path)localObject).lineTo(29.700001F, 51.0F);
      ((Path)localObject).lineTo(30.42F, 44.999001F);
      ((Path)localObject).lineTo(39.419998F, 44.999001F);
      ((Path)localObject).lineTo(38.700001F, 51.0F);
      ((Path)localObject).lineTo(43.200001F, 51.0F);
      ((Path)localObject).lineTo(43.919998F, 44.999001F);
      ((Path)localObject).lineTo(51.0F, 45.0F);
      ((Path)localObject).lineTo(51.0F, 40.5F);
      ((Path)localObject).lineTo(44.459999F, 40.499001F);
      ((Path)localObject).lineTo(45.540001F, 31.499001F);
      ((Path)localObject).lineTo(51.0F, 31.5F);
      ((Path)localObject).lineTo(51.0F, 27.0F);
      ((Path)localObject).lineTo(46.080002F, 26.999001F);
      ((Path)localObject).lineTo(46.799999F, 21.0F);
      ((Path)localObject).lineTo(42.299999F, 21.0F);
      ((Path)localObject).lineTo(41.580002F, 26.999001F);
      ((Path)localObject).lineTo(32.580002F, 26.999001F);
      ((Path)localObject).lineTo(33.299999F, 21.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(41.040001F, 31.499001F);
      ((Path)localObject).lineTo(39.959999F, 40.499001F);
      ((Path)localObject).lineTo(30.959999F, 40.499001F);
      ((Path)localObject).lineTo(32.040001F, 31.499001F);
      ((Path)localObject).lineTo(41.040001F, 31.499001F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icons_filled_topic
 * JD-Core Version:    0.7.0.1
 */