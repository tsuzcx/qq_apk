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

public class icons_outlined_quote_location
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint1.setColor(-16777216);
      localPaint1.setStrokeWidth(5.0625F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 10.6875F, 0.0F, 1.0F, 3.9375F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.3125F, 2.53125F);
      ((Path)localObject2).cubicTo(31.605444F, 2.53125F, 37.303436F, 5.062496F, 41.427666F, 9.157434F);
      ((Path)localObject2).cubicTo(45.545345F, 13.245865F, 48.09375F, 18.893545F, 48.09375F, 25.132717F);
      ((Path)localObject2).cubicTo(48.09375F, 43.167248F, 26.024639F, 61.312508F, 26.024639F, 61.312508F);
      ((Path)localObject2).cubicTo(25.772068F, 61.539612F, 25.541258F, 61.596313F, 25.320568F, 61.596809F);
      ((Path)localObject2).cubicTo(25.09186F, 61.597321F, 24.853292F, 61.537315F, 24.675802F, 61.378483F);
      ((Path)localObject2).cubicTo(24.611698F, 61.323021F, 2.53125F, 43.167595F, 2.53125F, 25.132717F);
      ((Path)localObject2).cubicTo(2.53125F, 18.893545F, 5.079656F, 13.245865F, 9.197333F, 9.157434F);
      ((Path)localObject2).cubicTo(13.321564F, 5.062496F, 19.019556F, 2.53125F, 25.3125F, 2.53125F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.3125F, 16.03125F);
      ((Path)localObject2).cubicTo(30.438393F, 16.03125F, 34.59375F, 20.186607F, 34.59375F, 25.3125F);
      ((Path)localObject2).cubicTo(34.59375F, 30.438393F, 30.438393F, 34.59375F, 25.3125F, 34.59375F);
      ((Path)localObject2).cubicTo(20.186607F, 34.59375F, 16.03125F, 30.438393F, 16.03125F, 25.3125F);
      ((Path)localObject2).cubicTo(16.03125F, 20.186607F, 20.186607F, 16.03125F, 25.3125F, 16.03125F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_quote_location
 * JD-Core Version:    0.7.0.1
 */