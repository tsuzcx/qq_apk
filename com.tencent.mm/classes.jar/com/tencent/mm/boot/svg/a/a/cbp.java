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

public final class cbp
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -249.0F, 0.0F, 1.0F, -128.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 249.0F, 0.0F, 1.0F, 128.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-9276814);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(80.0F, 38.0F);
      ((Path)localObject2).lineTo(80.0F, 46.0F);
      ((Path)localObject2).cubicTo(81.59742F, 46.5F, 83.5F, 48.403057F, 84.0F, 50.0F);
      ((Path)localObject2).lineTo(84.0F, 77.0F);
      ((Path)localObject2).cubicTo(83.5F, 78.59742F, 81.59742F, 80.5F, 80.0F, 81.0F);
      ((Path)localObject2).lineTo(53.0F, 81.0F);
      ((Path)localObject2).cubicTo(51.402584F, 80.5F, 49.5F, 78.59742F, 49.0F, 77.0F);
      ((Path)localObject2).lineTo(41.0F, 77.0F);
      ((Path)localObject2).cubicTo(41.0F, 83.291779F, 46.708221F, 89.0F, 53.0F, 89.0F);
      ((Path)localObject2).lineTo(80.0F, 89.0F);
      ((Path)localObject2).cubicTo(86.291779F, 89.0F, 92.0F, 83.291779F, 92.0F, 77.0F);
      ((Path)localObject2).lineTo(92.0F, 50.0F);
      ((Path)localObject2).cubicTo(92.0F, 43.708221F, 86.291779F, 38.0F, 80.0F, 38.0F);
      ((Path)localObject2).moveTo(16.0F, 56.0F);
      ((Path)localObject2).lineTo(16.0F, 17.0F);
      ((Path)localObject2).cubicTo(16.0F, 14.912758F, 17.912758F, 13.0F, 20.0F, 13.0F);
      ((Path)localObject2).lineTo(59.0F, 13.0F);
      ((Path)localObject2).cubicTo(61.087242F, 13.0F, 63.0F, 14.912758F, 63.0F, 17.0F);
      ((Path)localObject2).lineTo(63.0F, 56.0F);
      ((Path)localObject2).cubicTo(63.0F, 58.087242F, 61.087242F, 60.0F, 59.0F, 60.0F);
      ((Path)localObject2).lineTo(20.0F, 60.0F);
      ((Path)localObject2).cubicTo(17.912758F, 60.0F, 16.0F, 58.087242F, 16.0F, 56.0F);
      ((Path)localObject2).moveTo(71.0F, 56.0F);
      ((Path)localObject2).lineTo(71.0F, 17.0F);
      ((Path)localObject2).cubicTo(71.0F, 10.641533F, 65.358932F, 5.0F, 59.0F, 5.0F);
      ((Path)localObject2).lineTo(20.0F, 5.0F);
      ((Path)localObject2).cubicTo(13.641067F, 5.0F, 8.0F, 10.641533F, 8.0F, 17.0F);
      ((Path)localObject2).lineTo(8.0F, 56.0F);
      ((Path)localObject2).cubicTo(8.0F, 62.358932F, 13.641067F, 68.0F, 20.0F, 68.0F);
      ((Path)localObject2).lineTo(59.0F, 68.0F);
      ((Path)localObject2).cubicTo(65.358932F, 68.0F, 71.0F, 62.358932F, 71.0F, 56.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cbp
 * JD-Core Version:    0.7.0.1
 */