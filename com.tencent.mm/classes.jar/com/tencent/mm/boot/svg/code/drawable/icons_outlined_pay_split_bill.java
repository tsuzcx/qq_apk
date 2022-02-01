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

public class icons_outlined_pay_split_bill
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(39.0F, 0.0F);
      ((Path)localObject2).cubicTo(40.656853F, 0.0F, 42.0F, 1.343146F, 42.0F, 3.0F);
      ((Path)localObject2).lineTo(42.0F, 51.0F);
      ((Path)localObject2).cubicTo(42.0F, 52.656853F, 40.656853F, 54.0F, 39.0F, 54.0F);
      ((Path)localObject2).lineTo(3.0F, 54.0F);
      ((Path)localObject2).cubicTo(1.343146F, 54.0F, 0.0F, 52.656853F, 0.0F, 51.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(0.0F, 1.343146F, 1.343146F, 0.0F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(39.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(38.400002F, 3.6F);
      ((Path)localObject2).lineTo(3.6F, 3.6F);
      ((Path)localObject2).lineTo(3.6F, 50.400002F);
      ((Path)localObject2).lineTo(38.400002F, 50.400002F);
      ((Path)localObject2).lineTo(38.398998F, 29.511F);
      ((Path)localObject2).lineTo(24.674976F, 44.051704F);
      ((Path)localObject2).cubicTo(24.643566F, 44.084984F, 24.61142F, 44.117554F, 24.578566F, 44.149391F);
      ((Path)localObject2).lineTo(24.4779F, 44.242691F);
      ((Path)localObject2).cubicTo(23.20458F, 45.371109F, 21.257587F, 45.253651F, 20.129166F, 43.980331F);
      ((Path)localObject2).lineTo(20.129166F, 43.980331F);
      ((Path)localObject2).lineTo(12.0F, 34.807331F);
      ((Path)localObject2).lineTo(13.727176F, 33.110573F);
      ((Path)localObject2).lineTo(22.363054F, 40.081188F);
      ((Path)localObject2).lineTo(38.398998F, 25.681999F);
      ((Path)localObject2).lineTo(38.400002F, 3.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.5F, 18.0F);
      ((Path)localObject2).lineTo(25.5F, 21.6F);
      ((Path)localObject2).lineTo(7.5F, 21.6F);
      ((Path)localObject2).lineTo(7.5F, 18.0F);
      ((Path)localObject2).lineTo(25.5F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.5F, 9.0F);
      ((Path)localObject2).lineTo(25.5F, 12.6F);
      ((Path)localObject2).lineTo(7.5F, 12.6F);
      ((Path)localObject2).lineTo(7.5F, 9.0F);
      ((Path)localObject2).lineTo(25.5F, 9.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_pay_split_bill
 * JD-Core Version:    0.7.0.1
 */