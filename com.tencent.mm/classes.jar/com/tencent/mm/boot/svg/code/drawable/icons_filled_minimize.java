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

public class icons_filled_minimize
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.933949F, 12.944684F);
      ((Path)localObject).cubicTo(10.417315F, 12.944684F, 10.809162F, 13.336531F, 10.809162F, 13.819898F);
      ((Path)localObject).lineTo(10.809162F, 18.195967F);
      ((Path)localObject).lineTo(9.058735F, 18.195967F);
      ((Path)localObject).lineTo(9.058735F, 15.932349F);
      ((Path)localObject).lineTo(5.237739F, 19.752249F);
      ((Path)localObject).lineTo(4.0F, 18.514509F);
      ((Path)localObject).lineTo(7.819398F, 14.695111F);
      ((Path)localObject).lineTo(5.55788F, 14.695111F);
      ((Path)localObject).lineTo(5.55788F, 12.944684F);
      ((Path)localObject).lineTo(9.933949F, 12.944684F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.516108F, 4.0F);
      ((Path)localObject).lineTo(19.753847F, 5.237739F);
      ((Path)localObject).lineTo(15.934448F, 9.057138F);
      ((Path)localObject).lineTo(18.195967F, 9.057138F);
      ((Path)localObject).lineTo(18.195967F, 10.807565F);
      ((Path)localObject).lineTo(13.819898F, 10.807565F);
      ((Path)localObject).cubicTo(13.336531F, 10.807565F, 12.944684F, 10.415718F, 12.944684F, 9.932351F);
      ((Path)localObject).lineTo(12.944684F, 5.556283F);
      ((Path)localObject).lineTo(14.695111F, 5.556283F);
      ((Path)localObject).lineTo(14.695111F, 7.8199F);
      ((Path)localObject).lineTo(18.516108F, 4.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_minimize
 * JD-Core Version:    0.7.0.1
 */