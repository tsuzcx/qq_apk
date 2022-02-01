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

public class icons_outlined_android_pad
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 6.123234E-017F, 1.0F, 0.0F, -1.0F, 6.123234E-017F, 72.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(57.0F, 6.0F);
      ((Path)localObject).cubicTo(58.656853F, 6.0F, 60.0F, 7.343146F, 60.0F, 9.0F);
      ((Path)localObject).lineTo(60.0F, 63.0F);
      ((Path)localObject).cubicTo(60.0F, 64.656853F, 58.656853F, 66.0F, 57.0F, 66.0F);
      ((Path)localObject).lineTo(15.0F, 66.0F);
      ((Path)localObject).cubicTo(13.343145F, 66.0F, 12.0F, 64.656853F, 12.0F, 63.0F);
      ((Path)localObject).lineTo(12.0F, 9.0F);
      ((Path)localObject).cubicTo(12.0F, 7.343146F, 13.343145F, 6.0F, 15.0F, 6.0F);
      ((Path)localObject).lineTo(57.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(56.400002F, 9.6F);
      ((Path)localObject).lineTo(15.6F, 9.6F);
      ((Path)localObject).lineTo(15.6F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 9.6F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 18.0F);
      ((Path)localObject).cubicTo(37.656853F, 18.0F, 39.0F, 19.343145F, 39.0F, 21.0F);
      ((Path)localObject).cubicTo(39.0F, 22.656855F, 37.656853F, 24.0F, 36.0F, 24.0F);
      ((Path)localObject).cubicTo(34.343147F, 24.0F, 33.0F, 22.656855F, 33.0F, 21.0F);
      ((Path)localObject).cubicTo(33.0F, 19.343145F, 34.343147F, 18.0F, 36.0F, 18.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_android_pad
 * JD-Core Version:    0.7.0.1
 */