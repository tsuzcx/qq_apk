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

public class ic_chat_list_empty
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
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
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -156.0F, 0.0F, 1.0F, -435.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 240.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 119.0F, 0.0F, 1.0F, 195.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 37.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(64.0F, 0.0F);
      ((Path)localObject1).lineTo(64.0F, 64.0F);
      ((Path)localObject1).lineTo(0.0F, 64.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(637534208);
      ((Paint)localObject1).setStrokeWidth(2.4F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(32.0F, 11.2F);
      ((Path)localObject2).cubicTo(38.318069F, 11.2F, 44.043499F, 13.403544F, 48.185806F, 16.98427F);
      ((Path)localObject2).cubicTo(52.260181F, 20.506271F, 54.799999F, 25.366123F, 54.799999F, 30.74626F);
      ((Path)localObject2).cubicTo(54.799999F, 36.126396F, 52.260181F, 40.986248F, 48.185806F, 44.508247F);
      ((Path)localObject2).cubicTo(44.043499F, 48.088974F, 38.318069F, 50.292519F, 32.0F, 50.292519F);
      ((Path)localObject2).cubicTo(29.244429F, 50.292519F, 26.602167F, 49.873325F, 24.154348F, 49.103539F);
      ((Path)localObject2).lineTo(24.154348F, 49.103539F);
      ((Path)localObject2).lineTo(16.581964F, 52.796207F);
      ((Path)localObject2).lineTo(17.382318F, 45.743576F);
      ((Path)localObject2).cubicTo(12.401628F, 42.170841F, 9.2F, 36.787598F, 9.2F, 30.74626F);
      ((Path)localObject2).cubicTo(9.2F, 25.366123F, 11.73982F, 20.506271F, 15.814193F, 16.98427F);
      ((Path)localObject2).cubicTo(19.956501F, 13.403544F, 25.681931F, 11.2F, 32.0F, 11.2F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ic_chat_list_empty
 * JD-Core Version:    0.7.0.1
 */