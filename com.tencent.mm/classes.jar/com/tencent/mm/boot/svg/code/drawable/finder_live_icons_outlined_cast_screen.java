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

public class finder_live_icons_outlined_cast_screen
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.666667F, 0.0F, 1.0F, 3.333333F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.159342F, 15.43251F);
      ((Path)localObject2).lineTo(20.507324F, 23.367489F);
      ((Path)localObject2).cubicTo(20.963516F, 23.937729F, 20.725653F, 24.4F, 19.996702F, 24.4F);
      ((Path)localObject2).lineTo(6.669964F, 24.4F);
      ((Path)localObject2).cubicTo(5.931764F, 24.4F, 5.70846F, 23.931091F, 6.159342F, 23.367489F);
      ((Path)localObject2).lineTo(12.507324F, 15.43251F);
      ((Path)localObject2).cubicTo(12.963516F, 14.86227F, 13.70846F, 14.868907F, 14.159342F, 15.43251F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.333334F, 0.6666667F);
      ((Path)localObject2).cubicTo(26.069714F, 0.6666667F, 26.666666F, 1.26362F, 26.666666F, 2.0F);
      ((Path)localObject2).lineTo(26.666666F, 19.333334F);
      ((Path)localObject2).cubicTo(26.666666F, 20.069714F, 26.069714F, 20.666666F, 25.333334F, 20.666666F);
      ((Path)localObject2).lineTo(21.333F, 20.666666F);
      ((Path)localObject2).lineTo(21.333F, 18.666666F);
      ((Path)localObject2).lineTo(24.5F, 18.666666F);
      ((Path)localObject2).cubicTo(24.776142F, 18.666666F, 25.0F, 18.442808F, 25.0F, 18.166666F);
      ((Path)localObject2).lineTo(25.0F, 3.166667F);
      ((Path)localObject2).cubicTo(25.0F, 2.890524F, 24.776142F, 2.666667F, 24.5F, 2.666667F);
      ((Path)localObject2).lineTo(2.5F, 2.666667F);
      ((Path)localObject2).cubicTo(2.223858F, 2.666667F, 2.0F, 2.890524F, 2.0F, 3.166667F);
      ((Path)localObject2).lineTo(2.0F, 18.166666F);
      ((Path)localObject2).cubicTo(2.0F, 18.442808F, 2.223858F, 18.666666F, 2.5F, 18.666666F);
      ((Path)localObject2).lineTo(5.333F, 18.666666F);
      ((Path)localObject2).lineTo(5.333F, 20.666666F);
      ((Path)localObject2).lineTo(1.333333F, 20.666666F);
      ((Path)localObject2).cubicTo(0.5969537F, 20.666666F, 0.0F, 20.069714F, 0.0F, 19.333334F);
      ((Path)localObject2).lineTo(0.0F, 2.0F);
      ((Path)localObject2).cubicTo(0.0F, 1.26362F, 0.5969537F, 0.6666667F, 1.333333F, 0.6666667F);
      ((Path)localObject2).lineTo(25.333334F, 0.6666667F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_icons_outlined_cast_screen
 * JD-Core Version:    0.7.0.1
 */