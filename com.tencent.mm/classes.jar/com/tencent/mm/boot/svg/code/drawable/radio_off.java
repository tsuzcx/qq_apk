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

public class radio_off
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -305.0F, 0.0F, 1.0F, -141.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 305.0F, 0.0F, 1.0F, 141.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(60.0F, 0.0F);
      ((Path)localObject1).lineTo(60.0F, 60.0F);
      ((Path)localObject1).lineTo(0.0F, 60.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-5592406);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.0F, 30.0F);
      ((Path)localObject2).cubicTo(6.0F, 43.200001F, 16.799999F, 54.0F, 30.0F, 54.0F);
      ((Path)localObject2).cubicTo(43.200001F, 54.0F, 54.0F, 43.200001F, 54.0F, 30.0F);
      ((Path)localObject2).cubicTo(54.0F, 16.799999F, 43.200001F, 6.0F, 30.0F, 6.0F);
      ((Path)localObject2).cubicTo(16.799999F, 6.0F, 6.0F, 16.799999F, 6.0F, 30.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.0F, 30.0F);
      ((Path)localObject2).cubicTo(10.0F, 19.0F, 19.0F, 10.0F, 30.0F, 10.0F);
      ((Path)localObject2).cubicTo(41.0F, 10.0F, 50.0F, 19.0F, 50.0F, 30.0F);
      ((Path)localObject2).cubicTo(50.0F, 41.0F, 41.0F, 50.0F, 30.0F, 50.0F);
      ((Path)localObject2).cubicTo(19.0F, 50.0F, 10.0F, 41.0F, 10.0F, 30.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.radio_off
 * JD-Core Version:    0.7.0.1
 */