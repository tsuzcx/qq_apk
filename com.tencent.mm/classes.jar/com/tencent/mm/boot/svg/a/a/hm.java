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

public final class hm
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-10197008);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.cubicTo(114.62742F, 0.0F, 120.0F, 5.372582F, 120.0F, 12.0F);
      localPath.lineTo(120.0F, 108.0F);
      localPath.cubicTo(120.0F, 114.62742F, 114.62742F, 120.0F, 108.0F, 120.0F);
      localPath.lineTo(12.0F, 120.0F);
      localPath.cubicTo(5.372582F, 120.0F, 0.0F, 114.62742F, 0.0F, 108.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(50.71693F, 17.040428F);
      ((Path)localObject2).cubicTo(46.652882F, 13.881245F, 41.546135F, 12.0F, 36.0F, 12.0F);
      ((Path)localObject2).cubicTo(22.745167F, 12.0F, 12.0F, 22.745167F, 12.0F, 36.0F);
      ((Path)localObject2).cubicTo(12.0F, 49.254833F, 22.745167F, 60.0F, 36.0F, 60.0F);
      ((Path)localObject2).cubicTo(49.254833F, 60.0F, 60.0F, 49.254833F, 60.0F, 36.0F);
      ((Path)localObject2).cubicTo(60.0F, 30.453865F, 58.118755F, 25.34712F, 54.959572F, 21.283068F);
      ((Path)localObject2).lineTo(50.672245F, 25.570396F);
      ((Path)localObject2).cubicTo(52.767628F, 28.512854F, 54.0F, 32.112507F, 54.0F, 36.0F);
      ((Path)localObject2).cubicTo(54.0F, 45.941124F, 45.941124F, 54.0F, 36.0F, 54.0F);
      ((Path)localObject2).cubicTo(26.058874F, 54.0F, 18.0F, 45.941124F, 18.0F, 36.0F);
      ((Path)localObject2).cubicTo(18.0F, 26.058874F, 26.058874F, 18.0F, 36.0F, 18.0F);
      ((Path)localObject2).cubicTo(39.887493F, 18.0F, 43.487148F, 19.232372F, 46.429604F, 21.327757F);
      ((Path)localObject2).lineTo(50.71693F, 17.040428F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(42.095901F, 25.661457F);
      ((Path)localObject2).cubicTo(40.309361F, 24.605787F, 38.225426F, 24.0F, 36.0F, 24.0F);
      ((Path)localObject2).cubicTo(29.372583F, 24.0F, 24.0F, 29.372583F, 24.0F, 36.0F);
      ((Path)localObject2).cubicTo(24.0F, 42.627419F, 29.372583F, 48.0F, 36.0F, 48.0F);
      ((Path)localObject2).cubicTo(42.627419F, 48.0F, 48.0F, 42.627419F, 48.0F, 36.0F);
      ((Path)localObject2).cubicTo(48.0F, 33.774574F, 47.394211F, 31.690638F, 46.338543F, 29.904099F);
      ((Path)localObject2).lineTo(41.796772F, 34.445869F);
      ((Path)localObject2).cubicTo(41.929329F, 34.941551F, 42.0F, 35.462521F, 42.0F, 36.0F);
      ((Path)localObject2).cubicTo(42.0F, 39.313709F, 39.313709F, 42.0F, 36.0F, 42.0F);
      ((Path)localObject2).cubicTo(32.686291F, 42.0F, 30.0F, 39.313709F, 30.0F, 36.0F);
      ((Path)localObject2).cubicTo(30.0F, 32.686291F, 32.686291F, 30.0F, 36.0F, 30.0F);
      ((Path)localObject2).cubicTo(36.537479F, 30.0F, 37.058449F, 30.070671F, 37.554131F, 30.20323F);
      ((Path)localObject2).lineTo(42.095901F, 25.661457F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 66.0F);
      ((Path)localObject2).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject2).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject2).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject2).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.hm
 * JD-Core Version:    0.7.0.1
 */