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

public class icon_filled_video_call_off
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 24.0F, 0.0F, -1.0F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(2.575379F, 2.454058F);
      ((Path)localObject).lineTo(19.545942F, 19.424622F);
      ((Path)localObject).lineTo(18.485281F, 20.485281F);
      ((Path)localObject).lineTo(1.514719F, 3.514719F);
      ((Path)localObject).lineTo(2.575379F, 2.454058F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(2.053839F, 6.175464F);
      ((Path)localObject).lineTo(14.378F, 18.499058F);
      ((Path)localObject).lineTo(3.0F, 18.5F);
      ((Path)localObject).cubicTo(2.447715F, 18.5F, 2.0F, 18.052284F, 2.0F, 17.5F);
      ((Path)localObject).lineTo(2.0F, 6.5F);
      ((Path)localObject).cubicTo(2.0F, 6.386402F, 2.018942F, 6.277227F, 2.053839F, 6.175464F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.780869F, 7.45593F);
      ((Path)localObject).cubicTo(22.92272F, 7.633243F, 23.0F, 7.853553F, 23.0F, 8.080625F);
      ((Path)localObject).lineTo(23.0F, 15.919375F);
      ((Path)localObject).cubicTo(23.0F, 16.471661F, 22.552284F, 16.919374F, 22.0F, 16.919374F);
      ((Path)localObject).cubicTo(21.772928F, 16.919374F, 21.552618F, 16.842094F, 21.375305F, 16.700245F);
      ((Path)localObject).lineTo(18.0F, 14.0F);
      ((Path)localObject).lineTo(18.0F, 10.0F);
      ((Path)localObject).lineTo(21.375305F, 7.299756F);
      ((Path)localObject).cubicTo(21.806566F, 6.954747F, 22.43586F, 7.024668F, 22.780869F, 7.45593F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(5.619F, 5.499058F);
      ((Path)localObject).lineTo(16.0F, 5.5F);
      ((Path)localObject).cubicTo(16.552284F, 5.5F, 17.0F, 5.947715F, 17.0F, 6.5F);
      ((Path)localObject).lineTo(17.0F, 16.879059F);
      ((Path)localObject).lineTo(5.619F, 5.499058F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_video_call_off
 * JD-Core Version:    0.7.0.1
 */