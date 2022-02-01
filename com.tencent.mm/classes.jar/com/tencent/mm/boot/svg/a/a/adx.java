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

public final class adx
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
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-6710887);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(1.368062F, 0.5190846F);
      ((Path)localObject3).cubicTo(2.736124F, -0.3094543F, 4.473662F, 0.1597184F, 5.991512F, 1.776357E-015F);
      ((Path)localObject3).cubicTo(13.011567F, 0.08984157F, 20.041607F, -0.07985918F, 27.061663F, 0.06987678F);
      ((Path)localObject3).cubicTo(28.55954F, -0.04991199F, 29.947575F, 1.407518F, 29.917616F, 2.864948F);
      ((Path)localObject3).cubicTo(30.027462F, 8.275407F, 30.027462F, 13.695848F, 29.917616F, 19.106308F);
      ((Path)localObject3).cubicTo(29.977531F, 20.543774F, 28.599483F, 22.021168F, 27.14155F, 21.921345F);
      ((Path)localObject3).cubicTo(19.053009F, 22.031151F, 10.964467F, 22.021168F, 2.885912F, 21.921345F);
      ((Path)localObject3).cubicTo(1.388034F, 22.021168F, -0.01997171F, 20.553755F, 0.06990098F, 19.066378F);
      ((Path)localObject3).cubicTo(-0.07988682F, 14.374652F, 0.06990098F, 9.672943F, -1.776357E-015F, 4.971234F);
      ((Path)localObject3).cubicTo(0.04992927F, 3.41398F, -0.1997171F, 1.45743F, 1.368062F, 0.5190846F);
      ((Path)localObject3).lineTo(1.368062F, 0.5190846F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(3.131044F, 3.122275F);
      ((Path)localObject3).cubicTo(2.961345F, 8.367886F, 2.951363F, 13.633441F, 3.131044F, 18.889025F);
      ((Path)localObject3).cubicTo(11.047008F, 19.028641F, 18.972954F, 19.048586F, 26.888916F, 18.879051F);
      ((Path)localObject3).cubicTo(27.038651F, 13.633441F, 27.038651F, 8.377858F, 26.878935F, 3.132247F);
      ((Path)localObject3).cubicTo(18.962971F, 2.942767F, 11.047008F, 2.972685F, 3.131044F, 3.122275F);
      ((Path)localObject3).lineTo(3.131044F, 3.122275F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(38.059219F, 3.713281F);
      ((Path)localObject2).lineTo(38.059219F, 18.280001F);
      ((Path)localObject2).cubicTo(35.911186F, 17.24404F, 33.821373F, 15.385892F, 32.0F, 13.894882F);
      ((Path)localObject2).cubicTo(32.009899F, 11.97787F, 32.009899F, 10.060858F, 32.009899F, 8.153527F);
      ((Path)localObject2).cubicTo(33.801579F, 6.652835F, 36.020073F, 4.894471F, 38.059219F, 3.713281F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.adx
 * JD-Core Version:    0.7.0.1
 */