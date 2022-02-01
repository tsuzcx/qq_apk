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

public final class agx
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -16.0F, 0.0F, 1.0F, -172.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 88.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 72.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-526345);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 4.0F);
      localPath.cubicTo(0.0F, 1.790861F, 1.790861F, 0.0F, 4.0F, 0.0F);
      localPath.lineTo(44.0F, 0.0F);
      localPath.cubicTo(46.209141F, 0.0F, 48.0F, 1.790861F, 48.0F, 4.0F);
      localPath.lineTo(48.0F, 44.0F);
      localPath.cubicTo(48.0F, 46.209141F, 46.209141F, 48.0F, 44.0F, 48.0F);
      localPath.lineTo(4.0F, 48.0F);
      localPath.cubicTo(1.790861F, 48.0F, 0.0F, 46.209141F, 0.0F, 44.0F);
      localPath.lineTo(0.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-15683841);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(14.75F, 26.5F);
      ((Path)localObject2).lineTo(7.483383F, 26.5F);
      ((Path)localObject2).cubicTo(7.217157F, 26.5F, 6.957885F, 26.414997F, 6.743334F, 26.257376F);
      ((Path)localObject2).cubicTo(6.187F, 25.848658F, 6.067334F, 25.06633F, 6.476052F, 24.509995F);
      ((Path)localObject2).lineTo(6.476016F, 24.50997F);
      ((Path)localObject2).cubicTo(7.825339F, 22.673313F, 8.5F, 20.836657F, 8.5F, 19.0F);
      ((Path)localObject2).lineTo(8.5F, 14.0F);
      ((Path)localObject2).cubicTo(8.5F, 10.72167F, 10.60339F, 7.934613F, 13.534245F, 6.914754F);
      ((Path)localObject2).cubicTo(13.511722F, 6.779853F, 13.5F, 6.641295F, 13.5F, 6.5F);
      ((Path)localObject2).cubicTo(13.5F, 5.119288F, 14.619288F, 4.0F, 16.0F, 4.0F);
      ((Path)localObject2).cubicTo(17.380713F, 4.0F, 18.5F, 5.119288F, 18.5F, 6.5F);
      ((Path)localObject2).cubicTo(18.5F, 6.641295F, 18.488277F, 6.779853F, 18.465754F, 6.914754F);
      ((Path)localObject2).cubicTo(21.39661F, 7.934613F, 23.5F, 10.72167F, 23.5F, 14.0F);
      ((Path)localObject2).lineTo(23.5F, 19.0F);
      ((Path)localObject2).cubicTo(23.5F, 20.836636F, 24.174646F, 22.673273F, 25.523939F, 24.509909F);
      ((Path)localObject2).cubicTo(25.68157F, 24.724472F, 25.766575F, 24.983759F, 25.766575F, 25.25F);
      ((Path)localObject2).cubicTo(25.766575F, 25.940376F, 25.206917F, 26.500036F, 24.516541F, 26.500036F);
      ((Path)localObject2).lineTo(17.25F, 26.5F);
      ((Path)localObject2).lineTo(17.25F, 26.75F);
      ((Path)localObject2).cubicTo(17.25F, 27.440355F, 16.690355F, 28.0F, 16.0F, 28.0F);
      ((Path)localObject2).cubicTo(15.309644F, 28.0F, 14.75F, 27.440355F, 14.75F, 26.75F);
      ((Path)localObject2).lineTo(14.75F, 26.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.agx
 * JD-Core Version:    0.7.0.1
 */