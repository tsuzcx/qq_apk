package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class icon_dot
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 4.0F);
      localPath.cubicTo(16.418278F, 4.0F, 20.0F, 7.581722F, 20.0F, 12.0F);
      localPath.cubicTo(20.0F, 16.418278F, 16.418278F, 20.0F, 12.0F, 20.0F);
      localPath.cubicTo(7.581722F, 20.0F, 4.0F, 16.418278F, 4.0F, 12.0F);
      localPath.cubicTo(4.0F, 7.581722F, 7.581722F, 4.0F, 12.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 4.0F);
      ((Path)localObject).cubicTo(16.418278F, 4.0F, 20.0F, 7.581722F, 20.0F, 12.0F);
      ((Path)localObject).cubicTo(20.0F, 16.418278F, 16.418278F, 20.0F, 12.0F, 20.0F);
      ((Path)localObject).cubicTo(7.581722F, 20.0F, 4.0F, 16.418278F, 4.0F, 12.0F);
      ((Path)localObject).cubicTo(4.0F, 7.581722F, 7.581722F, 4.0F, 12.0F, 4.0F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_dot
 * JD-Core Version:    0.7.0.1
 */