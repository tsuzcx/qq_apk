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

public class finder_icons_filled_star
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
      ((Path)localObject).moveTo(36.0F, 55.5F);
      ((Path)localObject).lineTo(21.983503F, 62.868908F);
      ((Path)localObject).cubicTo(20.51697F, 63.639912F, 18.703089F, 63.076073F, 17.932085F, 61.609539F);
      ((Path)localObject).cubicTo(17.625069F, 61.025555F, 17.519125F, 60.356651F, 17.630655F, 59.706379F);
      ((Path)localObject).lineTo(20.307568F, 44.098782F);
      ((Path)localObject).lineTo(8.967983F, 33.045418F);
      ((Path)localObject).cubicTo(7.781533F, 31.888914F, 7.757256F, 29.989574F, 8.913759F, 28.803123F);
      ((Path)localObject).cubicTo(9.374285F, 28.330673F, 9.977713F, 28.023211F, 10.630624F, 27.928337F);
      ((Path)localObject).lineTo(26.301544F, 25.65122F);
      ((Path)localObject).lineTo(33.309792F, 11.450957F);
      ((Path)localObject).cubicTo(34.04306F, 9.965197F, 35.841938F, 9.355179F, 37.327698F, 10.088447F);
      ((Path)localObject).cubicTo(37.919334F, 10.380437F, 38.398216F, 10.85932F, 38.690208F, 11.450957F);
      ((Path)localObject).lineTo(45.698456F, 25.65122F);
      ((Path)localObject).lineTo(61.369377F, 27.928337F);
      ((Path)localObject).cubicTo(63.00901F, 28.16659F, 64.145058F, 29.688919F, 63.906803F, 31.328554F);
      ((Path)localObject).cubicTo(63.811928F, 31.981464F, 63.504467F, 32.584892F, 63.032017F, 33.045418F);
      ((Path)localObject).lineTo(51.692432F, 44.098782F);
      ((Path)localObject).lineTo(54.369347F, 59.706379F);
      ((Path)localObject).cubicTo(54.649429F, 61.33939F, 53.552666F, 62.890255F, 51.919655F, 63.170338F);
      ((Path)localObject).cubicTo(51.269382F, 63.281868F, 50.600479F, 63.175926F, 50.016499F, 62.868908F);
      ((Path)localObject).lineTo(36.0F, 55.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icons_filled_star
 * JD-Core Version:    0.7.0.1
 */