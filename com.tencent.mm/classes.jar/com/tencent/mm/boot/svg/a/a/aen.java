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

public final class aen
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(26.545586F, 21.454414F);
      ((Path)localObject).lineTo(33.878681F, 14.121321F);
      ((Path)localObject).cubicTo(35.050251F, 12.949747F, 36.949749F, 12.949747F, 38.121319F, 14.121321F);
      ((Path)localObject).cubicTo(38.683929F, 14.683929F, 39.0F, 15.446991F, 39.0F, 16.242641F);
      ((Path)localObject).lineTo(39.0F, 33.908829F);
      ((Path)localObject).lineTo(47.590534F, 42.499363F);
      ((Path)localObject).cubicTo(48.822994F, 40.591305F, 49.5F, 38.351662F, 49.5F, 36.0F);
      ((Path)localObject).cubicTo(49.5F, 32.770882F, 48.22353F, 29.752968F, 45.985283F, 27.514719F);
      ((Path)localObject).lineTo(48.530865F, 24.969133F);
      ((Path)localObject).cubicTo(51.353912F, 27.792179F, 53.099998F, 31.692179F, 53.099998F, 36.0F);
      ((Path)localObject).cubicTo(53.099998F, 39.39122F, 52.01791F, 42.529701F, 50.180176F, 45.089008F);
      ((Path)localObject).lineTo(53.609615F, 48.518444F);
      ((Path)localObject).cubicTo(56.362686F, 44.983818F, 57.900002F, 40.616837F, 57.900002F, 36.0F);
      ((Path)localObject).cubicTo(57.900002F, 30.51273F, 55.728367F, 25.378408F, 51.92498F, 21.575022F);
      ((Path)localObject).lineTo(54.470562F, 19.029438F);
      ((Path)localObject).cubicTo(58.813709F, 23.372583F, 61.5F, 29.372583F, 61.5F, 36.0F);
      ((Path)localObject).cubicTo(61.5F, 41.712715F, 59.504047F, 46.959255F, 56.171463F, 51.080296F);
      ((Path)localObject).lineTo(64.27494F, 59.183765F);
      ((Path)localObject).lineTo(61.729351F, 61.729351F);
      ((Path)localObject).lineTo(11.545586F, 11.545585F);
      ((Path)localObject).lineTo(14.09117F, 9.0F);
      ((Path)localObject).lineTo(26.545586F, 21.454414F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 30.908829F);
      ((Path)localObject).lineTo(36.0F, 16.242641F);
      ((Path)localObject).lineTo(28.666906F, 23.575735F);
      ((Path)localObject).lineTo(36.0F, 30.908829F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(23.408829F, 28.5F);
      ((Path)localObject).lineTo(9.0F, 28.5F);
      ((Path)localObject).lineTo(9.0F, 43.5F);
      ((Path)localObject).lineTo(23.742641F, 43.5F);
      ((Path)localObject).lineTo(36.0F, 55.757359F);
      ((Path)localObject).lineTo(36.0F, 41.091171F);
      ((Path)localObject).lineTo(39.0F, 44.091171F);
      ((Path)localObject).lineTo(39.0F, 55.757359F);
      ((Path)localObject).cubicTo(39.0F, 57.414215F, 37.656853F, 58.757359F, 36.0F, 58.757359F);
      ((Path)localObject).cubicTo(35.20435F, 58.757359F, 34.441288F, 58.441288F, 33.878681F, 57.878681F);
      ((Path)localObject).lineTo(22.5F, 46.5F);
      ((Path)localObject).lineTo(9.0F, 46.5F);
      ((Path)localObject).cubicTo(7.343146F, 46.5F, 6.0F, 45.156853F, 6.0F, 43.5F);
      ((Path)localObject).lineTo(6.0F, 28.5F);
      ((Path)localObject).cubicTo(6.0F, 26.843145F, 7.343146F, 25.5F, 9.0F, 25.5F);
      ((Path)localObject).lineTo(20.408829F, 25.5F);
      ((Path)localObject).lineTo(23.408829F, 28.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aen
 * JD-Core Version:    0.7.0.1
 */