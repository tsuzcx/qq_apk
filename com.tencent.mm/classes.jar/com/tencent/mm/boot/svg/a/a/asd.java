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

public final class asd
  extends c
{
  private final int height = 66;
  private final int width = 66;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 66;
      return 66;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-1);
      localPaint2.setStrokeWidth(3.6F);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(1.8F, 27.0F);
      localPath.cubicTo(1.8F, 13.082423F, 13.082423F, 1.8F, 27.0F, 1.8F);
      localPath.lineTo(39.000004F, 1.8F);
      localPath.cubicTo(52.91758F, 1.8F, 64.200005F, 13.082423F, 64.200005F, 27.0F);
      localPath.lineTo(64.200005F, 27.0F);
      localPath.cubicTo(64.200005F, 40.917576F, 52.91758F, 52.200001F, 39.000004F, 52.200001F);
      localPath.lineTo(27.0F, 52.200001F);
      localPath.cubicTo(13.082423F, 52.200001F, 1.8F, 40.917576F, 1.8F, 27.0F);
      localPath.lineTo(1.8F, 27.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, -0.7071068F, 28.757359F, 0.7071068F, 0.7071068F, -15.426407F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(31.0F, 25.0F);
      ((Path)localObject).lineTo(31.0F, 15.0F);
      ((Path)localObject).lineTo(35.0F, 15.0F);
      ((Path)localObject).lineTo(35.0F, 25.0F);
      ((Path)localObject).lineTo(45.0F, 25.0F);
      ((Path)localObject).lineTo(45.0F, 29.0F);
      ((Path)localObject).lineTo(35.0F, 29.0F);
      ((Path)localObject).lineTo(35.0F, 39.0F);
      ((Path)localObject).lineTo(31.0F, 39.0F);
      ((Path)localObject).lineTo(31.0F, 29.0F);
      ((Path)localObject).lineTo(21.0F, 29.0F);
      ((Path)localObject).lineTo(21.0F, 25.0F);
      ((Path)localObject).lineTo(31.0F, 25.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.asd
 * JD-Core Version:    0.7.0.1
 */