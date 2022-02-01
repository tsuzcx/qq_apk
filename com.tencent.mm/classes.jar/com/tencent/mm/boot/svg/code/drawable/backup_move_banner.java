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

public class backup_move_banner
  extends c
{
  private final int height = 100;
  private final int width = 100;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 100;
      return 100;
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-9473160);
      localPaint1.setStrokeWidth(6.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 59.0F, 0.0F, 1.0F, 38.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 1.973422F);
      ((Path)localObject2).cubicTo(0.0F, 0.8835311F, 0.8835311F, 0.0F, 1.973422F, 0.0F);
      ((Path)localObject2).lineTo(28.026579F, 0.0F);
      ((Path)localObject2).cubicTo(29.11647F, 0.0F, 30.0F, 0.8835311F, 30.0F, 1.973422F);
      ((Path)localObject2).lineTo(30.0F, 46.026577F);
      ((Path)localObject2).cubicTo(30.0F, 47.116467F, 29.11647F, 48.0F, 28.026579F, 48.0F);
      ((Path)localObject2).lineTo(1.973422F, 48.0F);
      ((Path)localObject2).cubicTo(0.8835311F, 48.0F, 0.0F, 47.116467F, 0.0F, 46.026577F);
      ((Path)localObject2).lineTo(0.0F, 1.973422F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(69.0F, 35.0F);
      ((Path)localObject2).lineTo(69.0F, 15.980916F);
      ((Path)localObject2).cubicTo(69.0F, 14.886887F, 68.122162F, 14.0F, 67.023438F, 14.0F);
      ((Path)localObject2).lineTo(24.976563F, 14.0F);
      ((Path)localObject2).cubicTo(23.884937F, 14.0F, 23.0F, 14.88437F, 23.0F, 15.981961F);
      ((Path)localObject2).lineTo(23.0F, 84.018036F);
      ((Path)localObject2).cubicTo(23.0F, 85.112648F, 23.873781F, 86.0F, 24.969942F, 86.0F);
      ((Path)localObject2).lineTo(56.0F, 86.0F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.backup_move_banner
 * JD-Core Version:    0.7.0.1
 */