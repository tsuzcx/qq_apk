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

public final class vy
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
      ((Paint)localObject2).setColor(-436207616);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -280.0F, 0.0F, 1.0F, -40.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 279.0F, 0.0F, 1.0F, 39.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 0.451329F, 0.0F, 1.0F, 0.496923F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 2.548671F, 0.0F, 1.0F, 2.503077F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(10.0F, 0.0F);
      ((Path)localObject3).cubicTo(15.522847F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      ((Path)localObject3).cubicTo(20.0F, 15.522847F, 15.522847F, 20.0F, 10.0F, 20.0F);
      ((Path)localObject3).cubicTo(4.477152F, 20.0F, 0.0F, 15.522847F, 0.0F, 10.0F);
      ((Path)localObject3).cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(10.0F, 1.666667F);
      ((Path)localObject3).cubicTo(5.397627F, 1.666667F, 1.666667F, 5.397627F, 1.666667F, 10.0F);
      ((Path)localObject3).cubicTo(1.666667F, 14.602373F, 5.397627F, 18.333334F, 10.0F, 18.333334F);
      ((Path)localObject3).cubicTo(14.602373F, 18.333334F, 18.333334F, 14.602373F, 18.333334F, 10.0F);
      ((Path)localObject3).cubicTo(18.333334F, 5.397627F, 14.602373F, 1.666667F, 10.0F, 1.666667F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(13.400186F, 7.0F);
      ((Path)localObject2).lineTo(13.400015F, 15.271F);
      ((Path)localObject2).lineTo(15.856973F, 12.815718F);
      ((Path)localObject2).lineTo(17.104809F, 14.063553F);
      ((Path)localObject2).lineTo(13.15333F, 18.015032F);
      ((Path)localObject2).cubicTo(12.835256F, 18.333105F, 12.334758F, 18.357573F, 11.988618F, 18.088434F);
      ((Path)localObject2).lineTo(11.905494F, 18.015032F);
      ((Path)localObject2).lineTo(7.954015F, 14.063553F);
      ((Path)localObject2).lineTo(9.201851F, 12.815718F);
      ((Path)localObject2).lineTo(11.635015F, 15.25F);
      ((Path)localObject2).lineTo(11.63548F, 7.0F);
      ((Path)localObject2).lineTo(13.400186F, 7.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.vy
 * JD-Core Version:    0.7.0.1
 */