package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class collect_sound_on
  extends c
{
  private final int height = 62;
  private final int width = 62;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 62;
      return 62;
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-11776948);
      localPaint.setStrokeWidth(3.0F);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.5F, 51.5F);
      ((Path)localObject).lineTo(12.5F, 50.833168F);
      ((Path)localObject).cubicTo(12.604213F, 50.756973F, 12.713017F, 50.673367F, 12.825878F, 50.581997F);
      ((Path)localObject).cubicTo(13.609306F, 49.947758F, 14.377914F, 49.098545F, 15.08248F, 48.008003F);
      ((Path)localObject).cubicTo(17.25971F, 44.638042F, 18.415026F, 39.67215F, 18.092539F, 32.831554F);
      ((Path)localObject).cubicTo(18.56658F, 22.598658F, 22.709154F, 17.582647F, 28.795002F, 16.286835F);
      ((Path)localObject).lineTo(31.072823F, 15.801835F);
      ((Path)localObject).lineTo(29.689184F, 13.928539F);
      ((Path)localObject).cubicTo(29.419085F, 13.562856F, 29.272728F, 13.127208F, 29.272728F, 12.666667F);
      ((Path)localObject).cubicTo(29.272728F, 11.47552F, 30.26446F, 10.5F, 31.5F, 10.5F);
      ((Path)localObject).cubicTo(32.735542F, 10.5F, 33.727272F, 11.47552F, 33.727272F, 12.666667F);
      ((Path)localObject).cubicTo(33.727272F, 13.127208F, 33.580914F, 13.562856F, 33.310818F, 13.928539F);
      ((Path)localObject).lineTo(31.927177F, 15.801835F);
      ((Path)localObject).lineTo(34.204998F, 16.286835F);
      ((Path)localObject).cubicTo(40.290844F, 17.582647F, 44.433418F, 22.598658F, 44.907459F, 32.831554F);
      ((Path)localObject).cubicTo(44.584972F, 39.67215F, 45.740288F, 44.638042F, 47.917519F, 48.008003F);
      ((Path)localObject).cubicTo(48.622086F, 49.098545F, 49.390694F, 49.947758F, 50.174122F, 50.581997F);
      ((Path)localObject).cubicTo(50.286983F, 50.673367F, 50.395786F, 50.756973F, 50.5F, 50.833168F);
      ((Path)localObject).lineTo(50.5F, 51.5F);
      ((Path)localObject).lineTo(12.5F, 51.5F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.collect_sound_on
 * JD-Core Version:    0.7.0.1
 */