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

public class icons_filled_eyes_on
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
      ((Path)localObject).moveTo(12.0F, 5.0F);
      ((Path)localObject).cubicTo(16.807985F, 5.0F, 20.972399F, 7.847857F, 23.000246F, 12.000502F);
      ((Path)localObject).cubicTo(20.971735F, 16.152597F, 16.807602F, 19.0F, 12.0F, 19.0F);
      ((Path)localObject).cubicTo(7.192399F, 19.0F, 3.028265F, 16.152597F, 1.00024F, 12.000491F);
      ((Path)localObject).cubicTo(3.027601F, 7.847857F, 7.192016F, 5.0F, 12.0F, 5.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 8.5F);
      ((Path)localObject).cubicTo(10.067003F, 8.5F, 8.5F, 10.067003F, 8.5F, 12.0F);
      ((Path)localObject).cubicTo(8.5F, 13.932997F, 10.067003F, 15.5F, 12.0F, 15.5F);
      ((Path)localObject).cubicTo(13.932997F, 15.5F, 15.5F, 13.932997F, 15.5F, 12.0F);
      ((Path)localObject).cubicTo(15.5F, 10.067003F, 13.932997F, 8.5F, 12.0F, 8.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_eyes_on
 * JD-Core Version:    0.7.0.1
 */