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

public final class acw
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
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(56.400002F, 59.400002F);
      localPath.lineTo(56.400002F, 57.946388F);
      localPath.cubicTo(56.400002F, 57.258179F, 55.694038F, 56.130058F, 55.07943F, 55.830261F);
      localPath.lineTo(38.09837F, 47.547119F);
      localPath.cubicTo(33.518623F, 45.313179F, 32.386719F, 39.908741F, 35.668011F, 36.019104F);
      localPath.lineTo(36.752609F, 34.733425F);
      localPath.cubicTo(38.406586F, 32.772804F, 39.900002F, 28.693172F, 39.900002F, 26.130558F);
      localPath.lineTo(39.900002F, 21.000622F);
      localPath.cubicTo(39.900002F, 16.364742F, 36.136768F, 12.6F, 31.5F, 12.6F);
      localPath.cubicTo(26.868927F, 12.6F, 23.1F, 16.365608F, 23.1F, 20.998741F);
      localPath.lineTo(23.1F, 26.127872F);
      localPath.cubicTo(23.1F, 28.696991F, 24.58724F, 32.761452F, 26.247236F, 34.728935F);
      localPath.lineTo(27.331833F, 36.014439F);
      localPath.cubicTo(30.619909F, 39.911579F, 29.475643F, 45.310951F, 24.902159F, 47.542759F);
      localPath.lineTo(7.921099F, 55.82933F);
      localPath.cubicTo(7.311051F, 56.127026F, 6.6F, 57.266029F, 6.6F, 57.946388F);
      localPath.lineTo(6.6F, 59.400002F);
      localPath.lineTo(56.400002F, 59.400002F);
      localPath.close();
      localPath.moveTo(3.0F, 60.0F);
      localPath.lineTo(3.0F, 57.946388F);
      localPath.cubicTo(3.0F, 55.891125F, 4.494453F, 53.495724F, 6.342293F, 52.593998F);
      localPath.lineTo(23.323353F, 44.30743F);
      localPath.cubicTo(25.786131F, 43.105621F, 26.358778F, 40.443787F, 24.580336F, 38.335918F);
      localPath.lineTo(23.495739F, 37.050415F);
      localPath.cubicTo(21.288954F, 34.434856F, 19.5F, 29.548489F, 19.5F, 26.127872F);
      localPath.lineTo(19.5F, 20.998741F);
      localPath.cubicTo(19.5F, 14.37202F, 24.886068F, 9.0F, 31.5F, 9.0F);
      localPath.cubicTo(38.127419F, 9.0F, 43.5F, 14.378941F, 43.5F, 21.000622F);
      localPath.lineTo(43.5F, 26.130558F);
      localPath.cubicTo(43.5F, 29.547888F, 41.702797F, 34.448582F, 39.504261F, 37.054718F);
      localPath.lineTo(38.419662F, 38.340397F);
      localPath.cubicTo(36.651096F, 40.436852F, 37.203564F, 43.105194F, 39.676647F, 44.311531F);
      localPath.lineTo(56.657707F, 52.594673F);
      localPath.cubicTo(58.503605F, 53.495079F, 60.0F, 55.875511F, 60.0F, 57.946388F);
      localPath.lineTo(60.0F, 60.0F);
      localPath.cubicTo(60.0F, 61.656853F, 58.656853F, 63.0F, 57.0F, 63.0F);
      localPath.lineTo(6.0F, 63.0F);
      localPath.cubicTo(4.343146F, 63.0F, 3.0F, 61.656853F, 3.0F, 60.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(60.0F, 43.5F);
      ((Path)localObject).lineTo(69.0F, 43.5F);
      ((Path)localObject).lineTo(69.0F, 47.099998F);
      ((Path)localObject).lineTo(60.0F, 47.099998F);
      ((Path)localObject).lineTo(60.0F, 43.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(54.0F, 34.5F);
      ((Path)localObject).lineTo(69.0F, 34.5F);
      ((Path)localObject).lineTo(69.0F, 38.099998F);
      ((Path)localObject).lineTo(54.0F, 38.099998F);
      ((Path)localObject).lineTo(54.0F, 34.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 25.5F);
      ((Path)localObject).lineTo(69.0F, 25.5F);
      ((Path)localObject).lineTo(69.0F, 29.1F);
      ((Path)localObject).lineTo(48.0F, 29.1F);
      ((Path)localObject).lineTo(48.0F, 25.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.acw
 * JD-Core Version:    0.7.0.1
 */