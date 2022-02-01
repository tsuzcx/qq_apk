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

public class ofm_myqrcode_icon
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-460552);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 20.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.0F, 1.0F);
      ((Path)localObject2).cubicTo(2.69737F, -0.3197964F, 4.455656F, 0.2092119F, 6.0F, 0.0F);
      ((Path)localObject2).cubicTo(21.349184F, 0.0794551F, 36.734184F, 0.02954869F, 52.0F, 0.0F);
      ((Path)localObject2).cubicTo(53.897449F, -0.2998338F, 55.955444F, 1.007715F, 56.0F, 3.0F);
      ((Path)localObject2).cubicTo(56.025375F, 19.303417F, 55.925472F, 35.692692F, 56.0F, 52.0F);
      ((Path)localObject2).cubicTo(56.25515F, 53.838676F, 55.016357F, 56.024578F, 53.0F, 56.0F);
      ((Path)localObject2).cubicTo(36.684235F, 56.004616F, 20.330177F, 55.914783F, 4.0F, 56.0F);
      ((Path)localObject2).cubicTo(2.197857F, 56.274109F, -0.009990259F, 55.1063F, 3.552714E-015F, 53.0F);
      ((Path)localObject2).cubicTo(-0.07992207F, 37.090073F, 0.0699318F, 21.050142F, 3.552714E-015F, 5.0F);
      ((Path)localObject2).cubicTo(0.02997078F, 3.453131F, -0.229776F, 1.496798F, 1.0F, 1.0F);
      ((Path)localObject2).lineTo(1.0F, 1.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.0F, 5.0F);
      ((Path)localObject2).lineTo(5.0F, 29.0F);
      ((Path)localObject2).lineTo(29.0F, 29.0F);
      ((Path)localObject2).lineTo(29.0F, 5.0F);
      ((Path)localObject2).lineTo(5.0F, 5.0F);
      ((Path)localObject2).lineTo(5.0F, 5.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(35.0F, 5.0F);
      ((Path)localObject2).lineTo(35.0F, 21.0F);
      ((Path)localObject2).lineTo(51.0F, 21.0F);
      ((Path)localObject2).lineTo(51.0F, 5.0F);
      ((Path)localObject2).lineTo(35.0F, 5.0F);
      ((Path)localObject2).lineTo(35.0F, 5.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.0F, 27.0F);
      ((Path)localObject2).lineTo(41.0F, 32.0F);
      ((Path)localObject2).lineTo(32.0F, 32.0F);
      ((Path)localObject2).lineTo(32.0F, 41.0F);
      ((Path)localObject2).lineTo(41.0F, 41.0F);
      ((Path)localObject2).lineTo(41.0F, 46.0F);
      ((Path)localObject2).lineTo(36.0F, 46.0F);
      ((Path)localObject2).lineTo(36.0F, 51.0F);
      ((Path)localObject2).lineTo(51.0F, 51.0F);
      ((Path)localObject2).lineTo(51.0F, 46.0F);
      ((Path)localObject2).lineTo(46.0F, 46.0F);
      ((Path)localObject2).lineTo(46.0F, 41.0F);
      ((Path)localObject2).lineTo(51.0F, 41.0F);
      ((Path)localObject2).lineTo(51.0F, 27.0F);
      ((Path)localObject2).lineTo(41.0F, 27.0F);
      ((Path)localObject2).lineTo(41.0F, 27.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.0F, 34.0F);
      ((Path)localObject2).lineTo(10.0F, 39.0F);
      ((Path)localObject2).lineTo(15.0F, 39.0F);
      ((Path)localObject2).lineTo(15.0F, 34.0F);
      ((Path)localObject2).lineTo(10.0F, 34.0F);
      ((Path)localObject2).lineTo(10.0F, 34.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(20.0F, 34.0F);
      ((Path)localObject2).lineTo(20.0F, 39.0F);
      ((Path)localObject2).lineTo(15.0F, 39.0F);
      ((Path)localObject2).lineTo(15.0F, 44.0F);
      ((Path)localObject2).lineTo(25.0F, 44.0F);
      ((Path)localObject2).lineTo(25.0F, 34.0F);
      ((Path)localObject2).lineTo(20.0F, 34.0F);
      ((Path)localObject2).lineTo(20.0F, 34.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.0F, 39.0F);
      ((Path)localObject2).lineTo(5.0F, 51.0F);
      ((Path)localObject2).lineTo(14.0F, 51.0F);
      ((Path)localObject2).lineTo(14.0F, 46.0F);
      ((Path)localObject2).lineTo(10.0F, 46.0F);
      ((Path)localObject2).lineTo(10.0F, 39.0F);
      ((Path)localObject2).lineTo(5.0F, 39.0F);
      ((Path)localObject2).lineTo(5.0F, 39.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.0F, 44.0F);
      ((Path)localObject2).lineTo(25.0F, 51.0F);
      ((Path)localObject2).lineTo(32.0F, 51.0F);
      ((Path)localObject2).lineTo(32.0F, 44.0F);
      ((Path)localObject2).lineTo(25.0F, 44.0F);
      ((Path)localObject2).lineTo(25.0F, 44.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 9.0F);
      ((Path)localObject2).lineTo(25.0F, 9.0F);
      ((Path)localObject2).lineTo(25.0F, 25.0F);
      ((Path)localObject2).lineTo(9.0F, 25.0F);
      ((Path)localObject2).lineTo(9.0F, 9.0F);
      ((Path)localObject2).lineTo(9.0F, 9.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(41.0F, 32.0F);
      ((Path)localObject1).lineTo(46.0F, 32.0F);
      ((Path)localObject1).lineTo(46.0F, 41.0F);
      ((Path)localObject1).lineTo(41.0F, 41.0F);
      ((Path)localObject1).lineTo(41.0F, 32.0F);
      ((Path)localObject1).lineTo(41.0F, 32.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ofm_myqrcode_icon
 * JD-Core Version:    0.7.0.1
 */