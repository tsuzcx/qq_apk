package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class room_live_icon
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      Object localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localObject = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.5F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 2.75F);
      localPath.cubicTo(17.108635F, 2.75F, 21.25F, 6.891366F, 21.25F, 12.0F);
      localPath.cubicTo(21.25F, 17.108635F, 17.108635F, 21.25F, 12.0F, 21.25F);
      localPath.cubicTo(6.891366F, 21.25F, 2.75F, 17.108635F, 2.75F, 12.0F);
      localPath.cubicTo(2.75F, 6.891366F, 6.891366F, 2.75F, 12.0F, 2.75F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-16777216);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(0.8333333F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 6.5F);
      ((Path)localObject).cubicTo(15.037566F, 6.5F, 17.5F, 8.962434F, 17.5F, 12.0F);
      ((Path)localObject).cubicTo(17.5F, 15.037566F, 15.037566F, 17.5F, 12.0F, 17.5F);
      ((Path)localObject).cubicTo(8.962434F, 17.5F, 6.5F, 15.037566F, 6.5F, 12.0F);
      ((Path)localObject).cubicTo(6.5F, 8.962434F, 8.962434F, 6.5F, 12.0F, 6.5F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.room_live_icon
 * JD-Core Version:    0.7.0.1
 */