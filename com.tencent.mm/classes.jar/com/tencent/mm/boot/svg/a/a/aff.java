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

public final class aff
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -60.0F, 0.0F, 1.0F, -459.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 32.0F, 0.0F, 1.0F, 334.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 28.0F, 0.0F, 1.0F, 125.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-436207616);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(12.287003F, 6.369852F);
      ((Path)localObject2).lineTo(7.727208F, 10.929646F);
      ((Path)localObject2).lineTo(5.605887F, 8.808326F);
      ((Path)localObject2).lineTo(4.75736F, 9.656855F);
      ((Path)localObject2).lineTo(7.585786F, 12.485281F);
      ((Path)localObject2).lineTo(7.727208F, 12.626702F);
      ((Path)localObject2).lineTo(12.76821F, 7.5857F);
      ((Path)localObject2).cubicTo(12.808246F, 7.584128F, 12.848477F, 7.583334F, 12.888889F, 7.583334F);
      ((Path)localObject2).cubicTo(14.607108F, 7.583334F, 16.0F, 9.019754F, 16.0F, 10.791667F);
      ((Path)localObject2).cubicTo(16.0F, 12.563581F, 14.607108F, 14.0F, 12.888889F, 14.0F);
      ((Path)localObject2).lineTo(3.555556F, 14.0F);
      ((Path)localObject2).cubicTo(1.591877F, 14.0F, 0.0F, 12.358377F, 0.0F, 10.333333F);
      ((Path)localObject2).cubicTo(0.0F, 8.30829F, 1.591877F, 6.666667F, 3.555556F, 6.666667F);
      ((Path)localObject2).cubicTo(3.585203F, 6.666667F, 3.614766F, 6.667041F, 3.644241F, 6.667785F);
      ((Path)localObject2).cubicTo(4.055617F, 4.575174F, 5.849432F, 3.0F, 8.0F, 3.0F);
      ((Path)localObject2).cubicTo(10.047238F, 3.0F, 11.771183F, 4.427445F, 12.287003F, 6.369852F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(16.0F, 16.0F);
      ((Path)localObject1).lineTo(0.0F, 16.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aff
 * JD-Core Version:    0.7.0.1
 */