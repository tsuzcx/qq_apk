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

public class bottomsheet_icon_translate
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
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
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-8617594);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(30.572737F, 32.897091F);
      ((Path)localObject3).lineTo(32.149662F, 36.971424F);
      ((Path)localObject3).lineTo(34.773781F, 36.971424F);
      ((Path)localObject3).lineTo(28.691349F, 21.256136F);
      ((Path)localObject3).lineTo(28.379143F, 21.256136F);
      ((Path)localObject3).lineTo(25.755024F, 21.256136F);
      ((Path)localObject3).lineTo(19.67259F, 36.971424F);
      ((Path)localObject3).lineTo(22.296709F, 36.971424F);
      ((Path)localObject3).lineTo(23.873636F, 32.897091F);
      ((Path)localObject3).lineTo(30.572737F, 32.897091F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(29.671635F, 30.568899F);
      ((Path)localObject3).lineTo(24.774738F, 30.568899F);
      ((Path)localObject3).lineTo(27.223186F, 24.242798F);
      ((Path)localObject3).lineTo(29.671635F, 30.568899F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(12.226544F, 8.0F);
      ((Path)localObject3).lineTo(63.140511F, 8.0F);
      ((Path)localObject3).cubicTo(65.445702F, 8.0F, 67.314423F, 9.868725F, 67.314423F, 12.173913F);
      ((Path)localObject3).lineTo(67.314423F, 75.548912F);
      ((Path)localObject3).cubicTo(67.314423F, 77.854103F, 65.445702F, 79.722824F, 63.140511F, 79.722824F);
      ((Path)localObject3).lineTo(12.226544F, 79.722824F);
      ((Path)localObject3).cubicTo(9.921356F, 79.722824F, 8.052631F, 77.854103F, 8.052631F, 75.548912F);
      ((Path)localObject3).lineTo(8.052631F, 12.173913F);
      ((Path)localObject3).cubicTo(8.052631F, 9.868725F, 9.921356F, 8.0F, 12.226544F, 8.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(18.827503F, 47.244564F);
      ((Path)localObject3).lineTo(18.827503F, 51.304348F);
      ((Path)localObject3).lineTo(56.539551F, 51.304348F);
      ((Path)localObject3).lineTo(56.539551F, 47.244564F);
      ((Path)localObject3).lineTo(18.827503F, 47.244564F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(18.827503F, 56.717392F);
      ((Path)localObject3).lineTo(18.827503F, 60.777172F);
      ((Path)localObject3).lineTo(56.539551F, 60.777172F);
      ((Path)localObject3).lineTo(56.539551F, 56.717392F);
      ((Path)localObject3).lineTo(18.827503F, 56.717392F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(18.827503F, 64.83696F);
      ((Path)localObject3).lineTo(18.827503F, 68.896736F);
      ((Path)localObject3).lineTo(56.539551F, 68.896736F);
      ((Path)localObject3).lineTo(56.539551F, 64.83696F);
      ((Path)localObject3).lineTo(18.827503F, 64.83696F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(60.582043F, 5.410628F);
      ((Path)localObject2).lineTo(7.472027F, 5.410628F);
      ((Path)localObject2).cubicTo(6.319433F, 5.410628F, 5.38507F, 6.34499F, 5.38507F, 7.497584F);
      ((Path)localObject2).lineTo(5.38507F, 73.04348F);
      ((Path)localObject2).lineTo(4.173913F, 73.04348F);
      ((Path)localObject2).cubicTo(1.868725F, 73.04348F, 1.170483E-015F, 71.174751F, 8.881784E-016F, 68.869568F);
      ((Path)localObject2).lineTo(0.0F, 4.173913F);
      ((Path)localObject2).cubicTo(-2.823042E-016F, 1.868725F, 1.868725F, 4.864348E-015F, 4.173913F, 4.440892E-015F);
      ((Path)localObject2).lineTo(56.408131F, 0.0F);
      ((Path)localObject2).cubicTo(58.713318F, -4.518294E-015F, 60.582043F, 1.868725F, 60.582043F, 4.173913F);
      ((Path)localObject2).lineTo(60.582043F, 5.410628F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_icon_translate
 * JD-Core Version:    0.7.0.1
 */