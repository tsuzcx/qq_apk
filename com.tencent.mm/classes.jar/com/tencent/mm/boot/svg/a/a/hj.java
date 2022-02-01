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

public final class hj
  extends c
{
  private final int height = 25;
  private final int width = 28;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 28;
      return 25;
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -298.0F, 0.0F, 1.0F, -619.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 296.0F, 0.0F, 1.0F, 616.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      Paint localPaint3 = c.a(localPaint1, paramVarArgs);
      localPaint3.setColor(-16777216);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(24.095997F, 27.803995F);
      localPath.lineTo(23.107147F, 26.54546F);
      localPath.cubicTo(26.016209F, 24.375971F, 27.9F, 20.907978F, 27.9F, 17.0F);
      localPath.cubicTo(27.9F, 10.427812F, 22.572189F, 5.1F, 16.0F, 5.1F);
      localPath.cubicTo(9.427812F, 5.1F, 4.1F, 10.427812F, 4.1F, 17.0F);
      localPath.cubicTo(4.1F, 20.907978F, 5.983792F, 24.375971F, 8.892853F, 26.54546F);
      localPath.lineTo(7.904004F, 27.803995F);
      localPath.cubicTo(4.622721F, 25.341223F, 2.5F, 21.418505F, 2.5F, 17.0F);
      localPath.cubicTo(2.5F, 9.544156F, 8.544156F, 3.5F, 16.0F, 3.5F);
      localPath.cubicTo(23.455845F, 3.5F, 29.5F, 9.544156F, 29.5F, 17.0F);
      localPath.cubicTo(29.5F, 21.418505F, 27.377279F, 25.341223F, 24.095997F, 27.803995F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(1.6F);
      arrayOfFloat = c.a(arrayOfFloat, 0.9838699F, -0.1788854F, 2.886728F, 0.1788854F, 0.9838699F, -3.094001F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(16.585722F, 17.916044F);
      ((Path)localObject).lineTo(20.614008F, 11.004251F);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(16.0F, 15.5F);
      ((Path)localObject).cubicTo(17.10457F, 15.5F, 18.0F, 16.39543F, 18.0F, 17.5F);
      ((Path)localObject).cubicTo(18.0F, 18.60457F, 17.10457F, 19.5F, 16.0F, 19.5F);
      ((Path)localObject).cubicTo(14.895431F, 19.5F, 14.0F, 18.60457F, 14.0F, 17.5F);
      ((Path)localObject).cubicTo(14.0F, 16.39543F, 14.895431F, 15.5F, 16.0F, 15.5F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.hj
 * JD-Core Version:    0.7.0.1
 */