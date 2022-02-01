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

public class app_attach_file_icon_ppt
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-892609);
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
      localObject2 = c.instancePaint(localPaint1, paramVarArgs);
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(40.023438F, 92.0F);
      ((Path)localObject1).lineTo(40.023438F, 80.820313F);
      ((Path)localObject1).lineTo(46.867188F, 80.820313F);
      ((Path)localObject1).cubicTo(53.710938F, 80.820313F, 58.515625F, 76.25F, 58.515625F, 69.5F);
      ((Path)localObject1).cubicTo(58.515625F, 62.75F, 53.851563F, 58.179688F, 47.125F, 58.179688F);
      ((Path)localObject1).lineTo(33.976563F, 58.179688F);
      ((Path)localObject1).lineTo(33.976563F, 92.0F);
      ((Path)localObject1).lineTo(40.023438F, 92.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(45.507813F, 75.945313F);
      ((Path)localObject1).lineTo(40.023438F, 75.945313F);
      ((Path)localObject1).lineTo(40.023438F, 63.125F);
      ((Path)localObject1).lineTo(45.53125F, 63.125F);
      ((Path)localObject1).cubicTo(49.867188F, 63.125F, 52.375F, 65.445313F, 52.375F, 69.5F);
      ((Path)localObject1).cubicTo(52.375F, 73.601563F, 49.84375F, 75.945313F, 45.507813F, 75.945313F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_ppt
 * JD-Core Version:    0.7.0.1
 */