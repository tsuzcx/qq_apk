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

public final class rq
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-8947849);
      localCanvas.saveLayerAlpha(null, 238, 4);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(27.26F, 0.0F);
      localPath.lineTo(32.619999F, 0.0F);
      localPath.cubicTo(46.700001F, 1.17F, 58.740002F, 13.2F, 60.0F, 27.26F);
      localPath.lineTo(60.0F, 32.630001F);
      localPath.cubicTo(58.82F, 46.700001F, 46.799999F, 58.740002F, 32.740002F, 60.0F);
      localPath.lineTo(27.389999F, 60.0F);
      localPath.cubicTo(13.31F, 58.84F, 1.26F, 46.810001F, 0.0F, 32.75F);
      localPath.lineTo(0.0F, 27.370001F);
      localPath.cubicTo(1.18F, 13.3F, 13.2F, 1.26F, 27.26F, 0.0F);
      localPath.lineTo(27.26F, 0.0F);
      localPath.close();
      localPath.moveTo(24.42F, 2.54F);
      localPath.cubicTo(10.35F, 5.18F, -0.2F, 19.83F, 2.27F, 34.029999F);
      localPath.cubicTo(4.12F, 48.830002F, 19.33F, 60.34F, 34.09F, 57.720001F);
      localPath.cubicTo(48.990002F, 55.830002F, 60.509998F, 40.380001F, 57.66F, 25.540001F);
      localPath.cubicTo(55.540001F, 10.38F, 39.419998F, -1.0F, 24.42F, 2.54F);
      localPath.lineTo(24.42F, 2.54F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(23.42F, 1.54F);
      localPath.cubicTo(38.419998F, -2.0F, 54.540001F, 9.38F, 56.66F, 24.540001F);
      localPath.cubicTo(59.509998F, 39.380001F, 47.990002F, 54.830002F, 33.09F, 56.720001F);
      localPath.cubicTo(18.33F, 59.34F, 3.12F, 47.830002F, 1.27F, 33.029999F);
      localPath.cubicTo(-1.2F, 18.83F, 9.35F, 4.18F, 23.42F, 1.54F);
      localPath.lineTo(23.42F, 1.54F);
      localPath.close();
      localPath.moveTo(15.79F, 19.84F);
      localPath.cubicTo(18.57F, 23.09F, 21.82F, 25.9F, 24.75F, 29.0F);
      localPath.cubicTo(21.83F, 32.09F, 18.610001F, 34.889999F, 15.83F, 38.110001F);
      localPath.cubicTo(14.2F, 40.529999F, 17.34F, 43.759998F, 19.809999F, 42.23F);
      localPath.cubicTo(23.07F, 39.450001F, 25.889999F, 36.189999F, 29.0F, 33.25F);
      localPath.cubicTo(32.080002F, 36.16F, 34.880001F, 39.389999F, 38.099998F, 42.16F);
      localPath.cubicTo(40.529999F, 43.849998F, 43.82F, 40.580002F, 42.18F, 38.130001F);
      localPath.cubicTo(39.41F, 34.889999F, 36.169998F, 32.099998F, 33.25F, 29.0F);
      localPath.cubicTo(36.169998F, 25.91F, 39.400002F, 23.110001F, 42.169998F, 19.889999F);
      localPath.cubicTo(43.830002F, 17.440001F, 40.549999F, 14.16F, 38.110001F, 15.83F);
      localPath.cubicTo(34.889999F, 18.6F, 32.09F, 21.83F, 29.0F, 24.75F);
      localPath.cubicTo(25.91F, 21.82F, 23.1F, 18.59F, 19.870001F, 15.81F);
      localPath.cubicTo(17.43F, 14.21F, 14.22F, 17.389999F, 15.79F, 19.84F);
      localPath.lineTo(15.79F, 19.84F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-8355712);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(0.79F, 4.84F);
      ((Path)localObject2).cubicTo(-0.78F, 2.39F, 2.43F, -0.79F, 4.87F, 0.81F);
      ((Path)localObject2).cubicTo(8.1F, 3.59F, 10.91F, 6.82F, 14.0F, 9.75F);
      ((Path)localObject2).cubicTo(17.09F, 6.83F, 19.889999F, 3.6F, 23.110001F, 0.83F);
      ((Path)localObject2).cubicTo(25.549999F, -0.84F, 28.83F, 2.44F, 27.17F, 4.89F);
      ((Path)localObject2).cubicTo(24.4F, 8.11F, 21.17F, 10.91F, 18.25F, 14.0F);
      ((Path)localObject2).cubicTo(21.17F, 17.1F, 24.41F, 19.889999F, 27.18F, 23.129999F);
      ((Path)localObject2).cubicTo(28.82F, 25.58F, 25.530001F, 28.85F, 23.1F, 27.16F);
      ((Path)localObject2).cubicTo(19.879999F, 24.389999F, 17.08F, 21.16F, 14.0F, 18.25F);
      ((Path)localObject2).cubicTo(10.89F, 21.190001F, 8.07F, 24.450001F, 4.81F, 27.23F);
      ((Path)localObject2).cubicTo(2.34F, 28.76F, -0.8F, 25.530001F, 0.83F, 23.110001F);
      ((Path)localObject2).cubicTo(3.61F, 19.889999F, 6.83F, 17.09F, 9.75F, 14.0F);
      ((Path)localObject2).cubicTo(6.82F, 10.9F, 3.57F, 8.09F, 0.79F, 4.84F);
      ((Path)localObject2).lineTo(0.79F, 4.84F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.rq
 * JD-Core Version:    0.7.0.1
 */