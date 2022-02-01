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

public final class agy
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
      localPaint2.setColor(-14671840);
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
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-15683841);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 204, 31);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(8.75F, 22.5F);
      ((Path)localObject2).lineTo(1.483383F, 22.5F);
      ((Path)localObject2).cubicTo(1.217157F, 22.5F, 0.9578847F, 22.414997F, 0.7433345F, 22.257376F);
      ((Path)localObject2).cubicTo(0.1870005F, 21.848658F, 0.06733385F, 21.06633F, 0.476052F, 20.509995F);
      ((Path)localObject2).lineTo(0.4760161F, 20.50997F);
      ((Path)localObject2).cubicTo(1.825339F, 18.673313F, 2.5F, 16.836657F, 2.5F, 15.0F);
      ((Path)localObject2).lineTo(2.5F, 10.0F);
      ((Path)localObject2).cubicTo(2.5F, 6.72167F, 4.60339F, 3.934614F, 7.534246F, 2.914754F);
      ((Path)localObject2).cubicTo(7.511722F, 2.779853F, 7.5F, 2.641295F, 7.5F, 2.5F);
      ((Path)localObject2).cubicTo(7.5F, 1.119288F, 8.619288F, 0.0F, 10.0F, 0.0F);
      ((Path)localObject2).cubicTo(11.380712F, 0.0F, 12.5F, 1.119288F, 12.5F, 2.5F);
      ((Path)localObject2).cubicTo(12.5F, 2.641295F, 12.488278F, 2.779853F, 12.465755F, 2.914754F);
      ((Path)localObject2).cubicTo(15.39661F, 3.934614F, 17.5F, 6.72167F, 17.5F, 10.0F);
      ((Path)localObject2).lineTo(17.5F, 15.0F);
      ((Path)localObject2).cubicTo(17.5F, 16.836636F, 18.174646F, 18.673273F, 19.523939F, 20.509909F);
      ((Path)localObject2).cubicTo(19.68157F, 20.724472F, 19.766575F, 20.983759F, 19.766575F, 21.25F);
      ((Path)localObject2).cubicTo(19.766575F, 21.940376F, 19.206917F, 22.500036F, 18.516541F, 22.500036F);
      ((Path)localObject2).lineTo(11.25F, 22.5F);
      ((Path)localObject2).lineTo(11.25F, 22.75F);
      ((Path)localObject2).cubicTo(11.25F, 23.440355F, 10.690356F, 24.0F, 10.0F, 24.0F);
      ((Path)localObject2).cubicTo(9.309644F, 24.0F, 8.75F, 23.440355F, 8.75F, 22.75F);
      ((Path)localObject2).lineTo(8.75F, 22.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.agy
 * JD-Core Version:    0.7.0.1
 */