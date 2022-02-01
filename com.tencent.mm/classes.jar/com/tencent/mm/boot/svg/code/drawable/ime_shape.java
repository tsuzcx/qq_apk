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

public class ime_shape
  extends c
{
  private final int height = 23;
  private final int width = 36;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 36;
      return 23;
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
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-13158600);
      localPaint1.setStrokeWidth(2.0F);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -677.0F, 0.0F, 1.0F, -992.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 678.0F, 0.0F, 1.0F, 993.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(33.263493F, 4.492106F);
      ((Path)localObject2).lineTo(18.719851F, 20.230263F);
      ((Path)localObject2).lineTo(18.719851F, 20.230263F);
      ((Path)localObject2).cubicTo(18.285301F, 20.719563F, 17.65889F, 21.0F, 17.000622F, 21.0F);
      ((Path)localObject2).cubicTo(16.342447F, 21.0F, 15.716186F, 20.719736F, 15.281392F, 20.230263F);
      ((Path)localObject2).lineTo(0.7377481F, 4.492106F);
      ((Path)localObject2).cubicTo(0.02771829F, 3.75F, -0.1916729F, 2.668421F, 0.1753088F, 1.713158F);
      ((Path)localObject2).cubicTo(0.5422905F, 0.7578948F, 1.427833F, 0.09078948F, 2.456977F, 0.0F);
      ((Path)localObject2).lineTo(31.532297F, 0.0F);
      ((Path)localObject2).cubicTo(32.56543F, 0.08684211F, 33.454964F, 0.75F, 33.821945F, 1.709211F);
      ((Path)localObject2).cubicTo(34.192917F, 2.668421F, 33.973522F, 3.746053F, 33.263493F, 4.492106F);
      ((Path)localObject2).lineTo(33.263493F, 4.492106F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_shape
 * JD-Core Version:    0.7.0.1
 */