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

public final class aew
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-419430401);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -10.0F, 0.0F, 1.0F, -8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 8.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(5.6F, 4.668629F);
      ((Path)localObject2).lineTo(5.599F, 5.867629F);
      ((Path)localObject2).lineTo(4.0F, 5.868629F);
      ((Path)localObject2).lineTo(4.0F, 13.468629F);
      ((Path)localObject2).lineTo(12.0F, 13.468629F);
      ((Path)localObject2).lineTo(12.0F, 5.868629F);
      ((Path)localObject2).lineTo(10.399F, 5.867629F);
      ((Path)localObject2).lineTo(10.4F, 4.668629F);
      ((Path)localObject2).lineTo(12.16F, 4.668629F);
      ((Path)localObject2).cubicTo(12.734376F, 4.668629F, 13.2F, 5.116345F, 13.2F, 5.668629F);
      ((Path)localObject2).lineTo(13.2F, 13.66863F);
      ((Path)localObject2).cubicTo(13.2F, 14.220914F, 12.734376F, 14.66863F, 12.16F, 14.66863F);
      ((Path)localObject2).lineTo(3.84F, 14.66863F);
      ((Path)localObject2).cubicTo(3.265624F, 14.66863F, 2.8F, 14.220914F, 2.8F, 13.66863F);
      ((Path)localObject2).lineTo(2.8F, 5.668629F);
      ((Path)localObject2).cubicTo(2.8F, 5.116345F, 3.265624F, 4.668629F, 3.84F, 4.668629F);
      ((Path)localObject2).lineTo(5.6F, 4.668629F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.594112F, 1.234315F);
      ((Path)localObject2).lineTo(10.856854F, 3.497056F);
      ((Path)localObject2).lineTo(10.008327F, 4.345584F);
      ((Path)localObject2).lineTo(8.6F, 2.937F);
      ((Path)localObject2).lineTo(8.6F, 8.668629F);
      ((Path)localObject2).lineTo(7.4F, 8.668629F);
      ((Path)localObject2).lineTo(7.4F, 2.993F);
      ((Path)localObject2).lineTo(6.048528F, 4.345584F);
      ((Path)localObject2).lineTo(5.2F, 3.497056F);
      ((Path)localObject2).lineTo(7.462742F, 1.234315F);
      ((Path)localObject2).cubicTo(7.775161F, 0.9218952F, 8.281694F, 0.9218952F, 8.594112F, 1.234315F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aew
 * JD-Core Version:    0.7.0.1
 */