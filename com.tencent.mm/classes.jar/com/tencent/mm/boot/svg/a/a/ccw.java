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

public final class ccw
  extends c
{
  private final int height = 265;
  private final int width = 222;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 222;
      return 265;
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
      localCanvas.saveLayerAlpha(null, 25, 31);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 0.6293204F, -0.777146F, 114.51628F, 0.777146F, 0.6293204F, 1.104701F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(129.86819F, 161.85629F);
      ((Path)localObject2).lineTo(40.530926F, 161.85629F);
      ((Path)localObject2).cubicTo(26.720047F, 141.8038F, 1.136868E-012F, 120.81583F, 1.136868E-012F, 86.323357F);
      ((Path)localObject2).cubicTo(1.136868E-012F, 38.648285F, 38.145142F, -1.409827E-012F, 85.199554F, -1.392664E-012F);
      ((Path)localObject2).cubicTo(132.25397F, -1.390268E-012F, 170.39911F, 38.648285F, 170.39911F, 86.323357F);
      ((Path)localObject2).cubicTo(170.39911F, 120.81583F, 143.67906F, 141.8038F, 129.86819F, 161.85629F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(55.379711F, 173.21463F);
      ((Path)localObject2).lineTo(115.0194F, 173.21463F);
      ((Path)localObject2).cubicTo(117.37212F, 173.21463F, 119.27938F, 175.12161F, 119.27938F, 177.47401F);
      ((Path)localObject2).lineTo(119.27938F, 180.3136F);
      ((Path)localObject2).cubicTo(119.27938F, 182.66599F, 117.37212F, 184.57297F, 115.0194F, 184.57297F);
      ((Path)localObject2).lineTo(55.379711F, 184.57297F);
      ((Path)localObject2).cubicTo(53.026993F, 184.57297F, 51.119732F, 182.66599F, 51.119732F, 180.3136F);
      ((Path)localObject2).lineTo(51.119732F, 177.47401F);
      ((Path)localObject2).cubicTo(51.119732F, 175.12161F, 53.026993F, 173.21463F, 55.379711F, 173.21463F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(63.899666F, 195.9313F);
      ((Path)localObject2).lineTo(106.49944F, 195.9313F);
      ((Path)localObject2).cubicTo(108.85217F, 195.9313F, 110.75942F, 197.83829F, 110.75942F, 200.19069F);
      ((Path)localObject2).lineTo(110.75942F, 203.03027F);
      ((Path)localObject2).cubicTo(110.75942F, 205.38266F, 108.85217F, 207.28964F, 106.49944F, 207.28964F);
      ((Path)localObject2).lineTo(63.899666F, 207.28964F);
      ((Path)localObject2).cubicTo(61.546947F, 207.28964F, 59.63969F, 205.38266F, 59.63969F, 203.03027F);
      ((Path)localObject2).lineTo(59.63969F, 200.19069F);
      ((Path)localObject2).cubicTo(59.63969F, 197.83829F, 61.546947F, 195.9313F, 63.899666F, 195.9313F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(87.992531F, 105.08893F);
      ((Path)localObject2).cubicTo(90.352364F, 109.80792F, 97.086662F, 109.80792F, 99.446495F, 105.08893F);
      ((Path)localObject2).lineTo(110.75942F, 82.466263F);
      ((Path)localObject2).lineTo(122.07235F, 105.08893F);
      ((Path)localObject2).cubicTo(123.65404F, 108.25185F, 127.50031F, 109.5337F, 130.66322F, 107.95201F);
      ((Path)localObject2).cubicTo(133.82616F, 106.37032F, 135.108F, 102.52406F, 133.52632F, 99.36113F);
      ((Path)localObject2).lineTo(116.4864F, 65.286125F);
      ((Path)localObject2).cubicTo(114.12657F, 60.567127F, 107.39227F, 60.567127F, 105.03244F, 65.286125F);
      ((Path)localObject2).lineTo(93.719513F, 87.908783F);
      ((Path)localObject2).lineTo(82.406586F, 65.286125F);
      ((Path)localObject2).cubicTo(80.046753F, 60.567127F, 73.312447F, 60.567127F, 70.952621F, 65.286125F);
      ((Path)localObject2).lineTo(59.63969F, 87.908783F);
      ((Path)localObject2).lineTo(48.326759F, 65.286125F);
      ((Path)localObject2).cubicTo(46.745075F, 62.123199F, 42.898808F, 60.841351F, 39.735882F, 62.423038F);
      ((Path)localObject2).cubicTo(36.572956F, 64.004723F, 35.291111F, 67.85099F, 36.872795F, 71.013916F);
      ((Path)localObject2).lineTo(53.912708F, 105.08893F);
      ((Path)localObject2).cubicTo(56.272537F, 109.80792F, 63.00684F, 109.80792F, 65.366669F, 105.08893F);
      ((Path)localObject2).lineTo(76.679604F, 82.466263F);
      ((Path)localObject2).lineTo(87.992531F, 105.08893F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ccw
 * JD-Core Version:    0.7.0.1
 */