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

public class icons_outline_miniprogram_live
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-10197008);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(1.2F, 1.7F);
      ((Path)localObject3).lineTo(1.2F, 12.3F);
      ((Path)localObject3).lineTo(13.8F, 12.3F);
      ((Path)localObject3).lineTo(13.8F, 1.7F);
      ((Path)localObject3).lineTo(1.2F, 1.7F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(1.0F, 0.5F);
      ((Path)localObject3).lineTo(14.0F, 0.5F);
      ((Path)localObject3).cubicTo(14.552284F, 0.5F, 15.0F, 0.9477152F, 15.0F, 1.5F);
      ((Path)localObject3).lineTo(15.0F, 12.5F);
      ((Path)localObject3).cubicTo(15.0F, 13.052284F, 14.552284F, 13.5F, 14.0F, 13.5F);
      ((Path)localObject3).lineTo(1.0F, 13.5F);
      ((Path)localObject3).cubicTo(0.4477153F, 13.5F, 0.0F, 13.052284F, 0.0F, 12.5F);
      ((Path)localObject3).lineTo(0.0F, 1.5F);
      ((Path)localObject3).cubicTo(0.0F, 0.9477152F, 0.4477153F, 0.5F, 1.0F, 0.5F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(17.200001F, 8.42325F);
      ((Path)localObject3).lineTo(19.799999F, 10.50325F);
      ((Path)localObject3).lineTo(19.799999F, 3.49675F);
      ((Path)localObject3).lineTo(17.200001F, 5.57675F);
      ((Path)localObject3).lineTo(17.200001F, 8.42325F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(16.0F, 5.0F);
      ((Path)localObject3).lineTo(19.375305F, 2.299756F);
      ((Path)localObject3).cubicTo(19.806566F, 1.954747F, 20.43586F, 2.024668F, 20.780869F, 2.45593F);
      ((Path)localObject3).cubicTo(20.92272F, 2.633243F, 21.0F, 2.853553F, 21.0F, 3.080625F);
      ((Path)localObject3).lineTo(21.0F, 10.919375F);
      ((Path)localObject3).cubicTo(21.0F, 11.47166F, 20.552284F, 11.919375F, 20.0F, 11.919375F);
      ((Path)localObject3).cubicTo(19.772928F, 11.919375F, 19.552618F, 11.842094F, 19.375305F, 11.700244F);
      ((Path)localObject3).lineTo(16.0F, 9.0F);
      ((Path)localObject3).lineTo(16.0F, 5.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.9F, 8.299999F);
      ((Path)localObject2).cubicTo(6.507514F, 8.299999F, 7.0F, 8.792486F, 7.0F, 9.4F);
      ((Path)localObject2).cubicTo(7.0F, 10.007513F, 6.507514F, 10.5F, 5.9F, 10.5F);
      ((Path)localObject2).cubicTo(5.292487F, 10.5F, 4.8F, 10.007513F, 4.8F, 9.4F);
      ((Path)localObject2).cubicTo(4.8F, 8.792486F, 5.292487F, 8.299999F, 5.9F, 8.299999F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outline_miniprogram_live
 * JD-Core Version:    0.7.0.1
 */