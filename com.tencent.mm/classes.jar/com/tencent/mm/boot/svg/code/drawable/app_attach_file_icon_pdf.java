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

public class app_attach_file_icon_pdf
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
      ((Paint)localObject1).setColor(-1686720);
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
      ((Path)localObject1).moveTo(22.015625F, 86.0F);
      ((Path)localObject1).lineTo(22.015625F, 78.546875F);
      ((Path)localObject1).lineTo(26.578125F, 78.546875F);
      ((Path)localObject1).cubicTo(31.140625F, 78.546875F, 34.34375F, 75.5F, 34.34375F, 71.0F);
      ((Path)localObject1).cubicTo(34.34375F, 66.5F, 31.234375F, 63.453125F, 26.75F, 63.453125F);
      ((Path)localObject1).lineTo(17.984375F, 63.453125F);
      ((Path)localObject1).lineTo(17.984375F, 86.0F);
      ((Path)localObject1).lineTo(22.015625F, 86.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(25.671875F, 75.296875F);
      ((Path)localObject1).lineTo(22.015625F, 75.296875F);
      ((Path)localObject1).lineTo(22.015625F, 66.75F);
      ((Path)localObject1).lineTo(25.6875F, 66.75F);
      ((Path)localObject1).cubicTo(28.578125F, 66.75F, 30.25F, 68.296875F, 30.25F, 71.0F);
      ((Path)localObject1).cubicTo(30.25F, 73.734375F, 28.5625F, 75.296875F, 25.671875F, 75.296875F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(45.515625F, 86.0F);
      ((Path)localObject1).cubicTo(52.265625F, 86.0F, 56.234375F, 81.8125F, 56.234375F, 74.671875F);
      ((Path)localObject1).cubicTo(56.234375F, 67.53125F, 52.25F, 63.453125F, 45.515625F, 63.453125F);
      ((Path)localObject1).lineTo(37.28125F, 63.453125F);
      ((Path)localObject1).lineTo(37.28125F, 86.0F);
      ((Path)localObject1).lineTo(45.515625F, 86.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(45.09375F, 82.59375F);
      ((Path)localObject1).lineTo(41.3125F, 82.59375F);
      ((Path)localObject1).lineTo(41.3125F, 66.859375F);
      ((Path)localObject1).lineTo(45.09375F, 66.859375F);
      ((Path)localObject1).cubicTo(49.59375F, 66.859375F, 52.125F, 69.640625F, 52.125F, 74.6875F);
      ((Path)localObject1).cubicTo(52.125F, 79.828125F, 49.625F, 82.59375F, 45.09375F, 82.59375F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(63.453125F, 86.0F);
      ((Path)localObject1).lineTo(63.453125F, 76.796875F);
      ((Path)localObject1).lineTo(72.90625F, 76.796875F);
      ((Path)localObject1).lineTo(72.90625F, 73.515625F);
      ((Path)localObject1).lineTo(63.453125F, 73.515625F);
      ((Path)localObject1).lineTo(63.453125F, 66.859375F);
      ((Path)localObject1).lineTo(73.796875F, 66.859375F);
      ((Path)localObject1).lineTo(73.796875F, 63.453125F);
      ((Path)localObject1).lineTo(59.421875F, 63.453125F);
      ((Path)localObject1).lineTo(59.421875F, 86.0F);
      ((Path)localObject1).lineTo(63.453125F, 86.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_pdf
 * JD-Core Version:    0.7.0.1
 */