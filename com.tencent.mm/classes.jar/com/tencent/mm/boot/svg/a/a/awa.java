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

public final class awa
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(3.6F, 15.6F);
      localPath.lineTo(3.6F, 44.400002F);
      localPath.lineTo(44.400002F, 44.400002F);
      localPath.lineTo(44.400002F, 15.6F);
      localPath.lineTo(3.6F, 15.6F);
      localPath.close();
      localPath.moveTo(3.0F, 12.0F);
      localPath.lineTo(45.0F, 12.0F);
      localPath.cubicTo(46.656853F, 12.0F, 48.0F, 13.343145F, 48.0F, 15.0F);
      localPath.lineTo(48.0F, 45.0F);
      localPath.cubicTo(48.0F, 46.656853F, 46.656853F, 48.0F, 45.0F, 48.0F);
      localPath.lineTo(3.0F, 48.0F);
      localPath.cubicTo(1.343146F, 48.0F, 3.75562E-015F, 46.656853F, 3.552714E-015F, 45.0F);
      localPath.lineTo(3.552714E-015F, 15.0F);
      localPath.cubicTo(3.349808E-015F, 13.343145F, 1.343146F, 12.0F, 3.0F, 12.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 36.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(48.0F, 0.0F);
      ((Path)localObject).lineTo(57.0F, 0.0F);
      ((Path)localObject).cubicTo(58.656853F, -2.664535E-015F, 60.0F, 1.343146F, 60.0F, 3.0F);
      ((Path)localObject).lineTo(60.0F, 33.0F);
      ((Path)localObject).cubicTo(60.0F, 34.656853F, 58.656853F, 36.0F, 57.0F, 36.0F);
      ((Path)localObject).lineTo(15.0F, 36.0F);
      ((Path)localObject).cubicTo(13.343145F, 36.0F, 12.0F, 34.656853F, 12.0F, 33.0F);
      ((Path)localObject).lineTo(12.0F, 24.0F);
      ((Path)localObject).lineTo(15.6F, 24.0F);
      ((Path)localObject).lineTo(15.6F, 32.400002F);
      ((Path)localObject).lineTo(56.400002F, 32.400002F);
      ((Path)localObject).lineTo(56.400002F, 3.6F);
      ((Path)localObject).lineTo(48.0F, 3.6F);
      ((Path)localObject).lineTo(48.0F, 0.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.awa
 * JD-Core Version:    0.7.0.1
 */