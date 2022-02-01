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

public final class arl
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(18.5F, 0.0F);
      ((Path)localObject2).cubicTo(19.328426F, 0.0F, 20.0F, 0.6715729F, 20.0F, 1.5F);
      ((Path)localObject2).lineTo(20.0F, 14.5F);
      ((Path)localObject2).cubicTo(20.0F, 15.328427F, 19.328426F, 16.0F, 18.5F, 16.0F);
      ((Path)localObject2).lineTo(6.469687F, 16.0F);
      ((Path)localObject2).cubicTo(6.00243F, 16.0F, 5.561861F, 15.782256F, 5.278062F, 15.41106F);
      ((Path)localObject2).lineTo(0.3084652F, 8.91106F);
      ((Path)localObject2).cubicTo(-0.1027023F, 8.373273F, -0.1027023F, 7.626727F, 0.3084652F, 7.08894F);
      ((Path)localObject2).lineTo(5.278062F, 0.5889396F);
      ((Path)localObject2).cubicTo(5.561861F, 0.2177436F, 6.00243F, 0.0F, 6.469687F, 0.0F);
      ((Path)localObject2).lineTo(18.5F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.5F, 1.2F);
      ((Path)localObject2).lineTo(6.469687F, 1.2F);
      ((Path)localObject2).cubicTo(6.376235F, 1.2F, 6.288121F, 1.243549F, 6.231361F, 1.317788F);
      ((Path)localObject2).lineTo(1.261765F, 7.817788F);
      ((Path)localObject2).cubicTo(1.179531F, 7.925345F, 1.179531F, 8.074655F, 1.261765F, 8.182212F);
      ((Path)localObject2).lineTo(6.231361F, 14.682212F);
      ((Path)localObject2).cubicTo(6.288121F, 14.756452F, 6.376235F, 14.8F, 6.469687F, 14.8F);
      ((Path)localObject2).lineTo(18.5F, 14.8F);
      ((Path)localObject2).cubicTo(18.665686F, 14.8F, 18.799999F, 14.665686F, 18.799999F, 14.5F);
      ((Path)localObject2).lineTo(18.799999F, 1.5F);
      ((Path)localObject2).cubicTo(18.799999F, 1.334315F, 18.665686F, 1.2F, 18.5F, 1.2F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.0F, 4.0F);
      ((Path)localObject2).lineTo(16.0F, 5.0F);
      ((Path)localObject2).lineTo(13.0F, 8.0F);
      ((Path)localObject2).lineTo(16.0F, 11.0F);
      ((Path)localObject2).lineTo(15.0F, 12.0F);
      ((Path)localObject2).lineTo(12.0F, 9.0F);
      ((Path)localObject2).lineTo(9.0F, 12.0F);
      ((Path)localObject2).lineTo(8.0F, 11.0F);
      ((Path)localObject2).lineTo(11.0F, 8.0F);
      ((Path)localObject2).lineTo(8.0F, 5.0F);
      ((Path)localObject2).lineTo(9.0F, 4.0F);
      ((Path)localObject2).lineTo(12.0F, 7.0F);
      ((Path)localObject2).lineTo(15.0F, 4.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.arl
 * JD-Core Version:    0.7.0.1
 */