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

public final class pz
  extends c
{
  private final int height = 42;
  private final int width = 42;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 42;
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-5066062);
      ((Paint)localObject1).setStrokeWidth(3.1752F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.5876F, 2.1752F);
      ((Path)localObject2).cubicTo(1.5876F, 1.298393F, 2.298393F, 0.5875999F, 3.1752F, 0.5875999F);
      ((Path)localObject2).lineTo(38.824799F, 0.5875999F);
      ((Path)localObject2).cubicTo(39.701607F, 0.5875999F, 40.412399F, 1.298393F, 40.412399F, 2.1752F);
      ((Path)localObject2).lineTo(40.412399F, 27.8248F);
      ((Path)localObject2).cubicTo(40.412399F, 28.701607F, 39.701607F, 29.412401F, 38.824799F, 29.412401F);
      ((Path)localObject2).lineTo(3.1752F, 29.412401F);
      ((Path)localObject2).cubicTo(2.298393F, 29.412401F, 1.5876F, 28.701607F, 1.5876F, 27.8248F);
      ((Path)localObject2).lineTo(1.5876F, 2.1752F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-5066062);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(31.32F, 14.56F);
      ((Path)localObject1).lineTo(26.1F, 19.735001F);
      ((Path)localObject1).lineTo(28.188F, 23.875F);
      ((Path)localObject1).lineTo(13.572F, 10.42F);
      ((Path)localObject1).lineTo(0.0F, 22.84F);
      ((Path)localObject1).lineTo(0.0F, 29.049999F);
      ((Path)localObject1).lineTo(40.716F, 29.049999F);
      ((Path)localObject1).lineTo(40.716F, 22.84F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pz
 * JD-Core Version:    0.7.0.1
 */