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

public class icons_filled_nearby
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
      ((Path)localObject).moveTo(21.0F, 18.0F);
      ((Path)localObject).cubicTo(17.686291F, 18.0F, 15.0F, 15.313708F, 15.0F, 12.0F);
      ((Path)localObject).cubicTo(15.0F, 8.686292F, 17.686291F, 6.0F, 21.0F, 6.0F);
      ((Path)localObject).cubicTo(24.313709F, 6.0F, 27.0F, 8.686292F, 27.0F, 12.0F);
      ((Path)localObject).cubicTo(27.0F, 15.313708F, 24.313709F, 18.0F, 21.0F, 18.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.919687F, 24.0F);
      ((Path)localObject).lineTo(25.080313F, 24.0F);
      ((Path)localObject).cubicTo(27.565594F, 24.0F, 29.580313F, 26.014719F, 29.580313F, 28.5F);
      ((Path)localObject).cubicTo(29.580313F, 28.633596F, 29.574364F, 28.767126F, 29.562483F, 28.900194F);
      ((Path)localObject).lineTo(26.494036F, 63.266796F);
      ((Path)localObject).cubicTo(26.355885F, 64.814102F, 25.059385F, 66.0F, 23.505922F, 66.0F);
      ((Path)localObject).lineTo(18.494078F, 66.0F);
      ((Path)localObject).cubicTo(16.940615F, 66.0F, 15.644116F, 64.814102F, 15.505964F, 63.266796F);
      ((Path)localObject).lineTo(12.437517F, 28.900194F);
      ((Path)localObject).cubicTo(12.216496F, 26.424759F, 14.04406F, 24.238852F, 16.519493F, 24.01783F);
      ((Path)localObject).cubicTo(16.652561F, 24.005949F, 16.786091F, 24.0F, 16.919687F, 24.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(51.0F, 18.0F);
      ((Path)localObject).cubicTo(47.686291F, 18.0F, 45.0F, 15.313708F, 45.0F, 12.0F);
      ((Path)localObject).cubicTo(45.0F, 8.686292F, 47.686291F, 6.0F, 51.0F, 6.0F);
      ((Path)localObject).cubicTo(54.313709F, 6.0F, 57.0F, 8.686292F, 57.0F, 12.0F);
      ((Path)localObject).cubicTo(57.0F, 15.313708F, 54.313709F, 18.0F, 51.0F, 18.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(46.919685F, 24.0F);
      ((Path)localObject).lineTo(55.080315F, 24.0F);
      ((Path)localObject).cubicTo(57.565594F, 24.0F, 59.580315F, 26.014719F, 59.580315F, 28.5F);
      ((Path)localObject).cubicTo(59.580315F, 28.633596F, 59.574364F, 28.767126F, 59.562481F, 28.900194F);
      ((Path)localObject).lineTo(56.494038F, 63.266796F);
      ((Path)localObject).cubicTo(56.355885F, 64.814102F, 55.059387F, 66.0F, 53.505924F, 66.0F);
      ((Path)localObject).lineTo(48.494076F, 66.0F);
      ((Path)localObject).cubicTo(46.940613F, 66.0F, 45.644115F, 64.814102F, 45.505962F, 63.266796F);
      ((Path)localObject).lineTo(42.437519F, 28.900194F);
      ((Path)localObject).cubicTo(42.216496F, 26.424759F, 44.04406F, 24.238852F, 46.519493F, 24.01783F);
      ((Path)localObject).cubicTo(46.652561F, 24.005949F, 46.786091F, 24.0F, 46.919685F, 24.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_nearby
 * JD-Core Version:    0.7.0.1
 */