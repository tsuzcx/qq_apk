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

public class icons_filled_health_note
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
      ((Path)localObject).moveTo(19.5F, 12.0F);
      ((Path)localObject).lineTo(19.5F, 15.0F);
      ((Path)localObject).cubicTo(19.5F, 18.238398F, 22.065575F, 20.877571F, 25.275063F, 20.995861F);
      ((Path)localObject).lineTo(25.5F, 21.0F);
      ((Path)localObject).lineTo(46.5F, 21.0F);
      ((Path)localObject).cubicTo(49.738396F, 21.0F, 52.377571F, 18.434425F, 52.495861F, 15.224938F);
      ((Path)localObject).lineTo(52.5F, 15.0F);
      ((Path)localObject).lineTo(52.5F, 12.0F);
      ((Path)localObject).lineTo(57.0F, 12.0F);
      ((Path)localObject).cubicTo(58.656853F, 12.0F, 60.0F, 13.343145F, 60.0F, 15.0F);
      ((Path)localObject).lineTo(60.0F, 63.0F);
      ((Path)localObject).cubicTo(60.0F, 64.656853F, 58.656853F, 66.0F, 57.0F, 66.0F);
      ((Path)localObject).lineTo(15.0F, 66.0F);
      ((Path)localObject).cubicTo(13.343145F, 66.0F, 12.0F, 64.656853F, 12.0F, 63.0F);
      ((Path)localObject).lineTo(12.0F, 15.0F);
      ((Path)localObject).cubicTo(12.0F, 13.343145F, 13.343145F, 12.0F, 15.0F, 12.0F);
      ((Path)localObject).lineTo(19.5F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.25F, 33.0F);
      ((Path)localObject).lineTo(33.75F, 33.0F);
      ((Path)localObject).lineTo(33.75F, 39.75F);
      ((Path)localObject).lineTo(27.0F, 39.75F);
      ((Path)localObject).lineTo(27.0F, 44.25F);
      ((Path)localObject).lineTo(33.75F, 44.25F);
      ((Path)localObject).lineTo(33.75F, 51.0F);
      ((Path)localObject).lineTo(38.25F, 51.0F);
      ((Path)localObject).lineTo(38.25F, 44.25F);
      ((Path)localObject).lineTo(45.0F, 44.25F);
      ((Path)localObject).lineTo(45.0F, 39.75F);
      ((Path)localObject).lineTo(38.25F, 39.75F);
      ((Path)localObject).lineTo(38.25F, 33.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(46.5F, 9.0F);
      ((Path)localObject).cubicTo(48.156853F, 9.0F, 49.5F, 10.343145F, 49.5F, 12.0F);
      ((Path)localObject).lineTo(49.5F, 15.0F);
      ((Path)localObject).cubicTo(49.5F, 16.656855F, 48.156853F, 18.0F, 46.5F, 18.0F);
      ((Path)localObject).lineTo(25.5F, 18.0F);
      ((Path)localObject).cubicTo(23.843145F, 18.0F, 22.5F, 16.656855F, 22.5F, 15.0F);
      ((Path)localObject).lineTo(22.5F, 12.0F);
      ((Path)localObject).cubicTo(22.5F, 10.343145F, 23.843145F, 9.0F, 25.5F, 9.0F);
      ((Path)localObject).lineTo(46.5F, 9.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_health_note
 * JD-Core Version:    0.7.0.1
 */