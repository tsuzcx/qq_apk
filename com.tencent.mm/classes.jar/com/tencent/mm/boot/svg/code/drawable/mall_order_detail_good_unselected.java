package com.tencent.mm.boot.svg.code.drawable;

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

public class mall_order_detail_good_unselected
  extends c
{
  private final int height = 132;
  private final int width = 132;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 132;
      return 132;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 1.224647E-016F, 132.0F, -1.224647E-016F, -1.0F, 132.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1907998);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(65.379997F, 0.0F);
      localPath.lineTo(68.18F, 0.0F);
      localPath.cubicTo(85.209999F, 0.57F, 101.88F, 7.96F, 113.62F, 20.32F);
      localPath.cubicTo(124.75F, 31.799999F, 131.3F, 47.43F, 132.0F, 63.380001F);
      localPath.lineTo(132.0F, 66.620003F);
      localPath.cubicTo(131.89999F, 83.949997F, 124.61F, 101.09F, 112.16F, 113.16F);
      localPath.cubicTo(100.64F, 124.56F, 84.790001F, 131.31F, 68.620003F, 132.0F);
      localPath.lineTo(63.810001F, 132.0F);
      localPath.cubicTo(47.0F, 131.44F, 30.52F, 124.23F, 18.82F, 112.13F);
      localPath.cubicTo(6.97F, 100.12F, 0.08F, 83.419998F, 0.0F, 66.540001F);
      localPath.lineTo(0.0F, 65.400002F);
      localPath.cubicTo(0.1F, 48.299999F, 7.18F, 31.4F, 19.33F, 19.360001F);
      localPath.cubicTo(31.360001F, 7.2F, 48.27F, 0.11F, 65.379997F, 0.0F);
      localPath.lineTo(65.379997F, 0.0F);
      localPath.close();
      localPath.moveTo(43.889999F, 43.93F);
      localPath.cubicTo(39.919998F, 44.73F, 38.860001F, 49.150002F, 40.220001F, 52.509998F);
      localPath.cubicTo(39.07F, 53.919998F, 37.349998F, 55.16F, 37.209999F, 57.139999F);
      localPath.cubicTo(37.060001F, 58.919998F, 38.18F, 60.48F, 38.790001F, 62.080002F);
      localPath.cubicTo(37.490002F, 63.779999F, 35.580002F, 65.5F, 36.049999F, 67.889999F);
      localPath.cubicTo(36.16F, 70.059998F, 38.139999F, 71.220001F, 39.59F, 72.519997F);
      localPath.cubicTo(38.439999F, 74.139999F, 36.68F, 75.730003F, 37.02F, 77.93F);
      localPath.cubicTo(37.169998F, 80.870003F, 39.950001F, 83.199997F, 42.860001F, 82.970001F);
      localPath.cubicTo(49.810001F, 83.099998F, 56.759998F, 82.949997F, 63.709999F, 82.989998F);
      localPath.cubicTo(62.689999F, 87.610001F, 62.310001F, 92.379997F, 63.049999F, 97.07F);
      localPath.cubicTo(63.599998F, 100.51F, 63.889999F, 104.86F, 67.459999F, 106.59F);
      localPath.cubicTo(69.150002F, 107.71F, 72.470001F, 108.45F, 73.279999F, 105.92F);
      localPath.cubicTo(73.720001F, 101.08F, 72.82F, 96.080002F, 74.5F, 91.379997F);
      localPath.cubicTo(76.470001F, 85.0F, 81.870003F, 78.589996F, 89.07F, 78.699997F);
      localPath.cubicTo(90.860001F, 78.379997F, 93.949997F, 78.599998F, 93.919998F, 76.019997F);
      localPath.cubicTo(94.0F, 66.769997F, 94.239998F, 57.490002F, 93.739998F, 48.25F);
      localPath.cubicTo(88.93F, 47.98F, 84.07F, 47.450001F, 79.68F, 45.330002F);
      localPath.cubicTo(68.559998F, 40.0F, 55.490002F, 40.720001F, 43.889999F, 43.93F);
      localPath.lineTo(43.889999F, 43.93F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-5000269);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 35.0F, 0.0F, 1.0F, 41.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.89F, 2.93F);
      ((Path)localObject2).cubicTo(20.49F, -0.28F, 33.560001F, -1.0F, 44.68F, 4.33F);
      ((Path)localObject2).cubicTo(49.07F, 6.45F, 53.93F, 6.98F, 58.740002F, 7.25F);
      ((Path)localObject2).cubicTo(59.240002F, 16.49F, 59.0F, 25.77F, 58.919998F, 35.02F);
      ((Path)localObject2).cubicTo(58.950001F, 37.599998F, 55.860001F, 37.380001F, 54.07F, 37.700001F);
      ((Path)localObject2).cubicTo(46.869999F, 37.59F, 41.470001F, 44.0F, 39.5F, 50.380001F);
      ((Path)localObject2).cubicTo(37.82F, 55.080002F, 38.720001F, 60.080002F, 38.279999F, 64.919998F);
      ((Path)localObject2).cubicTo(37.470001F, 67.449997F, 34.150002F, 66.709999F, 32.459999F, 65.589996F);
      ((Path)localObject2).cubicTo(28.889999F, 63.860001F, 28.6F, 59.509998F, 28.049999F, 56.07F);
      ((Path)localObject2).cubicTo(27.309999F, 51.380001F, 27.690001F, 46.610001F, 28.709999F, 41.990002F);
      ((Path)localObject2).cubicTo(21.76F, 41.950001F, 14.81F, 42.099998F, 7.86F, 41.970001F);
      ((Path)localObject2).cubicTo(4.95F, 42.200001F, 2.17F, 39.869999F, 2.02F, 36.93F);
      ((Path)localObject2).cubicTo(1.68F, 34.73F, 3.44F, 33.139999F, 4.59F, 31.52F);
      ((Path)localObject2).cubicTo(3.14F, 30.219999F, 1.16F, 29.059999F, 1.05F, 26.889999F);
      ((Path)localObject2).cubicTo(0.58F, 24.5F, 2.49F, 22.780001F, 3.79F, 21.08F);
      ((Path)localObject2).cubicTo(3.18F, 19.48F, 2.06F, 17.92F, 2.21F, 16.139999F);
      ((Path)localObject2).cubicTo(2.35F, 14.16F, 4.07F, 12.92F, 5.22F, 11.51F);
      ((Path)localObject2).cubicTo(3.86F, 8.15F, 4.92F, 3.73F, 8.89F, 2.93F);
      ((Path)localObject2).lineTo(8.89F, 2.93F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.mall_order_detail_good_unselected
 * JD-Core Version:    0.7.0.1
 */