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

public final class anf
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(51.012886F, 38.972252F);
      ((Path)localObject).lineTo(50.305111F, 38.983707F);
      ((Path)localObject).cubicTo(48.165051F, 38.983707F, 46.919781F, 37.413818F, 47.724277F, 35.603878F);
      ((Path)localObject).cubicTo(48.275196F, 34.318401F, 49.518124F, 33.325638F, 50.986015F, 32.999577F);
      ((Path)localObject).cubicTo(54.913383F, 32.05159F, 57.581791F, 28.982149F, 57.581791F, 25.413738F);
      ((Path)localObject).cubicTo(57.581791F, 21.087517F, 53.451355F, 17.561981F, 48.292332F, 17.561981F);
      ((Path)localObject).cubicTo(43.133308F, 17.561981F, 39.002876F, 21.087517F, 39.002876F, 25.413738F);
      ((Path)localObject).lineTo(39.002876F, 46.979233F);
      ((Path)localObject).cubicTo(39.002876F, 54.574989F, 32.213692F, 60.69297F, 23.851439F, 60.69297F);
      ((Path)localObject).cubicTo(15.489182F, 60.69297F, 8.7F, 54.574989F, 8.7F, 46.979233F);
      ((Path)localObject).cubicTo(8.7F, 40.318993F, 13.957028F, 34.633987F, 21.119808F, 33.553036F);
      ((Path)localObject).lineTo(21.694889F, 33.553036F);
      ((Path)localObject).cubicTo(23.315079F, 33.553036F, 24.482109F, 34.522938F, 24.482107F, 35.908073F);
      ((Path)localObject).cubicTo(24.482798F, 36.145412F, 24.477034F, 36.255089F, 24.4536F, 36.395687F);
      ((Path)localObject).cubicTo(24.42201F, 36.58522F, 24.360502F, 36.766632F, 24.275721F, 36.932861F);
      ((Path)localObject).cubicTo(23.759354F, 38.137722F, 22.439314F, 39.180859F, 21.013983F, 39.537167F);
      ((Path)localObject).cubicTo(17.11499F, 40.478302F, 14.418211F, 43.529003F, 14.418211F, 46.979233F);
      ((Path)localObject).cubicTo(14.418211F, 51.305454F, 18.548643F, 54.83099F, 23.707668F, 54.83099F);
      ((Path)localObject).cubicTo(28.866692F, 54.83099F, 32.997124F, 51.305454F, 32.997124F, 46.979233F);
      ((Path)localObject).lineTo(32.997124F, 25.413738F);
      ((Path)localObject).cubicTo(32.997124F, 17.817982F, 39.786308F, 11.7F, 48.148563F, 11.7F);
      ((Path)localObject).cubicTo(56.510818F, 11.7F, 63.299999F, 17.817982F, 63.299999F, 25.413738F);
      ((Path)localObject).cubicTo(63.299999F, 32.109337F, 58.16663F, 37.728123F, 51.012886F, 38.972252F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.anf
 * JD-Core Version:    0.7.0.1
 */