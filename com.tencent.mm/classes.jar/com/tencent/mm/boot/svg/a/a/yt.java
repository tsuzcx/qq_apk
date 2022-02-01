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

public final class yt
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
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
      localPaint2.setColor(-855310);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(90.0F, 0.0F);
      localPath.lineTo(90.0F, 90.0F);
      localPath.lineTo(0.0F, 90.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-10461088);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 17.0F, 0.0F, 1.0F, 17.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(39.676689F, 30.311752F);
      ((Path)localObject2).lineTo(39.126198F, 30.32066F);
      ((Path)localObject2).cubicTo(37.461704F, 30.32066F, 36.493164F, 29.099634F, 37.118885F, 27.691906F);
      ((Path)localObject2).cubicTo(37.547375F, 26.692091F, 38.514095F, 25.919941F, 39.655792F, 25.666336F);
      ((Path)localObject2).cubicTo(42.710411F, 24.929014F, 44.785835F, 22.541672F, 44.785835F, 19.766241F);
      ((Path)localObject2).cubicTo(44.785835F, 16.401402F, 41.573277F, 13.659318F, 37.560703F, 13.659318F);
      ((Path)localObject2).cubicTo(33.54813F, 13.659318F, 30.335569F, 16.401402F, 30.335569F, 19.766241F);
      ((Path)localObject2).lineTo(30.335569F, 36.539402F);
      ((Path)localObject2).cubicTo(30.335569F, 42.447212F, 25.055094F, 47.205643F, 18.551119F, 47.205643F);
      ((Path)localObject2).cubicTo(12.047142F, 47.205643F, 6.766667F, 42.447212F, 6.766667F, 36.539402F);
      ((Path)localObject2).cubicTo(6.766667F, 31.359217F, 10.855467F, 26.937546F, 16.426517F, 26.096806F);
      ((Path)localObject2).lineTo(16.873802F, 26.096806F);
      ((Path)localObject2).cubicTo(18.133951F, 26.096806F, 19.041639F, 26.851173F, 19.041639F, 27.928501F);
      ((Path)localObject2).cubicTo(19.042177F, 28.1131F, 19.037693F, 28.198402F, 19.019466F, 28.307756F);
      ((Path)localObject2).cubicTo(18.994898F, 28.455172F, 18.947058F, 28.59627F, 18.881117F, 28.725559F);
      ((Path)localObject2).cubicTo(18.479496F, 29.662674F, 17.452799F, 30.474003F, 16.34421F, 30.751129F);
      ((Path)localObject2).cubicTo(13.311659F, 31.483124F, 11.214164F, 33.855888F, 11.214164F, 36.539402F);
      ((Path)localObject2).cubicTo(11.214164F, 39.904243F, 14.426723F, 42.646324F, 18.439297F, 42.646324F);
      ((Path)localObject2).cubicTo(22.451872F, 42.646324F, 25.664431F, 39.904243F, 25.664431F, 36.539402F);
      ((Path)localObject2).lineTo(25.664431F, 19.766241F);
      ((Path)localObject2).cubicTo(25.664431F, 13.858431F, 30.944906F, 9.1F, 37.448883F, 9.1F);
      ((Path)localObject2).cubicTo(43.952858F, 9.1F, 49.233334F, 13.858431F, 49.233334F, 19.766241F);
      ((Path)localObject2).cubicTo(49.233334F, 24.97393F, 45.240711F, 29.344097F, 39.676689F, 30.311752F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.yt
 * JD-Core Version:    0.7.0.1
 */