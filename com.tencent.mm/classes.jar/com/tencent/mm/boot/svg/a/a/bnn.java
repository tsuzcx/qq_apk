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

public final class bnn
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(40.739872F, 0.951031F);
      ((Path)localObject2).cubicTo(42.900532F, -1.460749F, 46.528423F, 1.179307F, 46.950508F, 3.710187F);
      ((Path)localObject2).cubicTo(47.272091F, 5.189014F, 45.955601F, 6.231142F, 45.05114F, 7.193869F);
      ((Path)localObject2).cubicTo(36.941135F, 15.133884F, 28.891432F, 23.153301F, 20.801529F, 31.113167F);
      ((Path)localObject2).cubicTo(19.515184F, 32.601921F, 17.123386F, 32.065968F, 16.058132F, 30.616915F);
      ((Path)localObject2).cubicTo(11.405182F, 25.892607F, 6.591438F, 21.327097F, 1.948537F, 16.592863F);
      ((Path)localObject2).cubicTo(-1.227126F, 13.724532F, 4.350384F, 8.295546F, 7.24466F, 11.362377F);
      ((Path)localObject2).cubicTo(11.103695F, 15.084259F, 14.862233F, 18.905392F, 18.701168F, 22.637199F);
      ((Path)localObject2).cubicTo(26.077553F, 15.44156F, 33.33334F, 8.116896F, 40.739872F, 0.951031F);
      ((Path)localObject2).lineTo(40.739872F, 0.951031F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bnn
 * JD-Core Version:    0.7.0.1
 */