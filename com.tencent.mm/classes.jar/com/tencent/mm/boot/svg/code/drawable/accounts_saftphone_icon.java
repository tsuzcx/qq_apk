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

public class accounts_saftphone_icon
  extends c
{
  private final int height = 480;
  private final int width = 480;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 480;
      return 480;
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
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-10197916);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 129.0F, 0.0F, 1.0F, 40.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      Object localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(52.880001F, 2.34F);
      ((Path)localObject3).cubicTo(83.169998F, -0.27F, 113.62F, -0.47F, 143.98F, 0.65F);
      ((Path)localObject3).cubicTo(164.16F, 1.66F, 184.48F, 2.9F, 204.2F, 7.55F);
      ((Path)localObject3).cubicTo(208.85001F, 9.09F, 214.17999F, 9.64F, 217.91F, 13.12F);
      ((Path)localObject3).cubicTo(220.31F, 15.36F, 220.97F, 18.860001F, 221.00999F, 22.01F);
      ((Path)localObject3).cubicTo(221.0F, 85.32F, 220.99001F, 148.62F, 221.00999F, 211.92999F);
      ((Path)localObject3).cubicTo(216.39F, 210.99001F, 211.71001F, 210.37F, 207.0F, 210.14999F);
      ((Path)localObject3).lineTo(207.0F, 39.0F);
      ((Path)localObject3).lineTo(15.0F, 39.0F);
      ((Path)localObject3).lineTo(15.0F, 349.0F);
      ((Path)localObject3).cubicTo(49.27F, 349.0F, 83.540001F, 348.98999F, 117.8F, 349.01001F);
      ((Path)localObject3).cubicTo(129.91F, 372.37F, 152.14999F, 390.17001F, 177.61F, 396.85001F);
      ((Path)localObject3).cubicTo(150.50999F, 399.69F, 123.22F, 400.29999F, 95.989998F, 399.85999F);
      ((Path)localObject3).cubicTo(76.599998F, 399.47F, 57.18F, 398.54001F, 37.939999F, 395.97F);
      ((Path)localObject3).cubicTo(27.889999F, 394.45001F, 17.59F, 393.03F, 8.270001F, 388.78F);
      ((Path)localObject3).cubicTo(3.72F, 386.79999F, 0.61F, 382.03F, 0.99F, 377.01999F);
      ((Path)localObject3).cubicTo(1.01F, 258.69F, 0.99F, 140.35001F, 1.0F, 22.01F);
      ((Path)localObject3).cubicTo(0.73F, 17.32F, 3.13F, 12.48F, 7.65F, 10.71F);
      ((Path)localObject3).cubicTo(22.18F, 5.57F, 37.619999F, 3.82F, 52.880001F, 2.34F);
      ((Path)localObject3).lineTo(52.880001F, 2.34F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(107.37F, 365.39999F);
      ((Path)localObject3).cubicTo(100.42F, 367.88F, 99.379997F, 378.51001F, 105.75F, 382.26001F);
      ((Path)localObject3).cubicTo(111.42F, 386.42999F, 120.38F, 381.97F, 120.53F, 374.95001F);
      ((Path)localObject3).cubicTo(121.31F, 368.17001F, 113.58F, 362.48001F, 107.37F, 365.39999F);
      ((Path)localObject3).lineTo(107.37F, 365.39999F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-11286451);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 236.0F, 0.0F, 1.0F, 250.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(40.380001F, 17.290001F);
      localPath.cubicTo(57.580002F, 5.08F, 78.949997F, -1.01F, 100.0F, 0.15F);
      localPath.cubicTo(104.71F, 0.37F, 109.39F, 0.99F, 114.01F, 1.93F);
      localPath.cubicTo(135.63F, 6.26F, 155.53F, 18.469999F, 169.23F, 35.740002F);
      localPath.cubicTo(183.27F, 53.169998F, 190.74001F, 75.709999F, 189.92999F, 98.07F);
      localPath.cubicTo(189.38F, 116.69F, 183.17999F, 135.10001F, 172.28999F, 150.23F);
      localPath.cubicTo(161.67F, 165.14F, 146.64F, 176.83F, 129.60001F, 183.48F);
      localPath.cubicTo(110.95F, 190.83F, 89.980003F, 191.94F, 70.610001F, 186.85001F);
      localPath.cubicTo(45.150002F, 180.17F, 22.91F, 162.37F, 10.8F, 139.00999F);
      localPath.cubicTo(0.55F, 119.56F, -2.54F, 96.470001F, 2.14F, 75.0F);
      localPath.cubicTo(6.99F, 51.849998F, 21.01F, 30.83F, 40.380001F, 17.290001F);
      localPath.lineTo(40.380001F, 17.290001F);
      localPath.close();
      localPath.moveTo(69.419998F, 54.369999F);
      localPath.cubicTo(64.32F, 63.419998F, 66.440002F, 74.110001F, 66.0F, 84.0F);
      localPath.cubicTo(61.380001F, 84.110001F, 56.740002F, 83.75F, 52.130001F, 84.169998F);
      localPath.cubicTo(50.68F, 84.919998F, 51.099998F, 86.639999F, 50.98F, 87.970001F);
      localPath.cubicTo(51.07F, 104.98F, 50.880001F, 121.99F, 51.080002F, 139.0F);
      localPath.cubicTo(50.869999F, 140.62F, 52.669998F, 141.14999F, 53.950001F, 140.98F);
      localPath.cubicTo(80.959999F, 141.03999F, 107.98F, 140.96001F, 135.0F, 141.02F);
      localPath.cubicTo(136.44F, 140.99001F, 139.11F, 141.2F, 138.92F, 139.00999F);
      localPath.cubicTo(139.12F, 122.0F, 138.92F, 104.97F, 139.02F, 87.949997F);
      localPath.cubicTo(138.89999F, 86.620003F, 139.3F, 84.910004F, 137.87F, 84.160004F);
      localPath.cubicTo(133.25999F, 83.760002F, 128.62F, 84.110001F, 124.0F, 84.0F);
      localPath.cubicTo(123.92F, 77.959999F, 124.16F, 71.93F, 123.88F, 65.900002F);
      localPath.cubicTo(123.25F, 54.07F, 114.44F, 43.279999F, 103.04F, 40.150002F);
      localPath.cubicTo(90.290001F, 36.189999F, 75.489998F, 42.52F, 69.419998F, 54.369999F);
      localPath.lineTo(69.419998F, 54.369999F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(78.300003F, 64.93F);
      ((Path)localObject3).cubicTo(79.699997F, 55.970001F, 89.18F, 49.400002F, 98.07F, 51.290001F);
      ((Path)localObject3).cubicTo(105.53F, 52.529999F, 111.64F, 59.330002F, 111.92F, 66.919998F);
      ((Path)localObject3).cubicTo(112.13F, 72.599998F, 111.93F, 78.300003F, 112.0F, 84.0F);
      ((Path)localObject3).lineTo(78.0F, 84.0F);
      ((Path)localObject3).cubicTo(78.160004F, 77.639999F, 77.650002F, 71.260002F, 78.300003F, 64.93F);
      ((Path)localObject3).lineTo(78.300003F, 64.93F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 286.0F, 0.0F, 1.0F, 288.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(19.42F, 16.370001F);
      ((Path)localObject2).cubicTo(25.49F, 4.52F, 40.290001F, -1.81F, 53.040001F, 2.15F);
      ((Path)localObject2).cubicTo(64.440002F, 5.28F, 73.25F, 16.07F, 73.879997F, 27.9F);
      ((Path)localObject2).cubicTo(74.160004F, 33.93F, 73.919998F, 39.959999F, 74.0F, 46.0F);
      ((Path)localObject2).cubicTo(78.620003F, 46.110001F, 83.260002F, 45.759998F, 87.870003F, 46.16F);
      ((Path)localObject2).cubicTo(89.300003F, 46.91F, 88.900002F, 48.619999F, 89.019997F, 49.950001F);
      ((Path)localObject2).cubicTo(88.919998F, 66.970001F, 89.120003F, 84.0F, 88.919998F, 101.01F);
      ((Path)localObject2).cubicTo(89.110001F, 103.2F, 86.440002F, 102.99F, 85.0F, 103.02F);
      ((Path)localObject2).cubicTo(57.98F, 102.96F, 30.959999F, 103.04F, 3.95F, 102.98F);
      ((Path)localObject2).cubicTo(2.67F, 103.15F, 0.87F, 102.62F, 1.08F, 101.0F);
      ((Path)localObject2).cubicTo(0.88F, 83.989998F, 1.07F, 66.980003F, 0.98F, 49.970001F);
      ((Path)localObject2).cubicTo(1.1F, 48.639999F, 0.68F, 46.919998F, 2.13F, 46.169998F);
      ((Path)localObject2).cubicTo(6.74F, 45.75F, 11.38F, 46.110001F, 16.0F, 46.0F);
      ((Path)localObject2).cubicTo(16.440001F, 36.110001F, 14.32F, 25.42F, 19.42F, 16.370001F);
      ((Path)localObject2).lineTo(19.42F, 16.370001F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(28.299999F, 26.93F);
      ((Path)localObject2).cubicTo(27.65F, 33.259998F, 28.16F, 39.639999F, 28.0F, 46.0F);
      ((Path)localObject2).lineTo(62.0F, 46.0F);
      ((Path)localObject2).cubicTo(61.93F, 40.299999F, 62.130001F, 34.599998F, 61.919998F, 28.92F);
      ((Path)localObject2).cubicTo(61.639999F, 21.33F, 55.529999F, 14.53F, 48.07F, 13.29F);
      ((Path)localObject2).cubicTo(39.18F, 11.4F, 29.700001F, 17.969999F, 28.299999F, 26.93F);
      ((Path)localObject2).lineTo(28.299999F, 26.93F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.accounts_saftphone_icon
 * JD-Core Version:    0.7.0.1
 */