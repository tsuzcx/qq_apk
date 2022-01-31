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

public final class cl
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1686720);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(68.0F, 87.0F);
      ((Path)localObject2).cubicTo(68.0F, 88.656853F, 66.656853F, 90.0F, 65.0F, 90.0F);
      ((Path)localObject2).lineTo(3.0F, 90.0F);
      ((Path)localObject2).cubicTo(1.343146F, 90.0F, 2.029061E-016F, 88.656853F, 0.0F, 87.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-4704973);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(49.0F, 22.0F);
      ((Path)localObject2).cubicTo(47.343147F, 22.0F, 46.0F, 20.656855F, 46.0F, 19.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(13.462891F, 48.089844F);
      ((Path)localObject1).lineTo(20.037109F, 48.089844F);
      ((Path)localObject1).cubicTo(23.400391F, 48.089844F, 25.732422F, 50.375F, 25.732422F, 53.75F);
      ((Path)localObject1).cubicTo(25.732422F, 57.125F, 23.330078F, 59.410156F, 19.908203F, 59.410156F);
      ((Path)localObject1).lineTo(16.486328F, 59.410156F);
      ((Path)localObject1).lineTo(16.486328F, 65.0F);
      ((Path)localObject1).lineTo(13.462891F, 65.0F);
      ((Path)localObject1).lineTo(13.462891F, 48.089844F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(16.486328F, 50.5625F);
      ((Path)localObject1).lineTo(16.486328F, 56.972656F);
      ((Path)localObject1).lineTo(19.228516F, 56.972656F);
      ((Path)localObject1).cubicTo(21.396484F, 56.972656F, 22.662109F, 55.800781F, 22.662109F, 53.75F);
      ((Path)localObject1).cubicTo(22.662109F, 51.722656F, 21.408203F, 50.5625F, 19.240234F, 50.5625F);
      ((Path)localObject1).lineTo(16.486328F, 50.5625F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(27.935547F, 48.089844F);
      ((Path)localObject1).lineTo(34.111328F, 48.089844F);
      ((Path)localObject1).cubicTo(39.162109F, 48.089844F, 42.150391F, 51.148438F, 42.150391F, 56.503906F);
      ((Path)localObject1).cubicTo(42.150391F, 61.859375F, 39.173828F, 65.0F, 34.111328F, 65.0F);
      ((Path)localObject1).lineTo(27.935547F, 65.0F);
      ((Path)localObject1).lineTo(27.935547F, 48.089844F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(30.958984F, 50.644531F);
      ((Path)localObject1).lineTo(30.958984F, 62.445313F);
      ((Path)localObject1).lineTo(33.794922F, 62.445313F);
      ((Path)localObject1).cubicTo(37.193359F, 62.445313F, 39.068359F, 60.371094F, 39.068359F, 56.515625F);
      ((Path)localObject1).cubicTo(39.068359F, 52.730469F, 37.169922F, 50.644531F, 33.794922F, 50.644531F);
      ((Path)localObject1).lineTo(30.958984F, 50.644531F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(47.564453F, 65.0F);
      ((Path)localObject1).lineTo(44.541016F, 65.0F);
      ((Path)localObject1).lineTo(44.541016F, 48.089844F);
      ((Path)localObject1).lineTo(55.322266F, 48.089844F);
      ((Path)localObject1).lineTo(55.322266F, 50.644531F);
      ((Path)localObject1).lineTo(47.564453F, 50.644531F);
      ((Path)localObject1).lineTo(47.564453F, 55.636719F);
      ((Path)localObject1).lineTo(54.654297F, 55.636719F);
      ((Path)localObject1).lineTo(54.654297F, 58.097656F);
      ((Path)localObject1).lineTo(47.564453F, 58.097656F);
      ((Path)localObject1).lineTo(47.564453F, 65.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cl
 * JD-Core Version:    0.7.0.1
 */