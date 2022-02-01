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

public final class up
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
      ((Paint)localObject).setColor(-15158035);
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(142.54546F, 100.83131F);
      localPath.cubicTo(139.21634F, 92.181061F, 135.36592F, 85.412209F, 136.1254F, 75.064308F);
      localPath.cubicTo(134.93721F, 54.305878F, 117.50597F, 36.5975F, 97.605019F, 36.413792F);
      localPath.cubicTo(74.49456F, 36.5975F, 57.06332F, 54.305878F, 55.874607F, 75.064308F);
      localPath.cubicTo(56.631752F, 85.412209F, 52.781319F, 92.181061F, 49.454544F, 100.83131F);
      localPath.cubicTo(40.531776F, 114.37079F, 42.792137F, 131.66068F, 46.244514F, 133.04007F);
      localPath.cubicTo(48.937344F, 131.66068F, 53.503948F, 128.93271F, 59.084641F, 123.37745F);
      localPath.cubicTo(59.046963F, 129.886F, 62.214909F, 134.8965F, 65.5047F, 139.48183F);
      localPath.cubicTo(60.413361F, 140.68864F, 56.322769F, 143.90248F, 55.874607F, 145.92358F);
      localPath.cubicTo(56.75219F, 152.38712F, 65.805107F, 156.04285F, 75.134796F, 155.58621F);
      localPath.cubicTo(85.191315F, 155.14914F, 92.271347F, 152.36159F, 94.394981F, 149.14445F);
      localPath.cubicTo(95.27298F, 148.79735F, 95.623543F, 148.81863F, 97.605019F, 149.14445F);
      localPath.cubicTo(96.387749F, 148.81863F, 96.74691F, 148.79735F, 97.605019F, 149.14445F);
      localPath.cubicTo(99.752838F, 152.36159F, 106.82212F, 155.14914F, 116.8652F, 155.58621F);
      localPath.cubicTo(126.19614F, 156.04285F, 135.2462F, 152.38712F, 136.1254F, 145.92358F);
      localPath.cubicTo(135.67705F, 143.90106F, 131.58717F, 140.68864F, 126.4953F, 139.48183F);
      localPath.cubicTo(129.78922F, 134.8965F, 132.94926F, 129.89098F, 132.91536F, 123.37745F);
      localPath.cubicTo(138.50232F, 128.93483F, 143.06104F, 131.66068F, 145.75549F, 133.04007F);
      localPath.cubicTo(149.20982F, 131.66068F, 151.46875F, 114.37079F, 142.54546F, 100.83131F);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-15158035);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(176.66667F, 125.33334F);
      localPath.cubicTo(176.66667F, 141.90233F, 163.23567F, 155.33333F, 146.66667F, 155.33333F);
      localPath.cubicTo(130.09767F, 155.33333F, 116.66666F, 141.90233F, 116.66666F, 125.33334F);
      localPath.cubicTo(116.66666F, 108.76434F, 130.09767F, 95.333336F, 146.66667F, 95.333336F);
      localPath.cubicTo(163.23567F, 95.333336F, 176.66667F, 108.76434F, 176.66667F, 125.33334F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(144.0F, 128.0F);
      ((Path)localObject).lineTo(133.33333F, 128.0F);
      ((Path)localObject).lineTo(133.33333F, 122.66666F);
      ((Path)localObject).lineTo(144.0F, 122.66666F);
      ((Path)localObject).lineTo(144.0F, 112.0F);
      ((Path)localObject).lineTo(149.33333F, 112.0F);
      ((Path)localObject).lineTo(149.33333F, 122.66666F);
      ((Path)localObject).lineTo(160.0F, 122.66666F);
      ((Path)localObject).lineTo(160.0F, 128.0F);
      ((Path)localObject).lineTo(149.33333F, 128.0F);
      ((Path)localObject).lineTo(149.33333F, 138.66667F);
      ((Path)localObject).lineTo(144.0F, 138.66667F);
      ((Path)localObject).lineTo(144.0F, 128.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(122.66666F, 125.33551F);
      ((Path)localObject).cubicTo(122.66666F, 126.54803F, 122.7566F, 127.73956F, 122.93015F, 128.90376F);
      ((Path)localObject).cubicTo(124.65374F, 140.46556F, 134.62491F, 149.33333F, 146.66667F, 149.33333F);
      ((Path)localObject).cubicTo(159.92313F, 149.33333F, 170.66667F, 138.5898F, 170.66667F, 125.33551F);
      ((Path)localObject).cubicTo(170.66667F, 112.07905F, 159.92313F, 101.33334F, 146.66667F, 101.33334F);
      ((Path)localObject).cubicTo(133.41238F, 101.33334F, 122.66666F, 112.07905F, 122.66666F, 125.33551F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.up
 * JD-Core Version:    0.7.0.1
 */