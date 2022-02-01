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

public class mall_pos_icon
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      ((Path)localObject).moveTo(35.0F, 25.999985F);
      ((Path)localObject).lineTo(16.000061F, 25.999985F);
      ((Path)localObject).lineTo(16.000061F, 45.0F);
      ((Path)localObject).lineTo(10.0F, 45.0F);
      ((Path)localObject).lineTo(10.0F, 25.0F);
      ((Path)localObject).cubicTo(10.0F, 22.238577F, 12.238576F, 20.0F, 15.0F, 20.0F);
      ((Path)localObject).lineTo(35.0F, 20.0F);
      ((Path)localObject).lineTo(35.0F, 25.999985F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.0F, 94.000015F);
      ((Path)localObject).lineTo(35.0F, 100.0F);
      ((Path)localObject).lineTo(15.0F, 100.0F);
      ((Path)localObject).cubicTo(12.238576F, 100.0F, 10.0F, 97.761421F, 10.0F, 95.0F);
      ((Path)localObject).lineTo(10.0F, 75.0F);
      ((Path)localObject).lineTo(16.000061F, 75.0F);
      ((Path)localObject).lineTo(16.000061F, 94.000015F);
      ((Path)localObject).lineTo(35.0F, 94.000015F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(85.0F, 25.999985F);
      ((Path)localObject).lineTo(85.0F, 20.0F);
      ((Path)localObject).lineTo(105.0F, 20.0F);
      ((Path)localObject).cubicTo(107.76142F, 20.0F, 110.0F, 22.238577F, 110.0F, 25.0F);
      ((Path)localObject).lineTo(110.0F, 45.0F);
      ((Path)localObject).lineTo(103.99994F, 45.0F);
      ((Path)localObject).lineTo(103.99994F, 25.999985F);
      ((Path)localObject).lineTo(85.0F, 25.999985F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(85.0F, 94.000015F);
      ((Path)localObject).lineTo(103.99994F, 94.000015F);
      ((Path)localObject).lineTo(103.99994F, 75.0F);
      ((Path)localObject).lineTo(110.0F, 75.0F);
      ((Path)localObject).lineTo(110.0F, 95.0F);
      ((Path)localObject).cubicTo(110.0F, 97.761421F, 107.76142F, 100.0F, 105.0F, 100.0F);
      ((Path)localObject).lineTo(85.0F, 100.0F);
      ((Path)localObject).lineTo(85.0F, 94.000015F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(54.142136F, 72.791634F);
      ((Path)localObject).lineTo(83.183769F, 43.75F);
      ((Path)localObject).lineTo(87.426407F, 47.992641F);
      ((Path)localObject).lineTo(57.67767F, 77.741379F);
      ((Path)localObject).cubicTo(55.725048F, 79.694F, 52.559223F, 79.694F, 50.606602F, 77.741379F);
      ((Path)localObject).lineTo(35.0F, 62.134777F);
      ((Path)localObject).lineTo(39.242641F, 57.892136F);
      ((Path)localObject).lineTo(54.142136F, 72.791634F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.mall_pos_icon
 * JD-Core Version:    0.7.0.1
 */