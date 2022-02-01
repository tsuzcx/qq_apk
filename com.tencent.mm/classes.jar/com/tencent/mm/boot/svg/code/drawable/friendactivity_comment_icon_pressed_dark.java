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

public class friendactivity_comment_icon_pressed_dark
  extends c
{
  private final int height = 60;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 60;
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
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-13882324);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(84.0F, 0.0F);
      localPath.cubicTo(90.627419F, 0.0F, 96.0F, 5.372582F, 96.0F, 12.0F);
      localPath.lineTo(96.0F, 48.0F);
      localPath.cubicTo(96.0F, 54.627419F, 90.627419F, 60.0F, 84.0F, 60.0F);
      localPath.lineTo(12.0F, 60.0F);
      localPath.cubicTo(5.372582F, 60.0F, 0.0F, 54.627419F, 0.0F, 48.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localObject = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(436207615);
      localCanvas.save();
      localObject = c.instancePaint((Paint)localObject, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(84.0F, 0.0F);
      localPath.cubicTo(90.627419F, 0.0F, 96.0F, 5.372582F, 96.0F, 12.0F);
      localPath.lineTo(96.0F, 48.0F);
      localPath.cubicTo(96.0F, 54.627419F, 90.627419F, 60.0F, 84.0F, 60.0F);
      localPath.lineTo(12.0F, 60.0F);
      localPath.cubicTo(5.372582F, 60.0F, 0.0F, 54.627419F, 0.0F, 48.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-10521442);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 24.0F);
      ((Path)localObject).cubicTo(39.313709F, 24.0F, 42.0F, 26.686291F, 42.0F, 30.0F);
      ((Path)localObject).cubicTo(42.0F, 33.313709F, 39.313709F, 36.0F, 36.0F, 36.0F);
      ((Path)localObject).cubicTo(32.686291F, 36.0F, 30.0F, 33.313709F, 30.0F, 30.0F);
      ((Path)localObject).cubicTo(30.0F, 26.686291F, 32.686291F, 24.0F, 36.0F, 24.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.0F, 24.0F);
      ((Path)localObject).cubicTo(63.313709F, 24.0F, 66.0F, 26.686291F, 66.0F, 30.0F);
      ((Path)localObject).cubicTo(66.0F, 33.313709F, 63.313709F, 36.0F, 60.0F, 36.0F);
      ((Path)localObject).cubicTo(56.686291F, 36.0F, 54.0F, 33.313709F, 54.0F, 30.0F);
      ((Path)localObject).cubicTo(54.0F, 26.686291F, 56.686291F, 24.0F, 60.0F, 24.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.friendactivity_comment_icon_pressed_dark
 * JD-Core Version:    0.7.0.1
 */