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

public final class atg
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
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(160.0F, 72.396477F);
      ((Path)localObject).cubicTo(137.05844F, 81.942101F, 91.213402F, 101.04443F, 91.213402F, 101.04443F);
      ((Path)localObject).cubicTo(90.400215F, 101.32394F, 89.523659F, 101.48253F, 88.609077F, 101.48253F);
      ((Path)localObject).cubicTo(87.071411F, 101.48253F, 85.637238F, 101.05037F, 84.443848F, 100.3169F);
      ((Path)localObject).lineTo(68.063843F, 89.372368F);
      ((Path)localObject).cubicTo(67.637184F, 89.07502F, 67.115471F, 88.89859F, 66.540962F, 88.89859F);
      ((Path)localObject).cubicTo(65.138466F, 88.89859F, 64.0F, 89.965088F, 64.0F, 91.281372F);
      ((Path)localObject).cubicTo(64.0F, 91.624313F, 64.092934F, 91.977173F, 64.242905F, 92.288399F);
      ((Path)localObject).lineTo(78.126297F, 120.87781F);
      ((Path)localObject).lineTo(78.457916F, 121.55973F);
      ((Path)localObject).cubicTo(79.328133F, 123.01477F, 80.986198F, 124.0F, 82.893501F, 124.0F);
      ((Path)localObject).cubicTo(83.715141F, 124.0F, 84.490318F, 123.80969F, 85.178886F, 123.48657F);
      ((Path)localObject).lineTo(85.736504F, 123.18327F);
      ((Path)localObject).lineTo(160.0F, 82.982986F);
      ((Path)localObject).lineTo(160.0F, 90.030312F);
      ((Path)localObject).cubicTo(160.0F, 128.80115F, 133.61324F, 162.59669F, 96.0F, 172.0F);
      ((Path)localObject).cubicTo(58.386761F, 162.59669F, 32.0F, 128.80115F, 32.0F, 90.030312F);
      ((Path)localObject).lineTo(32.0F, 44.0F);
      ((Path)localObject).lineTo(96.0F, 20.0F);
      ((Path)localObject).lineTo(160.0F, 44.0F);
      ((Path)localObject).lineTo(160.0F, 72.396477F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.atg
 * JD-Core Version:    0.7.0.1
 */