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

public class app_brand_actionbar_capsule_home_light
  extends c
{
  private final int height = 96;
  private final int width = 132;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 132;
      return 96;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -659.0F, 0.0F, 1.0F, -950.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 532.0F, 0.0F, 1.0F, 950.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 170.0F, 0.0F, 1.0F, 22.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(26.0F, 52.0F);
      ((Path)localObject2).cubicTo(11.640596F, 52.0F, 0.0F, 40.359402F, 0.0F, 26.0F);
      ((Path)localObject2).cubicTo(0.0F, 11.640596F, 11.640596F, 0.0F, 26.0F, 0.0F);
      ((Path)localObject2).cubicTo(40.359402F, 0.0F, 52.0F, 11.640596F, 52.0F, 26.0F);
      ((Path)localObject2).cubicTo(52.0F, 40.359402F, 40.359402F, 52.0F, 26.0F, 52.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(26.0F, 45.882355F);
      ((Path)localObject2).cubicTo(36.980721F, 45.882355F, 45.882355F, 36.980721F, 45.882355F, 26.0F);
      ((Path)localObject2).cubicTo(45.882355F, 15.019279F, 36.980721F, 6.117647F, 26.0F, 6.117647F);
      ((Path)localObject2).cubicTo(15.019279F, 6.117647F, 6.117647F, 15.019279F, 6.117647F, 26.0F);
      ((Path)localObject2).cubicTo(6.117647F, 36.980721F, 15.019279F, 45.882355F, 26.0F, 45.882355F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(35.0F, 26.0F);
      ((Path)localObject2).cubicTo(35.0F, 30.969801F, 30.969801F, 35.0F, 26.0F, 35.0F);
      ((Path)localObject2).cubicTo(21.030199F, 35.0F, 17.0F, 30.969801F, 17.0F, 26.0F);
      ((Path)localObject2).cubicTo(17.0F, 21.0284F, 21.030199F, 17.0F, 26.0F, 17.0F);
      ((Path)localObject2).cubicTo(30.969801F, 17.0F, 35.0F, 21.0284F, 35.0F, 26.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_actionbar_capsule_home_light
 * JD-Core Version:    0.7.0.1
 */