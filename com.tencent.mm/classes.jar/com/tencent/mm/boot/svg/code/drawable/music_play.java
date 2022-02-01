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

public class music_play
  extends c
{
  private final int height = 107;
  private final int width = 107;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 107;
      return 107;
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
      ((Path)localObject).moveTo(29.0F, 22.005177F);
      ((Path)localObject).cubicTo(29.0F, 20.897749F, 29.901951F, 20.0F, 31.00853F, 20.0F);
      ((Path)localObject).lineTo(38.99147F, 20.0F);
      ((Path)localObject).cubicTo(40.10075F, 20.0F, 41.0F, 20.896469F, 41.0F, 22.005177F);
      ((Path)localObject).lineTo(41.0F, 84.99482F);
      ((Path)localObject).cubicTo(41.0F, 86.102249F, 40.098049F, 87.0F, 38.99147F, 87.0F);
      ((Path)localObject).lineTo(31.00853F, 87.0F);
      ((Path)localObject).cubicTo(29.89925F, 87.0F, 29.0F, 86.103531F, 29.0F, 84.99482F);
      ((Path)localObject).lineTo(29.0F, 22.005177F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(66.0F, 22.005177F);
      ((Path)localObject).cubicTo(66.0F, 20.897749F, 66.901947F, 20.0F, 68.00853F, 20.0F);
      ((Path)localObject).lineTo(75.99147F, 20.0F);
      ((Path)localObject).cubicTo(77.100754F, 20.0F, 78.0F, 20.896469F, 78.0F, 22.005177F);
      ((Path)localObject).lineTo(78.0F, 84.99482F);
      ((Path)localObject).cubicTo(78.0F, 86.102249F, 77.098053F, 87.0F, 75.99147F, 87.0F);
      ((Path)localObject).lineTo(68.00853F, 87.0F);
      ((Path)localObject).cubicTo(66.899246F, 87.0F, 66.0F, 86.103531F, 66.0F, 84.99482F);
      ((Path)localObject).lineTo(66.0F, 22.005177F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.music_play
 * JD-Core Version:    0.7.0.1
 */