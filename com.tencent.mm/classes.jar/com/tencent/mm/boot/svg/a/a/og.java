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

public final class og
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.6F, 5.661432F);
      ((Path)localObject2).lineTo(1.6F, 19.100517F);
      ((Path)localObject2).lineTo(23.733334F, 22.012798F);
      ((Path)localObject2).lineTo(23.733334F, 8.573713F);
      ((Path)localObject2).lineTo(1.6F, 5.661432F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.87462F, 0.8229694F);
      ((Path)localObject2).cubicTo(23.496151F, 0.7366458F, 24.0F, 1.171994F, 24.0F, 1.808224F);
      ((Path)localObject2).lineTo(24.0F, 1.808224F);
      ((Path)localObject2).lineTo(24.0F, 6.994067F);
      ((Path)localObject2).lineTo(24.212105F, 7.022918F);
      ((Path)localObject2).cubicTo(24.831343F, 7.104397F, 25.333334F, 7.687524F, 25.333334F, 8.316016F);
      ((Path)localObject2).lineTo(25.333334F, 22.501385F);
      ((Path)localObject2).cubicTo(25.333334F, 23.239088F, 24.7321F, 23.758005F, 24.006971F, 23.662594F);
      ((Path)localObject2).lineTo(1.121229F, 20.651312F);
      ((Path)localObject2).cubicTo(0.5019915F, 20.569834F, 0.0F, 19.986706F, 0.0F, 19.358213F);
      ((Path)localObject2).lineTo(0.0F, 5.172845F);
      ((Path)localObject2).lineTo(0.001F, 5.141067F);
      ((Path)localObject2).cubicTo(0.0F, 4.553124F, 0.4366655F, 4.008028F, 1.002308F, 3.867489F);
      ((Path)localObject2).lineTo(1.125379F, 3.843697F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.4F, 2.504247F);
      ((Path)localObject2).lineTo(6.576F, 4.702067F);
      ((Path)localObject2).lineTo(22.399F, 6.783067F);
      ((Path)localObject2).lineTo(22.4F, 2.504247F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.og
 * JD-Core Version:    0.7.0.1
 */