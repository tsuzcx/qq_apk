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

public class ic_filled_loading_fail
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      ((Paint)localObject2).setColor(-855638017);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -167.0F, 0.0F, 1.0F, -370.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 128.0F, 0.0F, 1.0F, 346.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 39.0F, 0.0F, 1.0F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(20.0F, 16.036478F);
      ((Path)localObject2).lineTo(37.1022F, 0.1344352F);
      ((Path)localObject2).cubicTo(37.298431F, -0.04802718F, 37.612587F, -0.04086595F, 37.798798F, 0.1453454F);
      ((Path)localObject2).lineTo(39.854656F, 2.201203F);
      ((Path)localObject2).cubicTo(40.043144F, 2.389691F, 40.049908F, 2.699546F, 39.865566F, 2.897802F);
      ((Path)localObject2).lineTo(23.963522F, 20.0F);
      ((Path)localObject2).lineTo(39.865566F, 37.1022F);
      ((Path)localObject2).cubicTo(40.048027F, 37.298431F, 40.040867F, 37.612587F, 39.854656F, 37.798798F);
      ((Path)localObject2).lineTo(37.798798F, 39.854656F);
      ((Path)localObject2).cubicTo(37.61031F, 40.043144F, 37.300453F, 40.049908F, 37.1022F, 39.865566F);
      ((Path)localObject2).lineTo(20.0F, 23.963522F);
      ((Path)localObject2).lineTo(2.897802F, 39.865566F);
      ((Path)localObject2).cubicTo(2.701569F, 40.048027F, 2.387415F, 40.040867F, 2.201203F, 39.854656F);
      ((Path)localObject2).lineTo(0.1453454F, 37.798798F);
      ((Path)localObject2).cubicTo(-0.0431425F, 37.61031F, -0.0499082F, 37.300453F, 0.1344352F, 37.1022F);
      ((Path)localObject2).lineTo(16.036478F, 20.0F);
      ((Path)localObject2).lineTo(0.1344352F, 2.897802F);
      ((Path)localObject2).cubicTo(-0.04802718F, 2.701569F, -0.04086595F, 2.387415F, 0.1453454F, 2.201203F);
      ((Path)localObject2).lineTo(2.201203F, 0.1453454F);
      ((Path)localObject2).cubicTo(2.389691F, -0.0431425F, 2.699546F, -0.0499082F, 2.897802F, 0.1344352F);
      ((Path)localObject2).lineTo(20.0F, 16.036478F);
      ((Path)localObject2).lineTo(20.0F, 16.036478F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ic_filled_loading_fail
 * JD-Core Version:    0.7.0.1
 */