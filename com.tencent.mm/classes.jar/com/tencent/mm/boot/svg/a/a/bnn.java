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

public final class bnn
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      localPaint.setColor(-16268960);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(96.0F, 176.0F);
      ((Path)localObject).cubicTo(51.817219F, 176.0F, 16.0F, 140.18279F, 16.0F, 96.0F);
      ((Path)localObject).cubicTo(16.0F, 51.817219F, 51.817219F, 16.0F, 96.0F, 16.0F);
      ((Path)localObject).cubicTo(140.18279F, 16.0F, 176.0F, 51.817219F, 176.0F, 96.0F);
      ((Path)localObject).cubicTo(176.0F, 140.18279F, 140.18279F, 176.0F, 96.0F, 176.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(86.587502F, 113.11453F);
      ((Path)localObject).lineTo(64.460304F, 90.987335F);
      ((Path)localObject).lineTo(56.0F, 99.447639F);
      ((Path)localObject).lineTo(80.95047F, 124.41615F);
      ((Path)localObject).cubicTo(80.94989F, 124.41731F, 80.95018F, 124.4176F, 80.95047F, 124.41789F);
      ((Path)localObject).cubicTo(84.07402F, 127.54274F, 89.139336F, 127.54379F, 92.263313F, 124.41937F);
      ((Path)localObject).lineTo(139.88225F, 76.820221F);
      ((Path)localObject).lineTo(131.38203F, 68.32F);
      ((Path)localObject).lineTo(86.587502F, 113.11453F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bnn
 * JD-Core Version:    0.7.0.1
 */