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

public class icons_outlined_lock_on
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
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(54.75F, 6.0F);
      ((Path)localObject).cubicTo(61.377419F, 6.0F, 66.75F, 11.372583F, 66.75F, 18.0F);
      ((Path)localObject).lineTo(66.75F, 27.0F);
      ((Path)localObject).lineTo(63.149998F, 27.0F);
      ((Path)localObject).lineTo(63.149998F, 18.0F);
      ((Path)localObject).cubicTo(63.14999F, 13.360799F, 59.389183F, 9.599991F, 54.75F, 9.599991F);
      ((Path)localObject).cubicTo(50.110798F, 9.599991F, 46.349991F, 13.360799F, 46.349991F, 18.0F);
      ((Path)localObject).lineTo(46.349998F, 26.997F);
      ((Path)localObject).lineTo(56.997383F, 27.0F);
      ((Path)localObject).cubicTo(58.655682F, 27.0F, 60.0F, 28.342468F, 60.0F, 29.995506F);
      ((Path)localObject).lineTo(60.0F, 63.004494F);
      ((Path)localObject).cubicTo(60.0F, 64.658867F, 58.666107F, 66.0F, 56.997383F, 66.0F);
      ((Path)localObject).lineTo(15.002615F, 66.0F);
      ((Path)localObject).cubicTo(13.344316F, 66.0F, 12.0F, 64.657532F, 12.0F, 63.004494F);
      ((Path)localObject).lineTo(12.0F, 29.995506F);
      ((Path)localObject).cubicTo(12.0F, 28.341135F, 13.333893F, 27.0F, 15.002615F, 27.0F);
      ((Path)localObject).lineTo(42.75F, 26.997F);
      ((Path)localObject).lineTo(42.75F, 18.0F);
      ((Path)localObject).cubicTo(42.75F, 11.372583F, 48.122581F, 6.0F, 54.75F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(56.400002F, 30.6F);
      ((Path)localObject).lineTo(15.6F, 30.6F);
      ((Path)localObject).lineTo(15.6F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 62.400002F);
      ((Path)localObject).lineTo(56.400002F, 30.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 39.0F);
      ((Path)localObject).cubicTo(38.485283F, 39.0F, 40.5F, 41.014717F, 40.5F, 43.5F);
      ((Path)localObject).cubicTo(40.5F, 45.345287F, 39.389313F, 46.93116F, 37.799999F, 47.625561F);
      ((Path)localObject).lineTo(37.799999F, 54.0F);
      ((Path)localObject).lineTo(34.200001F, 54.0F);
      ((Path)localObject).lineTo(34.200001F, 47.625561F);
      ((Path)localObject).cubicTo(32.610683F, 46.93116F, 31.5F, 45.345287F, 31.5F, 43.5F);
      ((Path)localObject).cubicTo(31.5F, 41.014717F, 33.514717F, 39.0F, 36.0F, 39.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_lock_on
 * JD-Core Version:    0.7.0.1
 */