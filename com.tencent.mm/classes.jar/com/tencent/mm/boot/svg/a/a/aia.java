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

public final class aia
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-2147483648);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 9.6F);
      localPath.cubicTo(0.0F, 4.298066F, 4.298066F, 0.0F, 9.6F, 0.0F);
      localPath.lineTo(86.400002F, 0.0F);
      localPath.cubicTo(91.701935F, 0.0F, 96.0F, 4.298066F, 96.0F, 9.6F);
      localPath.lineTo(96.0F, 86.400002F);
      localPath.cubicTo(96.0F, 91.701935F, 91.701935F, 96.0F, 86.400002F, 96.0F);
      localPath.lineTo(9.6F, 96.0F);
      localPath.cubicTo(4.298066F, 96.0F, 0.0F, 91.701935F, 0.0F, 86.400002F);
      localPath.lineTo(0.0F, 9.6F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 75.943878F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(50.0103F, 25.920588F);
      ((Path)localObject).lineTo(50.0103F, 54.991493F);
      ((Path)localObject).lineTo(46.988003F, 54.989735F);
      ((Path)localObject).lineTo(46.988003F, 25.922291F);
      ((Path)localObject).lineTo(41.279999F, 31.652632F);
      ((Path)localObject).lineTo(39.0F, 29.363708F);
      ((Path)localObject).lineTo(46.587086F, 21.746929F);
      ((Path)localObject).cubicTo(47.639442F, 20.690456F, 49.348984F, 20.687119F, 50.405457F, 21.739473F);
      ((Path)localObject).cubicTo(50.407948F, 21.741953F, 50.410431F, 21.744438F, 50.412914F, 21.746929F);
      ((Path)localObject).lineTo(50.779999F, 22.115454F);
      ((Path)localObject).lineTo(58.0F, 29.363708F);
      ((Path)localObject).lineTo(55.720001F, 31.652632F);
      ((Path)localObject).lineTo(50.0103F, 25.920588F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(66.997154F, 35.043194F);
      ((Path)localObject).lineTo(59.003365F, 35.039516F);
      ((Path)localObject).lineTo(59.003365F, 32.0F);
      ((Path)localObject).lineTo(67.315308F, 32.0F);
      ((Path)localObject).cubicTo(68.792961F, 32.0F, 70.0F, 33.218624F, 70.0F, 34.721878F);
      ((Path)localObject).lineTo(70.0F, 68.278122F);
      ((Path)localObject).cubicTo(70.0F, 69.772949F, 68.801811F, 71.0F, 67.323761F, 71.0F);
      ((Path)localObject).lineTo(29.676235F, 71.0F);
      ((Path)localObject).cubicTo(28.206472F, 71.0F, 27.0F, 69.781372F, 27.0F, 68.278122F);
      ((Path)localObject).lineTo(27.0F, 34.721878F);
      ((Path)localObject).cubicTo(27.0F, 33.227047F, 28.201979F, 32.0F, 29.684696F, 32.0F);
      ((Path)localObject).lineTo(37.994774F, 32.0F);
      ((Path)localObject).lineTo(37.994774F, 35.045048F);
      ((Path)localObject).lineTo(29.999331F, 35.045048F);
      ((Path)localObject).lineTo(29.999331F, 67.929237F);
      ((Path)localObject).lineTo(66.997154F, 67.932915F);
      ((Path)localObject).lineTo(66.997154F, 35.043194F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aia
 * JD-Core Version:    0.7.0.1
 */