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

public class icons_filled_pay_safe
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
      ((Path)localObject).moveTo(36.0F, 7.5F);
      ((Path)localObject).lineTo(60.0F, 16.5F);
      ((Path)localObject).lineTo(60.000721F, 27.148378F);
      ((Path)localObject).cubicTo(51.397877F, 30.727888F, 34.205029F, 37.891659F, 34.205029F, 37.891659F);
      ((Path)localObject).cubicTo(33.900082F, 37.996475F, 33.571373F, 38.055946F, 33.228405F, 38.055946F);
      ((Path)localObject).cubicTo(32.651779F, 38.055946F, 32.113964F, 37.89389F, 31.666443F, 37.618839F);
      ((Path)localObject).lineTo(31.666443F, 37.618839F);
      ((Path)localObject).lineTo(25.523943F, 33.514637F);
      ((Path)localObject).cubicTo(25.363945F, 33.403133F, 25.168303F, 33.336971F, 24.95286F, 33.336971F);
      ((Path)localObject).cubicTo(24.426926F, 33.336971F, 24.0F, 33.736908F, 24.0F, 34.230515F);
      ((Path)localObject).cubicTo(24.0F, 34.359119F, 24.034851F, 34.49144F, 24.091087F, 34.60815F);
      ((Path)localObject).lineTo(24.091087F, 34.60815F);
      ((Path)localObject).lineTo(29.297363F, 45.329178F);
      ((Path)localObject).lineTo(29.421717F, 45.5849F);
      ((Path)localObject).cubicTo(29.748051F, 46.130539F, 30.369825F, 46.5F, 31.085064F, 46.5F);
      ((Path)localObject).cubicTo(31.393179F, 46.5F, 31.683868F, 46.428635F, 31.942083F, 46.307465F);
      ((Path)localObject).lineTo(31.942083F, 46.307465F);
      ((Path)localObject).lineTo(32.151192F, 46.193726F);
      ((Path)localObject).cubicTo(32.151192F, 46.193726F, 48.522564F, 37.331581F, 60.001244F, 31.117949F);
      ((Path)localObject).lineTo(60.0F, 33.761368F);
      ((Path)localObject).cubicTo(60.0F, 48.30043F, 50.104965F, 60.973759F, 36.0F, 64.5F);
      ((Path)localObject).cubicTo(21.895035F, 60.973759F, 12.0F, 48.30043F, 12.0F, 33.761368F);
      ((Path)localObject).lineTo(12.0F, 16.5F);
      ((Path)localObject).lineTo(36.0F, 7.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_pay_safe
 * JD-Core Version:    0.7.0.1
 */