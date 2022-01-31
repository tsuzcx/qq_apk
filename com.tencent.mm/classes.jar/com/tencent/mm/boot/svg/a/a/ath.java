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

public final class ath
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
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 13.0F, 0.0F, 1.0F, 13.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-2603989);
      localCanvas.save();
      Object localObject3 = c.a(localPaint, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(5.3F, 1.27F);
      localPath.cubicTo(23.860001F, 0.64F, 42.5F, 1.17F, 61.09F, 1.0F);
      localPath.cubicTo(64.550003F, 0.58F, 68.059998F, 3.32F, 67.959999F, 6.91F);
      localPath.cubicTo(68.019997F, 25.290001F, 68.040001F, 43.68F, 67.949997F, 62.049999F);
      localPath.cubicTo(68.089996F, 65.660004F, 64.550003F, 68.440002F, 61.080002F, 68.0F);
      localPath.cubicTo(43.040001F, 67.970001F, 25.0F, 68.059998F, 6.96F, 67.959999F);
      localPath.cubicTo(3.79F, 68.07F, 0.96F, 65.230003F, 1.04F, 62.07F);
      localPath.cubicTo(0.94F, 44.029999F, 1.03F, 25.99F, 0.99F, 7.95F);
      localPath.cubicTo(0.72F, 5.07F, 2.4F, 2.01F, 5.3F, 1.27F);
      localPath.lineTo(5.3F, 1.27F);
      localPath.close();
      localPath.moveTo(29.0F, 8.97F);
      localPath.cubicTo(22.26F, 10.71F, 17.07F, 18.360001F, 19.85F, 25.17F);
      localPath.cubicTo(21.77F, 30.459999F, 27.73F, 32.84F, 33.009998F, 32.220001F);
      localPath.cubicTo(32.099998F, 34.880001F, 32.919998F, 37.5F, 34.540001F, 39.66F);
      localPath.cubicTo(29.02F, 40.040001F, 22.959999F, 40.740002F, 18.68F, 44.650002F);
      localPath.cubicTo(15.73F, 47.259998F, 14.46F, 51.93F, 16.58F, 55.439999F);
      localPath.cubicTo(19.110001F, 59.709999F, 24.389999F, 61.189999F, 29.040001F, 61.459999F);
      localPath.cubicTo(35.32F, 61.82F, 42.32F, 60.5F, 46.740002F, 55.669998F);
      localPath.cubicTo(49.75F, 52.48F, 50.77F, 47.34F, 48.540001F, 43.439999F);
      localPath.cubicTo(46.490002F, 39.880001F, 42.630001F, 38.040001F, 39.900002F, 35.119999F);
      localPath.cubicTo(38.900002F, 34.029999F, 39.189999F, 32.23F, 40.150002F, 31.209999F);
      localPath.cubicTo(42.52F, 28.58F, 46.029999F, 26.66F, 46.91F, 22.969999F);
      localPath.cubicTo(48.389999F, 18.27F, 46.029999F, 13.4F, 42.369999F, 10.46F);
      localPath.cubicTo(45.619999F, 11.0F, 48.580002F, 9.74F, 51.23F, 7.96F);
      localPath.cubicTo(43.830002F, 8.25F, 36.240002F, 7.08F, 29.0F, 8.97F);
      localPath.lineTo(29.0F, 8.97F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(30.389999F, 10.46F);
      localPath.cubicTo(37.68F, 9.08F, 41.32F, 18.059999F, 40.970001F, 24.02F);
      localPath.cubicTo(41.099998F, 28.74F, 35.380001F, 31.73F, 31.379999F, 29.6F);
      localPath.cubicTo(27.25F, 27.370001F, 25.620001F, 22.34F, 25.41F, 17.92F);
      localPath.cubicTo(25.139999F, 14.69F, 27.059999F, 11.17F, 30.389999F, 10.46F);
      localPath.lineTo(30.389999F, 10.46F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(28.360001F, 42.650002F);
      ((Path)localObject3).cubicTo(31.790001F, 41.970001F, 36.040001F, 40.459999F, 39.049999F, 43.009998F);
      ((Path)localObject3).cubicTo(41.669998F, 45.0F, 45.060001F, 47.299999F, 44.93F, 51.0F);
      ((Path)localObject3).cubicTo(45.040001F, 54.16F, 42.630001F, 56.84F, 39.720001F, 57.75F);
      ((Path)localObject3).cubicTo(35.529999F, 59.02F, 30.82F, 58.82F, 26.799999F, 57.049999F);
      ((Path)localObject3).cubicTo(23.719999F, 55.700001F, 21.299999F, 52.470001F, 21.879999F, 48.990002F);
      ((Path)localObject3).cubicTo(22.26F, 45.66F, 25.35F, 43.490002F, 28.360001F, 42.650002F);
      ((Path)localObject3).lineTo(28.360001F, 42.650002F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 7.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(14.0F, 1.97F);
      ((Path)localObject2).cubicTo(21.24F, 0.08F, 28.83F, 1.25F, 36.23F, 0.96F);
      ((Path)localObject2).cubicTo(33.580002F, 2.74F, 30.620001F, 4.0F, 27.370001F, 3.46F);
      ((Path)localObject2).cubicTo(31.030001F, 6.4F, 33.389999F, 11.27F, 31.91F, 15.97F);
      ((Path)localObject2).cubicTo(31.030001F, 19.66F, 27.52F, 21.58F, 25.15F, 24.209999F);
      ((Path)localObject2).cubicTo(24.190001F, 25.23F, 23.9F, 27.030001F, 24.9F, 28.120001F);
      ((Path)localObject2).cubicTo(27.629999F, 31.040001F, 31.49F, 32.880001F, 33.540001F, 36.439999F);
      ((Path)localObject2).cubicTo(35.77F, 40.34F, 34.75F, 45.48F, 31.74F, 48.669998F);
      ((Path)localObject2).cubicTo(27.32F, 53.5F, 20.32F, 54.82F, 14.04F, 54.459999F);
      ((Path)localObject2).cubicTo(9.39F, 54.189999F, 4.11F, 52.709999F, 1.58F, 48.439999F);
      ((Path)localObject2).cubicTo(-0.54F, 44.93F, 0.73F, 40.259998F, 3.68F, 37.650002F);
      ((Path)localObject2).cubicTo(7.96F, 33.740002F, 14.02F, 33.040001F, 19.540001F, 32.66F);
      ((Path)localObject2).cubicTo(17.92F, 30.5F, 17.1F, 27.879999F, 18.01F, 25.219999F);
      ((Path)localObject2).cubicTo(12.73F, 25.84F, 6.77F, 23.459999F, 4.85F, 18.17F);
      ((Path)localObject2).cubicTo(2.07F, 11.36F, 7.26F, 3.71F, 14.0F, 1.97F);
      ((Path)localObject2).lineTo(14.0F, 1.97F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.39F, 3.46F);
      ((Path)localObject2).cubicTo(12.06F, 4.17F, 10.14F, 7.69F, 10.41F, 10.92F);
      ((Path)localObject2).cubicTo(10.62F, 15.34F, 12.25F, 20.370001F, 16.379999F, 22.6F);
      ((Path)localObject2).cubicTo(20.379999F, 24.73F, 26.1F, 21.74F, 25.969999F, 17.02F);
      ((Path)localObject2).cubicTo(26.32F, 11.06F, 22.68F, 2.08F, 15.39F, 3.46F);
      ((Path)localObject2).lineTo(15.39F, 3.46F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.36F, 35.650002F);
      ((Path)localObject2).cubicTo(10.35F, 36.490002F, 7.26F, 38.66F, 6.88F, 41.990002F);
      ((Path)localObject2).cubicTo(6.3F, 45.470001F, 8.72F, 48.700001F, 11.8F, 50.049999F);
      ((Path)localObject2).cubicTo(15.82F, 51.82F, 20.530001F, 52.02F, 24.719999F, 50.75F);
      ((Path)localObject2).cubicTo(27.629999F, 49.84F, 30.040001F, 47.16F, 29.93F, 44.0F);
      ((Path)localObject2).cubicTo(30.059999F, 40.299999F, 26.67F, 38.0F, 24.049999F, 36.009998F);
      ((Path)localObject2).cubicTo(21.040001F, 33.459999F, 16.790001F, 34.970001F, 13.36F, 35.650002F);
      ((Path)localObject2).lineTo(13.36F, 35.650002F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ath
 * JD-Core Version:    0.7.0.1
 */