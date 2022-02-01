package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class connect_mac
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
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(0.8F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.4F, 16.4F);
      localPath.cubicTo(0.4F, 14.190861F, 2.190861F, 12.4F, 4.4F, 12.4F);
      localPath.lineTo(99.599998F, 12.4F);
      localPath.cubicTo(101.80914F, 12.4F, 103.6F, 14.190861F, 103.6F, 16.4F);
      localPath.lineTo(103.6F, 75.599998F);
      localPath.cubicTo(103.6F, 77.809135F, 101.80914F, 79.599998F, 99.599998F, 79.599998F);
      localPath.lineTo(4.4F, 79.599998F);
      localPath.cubicTo(2.190861F, 79.599998F, 0.4F, 77.809135F, 0.4F, 75.599998F);
      localPath.lineTo(0.4F, 16.4F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(0.8F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(60.0F, 79.5F);
      localPath.lineTo(60.677261F, 85.256729F);
      localPath.cubicTo(60.871513F, 86.90786F, 62.066837F, 88.266708F, 63.679722F, 88.66993F);
      localPath.lineTo(68.029854F, 89.757462F);
      localPath.cubicTo(68.600014F, 89.900002F, 69.0F, 90.412292F, 69.0F, 91.0F);
      localPath.cubicTo(69.0F, 91.552284F, 68.552284F, 92.0F, 68.0F, 92.0F);
      localPath.lineTo(36.0F, 92.0F);
      localPath.cubicTo(35.447716F, 92.0F, 35.0F, 91.552284F, 35.0F, 91.0F);
      localPath.cubicTo(35.0F, 90.412292F, 35.399982F, 89.900002F, 35.970142F, 89.757462F);
      localPath.lineTo(40.320278F, 88.66993F);
      localPath.cubicTo(41.933163F, 88.266708F, 43.128487F, 86.90786F, 43.322739F, 85.256729F);
      localPath.lineTo(44.0F, 79.5F);
      localPath.lineTo(44.0F, 79.5F);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(0.8F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 66.5F);
      ((Path)localObject).lineTo(104.0F, 66.5F);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_mac
 * JD-Core Version:    0.7.0.1
 */