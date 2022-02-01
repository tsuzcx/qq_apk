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

public final class ats
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(60.0F, 6.0F);
      ((Path)localObject).cubicTo(61.656853F, 6.0F, 63.0F, 7.343146F, 63.0F, 9.0F);
      ((Path)localObject).lineTo(63.0F, 63.0F);
      ((Path)localObject).cubicTo(63.0F, 64.656853F, 61.656853F, 66.0F, 60.0F, 66.0F);
      ((Path)localObject).lineTo(12.0F, 66.0F);
      ((Path)localObject).cubicTo(10.343145F, 66.0F, 9.0F, 64.656853F, 9.0F, 63.0F);
      ((Path)localObject).lineTo(9.0F, 9.0F);
      ((Path)localObject).cubicTo(9.0F, 7.343146F, 10.343145F, 6.0F, 12.0F, 6.0F);
      ((Path)localObject).lineTo(60.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(19.799F, 9.599F);
      ((Path)localObject).lineTo(12.6F, 9.6F);
      ((Path)localObject).lineTo(12.6F, 62.400002F);
      ((Path)localObject).lineTo(19.799F, 62.400002F);
      ((Path)localObject).lineTo(19.799F, 9.599F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(59.400002F, 9.6F);
      ((Path)localObject).lineTo(23.4F, 9.599F);
      ((Path)localObject).lineTo(23.4F, 62.400002F);
      ((Path)localObject).lineTo(59.400002F, 62.400002F);
      ((Path)localObject).lineTo(59.400002F, 9.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.700001F, 29.700001F);
      ((Path)localObject).lineTo(40.5F, 39.299999F);
      ((Path)localObject).lineTo(42.900002F, 39.299999F);
      ((Path)localObject).lineTo(47.700001F, 29.700001F);
      ((Path)localObject).lineTo(52.200001F, 29.700001F);
      ((Path)localObject).lineTo(47.400002F, 39.299999F);
      ((Path)localObject).lineTo(52.200001F, 39.300037F);
      ((Path)localObject).lineTo(52.200001F, 42.900036F);
      ((Path)localObject).lineTo(43.5F, 42.900002F);
      ((Path)localObject).lineTo(43.5F, 46.200001F);
      ((Path)localObject).lineTo(52.200001F, 46.200001F);
      ((Path)localObject).lineTo(52.200001F, 49.799999F);
      ((Path)localObject).lineTo(43.5F, 49.799999F);
      ((Path)localObject).lineTo(43.500072F, 55.200001F);
      ((Path)localObject).lineTo(39.90007F, 55.200001F);
      ((Path)localObject).lineTo(39.900002F, 49.799999F);
      ((Path)localObject).lineTo(31.200001F, 49.799999F);
      ((Path)localObject).lineTo(31.200001F, 46.200001F);
      ((Path)localObject).lineTo(39.900002F, 46.200001F);
      ((Path)localObject).lineTo(39.900002F, 42.900002F);
      ((Path)localObject).lineTo(31.200001F, 42.900036F);
      ((Path)localObject).lineTo(31.200001F, 39.300037F);
      ((Path)localObject).lineTo(36.0F, 39.299999F);
      ((Path)localObject).lineTo(31.200001F, 29.700001F);
      ((Path)localObject).lineTo(35.700001F, 29.700001F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ats
 * JD-Core Version:    0.7.0.1
 */