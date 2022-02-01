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

public final class uw
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-14187817);
      Path localPath = c.n(paramVarArgs);
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
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(7.5F, 60.0F);
      ((Path)localObject2).lineTo(7.5F, 57.946388F);
      ((Path)localObject2).cubicTo(7.5F, 55.891125F, 8.994453F, 53.495724F, 10.842293F, 52.593998F);
      ((Path)localObject2).lineTo(27.823353F, 44.30743F);
      ((Path)localObject2).cubicTo(30.286131F, 43.105621F, 30.858778F, 40.443787F, 29.080336F, 38.335918F);
      ((Path)localObject2).lineTo(27.995739F, 37.050415F);
      ((Path)localObject2).cubicTo(25.788954F, 34.434856F, 24.0F, 29.548489F, 24.0F, 26.127872F);
      ((Path)localObject2).lineTo(24.0F, 20.998741F);
      ((Path)localObject2).cubicTo(24.0F, 14.37202F, 29.386068F, 9.0F, 36.0F, 9.0F);
      ((Path)localObject2).cubicTo(42.627419F, 9.0F, 48.0F, 14.378941F, 48.0F, 21.000622F);
      ((Path)localObject2).lineTo(48.0F, 26.130558F);
      ((Path)localObject2).cubicTo(48.0F, 29.547888F, 46.202797F, 34.448582F, 44.004261F, 37.054718F);
      ((Path)localObject2).lineTo(42.919662F, 38.340397F);
      ((Path)localObject2).cubicTo(41.151096F, 40.436852F, 41.703564F, 43.105194F, 44.176647F, 44.311531F);
      ((Path)localObject2).lineTo(61.157707F, 52.594673F);
      ((Path)localObject2).cubicTo(63.003605F, 53.495079F, 64.5F, 55.875511F, 64.5F, 57.946388F);
      ((Path)localObject2).lineTo(64.5F, 60.0F);
      ((Path)localObject2).cubicTo(64.5F, 61.656853F, 63.156853F, 63.0F, 61.5F, 63.0F);
      ((Path)localObject2).lineTo(10.5F, 63.0F);
      ((Path)localObject2).cubicTo(8.843145F, 63.0F, 7.5F, 61.656853F, 7.5F, 60.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.0F, 54.0F);
      ((Path)localObject2).lineTo(36.0F, 57.0F);
      ((Path)localObject2).lineTo(39.0F, 54.0F);
      ((Path)localObject2).lineTo(36.0F, 45.0F);
      ((Path)localObject2).lineTo(33.0F, 54.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.uw
 * JD-Core Version:    0.7.0.1
 */