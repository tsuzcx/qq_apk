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

public class icons_outlined_ocr
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 0.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(4.2F, 16.0F);
      ((Path)localObject).lineTo(4.2F, 19.799999F);
      ((Path)localObject).lineTo(8.0F, 19.799999F);
      ((Path)localObject).lineTo(8.0F, 21.0F);
      ((Path)localObject).lineTo(4.0F, 21.0F);
      ((Path)localObject).cubicTo(3.487164F, 21.0F, 3.064493F, 20.61396F, 3.006728F, 20.116621F);
      ((Path)localObject).lineTo(3.0F, 20.0F);
      ((Path)localObject).lineTo(3.0F, 16.0F);
      ((Path)localObject).lineTo(4.2F, 16.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.0F, 16.0F);
      ((Path)localObject).lineTo(21.0F, 20.0F);
      ((Path)localObject).cubicTo(21.0F, 20.552284F, 20.552284F, 21.0F, 20.0F, 21.0F);
      ((Path)localObject).lineTo(16.0F, 21.0F);
      ((Path)localObject).lineTo(16.0F, 19.799999F);
      ((Path)localObject).lineTo(19.799999F, 19.799999F);
      ((Path)localObject).lineTo(19.799999F, 16.0F);
      ((Path)localObject).lineTo(21.0F, 16.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.85F, 7.0F);
      ((Path)localObject).lineTo(16.299999F, 16.5F);
      ((Path)localObject).lineTo(14.848F, 16.5F);
      ((Path)localObject).lineTo(14.011F, 14.2F);
      ((Path)localObject).lineTo(9.994F, 14.2F);
      ((Path)localObject).lineTo(9.157F, 16.5F);
      ((Path)localObject).lineTo(7.7F, 16.5F);
      ((Path)localObject).lineTo(11.16F, 7.0F);
      ((Path)localObject).lineTo(12.85F, 7.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.003F, 8.680677F);
      ((Path)localObject).lineTo(10.43F, 13.0F);
      ((Path)localObject).lineTo(13.574F, 13.0F);
      ((Path)localObject).lineTo(12.003F, 8.680677F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(8.0F, 3.0F);
      ((Path)localObject).lineTo(8.0F, 4.2F);
      ((Path)localObject).lineTo(4.2F, 4.2F);
      ((Path)localObject).lineTo(4.2F, 8.0F);
      ((Path)localObject).lineTo(3.0F, 8.0F);
      ((Path)localObject).lineTo(3.0F, 4.0F);
      ((Path)localObject).cubicTo(3.0F, 3.447715F, 3.447715F, 3.0F, 4.0F, 3.0F);
      ((Path)localObject).lineTo(8.0F, 3.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 3.0F);
      ((Path)localObject).cubicTo(20.512836F, 3.0F, 20.935507F, 3.38604F, 20.993273F, 3.883379F);
      ((Path)localObject).lineTo(21.0F, 4.0F);
      ((Path)localObject).lineTo(21.0F, 8.0F);
      ((Path)localObject).lineTo(19.799999F, 8.0F);
      ((Path)localObject).lineTo(19.799999F, 4.2F);
      ((Path)localObject).lineTo(16.0F, 4.2F);
      ((Path)localObject).lineTo(16.0F, 3.0F);
      ((Path)localObject).lineTo(20.0F, 3.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_ocr
 * JD-Core Version:    0.7.0.1
 */