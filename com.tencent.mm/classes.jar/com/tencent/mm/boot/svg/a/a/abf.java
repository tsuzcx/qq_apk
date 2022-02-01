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

public final class abf
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(14211288);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.lineTo(72.0F, 72.0F);
      localPath.lineTo(0.0F, 72.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(63.0F, 15.0F);
      ((Path)localObject).cubicTo(64.656853F, 15.0F, 66.0F, 16.343145F, 66.0F, 18.0F);
      ((Path)localObject).lineTo(66.0F, 54.0F);
      ((Path)localObject).cubicTo(66.0F, 55.656853F, 64.656853F, 57.0F, 63.0F, 57.0F);
      ((Path)localObject).lineTo(23.577339F, 57.0F);
      ((Path)localObject).cubicTo(22.138334F, 57.0F, 20.786116F, 56.311798F, 19.939213F, 55.148399F);
      ((Path)localObject).lineTo(7.285281F, 37.765602F);
      ((Path)localObject).cubicTo(6.519173F, 36.713192F, 6.519173F, 35.286808F, 7.285281F, 34.234398F);
      ((Path)localObject).lineTo(19.939213F, 16.851599F);
      ((Path)localObject).cubicTo(20.786116F, 15.688203F, 22.138334F, 15.0F, 23.577339F, 15.0F);
      ((Path)localObject).lineTo(63.0F, 15.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.785728F, 25.477728F);
      ((Path)localObject).lineTo(30.601854F, 28.661602F);
      ((Path)localObject).lineTo(37.933975F, 35.995728F);
      ((Path)localObject).lineTo(30.6F, 43.329266F);
      ((Path)localObject).lineTo(33.787582F, 46.51685F);
      ((Path)localObject).lineTo(41.119976F, 39.181728F);
      ((Path)localObject).lineTo(48.451538F, 46.518703F);
      ((Path)localObject).lineTo(51.639122F, 43.331123F);
      ((Path)localObject).lineTo(44.305977F, 35.995728F);
      ((Path)localObject).lineTo(51.640976F, 28.663456F);
      ((Path)localObject).lineTo(48.457104F, 25.479584F);
      ((Path)localObject).lineTo(41.122974F, 32.812729F);
      ((Path)localObject).lineTo(33.785728F, 25.477728F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abf
 * JD-Core Version:    0.7.0.1
 */