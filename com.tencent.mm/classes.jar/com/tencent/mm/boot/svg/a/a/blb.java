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

public final class blb
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
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      Paint localPaint2 = c.a(localPaint1, paramVarArgs);
      Paint localPaint3 = c.a((Paint)localObject, paramVarArgs);
      localPaint2.setColor(-2565928);
      localPaint3.setColor(-6842473);
      localPaint3.setStrokeWidth(4.8F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(2.4F, 2.4F);
      ((Path)localObject).lineTo(93.599998F, 2.4F);
      ((Path)localObject).lineTo(93.599998F, 93.599998F);
      ((Path)localObject).lineTo(2.4F, 93.599998F);
      ((Path)localObject).lineTo(2.4F, 2.4F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint3 = c.a(localPaint3, paramVarArgs);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.drawPath((Path)localObject, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(68.616692F, 18.0F);
      ((Path)localObject).cubicTo(73.965797F, 18.0F, 75.905518F, 18.556953F, 77.861076F, 19.602797F);
      ((Path)localObject).cubicTo(79.816628F, 20.64864F, 81.351364F, 22.183371F, 82.397202F, 24.138926F);
      ((Path)localObject).cubicTo(83.443047F, 26.094481F, 84.0F, 28.034199F, 84.0F, 33.383312F);
      ((Path)localObject).lineTo(84.0F, 62.616688F);
      ((Path)localObject).cubicTo(84.0F, 67.965797F, 83.443047F, 69.905518F, 82.397202F, 71.861076F);
      ((Path)localObject).cubicTo(81.351364F, 73.816628F, 79.816628F, 75.351364F, 77.861076F, 76.397202F);
      ((Path)localObject).cubicTo(75.905518F, 77.443047F, 73.965797F, 78.0F, 68.616692F, 78.0F);
      ((Path)localObject).lineTo(27.38331F, 78.0F);
      ((Path)localObject).cubicTo(22.034199F, 78.0F, 20.094481F, 77.443047F, 18.138926F, 76.397202F);
      ((Path)localObject).cubicTo(16.183371F, 75.351364F, 14.648639F, 73.816628F, 13.602797F, 71.861076F);
      ((Path)localObject).cubicTo(12.556953F, 69.905518F, 12.0F, 67.965797F, 12.0F, 62.616688F);
      ((Path)localObject).lineTo(12.0F, 33.383312F);
      ((Path)localObject).cubicTo(12.0F, 28.034199F, 12.556953F, 26.094481F, 13.602797F, 24.138926F);
      ((Path)localObject).cubicTo(14.648639F, 22.183371F, 16.183371F, 20.64864F, 18.138926F, 19.602797F);
      ((Path)localObject).cubicTo(20.094481F, 18.556953F, 22.034199F, 18.0F, 27.38331F, 18.0F);
      ((Path)localObject).lineTo(68.616692F, 18.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(43.216F, 31.68F);
      ((Path)localObject).cubicTo(41.890518F, 31.68F, 40.815998F, 32.754517F, 40.815998F, 34.080002F);
      ((Path)localObject).lineTo(40.815998F, 34.080002F);
      ((Path)localObject).lineTo(40.815998F, 61.919998F);
      ((Path)localObject).cubicTo(40.815998F, 63.245483F, 41.890518F, 64.32F, 43.216F, 64.32F);
      ((Path)localObject).cubicTo(44.541485F, 64.32F, 45.616001F, 63.245483F, 45.616001F, 61.919998F);
      ((Path)localObject).lineTo(45.616001F, 61.919998F);
      ((Path)localObject).lineTo(45.616001F, 34.080002F);
      ((Path)localObject).cubicTo(45.616001F, 32.754517F, 44.541485F, 31.68F, 43.216F, 31.68F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(62.416F, 38.400002F);
      ((Path)localObject).cubicTo(61.090515F, 38.400002F, 60.015999F, 39.474518F, 60.015999F, 40.799999F);
      ((Path)localObject).lineTo(60.015999F, 40.799999F);
      ((Path)localObject).lineTo(60.015999F, 55.200001F);
      ((Path)localObject).cubicTo(60.015999F, 56.525482F, 61.090515F, 57.599998F, 62.416F, 57.599998F);
      ((Path)localObject).cubicTo(63.741482F, 57.599998F, 64.816002F, 56.525482F, 64.816002F, 55.200001F);
      ((Path)localObject).lineTo(64.816002F, 55.200001F);
      ((Path)localObject).lineTo(64.816002F, 40.799999F);
      ((Path)localObject).cubicTo(64.816002F, 39.474518F, 63.741482F, 38.400002F, 62.416F, 38.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.616001F, 38.400002F);
      ((Path)localObject).cubicTo(32.290516F, 38.400002F, 31.216F, 39.474518F, 31.216F, 40.799999F);
      ((Path)localObject).lineTo(31.216F, 40.799999F);
      ((Path)localObject).lineTo(31.216F, 55.200001F);
      ((Path)localObject).cubicTo(31.216F, 56.525482F, 32.290516F, 57.599998F, 33.616001F, 57.599998F);
      ((Path)localObject).cubicTo(34.941483F, 57.599998F, 36.015999F, 56.525482F, 36.015999F, 55.200001F);
      ((Path)localObject).lineTo(36.015999F, 55.200001F);
      ((Path)localObject).lineTo(36.015999F, 40.799999F);
      ((Path)localObject).cubicTo(36.015999F, 39.474518F, 34.941483F, 38.400002F, 33.616001F, 38.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(52.815998F, 40.799999F);
      ((Path)localObject).cubicTo(51.490517F, 40.799999F, 50.416F, 41.874516F, 50.416F, 43.200001F);
      ((Path)localObject).lineTo(50.416F, 43.200001F);
      ((Path)localObject).lineTo(50.416F, 52.799999F);
      ((Path)localObject).cubicTo(50.416F, 54.125484F, 51.490517F, 55.200001F, 52.815998F, 55.200001F);
      ((Path)localObject).cubicTo(54.141483F, 55.200001F, 55.216F, 54.125484F, 55.216F, 52.799999F);
      ((Path)localObject).lineTo(55.216F, 52.799999F);
      ((Path)localObject).lineTo(55.216F, 43.200001F);
      ((Path)localObject).cubicTo(55.216F, 41.874516F, 54.141483F, 40.799999F, 52.815998F, 40.799999F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.blb
 * JD-Core Version:    0.7.0.1
 */