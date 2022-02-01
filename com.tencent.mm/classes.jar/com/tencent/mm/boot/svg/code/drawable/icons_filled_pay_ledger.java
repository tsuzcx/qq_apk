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

public class icons_filled_pay_ledger
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(60.0F, 6.0F);
      ((Path)localObject).cubicTo(61.656853F, 6.0F, 63.0F, 7.343146F, 63.0F, 9.0F);
      ((Path)localObject).lineTo(63.0F, 63.0F);
      ((Path)localObject).cubicTo(63.0F, 64.656853F, 61.656853F, 66.0F, 60.0F, 66.0F);
      ((Path)localObject).lineTo(24.0F, 66.0F);
      ((Path)localObject).lineTo(24.0F, 6.0F);
      ((Path)localObject).lineTo(60.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.0F, 6.0F);
      ((Path)localObject).lineTo(18.0F, 66.0F);
      ((Path)localObject).lineTo(12.0F, 66.0F);
      ((Path)localObject).cubicTo(10.343145F, 66.0F, 9.0F, 64.656853F, 9.0F, 63.0F);
      ((Path)localObject).lineTo(9.0F, 9.0F);
      ((Path)localObject).cubicTo(9.0F, 7.343146F, 10.343145F, 6.0F, 12.0F, 6.0F);
      ((Path)localObject).lineTo(18.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.0F, 31.5F);
      ((Path)localObject).lineTo(33.0F, 31.5F);
      ((Path)localObject).lineTo(37.5F, 40.5F);
      ((Path)localObject).lineTo(33.0F, 40.5F);
      ((Path)localObject).lineTo(33.0F, 45.0F);
      ((Path)localObject).lineTo(41.25F, 45.0F);
      ((Path)localObject).lineTo(41.25F, 48.0F);
      ((Path)localObject).lineTo(33.0F, 48.0F);
      ((Path)localObject).lineTo(33.0F, 52.5F);
      ((Path)localObject).lineTo(41.25F, 52.5F);
      ((Path)localObject).lineTo(41.25F, 57.0F);
      ((Path)localObject).lineTo(45.75F, 57.0F);
      ((Path)localObject).lineTo(45.75F, 52.5F);
      ((Path)localObject).lineTo(54.0F, 52.5F);
      ((Path)localObject).lineTo(54.0F, 48.0F);
      ((Path)localObject).lineTo(45.75F, 48.0F);
      ((Path)localObject).lineTo(45.75F, 45.0F);
      ((Path)localObject).lineTo(54.0F, 45.0F);
      ((Path)localObject).lineTo(54.0F, 40.5F);
      ((Path)localObject).lineTo(49.5F, 40.5F);
      ((Path)localObject).lineTo(54.0F, 31.5F);
      ((Path)localObject).lineTo(48.0F, 31.5F);
      ((Path)localObject).lineTo(43.5F, 40.5F);
      ((Path)localObject).lineTo(39.0F, 31.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_pay_ledger
 * JD-Core Version:    0.7.0.1
 */