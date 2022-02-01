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

public class icons_filled_cellphone
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
      ((Path)localObject).moveTo(15.0F, 9.0F);
      ((Path)localObject).cubicTo(15.0F, 7.343146F, 16.343145F, 6.0F, 18.0F, 6.0F);
      ((Path)localObject).lineTo(54.0F, 6.0F);
      ((Path)localObject).cubicTo(55.656853F, 6.0F, 57.0F, 7.343146F, 57.0F, 9.0F);
      ((Path)localObject).lineTo(57.0F, 63.0F);
      ((Path)localObject).cubicTo(57.0F, 64.656853F, 55.656853F, 66.0F, 54.0F, 66.0F);
      ((Path)localObject).lineTo(18.0F, 66.0F);
      ((Path)localObject).cubicTo(16.343145F, 66.0F, 15.0F, 64.656853F, 15.0F, 63.0F);
      ((Path)localObject).lineTo(15.0F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 60.0F);
      ((Path)localObject).cubicTo(37.656853F, 60.0F, 39.0F, 58.656853F, 39.0F, 57.0F);
      ((Path)localObject).cubicTo(39.0F, 55.343147F, 37.656853F, 54.0F, 36.0F, 54.0F);
      ((Path)localObject).cubicTo(34.343147F, 54.0F, 33.0F, 55.343147F, 33.0F, 57.0F);
      ((Path)localObject).cubicTo(33.0F, 58.656853F, 34.343147F, 60.0F, 36.0F, 60.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_cellphone
 * JD-Core Version:    0.7.0.1
 */