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

public class camera_golden
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
      Matrix localMatrix = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      c.instancePaint((Paint)localObject1, paramVarArgs).setStrokeWidth(1.0F);
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-4284563);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      Object localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(66.362022F, 28.0F);
      ((Path)localObject2).lineTo(76.99543F, 28.0F);
      ((Path)localObject2).cubicTo(79.200432F, 28.0F, 81.0F, 29.79529F, 81.0F, 32.009892F);
      ((Path)localObject2).lineTo(81.0F, 71.990105F);
      ((Path)localObject2).cubicTo(81.0F, 74.205948F, 79.207092F, 76.0F, 76.99543F, 76.0F);
      ((Path)localObject2).lineTo(19.00457F, 76.0F);
      ((Path)localObject2).cubicTo(16.79957F, 76.0F, 15.0F, 74.204712F, 15.0F, 71.990105F);
      ((Path)localObject2).lineTo(15.0F, 32.009892F);
      ((Path)localObject2).cubicTo(15.0F, 29.794052F, 16.792908F, 28.0F, 19.00457F, 28.0F);
      ((Path)localObject2).lineTo(29.637974F, 28.0F);
      ((Path)localObject2).lineTo(36.0F, 22.0F);
      ((Path)localObject2).lineTo(60.0F, 22.0F);
      ((Path)localObject2).lineTo(66.362022F, 28.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(48.0F, 70.0F);
      ((Path)localObject2).cubicTo(59.045696F, 70.0F, 68.0F, 61.045696F, 68.0F, 50.0F);
      ((Path)localObject2).cubicTo(68.0F, 38.954304F, 59.045696F, 30.0F, 48.0F, 30.0F);
      ((Path)localObject2).cubicTo(36.954304F, 30.0F, 28.0F, 38.954304F, 28.0F, 50.0F);
      ((Path)localObject2).cubicTo(28.0F, 61.045696F, 36.954304F, 70.0F, 48.0F, 70.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(48.0F, 63.0F);
      ((Path)localObject2).cubicTo(55.179703F, 63.0F, 61.0F, 57.179703F, 61.0F, 50.0F);
      ((Path)localObject2).cubicTo(61.0F, 42.820297F, 55.179703F, 37.0F, 48.0F, 37.0F);
      ((Path)localObject2).cubicTo(40.820297F, 37.0F, 35.0F, 42.820297F, 35.0F, 50.0F);
      ((Path)localObject2).cubicTo(35.0F, 57.179703F, 40.820297F, 63.0F, 48.0F, 63.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(66.362022F, 28.0F);
      ((Path)localObject1).lineTo(76.99543F, 28.0F);
      ((Path)localObject1).cubicTo(79.200432F, 28.0F, 81.0F, 29.79529F, 81.0F, 32.009892F);
      ((Path)localObject1).lineTo(81.0F, 71.990105F);
      ((Path)localObject1).cubicTo(81.0F, 74.205948F, 79.207092F, 76.0F, 76.99543F, 76.0F);
      ((Path)localObject1).lineTo(19.00457F, 76.0F);
      ((Path)localObject1).cubicTo(16.79957F, 76.0F, 15.0F, 74.204712F, 15.0F, 71.990105F);
      ((Path)localObject1).lineTo(15.0F, 32.009892F);
      ((Path)localObject1).cubicTo(15.0F, 29.794052F, 16.792908F, 28.0F, 19.00457F, 28.0F);
      ((Path)localObject1).lineTo(29.637974F, 28.0F);
      ((Path)localObject1).lineTo(36.0F, 22.0F);
      ((Path)localObject1).lineTo(60.0F, 22.0F);
      ((Path)localObject1).lineTo(66.362022F, 28.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(48.0F, 70.0F);
      ((Path)localObject1).cubicTo(59.045696F, 70.0F, 68.0F, 61.045696F, 68.0F, 50.0F);
      ((Path)localObject1).cubicTo(68.0F, 38.954304F, 59.045696F, 30.0F, 48.0F, 30.0F);
      ((Path)localObject1).cubicTo(36.954304F, 30.0F, 28.0F, 38.954304F, 28.0F, 50.0F);
      ((Path)localObject1).cubicTo(28.0F, 61.045696F, 36.954304F, 70.0F, 48.0F, 70.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(48.0F, 63.0F);
      ((Path)localObject1).cubicTo(55.179703F, 63.0F, 61.0F, 57.179703F, 61.0F, 50.0F);
      ((Path)localObject1).cubicTo(61.0F, 42.820297F, 55.179703F, 37.0F, 48.0F, 37.0F);
      ((Path)localObject1).cubicTo(40.820297F, 37.0F, 35.0F, 42.820297F, 35.0F, 50.0F);
      ((Path)localObject1).cubicTo(35.0F, 57.179703F, 40.820297F, 63.0F, 48.0F, 63.0F);
      ((Path)localObject1).close();
      localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 81.0F, 0.0F, 15.0F, 0.0F, 76.0F, 22.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.7940693F, 0.8090447F, 0.08431214F, 0.07970222F, new int[] { -4679064, -2112619 }, new float[] { 0.0F, 1.0F }, localMatrix, 0);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.camera_golden
 * JD-Core Version:    0.7.0.1
 */