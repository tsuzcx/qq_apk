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

public class connect_icon_lock_on_regular
  extends c
{
  private final int height = 162;
  private final int width = 162;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 162;
      return 162;
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
      localCanvas.saveLayerAlpha(null, 128, 31);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.333333F, 0.0F, 1.0F, 0.222222F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.6666667F, 80.727776F);
      ((Path)localObject2).cubicTo(0.6666667F, 36.615704F, 36.554333F, 0.7277778F, 80.666664F, 0.7277778F);
      ((Path)localObject2).cubicTo(124.779F, 0.7277778F, 160.66667F, 36.615704F, 160.66667F, 80.727776F);
      ((Path)localObject2).cubicTo(160.66667F, 124.83985F, 124.779F, 160.72778F, 80.666664F, 160.72778F);
      ((Path)localObject2).cubicTo(36.554333F, 160.72778F, 0.6666667F, 124.83985F, 0.6666667F, 80.727776F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-11711155);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(94.666664F, 75.727776F);
      ((Path)localObject1).lineTo(94.666664F, 72.727776F);
      ((Path)localObject1).lineTo(94.666664F, 65.727776F);
      ((Path)localObject1).cubicTo(94.666664F, 57.595959F, 88.186668F, 50.727779F, 80.150536F, 50.727779F);
      ((Path)localObject1).lineTo(79.182793F, 50.727779F);
      ((Path)localObject1).cubicTo(71.139168F, 50.727779F, 64.666664F, 57.594822F, 64.666664F, 65.727776F);
      ((Path)localObject1).lineTo(64.666664F, 72.727776F);
      ((Path)localObject1).lineTo(64.666664F, 75.727776F);
      ((Path)localObject1).lineTo(94.666664F, 75.727776F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(67.666664F, 66.394447F);
      ((Path)localObject1).cubicTo(67.666664F, 59.320904F, 72.809212F, 53.727779F, 78.666664F, 53.727779F);
      ((Path)localObject1).lineTo(80.666664F, 53.727779F);
      ((Path)localObject1).cubicTo(86.524124F, 53.727779F, 91.666664F, 59.320904F, 91.666664F, 66.394447F);
      ((Path)localObject1).lineTo(91.666664F, 72.727776F);
      ((Path)localObject1).lineTo(67.666664F, 72.727776F);
      ((Path)localObject1).lineTo(67.666664F, 66.394447F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(94.666664F, 72.727776F);
      ((Path)localObject1).lineTo(94.666664F, 75.727776F);
      ((Path)localObject1).lineTo(101.66666F, 75.727776F);
      ((Path)localObject1).lineTo(101.66666F, 107.72778F);
      ((Path)localObject1).lineTo(57.666668F, 107.72778F);
      ((Path)localObject1).lineTo(57.666668F, 75.727776F);
      ((Path)localObject1).lineTo(64.666664F, 75.727776F);
      ((Path)localObject1).lineTo(64.666664F, 72.727776F);
      ((Path)localObject1).lineTo(57.666668F, 72.727776F);
      ((Path)localObject1).cubicTo(56.894035F, 72.885368F, 56.491581F, 73.059715F, 55.666668F, 73.727776F);
      ((Path)localObject1).cubicTo(55.429451F, 73.782837F, 54.912796F, 74.532776F, 54.666668F, 75.727776F);
      ((Path)localObject1).cubicTo(54.689949F, 75.625839F, 54.666668F, 107.72778F, 54.666668F, 107.72778F);
      ((Path)localObject1).cubicTo(54.666668F, 108.5316F, 55.248734F, 109.55201F, 55.666668F, 109.72778F);
      ((Path)localObject1).cubicTo(56.664536F, 110.51654F, 57.305363F, 110.72778F, 57.666668F, 110.72778F);
      ((Path)localObject1).lineTo(101.66666F, 110.72778F);
      ((Path)localObject1).cubicTo(103.16882F, 110.72778F, 104.66666F, 109.22566F, 104.66666F, 107.72778F);
      ((Path)localObject1).lineTo(104.66666F, 75.727776F);
      ((Path)localObject1).cubicTo(104.66666F, 74.228775F, 103.17769F, 72.727776F, 101.66666F, 72.727776F);
      ((Path)localObject1).lineTo(94.666664F, 72.727776F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_icon_lock_on_regular
 * JD-Core Version:    0.7.0.1
 */