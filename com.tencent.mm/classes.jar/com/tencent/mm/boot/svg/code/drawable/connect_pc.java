package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class connect_pc
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
      localPath.moveTo(98.718056F, 16.4F);
      localPath.cubicTo(99.050537F, 16.4F, 99.176727F, 16.420479F, 99.299782F, 16.486292F);
      localPath.cubicTo(99.579521F, 16.823275F, 99.599998F, 16.949463F, 99.599998F, 17.281942F);
      localPath.lineTo(99.599998F, 17.281942F);
      localPath.lineTo(99.599998F, 74.718056F);
      localPath.cubicTo(99.599998F, 75.050537F, 99.579521F, 75.176727F, 99.51371F, 75.299782F);
      localPath.cubicTo(99.176727F, 75.579521F, 99.050537F, 75.599998F, 98.718056F, 75.599998F);
      localPath.lineTo(98.718056F, 75.599998F);
      localPath.lineTo(5.281942F, 75.599998F);
      localPath.cubicTo(4.949462F, 75.599998F, 4.823275F, 75.579521F, 4.700217F, 75.51371F);
      localPath.cubicTo(4.420479F, 75.176727F, 4.4F, 75.050537F, 4.4F, 74.718056F);
      localPath.lineTo(4.4F, 74.718056F);
      localPath.lineTo(4.4F, 17.281942F);
      localPath.cubicTo(4.4F, 16.949463F, 4.420479F, 16.823275F, 4.486291F, 16.700216F);
      localPath.cubicTo(4.823275F, 16.420479F, 4.949462F, 16.4F, 5.281942F, 16.4F);
      localPath.lineTo(5.281942F, 16.4F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(0.8F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(57.0F, 80.0F);
      localPath.lineTo(57.0F, 87.595009F);
      localPath.cubicTo(57.0F, 88.108765F, 57.389294F, 88.538933F, 57.900497F, 88.59005F);
      localPath.lineTo(71.099503F, 89.90995F);
      localPath.cubicTo(71.610703F, 89.961067F, 72.0F, 90.391235F, 72.0F, 90.904991F);
      localPath.lineTo(72.0F, 91.0F);
      localPath.cubicTo(72.0F, 91.552284F, 71.552284F, 92.0F, 71.0F, 92.0F);
      localPath.lineTo(33.0F, 92.0F);
      localPath.cubicTo(32.447716F, 92.0F, 32.0F, 91.552284F, 32.0F, 91.0F);
      localPath.lineTo(32.0F, 90.904991F);
      localPath.cubicTo(32.0F, 90.391235F, 32.389294F, 89.961067F, 32.900497F, 89.90995F);
      localPath.lineTo(46.099503F, 88.59005F);
      localPath.cubicTo(46.610706F, 88.538933F, 47.0F, 88.108765F, 47.0F, 87.595009F);
      localPath.lineTo(47.0F, 80.0F);
      localPath.lineTo(47.0F, 80.0F);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(0.8F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(98.872231F, 12.4F);
      ((Path)localObject).cubicTo(100.54198F, 12.4F, 101.15311F, 12.559718F, 101.76505F, 12.886991F);
      ((Path)localObject).cubicTo(102.34617F, 13.197774F, 102.80222F, 13.653834F, 103.11301F, 14.234948F);
      ((Path)localObject).cubicTo(103.44028F, 14.846895F, 103.6F, 15.458012F, 103.6F, 17.127769F);
      ((Path)localObject).lineTo(103.6F, 17.127769F);
      ((Path)localObject).lineTo(103.6F, 74.872231F);
      ((Path)localObject).cubicTo(103.6F, 76.541985F, 103.44028F, 77.153107F, 103.11301F, 77.765053F);
      ((Path)localObject).cubicTo(102.80222F, 78.346169F, 102.34617F, 78.802223F, 101.76505F, 79.113007F);
      ((Path)localObject).cubicTo(101.15311F, 79.440285F, 100.54198F, 79.599998F, 98.872231F, 79.599998F);
      ((Path)localObject).lineTo(98.872231F, 79.599998F);
      ((Path)localObject).lineTo(5.12777F, 79.599998F);
      ((Path)localObject).cubicTo(3.458012F, 79.599998F, 2.846895F, 79.440285F, 2.234948F, 79.113007F);
      ((Path)localObject).cubicTo(1.653835F, 78.802223F, 1.197774F, 78.346169F, 0.8869907F, 77.765053F);
      ((Path)localObject).cubicTo(0.5597178F, 77.153107F, 0.4F, 76.541985F, 0.4F, 74.872231F);
      ((Path)localObject).lineTo(0.4F, 74.872231F);
      ((Path)localObject).lineTo(0.4F, 17.127769F);
      ((Path)localObject).cubicTo(0.4F, 15.458012F, 0.5597178F, 14.846895F, 0.8869907F, 14.234948F);
      ((Path)localObject).cubicTo(1.197774F, 13.653834F, 1.653835F, 13.197774F, 2.234948F, 12.886991F);
      ((Path)localObject).cubicTo(2.846895F, 12.559718F, 3.458012F, 12.4F, 5.12777F, 12.4F);
      ((Path)localObject).lineTo(5.12777F, 12.4F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_pc
 * JD-Core Version:    0.7.0.1
 */