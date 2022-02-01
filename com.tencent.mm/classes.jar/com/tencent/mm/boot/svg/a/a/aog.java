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

public final class aog
  extends c
{
  private final int height = 10;
  private final int width = 10;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 10;
      return 10;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -6.0F, 0.0F, 1.0F, -4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(6.0F, 1.0F);
      ((Path)localObject2).cubicTo(8.761424F, 1.0F, 11.0F, 3.238576F, 11.0F, 6.0F);
      ((Path)localObject2).cubicTo(11.0F, 8.761424F, 8.761424F, 11.0F, 6.0F, 11.0F);
      ((Path)localObject2).cubicTo(3.238576F, 11.0F, 1.0F, 8.761424F, 1.0F, 6.0F);
      ((Path)localObject2).cubicTo(1.0F, 3.238576F, 3.238576F, 1.0F, 6.0F, 1.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.375F, 3.0F);
      ((Path)localObject2).lineTo(5.625F, 3.0F);
      ((Path)localObject2).lineTo(5.625F, 5.999F);
      ((Path)localObject2).lineTo(5.625F, 6.00033F);
      ((Path)localObject2).lineTo(7.74632F, 8.121651F);
      ((Path)localObject2).lineTo(8.27665F, 7.59132F);
      ((Path)localObject2).lineTo(6.375F, 5.689F);
      ((Path)localObject2).lineTo(6.375F, 3.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aog
 * JD-Core Version:    0.7.0.1
 */