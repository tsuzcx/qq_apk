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

public class arrow_down
  extends c
{
  private final int height = 21;
  private final int width = 39;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 39;
      return 21;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 83, 31);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      localObject4 = c.setMatrixFloatArray((float[])localObject2, -1.0F, 1.224647E-016F, 72.0F, -1.224647E-016F, -1.0F, 72.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, 6.123234E-017F, 1.0F, -9.0F, 1.0F, -6.123234E-017F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(63.0F, 77.810799F);
      ((Path)localObject1).lineTo(59.877548F, 81.0F);
      ((Path)localObject1).lineTo(42.883453F, 63.64262F);
      ((Path)localObject1).cubicTo(41.724884F, 62.459286F, 41.71944F, 60.546272F, 42.883453F, 59.35738F);
      ((Path)localObject1).lineTo(59.877548F, 42.0F);
      ((Path)localObject1).lineTo(63.0F, 45.189201F);
      ((Path)localObject1).lineTo(47.030582F, 61.5F);
      ((Path)localObject1).lineTo(63.0F, 77.810799F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.arrow_down
 * JD-Core Version:    0.7.0.1
 */