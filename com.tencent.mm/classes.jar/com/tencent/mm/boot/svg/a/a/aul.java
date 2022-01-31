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

public final class aul
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localPaint1.setColor(-12863723);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 22.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(12.334797F, 4.311203F);
      ((Path)localObject2).cubicTo(21.186792F, -1.572559F, 33.559582F, -1.422463F, 42.261543F, 4.691445F);
      ((Path)localObject2).cubicTo(48.873032F, 9.174312F, 53.184006F, 17.009319F, 52.993961F, 25.054462F);
      ((Path)localObject2).cubicTo(52.903942F, 31.708717F, 50.01329F, 37.972721F, 46.382469F, 43.416203F);
      ((Path)localObject2).cubicTo(40.951248F, 51.471352F, 33.959671F, 58.285709F, 27.008104F, 65.0F);
      ((Path)localObject2).cubicTo(20.046535F, 58.315727F, 13.094969F, 51.481358F, 7.663744F, 43.456226F);
      ((Path)localObject2).cubicTo(3.822879F, 37.702549F, 0.782194F, 31.028282F, 1.012245F, 23.973772F);
      ((Path)localObject2).cubicTo(1.212291F, 16.068718F, 5.713305F, 8.543908F, 12.334797F, 4.311203F);
      ((Path)localObject2).lineTo(12.334797F, 4.311203F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(23.398994F, 14.60051F);
      ((Path)localObject2).cubicTo(19.540892F, 15.836599F, 16.380636F, 19.116222F, 15.413617F, 23.063734F);
      ((Path)localObject2).cubicTo(13.429734F, 29.89213F, 18.853012F, 37.448223F, 25.901279F, 37.91674F);
      ((Path)localObject2).cubicTo(33.079147F, 38.833839F, 39.858246F, 32.025379F, 38.911163F, 24.848087F);
      ((Path)localObject2).cubicTo(38.442608F, 17.531237F, 30.337601F, 12.148268F, 23.398994F, 14.60051F);
      ((Path)localObject2).lineTo(23.398994F, 14.60051F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aul
 * JD-Core Version:    0.7.0.1
 */