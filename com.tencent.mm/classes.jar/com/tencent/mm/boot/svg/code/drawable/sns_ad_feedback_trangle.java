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

public class sns_ad_feedback_trangle
  extends c
{
  private final int height = 6;
  private final int width = 15;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 15;
      return 6;
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
      localPaint1.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.83697E-016F, -1.0F, 12.71027F, 1.0F, -1.83697E-016F, -2.416488F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(8.416489F, -3.853109F);
      ((Path)localObject).lineTo(8.416489F, -1.480681F);
      ((Path)localObject).cubicTo(8.416489F, -0.9334073F, 8.088407F, -0.199253F, 7.665439F, 0.1752663F);
      ((Path)localObject).lineTo(2.730143F, 4.545249F);
      ((Path)localObject).cubicTo(2.31535F, 4.91253F, 2.316132F, 5.507309F, 2.730143F, 5.872187F);
      ((Path)localObject).lineTo(7.665439F, 10.221771F);
      ((Path)localObject).cubicTo(8.080232F, 10.587337F, 8.416489F, 11.337422F, 8.416489F, 11.880487F);
      ((Path)localObject).lineTo(8.416489F, 14.146891F);
      ((Path)localObject).lineTo(13.147665F, 14.146891F);
      ((Path)localObject).lineTo(13.147665F, -3.853109F);
      ((Path)localObject).lineTo(8.416489F, -3.853109F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sns_ad_feedback_trangle
 * JD-Core Version:    0.7.0.1
 */