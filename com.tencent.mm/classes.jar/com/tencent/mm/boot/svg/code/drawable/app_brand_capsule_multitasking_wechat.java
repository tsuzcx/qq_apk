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

public class app_brand_capsule_multitasking_wechat
  extends c
{
  private final int height = 150;
  private final int width = 150;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 150;
      return 150;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -239.0F, 0.0F, 1.0F, -739.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 239.0F, 0.0F, 1.0F, 739.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16139513);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(75.0F, 0.0F);
      ((Path)localObject2).cubicTo(116.42136F, 0.0F, 150.0F, 33.57864F, 150.0F, 75.0F);
      ((Path)localObject2).cubicTo(150.0F, 116.42136F, 116.42136F, 150.0F, 75.0F, 150.0F);
      ((Path)localObject2).cubicTo(33.57864F, 150.0F, 0.0F, 116.42136F, 0.0F, 75.0F);
      ((Path)localObject2).cubicTo(0.0F, 33.57864F, 33.57864F, 0.0F, 75.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(40.333332F, 110.27027F);
      ((Path)localObject1).cubicTo(37.63287F, 110.70741F, 36.316177F, 109.3305F, 37.133335F, 107.07616F);
      ((Path)localObject1).lineTo(41.400002F, 94.299751F);
      ((Path)localObject1).cubicTo(37.380486F, 88.308548F, 35.0F, 83.169525F, 35.0F, 76.199837F);
      ((Path)localObject1).cubicTo(35.0F, 56.088482F, 52.908798F, 40.0F, 75.533333F, 40.0F);
      ((Path)localObject1).cubicTo(97.091202F, 40.0F, 115.0F, 56.088482F, 115.0F, 76.199837F);
      ((Path)localObject1).cubicTo(115.0F, 95.780472F, 97.091202F, 110.27027F, 75.533333F, 110.27027F);
      ((Path)localObject1).cubicTo(67.613953F, 110.27027F, 60.695438F, 108.47199F, 55.266666F, 104.94676F);
      ((Path)localObject1).lineTo(40.333332F, 110.27027F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_capsule_multitasking_wechat
 * JD-Core Version:    0.7.0.1
 */