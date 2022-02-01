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

public final class sv
  extends c
{
  private final int height = 204;
  private final int width = 264;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 264;
      return 204;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-13158344);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(245.998F, 169.00011F);
      ((Path)localObject2).lineTo(152.0F, 169.00011F);
      ((Path)localObject2).lineTo(152.0F, 169.00011F);
      ((Path)localObject2).lineTo(108.0F, 169.00011F);
      ((Path)localObject2).lineTo(108.0F, 169.00011F);
      ((Path)localObject2).lineTo(14.002F, 169.00011F);
      ((Path)localObject2).cubicTo(7.936F, 169.00011F, 3.0F, 164.0641F, 3.0F, 157.9971F);
      ((Path)localObject2).lineTo(3.0F, 138.00011F);
      ((Path)localObject2).lineTo(257.0F, 138.00011F);
      ((Path)localObject2).lineTo(257.0F, 157.9971F);
      ((Path)localObject2).cubicTo(257.0F, 164.0641F, 252.064F, 169.00011F, 245.998F, 169.00011F);
      ((Path)localObject2).lineTo(245.998F, 169.00011F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.002F, 3.0001F);
      ((Path)localObject2).lineTo(245.998F, 3.0001F);
      ((Path)localObject2).cubicTo(252.064F, 3.0001F, 257.0F, 7.9361F, 257.0F, 14.0021F);
      ((Path)localObject2).lineTo(257.0F, 136.00011F);
      ((Path)localObject2).lineTo(3.0F, 136.00011F);
      ((Path)localObject2).lineTo(3.0F, 14.0021F);
      ((Path)localObject2).cubicTo(3.0F, 7.9361F, 7.936F, 3.0001F, 14.002F, 3.0001F);
      ((Path)localObject2).lineTo(14.002F, 3.0001F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(164.703F, 197.00011F);
      ((Path)localObject2).lineTo(95.296997F, 197.00011F);
      ((Path)localObject2).lineTo(107.697F, 194.5201F);
      ((Path)localObject2).lineTo(110.634F, 172.00011F);
      ((Path)localObject2).lineTo(149.366F, 172.00011F);
      ((Path)localObject2).lineTo(152.30299F, 194.5201F);
      ((Path)localObject2).lineTo(164.703F, 197.00011F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(245.998F, 1.0E-004F);
      ((Path)localObject2).lineTo(14.002F, 1.0E-004F);
      ((Path)localObject2).cubicTo(6.266F, 1.0E-004F, 0.0F, 6.2691F, 0.0F, 14.0021F);
      ((Path)localObject2).lineTo(0.0F, 157.9971F);
      ((Path)localObject2).cubicTo(0.0F, 165.7261F, 6.269F, 172.00011F, 14.002F, 172.00011F);
      ((Path)localObject2).lineTo(107.609F, 172.00011F);
      ((Path)localObject2).lineTo(105.0F, 192.00011F);
      ((Path)localObject2).lineTo(90.0F, 195.00011F);
      ((Path)localObject2).lineTo(90.0F, 200.00011F);
      ((Path)localObject2).lineTo(170.0F, 200.00011F);
      ((Path)localObject2).lineTo(170.0F, 195.00011F);
      ((Path)localObject2).lineTo(155.0F, 192.00011F);
      ((Path)localObject2).lineTo(152.39101F, 172.00011F);
      ((Path)localObject2).lineTo(245.998F, 172.00011F);
      ((Path)localObject2).cubicTo(253.73399F, 172.00011F, 260.0F, 165.73109F, 260.0F, 157.9971F);
      ((Path)localObject2).lineTo(260.0F, 14.0021F);
      ((Path)localObject2).cubicTo(260.0F, 6.2741F, 253.731F, 1.0E-004F, 245.998F, 1.0E-004F);
      ((Path)localObject2).lineTo(245.998F, 1.0E-004F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sv
 * JD-Core Version:    0.7.0.1
 */