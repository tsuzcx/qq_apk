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

public class icon_video_short_screen
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
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      localPaint = c.instancePaint((Paint)localObject3, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(32.0F, 0.0F);
      ((Path)localObject3).lineTo(32.0F, 32.0F);
      ((Path)localObject3).lineTo(0.0F, 32.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localPaint.setStrokeWidth(1.5F);
      localObject3 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 0.0F, 5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 5.0F);
      localPath.lineTo(0.0F, 1.0F);
      localPath.cubicTo(-6.763538E-017F, 0.4477153F, 0.4477153F, 1.014531E-016F, 1.0F, 0.0F);
      localPath.lineTo(5.0F, 0.0F);
      localPath.lineTo(5.0F, 0.0F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, -1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 16.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.cubicTo(-6.763538E-017F, 11.447716F, 0.4477153F, 11.0F, 1.0F, 11.0F);
      localPath.lineTo(5.0F, 11.0F);
      localPath.lineTo(5.0F, 11.0F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.83697E-016F, 1.0F, 11.0F, -1.0F, 1.83697E-016F, 16.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(11.0F, 5.0F);
      localPath.lineTo(11.0F, 1.0F);
      localPath.cubicTo(11.0F, 0.4477153F, 11.447716F, 1.014531E-016F, 12.0F, 0.0F);
      localPath.lineTo(16.0F, 0.0F);
      localPath.lineTo(16.0F, 0.0F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.setMatrixFloatArray((float[])localObject3, 1.83697E-016F, 1.0F, -1.776357E-015F, 1.0F, -1.83697E-016F, 2.47991E-015F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(11.0F, 16.0F);
      ((Path)localObject1).lineTo(11.0F, 12.0F);
      ((Path)localObject1).cubicTo(11.0F, 11.447716F, 11.447716F, 11.0F, 12.0F, 11.0F);
      ((Path)localObject1).lineTo(16.0F, 11.0F);
      ((Path)localObject1).lineTo(16.0F, 11.0F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_video_short_screen
 * JD-Core Version:    0.7.0.1
 */