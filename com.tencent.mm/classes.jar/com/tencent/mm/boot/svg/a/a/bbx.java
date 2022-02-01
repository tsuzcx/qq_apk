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

public final class bbx
  extends c
{
  private final int height = 152;
  private final int width = 152;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 152;
      return 152;
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
      localObject2 = c.a((float[])localObject2, 1.333333F, 0.0F, 0.0F, 0.0F, 1.333333F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(47.299999F, 27.26F);
      ((Path)localObject2).cubicTo(55.290001F, 19.99F, 66.32F, 16.26F, 77.080002F, 17.15F);
      ((Path)localObject2).cubicTo(87.25F, 17.870001F, 97.029999F, 22.73F, 103.79F, 30.35F);
      ((Path)localObject2).cubicTo(110.22F, 37.439999F, 113.83F, 46.900002F, 114.0F, 56.439999F);
      ((Path)localObject2).lineTo(114.0F, 57.540001F);
      ((Path)localObject2).cubicTo(113.83F, 67.349998F, 110.01F, 77.059998F, 103.27F, 84.220001F);
      ((Path)localObject2).cubicTo(95.389999F, 92.800003F, 83.599998F, 97.589996F, 71.959999F, 96.919998F);
      ((Path)localObject2).cubicTo(61.450001F, 96.449997F, 51.240002F, 91.559998F, 44.25F, 83.690002F);
      ((Path)localObject2).cubicTo(37.23F, 75.959999F, 33.5F, 65.379997F, 34.080002F, 54.950001F);
      ((Path)localObject2).cubicTo(34.560001F, 44.439999F, 39.439999F, 34.240002F, 47.299999F, 27.26F);
      ((Path)localObject2).moveTo(67.419998F, 24.68F);
      ((Path)localObject2).cubicTo(59.029999F, 26.35F, 51.419998F, 31.459999F, 46.66F, 38.560001F);
      ((Path)localObject2).cubicTo(38.139999F, 50.73F, 39.470001F, 68.57F, 49.73F, 79.32F);
      ((Path)localObject2).cubicTo(59.869999F, 90.779999F, 78.269997F, 93.360001F, 91.169998F, 85.150002F);
      ((Path)localObject2).cubicTo(104.25F, 77.489998F, 110.42F, 60.23F, 105.1F, 46.02F);
      ((Path)localObject2).cubicTo(100.08F, 30.860001F, 83.019997F, 21.15F, 67.419998F, 24.68F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 28.780001F);
      ((Path)localObject2).cubicTo(0.29F, 26.23F, 2.33F, 23.98F, 5.01F, 24.07F);
      ((Path)localObject2).cubicTo(17.780001F, 23.889999F, 30.559999F, 24.07F, 43.34F, 23.99F);
      ((Path)localObject2).cubicTo(40.330002F, 27.049999F, 37.59F, 30.370001F, 35.299999F, 34.0F);
      ((Path)localObject2).cubicTo(25.219999F, 33.939999F, 15.13F, 34.110001F, 5.05F, 33.93F);
      ((Path)localObject2).cubicTo(2.51F, 34.040001F, 0.62F, 32.02F, 0.0F, 29.709999F);
      ((Path)localObject2).lineTo(0.0F, 28.780001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(60.310001F, 75.0F);
      ((Path)localObject2).cubicTo(60.32F, 63.57F, 60.299999F, 52.150002F, 60.32F, 40.73F);
      ((Path)localObject2).cubicTo(66.5F, 40.790001F, 72.690002F, 40.610001F, 78.870003F, 40.799999F);
      ((Path)localObject2).cubicTo(82.050003F, 40.880001F, 85.349998F, 42.189999F, 87.129997F, 44.93F);
      ((Path)localObject2).cubicTo(90.269997F, 49.459999F, 88.839996F, 56.75F, 83.419998F, 58.810001F);
      ((Path)localObject2).cubicTo(90.190002F, 61.419998F, 87.360001F, 69.709999F, 89.709999F, 75.019997F);
      ((Path)localObject2).cubicTo(87.230003F, 75.0F, 84.739998F, 74.989998F, 82.260002F, 74.989998F);
      ((Path)localObject2).cubicTo(81.029999F, 71.019997F, 82.07F, 66.199997F, 79.339996F, 62.82F);
      ((Path)localObject2).cubicTo(75.949997F, 60.689999F, 71.639999F, 61.93F, 67.849998F, 61.610001F);
      ((Path)localObject2).cubicTo(67.849998F, 66.080002F, 67.849998F, 70.540001F, 67.849998F, 75.0F);
      ((Path)localObject2).cubicTo(65.339996F, 75.0F, 62.82F, 75.0F, 60.310001F, 75.0F);
      ((Path)localObject2).moveTo(67.849998F, 46.59F);
      ((Path)localObject2).cubicTo(67.849998F, 49.799999F, 67.849998F, 53.009998F, 67.849998F, 56.23F);
      ((Path)localObject2).cubicTo(71.209999F, 56.169998F, 74.589996F, 56.450001F, 77.919998F, 55.990002F);
      ((Path)localObject2).cubicTo(82.300003F, 55.380001F, 82.470001F, 47.759998F, 78.18F, 46.860001F);
      ((Path)localObject2).cubicTo(74.760002F, 46.34F, 71.290001F, 46.66F, 67.849998F, 46.59F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 49.790001F);
      ((Path)localObject2).cubicTo(0.29F, 47.240002F, 2.32F, 44.98F, 5.0F, 45.07F);
      ((Path)localObject2).cubicTo(13.52F, 44.880001F, 22.059999F, 45.07F, 30.59F, 45.0F);
      ((Path)localObject2).cubicTo(29.83F, 48.290001F, 29.309999F, 51.630001F, 29.01F, 55.0F);
      ((Path)localObject2).cubicTo(21.01F, 54.939999F, 12.99F, 55.119999F, 4.99F, 54.93F);
      ((Path)localObject2).cubicTo(2.48F, 55.009998F, 0.63F, 53.0F, 0.0F, 50.73F);
      ((Path)localObject2).lineTo(0.0F, 49.790001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 70.790001F);
      ((Path)localObject2).cubicTo(0.29F, 68.239998F, 2.32F, 65.970001F, 5.01F, 66.07F);
      ((Path)localObject2).cubicTo(13.29F, 65.879997F, 21.59F, 66.059998F, 29.879999F, 66.0F);
      ((Path)localObject2).cubicTo(30.719999F, 69.410004F, 31.82F, 72.760002F, 33.169998F, 76.0F);
      ((Path)localObject2).cubicTo(23.799999F, 75.940002F, 14.42F, 76.110001F, 5.05F, 75.93F);
      ((Path)localObject2).cubicTo(2.51F, 76.029999F, 0.61F, 74.019997F, 0.0F, 71.709999F);
      ((Path)localObject2).lineTo(0.0F, 70.790001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 91.790001F);
      ((Path)localObject1).cubicTo(0.29F, 89.230003F, 2.33F, 86.970001F, 5.02F, 87.07F);
      ((Path)localObject1).cubicTo(16.82F, 86.910004F, 28.629999F, 87.029999F, 40.439999F, 87.019997F);
      ((Path)localObject1).cubicTo(44.150002F, 91.029999F, 48.5F, 94.410004F, 53.310001F, 97.019997F);
      ((Path)localObject1).cubicTo(37.209999F, 96.919998F, 21.1F, 97.120003F, 5.0F, 96.93F);
      ((Path)localObject1).cubicTo(2.48F, 97.019997F, 0.61F, 95.0F, 0.0F, 92.709999F);
      ((Path)localObject1).lineTo(0.0F, 91.790001F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbx
 * JD-Core Version:    0.7.0.1
 */