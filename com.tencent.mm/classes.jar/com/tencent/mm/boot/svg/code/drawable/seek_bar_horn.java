package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class seek_bar_horn
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      ((Path)localObject).lineTo(72.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localPaint.setStrokeWidth(3.6F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(50.391575F, 17.210928F);
      ((Path)localObject).lineTo(37.490154F, 24.799999F);
      ((Path)localObject).lineTo(21.0F, 24.799999F);
      ((Path)localObject).cubicTo(20.337257F, 24.799999F, 19.799999F, 25.337257F, 19.799999F, 26.0F);
      ((Path)localObject).lineTo(19.799999F, 46.0F);
      ((Path)localObject).cubicTo(19.799999F, 46.662743F, 20.337257F, 47.200001F, 21.0F, 47.200001F);
      ((Path)localObject).lineTo(37.490154F, 47.200001F);
      ((Path)localObject).lineTo(50.391575F, 54.78907F);
      ((Path)localObject).cubicTo(50.575989F, 54.897549F, 50.786049F, 54.95475F, 51.0F, 54.95475F);
      ((Path)localObject).cubicTo(51.662743F, 54.95475F, 52.200001F, 54.417492F, 52.200001F, 53.754749F);
      ((Path)localObject).lineTo(52.200001F, 18.245251F);
      ((Path)localObject).cubicTo(52.200001F, 18.031298F, 52.142799F, 17.821238F, 52.034321F, 17.636826F);
      ((Path)localObject).cubicTo(51.698299F, 17.065586F, 50.962814F, 16.874905F, 50.391575F, 17.210928F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.seek_bar_horn
 * JD-Core Version:    0.7.0.1
 */