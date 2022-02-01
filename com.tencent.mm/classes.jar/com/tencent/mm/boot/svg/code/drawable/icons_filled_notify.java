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

public class icons_filled_notify
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
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-15616);
      ((Canvas)localObject1).save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(45.0F, 11.412743F);
      ((Path)localObject2).cubicTo(46.656853F, 11.412743F, 48.0F, 12.755889F, 48.0F, 14.412743F);
      ((Path)localObject2).lineTo(48.0F, 14.412743F);
      ((Path)localObject2).lineTo(48.0F, 57.587257F);
      ((Path)localObject2).cubicTo(48.0F, 58.149517F, 47.841991F, 58.700459F, 47.543995F, 59.177254F);
      ((Path)localObject2).cubicTo(46.665863F, 60.582264F, 44.815014F, 61.009384F, 43.410004F, 60.131252F);
      ((Path)localObject2).lineTo(43.410004F, 60.131252F);
      ((Path)localObject2).lineTo(24.0F, 48.0F);
      ((Path)localObject2).lineTo(18.0F, 48.0F);
      ((Path)localObject2).cubicTo(11.372583F, 48.0F, 6.0F, 42.627419F, 6.0F, 36.0F);
      ((Path)localObject2).cubicTo(6.0F, 29.372583F, 11.372583F, 24.0F, 18.0F, 24.0F);
      ((Path)localObject2).lineTo(18.0F, 24.0F);
      ((Path)localObject2).lineTo(24.0F, 24.0F);
      ((Path)localObject2).lineTo(43.410004F, 11.868748F);
      ((Path)localObject2).cubicTo(43.886799F, 11.570751F, 44.43774F, 11.412743F, 45.0F, 11.412743F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(55.328876F, 45.316196F);
      ((Path)localObject2).lineTo(67.340591F, 51.316196F);
      ((Path)localObject2).lineTo(64.659409F, 56.683804F);
      ((Path)localObject2).lineTo(52.647686F, 50.683804F);
      ((Path)localObject2).lineTo(55.328876F, 45.316196F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(66.0F, 33.0F);
      ((Path)localObject2).lineTo(66.0F, 39.0F);
      ((Path)localObject2).lineTo(53.988281F, 39.0F);
      ((Path)localObject2).lineTo(53.988281F, 33.0F);
      ((Path)localObject2).lineTo(66.0F, 33.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(64.659409F, 15.316195F);
      ((Path)localObject2).lineTo(67.340591F, 20.683805F);
      ((Path)localObject2).lineTo(55.328876F, 26.683805F);
      ((Path)localObject2).lineTo(52.647686F, 21.316195F);
      ((Path)localObject2).lineTo(64.659409F, 15.316195F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      ((Canvas)localObject1).drawPath((Path)localObject2, localPaint);
      ((Canvas)localObject1).restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(72.0F, 0.0F);
      ((Path)localObject1).lineTo(72.0F, 72.0F);
      ((Path)localObject1).lineTo(0.0F, 72.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_notify
 * JD-Core Version:    0.7.0.1
 */