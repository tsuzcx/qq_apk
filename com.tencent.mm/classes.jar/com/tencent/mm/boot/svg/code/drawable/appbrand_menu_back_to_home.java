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

public class appbrand_menu_back_to_home
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
      localPaint.setColor(-15683841);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(37.977329F, 10.986356F);
      ((Path)localObject).lineTo(38.121319F, 11.121321F);
      ((Path)localObject).lineTo(63.878685F, 36.8787F);
      ((Path)localObject).cubicTo(64.441292F, 37.441307F, 64.757362F, 38.204369F, 64.757362F, 39.000019F);
      ((Path)localObject).cubicTo(64.757362F, 40.597698F, 63.508442F, 41.903679F, 61.933636F, 41.994926F);
      ((Path)localObject).lineTo(61.757362F, 42.000019F);
      ((Path)localObject).lineTo(53.999638F, 41.999641F);
      ((Path)localObject).lineTo(54.0F, 60.0F);
      ((Path)localObject).cubicTo(54.0F, 61.597679F, 52.75108F, 62.90366F, 51.176273F, 62.994907F);
      ((Path)localObject).lineTo(51.0F, 63.0F);
      ((Path)localObject).lineTo(40.5F, 63.0F);
      ((Path)localObject).lineTo(40.5F, 51.0F);
      ((Path)localObject).lineTo(31.5F, 51.0F);
      ((Path)localObject).lineTo(31.5F, 63.0F);
      ((Path)localObject).lineTo(21.0F, 63.0F);
      ((Path)localObject).cubicTo(19.402319F, 63.0F, 18.096338F, 61.75108F, 18.005093F, 60.176273F);
      ((Path)localObject).lineTo(18.0F, 60.0F);
      ((Path)localObject).lineTo(17.999638F, 41.999641F);
      ((Path)localObject).lineTo(10.242638F, 42.000019F);
      ((Path)localObject).cubicTo(9.513292F, 42.000019F, 8.811331F, 41.734432F, 8.266049F, 41.256817F);
      ((Path)localObject).lineTo(8.121318F, 41.121338F);
      ((Path)localObject).cubicTo(6.996608F, 39.996632F, 6.951619F, 38.201069F, 7.986352F, 37.02269F);
      ((Path)localObject).lineTo(8.121317F, 36.8787F);
      ((Path)localObject).lineTo(33.878681F, 11.121321F);
      ((Path)localObject).lineTo(34.022671F, 10.986354F);
      ((Path)localObject).cubicTo(35.151951F, 9.994735F, 36.848053F, 9.994735F, 37.977329F, 10.986356F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.appbrand_menu_back_to_home
 * JD-Core Version:    0.7.0.1
 */