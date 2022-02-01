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

public final class bjj
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 18.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(49.0F, 1.0F);
      ((Path)localObject3).cubicTo(50.036362F, 0.7465073F, 51.038017F, 0.3981372F, 52.0F, 3.552714E-015F);
      ((Path)localObject3).cubicTo(53.993389F, 0.8261347F, 55.778511F, 2.000639F, 58.0F, 3.0F);
      ((Path)localObject3).cubicTo(57.712399F, 4.230208F, 57.811569F, 5.394759F, 58.0F, 7.0F);
      ((Path)localObject3).cubicTo(56.819836F, 8.440509F, 56.145454F, 10.958727F, 54.0F, 12.0F);
      ((Path)localObject3).cubicTo(52.337189F, 12.790158F, 51.761982F, 14.65145F, 51.0F, 16.0F);
      ((Path)localObject3).cubicTo(51.256199F, 20.22537F, 52.545456F, 24.34609F, 52.0F, 29.0F);
      ((Path)localObject3).cubicTo(51.018181F, 31.761396F, 48.935535F, 34.598125F, 47.0F, 38.0F);
      ((Path)localObject3).cubicTo(42.261158F, 39.564888F, 36.717354F, 40.769253F, 31.0F, 39.0F);
      ((Path)localObject3).cubicTo(27.960331F, 38.669079F, 25.014875F, 36.648533F, 22.0F, 35.0F);
      ((Path)localObject3).cubicTo(25.49091F, 29.193411F, 28.565289F, 23.161633F, 32.0F, 18.0F);
      ((Path)localObject3).cubicTo(35.646282F, 14.820658F, 40.198349F, 14.104012F, 44.0F, 12.0F);
      ((Path)localObject3).cubicTo(44.839668F, 10.978634F, 45.603306F, 9.664781F, 46.0F, 8.0F);
      ((Path)localObject3).cubicTo(45.047935F, 5.603781F, 47.993389F, 3.36426F, 49.0F, 1.0F);
      ((Path)localObject3).lineTo(49.0F, 1.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 43.0F);
      ((Path)localObject2).cubicTo(3.573858F, 39.337292F, 8.595227F, 36.552418F, 14.0F, 37.0F);
      ((Path)localObject2).cubicTo(21.173609F, 36.999989F, 26.105131F, 43.375362F, 33.0F, 44.0F);
      ((Path)localObject2).cubicTo(39.242554F, 44.976665F, 45.06255F, 42.430492F, 51.0F, 41.0F);
      ((Path)localObject2).cubicTo(55.235065F, 38.959347F, 59.857121F, 40.670055F, 64.0F, 42.0F);
      ((Path)localObject2).cubicTo(60.615818F, 42.24152F, 57.091873F, 41.953087F, 54.0F, 43.0F);
      ((Path)localObject2).cubicTo(48.965839F, 45.076122F, 44.802994F, 48.408028F, 40.0F, 50.0F);
      ((Path)localObject2).cubicTo(37.525501F, 53.669453F, 35.868351F, 57.647846F, 33.0F, 61.0F);
      ((Path)localObject2).cubicTo(31.595695F, 61.298019F, 30.228046F, 60.243744F, 29.0F, 60.0F);
      ((Path)localObject2).cubicTo(24.26829F, 57.279842F, 19.586336F, 55.06189F, 15.0F, 53.0F);
      ((Path)localObject2).cubicTo(13.686477F, 52.038311F, 12.867884F, 50.347492F, 14.0F, 49.0F);
      ((Path)localObject2).cubicTo(14.684761F, 46.617752F, 16.232101F, 44.459473F, 17.0F, 42.0F);
      ((Path)localObject2).cubicTo(11.769771F, 39.188103F, 5.240992F, 40.113079F, 0.0F, 43.0F);
      ((Path)localObject2).lineTo(0.0F, 43.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bjj
 * JD-Core Version:    0.7.0.1
 */