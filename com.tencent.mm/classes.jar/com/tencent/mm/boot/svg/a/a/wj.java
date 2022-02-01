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

public final class wj
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -300.0F, 0.0F, 1.0F, -145.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 80.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 40.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, -1.0F, -1.224647E-016F, 336.0F, 1.224647E-016F, -1.0F, 61.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, -1.0F, 36.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(436207615);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(12.0F, 0.0F);
      ((Path)localObject2).cubicTo(18.627417F, 0.0F, 24.0F, 5.372583F, 24.0F, 12.0F);
      ((Path)localObject2).cubicTo(24.0F, 18.627417F, 18.627417F, 24.0F, 12.0F, 24.0F);
      ((Path)localObject2).cubicTo(5.372583F, 24.0F, 0.0F, 18.627417F, 0.0F, 12.0F);
      ((Path)localObject2).cubicTo(0.0F, 5.372583F, 5.372583F, 0.0F, 12.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 2.0F);
      ((Path)localObject2).cubicTo(6.477152F, 2.0F, 2.0F, 6.477152F, 2.0F, 12.0F);
      ((Path)localObject2).cubicTo(2.0F, 17.522848F, 6.477152F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject2).cubicTo(17.522848F, 22.0F, 22.0F, 17.522848F, 22.0F, 12.0F);
      ((Path)localObject2).cubicTo(22.0F, 6.477152F, 17.522848F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16268960);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(23.0F, 11.0F);
      ((Path)localObject1).cubicTo(23.552284F, 11.0F, 24.0F, 11.447716F, 24.0F, 12.0F);
      ((Path)localObject1).lineTo(24.0F, 12.0F);
      ((Path)localObject1).lineTo(24.0F, 12.0F);
      ((Path)localObject1).cubicTo(24.0F, 18.601927F, 18.668665F, 23.958654F, 12.076414F, 23.999762F);
      ((Path)localObject1).lineTo(12.017F, 23.999001F);
      ((Path)localObject1).lineTo(12.0F, 24.0F);
      ((Path)localObject1).cubicTo(11.487164F, 24.0F, 11.064493F, 23.61396F, 11.006728F, 23.116621F);
      ((Path)localObject1).lineTo(11.0F, 23.0F);
      ((Path)localObject1).cubicTo(11.0F, 22.447716F, 11.447716F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject1).lineTo(12.0F, 22.0F);
      ((Path)localObject1).cubicTo(17.522848F, 22.0F, 22.0F, 17.522848F, 22.0F, 12.0F);
      ((Path)localObject1).lineTo(22.0F, 11.999F);
      ((Path)localObject1).lineTo(22.006727F, 11.883379F);
      ((Path)localObject1).cubicTo(22.060049F, 11.424297F, 22.424297F, 11.060049F, 22.883379F, 11.006728F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.wj
 * JD-Core Version:    0.7.0.1
 */