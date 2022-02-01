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

public final class atx
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(39.0F, 59.400002F);
      ((Path)localObject).lineTo(50.400002F, 59.400002F);
      ((Path)localObject).lineTo(50.400002F, 38.400002F);
      ((Path)localObject).lineTo(60.30883F, 38.400002F);
      ((Path)localObject).lineTo(36.0F, 14.091168F);
      ((Path)localObject).lineTo(11.691169F, 38.400002F);
      ((Path)localObject).lineTo(21.6F, 38.400002F);
      ((Path)localObject).lineTo(21.6F, 59.400002F);
      ((Path)localObject).lineTo(33.0F, 59.400002F);
      ((Path)localObject).lineTo(33.0F, 51.0F);
      ((Path)localObject).lineTo(39.0F, 51.0F);
      ((Path)localObject).lineTo(39.0F, 59.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(54.0F, 60.0F);
      ((Path)localObject).cubicTo(54.0F, 61.656853F, 52.656853F, 63.0F, 51.0F, 63.0F);
      ((Path)localObject).lineTo(21.0F, 63.0F);
      ((Path)localObject).cubicTo(19.343145F, 63.0F, 18.0F, 61.656853F, 18.0F, 60.0F);
      ((Path)localObject).lineTo(18.0F, 42.0F);
      ((Path)localObject).lineTo(10.24264F, 42.0F);
      ((Path)localObject).cubicTo(9.446991F, 42.0F, 8.683929F, 41.683929F, 8.121321F, 41.121319F);
      ((Path)localObject).cubicTo(6.949748F, 39.949749F, 6.949748F, 38.050251F, 8.121321F, 36.878681F);
      ((Path)localObject).lineTo(33.878681F, 11.121321F);
      ((Path)localObject).cubicTo(35.050251F, 9.949747F, 36.949749F, 9.949747F, 38.121319F, 11.121321F);
      ((Path)localObject).lineTo(63.878681F, 36.878681F);
      ((Path)localObject).cubicTo(64.441292F, 37.441288F, 64.757362F, 38.20435F, 64.757362F, 39.0F);
      ((Path)localObject).cubicTo(64.757362F, 40.656853F, 63.414215F, 42.0F, 61.757359F, 42.0F);
      ((Path)localObject).lineTo(54.0F, 42.0F);
      ((Path)localObject).lineTo(54.0F, 60.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.atx
 * JD-Core Version:    0.7.0.1
 */