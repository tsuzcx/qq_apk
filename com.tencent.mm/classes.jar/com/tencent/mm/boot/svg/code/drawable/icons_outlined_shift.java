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

public class icons_outlined_shift
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
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(18.0F, 6.0F);
      ((Path)localObject).lineTo(18.0F, 7.2003F);
      ((Path)localObject).lineTo(8.192F, 7.2F);
      ((Path)localObject).lineTo(17.924242F, 16.93516F);
      ((Path)localObject).lineTo(17.075714F, 17.783899F);
      ((Path)localObject).lineTo(7.198F, 7.903F);
      ((Path)localObject).lineTo(7.2F, 18.0F);
      ((Path)localObject).lineTo(6.0F, 18.0F);
      ((Path)localObject).lineTo(6.0F, 6.595082F);
      ((Path)localObject).lineTo(6.003F, 6.563F);
      ((Path)localObject).lineTo(6.007971F, 6.502802F);
      ((Path)localObject).lineTo(6.031519F, 6.40699F);
      ((Path)localObject).cubicTo(6.041712F, 6.37743F, 6.054218F, 6.348901F, 6.068802F, 6.321608F);
      ((Path)localObject).lineTo(6.093588F, 6.279548F);
      ((Path)localObject).cubicTo(6.200504F, 6.111543F, 6.387682F, 6.0F, 6.595082F, 6.0F);
      ((Path)localObject).lineTo(18.0F, 6.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_shift
 * JD-Core Version:    0.7.0.1
 */