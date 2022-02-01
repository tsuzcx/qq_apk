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

public class finder_live_move_icon
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      Object localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint1.setColor(-1);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint1, paramVarArgs);
      Paint localPaint2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.5F, 1.0F);
      localPath.cubicTo(0.5F, 0.7238576F, 0.7238576F, 0.5F, 1.0F, 0.5F);
      localPath.lineTo(19.0F, 0.5F);
      localPath.cubicTo(19.276142F, 0.5F, 19.5F, 0.7238576F, 19.5F, 1.0F);
      localPath.lineTo(19.5F, 1.0F);
      localPath.cubicTo(19.5F, 1.276142F, 19.276142F, 1.5F, 19.0F, 1.5F);
      localPath.lineTo(1.0F, 1.5F);
      localPath.cubicTo(0.7238576F, 1.5F, 0.5F, 1.276142F, 0.5F, 1.0F);
      localPath.lineTo(0.5F, 1.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.5F, 1.0F);
      localPath.cubicTo(0.5F, 0.7238576F, 0.7238576F, 0.5F, 1.0F, 0.5F);
      localPath.lineTo(19.0F, 0.5F);
      localPath.cubicTo(19.276142F, 0.5F, 19.5F, 0.7238576F, 19.5F, 1.0F);
      localPath.lineTo(19.5F, 1.0F);
      localPath.cubicTo(19.5F, 1.276142F, 19.276142F, 1.5F, 19.0F, 1.5F);
      localPath.lineTo(1.0F, 1.5F);
      localPath.cubicTo(0.7238576F, 1.5F, 0.5F, 1.276142F, 0.5F, 1.0F);
      localPath.lineTo(0.5F, 1.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.5F, 1.0F);
      ((Path)localObject2).cubicTo(0.5F, 0.7238576F, 0.7238576F, 0.5F, 1.0F, 0.5F);
      ((Path)localObject2).lineTo(19.0F, 0.5F);
      ((Path)localObject2).cubicTo(19.276142F, 0.5F, 19.5F, 0.7238576F, 19.5F, 1.0F);
      ((Path)localObject2).lineTo(19.5F, 1.0F);
      ((Path)localObject2).cubicTo(19.5F, 1.276142F, 19.276142F, 1.5F, 19.0F, 1.5F);
      ((Path)localObject2).lineTo(1.0F, 1.5F);
      ((Path)localObject2).cubicTo(0.7238576F, 1.5F, 0.5F, 1.276142F, 0.5F, 1.0F);
      ((Path)localObject2).lineTo(0.5F, 1.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject2, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_move_icon
 * JD-Core Version:    0.7.0.1
 */