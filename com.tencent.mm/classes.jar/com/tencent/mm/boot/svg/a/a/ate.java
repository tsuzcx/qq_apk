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

public final class ate
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
      ((Path)localObject).moveTo(12.6F, 15.6F);
      ((Path)localObject).lineTo(35.279999F, 32.610001F);
      ((Path)localObject).cubicTo(35.706665F, 32.93F, 36.293335F, 32.93F, 36.720001F, 32.610001F);
      ((Path)localObject).lineTo(59.400002F, 15.6F);
      ((Path)localObject).lineTo(12.6F, 15.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(62.400002F, 17.85F);
      ((Path)localObject).lineTo(38.880001F, 35.490002F);
      ((Path)localObject).cubicTo(37.173332F, 36.77F, 34.826668F, 36.77F, 33.119999F, 35.490002F);
      ((Path)localObject).lineTo(9.6F, 17.85F);
      ((Path)localObject).lineTo(9.6F, 56.400002F);
      ((Path)localObject).lineTo(62.400002F, 56.400002F);
      ((Path)localObject).lineTo(62.400002F, 17.85F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 12.0F);
      ((Path)localObject).cubicTo(64.656853F, 12.0F, 66.0F, 13.343145F, 66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 57.0F);
      ((Path)localObject).cubicTo(66.0F, 58.656853F, 64.656853F, 60.0F, 63.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 60.0F);
      ((Path)localObject).cubicTo(7.343146F, 60.0F, 6.0F, 58.656853F, 6.0F, 57.0F);
      ((Path)localObject).lineTo(6.0F, 15.0F);
      ((Path)localObject).cubicTo(6.0F, 13.343145F, 7.343146F, 12.0F, 9.0F, 12.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ate
 * JD-Core Version:    0.7.0.1
 */