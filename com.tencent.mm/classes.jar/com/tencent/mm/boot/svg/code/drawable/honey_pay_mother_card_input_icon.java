package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class honey_pay_mother_card_input_icon
  extends c
{
  private final int height = 120;
  private final int width = 140;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 140;
      return 120;
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
      localPaint1 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.ROUND);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-25290);
      localPaint1.setStrokeWidth(2.0F);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 42.220886F);
      ((Path)localObject2).cubicTo(37.257179F, 26.622805F, 49.257179F, 25.956137F, 60.0F, 40.220886F);
      ((Path)localObject2).cubicTo(70.742821F, 54.485634F, 82.742821F, 55.152298F, 96.0F, 42.220886F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 62.220886F);
      ((Path)localObject2).cubicTo(37.257179F, 46.622803F, 49.257179F, 45.956139F, 60.0F, 60.220886F);
      ((Path)localObject2).cubicTo(70.742821F, 74.485634F, 82.742821F, 75.152298F, 96.0F, 62.220886F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(24.0F, 82.220886F);
      ((Path)localObject1).cubicTo(37.257179F, 66.622803F, 49.257179F, 65.956139F, 60.0F, 80.220886F);
      ((Path)localObject1).cubicTo(70.742821F, 94.485634F, 82.742821F, 95.152298F, 96.0F, 82.220886F);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.honey_pay_mother_card_input_icon
 * JD-Core Version:    0.7.0.1
 */