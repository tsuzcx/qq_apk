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

public class finder_icons_filled_unstar
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
      ((Path)localObject).moveTo(15.363961F, 9.0F);
      ((Path)localObject).lineTo(28.024017F, 21.66F);
      ((Path)localObject).lineTo(33.309792F, 10.955829F);
      ((Path)localObject).cubicTo(34.04306F, 9.470068F, 35.841938F, 8.860051F, 37.327698F, 9.593318F);
      ((Path)localObject).cubicTo(37.919334F, 9.885308F, 38.398216F, 10.364191F, 38.690208F, 10.955829F);
      ((Path)localObject).lineTo(45.698456F, 25.156092F);
      ((Path)localObject).lineTo(61.369377F, 27.433208F);
      ((Path)localObject).cubicTo(63.00901F, 27.671463F, 64.145058F, 29.19379F, 63.906803F, 30.833426F);
      ((Path)localObject).cubicTo(63.811928F, 31.486336F, 63.504467F, 32.089764F, 63.032017F, 32.550289F);
      ((Path)localObject).lineTo(51.692432F, 43.603653F);
      ((Path)localObject).lineTo(52.048016F, 45.683998F);
      ((Path)localObject).lineTo(66.27565F, 59.91169F);
      ((Path)localObject).lineTo(63.09367F, 63.09367F);
      ((Path)localObject).lineTo(12.18198F, 12.18198F);
      ((Path)localObject).lineTo(15.363961F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.744017F, 26.109858F);
      ((Path)localObject).lineTo(54.271202F, 60.630337F);
      ((Path)localObject).cubicTo(53.941036F, 61.662338F, 53.061417F, 62.479385F, 51.919655F, 62.675213F);
      ((Path)localObject).cubicTo(51.269382F, 62.786743F, 50.600479F, 62.680798F, 50.016499F, 62.373779F);
      ((Path)localObject).lineTo(36.0F, 55.004871F);
      ((Path)localObject).lineTo(21.983503F, 62.373779F);
      ((Path)localObject).cubicTo(20.51697F, 63.144783F, 18.703089F, 62.580944F, 17.932085F, 61.11441F);
      ((Path)localObject).cubicTo(17.625069F, 60.53043F, 17.519125F, 59.861523F, 17.630655F, 59.21125F);
      ((Path)localObject).lineTo(20.307568F, 43.603653F);
      ((Path)localObject).lineTo(8.967983F, 32.550289F);
      ((Path)localObject).cubicTo(7.781533F, 31.393785F, 7.757256F, 29.494446F, 8.913759F, 28.307995F);
      ((Path)localObject).cubicTo(9.374285F, 27.835545F, 9.977713F, 27.528084F, 10.630624F, 27.433208F);
      ((Path)localObject).lineTo(19.744017F, 26.109858F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icons_filled_unstar
 * JD-Core Version:    0.7.0.1
 */