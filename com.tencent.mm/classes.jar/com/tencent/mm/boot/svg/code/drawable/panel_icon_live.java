package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class panel_icon_live
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      ((Path)localObject).lineTo(96.0F, 0.0F);
      ((Path)localObject).lineTo(96.0F, 96.0F);
      ((Path)localObject).lineTo(0.0F, 96.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localObject = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(6.0F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(48.0F, 11.0F);
      localPath.cubicTo(68.43454F, 11.0F, 85.0F, 27.565464F, 85.0F, 48.0F);
      localPath.cubicTo(85.0F, 68.43454F, 68.43454F, 85.0F, 48.0F, 85.0F);
      localPath.cubicTo(27.565464F, 85.0F, 11.0F, 68.43454F, 11.0F, 48.0F);
      localPath.cubicTo(11.0F, 27.565464F, 27.565464F, 11.0F, 48.0F, 11.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-16777216);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(3.333333F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(48.0F, 26.0F);
      ((Path)localObject).cubicTo(60.150265F, 26.0F, 70.0F, 35.849735F, 70.0F, 48.0F);
      ((Path)localObject).cubicTo(70.0F, 60.150265F, 60.150265F, 70.0F, 48.0F, 70.0F);
      ((Path)localObject).cubicTo(35.849735F, 70.0F, 26.0F, 60.150265F, 26.0F, 48.0F);
      ((Path)localObject).cubicTo(26.0F, 35.849735F, 35.849735F, 26.0F, 48.0F, 26.0F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.panel_icon_live
 * JD-Core Version:    0.7.0.1
 */