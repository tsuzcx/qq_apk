package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class tips_background_dark
  extends c
{
  private final int height = 101;
  private final int width = 200;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 200;
      return 101;
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
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-13882324);
      localPaint2.setColor(268435455);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.5F, 8.5F);
      localPath.cubicTo(0.5F, 4.081722F, 4.081722F, 0.5F, 8.5F, 0.5F);
      localPath.lineTo(191.5F, 0.5F);
      localPath.cubicTo(195.91827F, 0.5F, 199.5F, 4.081722F, 199.5F, 8.5F);
      localPath.lineTo(199.5F, 92.5F);
      localPath.cubicTo(199.5F, 96.918282F, 195.91827F, 100.5F, 191.5F, 100.5F);
      localPath.lineTo(8.5F, 100.5F);
      localPath.cubicTo(4.081722F, 100.5F, 0.5F, 96.918282F, 0.5F, 92.5F);
      localPath.lineTo(0.5F, 8.5F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.tips_background_dark
 * JD-Core Version:    0.7.0.1
 */