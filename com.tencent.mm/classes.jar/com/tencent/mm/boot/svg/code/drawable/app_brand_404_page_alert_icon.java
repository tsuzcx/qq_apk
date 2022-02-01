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

public class app_brand_404_page_alert_icon
  extends c
{
  private final int height = 280;
  private final int width = 280;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 280;
      return 280;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -10.0F, 0.0F, 1.0F, -10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16896);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(289.5F, 151.72223F);
      ((Path)localObject2).cubicTo(289.5F, 72.954666F, 227.04533F, 10.5F, 148.27777F, 10.5F);
      ((Path)localObject2).cubicTo(72.954666F, 10.5F, 10.5F, 72.954666F, 10.5F, 151.72223F);
      ((Path)localObject2).cubicTo(10.5F, 227.04533F, 72.954666F, 289.5F, 148.27777F, 289.5F);
      ((Path)localObject2).cubicTo(227.04533F, 289.5F, 289.5F, 227.04533F, 289.5F, 151.72223F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(141.49457F, 85.5F);
      ((Path)localObject1).cubicTo(140.39299F, 85.5F, 139.53296F, 86.392433F, 139.57391F, 87.500977F);
      ((Path)localObject1).lineTo(142.96306F, 179.25606F);
      ((Path)localObject1).cubicTo(142.98346F, 179.80836F, 143.44995F, 180.2561F, 144.00685F, 180.2561F);
      ((Path)localObject1).lineTo(155.99315F, 180.2561F);
      ((Path)localObject1).cubicTo(156.54922F, 180.2561F, 157.01639F, 179.81255F, 157.03694F, 179.25606F);
      ((Path)localObject1).lineTo(160.42609F, 87.500977F);
      ((Path)localObject1).cubicTo(160.4669F, 86.395866F, 159.59766F, 85.5F, 158.50543F, 85.5F);
      ((Path)localObject1).lineTo(141.49457F, 85.5F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(150.0F, 214.5F);
      ((Path)localObject1).cubicTo(155.799F, 214.5F, 160.5F, 209.799F, 160.5F, 204.0F);
      ((Path)localObject1).cubicTo(160.5F, 198.201F, 155.799F, 193.5F, 150.0F, 193.5F);
      ((Path)localObject1).cubicTo(144.201F, 193.5F, 139.5F, 198.201F, 139.5F, 204.0F);
      ((Path)localObject1).cubicTo(139.5F, 209.799F, 144.201F, 214.5F, 150.0F, 214.5F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_404_page_alert_icon
 * JD-Core Version:    0.7.0.1
 */