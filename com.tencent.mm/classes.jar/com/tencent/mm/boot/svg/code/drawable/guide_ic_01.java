package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class guide_ic_01
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 38, 31);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -79.0F, 0.0F, 1.0F, -610.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 79.0F, 0.0F, 1.0F, 610.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-436207616);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 4.0F);
      ((Path)localObject2).cubicTo(35.045696F, 4.0F, 44.0F, 12.954305F, 44.0F, 24.0F);
      ((Path)localObject2).cubicTo(44.0F, 35.045696F, 35.045696F, 44.0F, 24.0F, 44.0F);
      ((Path)localObject2).cubicTo(12.954305F, 44.0F, 4.0F, 35.045696F, 4.0F, 24.0F);
      ((Path)localObject2).cubicTo(4.0F, 12.954305F, 12.954305F, 4.0F, 24.0F, 4.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.0F, 6.4F);
      ((Path)localObject2).cubicTo(14.279788F, 6.4F, 6.4F, 14.279788F, 6.4F, 24.0F);
      ((Path)localObject2).cubicTo(6.4F, 33.720211F, 14.279788F, 41.599998F, 24.0F, 41.599998F);
      ((Path)localObject2).cubicTo(33.720211F, 41.599998F, 41.599998F, 33.720211F, 41.599998F, 24.0F);
      ((Path)localObject2).cubicTo(41.599998F, 14.279788F, 33.720211F, 6.4F, 24.0F, 6.4F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(2.4F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(26.799999F, 22.0F);
      ((Path)localObject2).cubicTo(26.799999F, 18.907206F, 29.307203F, 16.4F, 32.399998F, 16.4F);
      ((Path)localObject2).lineTo(33.200001F, 16.4F);
      ((Path)localObject2).cubicTo(36.292797F, 16.4F, 38.799999F, 18.907206F, 38.799999F, 22.0F);
      ((Path)localObject2).lineTo(38.799999F, 21.999998F);
      ((Path)localObject2).cubicTo(38.799999F, 25.092793F, 36.292797F, 27.599998F, 33.200001F, 27.599998F);
      ((Path)localObject2).lineTo(32.399998F, 27.599998F);
      ((Path)localObject2).cubicTo(29.307203F, 27.599998F, 26.799999F, 25.092793F, 26.799999F, 21.999998F);
      ((Path)localObject2).lineTo(26.799999F, 22.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(2.4F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(9.2F, 22.0F);
      ((Path)localObject2).cubicTo(9.2F, 18.907206F, 11.707205F, 16.4F, 14.799999F, 16.4F);
      ((Path)localObject2).lineTo(15.6F, 16.4F);
      ((Path)localObject2).cubicTo(18.692795F, 16.4F, 21.200001F, 18.907206F, 21.200001F, 22.0F);
      ((Path)localObject2).lineTo(21.200001F, 21.999998F);
      ((Path)localObject2).cubicTo(21.200001F, 25.092793F, 18.692795F, 27.599998F, 15.6F, 27.599998F);
      ((Path)localObject2).lineTo(14.799999F, 27.599998F);
      ((Path)localObject2).cubicTo(11.707205F, 27.599998F, 9.2F, 25.092793F, 9.2F, 21.999998F);
      ((Path)localObject2).lineTo(9.2F, 22.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(2.4F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(26.799999F, 22.799999F);
      ((Path)localObject1).cubicTo(26.799999F, 21.253603F, 25.546398F, 20.0F, 24.0F, 20.0F);
      ((Path)localObject1).cubicTo(22.453602F, 20.0F, 21.200001F, 21.253603F, 21.200001F, 22.799999F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.guide_ic_01
 * JD-Core Version:    0.7.0.1
 */