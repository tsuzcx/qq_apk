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

public class wecoin_product_list_icons
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
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
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.5F, 0.8660254F, 0.7303667F, -0.8660254F, 0.5F, 13.685536F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.801277F, 0.0F, 1.0F, 0.787784F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-7746194);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(6.798704F, 0.001597881F);
      localPath.cubicTo(10.554192F, 0.001597881F, 13.598616F, 2.475855F, 13.598616F, 5.528005F);
      localPath.cubicTo(13.598616F, 8.580155F, 10.554192F, 11.054413F, 6.798704F, 11.054413F);
      localPath.cubicTo(3.043217F, 11.054413F, -0.001206875F, 8.580155F, -0.001206875F, 5.528005F);
      localPath.cubicTo(-0.001206875F, 2.475855F, 3.043217F, 0.001597881F, 6.798704F, 0.001597881F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-2130706433);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9510565F, -0.309017F, 1.428801F, 0.309017F, 0.9510565F, -2.972626F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.098612F, 2.024236F);
      ((Path)localObject).cubicTo(10.834071F, 2.024236F, 11.430279F, 2.471952F, 11.430279F, 3.024236F);
      ((Path)localObject).cubicTo(11.430279F, 3.576521F, 10.834071F, 4.024237F, 10.098612F, 4.024237F);
      ((Path)localObject).cubicTo(9.363153F, 4.024237F, 8.766945F, 3.576521F, 8.766945F, 3.024236F);
      ((Path)localObject).cubicTo(8.766945F, 2.471952F, 9.363153F, 2.024236F, 10.098612F, 2.024236F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wecoin_product_list_icons
 * JD-Core Version:    0.7.0.1
 */