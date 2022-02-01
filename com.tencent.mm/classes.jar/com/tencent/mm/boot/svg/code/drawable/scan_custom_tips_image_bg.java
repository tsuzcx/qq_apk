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

public class scan_custom_tips_image_bg
  extends c
{
  private final int height = 279;
  private final int width = 264;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 264;
      return 279;
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
      localPaint.setColor(-421667363);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(24.0F, 264.0F);
      ((Path)localObject).cubicTo(10.745166F, 264.0F, 0.0F, 253.25484F, 0.0F, 240.0F);
      ((Path)localObject).lineTo(0.0F, 24.0F);
      ((Path)localObject).cubicTo(0.0F, 10.745166F, 10.745166F, -2.131628E-013F, 24.0F, -2.131628E-013F);
      ((Path)localObject).lineTo(240.0F, -2.131628E-013F);
      ((Path)localObject).cubicTo(253.25484F, -2.131628E-013F, 264.0F, 10.745166F, 264.0F, 24.0F);
      ((Path)localObject).lineTo(264.0F, 240.0F);
      ((Path)localObject).cubicTo(264.0F, 253.25484F, 253.25484F, 264.0F, 240.0F, 264.0F);
      ((Path)localObject).lineTo(148.97057F, 264.0F);
      ((Path)localObject).lineTo(136.24265F, 276.72794F);
      ((Path)localObject).cubicTo(133.89949F, 279.07108F, 130.10051F, 279.07108F, 127.75736F, 276.72794F);
      ((Path)localObject).lineTo(115.02943F, 264.0F);
      ((Path)localObject).lineTo(24.0F, 264.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.scan_custom_tips_image_bg
 * JD-Core Version:    0.7.0.1
 */