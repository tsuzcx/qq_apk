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

public class icons_filled_allselect
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
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(65.435585F, 40.122665F);
      ((Path)localObject).lineTo(70.375107F, 45.062183F);
      ((Path)localObject).lineTo(50.637524F, 64.799767F);
      ((Path)localObject).lineTo(38.288731F, 52.45097F);
      ((Path)localObject).lineTo(43.223125F, 47.516575F);
      ((Path)localObject).lineTo(50.632401F, 54.92585F);
      ((Path)localObject).lineTo(65.435585F, 40.122665F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(51.758507F, 7.5F);
      ((Path)localObject).cubicTo(53.433002F, 7.5F, 54.801384F, 8.81064F, 54.893764F, 10.462035F);
      ((Path)localObject).lineTo(54.898735F, 10.640229F);
      ((Path)localObject).lineTo(54.897999F, 43.445999F);
      ((Path)localObject).lineTo(50.854694F, 47.49073F);
      ((Path)localObject).lineTo(43.431087F, 40.066368F);
      ((Path)localObject).lineTo(30.703167F, 52.794289F);
      ((Path)localObject).lineTo(41.235001F, 63.326F);
      ((Path)localObject).lineTo(9.14023F, 63.326305F);
      ((Path)localObject).cubicTo(7.465732F, 63.326305F, 6.097351F, 62.015667F, 6.004971F, 60.364273F);
      ((Path)localObject).lineTo(6.0F, 60.186077F);
      ((Path)localObject).lineTo(6.0F, 10.640229F);
      ((Path)localObject).cubicTo(6.0F, 8.965733F, 7.31064F, 7.597351F, 8.962035F, 7.504971F);
      ((Path)localObject).lineTo(9.14023F, 7.5F);
      ((Path)localObject).lineTo(51.758507F, 7.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.449368F, 36.808811F);
      ((Path)localObject).lineTo(15.168513F, 36.808811F);
      ((Path)localObject).lineTo(15.168513F, 41.519154F);
      ((Path)localObject).lineTo(30.449368F, 41.519154F);
      ((Path)localObject).lineTo(30.449368F, 36.808811F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.730221F, 27.388121F);
      ((Path)localObject).lineTo(15.168513F, 27.388121F);
      ((Path)localObject).lineTo(15.168513F, 32.098465F);
      ((Path)localObject).lineTo(45.730221F, 32.098465F);
      ((Path)localObject).lineTo(45.730221F, 27.388121F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.730221F, 17.967432F);
      ((Path)localObject).lineTo(15.168513F, 17.967432F);
      ((Path)localObject).lineTo(15.168513F, 22.677776F);
      ((Path)localObject).lineTo(45.730221F, 22.677776F);
      ((Path)localObject).lineTo(45.730221F, 17.967432F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_allselect
 * JD-Core Version:    0.7.0.1
 */