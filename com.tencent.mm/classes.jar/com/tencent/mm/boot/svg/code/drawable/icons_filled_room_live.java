package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class icons_filled_room_live
  extends c
{
  private final int height = 12;
  private final int width = 12;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 12;
      return 12;
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
      localPath.lineTo(11.776F, 0.0F);
      localPath.lineTo(11.776F, 11.776F);
      localPath.lineTo(0.0F, 11.776F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.104F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(5.888F, 1.533333F);
      localPath.cubicTo(8.293016F, 1.533333F, 10.242666F, 3.482984F, 10.242666F, 5.888F);
      localPath.cubicTo(10.242666F, 8.293016F, 8.293016F, 10.242666F, 5.888F, 10.242666F);
      localPath.cubicTo(3.482984F, 10.242666F, 1.533333F, 8.293016F, 1.533333F, 5.888F);
      localPath.cubicTo(1.533333F, 3.482984F, 3.482984F, 1.533333F, 5.888F, 1.533333F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(5.888F, 3.189333F);
      ((Path)localObject).cubicTo(7.378432F, 3.189333F, 8.586666F, 4.397568F, 8.586666F, 5.888F);
      ((Path)localObject).cubicTo(8.586666F, 7.378432F, 7.378432F, 8.586666F, 5.888F, 8.586666F);
      ((Path)localObject).cubicTo(4.397568F, 8.586666F, 3.189333F, 7.378432F, 3.189333F, 5.888F);
      ((Path)localObject).cubicTo(3.189333F, 4.397568F, 4.397568F, 3.189333F, 5.888F, 3.189333F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_room_live
 * JD-Core Version:    0.7.0.1
 */