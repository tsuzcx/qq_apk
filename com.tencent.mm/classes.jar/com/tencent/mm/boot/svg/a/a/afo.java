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

public final class afo
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15616);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(18.599894F, 29.96312F);
      ((Path)localObject2).cubicTo(19.577887F, 24.167274F, 24.161039F, 19.597342F, 29.96312F, 18.638449F);
      ((Path)localObject2).lineTo(29.96312F, 1.844108F);
      ((Path)localObject2).cubicTo(29.96312F, 0.8255191F, 29.137592F, 3.552714E-014F, 28.119265F, 3.552714E-014F);
      ((Path)localObject2).lineTo(27.684988F, 3.552714E-014F);
      ((Path)localObject2).cubicTo(27.196127F, 3.552714E-014F, 26.727163F, 0.194414F, 26.381355F, 0.5402176F);
      ((Path)localObject2).lineTo(0.5399535F, 26.381388F);
      ((Path)localObject2).cubicTo(0.1941467F, 26.726923F, -4.192202E-013F, 27.196152F, -4.192202E-013F, 27.685009F);
      ((Path)localObject2).lineTo(-4.192202E-013F, 28.11928F);
      ((Path)localObject2).cubicTo(-4.192202E-013F, 29.1376F, 0.825527F, 29.96312F, 1.843855F, 29.96312F);
      ((Path)localObject2).lineTo(18.599894F, 29.96312F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15683841);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(33.958202F, 18.649372F);
      ((Path)localObject2).cubicTo(39.728767F, 19.632206F, 44.280418F, 24.189543F, 45.254639F, 29.96312F);
      ((Path)localObject2).lineTo(61.770401F, 29.96312F);
      ((Path)localObject2).cubicTo(62.958126F, 29.96312F, 63.921322F, 29.000185F, 63.921322F, 27.81218F);
      ((Path)localObject2).lineTo(63.921322F, 27.768618F);
      ((Path)localObject2).cubicTo(63.921322F, 27.198277F, 63.694637F, 26.651064F, 63.29129F, 26.247711F);
      ((Path)localObject2).lineTo(37.673576F, 0.6300355F);
      ((Path)localObject2).cubicTo(37.270229F, 0.2264148F, 36.723019F, 3.552714E-014F, 36.152683F, 3.552714E-014F);
      ((Path)localObject2).lineTo(36.109123F, 3.552714E-014F);
      ((Path)localObject2).cubicTo(34.921127F, 3.552714E-014F, 33.958202F, 0.9629351F, 33.958202F, 2.15094F);
      ((Path)localObject2).lineTo(33.958202F, 18.649372F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-372399);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(29.96312F, 45.308418F);
      ((Path)localObject2).cubicTo(24.152487F, 44.348179F, 19.564535F, 39.766148F, 18.595694F, 33.958202F);
      ((Path)localObject2).lineTo(2.150921F, 33.958202F);
      ((Path)localObject2).cubicTo(0.9631953F, 33.958202F, -4.192202E-013F, 34.921127F, -4.192202E-013F, 36.109123F);
      ((Path)localObject2).lineTo(-4.192202E-013F, 36.128216F);
      ((Path)localObject2).cubicTo(-4.192202E-013F, 36.698547F, 0.2266817F, 37.245758F, 0.63003F, 37.649105F);
      ((Path)localObject2).lineTo(26.272215F, 63.29129F);
      ((Path)localObject2).cubicTo(26.675564F, 63.694637F, 27.222773F, 63.921322F, 27.793106F, 63.921322F);
      ((Path)localObject2).lineTo(27.812199F, 63.921322F);
      ((Path)localObject2).cubicTo(29.000193F, 63.921322F, 29.96312F, 62.958126F, 29.96312F, 61.770401F);
      ((Path)localObject2).lineTo(29.96312F, 45.308418F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16268960);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(45.258942F, 33.958202F);
      ((Path)localObject1).cubicTo(44.293594F, 39.743828F, 39.737373F, 44.312954F, 33.958202F, 45.297394F);
      ((Path)localObject1).lineTo(33.958202F, 61.770401F);
      ((Path)localObject1).cubicTo(33.958202F, 62.958126F, 34.921127F, 63.921322F, 36.109123F, 63.921322F);
      ((Path)localObject1).lineTo(36.171776F, 63.921322F);
      ((Path)localObject1).cubicTo(36.742111F, 63.921322F, 37.289318F, 63.694637F, 37.692669F, 63.29129F);
      ((Path)localObject1).lineTo(63.29129F, 37.692669F);
      ((Path)localObject1).cubicTo(63.694637F, 37.289318F, 63.921322F, 36.742111F, 63.921322F, 36.171776F);
      ((Path)localObject1).lineTo(63.921322F, 36.109123F);
      ((Path)localObject1).cubicTo(63.921322F, 34.921127F, 62.958126F, 33.958202F, 61.770401F, 33.958202F);
      ((Path)localObject1).lineTo(45.258942F, 33.958202F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.afo
 * JD-Core Version:    0.7.0.1
 */