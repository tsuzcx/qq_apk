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

public class icons_filled_specialplay
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
      ((Path)localObject).moveTo(8.496139F, 4.854937F);
      ((Path)localObject).lineTo(19.480574F, 11.131757F);
      ((Path)localObject).cubicTo(19.960093F, 11.405766F, 20.126688F, 12.016622F, 19.852678F, 12.496139F);
      ((Path)localObject).cubicTo(19.76409F, 12.65117F, 19.635605F, 12.779654F, 19.480574F, 12.868243F);
      ((Path)localObject).lineTo(8.496139F, 19.145063F);
      ((Path)localObject).cubicTo(8.016622F, 19.419073F, 7.405767F, 19.252478F, 7.131757F, 18.772959F);
      ((Path)localObject).cubicTo(7.045415F, 18.621862F, 7.0F, 18.450848F, 7.0F, 18.276821F);
      ((Path)localObject).lineTo(7.0F, 5.72318F);
      ((Path)localObject).cubicTo(7.0F, 5.170895F, 7.447715F, 4.72318F, 8.0F, 4.72318F);
      ((Path)localObject).cubicTo(8.174027F, 4.72318F, 8.345041F, 4.768595F, 8.496139F, 4.854937F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_specialplay
 * JD-Core Version:    0.7.0.1
 */