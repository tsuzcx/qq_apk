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

public final class amk
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      ((Paint)localObject2).setColor(-16515072);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(27.9F, 2.1F);
      ((Path)localObject3).lineTo(16.5F, 13.5F);
      ((Path)localObject3).lineTo(3.0F, 13.5F);
      ((Path)localObject3).cubicTo(1.2F, 13.5F, 0.0F, 14.7F, 0.0F, 16.5F);
      ((Path)localObject3).lineTo(0.0F, 31.5F);
      ((Path)localObject3).cubicTo(0.0F, 33.299999F, 1.2F, 34.5F, 3.0F, 34.5F);
      ((Path)localObject3).lineTo(16.5F, 34.5F);
      ((Path)localObject3).lineTo(27.9F, 45.900002F);
      ((Path)localObject3).cubicTo(28.5F, 46.5F, 29.1F, 46.799999F, 30.0F, 46.799999F);
      ((Path)localObject3).cubicTo(31.799999F, 46.799999F, 33.0F, 45.599998F, 33.0F, 43.799999F);
      ((Path)localObject3).lineTo(33.0F, 4.2F);
      ((Path)localObject3).cubicTo(33.0F, 3.3F, 32.700001F, 2.7F, 32.099998F, 2.1F);
      ((Path)localObject3).cubicTo(30.9F, 0.9F, 29.1F, 0.9F, 27.9F, 2.1F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(42.599998F, 35.700001F);
      ((Path)localObject2).lineTo(39.299999F, 32.400002F);
      ((Path)localObject2).lineTo(39.599998F, 32.099998F);
      ((Path)localObject2).cubicTo(41.700001F, 30.0F, 42.900002F, 27.0F, 42.900002F, 24.0F);
      ((Path)localObject2).cubicTo(42.900002F, 21.0F, 41.700001F, 18.0F, 39.599998F, 15.9F);
      ((Path)localObject2).lineTo(39.299999F, 15.6F);
      ((Path)localObject2).lineTo(42.599998F, 12.3F);
      ((Path)localObject2).lineTo(42.900002F, 12.6F);
      ((Path)localObject2).cubicTo(45.900002F, 15.6F, 47.700001F, 19.799999F, 47.700001F, 24.0F);
      ((Path)localObject2).cubicTo(47.700001F, 28.200001F, 45.900002F, 32.400002F, 42.900002F, 35.400002F);
      ((Path)localObject2).lineTo(42.599998F, 35.700001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.amk
 * JD-Core Version:    0.7.0.1
 */