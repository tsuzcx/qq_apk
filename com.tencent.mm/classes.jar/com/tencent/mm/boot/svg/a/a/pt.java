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

public final class pt
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localPaint2.setColor(-12206054);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.lineTo(108.0F, 108.0F);
      localPath.lineTo(0.0F, 108.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 18.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(47.704567F, 7.103272F);
      ((Path)localObject2).cubicTo(48.198116F, 7.035328F, 48.706787F, 7.0F, 49.229694F, 7.0F);
      ((Path)localObject2).cubicTo(56.058342F, 7.0F, 60.459389F, 13.02472F, 60.459389F, 19.03764F);
      ((Path)localObject2).cubicTo(60.459389F, 24.831484F, 58.489338F, 26.307079F, 56.180534F, 29.742367F);
      ((Path)localObject2).cubicTo(53.121593F, 34.293007F, 57.841705F, 36.268681F, 60.119278F, 37.523205F);
      ((Path)localObject2).cubicTo(68.294106F, 42.027901F, 72.0F, 43.773842F, 72.0F, 46.117085F);
      ((Path)localObject2).lineTo(72.0F, 49.046967F);
      ((Path)localObject2).cubicTo(72.0F, 50.137016F, 71.228813F, 51.0F, 70.019768F, 51.0F);
      ((Path)localObject2).lineTo(64.71711F, 51.0F);
      ((Path)localObject2).cubicTo(64.658745F, 48.052181F, 60.147499F, 45.825893F, 50.273735F, 40.140404F);
      ((Path)localObject2).cubicTo(47.504784F, 38.546654F, 41.766323F, 36.036751F, 45.485222F, 30.255606F);
      ((Path)localObject2).cubicTo(48.292141F, 25.891405F, 50.687222F, 24.016804F, 50.687222F, 16.656288F);
      ((Path)localObject2).cubicTo(50.687222F, 13.247847F, 49.62196F, 9.83642F, 47.704567F, 7.103272F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(15.0F, 16.0F);
      ((Path)localObject2).cubicTo(14.951405F, 24.315659F, 17.503698F, 26.327835F, 20.0F, 31.0F);
      ((Path)localObject2).cubicTo(24.457859F, 37.217739F, 18.342735F, 39.911839F, 15.0F, 42.0F);
      ((Path)localObject2).cubicTo(4.80116F, 47.765316F, 0.0F, 50.146149F, 0.0F, 53.0F);
      ((Path)localObject2).lineTo(0.0F, 57.0F);
      ((Path)localObject2).cubicTo(0.0F, 58.823204F, 0.9991056F, 60.0F, 3.0F, 60.0F);
      ((Path)localObject2).lineTo(56.0F, 60.0F);
      ((Path)localObject2).cubicTo(58.000893F, 60.0F, 59.0F, 58.823204F, 59.0F, 57.0F);
      ((Path)localObject2).lineTo(59.0F, 53.0F);
      ((Path)localObject2).cubicTo(59.0F, 50.146149F, 54.198841F, 47.765316F, 44.0F, 42.0F);
      ((Path)localObject2).cubicTo(40.657265F, 39.911839F, 34.542141F, 37.217739F, 39.0F, 31.0F);
      ((Path)localObject2).cubicTo(41.496304F, 26.327835F, 44.048595F, 24.315659F, 44.0F, 16.0F);
      ((Path)localObject2).cubicTo(44.048595F, 8.215528F, 38.346832F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject2).cubicTo(20.653166F, 0.0F, 14.951405F, 8.215528F, 15.0F, 16.0F);
      ((Path)localObject2).lineTo(15.0F, 16.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pt
 * JD-Core Version:    0.7.0.1
 */