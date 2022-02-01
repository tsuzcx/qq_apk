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

public final class bzn
  extends c
{
  private final int height = 240;
  private final int width = 240;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 240;
      return 240;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -4094.0F, 0.0F, 1.0F, -5370.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 4094.0F, 0.0F, 1.0F, 5370.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16268960);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(120.0F, 0.0F);
      ((Path)localObject2).cubicTo(186.27417F, 0.0F, 240.0F, 53.72583F, 240.0F, 120.0F);
      ((Path)localObject2).cubicTo(240.0F, 186.27417F, 186.27417F, 240.0F, 120.0F, 240.0F);
      ((Path)localObject2).cubicTo(53.72583F, 240.0F, 0.0F, 186.27417F, 0.0F, 120.0F);
      ((Path)localObject2).cubicTo(0.0F, 53.72583F, 53.72583F, 0.0F, 120.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(87.272728F, 109.09091F);
      ((Path)localObject1).lineTo(87.272728F, 121.55844F);
      ((Path)localObject1).cubicTo(87.272728F, 140.49391F, 102.62296F, 155.84416F, 121.55844F, 155.84416F);
      ((Path)localObject1).cubicTo(140.49391F, 155.84416F, 155.84416F, 140.49391F, 155.84416F, 121.55844F);
      ((Path)localObject1).lineTo(155.84416F, 109.09091F);
      ((Path)localObject1).lineTo(165.19481F, 109.09091F);
      ((Path)localObject1).lineTo(165.19481F, 121.55844F);
      ((Path)localObject1).cubicTo(165.19481F, 144.07864F, 148.13507F, 162.61435F, 126.23389F, 164.94727F);
      ((Path)localObject1).lineTo(126.23376F, 183.8961F);
      ((Path)localObject1).lineTo(116.88312F, 183.8961F);
      ((Path)localObject1).lineTo(116.88344F, 164.94731F);
      ((Path)localObject1).cubicTo(94.98204F, 162.61459F, 77.922081F, 144.0788F, 77.922081F, 121.55844F);
      ((Path)localObject1).lineTo(77.922081F, 109.09091F);
      ((Path)localObject1).lineTo(87.272728F, 109.09091F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(121.55844F, 59.220779F);
      ((Path)localObject1).cubicTo(135.3297F, 59.220779F, 146.4935F, 70.38459F, 146.4935F, 84.155846F);
      ((Path)localObject1).lineTo(146.4935F, 84.155846F);
      ((Path)localObject1).lineTo(146.4935F, 121.55844F);
      ((Path)localObject1).cubicTo(146.4935F, 135.3297F, 135.3297F, 146.4935F, 121.55844F, 146.4935F);
      ((Path)localObject1).cubicTo(107.78719F, 146.4935F, 96.623375F, 135.3297F, 96.623375F, 121.55844F);
      ((Path)localObject1).lineTo(96.623375F, 121.55844F);
      ((Path)localObject1).lineTo(96.623375F, 84.155846F);
      ((Path)localObject1).cubicTo(96.623375F, 70.38459F, 107.78719F, 59.220779F, 121.55844F, 59.220779F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bzn
 * JD-Core Version:    0.7.0.1
 */