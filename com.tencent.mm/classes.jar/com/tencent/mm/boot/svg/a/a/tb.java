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

public final class tb
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
      localPaint1.setColor(-9538696);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 17.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(77.0F, 50.560101F);
      ((Path)localObject2).cubicTo(77.0F, 51.355099F, 76.360001F, 52.000099F, 75.555F, 52.000099F);
      ((Path)localObject2).lineTo(49.0F, 52.000099F);
      ((Path)localObject2).lineTo(32.0F, 52.000099F);
      ((Path)localObject2).lineTo(4.445F, 52.000099F);
      ((Path)localObject2).cubicTo(3.647F, 52.000099F, 3.0F, 51.362099F, 3.0F, 50.560101F);
      ((Path)localObject2).lineTo(3.0F, 43.000099F);
      ((Path)localObject2).lineTo(77.0F, 43.000099F);
      ((Path)localObject2).lineTo(77.0F, 50.560101F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.231998F, 60.000099F);
      ((Path)localObject2).lineTo(35.0F, 55.578098F);
      ((Path)localObject2).lineTo(35.0F, 55.000099F);
      ((Path)localObject2).lineTo(46.0F, 55.000099F);
      ((Path)localObject2).lineTo(46.0F, 55.578098F);
      ((Path)localObject2).lineTo(47.769001F, 60.000099F);
      ((Path)localObject2).lineTo(33.231998F, 60.000099F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.0F, 4.4401F);
      ((Path)localObject2).cubicTo(3.0F, 3.6451F, 3.64F, 3.0001F, 4.445F, 3.0001F);
      ((Path)localObject2).lineTo(75.555F, 3.0001F);
      ((Path)localObject2).cubicTo(76.352997F, 3.0001F, 77.0F, 3.6371F, 77.0F, 4.4401F);
      ((Path)localObject2).lineTo(77.0F, 40.000099F);
      ((Path)localObject2).lineTo(3.0F, 40.000099F);
      ((Path)localObject2).lineTo(3.0F, 4.4401F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(75.684998F, 1.0E-004F);
      ((Path)localObject2).lineTo(4.315F, 1.0E-004F);
      ((Path)localObject2).cubicTo(1.938F, 1.0E-004F, 0.0F, 1.9321F, 0.0F, 4.3161F);
      ((Path)localObject2).lineTo(0.0F, 50.684101F);
      ((Path)localObject2).cubicTo(0.0F, 53.0751F, 1.932F, 55.000099F, 4.315F, 55.000099F);
      ((Path)localObject2).lineTo(32.0F, 55.000099F);
      ((Path)localObject2).lineTo(30.0F, 60.000099F);
      ((Path)localObject2).lineTo(26.0F, 62.000099F);
      ((Path)localObject2).lineTo(26.0F, 63.000099F);
      ((Path)localObject2).lineTo(55.0F, 63.000099F);
      ((Path)localObject2).lineTo(55.0F, 62.000099F);
      ((Path)localObject2).lineTo(51.0F, 60.000099F);
      ((Path)localObject2).lineTo(49.0F, 55.000099F);
      ((Path)localObject2).lineTo(75.684998F, 55.000099F);
      ((Path)localObject2).cubicTo(78.061996F, 55.000099F, 80.0F, 53.0681F, 80.0F, 50.684101F);
      ((Path)localObject2).lineTo(80.0F, 4.3161F);
      ((Path)localObject2).cubicTo(80.0F, 1.9251F, 78.068001F, 1.0E-004F, 75.684998F, 1.0E-004F);
      ((Path)localObject2).lineTo(75.684998F, 1.0E-004F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.tb
 * JD-Core Version:    0.7.0.1
 */