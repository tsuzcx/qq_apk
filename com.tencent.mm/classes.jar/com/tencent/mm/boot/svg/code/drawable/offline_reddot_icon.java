package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class offline_reddot_icon
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-564640);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 3.0F);
      localPath.cubicTo(16.970562F, 3.0F, 21.0F, 7.029437F, 21.0F, 12.0F);
      localPath.cubicTo(21.0F, 16.970562F, 16.970562F, 21.0F, 12.0F, 21.0F);
      localPath.cubicTo(7.029437F, 21.0F, 3.0F, 16.970562F, 3.0F, 12.0F);
      localPath.cubicTo(3.0F, 7.029437F, 7.029437F, 3.0F, 12.0F, 3.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localPaint.setStrokeWidth(3.0F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 1.5F);
      ((Path)localObject).cubicTo(17.79899F, 1.5F, 22.5F, 6.20101F, 22.5F, 12.0F);
      ((Path)localObject).cubicTo(22.5F, 17.79899F, 17.79899F, 22.5F, 12.0F, 22.5F);
      ((Path)localObject).cubicTo(6.20101F, 22.5F, 1.5F, 17.79899F, 1.5F, 12.0F);
      ((Path)localObject).cubicTo(1.5F, 6.20101F, 6.20101F, 1.5F, 12.0F, 1.5F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.offline_reddot_icon
 * JD-Core Version:    0.7.0.1
 */