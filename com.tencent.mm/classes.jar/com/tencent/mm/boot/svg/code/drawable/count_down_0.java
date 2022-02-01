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

public class count_down_0
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      localPaint.setColor(-1);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(39.576F, 13.0F);
      ((Path)localObject).cubicTo(45.624001F, 13.0F, 50.304001F, 15.52F, 53.616001F, 20.632F);
      ((Path)localObject).cubicTo(56.639999F, 25.384001F, 58.152F, 31.719999F, 58.152F, 39.712002F);
      ((Path)localObject).cubicTo(58.152F, 47.632F, 56.639999F, 54.040001F, 53.616001F, 58.792F);
      ((Path)localObject).cubicTo(50.304001F, 63.832001F, 45.624001F, 66.424004F, 39.576F, 66.424004F);
      ((Path)localObject).cubicTo(33.528F, 66.424004F, 28.848F, 63.832001F, 25.535999F, 58.792F);
      ((Path)localObject).cubicTo(22.511999F, 54.040001F, 21.0F, 47.703999F, 21.0F, 39.712002F);
      ((Path)localObject).cubicTo(21.0F, 31.648001F, 22.511999F, 25.312F, 25.535999F, 20.632F);
      ((Path)localObject).cubicTo(28.848F, 15.52F, 33.528F, 13.0F, 39.576F, 13.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.576F, 19.624001F);
      ((Path)localObject).cubicTo(35.327999F, 19.624001F, 32.375999F, 21.927999F, 30.648001F, 26.608F);
      ((Path)localObject).cubicTo(29.351999F, 29.775999F, 28.775999F, 34.167999F, 28.775999F, 39.712002F);
      ((Path)localObject).cubicTo(28.775999F, 45.183998F, 29.351999F, 49.576F, 30.648001F, 52.816002F);
      ((Path)localObject).cubicTo(32.375999F, 57.424F, 35.327999F, 59.799999F, 39.576F, 59.799999F);
      ((Path)localObject).cubicTo(43.751999F, 59.799999F, 46.776001F, 57.424F, 48.504002F, 52.816002F);
      ((Path)localObject).cubicTo(49.728001F, 49.576F, 50.375999F, 45.183998F, 50.375999F, 39.712002F);
      ((Path)localObject).cubicTo(50.375999F, 34.167999F, 49.728001F, 29.775999F, 48.504002F, 26.608F);
      ((Path)localObject).cubicTo(46.776001F, 21.927999F, 43.751999F, 19.624001F, 39.576F, 19.624001F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.count_down_0
 * JD-Core Version:    0.7.0.1
 */