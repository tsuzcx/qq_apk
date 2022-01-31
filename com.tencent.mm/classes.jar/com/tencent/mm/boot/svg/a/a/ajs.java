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

public final class ajs
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
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
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
      localPaint2.setColor(-14046139);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(96.0F, 0.0F);
      localPath.lineTo(96.0F, 96.0F);
      localPath.lineTo(0.0F, 96.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 4);
      localCanvas.drawPath(localPath, c.a(localPaint2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 51, 4);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(20.25F, 36.0F);
      ((Path)localObject2).cubicTo(20.25F, 38.899052F, 17.89905F, 41.25F, 15.0F, 41.25F);
      ((Path)localObject2).cubicTo(12.10095F, 41.25F, 9.75F, 38.899052F, 9.75F, 36.0F);
      ((Path)localObject2).cubicTo(9.75F, 33.099899F, 12.10095F, 30.75F, 15.0F, 30.75F);
      ((Path)localObject2).cubicTo(17.89905F, 30.75F, 20.25F, 33.099899F, 20.25F, 36.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.0F, 30.75F);
      ((Path)localObject2).cubicTo(38.899052F, 30.75F, 41.25F, 33.099899F, 41.25F, 36.0F);
      ((Path)localObject2).cubicTo(41.25F, 38.899052F, 38.899052F, 41.25F, 36.0F, 41.25F);
      ((Path)localObject2).cubicTo(33.100948F, 41.25F, 30.75F, 38.899052F, 30.75F, 36.0F);
      ((Path)localObject2).cubicTo(30.75F, 33.099899F, 33.100948F, 30.75F, 36.0F, 30.75F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(57.0F, 30.75F);
      ((Path)localObject2).cubicTo(59.899052F, 30.75F, 62.25F, 33.099899F, 62.25F, 36.0F);
      ((Path)localObject2).cubicTo(62.25F, 38.899052F, 59.899052F, 41.25F, 57.0F, 41.25F);
      ((Path)localObject2).cubicTo(54.100948F, 41.25F, 51.75F, 38.899052F, 51.75F, 36.0F);
      ((Path)localObject2).cubicTo(51.75F, 33.099899F, 54.100948F, 30.75F, 57.0F, 30.75F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ajs
 * JD-Core Version:    0.7.0.1
 */