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

public class icons_filled_photo_wall
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
      ((Path)localObject).moveTo(18.0F, 19.5F);
      ((Path)localObject).lineTo(18.0F, 15.0F);
      ((Path)localObject).cubicTo(18.0F, 13.343145F, 19.343145F, 12.0F, 21.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 12.0F);
      ((Path)localObject).cubicTo(64.656853F, 12.0F, 66.0F, 13.343145F, 66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 45.0F);
      ((Path)localObject).cubicTo(66.0F, 46.656853F, 64.656853F, 48.0F, 63.0F, 48.0F);
      ((Path)localObject).lineTo(58.5F, 48.0F);
      ((Path)localObject).lineTo(58.5F, 24.0F);
      ((Path)localObject).cubicTo(58.5F, 21.514719F, 56.485283F, 19.5F, 54.0F, 19.5F);
      ((Path)localObject).lineTo(18.0F, 19.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.0F, 24.0F);
      ((Path)localObject).lineTo(51.0F, 24.0F);
      ((Path)localObject).cubicTo(52.656853F, 24.0F, 54.0F, 25.343145F, 54.0F, 27.0F);
      ((Path)localObject).lineTo(54.0F, 57.0F);
      ((Path)localObject).cubicTo(54.0F, 58.656853F, 52.656853F, 60.0F, 51.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 60.0F);
      ((Path)localObject).cubicTo(7.343146F, 60.0F, 6.0F, 58.656853F, 6.0F, 57.0F);
      ((Path)localObject).lineTo(6.0F, 27.0F);
      ((Path)localObject).cubicTo(6.0F, 25.343145F, 7.343146F, 24.0F, 9.0F, 24.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_photo_wall
 * JD-Core Version:    0.7.0.1
 */