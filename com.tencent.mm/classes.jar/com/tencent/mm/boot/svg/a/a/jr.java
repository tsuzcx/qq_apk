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

public final class jr
  extends c
{
  private final int height = 17;
  private final int width = 17;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 17;
      return 17;
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
      localPaint1.setColor(-11048043);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.3709773F, 3.937497F);
      ((Path)localObject2).lineTo(3.945679F, 3.937497F);
      ((Path)localObject2).lineTo(8.5F, 15.0F);
      ((Path)localObject2).lineTo(0.2260281F, 4.231666F);
      ((Path)localObject2).cubicTo(0.1645183F, 4.151613F, 0.1795507F, 4.036853F, 0.2596039F, 3.975344F);
      ((Path)localObject2).cubicTo(0.291545F, 3.950802F, 0.3306969F, 3.937497F, 0.3709773F, 3.937497F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(16.629023F, 3.937497F);
      ((Path)localObject2).lineTo(13.138271F, 3.937497F);
      ((Path)localObject2).lineTo(8.5F, 15.0F);
      ((Path)localObject2).lineTo(16.773972F, 4.231666F);
      ((Path)localObject2).cubicTo(16.835482F, 4.151613F, 16.82045F, 4.036853F, 16.740396F, 3.975344F);
      ((Path)localObject2).cubicTo(16.708456F, 3.950802F, 16.669304F, 3.937497F, 16.629023F, 3.937497F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(5.194445F, 3.937497F);
      ((Path)localObject2).lineTo(11.805555F, 3.937497F);
      ((Path)localObject2).lineTo(8.5F, 15.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(4.035354F, 2.8125F);
      ((Path)localObject2).lineTo(6.611111F, 0.0F);
      ((Path)localObject2).lineTo(3.923123F, 5.828671E-016F);
      ((Path)localObject2).cubicTo(3.884463F, 6.929792E-016F, 3.846798F, 0.01225696F, 3.815543F, 0.03500923F);
      ((Path)localObject2).lineTo(0.4541331F, 2.481918F);
      ((Path)localObject2).cubicTo(0.3725129F, 2.541333F, 0.3545118F, 2.655664F, 0.4139265F, 2.737284F);
      ((Path)localObject2).cubicTo(0.4483286F, 2.784544F, 0.5032581F, 2.8125F, 0.5617129F, 2.8125F);
      ((Path)localObject2).lineTo(4.035354F, 2.8125F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(7.555555F, 0.0F);
      ((Path)localObject2).lineTo(9.444445F, 0.0F);
      ((Path)localObject2).lineTo(11.805555F, 2.8125F);
      ((Path)localObject2).lineTo(5.194445F, 2.8125F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(13.150493F, 2.8125F);
      ((Path)localObject1).lineTo(10.388889F, 0.0F);
      ((Path)localObject1).lineTo(13.17345F, -2.775558E-017F);
      ((Path)localObject1).cubicTo(13.212875F, -2.051328E-017F, 13.251245F, 0.01274652F, 13.282832F, 0.03633791F);
      ((Path)localObject1).lineTo(16.559143F, 2.483247F);
      ((Path)localObject1).cubicTo(16.64003F, 2.543656F, 16.65663F, 2.6582F, 16.596218F, 2.739086F);
      ((Path)localObject1).cubicTo(16.561712F, 2.785289F, 16.507427F, 2.8125F, 16.44976F, 2.8125F);
      ((Path)localObject1).lineTo(13.150493F, 2.8125F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.jr
 * JD-Core Version:    0.7.0.1
 */