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

public class bottomsheet_icon_allow_comment
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.666667F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.889937F, 20.357117F);
      ((Path)localObject2).lineTo(9.476319F, 20.526922F);
      ((Path)localObject2).cubicTo(10.704722F, 20.882647F, 12.002946F, 21.066668F, 13.333333F, 21.066668F);
      ((Path)localObject2).cubicTo(19.865908F, 21.066668F, 25.066668F, 16.646021F, 25.066668F, 11.333333F);
      ((Path)localObject2).cubicTo(25.066668F, 6.020646F, 19.865908F, 1.6F, 13.333333F, 1.6F);
      ((Path)localObject2).cubicTo(6.80076F, 1.6F, 1.6F, 6.020646F, 1.6F, 11.333333F);
      ((Path)localObject2).cubicTo(1.6F, 14.101232F, 3.009241F, 16.701462F, 5.46746F, 18.548485F);
      ((Path)localObject2).lineTo(6.20168F, 19.100151F);
      ((Path)localObject2).lineTo(5.888258F, 21.796453F);
      ((Path)localObject2).lineTo(8.889937F, 20.357117F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.333333F, 22.666666F);
      ((Path)localObject2).cubicTo(11.828022F, 22.666666F, 10.380974F, 22.454632F, 9.031272F, 22.063782F);
      ((Path)localObject2).lineTo(5.054001F, 23.970924F);
      ((Path)localObject2).cubicTo(4.94047F, 24.025364F, 4.813844F, 24.046539F, 4.688777F, 24.032001F);
      ((Path)localObject2).cubicTo(4.32305F, 23.989489F, 4.061033F, 23.658546F, 4.103545F, 23.292818F);
      ((Path)localObject2).lineTo(4.506342F, 19.827644F);
      ((Path)localObject2).cubicTo(1.742664F, 17.75111F, 0.0F, 14.715206F, 0.0F, 11.333333F);
      ((Path)localObject2).cubicTo(0.0F, 5.074106F, 5.969537F, 0.0F, 13.333333F, 0.0F);
      ((Path)localObject2).cubicTo(20.69713F, 0.0F, 26.666666F, 5.074106F, 26.666666F, 11.333333F);
      ((Path)localObject2).cubicTo(26.666666F, 17.59256F, 20.69713F, 22.666666F, 13.333333F, 22.666666F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_icon_allow_comment
 * JD-Core Version:    0.7.0.1
 */