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

public final class btp
  extends c
{
  private final int height = 27;
  private final int width = 42;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 27;
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.5F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.5F);
      localPath.lineTo(26.0F, 0.5F);
      localPath.lineTo(26.0F, 24.5F);
      localPath.lineTo(0.0F, 24.5F);
      localPath.lineTo(0.0F, 0.5F);
      localPath.close();
      localPath.moveTo(2.0F, 2.5F);
      localPath.lineTo(2.0F, 22.5F);
      localPath.lineTo(24.0F, 22.5F);
      localPath.lineTo(24.0F, 2.5F);
      localPath.lineTo(2.0F, 2.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 27.363636F, 0.0F, 1.0F, 1.090909F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(31.008236F, 11.565939F);
      ((Path)localObject2).lineTo(31.002834F, 13.579968F);
      ((Path)localObject2).lineTo(39.986187F, 19.714403F);
      ((Path)localObject2).lineTo(39.997097F, 5.325294F);
      ((Path)localObject2).lineTo(31.008236F, 11.565939F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(29.011042F, 10.51777F);
      ((Path)localObject2).lineTo(42.0F, 1.5F);
      ((Path)localObject2).lineTo(41.983315F, 23.5F);
      ((Path)localObject2).lineTo(29.0F, 14.634123F);
      ((Path)localObject2).lineTo(29.011042F, 10.51777F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.btp
 * JD-Core Version:    0.7.0.1
 */