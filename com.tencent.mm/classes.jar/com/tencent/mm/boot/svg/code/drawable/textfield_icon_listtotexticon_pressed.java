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

public class textfield_icon_listtotexticon_pressed
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, -1.0F, 1.224647E-016F, 120.0F, -1.224647E-016F, -1.0F, 120.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject2, 1.0F, -2.449294E-016F, 1.175661E-014F, 2.449294E-016F, 1.0F, -1.421086E-014F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(96.0F, 0.0F);
      ((Path)localObject2).lineTo(96.0F, 96.0F);
      ((Path)localObject2).lineTo(0.0F, 96.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-9473160);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 1.224647E-016F, 96.0F, -1.224647E-016F, -1.0F, 76.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      Object localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(26.0F, 22.998102F);
      ((Path)localObject4).cubicTo(26.0F, 21.894581F, 26.886707F, 21.0F, 27.998102F, 21.0F);
      ((Path)localObject4).lineTo(32.0019F, 21.0F);
      ((Path)localObject4).cubicTo(33.105419F, 21.0F, 34.0F, 21.886707F, 34.0F, 22.998102F);
      ((Path)localObject4).lineTo(34.0F, 27.001898F);
      ((Path)localObject4).cubicTo(34.0F, 28.105419F, 33.113293F, 29.0F, 32.0019F, 29.0F);
      ((Path)localObject4).lineTo(27.998102F, 29.0F);
      ((Path)localObject4).cubicTo(26.894581F, 29.0F, 26.0F, 28.113293F, 26.0F, 27.001898F);
      ((Path)localObject4).lineTo(26.0F, 22.998102F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(26.0F, 34.9981F);
      ((Path)localObject4).cubicTo(26.0F, 33.894581F, 26.886707F, 33.0F, 27.998102F, 33.0F);
      ((Path)localObject4).lineTo(32.0019F, 33.0F);
      ((Path)localObject4).cubicTo(33.105419F, 33.0F, 34.0F, 33.886707F, 34.0F, 34.9981F);
      ((Path)localObject4).lineTo(34.0F, 39.0019F);
      ((Path)localObject4).cubicTo(34.0F, 40.105419F, 33.113293F, 41.0F, 32.0019F, 41.0F);
      ((Path)localObject4).lineTo(27.998102F, 41.0F);
      ((Path)localObject4).cubicTo(26.894581F, 41.0F, 26.0F, 40.113293F, 26.0F, 39.0019F);
      ((Path)localObject4).lineTo(26.0F, 34.9981F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(50.0F, 22.998102F);
      ((Path)localObject4).cubicTo(50.0F, 21.894581F, 50.886707F, 21.0F, 51.9981F, 21.0F);
      ((Path)localObject4).lineTo(56.0019F, 21.0F);
      ((Path)localObject4).cubicTo(57.105419F, 21.0F, 58.0F, 21.886707F, 58.0F, 22.998102F);
      ((Path)localObject4).lineTo(58.0F, 27.001898F);
      ((Path)localObject4).cubicTo(58.0F, 28.105419F, 57.113293F, 29.0F, 56.0019F, 29.0F);
      ((Path)localObject4).lineTo(51.9981F, 29.0F);
      ((Path)localObject4).cubicTo(50.894581F, 29.0F, 50.0F, 28.113293F, 50.0F, 27.001898F);
      ((Path)localObject4).lineTo(50.0F, 22.998102F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(50.0F, 34.9981F);
      ((Path)localObject4).cubicTo(50.0F, 33.894581F, 50.886707F, 33.0F, 51.9981F, 33.0F);
      ((Path)localObject4).lineTo(56.0019F, 33.0F);
      ((Path)localObject4).cubicTo(57.105419F, 33.0F, 58.0F, 33.886707F, 58.0F, 34.9981F);
      ((Path)localObject4).lineTo(58.0F, 39.0019F);
      ((Path)localObject4).cubicTo(58.0F, 40.105419F, 57.113293F, 41.0F, 56.0019F, 41.0F);
      ((Path)localObject4).lineTo(51.9981F, 41.0F);
      ((Path)localObject4).cubicTo(50.894581F, 41.0F, 50.0F, 40.113293F, 50.0F, 39.0019F);
      ((Path)localObject4).lineTo(50.0F, 34.9981F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(38.0F, 22.998102F);
      ((Path)localObject4).cubicTo(38.0F, 21.894581F, 38.886707F, 21.0F, 39.9981F, 21.0F);
      ((Path)localObject4).lineTo(44.0019F, 21.0F);
      ((Path)localObject4).cubicTo(45.105419F, 21.0F, 46.0F, 21.886707F, 46.0F, 22.998102F);
      ((Path)localObject4).lineTo(46.0F, 27.001898F);
      ((Path)localObject4).cubicTo(46.0F, 28.105419F, 45.113293F, 29.0F, 44.0019F, 29.0F);
      ((Path)localObject4).lineTo(39.9981F, 29.0F);
      ((Path)localObject4).cubicTo(38.894581F, 29.0F, 38.0F, 28.113293F, 38.0F, 27.001898F);
      ((Path)localObject4).lineTo(38.0F, 22.998102F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(38.0F, 34.9981F);
      ((Path)localObject4).cubicTo(38.0F, 33.894581F, 38.886707F, 33.0F, 39.9981F, 33.0F);
      ((Path)localObject4).lineTo(44.0019F, 33.0F);
      ((Path)localObject4).cubicTo(45.105419F, 33.0F, 46.0F, 33.886707F, 46.0F, 34.9981F);
      ((Path)localObject4).lineTo(46.0F, 39.0019F);
      ((Path)localObject4).cubicTo(46.0F, 40.105419F, 45.113293F, 41.0F, 44.0019F, 41.0F);
      ((Path)localObject4).lineTo(39.9981F, 41.0F);
      ((Path)localObject4).cubicTo(38.894581F, 41.0F, 38.0F, 40.113293F, 38.0F, 39.0019F);
      ((Path)localObject4).lineTo(38.0F, 34.9981F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(62.0F, 22.998102F);
      ((Path)localObject4).cubicTo(62.0F, 21.894581F, 62.886707F, 21.0F, 63.9981F, 21.0F);
      ((Path)localObject4).lineTo(68.0019F, 21.0F);
      ((Path)localObject4).cubicTo(69.105423F, 21.0F, 70.0F, 21.886707F, 70.0F, 22.998102F);
      ((Path)localObject4).lineTo(70.0F, 27.001898F);
      ((Path)localObject4).cubicTo(70.0F, 28.105419F, 69.113297F, 29.0F, 68.0019F, 29.0F);
      ((Path)localObject4).lineTo(63.9981F, 29.0F);
      ((Path)localObject4).cubicTo(62.894581F, 29.0F, 62.0F, 28.113293F, 62.0F, 27.001898F);
      ((Path)localObject4).lineTo(62.0F, 22.998102F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(62.0F, 34.9981F);
      ((Path)localObject4).cubicTo(62.0F, 33.894581F, 62.886707F, 33.0F, 63.9981F, 33.0F);
      ((Path)localObject4).lineTo(68.0019F, 33.0F);
      ((Path)localObject4).cubicTo(69.105423F, 33.0F, 70.0F, 33.886707F, 70.0F, 34.9981F);
      ((Path)localObject4).lineTo(70.0F, 39.0019F);
      ((Path)localObject4).cubicTo(70.0F, 40.105419F, 69.113297F, 41.0F, 68.0019F, 41.0F);
      ((Path)localObject4).lineTo(63.9981F, 41.0F);
      ((Path)localObject4).cubicTo(62.894581F, 41.0F, 62.0F, 40.113293F, 62.0F, 39.0019F);
      ((Path)localObject4).lineTo(62.0F, 34.9981F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(34.0F, 48.9981F);
      ((Path)localObject4).cubicTo(34.0F, 47.894581F, 34.899899F, 47.0F, 35.991245F, 47.0F);
      ((Path)localObject4).lineTo(60.008755F, 47.0F);
      ((Path)localObject4).cubicTo(61.10849F, 47.0F, 62.0F, 47.886707F, 62.0F, 48.9981F);
      ((Path)localObject4).lineTo(62.0F, 53.0019F);
      ((Path)localObject4).cubicTo(62.0F, 54.105419F, 61.100101F, 55.0F, 60.008755F, 55.0F);
      ((Path)localObject4).lineTo(35.991245F, 55.0F);
      ((Path)localObject4).cubicTo(34.89151F, 55.0F, 34.0F, 54.113293F, 34.0F, 53.0019F);
      ((Path)localObject4).lineTo(34.0F, 48.9981F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject4 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject4).setColor(419430400);
      localObject2 = c.setMatrixFloatArray((float[])localObject3, 1.0F, -2.449294E-016F, 9.307316E-015F, 2.449294E-016F, 1.0F, -1.421086E-014F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(7.0F, 13.0F);
      ((Path)localObject3).cubicTo(7.0F, 9.686291F, 9.686291F, 7.0F, 13.0F, 7.0F);
      ((Path)localObject3).lineTo(83.0F, 7.0F);
      ((Path)localObject3).cubicTo(86.313705F, 7.0F, 89.0F, 9.686291F, 89.0F, 13.0F);
      ((Path)localObject3).lineTo(89.0F, 63.0F);
      ((Path)localObject3).cubicTo(89.0F, 66.313705F, 86.313705F, 69.0F, 83.0F, 69.0F);
      ((Path)localObject3).lineTo(13.0F, 69.0F);
      ((Path)localObject3).cubicTo(9.686291F, 69.0F, 7.0F, 66.313705F, 7.0F, 63.0F);
      ((Path)localObject3).lineTo(7.0F, 13.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-9473160);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(7.0F, 13.001155F);
      ((Path)localObject4).cubicTo(7.0F, 9.686809F, 9.681666F, 7.0F, 12.996433F, 7.0F);
      ((Path)localObject4).lineTo(83.003563F, 7.0F);
      ((Path)localObject4).cubicTo(86.315308F, 7.0F, 89.0F, 9.683963F, 89.0F, 13.001155F);
      ((Path)localObject4).lineTo(89.0F, 62.998844F);
      ((Path)localObject4).cubicTo(89.0F, 66.313194F, 86.318336F, 69.0F, 83.003563F, 69.0F);
      ((Path)localObject4).lineTo(12.996433F, 69.0F);
      ((Path)localObject4).cubicTo(9.684694F, 69.0F, 7.0F, 66.31604F, 7.0F, 62.998844F);
      ((Path)localObject4).lineTo(7.0F, 13.001155F);
      ((Path)localObject4).close();
      ((Path)localObject4).moveTo(9.0F, 13.009459F);
      ((Path)localObject4).cubicTo(9.0F, 10.795095F, 10.794424F, 9.0F, 13.002277F, 9.0F);
      ((Path)localObject4).lineTo(82.997719F, 9.0F);
      ((Path)localObject4).cubicTo(85.208122F, 9.0F, 87.0F, 10.799425F, 87.0F, 13.009459F);
      ((Path)localObject4).lineTo(87.0F, 62.99054F);
      ((Path)localObject4).cubicTo(87.0F, 65.204903F, 85.205574F, 67.0F, 82.997719F, 67.0F);
      ((Path)localObject4).lineTo(13.002277F, 67.0F);
      ((Path)localObject4).cubicTo(10.791881F, 67.0F, 9.0F, 65.200577F, 9.0F, 62.99054F);
      ((Path)localObject4).lineTo(9.0F, 13.009459F);
      ((Path)localObject4).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-9473160);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, -2.449294E-016F, 2.088095E-014F, 2.449294E-016F, 1.0F, -1.421086E-014F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(39.0F, 80.0F);
      ((Path)localObject1).lineTo(57.0F, 80.0F);
      ((Path)localObject1).lineTo(48.0F, 90.505859F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.textfield_icon_listtotexticon_pressed
 * JD-Core Version:    0.7.0.1
 */