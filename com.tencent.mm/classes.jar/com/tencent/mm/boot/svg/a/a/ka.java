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

public final class ka
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
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8683387);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(44.0F, 26.0F);
      ((Path)localObject2).lineTo(38.0F, 32.0F);
      ((Path)localObject2).cubicTo(38.86063F, 32.187641F, 39.391327F, 32.618652F, 40.0F, 33.0F);
      ((Path)localObject2).cubicTo(43.856228F, 37.084045F, 43.856228F, 43.524426F, 40.0F, 47.0F);
      ((Path)localObject2).lineTo(25.0F, 62.0F);
      ((Path)localObject2).cubicTo(21.528116F, 65.855446F, 15.087992F, 65.855446F, 11.0F, 62.0F);
      ((Path)localObject2).cubicTo(7.143773F, 57.910351F, 7.143773F, 51.469517F, 11.0F, 47.0F);
      ((Path)localObject2).lineTo(16.0F, 43.0F);
      ((Path)localObject2).cubicTo(14.604678F, 39.432732F, 14.147989F, 35.501705F, 15.0F, 32.0F);
      ((Path)localObject2).lineTo(5.0F, 42.0F);
      ((Path)localObject2).cubicTo(-1.787382F, 48.893364F, -1.787382F, 60.486504F, 5.0F, 68.0F);
      ((Path)localObject2).cubicTo(12.512122F, 74.787575F, 24.103985F, 74.787575F, 31.0F, 68.0F);
      ((Path)localObject2).lineTo(46.0F, 53.0F);
      ((Path)localObject2).cubicTo(52.78738F, 46.101028F, 52.78738F, 34.507442F, 46.0F, 27.0F);
      ((Path)localObject2).cubicTo(45.151382F, 26.870602F, 44.642796F, 26.420181F, 44.0F, 26.0F);
      ((Path)localObject2).moveTo(68.0F, 5.0F);
      ((Path)localObject2).cubicTo(60.488327F, -1.787578F, 48.896015F, -1.787578F, 42.0F, 5.0F);
      ((Path)localObject2).lineTo(27.0F, 20.0F);
      ((Path)localObject2).cubicTo(20.212618F, 26.898972F, 20.212618F, 38.492558F, 27.0F, 46.0F);
      ((Path)localObject2).cubicTo(27.848618F, 46.129398F, 28.357655F, 46.579819F, 29.0F, 47.0F);
      ((Path)localObject2).lineTo(35.0F, 41.0F);
      ((Path)localObject2).cubicTo(34.13982F, 40.812359F, 33.608673F, 40.381348F, 33.0F, 40.0F);
      ((Path)localObject2).cubicTo(29.143772F, 35.915955F, 29.143772F, 29.475574F, 33.0F, 26.0F);
      ((Path)localObject2).lineTo(48.0F, 11.0F);
      ((Path)localObject2).cubicTo(51.472336F, 7.144558F, 57.91201F, 7.144558F, 62.0F, 11.0F);
      ((Path)localObject2).cubicTo(65.856224F, 15.08965F, 65.856224F, 21.530483F, 62.0F, 26.0F);
      ((Path)localObject2).lineTo(57.0F, 30.0F);
      ((Path)localObject2).cubicTo(58.395775F, 33.567268F, 58.852013F, 37.498295F, 58.0F, 41.0F);
      ((Path)localObject2).lineTo(68.0F, 31.0F);
      ((Path)localObject2).cubicTo(74.787384F, 24.106634F, 74.787384F, 12.513497F, 68.0F, 5.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ka
 * JD-Core Version:    0.7.0.1
 */