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

public final class tu
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
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
      localPaint.setColor(-12040120);
      localCanvas.saveLayerAlpha(null, 238, 4);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(27.26F, 0.0F);
      localPath.lineTo(32.599998F, 0.0F);
      localPath.cubicTo(46.68F, 1.16F, 58.73F, 13.18F, 60.0F, 27.24F);
      localPath.lineTo(60.0F, 32.599998F);
      localPath.cubicTo(58.84F, 46.68F, 46.82F, 58.720001F, 32.759998F, 60.0F);
      localPath.lineTo(27.370001F, 60.0F);
      localPath.cubicTo(13.3F, 58.82F, 1.27F, 46.810001F, 0.0F, 32.759998F);
      localPath.lineTo(0.0F, 27.379999F);
      localPath.cubicTo(1.17F, 13.3F, 13.2F, 1.26F, 27.26F, 0.0F);
      localPath.lineTo(27.26F, 0.0F);
      localPath.close();
      localPath.moveTo(26.24F, 2.26F);
      localPath.cubicTo(12.44F, 3.91F, 1.18F, 17.110001F, 2.04F, 31.040001F);
      localPath.cubicTo(2.23F, 45.91F, 16.120001F, 58.889999F, 30.99F, 57.970001F);
      localPath.cubicTo(45.900002F, 57.799999F, 58.900002F, 43.880001F, 57.959999F, 28.98F);
      localPath.cubicTo(57.82F, 13.07F, 41.98F, -0.35F, 26.24F, 2.26F);
      localPath.lineTo(26.24F, 2.26F);
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
      localPath = c.l(paramVarArgs);
      localPath.moveTo(25.24F, 1.26F);
      localPath.cubicTo(40.98F, -1.35F, 56.82F, 12.07F, 56.959999F, 27.98F);
      localPath.cubicTo(57.900002F, 42.880001F, 44.900002F, 56.799999F, 29.99F, 56.970001F);
      localPath.cubicTo(15.12F, 57.889999F, 1.23F, 44.91F, 1.04F, 30.040001F);
      localPath.cubicTo(0.18F, 16.110001F, 11.44F, 2.91F, 25.24F, 1.26F);
      localPath.lineTo(25.24F, 1.26F);
      localPath.close();
      localPath.moveTo(15.83F, 19.889999F);
      localPath.cubicTo(18.610001F, 23.110001F, 21.82F, 25.92F, 24.75F, 29.0F);
      localPath.cubicTo(21.809999F, 32.09F, 18.58F, 34.91F, 15.8F, 38.150002F);
      localPath.cubicTo(14.21F, 40.599998F, 17.43F, 43.799999F, 19.870001F, 42.189999F);
      localPath.cubicTo(23.1F, 39.400002F, 25.92F, 36.189999F, 29.0F, 33.25F);
      localPath.cubicTo(32.110001F, 36.200001F, 34.939999F, 39.450001F, 38.200001F, 42.240002F);
      localPath.cubicTo(40.669998F, 43.73F, 43.799999F, 40.529999F, 42.169998F, 38.110001F);
      localPath.cubicTo(39.389999F, 34.889999F, 36.18F, 32.080002F, 33.25F, 29.0F);
      localPath.cubicTo(36.189999F, 25.91F, 39.41F, 23.09F, 42.189999F, 19.870001F);
      localPath.cubicTo(43.790001F, 17.42F, 40.599998F, 14.22F, 38.139999F, 15.8F);
      localPath.cubicTo(34.91F, 18.58F, 32.09F, 21.809999F, 29.0F, 24.75F);
      localPath.cubicTo(25.92F, 21.82F, 23.110001F, 18.610001F, 19.889999F, 15.83F);
      localPath.cubicTo(17.440001F, 14.17F, 14.15F, 17.440001F, 15.83F, 19.889999F);
      localPath.lineTo(15.83F, 19.889999F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-11711155);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(0.83F, 4.89F);
      ((Path)localObject2).cubicTo(-0.85F, 2.44F, 2.44F, -0.83F, 4.89F, 0.83F);
      ((Path)localObject2).cubicTo(8.11F, 3.61F, 10.92F, 6.82F, 14.0F, 9.75F);
      ((Path)localObject2).cubicTo(17.09F, 6.81F, 19.91F, 3.58F, 23.139999F, 0.8F);
      ((Path)localObject2).cubicTo(25.6F, -0.78F, 28.790001F, 2.42F, 27.190001F, 4.87F);
      ((Path)localObject2).cubicTo(24.41F, 8.09F, 21.190001F, 10.91F, 18.25F, 14.0F);
      ((Path)localObject2).cubicTo(21.18F, 17.08F, 24.389999F, 19.889999F, 27.17F, 23.110001F);
      ((Path)localObject2).cubicTo(28.799999F, 25.530001F, 25.67F, 28.73F, 23.200001F, 27.24F);
      ((Path)localObject2).cubicTo(19.940001F, 24.450001F, 17.110001F, 21.200001F, 14.0F, 18.25F);
      ((Path)localObject2).cubicTo(10.92F, 21.190001F, 8.1F, 24.4F, 4.87F, 27.190001F);
      ((Path)localObject2).cubicTo(2.43F, 28.799999F, -0.79F, 25.6F, 0.8F, 23.15F);
      ((Path)localObject2).cubicTo(3.58F, 19.91F, 6.81F, 17.09F, 9.75F, 14.0F);
      ((Path)localObject2).cubicTo(6.82F, 10.92F, 3.61F, 8.11F, 0.83F, 4.89F);
      ((Path)localObject2).lineTo(0.83F, 4.89F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.tu
 * JD-Core Version:    0.7.0.1
 */