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

public class icons_filled_pay_minifund
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
      ((Path)localObject).moveTo(19.604445F, 26.17499F);
      ((Path)localObject).lineTo(36.0F, 66.0F);
      ((Path)localObject).lineTo(6.213701F, 27.233997F);
      ((Path)localObject).cubicTo(5.992266F, 26.945807F, 6.046382F, 26.532673F, 6.334574F, 26.311237F);
      ((Path)localObject).cubicTo(6.44956F, 26.222887F, 6.590509F, 26.17499F, 6.735518F, 26.17499F);
      ((Path)localObject).lineTo(19.604445F, 26.17499F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(65.264481F, 26.17499F);
      ((Path)localObject).cubicTo(65.409492F, 26.17499F, 65.550438F, 26.222887F, 65.665428F, 26.311237F);
      ((Path)localObject).cubicTo(65.953621F, 26.532673F, 66.007736F, 26.945807F, 65.786301F, 27.233997F);
      ((Path)localObject).lineTo(65.786301F, 27.233997F);
      ((Path)localObject).lineTo(36.0F, 66.0F);
      ((Path)localObject).lineTo(52.697777F, 26.17499F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(47.900002F, 26.17499F);
      ((Path)localObject).lineTo(36.0F, 66.0F);
      ((Path)localObject).lineTo(24.1F, 26.17499F);
      ((Path)localObject).lineTo(47.900002F, 26.17499F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(29.200001F, 12.0F);
      ((Path)localObject).lineTo(19.927273F, 22.125F);
      ((Path)localObject).lineTo(7.422167F, 22.125F);
      ((Path)localObject).cubicTo(7.211729F, 22.125F, 7.013983F, 22.024357F, 6.890135F, 21.854223F);
      ((Path)localObject).cubicTo(6.676242F, 21.56039F, 6.741046F, 21.148798F, 7.034879F, 20.934904F);
      ((Path)localObject).lineTo(7.034879F, 20.934904F);
      ((Path)localObject).lineTo(19.135954F, 12.126033F);
      ((Path)localObject).cubicTo(19.248474F, 12.044126F, 19.384068F, 12.0F, 19.523241F, 12.0F);
      ((Path)localObject).lineTo(19.523241F, 12.0F);
      ((Path)localObject).lineTo(29.200001F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.400002F, 12.0F);
      ((Path)localObject).lineTo(47.900002F, 22.125F);
      ((Path)localObject).lineTo(24.1F, 22.125F);
      ((Path)localObject).lineTo(32.599998F, 12.0F);
      ((Path)localObject).lineTo(39.400002F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(51.513329F, 12.0F);
      ((Path)localObject).cubicTo(51.655258F, 12.0F, 51.793385F, 12.045888F, 51.907101F, 12.130816F);
      ((Path)localObject).lineTo(63.70182F, 20.939688F);
      ((Path)localObject).cubicTo(63.993011F, 21.157164F, 64.052773F, 21.569519F, 63.835293F, 21.86071F);
      ((Path)localObject).cubicTo(63.711071F, 22.02704F, 63.515644F, 22.125F, 63.308044F, 22.125F);
      ((Path)localObject).lineTo(51.430679F, 22.125F);
      ((Path)localObject).lineTo(41.488907F, 12.0F);
      ((Path)localObject).lineTo(51.513329F, 12.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_pay_minifund
 * JD-Core Version:    0.7.0.1
 */