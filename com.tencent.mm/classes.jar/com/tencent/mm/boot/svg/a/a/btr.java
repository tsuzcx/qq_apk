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

public final class btr
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-419430401);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(9.3F, 0.7F);
      ((Path)localObject2).cubicTo(9.7F, 0.3F, 10.3F, 0.3F, 10.7F, 0.7F);
      ((Path)localObject2).cubicTo(10.9F, 0.9F, 11.0F, 1.1F, 11.0F, 1.4F);
      ((Path)localObject2).lineTo(11.0F, 14.6F);
      ((Path)localObject2).cubicTo(11.0F, 15.2F, 10.6F, 15.6F, 10.0F, 15.6F);
      ((Path)localObject2).cubicTo(9.7F, 15.6F, 9.5F, 15.5F, 9.3F, 15.3F);
      ((Path)localObject2).lineTo(5.5F, 11.5F);
      ((Path)localObject2).lineTo(1.0F, 11.5F);
      ((Path)localObject2).cubicTo(0.4F, 11.5F, 0.0F, 11.1F, 0.0F, 10.5F);
      ((Path)localObject2).lineTo(0.0F, 5.5F);
      ((Path)localObject2).cubicTo(0.0F, 4.9F, 0.4F, 4.5F, 1.0F, 4.5F);
      ((Path)localObject2).lineTo(5.5F, 4.5F);
      ((Path)localObject2).lineTo(9.3F, 0.7F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.200001F, 13.9F);
      ((Path)localObject2).lineTo(15.1F, 12.8F);
      ((Path)localObject2).lineTo(15.2F, 12.7F);
      ((Path)localObject2).cubicTo(16.5F, 11.4F, 17.1F, 9.8F, 17.1F, 8.0F);
      ((Path)localObject2).cubicTo(17.1F, 6.2F, 16.4F, 4.6F, 15.2F, 3.3F);
      ((Path)localObject2).lineTo(15.1F, 3.2F);
      ((Path)localObject2).lineTo(16.200001F, 2.1F);
      ((Path)localObject2).lineTo(16.299999F, 2.2F);
      ((Path)localObject2).cubicTo(17.799999F, 3.7F, 18.700001F, 5.8F, 18.700001F, 8.0F);
      ((Path)localObject2).cubicTo(18.700001F, 10.2F, 17.9F, 12.2F, 16.299999F, 13.8F);
      ((Path)localObject2).lineTo(16.200001F, 13.9F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.2F, 11.9F);
      ((Path)localObject2).lineTo(13.1F, 10.8F);
      ((Path)localObject2).lineTo(13.2F, 10.7F);
      ((Path)localObject2).cubicTo(13.9F, 10.0F, 14.3F, 9.0F, 14.3F, 8.0F);
      ((Path)localObject2).cubicTo(14.3F, 7.0F, 13.9F, 6.0F, 13.2F, 5.3F);
      ((Path)localObject2).lineTo(13.1F, 5.2F);
      ((Path)localObject2).lineTo(14.2F, 4.1F);
      ((Path)localObject2).lineTo(14.3F, 4.2F);
      ((Path)localObject2).cubicTo(15.3F, 5.2F, 15.9F, 6.6F, 15.9F, 8.0F);
      ((Path)localObject2).cubicTo(15.9F, 9.4F, 15.3F, 10.8F, 14.3F, 11.8F);
      ((Path)localObject2).lineTo(14.2F, 11.9F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.btr
 * JD-Core Version:    0.7.0.1
 */