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

public final class ym
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
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(39.94915F, 0.0F);
      localPath.lineTo(39.94915F, 39.94915F);
      localPath.lineTo(0.0F, 39.94915F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-3355444);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.506849F, 0.0F, 1.0F, 13.150685F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(16.203501F, 12.888432F);
      ((Path)localObject2).cubicTo(16.194273F, 12.974248F, 16.184774F, 13.061666F, 16.175003F, 13.150685F);
      ((Path)localObject2).lineTo(11.088048F, 13.150685F);
      ((Path)localObject2).lineTo(0.1406831F, 13.150685F);
      ((Path)localObject2).lineTo(0.1406831F, 12.759707F);
      ((Path)localObject2).cubicTo(0.05224029F, 12.619041F, 0.0F, 12.449673F, 0.0F, 12.267411F);
      ((Path)localObject2).lineTo(0.0F, 0.883274F);
      ((Path)localObject2).cubicTo(0.0F, 0.3935739F, 0.3649688F, 1.337819E-014F, 0.8151807F, 1.337819E-014F);
      ((Path)localObject2).lineTo(15.623176F, 1.337819E-014F);
      ((Path)localObject2).cubicTo(16.064133F, 1.337819E-014F, 16.438356F, 0.3954551F, 16.438356F, 0.883274F);
      ((Path)localObject2).lineTo(16.438356F, 12.267411F);
      ((Path)localObject2).cubicTo(16.438356F, 12.510094F, 16.348722F, 12.729167F, 16.203501F, 12.888432F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.79452F, 7.983133F);
      ((Path)localObject2).lineTo(14.79452F, 1.643836F);
      ((Path)localObject2).lineTo(1.643836F, 1.643836F);
      ((Path)localObject2).lineTo(1.643836F, 7.935752F);
      ((Path)localObject2).lineTo(5.008241F, 5.168386F);
      ((Path)localObject2).cubicTo(5.407779F, 4.83975F, 6.049406F, 4.855688F, 6.434533F, 5.19986F);
      ((Path)localObject2).lineTo(10.301113F, 8.65526F);
      ((Path)localObject2).lineTo(12.272379F, 6.950264F);
      ((Path)localObject2).cubicTo(12.671624F, 6.604947F, 13.306842F, 6.611962F, 13.69442F, 6.965714F);
      ((Path)localObject2).lineTo(14.79452F, 7.983133F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ym
 * JD-Core Version:    0.7.0.1
 */