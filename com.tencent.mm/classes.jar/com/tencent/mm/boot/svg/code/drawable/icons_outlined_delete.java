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

public class icons_outlined_delete
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
      ((Path)localObject).moveTo(20.320658F, 19.199991F);
      ((Path)localObject).lineTo(22.757717F, 60.142605F);
      ((Path)localObject).cubicTo(22.833185F, 61.410458F, 23.883381F, 62.400002F, 25.153477F, 62.400002F);
      ((Path)localObject).lineTo(46.846523F, 62.400002F);
      ((Path)localObject).cubicTo(48.116619F, 62.400002F, 49.166817F, 61.410458F, 49.242283F, 60.142605F);
      ((Path)localObject).lineTo(51.679344F, 19.199991F);
      ((Path)localObject).lineTo(20.320658F, 19.199991F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(55.285713F, 19.199991F);
      ((Path)localObject).lineTo(52.835922F, 60.35651F);
      ((Path)localObject).cubicTo(52.647255F, 63.526142F, 50.021767F, 66.0F, 46.846523F, 66.0F);
      ((Path)localObject).lineTo(25.153477F, 66.0F);
      ((Path)localObject).cubicTo(21.978235F, 66.0F, 19.352747F, 63.526142F, 19.164078F, 60.35651F);
      ((Path)localObject).lineTo(16.714285F, 19.199991F);
      ((Path)localObject).lineTo(10.5F, 19.199991F);
      ((Path)localObject).lineTo(10.5F, 17.099991F);
      ((Path)localObject).cubicTo(10.5F, 16.271564F, 11.171573F, 15.599991F, 12.0F, 15.599991F);
      ((Path)localObject).lineTo(60.0F, 15.599991F);
      ((Path)localObject).cubicTo(60.828426F, 15.599991F, 61.5F, 16.271564F, 61.5F, 17.099991F);
      ((Path)localObject).lineTo(61.5F, 19.199991F);
      ((Path)localObject).lineTo(55.285713F, 19.199991F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(42.0F, 9.000082F);
      ((Path)localObject).cubicTo(42.828426F, 9.000082F, 43.5F, 9.671655F, 43.5F, 10.500082F);
      ((Path)localObject).lineTo(43.5F, 12.600073F);
      ((Path)localObject).lineTo(28.5F, 12.600073F);
      ((Path)localObject).lineTo(28.5F, 10.500082F);
      ((Path)localObject).cubicTo(28.5F, 9.671655F, 29.171574F, 9.000082F, 30.0F, 9.000082F);
      ((Path)localObject).lineTo(42.0F, 9.000082F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(28.5F, 27.0F);
      ((Path)localObject).lineTo(32.100037F, 27.0F);
      ((Path)localObject).lineTo(33.600037F, 54.0F);
      ((Path)localObject).lineTo(30.0F, 54.0F);
      ((Path)localObject).lineTo(28.5F, 27.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.899963F, 27.0F);
      ((Path)localObject).lineTo(43.5F, 27.0F);
      ((Path)localObject).lineTo(42.0F, 54.0F);
      ((Path)localObject).lineTo(38.399963F, 54.0F);
      ((Path)localObject).lineTo(39.899963F, 27.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_delete
 * JD-Core Version:    0.7.0.1
 */