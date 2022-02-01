package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bkj
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-435699360);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(20.0F, 0.0F);
      localPath.cubicTo(31.045696F, 0.0F, 40.0F, 8.954305F, 40.0F, 20.0F);
      localPath.cubicTo(40.0F, 31.045696F, 31.045696F, 40.0F, 20.0F, 40.0F);
      localPath.cubicTo(8.954305F, 40.0F, 0.0F, 31.045696F, 0.0F, 20.0F);
      localPath.cubicTo(0.0F, 8.954305F, 8.954305F, 0.0F, 20.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-419430401);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(20.0F, 0.0F);
      ((Path)localObject).cubicTo(31.045694F, 0.0F, 40.0F, 8.954305F, 40.0F, 20.0F);
      ((Path)localObject).cubicTo(40.0F, 31.045694F, 31.045694F, 40.0F, 20.0F, 40.0F);
      ((Path)localObject).cubicTo(8.954305F, 40.0F, 0.0F, 31.045694F, 0.0F, 20.0F);
      ((Path)localObject).cubicTo(0.0F, 8.954305F, 8.954305F, 0.0F, 20.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 2.5F);
      ((Path)localObject).cubicTo(10.335017F, 2.5F, 2.5F, 10.335017F, 2.5F, 20.0F);
      ((Path)localObject).cubicTo(2.5F, 29.664984F, 10.335017F, 37.5F, 20.0F, 37.5F);
      ((Path)localObject).cubicTo(29.664984F, 37.5F, 37.5F, 29.664984F, 37.5F, 20.0F);
      ((Path)localObject).cubicTo(37.5F, 10.335017F, 29.664984F, 2.5F, 20.0F, 2.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bkj
 * JD-Core Version:    0.7.0.1
 */