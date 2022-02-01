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

public final class brq
  extends c
{
  private final int height = 20;
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
      return 20;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(18.736526F, 15.312118F);
      ((Path)localObject2).cubicTo(18.688551F, 15.287715F, 18.641708F, 15.259116F, 18.596445F, 15.226229F);
      ((Path)localObject2).lineTo(0.766619F, 2.272103F);
      ((Path)localObject2).cubicTo(0.3186825F, 1.946658F, 0.2164554F, 1.323738F, 0.5433434F, 0.8738154F);
      ((Path)localObject2).cubicTo(0.8679683F, 0.4270076F, 1.4962F, 0.3300382F, 1.939853F, 0.6523712F);
      ((Path)localObject2).lineTo(19.354612F, 13.304935F);
      ((Path)localObject2).lineTo(19.457281F, 13.379528F);
      ((Path)localObject2).lineTo(19.457281F, 13.379528F);
      ((Path)localObject2).lineTo(19.559952F, 13.304935F);
      ((Path)localObject2).lineTo(36.974709F, 0.6523712F);
      ((Path)localObject2).cubicTo(37.418362F, 0.3300382F, 38.046597F, 0.4270076F, 38.37122F, 0.8738154F);
      ((Path)localObject2).cubicTo(38.698109F, 1.323738F, 38.595882F, 1.946658F, 38.147945F, 2.272103F);
      ((Path)localObject2).lineTo(20.623741F, 15.004182F);
      ((Path)localObject2).lineTo(19.49353F, 15.865662F);
      ((Path)localObject2).lineTo(18.736526F, 15.312118F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.brq
 * JD-Core Version:    0.7.0.1
 */