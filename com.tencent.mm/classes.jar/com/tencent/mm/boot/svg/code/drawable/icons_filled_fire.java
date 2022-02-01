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

public class icons_filled_fire
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(34.200806F, 7.552002F);
      ((Path)localObject).cubicTo(39.507114F, 7.552002F, 43.685303F, 12.014282F, 45.091553F, 16.471069F);
      ((Path)localObject).cubicTo(46.656857F, 21.431944F, 43.243286F, 26.969238F, 45.740845F, 29.0625F);
      ((Path)localObject).cubicTo(48.238403F, 31.155762F, 51.413086F, 27.455933F, 53.026497F, 24.667688F);
      ((Path)localObject).cubicTo(55.80043F, 29.66374F, 57.44912F, 35.481979F, 57.44912F, 41.55088F);
      ((Path)localObject).cubicTo(57.44912F, 52.058338F, 49.89365F, 60.801117F, 39.919163F, 62.642773F);
      ((Path)localObject).cubicTo(40.636597F, 61.769173F, 41.06638F, 60.651588F, 41.06638F, 59.43362F);
      ((Path)localObject).cubicTo(41.06638F, 56.114578F, 39.377586F, 52.803371F, 36.0F, 49.5F);
      ((Path)localObject).cubicTo(32.622414F, 52.803371F, 30.933619F, 56.114578F, 30.933619F, 59.43362F);
      ((Path)localObject).cubicTo(30.933619F, 60.651588F, 31.363403F, 61.769173F, 32.079586F, 62.642994F);
      ((Path)localObject).cubicTo(22.105341F, 60.79995F, 14.550882F, 52.057636F, 14.550882F, 41.55088F);
      ((Path)localObject).cubicTo(14.550882F, 32.114529F, 20.35364F, 25.571796F, 23.196913F, 23.066687F);
      ((Path)localObject).cubicTo(22.610746F, 25.77886F, 22.603514F, 31.248344F, 23.683264F, 32.03204F);
      ((Path)localObject).cubicTo(23.696754F, 32.041832F, 23.732718F, 32.001656F, 23.737024F, 31.972952F);
      ((Path)localObject).cubicTo(25.737291F, 18.641375F, 37.708652F, 15.437002F, 34.200806F, 7.552002F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_fire
 * JD-Core Version:    0.7.0.1
 */