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

public final class brf
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
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(26.43F, 1.68F);
      localPath.cubicTo(41.459999F, -1.69F, 57.900002F, 7.14F, 63.509998F, 21.450001F);
      localPath.cubicTo(69.440002F, 35.220001F, 64.389999F, 52.549999F, 51.990002F, 60.970001F);
      localPath.cubicTo(39.830002F, 69.860001F, 21.65F, 68.699997F, 10.73F, 58.32F);
      localPath.cubicTo(-0.37F, 48.509998F, -3.25F, 30.940001F, 4.11F, 18.1F);
      localPath.cubicTo(8.68F, 9.71F, 17.049999F, 3.53F, 26.43F, 1.68F);
      localPath.lineTo(26.43F, 1.68F);
      localPath.close();
      localPath.moveTo(20.27F, 23.379999F);
      localPath.cubicTo(23.799999F, 26.93F, 27.34F, 30.450001F, 30.870001F, 34.0F);
      localPath.cubicTo(27.35F, 37.540001F, 23.799999F, 41.060001F, 20.280001F, 44.610001F);
      localPath.cubicTo(20.799999F, 45.139999F, 21.860001F, 46.200001F, 22.379999F, 46.73F);
      localPath.cubicTo(25.940001F, 43.209999F, 29.450001F, 39.650002F, 33.0F, 36.130001F);
      localPath.cubicTo(36.549999F, 39.66F, 40.07F, 43.209999F, 43.619999F, 46.73F);
      localPath.cubicTo(44.139999F, 46.200001F, 45.200001F, 45.139999F, 45.720001F, 44.610001F);
      localPath.cubicTo(42.200001F, 41.060001F, 38.650002F, 37.540001F, 35.130001F, 34.0F);
      localPath.cubicTo(38.650002F, 30.459999F, 42.200001F, 26.93F, 45.73F, 23.389999F);
      localPath.cubicTo(45.200001F, 22.860001F, 44.139999F, 21.799999F, 43.610001F, 21.280001F);
      localPath.cubicTo(40.060001F, 24.790001F, 36.549999F, 28.35F, 33.0F, 31.870001F);
      localPath.cubicTo(29.459999F, 28.34F, 25.93F, 24.799999F, 22.389999F, 21.27F);
      localPath.cubicTo(21.860001F, 21.799999F, 20.799999F, 22.860001F, 20.27F, 23.379999F);
      localPath.lineTo(20.27F, 23.379999F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 21.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.27F, 2.38F);
      ((Path)localObject2).cubicTo(0.8F, 1.86F, 1.86F, 0.8F, 2.39F, 0.27F);
      ((Path)localObject2).cubicTo(5.93F, 3.8F, 9.46F, 7.34F, 13.0F, 10.87F);
      ((Path)localObject2).cubicTo(16.549999F, 7.35F, 20.059999F, 3.79F, 23.610001F, 0.28F);
      ((Path)localObject2).cubicTo(24.139999F, 0.8F, 25.200001F, 1.86F, 25.73F, 2.39F);
      ((Path)localObject2).cubicTo(22.200001F, 5.93F, 18.65F, 9.46F, 15.13F, 13.0F);
      ((Path)localObject2).cubicTo(18.65F, 16.540001F, 22.200001F, 20.059999F, 25.719999F, 23.610001F);
      ((Path)localObject2).cubicTo(25.200001F, 24.139999F, 24.139999F, 25.200001F, 23.620001F, 25.73F);
      ((Path)localObject2).cubicTo(20.07F, 22.209999F, 16.549999F, 18.66F, 13.0F, 15.13F);
      ((Path)localObject2).cubicTo(9.45F, 18.65F, 5.94F, 22.209999F, 2.38F, 25.73F);
      ((Path)localObject2).cubicTo(1.86F, 25.200001F, 0.8F, 24.139999F, 0.28F, 23.610001F);
      ((Path)localObject2).cubicTo(3.8F, 20.059999F, 7.35F, 16.540001F, 10.87F, 13.0F);
      ((Path)localObject2).cubicTo(7.34F, 9.45F, 3.8F, 5.93F, 0.27F, 2.38F);
      ((Path)localObject2).lineTo(0.27F, 2.38F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.brf
 * JD-Core Version:    0.7.0.1
 */