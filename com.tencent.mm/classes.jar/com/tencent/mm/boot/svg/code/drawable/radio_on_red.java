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

public class radio_on_red
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
      localPaint1.setColor(-899014);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -218.0F, 0.0F, 1.0F, -230.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 224.0F, 0.0F, 1.0F, 236.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 24.0F);
      ((Path)localObject2).cubicTo(0.0F, 10.8F, 10.8F, 0.0F, 24.0F, 0.0F);
      ((Path)localObject2).cubicTo(37.200001F, 0.0F, 48.0F, 10.8F, 48.0F, 24.0F);
      ((Path)localObject2).cubicTo(48.0F, 37.200001F, 37.200001F, 48.0F, 24.0F, 48.0F);
      ((Path)localObject2).cubicTo(10.8F, 48.0F, 0.0F, 37.200001F, 0.0F, 24.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.0F, 24.0F);
      ((Path)localObject2).cubicTo(4.0F, 35.0F, 13.0F, 44.0F, 24.0F, 44.0F);
      ((Path)localObject2).cubicTo(35.0F, 44.0F, 44.0F, 35.0F, 44.0F, 24.0F);
      ((Path)localObject2).cubicTo(44.0F, 13.0F, 35.0F, 4.0F, 24.0F, 4.0F);
      ((Path)localObject2).cubicTo(13.0F, 4.0F, 4.0F, 13.0F, 4.0F, 24.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.0F, 24.0F);
      ((Path)localObject2).cubicTo(10.0F, 31.700001F, 16.299999F, 38.0F, 24.0F, 38.0F);
      ((Path)localObject2).cubicTo(31.700001F, 38.0F, 38.0F, 31.700001F, 38.0F, 24.0F);
      ((Path)localObject2).cubicTo(38.0F, 16.299999F, 31.700001F, 10.0F, 24.0F, 10.0F);
      ((Path)localObject2).cubicTo(16.299999F, 10.0F, 10.0F, 16.299999F, 10.0F, 24.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.radio_on_red
 * JD-Core Version:    0.7.0.1
 */