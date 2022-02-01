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

public class appbrand_menu_header_record_screen
  extends c
{
  private final int height = 9;
  private final int width = 13;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 13;
      return 9;
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
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -286.0F, 0.0F, 1.0F, -424.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 279.0F, 0.0F, 1.0F, 417.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 4.7F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 1.166667F, 0.0F, 1.0F, 2.916667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.5833333F, 0.2916667F);
      ((Path)localObject2).lineTo(8.166667F, 0.2916667F);
      ((Path)localObject2).cubicTo(8.488833F, 0.2916667F, 8.75F, 0.5528339F, 8.75F, 0.875F);
      ((Path)localObject2).lineTo(8.75F, 7.291667F);
      ((Path)localObject2).cubicTo(8.75F, 7.613833F, 8.488833F, 7.875F, 8.166667F, 7.875F);
      ((Path)localObject2).lineTo(0.5833333F, 7.875F);
      ((Path)localObject2).cubicTo(0.2611672F, 7.875F, -2.936129E-016F, 7.613833F, 0.0F, 7.291667F);
      ((Path)localObject2).lineTo(0.0F, 0.875F);
      ((Path)localObject2).cubicTo(-3.945397E-017F, 0.5528339F, 0.2611672F, 0.2916667F, 0.5833333F, 0.2916667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.333333F, 2.916667F);
      ((Path)localObject2).lineTo(11.302261F, 1.341524F);
      ((Path)localObject2).cubicTo(11.553831F, 1.140269F, 11.920918F, 1.181056F, 12.122173F, 1.432626F);
      ((Path)localObject2).cubicTo(12.20492F, 1.536058F, 12.25F, 1.664573F, 12.25F, 1.797031F);
      ((Path)localObject2).lineTo(12.25F, 6.369636F);
      ((Path)localObject2).cubicTo(12.25F, 6.691802F, 11.988832F, 6.952969F, 11.666667F, 6.952969F);
      ((Path)localObject2).cubicTo(11.534208F, 6.952969F, 11.405694F, 6.907888F, 11.302261F, 6.825142F);
      ((Path)localObject2).lineTo(9.333333F, 5.25F);
      ((Path)localObject2).lineTo(9.333333F, 2.916667F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_menu_header_record_screen
 * JD-Core Version:    0.7.0.1
 */