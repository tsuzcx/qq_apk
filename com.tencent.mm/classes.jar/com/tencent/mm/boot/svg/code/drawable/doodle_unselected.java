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

public class doodle_unselected
  extends c
{
  private final int height = 63;
  private final int width = 63;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 63;
      return 63;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1.setColor(-1);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 31.394091F, 0.7071068F, 0.7071068F, -12.125177F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(25.405478F, 12.614841F);
      ((Path)localObject).lineTo(25.645857F, 54.121506F);
      ((Path)localObject).lineTo(30.480642F, 63.385418F);
      ((Path)localObject).lineTo(35.31543F, 54.121506F);
      ((Path)localObject).lineTo(35.214981F, 12.614841F);
      ((Path)localObject).lineTo(25.405478F, 12.614841F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(25.389639F, 9.879872F);
      ((Path)localObject).lineTo(25.351372F, 3.272119F);
      ((Path)localObject).cubicTo(25.341805F, 1.620414F, 26.683146F, 0.2814423F, 28.343227F, 0.2814423F);
      ((Path)localObject).lineTo(32.175957F, 0.2814423F);
      ((Path)localObject).cubicTo(33.837879F, 0.2814423F, 35.188385F, 1.62576F, 35.192371F, 3.272119F);
      ((Path)localObject).lineTo(35.208363F, 9.879872F);
      ((Path)localObject).lineTo(25.389639F, 9.879872F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.doodle_unselected
 * JD-Core Version:    0.7.0.1
 */