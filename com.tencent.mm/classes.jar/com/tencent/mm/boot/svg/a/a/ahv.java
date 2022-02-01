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

public final class ahv
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(16.0F, 14.0F);
      ((Path)localObject).lineTo(16.0F, 16.4F);
      ((Path)localObject).lineTo(10.4F, 16.4F);
      ((Path)localObject).lineTo(10.4F, 41.599998F);
      ((Path)localObject).lineTo(37.599998F, 41.599998F);
      ((Path)localObject).lineTo(37.599998F, 16.4F);
      ((Path)localObject).lineTo(32.0F, 16.4F);
      ((Path)localObject).lineTo(32.0F, 14.0F);
      ((Path)localObject).lineTo(38.002087F, 14.0F);
      ((Path)localObject).cubicTo(39.101738F, 14.0F, 40.0F, 14.891677F, 40.0F, 15.991617F);
      ((Path)localObject).lineTo(40.0F, 42.008385F);
      ((Path)localObject).cubicTo(40.0F, 43.102161F, 39.108322F, 44.0F, 38.008385F, 44.0F);
      ((Path)localObject).lineTo(9.991617F, 44.0F);
      ((Path)localObject).cubicTo(8.897841F, 44.0F, 8.0F, 43.108322F, 8.0F, 42.008385F);
      ((Path)localObject).lineTo(8.0F, 15.991617F);
      ((Path)localObject).cubicTo(8.0F, 14.89784F, 8.894496F, 14.0F, 9.997913F, 14.0F);
      ((Path)localObject).lineTo(16.0F, 14.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(25.414213F, 5.343146F);
      ((Path)localObject).lineTo(31.071068F, 11.0F);
      ((Path)localObject).lineTo(29.374012F, 12.697057F);
      ((Path)localObject).lineTo(25.199987F, 8.523033F);
      ((Path)localObject).lineTo(25.199987F, 27.0F);
      ((Path)localObject).lineTo(22.799988F, 27.0F);
      ((Path)localObject).lineTo(22.799988F, 8.523057F);
      ((Path)localObject).lineTo(18.625988F, 12.697057F);
      ((Path)localObject).lineTo(16.928932F, 11.0F);
      ((Path)localObject).lineTo(22.585787F, 5.343146F);
      ((Path)localObject).cubicTo(23.366835F, 4.562097F, 24.633165F, 4.562097F, 25.414213F, 5.343146F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahv
 * JD-Core Version:    0.7.0.1
 */