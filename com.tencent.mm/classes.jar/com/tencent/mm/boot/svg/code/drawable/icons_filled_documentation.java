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

public class icons_filled_documentation
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
      ((Path)localObject).moveTo(19.0F, 2.0F);
      ((Path)localObject).cubicTo(19.552284F, 2.0F, 20.0F, 2.447715F, 20.0F, 3.0F);
      ((Path)localObject).lineTo(20.0F, 21.001354F);
      ((Path)localObject).cubicTo(20.0F, 21.55423F, 19.554161F, 22.0F, 19.004192F, 22.0F);
      ((Path)localObject).lineTo(5.995809F, 22.0F);
      ((Path)localObject).cubicTo(5.44892F, 22.0F, 5.0F, 21.552891F, 5.0F, 21.001354F);
      ((Path)localObject).lineTo(5.0F, 2.998646F);
      ((Path)localObject).cubicTo(5.0F, 2.44577F, 5.445839F, 2.0F, 5.995809F, 2.0F);
      ((Path)localObject).lineTo(19.0F, 2.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.0F, 13.0F);
      ((Path)localObject).lineTo(8.0F, 13.0F);
      ((Path)localObject).lineTo(8.0F, 14.5F);
      ((Path)localObject).lineTo(13.0F, 14.5F);
      ((Path)localObject).lineTo(13.0F, 13.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.0F, 9.0F);
      ((Path)localObject).lineTo(8.0F, 9.0F);
      ((Path)localObject).lineTo(8.0F, 10.5F);
      ((Path)localObject).lineTo(17.0F, 10.5F);
      ((Path)localObject).lineTo(17.0F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(17.0F, 5.0F);
      ((Path)localObject).lineTo(8.0F, 5.0F);
      ((Path)localObject).lineTo(8.0F, 6.5F);
      ((Path)localObject).lineTo(17.0F, 6.5F);
      ((Path)localObject).lineTo(17.0F, 5.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_documentation
 * JD-Core Version:    0.7.0.1
 */