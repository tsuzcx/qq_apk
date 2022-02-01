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

public class fix_tools_failed
  extends c
{
  private final int height = 100;
  private final int width = 100;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 100;
      return 100;
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
      localPaint.setColor(-1686720);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(51.515152F, 100.0F);
      ((Path)localObject).cubicTo(22.385763F, 100.0F, 0.0F, 77.614235F, 0.0F, 51.515152F);
      ((Path)localObject).cubicTo(0.0F, 22.385763F, 22.385763F, 0.0F, 51.515152F, 0.0F);
      ((Path)localObject).cubicTo(77.614235F, 0.0F, 100.0F, 22.385763F, 100.0F, 51.515152F);
      ((Path)localObject).cubicTo(100.0F, 77.614235F, 77.614235F, 100.0F, 51.515152F, 100.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.567917F, 25.108103F);
      ((Path)localObject).lineTo(47.272728F, 60.909092F);
      ((Path)localObject).lineTo(54.545456F, 60.909092F);
      ((Path)localObject).lineTo(56.250263F, 25.108103F);
      ((Path)localObject).cubicTo(56.309967F, 23.85433F, 55.341984F, 22.789549F, 54.088211F, 22.729845F);
      ((Path)localObject).cubicTo(54.052204F, 22.72813F, 54.016159F, 22.727272F, 53.98011F, 22.727272F);
      ((Path)localObject).lineTo(47.838074F, 22.727272F);
      ((Path)localObject).cubicTo(46.582882F, 22.727272F, 45.565346F, 23.744808F, 45.565346F, 25.0F);
      ((Path)localObject).cubicTo(45.565346F, 25.036049F, 45.566204F, 25.072094F, 45.567917F, 25.108103F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(50.909092F, 76.818184F);
      ((Path)localObject).cubicTo(53.921555F, 76.818184F, 56.363636F, 74.376099F, 56.363636F, 71.36364F);
      ((Path)localObject).cubicTo(56.363636F, 68.351173F, 53.921555F, 65.909088F, 50.909092F, 65.909088F);
      ((Path)localObject).cubicTo(47.896629F, 65.909088F, 45.454544F, 68.351173F, 45.454544F, 71.36364F);
      ((Path)localObject).cubicTo(45.454544F, 74.376099F, 47.896629F, 76.818184F, 50.909092F, 76.818184F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fix_tools_failed
 * JD-Core Version:    0.7.0.1
 */