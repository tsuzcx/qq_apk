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

public final class blh
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
      localPaint1.setColor(-5592406);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 18.0F, 0.0F, 1.0F, 18.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.35F, 12.4F);
      ((Path)localObject2).cubicTo(7.25F, 5.36F, 14.93F, 0.63F, 22.959999F, 0.27F);
      ((Path)localObject2).cubicTo(31.48F, -0.27F, 40.049999F, 4.2F, 44.529999F, 11.46F);
      ((Path)localObject2).cubicTo(49.919998F, 19.74F, 49.240002F, 31.190001F, 43.220001F, 38.970001F);
      ((Path)localObject2).cubicTo(48.419998F, 44.200001F, 53.650002F, 49.400002F, 58.860001F, 54.619999F);
      ((Path)localObject2).cubicTo(57.459999F, 56.07F, 56.029999F, 57.5F, 54.529999F, 58.84F);
      ((Path)localObject2).cubicTo(49.400002F, 53.57F, 44.139999F, 48.41F, 38.950001F, 43.200001F);
      ((Path)localObject2).cubicTo(34.16F, 46.84F, 28.049999F, 48.709999F, 22.040001F, 48.110001F);
      ((Path)localObject2).cubicTo(13.48F, 47.41F, 5.55F, 41.700001F, 2.22F, 33.77F);
      ((Path)localObject2).cubicTo(-0.77F, 26.99F, -0.35F, 18.82F, 3.35F, 12.4F);
      ((Path)localObject2).lineTo(3.35F, 12.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.25F, 6.34F);
      ((Path)localObject2).cubicTo(12.73F, 7.14F, 5.11F, 16.549999F, 6.33F, 26.040001F);
      ((Path)localObject2).cubicTo(7.03F, 35.599998F, 16.43F, 43.299999F, 25.940001F, 42.130001F);
      ((Path)localObject2).cubicTo(35.700001F, 41.450001F, 43.549999F, 31.719999F, 42.080002F, 22.030001F);
      ((Path)localObject2).cubicTo(41.150002F, 12.55F, 31.709999F, 5.05F, 22.25F, 6.34F);
      ((Path)localObject2).lineTo(22.25F, 6.34F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.blh
 * JD-Core Version:    0.7.0.1
 */