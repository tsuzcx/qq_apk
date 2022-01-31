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

public final class aem
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-9473160);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(53.0F, 46.715801F);
      ((Path)localObject2).cubicTo(53.0F, 48.510799F, 51.705002F, 50.472801F, 49.973999F, 51.318802F);
      ((Path)localObject2).cubicTo(49.355F, 51.517799F, 46.938F, 52.0728F, 46.360001F, 52.1898F);
      ((Path)localObject2).cubicTo(45.499001F, 52.360802F, 44.713001F, 52.174801F, 44.02F, 51.632801F);
      ((Path)localObject2).cubicTo(43.169998F, 50.971802F, 42.587002F, 49.8498F, 42.534F, 48.777802F);
      ((Path)localObject2).cubicTo(42.435001F, 46.736801F, 43.717999F, 45.096802F, 44.979F, 44.8438F);
      ((Path)localObject2).lineTo(50.365002F, 43.764801F);
      ((Path)localObject2).cubicTo(51.328999F, 43.570801F, 52.227001F, 43.142799F, 53.0F, 42.547798F);
      ((Path)localObject2).lineTo(53.0F, 46.715801F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.471F, 55.463799F);
      ((Path)localObject2).cubicTo(13.471F, 57.258801F, 12.174F, 59.222801F, 10.446F, 60.066799F);
      ((Path)localObject2).cubicTo(9.822F, 60.267799F, 7.39F, 60.825802F, 6.832F, 60.937801F);
      ((Path)localObject2).cubicTo(5.972F, 61.108799F, 5.185F, 60.920799F, 4.489F, 60.380798F);
      ((Path)localObject2).cubicTo(3.641F, 59.7188F, 3.058F, 58.598801F, 3.006F, 57.524799F);
      ((Path)localObject2).cubicTo(2.906F, 55.485802F, 4.187F, 53.845798F, 5.449F, 53.5928F);
      ((Path)localObject2).lineTo(10.835F, 52.512798F);
      ((Path)localObject2).cubicTo(11.8F, 52.319801F, 12.697F, 51.8908F, 13.471F, 51.295799F);
      ((Path)localObject2).lineTo(13.471F, 55.463799F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.161F, 9.3678F);
      ((Path)localObject2).lineTo(13.161F, 13.2228F);
      ((Path)localObject2).lineTo(13.178F, 13.2188F);
      ((Path)localObject2).lineTo(13.178F, 45.979801F);
      ((Path)localObject2).cubicTo(13.178F, 47.638802F, 11.86F, 49.247799F, 10.245F, 49.570801F);
      ((Path)localObject2).lineTo(4.859F, 50.650799F);
      ((Path)localObject2).cubicTo(2.161F, 51.191799F, -0.164F, 54.137798F, 0.009F, 57.671799F);
      ((Path)localObject2).cubicTo(0.182F, 61.205799F, 3.328F, 64.699799F, 7.421F, 63.878799F);
      ((Path)localObject2).cubicTo(7.847F, 63.7938F, 11.11F, 63.066799F, 11.626F, 62.826801F);
      ((Path)localObject2).cubicTo(14.405F, 61.535801F, 16.471001F, 58.5378F, 16.471001F, 55.463799F);
      ((Path)localObject2).lineTo(16.471001F, 52.1628F);
      ((Path)localObject2).lineTo(16.471001F, 12.4988F);
      ((Path)localObject2).lineTo(52.708F, 4.5748F);
      ((Path)localObject2).lineTo(52.708F, 37.2318F);
      ((Path)localObject2).cubicTo(52.708F, 38.889801F, 51.389F, 40.498798F, 49.775002F, 40.8228F);
      ((Path)localObject2).lineTo(44.388F, 41.902802F);
      ((Path)localObject2).cubicTo(41.691002F, 42.443802F, 39.365002F, 45.389801F, 39.539001F, 48.923801F);
      ((Path)localObject2).cubicTo(39.712002F, 52.456799F, 42.856998F, 55.951801F, 46.951F, 55.130798F);
      ((Path)localObject2).cubicTo(47.376999F, 55.0448F, 50.639F, 54.318802F, 51.155998F, 54.0788F);
      ((Path)localObject2).cubicTo(53.933998F, 52.7868F, 56.0F, 49.789799F, 56.0F, 46.715801F);
      ((Path)localObject2).lineTo(56.0F, 43.414799F);
      ((Path)localObject2).lineTo(56.0F, 3.3078F);
      ((Path)localObject2).lineTo(56.0F, -0.0002F);
      ((Path)localObject2).lineTo(13.161F, 9.3678F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aem
 * JD-Core Version:    0.7.0.1
 */