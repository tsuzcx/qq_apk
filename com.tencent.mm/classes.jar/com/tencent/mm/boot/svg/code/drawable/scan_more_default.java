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

public class scan_more_default
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(21.0F, 36.0F);
      ((Path)localObject).cubicTo(21.0F, 39.313202F, 18.3132F, 42.0F, 15.0F, 42.0F);
      ((Path)localObject).cubicTo(11.6868F, 42.0F, 9.0F, 39.313202F, 9.0F, 36.0F);
      ((Path)localObject).cubicTo(9.0F, 32.6856F, 11.6868F, 30.0F, 15.0F, 30.0F);
      ((Path)localObject).cubicTo(18.3132F, 30.0F, 21.0F, 32.6856F, 21.0F, 36.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 30.0F);
      ((Path)localObject).cubicTo(39.313202F, 30.0F, 42.0F, 32.6856F, 42.0F, 36.0F);
      ((Path)localObject).cubicTo(42.0F, 39.313202F, 39.313202F, 42.0F, 36.0F, 42.0F);
      ((Path)localObject).cubicTo(32.686798F, 42.0F, 30.0F, 39.313202F, 30.0F, 36.0F);
      ((Path)localObject).cubicTo(30.0F, 32.6856F, 32.686798F, 30.0F, 36.0F, 30.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(57.0F, 30.0F);
      ((Path)localObject).cubicTo(60.313202F, 30.0F, 63.0F, 32.6856F, 63.0F, 36.0F);
      ((Path)localObject).cubicTo(63.0F, 39.313202F, 60.313202F, 42.0F, 57.0F, 42.0F);
      ((Path)localObject).cubicTo(53.686798F, 42.0F, 51.0F, 39.313202F, 51.0F, 36.0F);
      ((Path)localObject).cubicTo(51.0F, 32.6856F, 53.686798F, 30.0F, 57.0F, 30.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.scan_more_default
 * JD-Core Version:    0.7.0.1
 */