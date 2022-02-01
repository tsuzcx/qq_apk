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

public final class cy
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-855310);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(90.0F, 0.0F);
      localPath.lineTo(90.0F, 90.0F);
      localPath.lineTo(0.0F, 90.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 30.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 153, 31);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(13.125807F, 35.884048F);
      ((Path)localObject2).cubicTo(5.726082F, 34.961723F, 9.368011E-016F, 28.649561F, 0.0F, 21.0F);
      ((Path)localObject2).lineTo(0.0F, 17.25F);
      ((Path)localObject2).lineTo(3.75F, 17.25F);
      ((Path)localObject2).lineTo(3.75F, 21.0F);
      ((Path)localObject2).cubicTo(3.75F, 27.213203F, 8.786797F, 32.25F, 15.0F, 32.25F);
      ((Path)localObject2).cubicTo(21.213203F, 32.25F, 26.25F, 27.213203F, 26.25F, 21.0F);
      ((Path)localObject2).lineTo(26.25F, 17.25F);
      ((Path)localObject2).lineTo(30.0F, 17.25F);
      ((Path)localObject2).lineTo(30.0F, 21.0F);
      ((Path)localObject2).cubicTo(30.0F, 28.649282F, 24.274334F, 34.961266F, 16.875F, 35.883949F);
      ((Path)localObject2).lineTo(16.875F, 42.0F);
      ((Path)localObject2).lineTo(13.12812F, 42.0F);
      ((Path)localObject2).lineTo(13.125807F, 35.884048F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.0F, 0.0F);
      ((Path)localObject2).cubicTo(19.142136F, -7.60898E-016F, 22.5F, 3.357864F, 22.5F, 7.5F);
      ((Path)localObject2).lineTo(22.5F, 21.0F);
      ((Path)localObject2).cubicTo(22.5F, 25.142136F, 19.142136F, 28.5F, 15.0F, 28.5F);
      ((Path)localObject2).cubicTo(10.857864F, 28.5F, 7.5F, 25.142136F, 7.5F, 21.0F);
      ((Path)localObject2).lineTo(7.5F, 7.5F);
      ((Path)localObject2).cubicTo(7.5F, 3.357864F, 10.857864F, 7.60898E-016F, 15.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.0F, 3.75F);
      ((Path)localObject2).cubicTo(12.928932F, 3.75F, 11.25F, 5.428932F, 11.25F, 7.5F);
      ((Path)localObject2).lineTo(11.25F, 21.0F);
      ((Path)localObject2).cubicTo(11.25F, 23.071068F, 12.928932F, 24.75F, 15.0F, 24.75F);
      ((Path)localObject2).cubicTo(17.071068F, 24.75F, 18.75F, 23.071068F, 18.75F, 21.0F);
      ((Path)localObject2).lineTo(18.75F, 7.5F);
      ((Path)localObject2).cubicTo(18.75F, 5.428932F, 17.071068F, 3.75F, 15.0F, 3.75F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cy
 * JD-Core Version:    0.7.0.1
 */