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

public class ime_right
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -415.0F, 0.0F, 1.0F, -977.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 915.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(409.38461F, 70.0F);
      ((Path)localObject2).lineTo(411.0F, 70.0F);
      ((Path)localObject2).cubicTo(411.0F, 72.205116F, 410.21796F, 74.089722F, 408.65384F, 75.653847F);
      ((Path)localObject2).cubicTo(407.08975F, 77.217964F, 405.20514F, 78.0F, 403.0F, 78.0F);
      ((Path)localObject2).cubicTo(400.79489F, 78.0F, 398.91028F, 77.217949F, 397.34616F, 75.653847F);
      ((Path)localObject2).cubicTo(395.78204F, 74.089745F, 395.0F, 72.205154F, 395.0F, 70.0F);
      ((Path)localObject2).cubicTo(395.0F, 67.794846F, 395.78204F, 65.910263F, 397.34616F, 64.346138F);
      ((Path)localObject2).cubicTo(398.91025F, 62.782017F, 400.79486F, 62.0F, 403.0F, 62.0F);
      ((Path)localObject2).cubicTo(404.02567F, 62.0F, 405.02563F, 62.20512F, 406.0F, 62.615379F);
      ((Path)localObject2).lineTo(404.76923F, 63.846149F);
      ((Path)localObject2).cubicTo(404.20514F, 63.692307F, 403.61539F, 63.615376F, 403.0F, 63.615376F);
      ((Path)localObject2).cubicTo(401.23074F, 63.615376F, 399.72437F, 64.237167F, 398.48077F, 65.480751F);
      ((Path)localObject2).cubicTo(397.23715F, 66.72435F, 396.61539F, 68.230736F, 396.61539F, 69.999977F);
      ((Path)localObject2).cubicTo(396.61539F, 71.769211F, 397.23718F, 73.275612F, 398.48077F, 74.519203F);
      ((Path)localObject2).cubicTo(399.72437F, 75.762802F, 401.23074F, 76.384575F, 403.0F, 76.384575F);
      ((Path)localObject2).cubicTo(404.76923F, 76.384575F, 406.27563F, 75.762787F, 407.51923F, 74.519203F);
      ((Path)localObject2).cubicTo(408.76282F, 73.275597F, 409.38461F, 71.769211F, 409.38461F, 69.999977F);
      ((Path)localObject2).lineTo(409.38461F, 70.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(399.73077F, 68.461525F);
      ((Path)localObject2).lineTo(402.19229F, 70.92305F);
      ((Path)localObject2).lineTo(409.07693F, 64.076904F);
      ((Path)localObject2).lineTo(410.19229F, 65.192276F);
      ((Path)localObject2).lineTo(402.19232F, 73.192268F);
      ((Path)localObject2).lineTo(398.61542F, 69.615364F);
      ((Path)localObject2).lineTo(399.73077F, 68.46151F);
      ((Path)localObject2).lineTo(399.73077F, 68.461525F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_right
 * JD-Core Version:    0.7.0.1
 */