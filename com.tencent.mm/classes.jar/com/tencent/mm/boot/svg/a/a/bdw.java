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

public final class bdw
  extends c
{
  private final int height = 16;
  private final int width = 12;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 12;
      return 16;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      localPaint1.setColor(-5066062);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -202.0F, 0.0F, 1.0F, -603.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 133.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(3.9F, 2.4F);
      ((Path)localObject2).lineTo(3.9F, 15.6F);
      ((Path)localObject2).lineTo(14.1F, 15.6F);
      ((Path)localObject2).lineTo(14.1F, 2.4F);
      ((Path)localObject2).lineTo(3.9F, 2.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.0F, 2.25F);
      ((Path)localObject2).cubicTo(3.0F, 1.835787F, 3.335786F, 1.5F, 3.75F, 1.5F);
      ((Path)localObject2).lineTo(14.25F, 1.5F);
      ((Path)localObject2).cubicTo(14.664213F, 1.5F, 15.0F, 1.835787F, 15.0F, 2.25F);
      ((Path)localObject2).lineTo(15.0F, 15.75F);
      ((Path)localObject2).cubicTo(15.0F, 16.164213F, 14.664213F, 16.5F, 14.25F, 16.5F);
      ((Path)localObject2).lineTo(3.75F, 16.5F);
      ((Path)localObject2).cubicTo(3.335786F, 16.5F, 3.0F, 16.164213F, 3.0F, 15.75F);
      ((Path)localObject2).lineTo(3.0F, 2.25F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(6.375F, 3.75F);
      ((Path)localObject2).cubicTo(6.99632F, 3.75F, 7.5F, 4.25368F, 7.5F, 4.875F);
      ((Path)localObject2).cubicTo(7.5F, 5.49632F, 6.99632F, 6.0F, 6.375F, 6.0F);
      ((Path)localObject2).cubicTo(5.75368F, 6.0F, 5.25F, 5.49632F, 5.25F, 4.875F);
      ((Path)localObject2).cubicTo(5.25F, 4.25368F, 5.75368F, 3.75F, 6.375F, 3.75F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(5.25F, 7.5F);
      ((Path)localObject2).lineTo(10.875F, 7.5F);
      ((Path)localObject2).lineTo(10.875F, 8.5F);
      ((Path)localObject2).lineTo(5.25F, 8.5F);
      ((Path)localObject2).lineTo(5.25F, 7.5F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(5.25F, 9.75F);
      ((Path)localObject2).lineTo(8.25F, 9.75F);
      ((Path)localObject2).lineTo(8.25F, 10.75F);
      ((Path)localObject2).lineTo(5.25F, 10.75F);
      ((Path)localObject2).lineTo(5.25F, 9.75F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(5.25F, 12.0F);
      ((Path)localObject1).lineTo(8.25F, 12.0F);
      ((Path)localObject1).lineTo(8.25F, 13.0F);
      ((Path)localObject1).lineTo(5.25F, 13.0F);
      ((Path)localObject1).lineTo(5.25F, 12.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bdw
 * JD-Core Version:    0.7.0.1
 */