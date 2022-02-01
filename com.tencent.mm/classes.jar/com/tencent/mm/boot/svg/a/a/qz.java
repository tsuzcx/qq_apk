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

public final class qz
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 6.4F);
      ((Path)localObject2).cubicTo(0.0F, 2.865377F, 2.865377F, 0.0F, 6.4F, 0.0F);
      ((Path)localObject2).lineTo(41.599998F, 0.0F);
      ((Path)localObject2).cubicTo(45.134621F, 0.0F, 48.0F, 2.865377F, 48.0F, 6.4F);
      ((Path)localObject2).lineTo(48.0F, 41.599998F);
      ((Path)localObject2).cubicTo(48.0F, 45.134621F, 45.134621F, 48.0F, 41.599998F, 48.0F);
      ((Path)localObject2).lineTo(6.4F, 48.0F);
      ((Path)localObject2).cubicTo(2.865377F, 48.0F, 0.0F, 45.134621F, 0.0F, 41.599998F);
      ((Path)localObject2).lineTo(0.0F, 6.4F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(37.201889F, 9.6F);
      ((Path)localObject1).lineTo(41.727371F, 14.125484F);
      ((Path)localObject1).lineTo(23.889999F, 31.962F);
      ((Path)localObject1).lineTo(23.91362F, 31.985889F);
      ((Path)localObject1).lineTo(19.388138F, 36.511372F);
      ((Path)localObject1).lineTo(6.4F, 23.523235F);
      ((Path)localObject1).lineTo(10.925484F, 18.997753F);
      ((Path)localObject1).lineTo(19.365F, 27.437F);
      ((Path)localObject1).lineTo(37.201889F, 9.6F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.qz
 * JD-Core Version:    0.7.0.1
 */