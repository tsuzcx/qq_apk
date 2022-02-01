package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_filled_crop
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
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(18.0F, 60.0F);
      ((Path)localObject).lineTo(8.997152F, 60.0F);
      ((Path)localObject).cubicTo(7.341871F, 60.0F, 6.0F, 58.666107F, 6.0F, 56.997383F);
      ((Path)localObject).lineTo(6.0F, 15.002615F);
      ((Path)localObject).cubicTo(6.0F, 13.344316F, 7.341623F, 12.0F, 8.997152F, 12.0F);
      ((Path)localObject).lineTo(12.0F, 12.0F);
      ((Path)localObject).lineTo(60.0F, 12.0F);
      ((Path)localObject).lineTo(63.00285F, 12.0F);
      ((Path)localObject).cubicTo(64.658127F, 12.0F, 66.0F, 13.333893F, 66.0F, 15.002615F);
      ((Path)localObject).lineTo(66.0F, 56.997383F);
      ((Path)localObject).cubicTo(66.0F, 58.655682F, 64.658379F, 60.0F, 63.00285F, 60.0F);
      ((Path)localObject).lineTo(54.0F, 60.0F);
      ((Path)localObject).lineTo(18.0F, 60.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.0F, 57.0F);
      ((Path)localObject).lineTo(54.0F, 57.0F);
      ((Path)localObject).lineTo(54.0F, 15.0F);
      ((Path)localObject).lineTo(18.0F, 15.0F);
      ((Path)localObject).lineTo(18.0F, 57.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.0F, 33.333332F);
      ((Path)localObject).lineTo(10.0F, 40.444443F);
      ((Path)localObject).lineTo(14.0F, 40.444443F);
      ((Path)localObject).lineTo(14.0F, 33.333332F);
      ((Path)localObject).lineTo(10.0F, 33.333332F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(58.0F, 33.333332F);
      ((Path)localObject).lineTo(58.0F, 40.444443F);
      ((Path)localObject).lineTo(62.0F, 40.444443F);
      ((Path)localObject).lineTo(62.0F, 33.333332F);
      ((Path)localObject).lineTo(58.0F, 33.333332F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_crop
 * JD-Core Version:    0.7.0.1
 */