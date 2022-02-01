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

public final class dw
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -637.0F, 0.0F, 1.0F, -1392.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 637.0F, 0.0F, 1.0F, 1392.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-921103);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(40.0F, 0.0F);
      ((Path)localObject2).lineTo(40.0F, 40.0F);
      ((Path)localObject2).lineTo(0.0F, 40.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-3552823);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(16.955261F, 20.434963F);
      ((Path)localObject1).cubicTo(18.24053F, 22.476675F, 16.106638F, 23.401121F, 15.21541F, 23.914665F);
      ((Path)localObject1).cubicTo(11.381262F, 26.095942F, 9.705882F, 26.912895F, 9.705882F, 27.974316F);
      ((Path)localObject1).lineTo(9.705882F, 29.424192F);
      ((Path)localObject1).cubicTo(9.705882F, 29.890316F, 10.054523F, 30.294117F, 10.575808F, 30.294117F);
      ((Path)localObject1).lineTo(29.424192F, 30.294117F);
      ((Path)localObject1).cubicTo(29.945477F, 30.294117F, 30.294117F, 29.890316F, 30.294117F, 29.424192F);
      ((Path)localObject1).lineTo(30.294117F, 27.974316F);
      ((Path)localObject1).cubicTo(30.294117F, 26.912895F, 28.618738F, 26.095942F, 24.78459F, 23.914665F);
      ((Path)localObject1).cubicTo(23.893362F, 23.401121F, 21.75947F, 22.476675F, 23.044739F, 20.434963F);
      ((Path)localObject1).cubicTo(24.186148F, 18.739943F, 25.076778F, 18.04949F, 25.074566F, 15.21541F);
      ((Path)localObject1).cubicTo(25.076778F, 12.524936F, 23.08713F, 9.705882F, 20.144987F, 9.705882F);
      ((Path)localObject1).cubicTo(16.91287F, 9.705882F, 14.923222F, 12.524936F, 14.925435F, 15.21541F);
      ((Path)localObject1).cubicTo(14.923222F, 18.04949F, 15.813852F, 18.739943F, 16.955261F, 20.434963F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.dw
 * JD-Core Version:    0.7.0.1
 */