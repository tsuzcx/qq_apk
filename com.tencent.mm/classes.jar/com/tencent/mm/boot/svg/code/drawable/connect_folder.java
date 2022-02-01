package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class connect_folder
  extends c
{
  private final int height = 104;
  private final int width = 104;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 104;
      return 104;
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
      localPaint = c.instancePaint((Paint)localObject, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(104.0F, 0.0F);
      ((Path)localObject).lineTo(104.0F, 104.0F);
      ((Path)localObject).lineTo(0.0F, 104.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.2F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(37.7062F, 17.933332F);
      localPath.lineTo(45.8312F, 24.433332F);
      localPath.lineTo(91.0F, 24.433332F);
      localPath.cubicTo(92.03093F, 24.433332F, 92.964264F, 24.8512F, 93.639862F, 25.526802F);
      localPath.cubicTo(94.315468F, 26.202402F, 94.73333F, 27.135735F, 94.73333F, 28.166666F);
      localPath.lineTo(94.73333F, 28.166666F);
      localPath.lineTo(94.73333F, 82.333336F);
      localPath.cubicTo(94.73333F, 83.364265F, 94.315468F, 84.2976F, 93.639862F, 84.973198F);
      localPath.cubicTo(92.964264F, 85.648796F, 92.03093F, 86.066666F, 91.0F, 86.066666F);
      localPath.lineTo(91.0F, 86.066666F);
      localPath.lineTo(13.0F, 86.066666F);
      localPath.cubicTo(11.969069F, 86.066666F, 11.035735F, 85.648796F, 10.360135F, 84.973198F);
      localPath.cubicTo(9.684534F, 84.2976F, 9.266666F, 83.364265F, 9.266666F, 82.333336F);
      localPath.lineTo(9.266666F, 82.333336F);
      localPath.lineTo(9.266666F, 21.666666F);
      localPath.cubicTo(9.266666F, 20.635735F, 9.684534F, 19.702402F, 10.360135F, 19.026802F);
      localPath.cubicTo(11.035735F, 18.3512F, 11.969069F, 17.933332F, 13.0F, 17.933332F);
      localPath.lineTo(13.0F, 17.933332F);
      localPath.lineTo(37.7062F, 17.933332F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(1.2F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(8.666667F, 41.166668F);
      ((Path)localObject).lineTo(95.333336F, 41.166668F);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_folder
 * JD-Core Version:    0.7.0.1
 */