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

public class finder_full_comment
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(34.5F, 54.0F);
      ((Path)localObject).lineTo(27.621321F, 60.869999F);
      ((Path)localObject).cubicTo(26.449747F, 62.041573F, 24.550253F, 62.041573F, 23.378679F, 60.869999F);
      ((Path)localObject).cubicTo(22.816071F, 60.307392F, 22.5F, 59.565651F, 22.5F, 58.77F);
      ((Path)localObject).lineTo(22.5F, 54.0F);
      ((Path)localObject).lineTo(15.0F, 54.0F);
      ((Path)localObject).cubicTo(10.857864F, 54.0F, 7.5F, 50.642136F, 7.5F, 46.5F);
      ((Path)localObject).lineTo(7.5F, 21.0F);
      ((Path)localObject).cubicTo(7.5F, 16.857864F, 10.857864F, 13.5F, 15.0F, 13.5F);
      ((Path)localObject).lineTo(57.0F, 13.5F);
      ((Path)localObject).cubicTo(61.142136F, 13.5F, 64.5F, 16.857864F, 64.5F, 21.0F);
      ((Path)localObject).lineTo(64.5F, 46.5F);
      ((Path)localObject).cubicTo(64.5F, 50.642136F, 61.142136F, 54.0F, 57.0F, 54.0F);
      ((Path)localObject).lineTo(34.5F, 54.0F);
      ((Path)localObject).lineTo(34.5F, 54.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_full_comment
 * JD-Core Version:    0.7.0.1
 */