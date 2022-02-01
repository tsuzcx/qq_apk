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

public class icons_filled_chat
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 20.0F);
      ((Path)localObject).cubicTo(17.522848F, 20.0F, 22.0F, 16.19442F, 22.0F, 11.5F);
      ((Path)localObject).cubicTo(22.0F, 6.80558F, 17.522848F, 3.0F, 12.0F, 3.0F);
      ((Path)localObject).cubicTo(6.477152F, 3.0F, 2.0F, 6.80558F, 2.0F, 11.5F);
      ((Path)localObject).cubicTo(2.0F, 14.036405F, 3.306998F, 16.313334F, 5.379757F, 17.870733F);
      ((Path)localObject).lineTo(5.077659F, 20.469614F);
      ((Path)localObject).cubicTo(5.045775F, 20.74391F, 5.242288F, 20.992117F, 5.516583F, 21.024002F);
      ((Path)localObject).cubicTo(5.610383F, 21.034904F, 5.705353F, 21.019022F, 5.790501F, 20.978193F);
      ((Path)localObject).lineTo(8.773454F, 19.547836F);
      ((Path)localObject).cubicTo(9.78573F, 19.840973F, 10.871017F, 20.0F, 12.0F, 20.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_chat
 * JD-Core Version:    0.7.0.1
 */