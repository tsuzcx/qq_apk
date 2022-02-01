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

public class icons_outlined_mike
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.8660254F, -0.5F, 30.430782F, 0.5F, 0.8660254F, -17.569218F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(68.0F, 82.641014F);
      ((Path)localObject).cubicTo(48.868294F, 93.686714F, 24.404678F, 87.131706F, 13.358984F, 68.0F);
      ((Path)localObject).cubicTo(2.313289F, 48.868294F, 8.868295F, 24.404678F, 28.0F, 13.358984F);
      ((Path)localObject).cubicTo(47.131706F, 2.313289F, 71.595322F, 8.868295F, 82.641014F, 28.0F);
      ((Path)localObject).cubicTo(93.686714F, 47.131706F, 87.131706F, 71.595322F, 68.0F, 82.641014F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(65.599998F, 78.484093F);
      ((Path)localObject).cubicTo(82.435898F, 68.763885F, 88.204308F, 47.235901F, 78.484093F, 30.4F);
      ((Path)localObject).cubicTo(68.763885F, 13.564099F, 47.235901F, 7.795694F, 30.4F, 17.515905F);
      ((Path)localObject).cubicTo(13.564099F, 27.236118F, 7.795694F, 48.764099F, 17.515905F, 65.599998F);
      ((Path)localObject).cubicTo(27.236118F, 82.435898F, 48.764099F, 88.204308F, 65.599998F, 78.484093F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 30.799999F);
      ((Path)localObject).cubicTo(45.12812F, 30.799999F, 42.799999F, 33.12812F, 42.799999F, 36.0F);
      ((Path)localObject).lineTo(42.799999F, 50.0F);
      ((Path)localObject).cubicTo(42.799999F, 52.87188F, 45.12812F, 55.200001F, 48.0F, 55.200001F);
      ((Path)localObject).cubicTo(50.87188F, 55.200001F, 53.200001F, 52.87188F, 53.200001F, 50.0F);
      ((Path)localObject).lineTo(53.200001F, 36.0F);
      ((Path)localObject).cubicTo(53.200001F, 33.12812F, 50.87188F, 30.799999F, 48.0F, 30.799999F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(50.400097F, 67.841354F);
      ((Path)localObject).lineTo(50.400097F, 74.0F);
      ((Path)localObject).lineTo(45.600098F, 74.0F);
      ((Path)localObject).lineTo(45.600098F, 67.841362F);
      ((Path)localObject).cubicTo(36.793587F, 66.667694F, 30.0F, 59.124485F, 30.0F, 49.990005F);
      ((Path)localObject).lineTo(30.0F, 44.0F);
      ((Path)localObject).lineTo(34.799999F, 44.0F);
      ((Path)localObject).lineTo(34.799999F, 49.990005F);
      ((Path)localObject).cubicTo(34.799999F, 57.287613F, 40.709599F, 63.200001F, 48.0F, 63.200001F);
      ((Path)localObject).cubicTo(55.290901F, 63.200001F, 61.200001F, 57.287125F, 61.200001F, 49.990005F);
      ((Path)localObject).lineTo(61.200001F, 44.0F);
      ((Path)localObject).lineTo(66.0F, 44.0F);
      ((Path)localObject).lineTo(66.0F, 49.990005F);
      ((Path)localObject).cubicTo(66.0F, 59.122581F, 59.208122F, 66.667519F, 50.400097F, 67.841354F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 26.0F);
      ((Path)localObject).cubicTo(53.522846F, 26.0F, 58.0F, 30.477152F, 58.0F, 36.0F);
      ((Path)localObject).lineTo(58.0F, 50.0F);
      ((Path)localObject).cubicTo(58.0F, 55.522846F, 53.522846F, 60.0F, 48.0F, 60.0F);
      ((Path)localObject).cubicTo(42.477154F, 60.0F, 38.0F, 55.522846F, 38.0F, 50.0F);
      ((Path)localObject).lineTo(38.0F, 36.0F);
      ((Path)localObject).cubicTo(38.0F, 30.477152F, 42.477154F, 26.0F, 48.0F, 26.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_mike
 * JD-Core Version:    0.7.0.1
 */