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

public class icons_filled_favorites
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
      ((Path)localObject).moveTo(60.597374F, 19.200624F);
      ((Path)localObject).lineTo(36.0F, 33.401924F);
      ((Path)localObject).lineTo(11.402575F, 19.200594F);
      ((Path)localObject).cubicTo(11.464108F, 19.16046F, 11.526233F, 19.122423F, 11.588874F, 19.086618F);
      ((Path)localObject).lineTo(33.411125F, 6.612736F);
      ((Path)localObject).cubicTo(34.840923F, 5.795446F, 37.160156F, 5.796063F, 38.588875F, 6.612736F);
      ((Path)localObject).lineTo(60.411125F, 19.086618F);
      ((Path)localObject).cubicTo(60.473751F, 19.122416F, 60.535858F, 19.160461F, 60.597374F, 19.200624F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(62.968868F, 23.027594F);
      ((Path)localObject).cubicTo(62.989361F, 23.187063F, 63.0F, 23.344381F, 63.0F, 23.49818F);
      ((Path)localObject).lineTo(63.0F, 48.50182F);
      ((Path)localObject).cubicTo(63.0F, 50.120968F, 61.839844F, 52.09671F, 60.411125F, 52.913383F);
      ((Path)localObject).lineTo(38.588875F, 65.38726F);
      ((Path)localObject).cubicTo(38.480747F, 65.449074F, 38.367531F, 65.506203F, 38.25F, 65.558655F);
      ((Path)localObject).lineTo(38.25F, 37.299038F);
      ((Path)localObject).lineTo(62.968868F, 23.027594F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.75F, 65.558647F);
      ((Path)localObject).cubicTo(33.632458F, 65.506195F, 33.519241F, 65.449066F, 33.411125F, 65.38726F);
      ((Path)localObject).lineTo(11.588874F, 52.913383F);
      ((Path)localObject).cubicTo(10.159078F, 52.096092F, 9.0F, 50.107227F, 9.0F, 48.50182F);
      ((Path)localObject).lineTo(9.0F, 23.49818F);
      ((Path)localObject).cubicTo(9.0F, 23.344044F, 9.010513F, 23.186676F, 9.030771F, 23.027386F);
      ((Path)localObject).lineTo(33.75F, 37.299038F);
      ((Path)localObject).lineTo(33.75F, 65.558647F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_favorites
 * JD-Core Version:    0.7.0.1
 */