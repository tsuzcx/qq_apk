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

public class radar_member_bg
  extends c
{
  private final int height = 210;
  private final int width = 210;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 210;
      return 210;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Matrix localMatrix = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      c.instancePaint((Paint)localObject1, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-263173);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      Object localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.700001F, 33.630001F);
      ((Path)localObject2).cubicTo(40.27F, 15.91F, 62.450001F, 4.14F, 85.879997F, 1.28F);
      ((Path)localObject2).cubicTo(108.44F, -1.63F, 131.96001F, 3.59F, 151.09F, 15.93F);
      ((Path)localObject2).cubicTo(172.67F, 29.610001F, 188.49001F, 52.029999F, 194.03F, 76.980003F);
      ((Path)localObject2).cubicTo(200.74001F, 105.79F, 193.44F, 137.39999F, 174.77F, 160.34F);
      ((Path)localObject2).cubicTo(173.14999F, 160.22F, 171.53F, 160.10001F, 169.92F, 159.98F);
      ((Path)localObject2).cubicTo(183.87F, 143.67F, 192.17999F, 122.51F, 192.44F, 100.99F);
      ((Path)localObject2).cubicTo(193.16F, 79.559998F, 185.98F, 58.09F, 172.86F, 41.169998F);
      ((Path)localObject2).cubicTo(159.56F, 23.77F, 139.95F, 11.4F, 118.6F, 6.64F);
      ((Path)localObject2).cubicTo(99.239998F, 2.59F, 78.5F, 4.25F, 60.389999F, 12.4F);
      ((Path)localObject2).cubicTo(38.52F, 21.959999F, 20.59F, 40.16F, 11.33F, 62.16F);
      ((Path)localObject2).cubicTo(-0.62F, 90.040001F, 2.12F, 123.71F, 18.58F, 149.22F);
      ((Path)localObject2).cubicTo(17.559999F, 149.45F, 15.51F, 149.89999F, 14.49F, 150.13F);
      ((Path)localObject2).cubicTo(3.87F, 132.83F, -1.21F, 112.21F, 0.26F, 91.959999F);
      ((Path)localObject2).cubicTo(1.63F, 70.519997F, 10.41F, 49.66F, 24.700001F, 33.630001F);
      ((Path)localObject2).lineTo(24.700001F, 33.630001F);
      ((Path)localObject2).lineTo(24.700001F, 33.630001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(99.0F, 198.0F);
      ((Path)localObject1).cubicTo(153.67619F, 198.0F, 198.0F, 153.67619F, 198.0F, 99.0F);
      ((Path)localObject1).cubicTo(198.0F, 44.323811F, 153.67619F, 0.0F, 99.0F, 0.0F);
      ((Path)localObject1).cubicTo(44.323811F, 0.0F, 0.0F, 44.323811F, 0.0F, 99.0F);
      ((Path)localObject1).cubicTo(0.0F, 153.67619F, 44.323811F, 198.0F, 99.0F, 198.0F);
      ((Path)localObject1).lineTo(99.0F, 198.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(99.0F, 193.0F);
      ((Path)localObject1).cubicTo(150.91476F, 193.0F, 193.0F, 150.91476F, 193.0F, 99.0F);
      ((Path)localObject1).cubicTo(193.0F, 47.085232F, 150.91476F, 5.0F, 99.0F, 5.0F);
      ((Path)localObject1).cubicTo(47.085232F, 5.0F, 5.0F, 47.085232F, 5.0F, 99.0F);
      ((Path)localObject1).cubicTo(5.0F, 150.91476F, 47.085232F, 193.0F, 99.0F, 193.0F);
      ((Path)localObject1).lineTo(99.0F, 193.0F);
      ((Path)localObject1).close();
      localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 198.0F, 0.0F, 0.0F, 0.0F, 198.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.5F, 0.0F, 0.5F, 1.0F, new int[] { -1, -1184275 }, new float[] { 0.0F, 1.0F }, localMatrix, 0);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.radar_member_bg
 * JD-Core Version:    0.7.0.1
 */