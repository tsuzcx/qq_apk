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

public final class od
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject1 = c.m(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      Paint localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-16777216);
      localCanvas.saveLayerAlpha(null, 12, 31);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(20.0F, 0.0F);
      localPath.cubicTo(31.045696F, 0.0F, 40.0F, 8.954305F, 40.0F, 20.0F);
      localPath.cubicTo(40.0F, 31.045696F, 31.045696F, 40.0F, 20.0F, 40.0F);
      localPath.cubicTo(8.954305F, 40.0F, 0.0F, 31.045696F, 0.0F, 20.0F);
      localPath.cubicTo(0.0F, 8.954305F, 8.954305F, 0.0F, 20.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(4.5F, 10.5F);
      ((Path)localObject3).lineTo(4.5F, 24.0F);
      ((Path)localObject3).cubicTo(4.5F, 24.276142F, 4.723857F, 24.5F, 5.0F, 24.5F);
      ((Path)localObject3).lineTo(23.0F, 24.5F);
      ((Path)localObject3).cubicTo(23.276142F, 24.5F, 23.5F, 24.276142F, 23.5F, 24.0F);
      ((Path)localObject3).lineTo(23.5F, 10.5F);
      ((Path)localObject3).lineTo(4.5F, 10.5F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-2565928);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(25.499073F, 10.472813F);
      ((Path)localObject3).lineTo(23.211826F, 4.373488F);
      ((Path)localObject3).cubicTo(23.014799F, 3.848079F, 22.51252F, 3.5F, 21.951384F, 3.5F);
      ((Path)localObject3).lineTo(6.048616F, 3.5F);
      ((Path)localObject3).cubicTo(5.487479F, 3.5F, 4.985201F, 3.848079F, 4.788173F, 4.373488F);
      ((Path)localObject3).lineTo(2.500926F, 10.472813F);
      ((Path)localObject3).cubicTo(2.547857F, 12.704954F, 4.371993F, 14.5F, 6.615385F, 14.5F);
      ((Path)localObject3).cubicTo(7.926839F, 14.5F, 9.134812F, 13.882993F, 9.907946F, 12.853959F);
      ((Path)localObject3).lineTo(10.307693F, 12.321898F);
      ((Path)localObject3).lineTo(10.707439F, 12.853959F);
      ((Path)localObject3).cubicTo(11.480572F, 13.882993F, 12.688545F, 14.5F, 14.0F, 14.5F);
      ((Path)localObject3).cubicTo(15.311455F, 14.5F, 16.519428F, 13.882993F, 17.292561F, 12.853959F);
      ((Path)localObject3).lineTo(17.692308F, 12.321898F);
      ((Path)localObject3).lineTo(18.092054F, 12.853959F);
      ((Path)localObject3).cubicTo(18.865187F, 13.882993F, 20.07316F, 14.5F, 21.384615F, 14.5F);
      ((Path)localObject3).cubicTo(23.628008F, 14.5F, 25.452143F, 12.704954F, 25.499073F, 10.472813F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(5.0F, 10.0F);
      ((Path)localObject1).cubicTo(5.0F, 9.723858F, 5.223857F, 9.5F, 5.5F, 9.5F);
      ((Path)localObject1).lineTo(22.5F, 9.5F);
      ((Path)localObject1).cubicTo(22.776142F, 9.5F, 23.0F, 9.723858F, 23.0F, 10.0F);
      ((Path)localObject1).lineTo(23.0F, 10.0F);
      ((Path)localObject1).cubicTo(23.0F, 10.276142F, 22.776142F, 10.5F, 22.5F, 10.5F);
      ((Path)localObject1).lineTo(5.5F, 10.5F);
      ((Path)localObject1).cubicTo(5.223857F, 10.5F, 5.0F, 10.276142F, 5.0F, 10.0F);
      ((Path)localObject1).lineTo(5.0F, 10.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.od
 * JD-Core Version:    0.7.0.1
 */