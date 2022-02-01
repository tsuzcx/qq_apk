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

public final class bhh
  extends c
{
  private final int height = 84;
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
      return 84;
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
      localPaint1.setColor(-12206054);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(14.949F, 5.842577F);
      ((Path)localObject2).cubicTo(21.649F, 1.679292F, 29.638F, -0.2605797F, 37.502998F, 0.0289533F);
      ((Path)localObject2).cubicTo(45.467999F, 0.2965218F, 53.408001F, 2.88934F, 59.778F, 7.714557F);
      ((Path)localObject2).cubicTo(62.780998F, 9.984896F, 65.422997F, 12.749436F, 67.470001F, 15.911337F);
      ((Path)localObject2).cubicTo(69.411003F, 18.899517F, 70.805F, 22.249115F, 71.490997F, 25.747471F);
      ((Path)localObject2).cubicTo(72.316002F, 29.922737F, 72.130997F, 34.29269F, 70.953003F, 38.383091F);
      ((Path)localObject2).cubicTo(69.293999F, 44.209694F, 65.655998F, 49.370369F, 61.004002F, 53.215168F);
      ((Path)localObject2).cubicTo(55.825001F, 57.515232F, 49.43F, 60.263802F, 42.799F, 61.347054F);
      ((Path)localObject2).cubicTo(33.675999F, 62.845634F, 24.002001F, 61.304123F, 15.968F, 56.670597F);
      ((Path)localObject2).cubicTo(10.646F, 58.412785F, 5.323F, 60.156971F, 0.0F, 61.900162F);
      ((Path)localObject2).cubicTo(2.104F, 57.420387F, 4.21F, 52.942608F, 6.312F, 48.461834F);
      ((Path)localObject2).cubicTo(3.922F, 45.468662F, 2.079F, 42.025219F, 1.034F, 38.337166F);
      ((Path)localObject2).cubicTo(-0.644F, 32.517551F, -0.26F, 26.141836F, 2.082F, 20.557842F);
      ((Path)localObject2).cubicTo(4.618F, 14.419743F, 9.327F, 9.31897F, 14.949F, 5.842577F);
      ((Path)localObject2).lineTo(14.949F, 5.842577F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bhh
 * JD-Core Version:    0.7.0.1
 */