package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class uw
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-12206054);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(192.0F, 0.0F);
      localPath.lineTo(192.0F, 192.0F);
      localPath.lineTo(0.0F, 192.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(119.15902F, 118.16251F);
      ((Path)localObject).cubicTo(120.66709F, 116.64901F, 126.05303F, 114.05444F, 128.20741F, 116.64901F);
      ((Path)localObject).cubicTo(130.36179F, 119.24358F, 145.01157F, 120.32465F, 150.61296F, 120.75708F);
      ((Path)localObject).cubicTo(156.21434F, 121.18951F, 155.9989F, 127.45972F, 155.9989F, 127.45972F);
      ((Path)localObject).lineTo(155.9989F, 147.56764F);
      ((Path)localObject).lineTo(155.9989F, 150.16222F);
      ((Path)localObject).cubicTo(154.70627F, 152.97301F, 152.98277F, 155.35136F, 150.39752F, 155.56757F);
      ((Path)localObject).cubicTo(146.73508F, 156.0F, 141.13368F, 156.0F, 138.11755F, 156.0F);
      ((Path)localObject).cubicTo(111.83414F, 152.10814F, 88.351402F, 139.3515F, 70.685501F, 120.9733F);
      ((Path)localObject).cubicTo(52.37328F, 103.45995F, 39.87788F, 79.892593F, 36.0F, 53.730671F);
      ((Path)localObject).cubicTo(36.0F, 50.703671F, 36.0F, 45.0821F, 36.430878F, 41.40646F);
      ((Path)localObject).cubicTo(36.646313F, 38.81189F, 39.016129F, 37.082172F, 41.816822F, 36.001102F);
      ((Path)localObject).lineTo(44.402077F, 36.001102F);
      ((Path)localObject).lineTo(64.437798F, 36.001102F);
      ((Path)localObject).cubicTo(64.437798F, 36.001102F, 70.470062F, 35.784889F, 71.116371F, 41.40646F);
      ((Path)localObject).cubicTo(71.547249F, 47.02803F, 72.624443F, 61.514381F, 75.209694F, 63.676525F);
      ((Path)localObject).cubicTo(77.794952F, 66.054878F, 74.994255F, 71.244026F, 73.70163F, 72.757523F);
      ((Path)localObject).cubicTo(72.624443F, 73.838593F, 64.006927F, 83.135803F, 59.698166F, 87.6763F);
      ((Path)localObject).cubicTo(64.868675F, 96.973518F, 72.193565F, 104.97344F, 79.087578F, 112.97337F);
      ((Path)localObject).cubicTo(87.058777F, 119.67601F, 94.814545F, 126.81108F, 104.29381F, 132.21643F);
      ((Path)localObject).cubicTo(108.818F, 127.89215F, 118.08183F, 119.24358F, 119.15902F, 118.16251F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.uw
 * JD-Core Version:    0.7.0.1
 */