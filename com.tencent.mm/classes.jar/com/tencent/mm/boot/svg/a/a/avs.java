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

public final class avs
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-27648);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(26.4F, 1.66F);
      ((Path)localObject2).cubicTo(42.279999F, -1.94F, 59.610001F, 8.21F, 64.370003F, 23.75F);
      ((Path)localObject2).cubicTo(69.730003F, 39.029999F, 61.77F, 57.349998F, 46.959999F, 63.880001F);
      ((Path)localObject2).cubicTo(32.580002F, 71.019997F, 13.62F, 65.470001F, 5.24F, 51.82F);
      ((Path)localObject2).cubicTo(-2.86F, 39.68F, -1.34F, 22.27F, 8.7F, 11.7F);
      ((Path)localObject2).cubicTo(13.34F, 6.59F, 19.66F, 3.07F, 26.4F, 1.66F);
      ((Path)localObject2).lineTo(26.4F, 1.66F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(26.42F, 4.73F);
      ((Path)localObject2).cubicTo(22.559999F, 5.59F, 18.889999F, 7.26F, 15.66F, 9.55F);
      ((Path)localObject2).cubicTo(3.91F, 17.540001F, -0.47F, 34.34F, 5.99F, 47.02F);
      ((Path)localObject2).cubicTo(12.27F, 60.810001F, 29.809999F, 67.790001F, 43.84F, 61.970001F);
      ((Path)localObject2).cubicTo(58.139999F, 56.759998F, 66.510002F, 39.709999F, 61.68F, 25.23F);
      ((Path)localObject2).cubicTo(57.540001F, 10.62F, 41.200001F, 1.03F, 26.42F, 4.73F);
      ((Path)localObject2).lineTo(26.42F, 4.73F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.avs
 * JD-Core Version:    0.7.0.1
 */