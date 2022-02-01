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

public class c2c_remittance_cancle_icon
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Matrix localMatrix = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -2.0F, 0.0F, 1.0F, -2.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(17.0F, 2.833333F);
      ((Path)localObject2).cubicTo(24.824034F, 2.833333F, 31.166666F, 9.175966F, 31.166666F, 17.0F);
      ((Path)localObject2).cubicTo(31.166666F, 24.824034F, 24.824034F, 31.166666F, 17.0F, 31.166666F);
      ((Path)localObject2).cubicTo(9.175966F, 31.166666F, 2.833333F, 24.824034F, 2.833333F, 17.0F);
      ((Path)localObject2).cubicTo(2.833333F, 9.175966F, 9.175966F, 2.833333F, 17.0F, 2.833333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.0F, 4.533333F);
      ((Path)localObject2).cubicTo(10.11485F, 4.533333F, 4.533333F, 10.11485F, 4.533333F, 17.0F);
      ((Path)localObject2).cubicTo(4.533333F, 23.885149F, 10.11485F, 29.466667F, 17.0F, 29.466667F);
      ((Path)localObject2).cubicTo(23.885149F, 29.466667F, 29.466667F, 23.885149F, 29.466667F, 17.0F);
      ((Path)localObject2).cubicTo(29.466667F, 10.11485F, 23.885149F, 4.533333F, 17.0F, 4.533333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.923605F, 11.05F);
      ((Path)localObject2).lineTo(15.125687F, 12.252082F);
      ((Path)localObject2).lineTo(13.210333F, 14.166333F);
      ((Path)localObject2).lineTo(19.833334F, 14.166667F);
      ((Path)localObject2).cubicTo(22.180544F, 14.166667F, 24.083334F, 16.069456F, 24.083334F, 18.416666F);
      ((Path)localObject2).cubicTo(24.083334F, 20.763876F, 22.180544F, 22.666666F, 19.833334F, 22.666666F);
      ((Path)localObject2).lineTo(17.0F, 22.666668F);
      ((Path)localObject2).lineTo(17.0F, 20.966667F);
      ((Path)localObject2).lineTo(19.833334F, 20.966667F);
      ((Path)localObject2).cubicTo(21.241659F, 20.966667F, 22.383333F, 19.824993F, 22.383333F, 18.416666F);
      ((Path)localObject2).cubicTo(22.383333F, 17.008341F, 21.241659F, 15.866667F, 19.833334F, 15.866667F);
      ((Path)localObject2).lineTo(13.130333F, 15.866333F);
      ((Path)localObject2).lineTo(15.125687F, 17.861795F);
      ((Path)localObject2).lineTo(13.923605F, 19.063877F);
      ((Path)localObject2).lineTo(10.417534F, 15.557806F);
      ((Path)localObject2).cubicTo(10.140913F, 15.281184F, 10.140913F, 14.832693F, 10.417534F, 14.556071F);
      ((Path)localObject2).lineTo(13.923605F, 11.05F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 9.916667F, 0.0F, 1.0F, 9.916667F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject1);
      localCanvas.concat(localMatrix);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.c2c_remittance_cancle_icon
 * JD-Core Version:    0.7.0.1
 */