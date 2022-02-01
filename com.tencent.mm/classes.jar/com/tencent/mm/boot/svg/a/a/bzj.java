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

public final class bzj
  extends c
{
  private final int height = 14;
  private final int width = 14;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 14;
      return 14;
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
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-5066062);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -140.0F, 0.0F, 1.0F, -747.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 72.0F, 0.0F, 1.0F, 143.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(12.429453F, 11.795271F);
      ((Path)localObject2).lineTo(15.915277F, 15.281094F);
      ((Path)localObject2).lineTo(15.19637F, 16.0F);
      ((Path)localObject2).lineTo(11.703301F, 12.506931F);
      ((Path)localObject2).cubicTo(10.678107F, 13.353059F, 9.36375F, 13.861345F, 7.930673F, 13.861345F);
      ((Path)localObject2).cubicTo(4.655247F, 13.861345F, 2.0F, 11.206099F, 2.0F, 7.930673F);
      ((Path)localObject2).cubicTo(2.0F, 4.655247F, 4.655247F, 2.0F, 7.930673F, 2.0F);
      ((Path)localObject2).cubicTo(11.206099F, 2.0F, 13.861345F, 4.655247F, 13.861345F, 7.930673F);
      ((Path)localObject2).cubicTo(13.861345F, 9.406973F, 13.321936F, 10.757285F, 12.429453F, 11.795271F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.844656F, 7.930683F);
      ((Path)localObject2).cubicTo(12.844656F, 5.216759F, 10.644594F, 3.016697F, 7.93067F, 3.016697F);
      ((Path)localObject2).cubicTo(5.216746F, 3.016697F, 3.016684F, 5.216759F, 3.016684F, 7.930683F);
      ((Path)localObject2).cubicTo(3.016684F, 10.644608F, 5.216746F, 12.844669F, 7.93067F, 12.844669F);
      ((Path)localObject2).cubicTo(10.644594F, 12.844669F, 12.844656F, 10.644608F, 12.844656F, 7.930683F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bzj
 * JD-Core Version:    0.7.0.1
 */