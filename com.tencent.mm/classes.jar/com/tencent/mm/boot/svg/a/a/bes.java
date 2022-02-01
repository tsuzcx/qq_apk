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

public final class bes
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localPaint2.setColor(-1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(30.0F, 0.0F);
      localPath.cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      localPath.cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      localPath.cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      localPath.cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1686720);
      arrayOfFloat = c.a(arrayOfFloat, 6.123234E-017F, 1.0F, -1.311783F, -1.0F, 6.123234E-017F, 61.688217F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(36.146671F, 51.0F);
      localPath.cubicTo(40.936661F, 45.963642F, 43.876438F, 39.151093F, 43.876438F, 31.651924F);
      localPath.cubicTo(43.876438F, 24.000854F, 40.81636F, 17.064505F, 35.853329F, 12.0F);
      localPath.lineTo(32.543938F, 15.309392F);
      localPath.cubicTo(36.660168F, 19.526825F, 39.196537F, 25.293175F, 39.196537F, 31.651924F);
      localPath.cubicTo(39.196537F, 37.858765F, 36.779907F, 43.501171F, 32.836227F, 47.689556F);
      localPath.lineTo(36.146671F, 51.0F);
      localPath.close();
      localPath.moveTo(28.464663F, 43.317989F);
      localPath.cubicTo(31.478422F, 40.347473F, 33.346668F, 36.217873F, 33.346668F, 31.651924F);
      localPath.cubicTo(33.346668F, 26.934067F, 31.352043F, 22.682077F, 28.160082F, 19.693247F);
      localPath.lineTo(24.848375F, 23.004953F);
      localPath.cubicTo(27.194576F, 25.144638F, 28.666769F, 28.226358F, 28.666769F, 31.651924F);
      localPath.cubicTo(28.666769F, 34.925556F, 27.322275F, 37.885162F, 25.155354F, 40.008682F);
      localPath.lineTo(28.464663F, 43.317989F);
      localPath.close();
      localPath.moveTo(21.018442F, 35.871773F);
      localPath.cubicTo(22.12694F, 34.807247F, 22.816896F, 33.310162F, 22.816896F, 31.651924F);
      localPath.cubicTo(22.816896F, 29.841587F, 21.994562F, 28.223316F, 20.703054F, 27.150274F);
      localPath.lineTo(16.5F, 31.353329F);
      localPath.lineTo(21.018442F, 35.871773F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, 0.7071068F, -8.70495F, -0.7071068F, 0.7071068F, 31.622213F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(31.568913F, 8.318913F);
      localPath.lineTo(36.068913F, 8.318913F);
      localPath.lineTo(36.068913F, 44.318913F);
      localPath.lineTo(31.568913F, 44.318913F);
      localPath.lineTo(31.568913F, 8.318913F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1686720);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, 0.7071068F, -11.485281F, -0.7071068F, 0.7071068F, 30.909903F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(29.568913F, 11.318913F);
      ((Path)localObject).lineTo(33.568913F, 11.318913F);
      ((Path)localObject).lineTo(33.568913F, 47.318913F);
      ((Path)localObject).lineTo(29.568913F, 47.318913F);
      ((Path)localObject).lineTo(29.568913F, 11.318913F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bes
 * JD-Core Version:    0.7.0.1
 */