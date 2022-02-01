package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class panel_icon_fav
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
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
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-13421773);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 48.0F, 0.0F, 1.0F, 48.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(81.37307F, 25.26795F);
      ((Path)localObject2).lineTo(48.0F, 44.5359F);
      ((Path)localObject2).lineTo(14.626933F, 25.26795F);
      ((Path)localObject2).lineTo(45.398735F, 7.501841F);
      ((Path)localObject2).cubicTo(46.835373F, 6.672397F, 49.169003F, 6.674923F, 50.601265F, 7.501841F);
      ((Path)localObject2).lineTo(81.37307F, 25.26795F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(84.37307F, 30.464102F);
      ((Path)localObject2).lineTo(84.37307F, 65.996315F);
      ((Path)localObject2).cubicTo(84.37307F, 67.655205F, 83.204063F, 69.674927F, 81.771805F, 70.501839F);
      ((Path)localObject2).lineTo(51.0F, 88.267952F);
      ((Path)localObject2).lineTo(51.0F, 49.732052F);
      ((Path)localObject2).lineTo(84.37307F, 30.464102F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.0F, 88.267952F);
      ((Path)localObject2).lineTo(14.228197F, 70.501839F);
      ((Path)localObject2).cubicTo(12.791558F, 69.672394F, 11.626933F, 67.650154F, 11.626933F, 65.996315F);
      ((Path)localObject2).lineTo(11.626933F, 30.464102F);
      ((Path)localObject2).lineTo(45.0F, 49.732052F);
      ((Path)localObject2).lineTo(45.0F, 88.267952F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.panel_icon_fav
 * JD-Core Version:    0.7.0.1
 */