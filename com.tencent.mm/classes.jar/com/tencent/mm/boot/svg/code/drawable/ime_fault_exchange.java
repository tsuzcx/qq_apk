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

public class ime_fault_exchange
  extends c
{
  private final int height = 36;
  private final int width = 28;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 28;
      return 36;
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
      localPaint1.setStrokeCap(Paint.Cap.SQUARE);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-372399);
      localPaint1.setStrokeWidth(2.0F);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -56.0F, 0.0F, 1.0F, -920.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(58.0F, 922.0F);
      ((Path)localObject2).cubicTo(65.434441F, 921.52246F, 69.434441F, 921.52246F, 70.0F, 922.0F);
      ((Path)localObject2).cubicTo(70.848335F, 922.71631F, 71.123665F, 924.1167F, 71.123665F, 925.36835F);
      ((Path)localObject2).cubicTo(71.123665F, 926.62006F, 70.92569F, 931.40289F, 69.216858F, 938.0318F);
      ((Path)localObject2).cubicTo(67.508018F, 944.66071F, 66.717987F, 950.07886F, 66.717987F, 951.16852F);
      ((Path)localObject2).cubicTo(66.717987F, 952.25812F, 67.000488F, 953.34113F, 68.000244F, 954.0F);
      ((Path)localObject2).cubicTo(68.666748F, 954.43927F, 73.333336F, 954.43927F, 82.0F, 954.0F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_fault_exchange
 * JD-Core Version:    0.7.0.1
 */