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

public final class al
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 20.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 9.0F);
      ((Path)localObject2).cubicTo(24.056999F, 5.94928F, 23.56735F, 2.849655F, 25.0F, 0.0F);
      ((Path)localObject2).cubicTo(29.882835F, 3.919525F, 35.1091F, 7.799056F, 40.0F, 12.0F);
      ((Path)localObject2).cubicTo(41.234722F, 12.54848F, 40.785042F, 14.168284F, 40.0F, 15.0F);
      ((Path)localObject2).cubicTo(34.779335F, 18.527756F, 29.752928F, 22.337296F, 25.0F, 26.0F);
      ((Path)localObject2).cubicTo(23.3575F, 22.54727F, 24.216885F, 18.627745F, 24.0F, 15.0F);
      ((Path)localObject2).cubicTo(19.050577F, 15.228156F, 14.094121F, 17.067934F, 11.0F, 21.0F);
      ((Path)localObject2).cubicTo(5.909971F, 26.006851F, 4.630885F, 34.115868F, 8.0F, 41.0F);
      ((Path)localObject2).cubicTo(10.586628F, 47.154289F, 17.861427F, 51.53376F, 25.0F, 51.0F);
      ((Path)localObject2).cubicTo(32.391041F, 50.643867F, 39.086258F, 45.364506F, 41.0F, 38.0F);
      ((Path)localObject2).cubicTo(42.224014F, 35.505699F, 41.574478F, 32.356083F, 42.0F, 29.0F);
      ((Path)localObject2).cubicTo(43.613022F, 27.286695F, 47.230434F, 27.696646F, 48.0F, 30.0F);
      ((Path)localObject2).cubicTo(48.989178F, 39.065269F, 44.592323F, 48.344147F, 37.0F, 53.0F);
      ((Path)localObject2).cubicTo(30.132656F, 57.723011F, 20.819313F, 58.252945F, 13.0F, 55.0F);
      ((Path)localObject2).cubicTo(6.329671F, 51.103813F, 1.163364F, 43.974674F, 3.552714E-015F, 36.0F);
      ((Path)localObject2).cubicTo(-1.065044F, 27.176708F, 3.301835F, 17.767849F, 11.0F, 13.0F);
      ((Path)localObject2).cubicTo(14.773635F, 10.288754F, 19.420313F, 9.218884F, 24.0F, 9.0F);
      ((Path)localObject2).lineTo(24.0F, 9.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.al
 * JD-Core Version:    0.7.0.1
 */