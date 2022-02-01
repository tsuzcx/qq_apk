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

public class send_data_round_rect_shadow
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
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
      localPaint.setColor(-1973786);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(168.0F, 0.0F);
      ((Path)localObject).lineTo(168.0F, 168.0F);
      ((Path)localObject).lineTo(0.0F, 168.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(0.0F, 11.997895F);
      ((Path)localObject).cubicTo(0.0F, 5.371641F, 5.375813F, 0.0F, 11.997895F, 0.0F);
      ((Path)localObject).lineTo(156.00211F, 0.0F);
      ((Path)localObject).cubicTo(162.62836F, 0.0F, 168.0F, 5.375813F, 168.0F, 11.997895F);
      ((Path)localObject).lineTo(168.0F, 156.00211F);
      ((Path)localObject).cubicTo(168.0F, 162.62836F, 162.62419F, 168.0F, 156.00211F, 168.0F);
      ((Path)localObject).lineTo(11.997895F, 168.0F);
      ((Path)localObject).cubicTo(5.371641F, 168.0F, 0.0F, 162.62419F, 0.0F, 156.00211F);
      ((Path)localObject).lineTo(0.0F, 11.997895F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.send_data_round_rect_shadow
 * JD-Core Version:    0.7.0.1
 */