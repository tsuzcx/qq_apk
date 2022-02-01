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

public final class zi
  extends c
{
  private final int height = 135;
  private final int width = 135;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 135;
      return 135;
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
      localPaint.setColor(-9207928);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(64.620003F, 0.0F);
      ((Path)localObject).lineTo(69.82F, 0.0F);
      ((Path)localObject).cubicTo(86.019997F, 0.59F, 101.92F, 7.14F, 113.69F, 18.299999F);
      ((Path)localObject).cubicTo(126.52F, 30.190001F, 134.21001F, 47.23F, 135.0F, 64.669998F);
      ((Path)localObject).lineTo(135.0F, 69.699997F);
      ((Path)localObject).cubicTo(134.42999F, 86.650002F, 127.28F, 103.29F, 115.22F, 115.23F);
      ((Path)localObject).cubicTo(103.44F, 127.13F, 87.099998F, 134.22F, 70.389999F, 135.0F);
      ((Path)localObject).lineTo(65.129997F, 135.0F);
      ((Path)localObject).cubicTo(48.950001F, 134.39999F, 33.060001F, 127.85F, 21.299999F, 116.69F);
      ((Path)localObject).cubicTo(8.38F, 104.71F, 0.66F, 87.489998F, 0.0F, 69.900002F);
      ((Path)localObject).lineTo(0.0F, 65.25F);
      ((Path)localObject).cubicTo(0.61F, 47.360001F, 8.58F, 29.83F, 21.860001F, 17.799999F);
      ((Path)localObject).cubicTo(33.419998F, 7.05F, 48.869999F, 0.76F, 64.620003F, 0.0F);
      ((Path)localObject).lineTo(64.620003F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(52.09248F, 46.367477F);
      ((Path)localObject).cubicTo(50.38364F, 46.545963F, 48.854675F, 48.043251F, 49.014568F, 49.81818F);
      ((Path)localObject).cubicTo(48.984589F, 60.358685F, 49.014568F, 70.909111F, 49.004574F, 81.459534F);
      ((Path)localObject).cubicTo(45.456978F, 81.578522F, 41.089939F, 83.492271F, 41.0F, 87.547836F);
      ((Path)localObject).cubicTo(41.039974F, 91.226601F, 44.827404F, 93.120522F, 47.975273F, 93.755135F);
      ((Path)localObject).cubicTo(52.242378F, 95.083855F, 56.289639F, 90.760559F, 55.989841F, 86.685165F);
      ((Path)localObject).cubicTo(56.019821F, 76.54129F, 55.989841F, 66.397415F, 55.999832F, 56.25354F);
      ((Path)localObject).cubicTo(64.663963F, 54.310043F, 73.318092F, 52.336796F, 81.972229F, 50.393295F);
      ((Path)localObject).cubicTo(81.992218F, 59.109295F, 81.982224F, 67.825294F, 81.982224F, 76.54129F);
      ((Path)localObject).cubicTo(78.144821F, 76.333054F, 73.078255F, 78.15757F, 72.978325F, 82.639511F);
      ((Path)localObject).cubicTo(73.467995F, 89.878052F, 86.669044F, 91.0382F, 87.858238F, 83.591431F);
      ((Path)localObject).cubicTo(88.158035F, 70.34391F, 87.868233F, 57.076553F, 87.998146F, 43.819115F);
      ((Path)localObject).cubicTo(87.908203F, 42.420986F, 88.208F, 40.824539F, 87.278633F, 39.624725F);
      ((Path)localObject).cubicTo(86.259323F, 38.662895F, 84.810303F, 39.039696F, 83.591133F, 39.267757F);
      ((Path)localObject).cubicTo(73.098244F, 41.647552F, 62.595364F, 44.017429F, 52.09248F, 46.367477F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.zi
 * JD-Core Version:    0.7.0.1
 */