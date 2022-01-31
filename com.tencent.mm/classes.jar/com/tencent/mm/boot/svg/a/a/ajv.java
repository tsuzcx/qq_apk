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

public final class ajv
  extends c
{
  private final int height = 210;
  private final int width = 210;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      c.a(localPaint1, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint1 = c.a((Paint)localObject2, paramVarArgs);
      localPaint1.setColor(-263173);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(24.700001F, 33.630001F);
      localPath.cubicTo(40.27F, 15.91F, 62.450001F, 4.14F, 85.879997F, 1.28F);
      localPath.cubicTo(108.44F, -1.63F, 131.96001F, 3.59F, 151.09F, 15.93F);
      localPath.cubicTo(172.67F, 29.610001F, 188.49001F, 52.029999F, 194.03F, 76.980003F);
      localPath.cubicTo(200.74001F, 105.79F, 193.44F, 137.39999F, 174.77F, 160.34F);
      localPath.cubicTo(173.14999F, 160.22F, 171.53F, 160.10001F, 169.92F, 159.98F);
      localPath.cubicTo(183.87F, 143.67F, 192.17999F, 122.51F, 192.44F, 100.99F);
      localPath.cubicTo(193.16F, 79.559998F, 185.98F, 58.09F, 172.86F, 41.169998F);
      localPath.cubicTo(159.56F, 23.77F, 139.95F, 11.4F, 118.6F, 6.64F);
      localPath.cubicTo(99.239998F, 2.59F, 78.5F, 4.25F, 60.389999F, 12.4F);
      localPath.cubicTo(38.52F, 21.959999F, 20.59F, 40.16F, 11.33F, 62.16F);
      localPath.cubicTo(-0.62F, 90.040001F, 2.12F, 123.71F, 18.58F, 149.22F);
      localPath.cubicTo(17.559999F, 149.45F, 15.51F, 149.89999F, 14.49F, 150.13F);
      localPath.cubicTo(3.87F, 132.83F, -1.21F, 112.21F, 0.26F, 91.959999F);
      localPath.cubicTo(1.63F, 70.519997F, 10.41F, 49.66F, 24.700001F, 33.630001F);
      localPath.lineTo(24.700001F, 33.630001F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a((Paint)localObject2, paramVarArgs);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(99.0F, 199.0F);
      localPath.cubicTo(153.67619F, 199.0F, 198.0F, 154.67619F, 198.0F, 100.0F);
      localPath.cubicTo(198.0F, 45.323811F, 153.67619F, 1.0F, 99.0F, 1.0F);
      localPath.cubicTo(44.323811F, 1.0F, 0.0F, 45.323811F, 0.0F, 100.0F);
      localPath.cubicTo(0.0F, 154.67619F, 44.323811F, 199.0F, 99.0F, 199.0F);
      localPath.close();
      localPath.moveTo(99.0F, 194.0F);
      localPath.cubicTo(150.91476F, 194.0F, 193.0F, 151.91476F, 193.0F, 100.0F);
      localPath.cubicTo(193.0F, 48.085232F, 150.91476F, 6.0F, 99.0F, 6.0F);
      localPath.cubicTo(47.085232F, 6.0F, 5.0F, 48.085232F, 5.0F, 100.0F);
      localPath.cubicTo(5.0F, 151.91476F, 47.085232F, 194.0F, 99.0F, 194.0F);
      localPath.close();
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint3 = c.i(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 198.0F, 0.0F, 0.0F, 0.0F, 199.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.5F, 0.0F, 0.5F, 1.0F, new int[] { -1, -1184275 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint1);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-13684945);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 38, 4);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(57.243538F, 7.868875F);
      ((Path)localObject2).cubicTo(75.306519F, -0.2599675F, 95.992676F, -1.915658F, 115.30242F, 2.123828F);
      ((Path)localObject2).cubicTo(136.597F, 6.871471F, 156.15608F, 19.209358F, 169.42155F, 36.564186F);
      ((Path)localObject2).cubicTo(182.50749F, 53.440262F, 189.66885F, 74.854523F, 188.95073F, 96.228889F);
      ((Path)localObject2).cubicTo(188.69141F, 117.69302F, 180.40297F, 138.7981F, 166.48918F, 155.06575F);
      ((Path)localObject2).cubicTo(153.29353F, 170.29611F, 135.36021F, 181.46703F, 115.63156F, 185.8157F);
      ((Path)localObject2).cubicTo(98.336578F, 189.47618F, 79.914528F, 188.66829F, 63.267857F, 182.54422F);
      ((Path)localObject2).cubicTo(43.688816F, 175.55243F, 26.673105F, 161.87802F, 15.542078F, 144.33368F);
      ((Path)localObject2).cubicTo(-0.8751906F, 118.88991F, -3.608077F, 85.30732F, 8.3109F, 57.499695F);
      ((Path)localObject2).cubicTo(17.54686F, 35.556808F, 35.430313F, 17.404057F, 57.243538F, 7.868875F);
      ((Path)localObject2).lineTo(57.243538F, 7.868875F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ajv
 * JD-Core Version:    0.7.0.1
 */