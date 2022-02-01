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

public class appbrand_menu_header_record_voice
  extends c
{
  private final int height = 13;
  private final int width = 10;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 10;
      return 13;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -287.0F, 0.0F, 1.0F, -422.0F, 0.0F, 0.0F, 1.0F);
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
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.4375F, 11.06017F);
      ((Path)localObject2).lineTo(7.4375F, 12.833333F);
      ((Path)localObject2).lineTo(6.5625F, 12.833333F);
      ((Path)localObject2).lineTo(6.5625F, 11.06017F);
      ((Path)localObject2).cubicTo(4.513061F, 10.84187F, 2.916667F, 9.107364F, 2.916667F, 7.0F);
      ((Path)localObject2).lineTo(2.916667F, 5.833334F);
      ((Path)localObject2).lineTo(3.791667F, 5.833334F);
      ((Path)localObject2).lineTo(3.791667F, 7.0F);
      ((Path)localObject2).cubicTo(3.791667F, 8.771914F, 5.228087F, 10.208333F, 7.0F, 10.208333F);
      ((Path)localObject2).cubicTo(8.771914F, 10.208333F, 10.208333F, 8.771914F, 10.208333F, 7.0F);
      ((Path)localObject2).lineTo(10.208333F, 5.833334F);
      ((Path)localObject2).lineTo(11.083333F, 5.833334F);
      ((Path)localObject2).lineTo(11.083333F, 7.0F);
      ((Path)localObject2).cubicTo(11.083333F, 9.107364F, 9.486939F, 10.84187F, 7.4375F, 11.06017F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.666667F, 3.5F);
      ((Path)localObject2).cubicTo(4.666667F, 2.211336F, 5.711336F, 1.166667F, 7.0F, 1.166667F);
      ((Path)localObject2).cubicTo(8.288665F, 1.166667F, 9.333333F, 2.211336F, 9.333333F, 3.5F);
      ((Path)localObject2).lineTo(9.333333F, 7.0F);
      ((Path)localObject2).cubicTo(9.333333F, 8.288665F, 8.288665F, 9.333333F, 7.0F, 9.333333F);
      ((Path)localObject2).cubicTo(5.711336F, 9.333333F, 4.666667F, 8.288665F, 4.666667F, 7.0F);
      ((Path)localObject2).lineTo(4.666667F, 3.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_menu_header_record_voice
 * JD-Core Version:    0.7.0.1
 */