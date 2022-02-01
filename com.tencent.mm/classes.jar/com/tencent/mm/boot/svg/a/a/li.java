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

public final class li
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      ((Paint)localObject).setColor(-9276814);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(8.0F, 32.0F);
      localPath.cubicTo(8.0F, 28.686291F, 10.686291F, 26.0F, 14.0F, 26.0F);
      localPath.lineTo(130.0F, 26.0F);
      localPath.cubicTo(133.31371F, 26.0F, 136.0F, 28.686291F, 136.0F, 32.0F);
      localPath.lineTo(136.0F, 112.0F);
      localPath.cubicTo(136.0F, 115.31371F, 133.31371F, 118.0F, 130.0F, 118.0F);
      localPath.lineTo(14.0F, 118.0F);
      localPath.cubicTo(10.686291F, 118.0F, 8.0F, 115.31371F, 8.0F, 112.0F);
      localPath.lineTo(8.0F, 32.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(71.885094F, 65.030899F);
      ((Path)localObject).lineTo(27.494259F, 39.401836F);
      ((Path)localObject).cubicTo(26.058262F, 38.572762F, 24.230272F, 39.068474F, 23.401754F, 40.50351F);
      ((Path)localObject).lineTo(21.402084F, 43.967037F);
      ((Path)localObject).cubicTo(20.576242F, 45.397442F, 21.06255F, 47.235489F, 22.494259F, 48.062088F);
      ((Path)localObject).lineTo(70.312874F, 75.670181F);
      ((Path)localObject).cubicTo(70.809265F, 75.956772F, 71.352501F, 76.08506F, 71.885094F, 76.070969F);
      ((Path)localObject).cubicTo(72.417694F, 76.08506F, 72.96093F, 75.956772F, 73.457321F, 75.670181F);
      ((Path)localObject).lineTo(121.27593F, 48.062088F);
      ((Path)localObject).cubicTo(122.70764F, 47.235489F, 123.19395F, 45.397442F, 122.36811F, 43.967037F);
      ((Path)localObject).lineTo(120.36844F, 40.50351F);
      ((Path)localObject).cubicTo(119.53992F, 39.068474F, 117.71193F, 38.572762F, 116.27593F, 39.401836F);
      ((Path)localObject).lineTo(71.885094F, 65.030899F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.li
 * JD-Core Version:    0.7.0.1
 */