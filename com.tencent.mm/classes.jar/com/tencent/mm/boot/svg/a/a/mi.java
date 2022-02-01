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

public final class mi
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
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 40.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-8617851);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(8.0F, 65.0F);
      ((Path)localObject2).cubicTo(3.581778F, 65.0F, 0.0F, 68.581779F, 0.0F, 73.0F);
      ((Path)localObject2).cubicTo(0.0F, 77.418221F, 3.581778F, 81.0F, 8.0F, 81.0F);
      ((Path)localObject2).cubicTo(12.418222F, 81.0F, 16.0F, 77.418221F, 16.0F, 73.0F);
      ((Path)localObject2).cubicTo(16.0F, 68.581779F, 12.418222F, 65.0F, 8.0F, 65.0F);
      ((Path)localObject2).moveTo(8.0F, 32.0F);
      ((Path)localObject2).cubicTo(3.581778F, 32.0F, 0.0F, 35.581779F, 0.0F, 40.0F);
      ((Path)localObject2).cubicTo(0.0F, 44.418221F, 3.581778F, 48.0F, 8.0F, 48.0F);
      ((Path)localObject2).cubicTo(12.418222F, 48.0F, 16.0F, 44.418221F, 16.0F, 40.0F);
      ((Path)localObject2).cubicTo(16.0F, 35.581779F, 12.418222F, 32.0F, 8.0F, 32.0F);
      ((Path)localObject2).moveTo(16.0F, 8.0F);
      ((Path)localObject2).cubicTo(16.0F, 3.581778F, 12.418222F, 0.0F, 8.0F, 0.0F);
      ((Path)localObject2).cubicTo(3.581778F, 0.0F, 0.0F, 3.581778F, 0.0F, 8.0F);
      ((Path)localObject2).cubicTo(0.0F, 12.418222F, 3.581778F, 16.0F, 8.0F, 16.0F);
      ((Path)localObject2).cubicTo(12.418222F, 16.0F, 16.0F, 12.418222F, 16.0F, 8.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.mi
 * JD-Core Version:    0.7.0.1
 */