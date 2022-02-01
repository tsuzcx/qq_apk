package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bob
  extends c
{
  private final int height = 270;
  private final int width = 270;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 270;
      return 270;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1202386);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(130.84F, 0.0F);
      ((Path)localObject).lineTo(137.49001F, 0.0F);
      ((Path)localObject).cubicTo(169.21001F, 0.52F, 200.58F, 12.66F, 224.28F, 33.779999F);
      ((Path)localObject).cubicTo(252.31F, 58.189999F, 269.23001F, 94.639999F, 270.0F, 131.78999F);
      ((Path)localObject).lineTo(270.0F, 137.24001F);
      ((Path)localObject).cubicTo(269.54999F, 165.21001F, 260.20999F, 192.96001F, 243.45F, 215.38F);
      ((Path)localObject).cubicTo(219.22F, 248.49001F, 179.23F, 269.26001F, 138.21001F, 270.0F);
      ((Path)localObject).lineTo(131.99001F, 270.0F);
      ((Path)localObject).cubicTo(100.68F, 269.35999F, 69.790001F, 257.39999F, 46.259998F, 236.73F);
      ((Path)localObject).cubicTo(17.950001F, 212.27F, 0.75F, 175.62F, 0.0F, 138.21001F);
      ((Path)localObject).lineTo(0.0F, 132.67999F);
      ((Path)localObject).cubicTo(0.48F, 94.980003F, 17.709999F, 57.93F, 46.25F, 33.310001F);
      ((Path)localObject).cubicTo(69.470001F, 12.83F, 99.93F, 0.99F, 130.84F, 0.0F);
      ((Path)localObject).lineTo(130.84F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(71.0F, 135.0F);
      ((Path)localObject).cubicTo(85.651161F, 149.34F, 100.32233F, 163.67F, 114.98349F, 178.0F);
      ((Path)localObject).cubicTo(115.00349F, 166.66F, 114.98349F, 155.33F, 114.99349F, 144.0F);
      ((Path)localObject).cubicTo(142.32567F, 143.99001F, 169.66783F, 144.0F, 197.0F, 144.0F);
      ((Path)localObject).lineTo(197.0F, 127.0F);
      ((Path)localObject).lineTo(114.99349F, 127.0F);
      ((Path)localObject).cubicTo(114.98349F, 115.33F, 115.00349F, 103.67F, 114.98349F, 92.0F);
      ((Path)localObject).cubicTo(100.33233F, 106.34F, 85.651161F, 120.66F, 71.0F, 135.0F);
      ((Path)localObject).lineTo(71.0F, 135.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bob
 * JD-Core Version:    0.7.0.1
 */