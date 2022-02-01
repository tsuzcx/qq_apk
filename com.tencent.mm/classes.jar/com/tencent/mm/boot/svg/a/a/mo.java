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

public final class mo
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint.setColor(-8617851);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(77.0F, 71.0F);
      ((Path)localObject).lineTo(53.0F, 76.0F);
      ((Path)localObject).lineTo(53.0F, 26.0F);
      ((Path)localObject).lineTo(77.0F, 21.0F);
      ((Path)localObject).lineTo(77.0F, 71.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(20.0F, 21.0F);
      ((Path)localObject).lineTo(44.0F, 26.0F);
      ((Path)localObject).lineTo(44.0F, 76.0F);
      ((Path)localObject).lineTo(20.0F, 71.0F);
      ((Path)localObject).lineTo(20.0F, 21.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(85.0F, 18.0F);
      ((Path)localObject).cubicTo(85.0F, 14.723531F, 82.276466F, 12.0F, 79.0F, 12.0F);
      ((Path)localObject).cubicTo(78.840515F, 12.0F, 78.766609F, 12.008562F, 79.0F, 12.0F);
      ((Path)localObject).lineTo(79.0F, 12.0F);
      ((Path)localObject).lineTo(79.0F, 12.0F);
      ((Path)localObject).cubicTo(77.960457F, 12.046865F, 77.32959F, 12.18205F, 77.0F, 12.0F);
      ((Path)localObject).lineTo(49.0F, 18.0F);
      ((Path)localObject).lineTo(20.0F, 12.0F);
      ((Path)localObject).cubicTo(19.670408F, 12.18205F, 19.039543F, 12.046865F, 18.0F, 12.0F);
      ((Path)localObject).lineTo(18.0F, 12.0F);
      ((Path)localObject).lineTo(18.0F, 12.0F);
      ((Path)localObject).cubicTo(18.233389F, 12.008562F, 18.159487F, 12.0F, 18.0F, 12.0F);
      ((Path)localObject).cubicTo(14.723531F, 12.0F, 12.0F, 14.723531F, 12.0F, 18.0F);
      ((Path)localObject).cubicTo(12.0F, 18.159487F, 12.008562F, 18.233389F, 12.0F, 18.0F);
      ((Path)localObject).lineTo(12.0F, 18.0F);
      ((Path)localObject).lineTo(12.0F, 72.0F);
      ((Path)localObject).lineTo(12.0F, 72.0F);
      ((Path)localObject).cubicTo(12.008562F, 72.45797F, 12.0F, 72.531868F, 12.0F, 73.0F);
      ((Path)localObject).cubicTo(12.0F, 75.967827F, 14.723531F, 78.69136F, 18.0F, 79.0F);
      ((Path)localObject).cubicTo(18.159487F, 78.69136F, 18.233389F, 78.682793F, 18.0F, 79.0F);
      ((Path)localObject).lineTo(18.0F, 79.0F);
      ((Path)localObject).lineTo(49.0F, 85.0F);
      ((Path)localObject).lineTo(79.0F, 79.0F);
      ((Path)localObject).lineTo(79.0F, 79.0F);
      ((Path)localObject).cubicTo(78.766609F, 78.682793F, 78.840515F, 78.69136F, 79.0F, 79.0F);
      ((Path)localObject).cubicTo(82.276466F, 78.69136F, 85.0F, 75.967827F, 85.0F, 73.0F);
      ((Path)localObject).cubicTo(85.0F, 72.531868F, 84.99144F, 72.45797F, 85.0F, 72.0F);
      ((Path)localObject).lineTo(85.0F, 72.0F);
      ((Path)localObject).lineTo(85.0F, 18.0F);
      ((Path)localObject).lineTo(85.0F, 18.0F);
      ((Path)localObject).cubicTo(84.99144F, 18.233389F, 85.0F, 18.159487F, 85.0F, 18.0F);
      ((Path)localObject).lineTo(85.0F, 18.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.mo
 * JD-Core Version:    0.7.0.1
 */