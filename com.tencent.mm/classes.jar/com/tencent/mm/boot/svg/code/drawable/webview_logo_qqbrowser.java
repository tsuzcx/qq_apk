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

public class webview_logo_qqbrowser
  extends c
{
  private final int height = 39;
  private final int width = 39;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 39;
      return 39;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint((Paint)localObject, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(15.911817F, 28.210007F);
      ((Path)localObject).cubicTo(12.592391F, 26.960802F, 10.230769F, 23.756193F, 10.230769F, 20.0F);
      ((Path)localObject).cubicTo(10.230769F, 15.156888F, 14.156888F, 11.230769F, 19.0F, 11.230769F);
      ((Path)localObject).cubicTo(23.843113F, 11.230769F, 27.76923F, 15.156888F, 27.76923F, 20.0F);
      ((Path)localObject).cubicTo(27.76923F, 20.19488F, 27.762875F, 20.388273F, 27.750357F, 20.579987F);
      ((Path)localObject).cubicTo(30.774906F, 21.110861F, 33.20298F, 23.374031F, 33.973866F, 26.308788F);
      ((Path)localObject).cubicTo(34.541199F, 26.484497F, 35.077324F, 26.731188F, 35.571869F, 27.038485F);
      ((Path)localObject).cubicTo(36.491306F, 24.876438F, 37.0F, 22.497625F, 37.0F, 20.0F);
      ((Path)localObject).cubicTo(37.0F, 10.058874F, 28.941126F, 2.0F, 19.0F, 2.0F);
      ((Path)localObject).cubicTo(9.058874F, 2.0F, 1.0F, 10.058874F, 1.0F, 20.0F);
      ((Path)localObject).cubicTo(1.0F, 29.941126F, 9.058874F, 38.0F, 19.0F, 38.0F);
      ((Path)localObject).cubicTo(19.099163F, 38.0F, 19.198141F, 37.999199F, 19.296925F, 37.997601F);
      ((Path)localObject).cubicTo(19.351601F, 37.999195F, 19.406475F, 38.0F, 19.461538F, 38.0F);
      ((Path)localObject).lineTo(32.384617F, 38.0F);
      ((Path)localObject).lineTo(32.384617F, 37.979301F);
      ((Path)localObject).cubicTo(34.972229F, 37.74612F, 37.0F, 35.571404F, 37.0F, 32.923077F);
      ((Path)localObject).cubicTo(37.0F, 30.269276F, 34.96384F, 28.091045F, 32.368565F, 27.865429F);
      ((Path)localObject).cubicTo(32.142185F, 24.75823F, 29.549576F, 22.307692F, 26.384615F, 22.307692F);
      ((Path)localObject).cubicTo(23.496096F, 22.307692F, 21.084314F, 24.348843F, 20.512947F, 27.067463F);
      ((Path)localObject).cubicTo(20.216953F, 26.979319F, 19.868599F, 26.929428F, 19.461538F, 26.923077F);
      ((Path)localObject).cubicTo(18.110815F, 26.923077F, 16.873026F, 27.406603F, 15.911817F, 28.210007F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.webview_logo_qqbrowser
 * JD-Core Version:    0.7.0.1
 */