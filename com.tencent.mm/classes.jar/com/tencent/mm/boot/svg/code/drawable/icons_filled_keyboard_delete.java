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

public class icons_filled_keyboard_delete
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
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(63.0F, 12.0F);
      ((Path)localObject).cubicTo(64.656853F, 12.0F, 66.0F, 13.343145F, 66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 57.0F);
      ((Path)localObject).cubicTo(66.0F, 58.656853F, 64.656853F, 60.0F, 63.0F, 60.0F);
      ((Path)localObject).lineTo(25.5F, 60.0F);
      ((Path)localObject).cubicTo(24.555729F, 60.0F, 23.666563F, 59.555416F, 23.1F, 58.799999F);
      ((Path)localObject).lineTo(7.35F, 37.799999F);
      ((Path)localObject).cubicTo(6.55F, 36.733334F, 6.55F, 35.266666F, 7.35F, 34.200001F);
      ((Path)localObject).lineTo(23.1F, 13.2F);
      ((Path)localObject).cubicTo(23.666563F, 12.444583F, 24.555729F, 12.0F, 25.5F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(52.272793F, 25.727207F);
      ((Path)localObject).cubicTo(51.569847F, 25.024263F, 50.430153F, 25.024263F, 49.727207F, 25.727207F);
      ((Path)localObject).lineTo(49.727207F, 25.727207F);
      ((Path)localObject).lineTo(42.0F, 33.455002F);
      ((Path)localObject).lineTo(34.272793F, 25.727207F);
      ((Path)localObject).cubicTo(33.569847F, 25.024263F, 32.430153F, 25.024263F, 31.727207F, 25.727207F);
      ((Path)localObject).cubicTo(31.024263F, 26.430151F, 31.024263F, 27.569849F, 31.727207F, 28.272793F);
      ((Path)localObject).lineTo(31.727207F, 28.272793F);
      ((Path)localObject).lineTo(39.455002F, 36.0F);
      ((Path)localObject).lineTo(31.727207F, 43.727207F);
      ((Path)localObject).cubicTo(31.024263F, 44.430153F, 31.024263F, 45.569847F, 31.727207F, 46.272793F);
      ((Path)localObject).cubicTo(32.430153F, 46.975735F, 33.569847F, 46.975735F, 34.272793F, 46.272793F);
      ((Path)localObject).lineTo(34.272793F, 46.272793F);
      ((Path)localObject).lineTo(42.0F, 38.544998F);
      ((Path)localObject).lineTo(49.727207F, 46.272793F);
      ((Path)localObject).cubicTo(50.430153F, 46.975735F, 51.569847F, 46.975735F, 52.272793F, 46.272793F);
      ((Path)localObject).cubicTo(52.975735F, 45.569847F, 52.975735F, 44.430153F, 52.272793F, 43.727207F);
      ((Path)localObject).lineTo(52.272793F, 43.727207F);
      ((Path)localObject).lineTo(44.544998F, 36.0F);
      ((Path)localObject).lineTo(52.272793F, 28.272793F);
      ((Path)localObject).cubicTo(52.975735F, 27.569849F, 52.975735F, 26.430151F, 52.272793F, 25.727207F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_keyboard_delete
 * JD-Core Version:    0.7.0.1
 */