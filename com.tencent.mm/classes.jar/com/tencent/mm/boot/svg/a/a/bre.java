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

public final class bre
  extends c
{
  private final int height = 222;
  private final int width = 222;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 222;
      return 222;
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-11286451);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(106.78F, 0.0F);
      localPath.lineTo(114.26F, 0.0F);
      localPath.cubicTo(143.67F, 0.83F, 172.5F, 13.86F, 192.39999F, 35.560001F);
      localPath.cubicTo(210.27F, 54.610001F, 220.71001F, 80.129997F, 222.0F, 106.17F);
      localPath.lineTo(222.0F, 115.49F);
      localPath.cubicTo(220.85001F, 140.92999F, 210.92999F, 165.91F, 193.85001F, 184.84F);
      localPath.cubicTo(173.91F, 207.48F, 144.39999F, 221.16F, 114.26F, 222.0F);
      localPath.lineTo(107.88F, 222.0F);
      localPath.cubicTo(78.879997F, 221.22F, 50.43F, 208.59F, 30.549999F, 187.44F);
      localPath.cubicTo(12.11F, 168.27F, 1.27F, 142.3F, 0.0F, 115.78F);
      localPath.lineTo(0.0F, 107.09F);
      localPath.cubicTo(1.01F, 80.269997F, 11.92F, 53.950001F, 30.530001F, 34.57F);
      localPath.cubicTo(50.169998F, 13.67F, 78.160004F, 1.14F, 106.78F, 0.0F);
      localPath.lineTo(106.78F, 0.0F);
      localPath.close();
      localPath.moveTo(166.75F, 67.699997F);
      localPath.cubicTo(141.11F, 93.18F, 115.52F, 118.69F, 89.879997F, 144.16F);
      localPath.cubicTo(78.650002F, 133.03999F, 67.470001F, 121.87F, 56.259998F, 110.74F);
      localPath.cubicTo(55.32F, 109.66F, 53.84F, 108.99F, 52.43F, 109.53F);
      localPath.cubicTo(49.779999F, 111.27F, 45.099998F, 115.1F, 48.700001F, 118.23F);
      localPath.cubicTo(60.560001F, 130.06F, 72.470001F, 141.86F, 84.32F, 153.7F);
      localPath.cubicTo(85.660004F, 154.99001F, 86.879997F, 156.46001F, 88.470001F, 157.46001F);
      localPath.cubicTo(90.129997F, 158.14F, 91.93F, 157.42F, 93.019997F, 156.09F);
      localPath.cubicTo(120.24F, 128.92999F, 147.59F, 101.89F, 174.75F, 74.68F);
      localPath.cubicTo(177.24001F, 72.169998F, 174.10001F, 69.349998F, 172.21001F, 67.690002F);
      localPath.cubicTo(170.84F, 65.919998F, 168.10001F, 65.879997F, 166.75F, 67.699997F);
      localPath.lineTo(166.75F, 67.699997F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 47.0F, 0.0F, 1.0F, 66.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(119.75F, 1.7F);
      ((Path)localObject2).cubicTo(121.1F, -0.12F, 123.84F, -0.08F, 125.21F, 1.69F);
      ((Path)localObject2).cubicTo(127.1F, 3.35F, 130.24001F, 6.17F, 127.75F, 8.68F);
      ((Path)localObject2).cubicTo(100.59F, 35.889999F, 73.239998F, 62.93F, 46.02F, 90.089996F);
      ((Path)localObject2).cubicTo(44.93F, 91.419998F, 43.130001F, 92.139999F, 41.470001F, 91.459999F);
      ((Path)localObject2).cubicTo(39.880001F, 90.459999F, 38.66F, 88.989998F, 37.32F, 87.699997F);
      ((Path)localObject2).cubicTo(25.469999F, 75.860001F, 13.56F, 64.059998F, 1.7F, 52.23F);
      ((Path)localObject2).cubicTo(-1.9F, 49.099998F, 2.78F, 45.27F, 5.43F, 43.529999F);
      ((Path)localObject2).cubicTo(6.84F, 42.990002F, 8.32F, 43.66F, 9.26F, 44.740002F);
      ((Path)localObject2).cubicTo(20.469999F, 55.869999F, 31.65F, 67.040001F, 42.880001F, 78.160004F);
      ((Path)localObject2).cubicTo(68.519997F, 52.689999F, 94.110001F, 27.18F, 119.75F, 1.7F);
      ((Path)localObject2).lineTo(119.75F, 1.7F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bre
 * JD-Core Version:    0.7.0.1
 */