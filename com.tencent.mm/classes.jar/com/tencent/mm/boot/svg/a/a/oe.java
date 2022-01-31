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

public final class oe
  extends c
{
  private final int height = 216;
  private final int width = 216;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 216;
      return 216;
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
      localPaint1 = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(108.0F, 0.0F);
      localPath.cubicTo(167.64676F, 0.0F, 216.0F, 48.353245F, 216.0F, 108.0F);
      localPath.cubicTo(216.0F, 167.64676F, 167.64676F, 216.0F, 108.0F, 216.0F);
      localPath.cubicTo(48.353245F, 216.0F, 0.0F, 167.64676F, 0.0F, 108.0F);
      localPath.cubicTo(0.0F, 48.353245F, 48.353245F, 0.0F, 108.0F, 0.0F);
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
      arrayOfFloat = c.a(arrayOfFloat, 216.0F, 0.0F, 0.0F, 0.0F, 216.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.5F, 0.0F, 0.5F, 1.0F, new int[] { -1, -1 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      localCanvas.saveLayerAlpha(null, 230, 4);
      localCanvas.drawPath(localPath, c.a(localPaint1, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-15028967);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(70.794838F, 109.83536F);
      ((Path)localObject2).lineTo(73.466721F, 106.20732F);
      ((Path)localObject2).cubicTo(73.938324F, 105.56695F, 74.83976F, 105.43014F, 75.480133F, 105.90174F);
      ((Path)localObject2).cubicTo(75.487152F, 105.90691F, 75.494125F, 105.91215F, 75.501053F, 105.91744F);
      ((Path)localObject2).lineTo(94.422333F, 120.38942F);
      ((Path)localObject2).cubicTo(94.956024F, 120.79762F, 95.701073F, 120.78248F, 96.217735F, 120.35294F);
      ((Path)localObject2).lineTo(143.59654F, 80.964485F);
      ((Path)localObject2).cubicTo(144.16566F, 80.491348F, 145.00078F, 80.526672F, 145.52791F, 81.046181F);
      ((Path)localObject2).lineTo(147.82039F, 83.305527F);
      ((Path)localObject2).cubicTo(148.38681F, 83.86377F, 148.39345F, 84.775505F, 147.83521F, 85.341942F);
      ((Path)localObject2).cubicTo(147.82971F, 85.347511F, 147.82417F, 85.353043F, 147.81859F, 85.358528F);
      ((Path)localObject2).lineTo(96.367729F, 135.88878F);
      ((Path)localObject2).cubicTo(95.800316F, 136.44603F, 94.888596F, 136.43781F, 94.331345F, 135.87039F);
      ((Path)localObject2).cubicTo(94.328949F, 135.86795F, 94.326569F, 135.86551F, 94.324196F, 135.86307F);
      ((Path)localObject2).lineTo(70.9198F, 111.69095F);
      ((Path)localObject2).cubicTo(70.430756F, 111.18586F, 70.37793F, 110.40146F, 70.794838F, 109.83536F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.oe
 * JD-Core Version:    0.7.0.1
 */