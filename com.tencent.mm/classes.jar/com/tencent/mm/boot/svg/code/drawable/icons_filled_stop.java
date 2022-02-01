package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class icons_filled_stop
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-372399);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(16.0F, 0.0F);
      localPath.cubicTo(24.836555F, 0.0F, 32.0F, 7.163444F, 32.0F, 16.0F);
      localPath.cubicTo(32.0F, 24.836555F, 24.836555F, 32.0F, 16.0F, 32.0F);
      localPath.cubicTo(7.163444F, 32.0F, 0.0F, 24.836555F, 0.0F, 16.0F);
      localPath.cubicTo(0.0F, 7.163444F, 7.163444F, 0.0F, 16.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(10.0F, 11.0F);
      ((Path)localObject).cubicTo(10.0F, 10.447715F, 10.447715F, 10.0F, 11.0F, 10.0F);
      ((Path)localObject).lineTo(21.0F, 10.0F);
      ((Path)localObject).cubicTo(21.552284F, 10.0F, 22.0F, 10.447715F, 22.0F, 11.0F);
      ((Path)localObject).lineTo(22.0F, 21.0F);
      ((Path)localObject).cubicTo(22.0F, 21.552284F, 21.552284F, 22.0F, 21.0F, 22.0F);
      ((Path)localObject).lineTo(11.0F, 22.0F);
      ((Path)localObject).cubicTo(10.447715F, 22.0F, 10.0F, 21.552284F, 10.0F, 21.0F);
      ((Path)localObject).lineTo(10.0F, 11.0F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_stop
 * JD-Core Version:    0.7.0.1
 */