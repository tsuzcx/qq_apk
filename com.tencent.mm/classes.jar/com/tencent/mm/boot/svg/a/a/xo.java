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

public final class xo
  extends c
{
  private final int height = 405;
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
      return 405;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint1.setColor(-1);
      localPaint2.setColor(838860800);
      localPaint2.setStrokeWidth(1.5F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(191.25F, 381.0F);
      localPath.lineTo(191.25F, 48.0F);
      localPath.cubicTo(191.25F, 21.904545F, 170.09546F, 0.75F, 144.0F, 0.75F);
      localPath.lineTo(48.0F, 0.75F);
      localPath.cubicTo(21.904545F, 0.75F, 0.75F, 21.904545F, 0.75F, 48.0F);
      localPath.lineTo(0.75F, 180.0F);
      localPath.cubicTo(0.75F, 194.87228F, 7.752174F, 208.87663F, 19.65F, 217.8F);
      localPath.lineTo(53.25F, 243.0F);
      localPath.cubicTo(65.525536F, 252.20665F, 72.75F, 266.65558F, 72.75F, 282.0F);
      localPath.lineTo(72.75F, 381.0F);
      localPath.cubicTo(72.75F, 393.84061F, 83.159378F, 404.25F, 96.0F, 404.25F);
      localPath.lineTo(168.0F, 404.25F);
      localPath.cubicTo(180.84062F, 404.25F, 191.25F, 393.84061F, 191.25F, 381.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xo
 * JD-Core Version:    0.7.0.1
 */