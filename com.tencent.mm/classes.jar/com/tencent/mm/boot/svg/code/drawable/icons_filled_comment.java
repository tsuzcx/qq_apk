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

public class icons_filled_comment
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
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(20.5F, 4.0F);
      ((Path)localObject).cubicTo(21.328426F, 4.0F, 22.0F, 4.671573F, 22.0F, 5.5F);
      ((Path)localObject).lineTo(22.0F, 5.5F);
      ((Path)localObject).lineTo(22.0F, 17.5F);
      ((Path)localObject).cubicTo(22.0F, 18.328426F, 21.328426F, 19.0F, 20.5F, 19.0F);
      ((Path)localObject).lineTo(20.5F, 19.0F);
      ((Path)localObject).lineTo(11.0F, 19.0F);
      ((Path)localObject).lineTo(8.707107F, 21.292892F);
      ((Path)localObject).cubicTo(8.316583F, 21.683418F, 7.683417F, 21.683418F, 7.292893F, 21.292892F);
      ((Path)localObject).cubicTo(7.105357F, 21.105356F, 7.0F, 20.851004F, 7.0F, 20.585787F);
      ((Path)localObject).lineTo(7.0F, 19.0F);
      ((Path)localObject).lineTo(3.5F, 19.0F);
      ((Path)localObject).cubicTo(2.720304F, 19.0F, 2.079551F, 18.405111F, 2.006867F, 17.644461F);
      ((Path)localObject).lineTo(2.0F, 17.5F);
      ((Path)localObject).lineTo(2.0F, 5.5F);
      ((Path)localObject).cubicTo(2.0F, 4.671573F, 2.671573F, 4.0F, 3.5F, 4.0F);
      ((Path)localObject).lineTo(3.5F, 4.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_comment
 * JD-Core Version:    0.7.0.1
 */