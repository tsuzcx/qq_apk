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

public final class aui
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(60.900002F, 59.400002F);
      ((Path)localObject).lineTo(60.900002F, 57.946388F);
      ((Path)localObject).cubicTo(60.900002F, 57.258179F, 60.194038F, 56.130058F, 59.57943F, 55.830261F);
      ((Path)localObject).lineTo(42.59837F, 47.547119F);
      ((Path)localObject).cubicTo(38.018623F, 45.313179F, 36.886719F, 39.908741F, 40.168011F, 36.019104F);
      ((Path)localObject).lineTo(41.252609F, 34.733425F);
      ((Path)localObject).cubicTo(42.906586F, 32.772804F, 44.400002F, 28.693172F, 44.400002F, 26.130558F);
      ((Path)localObject).lineTo(44.400002F, 21.000622F);
      ((Path)localObject).cubicTo(44.400002F, 16.364742F, 40.636768F, 12.6F, 36.0F, 12.6F);
      ((Path)localObject).cubicTo(31.368927F, 12.6F, 27.6F, 16.365608F, 27.6F, 20.998741F);
      ((Path)localObject).lineTo(27.6F, 26.127872F);
      ((Path)localObject).cubicTo(27.6F, 28.696991F, 29.08724F, 32.761452F, 30.747236F, 34.728935F);
      ((Path)localObject).lineTo(31.831833F, 36.014439F);
      ((Path)localObject).cubicTo(35.119907F, 39.911579F, 33.975643F, 45.310951F, 29.402159F, 47.542759F);
      ((Path)localObject).lineTo(12.421099F, 55.82933F);
      ((Path)localObject).cubicTo(11.811051F, 56.127026F, 11.1F, 57.266029F, 11.1F, 57.946388F);
      ((Path)localObject).lineTo(11.1F, 59.400002F);
      ((Path)localObject).lineTo(60.900002F, 59.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.5F, 60.0F);
      ((Path)localObject).lineTo(7.5F, 57.946388F);
      ((Path)localObject).cubicTo(7.5F, 55.891125F, 8.994453F, 53.495724F, 10.842293F, 52.593998F);
      ((Path)localObject).lineTo(27.823353F, 44.30743F);
      ((Path)localObject).cubicTo(30.286131F, 43.105621F, 30.858778F, 40.443787F, 29.080336F, 38.335918F);
      ((Path)localObject).lineTo(27.995739F, 37.050415F);
      ((Path)localObject).cubicTo(25.788954F, 34.434856F, 24.0F, 29.548489F, 24.0F, 26.127872F);
      ((Path)localObject).lineTo(24.0F, 20.998741F);
      ((Path)localObject).cubicTo(24.0F, 14.37202F, 29.386068F, 9.0F, 36.0F, 9.0F);
      ((Path)localObject).cubicTo(42.627419F, 9.0F, 48.0F, 14.378941F, 48.0F, 21.000622F);
      ((Path)localObject).lineTo(48.0F, 26.130558F);
      ((Path)localObject).cubicTo(48.0F, 29.547888F, 46.202797F, 34.448582F, 44.004261F, 37.054718F);
      ((Path)localObject).lineTo(42.919662F, 38.340397F);
      ((Path)localObject).cubicTo(41.151096F, 40.436852F, 41.703564F, 43.105194F, 44.176647F, 44.311531F);
      ((Path)localObject).lineTo(61.157707F, 52.594673F);
      ((Path)localObject).cubicTo(63.003605F, 53.495079F, 64.5F, 55.875511F, 64.5F, 57.946388F);
      ((Path)localObject).lineTo(64.5F, 60.0F);
      ((Path)localObject).cubicTo(64.5F, 61.656853F, 63.156853F, 63.0F, 61.5F, 63.0F);
      ((Path)localObject).lineTo(10.5F, 63.0F);
      ((Path)localObject).cubicTo(8.843145F, 63.0F, 7.5F, 61.656853F, 7.5F, 60.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aui
 * JD-Core Version:    0.7.0.1
 */