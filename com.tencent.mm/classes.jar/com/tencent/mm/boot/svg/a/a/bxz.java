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

public final class bxz
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(14.8F, 6.2F);
      ((Path)localObject2).lineTo(12.0F, 6.2F);
      ((Path)localObject2).lineTo(12.0F, 5.0F);
      ((Path)localObject2).lineTo(15.001043F, 5.0F);
      ((Path)localObject2).cubicTo(15.55087F, 5.0F, 16.0F, 5.445839F, 16.0F, 5.995809F);
      ((Path)localObject2).lineTo(16.0F, 19.004192F);
      ((Path)localObject2).cubicTo(16.0F, 19.551081F, 15.554161F, 20.0F, 15.004191F, 20.0F);
      ((Path)localObject2).lineTo(0.9958085F, 20.0F);
      ((Path)localObject2).cubicTo(0.4489202F, 20.0F, 8.881784E-016F, 19.554161F, 8.881784E-016F, 19.004192F);
      ((Path)localObject2).lineTo(0.0F, 5.995809F);
      ((Path)localObject2).cubicTo(0.0F, 5.44892F, 0.447248F, 5.0F, 0.9989566F, 5.0F);
      ((Path)localObject2).lineTo(4.0F, 5.0F);
      ((Path)localObject2).lineTo(4.0F, 6.2F);
      ((Path)localObject2).lineTo(1.2F, 6.2F);
      ((Path)localObject2).lineTo(1.2F, 18.799999F);
      ((Path)localObject2).lineTo(14.8F, 18.799999F);
      ((Path)localObject2).lineTo(14.8F, 6.2F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.599994F, 2.261516F);
      ((Path)localObject2).lineTo(8.599994F, 11.5F);
      ((Path)localObject2).lineTo(7.399994F, 11.5F);
      ((Path)localObject2).lineTo(7.399994F, 2.261529F);
      ((Path)localObject2).lineTo(5.312995F, 4.348528F);
      ((Path)localObject2).lineTo(4.464466F, 3.5F);
      ((Path)localObject2).lineTo(7.292893F, 0.6715729F);
      ((Path)localObject2).cubicTo(7.683417F, 0.281049F, 8.316583F, 0.281049F, 8.707107F, 0.6715729F);
      ((Path)localObject2).lineTo(11.535534F, 3.5F);
      ((Path)localObject2).lineTo(10.687006F, 4.348528F);
      ((Path)localObject2).lineTo(8.599994F, 2.261516F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bxz
 * JD-Core Version:    0.7.0.1
 */