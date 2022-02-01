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

public class c2c_remittance_received_icon
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
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
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -2.0F, 0.0F, 1.0F, -2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(17.0F, 2.833333F);
      ((Path)localObject2).cubicTo(24.824034F, 2.833333F, 31.166666F, 9.175966F, 31.166666F, 17.0F);
      ((Path)localObject2).cubicTo(31.166666F, 24.824034F, 24.824034F, 31.166666F, 17.0F, 31.166666F);
      ((Path)localObject2).cubicTo(9.175966F, 31.166666F, 2.833333F, 24.824034F, 2.833333F, 17.0F);
      ((Path)localObject2).cubicTo(2.833333F, 9.175966F, 9.175966F, 2.833333F, 17.0F, 2.833333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.0F, 4.533333F);
      ((Path)localObject2).cubicTo(10.11485F, 4.533333F, 4.533333F, 10.11485F, 4.533333F, 17.0F);
      ((Path)localObject2).cubicTo(4.533333F, 23.885149F, 10.11485F, 29.466667F, 17.0F, 29.466667F);
      ((Path)localObject2).cubicTo(23.885149F, 29.466667F, 29.466667F, 23.885149F, 29.466667F, 17.0F);
      ((Path)localObject2).cubicTo(29.466667F, 10.11485F, 23.885149F, 4.533333F, 17.0F, 4.533333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(23.568733F, 12.395833F);
      ((Path)localObject2).lineTo(24.770815F, 13.597915F);
      ((Path)localObject2).lineTo(16.342007F, 22.026724F);
      ((Path)localObject2).cubicTo(15.788764F, 22.579967F, 14.89178F, 22.579967F, 14.338537F, 22.026724F);
      ((Path)localObject2).lineTo(9.916667F, 17.604853F);
      ((Path)localObject2).lineTo(11.118749F, 16.402771F);
      ((Path)localObject2).lineTo(15.340272F, 20.624296F);
      ((Path)localObject2).lineTo(23.568733F, 12.395833F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.c2c_remittance_received_icon
 * JD-Core Version:    0.7.0.1
 */