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

public class icons_pop_arrow
  extends c
{
  private final int height = 16;
  private final int width = 42;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 16;
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
      localPaint1.setColor(-11776948);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -6.123234E-017F, -1.0F, 25.5F, -1.0F, 6.123234E-017F, 25.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(25.5F, -16.5F);
      ((Path)localObject).cubicTo(25.5F, -10.98989F, 23.996019F, -9.600116F, 22.157511F, -7.884538F);
      ((Path)localObject).lineTo(12.007299F, 1.586997F);
      ((Path)localObject).cubicTo(9.997109F, 3.462779F, 9.998025F, 6.453113F, 12.007299F, 8.32804F);
      ((Path)localObject).lineTo(22.157511F, 17.799574F);
      ((Path)localObject).cubicTo(23.999258F, 19.518175F, 25.5F, 22.850643F, 25.5F, 25.39781F);
      ((Path)localObject).lineTo(31.5F, 25.5F);
      ((Path)localObject).lineTo(31.5F, -16.5F);
      ((Path)localObject).lineTo(25.5F, -16.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_pop_arrow
 * JD-Core Version:    0.7.0.1
 */