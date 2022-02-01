package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class finder_live_icon
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
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(24.0F, 0.0F);
      localPath.lineTo(24.0F, 24.0F);
      localPath.lineTo(0.0F, 24.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-40634);
      ((Paint)localObject).setStrokeWidth(1.5F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 2.75F);
      localPath.cubicTo(17.108635F, 2.75F, 21.25F, 6.891366F, 21.25F, 12.0F);
      localPath.cubicTo(21.25F, 17.108635F, 17.108635F, 21.25F, 12.0F, 21.25F);
      localPath.cubicTo(6.891366F, 21.25F, 2.75F, 17.108635F, 2.75F, 12.0F);
      localPath.cubicTo(2.75F, 6.891366F, 6.891366F, 2.75F, 12.0F, 2.75F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-40634);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 6.5F);
      ((Path)localObject).cubicTo(15.037566F, 6.5F, 17.5F, 8.962434F, 17.5F, 12.0F);
      ((Path)localObject).cubicTo(17.5F, 15.037566F, 15.037566F, 17.5F, 12.0F, 17.5F);
      ((Path)localObject).cubicTo(8.962434F, 17.5F, 6.5F, 15.037566F, 6.5F, 12.0F);
      ((Path)localObject).cubicTo(6.5F, 8.962434F, 8.962434F, 6.5F, 12.0F, 6.5F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_icon
 * JD-Core Version:    0.7.0.1
 */