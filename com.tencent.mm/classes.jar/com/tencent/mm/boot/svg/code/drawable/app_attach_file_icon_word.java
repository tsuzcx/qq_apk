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

public class app_attach_file_icon_word
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(120.0F, 0.0F);
      ((Path)localObject3).lineTo(120.0F, 120.0F);
      ((Path)localObject3).lineTo(0.0F, 120.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-13871462);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(90.0F, 116.0F);
      ((Path)localObject2).cubicTo(90.0F, 118.20914F, 88.209137F, 120.0F, 86.0F, 120.0F);
      ((Path)localObject2).lineTo(4.0F, 120.0F);
      ((Path)localObject2).cubicTo(1.790861F, 120.0F, 2.569541E-013F, 118.20914F, 2.557954E-013F, 116.0F);
      ((Path)localObject2).lineTo(2.557954E-013F, 4.0F);
      ((Path)localObject2).cubicTo(2.555249E-013F, 1.790861F, 1.790861F, 1.293991E-015F, 4.0F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 0.0F);
      ((Path)localObject2).lineTo(90.0F, 30.0F);
      ((Path)localObject2).lineTo(90.0F, 116.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(90.0F, 30.0F);
      ((Path)localObject1).lineTo(64.0F, 30.0F);
      ((Path)localObject1).cubicTo(61.790859F, 30.0F, 60.0F, 28.209139F, 60.0F, 26.0F);
      ((Path)localObject1).lineTo(60.0F, 0.0F);
      ((Path)localObject1).lineTo(60.0F, 0.0F);
      ((Path)localObject1).lineTo(90.0F, 30.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(37.773438F, 92.0F);
      ((Path)localObject1).lineTo(44.6875F, 67.53125F);
      ((Path)localObject1).lineTo(44.921875F, 67.53125F);
      ((Path)localObject1).lineTo(51.835938F, 92.0F);
      ((Path)localObject1).lineTo(57.53125F, 92.0F);
      ((Path)localObject1).lineTo(66.601563F, 58.179688F);
      ((Path)localObject1).lineTo(60.320313F, 58.179688F);
      ((Path)localObject1).lineTo(54.460938F, 83.796875F);
      ((Path)localObject1).lineTo(54.273438F, 83.796875F);
      ((Path)localObject1).lineTo(47.476563F, 58.179688F);
      ((Path)localObject1).lineTo(42.132813F, 58.179688F);
      ((Path)localObject1).lineTo(35.335938F, 83.796875F);
      ((Path)localObject1).lineTo(35.148438F, 83.796875F);
      ((Path)localObject1).lineTo(29.289063F, 58.179688F);
      ((Path)localObject1).lineTo(23.007813F, 58.179688F);
      ((Path)localObject1).lineTo(32.078125F, 92.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_word
 * JD-Core Version:    0.7.0.1
 */