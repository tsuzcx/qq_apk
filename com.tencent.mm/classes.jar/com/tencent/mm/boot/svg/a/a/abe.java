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

public final class abe
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(44.5F, 40.321075F);
      ((Path)localObject2).lineTo(23.613749F, 19.430162F);
      ((Path)localObject2).cubicTo(23.041075F, 18.857361F, 22.093519F, 18.853842F, 21.511253F, 19.436235F);
      ((Path)localObject2).lineTo(19.44183F, 21.506123F);
      ((Path)localObject2).cubicTo(18.850626F, 22.097458F, 18.856846F, 23.030046F, 19.435757F, 23.609087F);
      ((Path)localObject2).lineTo(40.322006F, 44.5F);
      ((Path)localObject2).lineTo(19.435757F, 65.390915F);
      ((Path)localObject2).cubicTo(18.856846F, 65.969955F, 18.850626F, 66.902542F, 19.44183F, 67.493874F);
      ((Path)localObject2).lineTo(21.511253F, 69.563766F);
      ((Path)localObject2).cubicTo(22.093519F, 70.146156F, 23.041075F, 70.142639F, 23.613749F, 69.569839F);
      ((Path)localObject2).lineTo(44.5F, 48.678925F);
      ((Path)localObject2).lineTo(65.386253F, 69.569839F);
      ((Path)localObject2).cubicTo(65.958923F, 70.142639F, 66.906479F, 70.146156F, 67.488747F, 69.563766F);
      ((Path)localObject2).lineTo(69.558174F, 67.493874F);
      ((Path)localObject2).cubicTo(70.149376F, 66.902542F, 70.143158F, 65.969955F, 69.564247F, 65.390915F);
      ((Path)localObject2).lineTo(48.677994F, 44.5F);
      ((Path)localObject2).lineTo(69.564247F, 23.609087F);
      ((Path)localObject2).cubicTo(70.143158F, 23.030046F, 70.149376F, 22.097458F, 69.558174F, 21.506123F);
      ((Path)localObject2).lineTo(67.488747F, 19.436235F);
      ((Path)localObject2).cubicTo(66.906479F, 18.853842F, 65.958923F, 18.857361F, 65.386253F, 19.430162F);
      ((Path)localObject2).lineTo(44.5F, 40.321075F);
      ((Path)localObject2).lineTo(44.5F, 40.321075F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abe
 * JD-Core Version:    0.7.0.1
 */