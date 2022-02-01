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

public final class bfi
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
      localPaint1 = c.a(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-372399);
      localPaint1.setStrokeWidth(3.756522F);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 13.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(33.423096F, 23.393011F);
      ((Path)localObject2).cubicTo(33.423096F, 28.885603F, 28.958527F, 33.335987F, 23.453514F, 33.335987F);
      ((Path)localObject2).cubicTo(17.946226F, 33.335987F, 13.483933F, 28.885603F, 13.483933F, 23.393011F);
      ((Path)localObject2).cubicTo(13.483933F, 17.900419F, 17.946226F, 13.450035F, 23.453514F, 13.450035F);
      ((Path)localObject2).cubicTo(28.958527F, 13.450035F, 33.423096F, 17.900419F, 33.423096F, 23.393011F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(36.644825F, 43.308029F);
      ((Path)localObject2).lineTo(23.453743F, 56.466183F);
      ((Path)localObject2).lineTo(14.822849F, 47.858318F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(40.033207F, 39.928688F);
      ((Path)localObject1).cubicTo(49.190014F, 30.796316F, 49.190014F, 15.989706F, 40.033207F, 6.857335F);
      ((Path)localObject1).cubicTo(30.876402F, -2.275036F, 16.030172F, -2.275036F, 6.873366F, 6.857335F);
      ((Path)localObject1).cubicTo(-2.28344F, 15.989706F, -2.28344F, 30.796316F, 6.873366F, 39.928688F);
      ((Path)localObject1).lineTo(11.679438F, 44.721935F);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bfi
 * JD-Core Version:    0.7.0.1
 */