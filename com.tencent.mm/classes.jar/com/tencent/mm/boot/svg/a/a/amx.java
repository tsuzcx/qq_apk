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

public final class amx
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
      ((Path)localObject).moveTo(38.25F, 56.880878F);
      ((Path)localObject).lineTo(38.25F, 66.0F);
      ((Path)localObject).lineTo(33.75F, 66.0F);
      ((Path)localObject).lineTo(33.75F, 56.880878F);
      ((Path)localObject).cubicTo(23.210026F, 55.75819F, 15.0F, 46.837872F, 15.0F, 36.0F);
      ((Path)localObject).lineTo(15.0F, 30.0F);
      ((Path)localObject).lineTo(19.5F, 30.0F);
      ((Path)localObject).lineTo(19.5F, 36.0F);
      ((Path)localObject).cubicTo(19.5F, 45.112698F, 26.887302F, 52.5F, 36.0F, 52.5F);
      ((Path)localObject).cubicTo(45.112698F, 52.5F, 52.5F, 45.112698F, 52.5F, 36.0F);
      ((Path)localObject).lineTo(52.5F, 30.0F);
      ((Path)localObject).lineTo(57.0F, 30.0F);
      ((Path)localObject).lineTo(57.0F, 36.0F);
      ((Path)localObject).cubicTo(57.0F, 46.837872F, 48.789974F, 55.75819F, 38.25F, 56.880878F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 18.0F);
      ((Path)localObject).cubicTo(24.0F, 11.372583F, 29.372583F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(42.627419F, 6.0F, 48.0F, 11.372583F, 48.0F, 18.0F);
      ((Path)localObject).lineTo(48.0F, 36.0F);
      ((Path)localObject).cubicTo(48.0F, 42.627419F, 42.627419F, 48.0F, 36.0F, 48.0F);
      ((Path)localObject).cubicTo(29.372583F, 48.0F, 24.0F, 42.627419F, 24.0F, 36.0F);
      ((Path)localObject).lineTo(24.0F, 18.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.amx
 * JD-Core Version:    0.7.0.1
 */