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

public final class bmm
  extends c
{
  private final int height = 76;
  private final int width = 76;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 76;
      return 76;
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-789517);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 4.0F);
      localPath.cubicTo(0.0F, 1.790861F, 1.790861F, 0.0F, 4.0F, 0.0F);
      localPath.lineTo(72.0F, 0.0F);
      localPath.cubicTo(74.209137F, 0.0F, 76.0F, 1.790861F, 76.0F, 4.0F);
      localPath.lineTo(76.0F, 72.0F);
      localPath.cubicTo(76.0F, 74.209137F, 74.209137F, 76.0F, 72.0F, 76.0F);
      localPath.lineTo(4.0F, 76.0F);
      localPath.cubicTo(1.790861F, 76.0F, 0.0F, 74.209137F, 0.0F, 72.0F);
      localPath.lineTo(0.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-5658199);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.48F, 15.58F);
      ((Path)localObject2).cubicTo(0.27F, 9.35F, 5.54F, 1.93F, 12.02F, 1.02F);
      ((Path)localObject2).cubicTo(19.309999F, 0.03F, 26.719999F, 0.53F, 34.049999F, 0.82F);
      ((Path)localObject2).cubicTo(31.620001F, 2.59F, 28.84F, 3.78F, 26.059999F, 4.88F);
      ((Path)localObject2).cubicTo(27.110001F, 7.45F, 28.809999F, 10.09F, 28.190001F, 12.99F);
      ((Path)localObject2).cubicTo(27.4F, 16.84F, 23.67F, 19.209999F, 22.68F, 22.959999F);
      ((Path)localObject2).cubicTo(24.4F, 28.110001F, 31.25F, 30.9F, 30.73F, 37.029999F);
      ((Path)localObject2).cubicTo(30.280001F, 45.110001F, 21.25F, 49.650002F, 13.94F, 49.09F);
      ((Path)localObject2).cubicTo(7.06F, 49.130001F, -1.04F, 43.720001F, 0.23F, 36.060001F);
      ((Path)localObject2).cubicTo(1.82F, 28.82F, 9.89F, 26.16F, 16.440001F, 25.719999F);
      ((Path)localObject2).cubicTo(16.459999F, 24.709999F, 16.49F, 23.690001F, 16.52F, 22.68F);
      ((Path)localObject2).cubicTo(11.51F, 22.110001F, 5.72F, 20.65F, 3.48F, 15.58F);
      ((Path)localObject2).lineTo(3.48F, 15.58F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.2F, 4.24F);
      ((Path)localObject2).cubicTo(8.59F, 5.84F, 8.82F, 12.22F, 11.58F, 15.43F);
      ((Path)localObject2).cubicTo(13.94F, 18.889999F, 19.98F, 20.67F, 22.690001F, 16.690001F);
      ((Path)localObject2).cubicTo(26.26F, 10.87F, 19.77F, 2.34F, 13.2F, 4.24F);
      ((Path)localObject2).lineTo(13.2F, 4.24F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.31F, 30.24F);
      ((Path)localObject2).cubicTo(10.57F, 31.120001F, 7.7F, 32.689999F, 6.5F, 35.459999F);
      ((Path)localObject2).cubicTo(5.37F, 38.41F, 7.39F, 41.77F, 10.27F, 42.73F);
      ((Path)localObject2).cubicTo(14.73F, 44.279999F, 19.99F, 43.529999F, 23.85F, 40.82F);
      ((Path)localObject2).cubicTo(25.120001F, 39.869999F, 26.66F, 38.07F, 25.41F, 36.509998F);
      ((Path)localObject2).cubicTo(22.73F, 32.790001F, 18.370001F, 28.18F, 13.31F, 30.24F);
      ((Path)localObject2).lineTo(13.31F, 30.24F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(40.610001F, 12.53F);
      ((Path)localObject2).lineTo(45.049999F, 12.53F);
      ((Path)localObject2).cubicTo(45.049999F, 15.02F, 45.049999F, 17.5F, 45.060001F, 19.99F);
      ((Path)localObject2).cubicTo(47.580002F, 20.0F, 50.09F, 20.01F, 52.610001F, 20.02F);
      ((Path)localObject2).cubicTo(52.599998F, 21.52F, 52.59F, 23.02F, 52.580002F, 24.52F);
      ((Path)localObject2).cubicTo(50.080002F, 24.52F, 47.57F, 24.530001F, 45.060001F, 24.540001F);
      ((Path)localObject2).cubicTo(45.049999F, 27.02F, 45.049999F, 29.51F, 45.049999F, 31.99F);
      ((Path)localObject2).cubicTo(43.57F, 32.0F, 42.080002F, 32.0F, 40.599998F, 32.0F);
      ((Path)localObject2).cubicTo(40.599998F, 29.51F, 40.59F, 27.030001F, 40.580002F, 24.540001F);
      ((Path)localObject2).cubicTo(38.07F, 24.530001F, 35.560001F, 24.52F, 33.049999F, 24.52F);
      ((Path)localObject2).lineTo(33.049999F, 20.01F);
      ((Path)localObject2).cubicTo(35.560001F, 20.0F, 38.080002F, 19.99F, 40.59F, 19.99F);
      ((Path)localObject2).cubicTo(40.599998F, 17.5F, 40.599998F, 15.02F, 40.610001F, 12.53F);
      ((Path)localObject2).lineTo(40.610001F, 12.53F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bmm
 * JD-Core Version:    0.7.0.1
 */