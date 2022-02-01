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

public class sns_img_tipsbubble
  extends c
{
  private final int height = 96;
  private final int width = 584;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 584;
      return 96;
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
      localPaint.setColor(419430400);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 9.00051F);
      ((Path)localObject).cubicTo(0.0F, 4.029666F, 4.021278F, 0.0F, 8.997707F, 0.0F);
      ((Path)localObject).lineTo(575.00232F, 0.0F);
      ((Path)localObject).cubicTo(579.97162F, 0.0F, 584.0F, 4.03261F, 584.0F, 9.00051F);
      ((Path)localObject).lineTo(584.0F, 76.999489F);
      ((Path)localObject).cubicTo(584.0F, 81.970337F, 579.9787F, 86.0F, 575.00232F, 86.0F);
      ((Path)localObject).lineTo(8.997707F, 86.0F);
      ((Path)localObject).cubicTo(4.028411F, 86.0F, 0.0F, 81.967392F, 0.0F, 76.999489F);
      ((Path)localObject).lineTo(0.0F, 9.00051F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(113.04867F, 96.0F);
      ((Path)localObject).lineTo(104.0F, 86.0F);
      ((Path)localObject).lineTo(122.09733F, 86.0F);
      ((Path)localObject).lineTo(113.04867F, 96.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sns_img_tipsbubble
 * JD-Core Version:    0.7.0.1
 */