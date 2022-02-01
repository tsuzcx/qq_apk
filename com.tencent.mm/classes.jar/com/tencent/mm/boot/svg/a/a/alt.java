package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class alt
  extends c
{
  private final int height = 92;
  private final int width = 92;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 92;
      return 92;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-13421773);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -121.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 121.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(15.333333F, 50.599998F);
      ((Path)localObject2).lineTo(43.699333F, 50.599335F);
      ((Path)localObject2).lineTo(43.700001F, 80.5F);
      ((Path)localObject2).lineTo(48.299999F, 80.5F);
      ((Path)localObject2).lineTo(48.299332F, 50.599335F);
      ((Path)localObject2).lineTo(76.666664F, 50.599998F);
      ((Path)localObject2).lineTo(76.666664F, 76.5F);
      ((Path)localObject2).cubicTo(76.666664F, 78.709137F, 74.875809F, 80.5F, 72.666664F, 80.5F);
      ((Path)localObject2).lineTo(19.333334F, 80.5F);
      ((Path)localObject2).cubicTo(17.124195F, 80.5F, 15.333333F, 78.709137F, 15.333333F, 76.5F);
      ((Path)localObject2).lineTo(15.333333F, 50.599998F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(55.583332F, 11.5F);
      ((Path)localObject2).cubicTo(60.87606F, 11.5F, 65.166664F, 15.790605F, 65.166664F, 21.083334F);
      ((Path)localObject2).cubicTo(65.166664F, 23.241062F, 64.45356F, 25.232237F, 63.250172F, 26.83404F);
      ((Path)localObject2).lineTo(76.5F, 26.833334F);
      ((Path)localObject2).cubicTo(78.709137F, 26.833334F, 80.5F, 28.624195F, 80.5F, 30.833334F);
      ((Path)localObject2).lineTo(80.5F, 42.0F);
      ((Path)localObject2).cubicTo(80.5F, 44.153297F, 78.798531F, 45.909195F, 76.666702F, 45.99659F);
      ((Path)localObject2).lineTo(76.666664F, 46.0F);
      ((Path)localObject2).lineTo(48.299332F, 45.999332F);
      ((Path)localObject2).lineTo(48.299999F, 26.833334F);
      ((Path)localObject2).lineTo(43.700001F, 26.833334F);
      ((Path)localObject2).lineTo(43.699333F, 45.999332F);
      ((Path)localObject2).lineTo(15.333333F, 46.0F);
      ((Path)localObject2).lineTo(15.333F, 45.995335F);
      ((Path)localObject2).lineTo(15.30036F, 45.995106F);
      ((Path)localObject2).cubicTo(13.183969F, 45.891079F, 11.5F, 44.142197F, 11.5F, 42.0F);
      ((Path)localObject2).lineTo(11.5F, 30.833334F);
      ((Path)localObject2).cubicTo(11.5F, 28.624195F, 13.290861F, 26.833334F, 15.5F, 26.833334F);
      ((Path)localObject2).lineTo(28.749828F, 26.83404F);
      ((Path)localObject2).cubicTo(27.546438F, 25.232237F, 26.833334F, 23.241062F, 26.833334F, 21.083334F);
      ((Path)localObject2).cubicTo(26.833334F, 15.790605F, 31.123938F, 11.5F, 36.416668F, 11.5F);
      ((Path)localObject2).cubicTo(41.570114F, 11.5F, 45.773483F, 15.567755F, 45.991146F, 20.667627F);
      ((Path)localObject2).lineTo(46.0F, 21.059999F);
      ((Path)localObject2).lineTo(46.008854F, 20.667627F);
      ((Path)localObject2).cubicTo(46.22263F, 15.658824F, 50.281036F, 11.645606F, 55.308182F, 11.503874F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.416668F, 16.1F);
      ((Path)localObject2).cubicTo(33.664448F, 16.1F, 31.433332F, 18.331114F, 31.433332F, 21.083334F);
      ((Path)localObject2).cubicTo(31.433332F, 23.835552F, 33.664448F, 26.066668F, 36.416668F, 26.066668F);
      ((Path)localObject2).lineTo(41.400505F, 26.066668F);
      ((Path)localObject2).lineTo(41.401043F, 21.181286F);
      ((Path)localObject2).lineTo(41.395329F, 20.863777F);
      ((Path)localObject2).cubicTo(41.281971F, 18.207777F, 39.087807F, 16.1F, 36.416668F, 16.1F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(55.583332F, 16.1F);
      ((Path)localObject2).cubicTo(52.912193F, 16.1F, 50.718029F, 18.207777F, 50.604671F, 20.863777F);
      ((Path)localObject2).lineTo(50.604671F, 20.863777F);
      ((Path)localObject2).lineTo(50.598957F, 21.181286F);
      ((Path)localObject2).lineTo(50.599495F, 26.066668F);
      ((Path)localObject2).lineTo(55.583332F, 26.066668F);
      ((Path)localObject2).cubicTo(58.335552F, 26.066668F, 60.566666F, 23.835552F, 60.566666F, 21.083334F);
      ((Path)localObject2).cubicTo(60.566666F, 18.331114F, 58.335552F, 16.1F, 55.583332F, 16.1F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.alt
 * JD-Core Version:    0.7.0.1
 */