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

public final class mi
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
      localPaint.setColor(-8617851);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(87.0F, 26.0F);
      ((Path)localObject).lineTo(81.0F, 32.0F);
      ((Path)localObject).cubicTo(80.878853F, 32.277943F, 80.900002F, 32.483356F, 81.0F, 33.0F);
      ((Path)localObject).lineTo(81.0F, 65.0F);
      ((Path)localObject).cubicTo(80.900002F, 67.141373F, 79.086952F, 68.944473F, 77.0F, 69.0F);
      ((Path)localObject).lineTo(20.0F, 69.0F);
      ((Path)localObject).cubicTo(17.91305F, 68.944473F, 16.1F, 67.141373F, 16.0F, 65.0F);
      ((Path)localObject).lineTo(16.0F, 33.0F);
      ((Path)localObject).cubicTo(16.1F, 32.483356F, 16.121149F, 32.277943F, 16.0F, 32.0F);
      ((Path)localObject).lineTo(10.0F, 26.0F);
      ((Path)localObject).cubicTo(8.75645F, 27.917215F, 8.0F, 30.216175F, 8.0F, 33.0F);
      ((Path)localObject).lineTo(8.0F, 65.0F);
      ((Path)localObject).cubicTo(8.0F, 71.590263F, 13.4396F, 77.0F, 20.0F, 77.0F);
      ((Path)localObject).lineTo(77.0F, 77.0F);
      ((Path)localObject).cubicTo(83.560402F, 77.0F, 89.0F, 71.590263F, 89.0F, 65.0F);
      ((Path)localObject).lineTo(89.0F, 33.0F);
      ((Path)localObject).cubicTo(89.0F, 30.216175F, 88.243553F, 27.917215F, 87.0F, 26.0F);
      ((Path)localObject).moveTo(17.0F, 22.0F);
      ((Path)localObject).lineTo(24.0F, 29.0F);
      ((Path)localObject).lineTo(24.0F, 29.0F);
      ((Path)localObject).lineTo(49.0F, 53.0F);
      ((Path)localObject).lineTo(73.0F, 29.0F);
      ((Path)localObject).lineTo(73.0F, 29.0F);
      ((Path)localObject).lineTo(80.0F, 22.0F);
      ((Path)localObject).cubicTo(80.486328F, 21.519585F, 80.482269F, 21.517807F, 80.0F, 22.0F);
      ((Path)localObject).lineTo(81.0F, 21.0F);
      ((Path)localObject).lineTo(77.0F, 21.0F);
      ((Path)localObject).cubicTo(77.000328F, 21.002222F, 76.968727F, 21.0F, 77.0F, 21.0F);
      ((Path)localObject).lineTo(20.0F, 21.0F);
      ((Path)localObject).cubicTo(20.031721F, 21.0F, 20.000126F, 21.002222F, 20.0F, 21.0F);
      ((Path)localObject).lineTo(16.0F, 21.0F);
      ((Path)localObject).lineTo(17.0F, 22.0F);
      ((Path)localObject).cubicTo(16.517733F, 21.517807F, 16.514122F, 21.519585F, 17.0F, 22.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.mi
 * JD-Core Version:    0.7.0.1
 */