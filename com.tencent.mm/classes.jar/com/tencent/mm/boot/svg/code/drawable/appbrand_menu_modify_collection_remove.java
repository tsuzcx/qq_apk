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

public class appbrand_menu_modify_collection_remove
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(16777215);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(32.0F, 0.0F);
      localPath.lineTo(32.0F, 32.0F);
      localPath.lineTo(0.0F, 32.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-15616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 0.7071068F, 0.7071068F, -9.443495F, -0.7071068F, 0.7071068F, 22.884369F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(21.968798F, 17.508156F);
      ((Path)localObject1).lineTo(23.835464F, 17.508156F);
      ((Path)localObject1).lineTo(23.835464F, 28.174824F);
      ((Path)localObject1).lineTo(21.968798F, 28.174824F);
      ((Path)localObject1).lineTo(21.968798F, 17.508156F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(20.333334F, 25.419897F);
      ((Path)localObject2).lineTo(27.333334F, 25.419897F);
      ((Path)localObject2).lineTo(27.333334F, 27.286564F);
      ((Path)localObject2).lineTo(20.333334F, 27.286564F);
      ((Path)localObject2).lineTo(20.333334F, 25.419897F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.466667F, 20.286564F);
      ((Path)localObject2).lineTo(27.333334F, 20.286564F);
      ((Path)localObject2).lineTo(27.333334F, 27.286564F);
      ((Path)localObject2).lineTo(25.466667F, 27.286564F);
      ((Path)localObject2).lineTo(25.466667F, 20.286564F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(17.333334F, 9.666666F);
      ((Path)localObject2).cubicTo(17.333334F, 6.905242F, 19.571911F, 4.666667F, 22.333334F, 4.666667F);
      ((Path)localObject2).lineTo(22.333334F, 4.666667F);
      ((Path)localObject2).cubicTo(25.094757F, 4.666667F, 27.333334F, 6.905242F, 27.333334F, 9.666666F);
      ((Path)localObject2).lineTo(27.333334F, 9.666666F);
      ((Path)localObject2).cubicTo(27.333334F, 12.42809F, 25.094757F, 14.666666F, 22.333334F, 14.666666F);
      ((Path)localObject2).lineTo(22.333334F, 14.666666F);
      ((Path)localObject2).cubicTo(19.571911F, 14.666666F, 17.333334F, 12.42809F, 17.333334F, 9.666666F);
      ((Path)localObject2).lineTo(17.333334F, 9.666666F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(4.666667F, 9.666666F);
      ((Path)localObject2).cubicTo(4.666667F, 6.905242F, 6.905242F, 4.666667F, 9.666666F, 4.666667F);
      ((Path)localObject2).lineTo(9.666666F, 4.666667F);
      ((Path)localObject2).cubicTo(12.42809F, 4.666667F, 14.666666F, 6.905242F, 14.666666F, 9.666666F);
      ((Path)localObject2).lineTo(14.666666F, 9.666666F);
      ((Path)localObject2).cubicTo(14.666666F, 12.42809F, 12.42809F, 14.666666F, 9.666666F, 14.666666F);
      ((Path)localObject2).lineTo(9.666666F, 14.666666F);
      ((Path)localObject2).cubicTo(6.905242F, 14.666666F, 4.666667F, 12.42809F, 4.666667F, 9.666666F);
      ((Path)localObject2).lineTo(4.666667F, 9.666666F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-15616);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(4.666667F, 22.333334F);
      ((Path)localObject1).cubicTo(4.666667F, 19.571911F, 6.905242F, 17.333334F, 9.666666F, 17.333334F);
      ((Path)localObject1).lineTo(9.666666F, 17.333334F);
      ((Path)localObject1).cubicTo(12.42809F, 17.333334F, 14.666666F, 19.571911F, 14.666666F, 22.333334F);
      ((Path)localObject1).lineTo(14.666666F, 22.333334F);
      ((Path)localObject1).cubicTo(14.666666F, 25.094757F, 12.42809F, 27.333334F, 9.666666F, 27.333334F);
      ((Path)localObject1).lineTo(9.666666F, 27.333334F);
      ((Path)localObject1).cubicTo(6.905242F, 27.333334F, 4.666667F, 25.094757F, 4.666667F, 22.333334F);
      ((Path)localObject1).lineTo(4.666667F, 22.333334F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_menu_modify_collection_remove
 * JD-Core Version:    0.7.0.1
 */