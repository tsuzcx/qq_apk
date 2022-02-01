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

public class smiley_recent_dot
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-2697514);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 0.0F);
      ((Path)localObject).cubicTo(5.371652F, 0.0F, 0.0F, 5.371652F, 0.0F, 12.0F);
      ((Path)localObject).cubicTo(0.0F, 18.628347F, 5.371652F, 24.0F, 12.0F, 24.0F);
      ((Path)localObject).cubicTo(18.628347F, 24.0F, 24.0F, 18.628347F, 24.0F, 12.0F);
      ((Path)localObject).cubicTo(24.0F, 5.371652F, 18.628347F, 0.0F, 12.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.148247F, 12.97082F);
      ((Path)localObject).lineTo(18.916821F, 15.12273F);
      ((Path)localObject).lineTo(18.506933F, 16.406258F);
      ((Path)localObject).lineTo(10.797303F, 13.955056F);
      ((Path)localObject).lineTo(10.797303F, 3.155124F);
      ((Path)localObject).lineTo(12.145618F, 3.155124F);
      ((Path)localObject).lineTo(12.145618F, 12.97082F);
      ((Path)localObject).lineTo(12.148247F, 12.97082F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.smiley_recent_dot
 * JD-Core Version:    0.7.0.1
 */