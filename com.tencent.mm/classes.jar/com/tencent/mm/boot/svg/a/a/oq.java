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

public final class oq
  extends c
{
  private final int height = 60;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 60;
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
      localPaint.setColor(-2565928);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(41.408173F, 42.897102F);
      ((Path)localObject).cubicTo(41.207142F, 42.543682F, 40.927578F, 42.211319F, 40.650383F, 42.022015F);
      ((Path)localObject).lineTo(40.280449F, 41.769379F);
      ((Path)localObject).lineTo(38.0F, 39.48893F);
      ((Path)localObject).lineTo(38.0F, 27.0F);
      ((Path)localObject).lineTo(37.967194F, 27.0F);
      ((Path)localObject).lineTo(37.967194F, 27.0F);
      ((Path)localObject).cubicTo(37.54229F, 20.544485F, 33.033459F, 15.204463F, 27.0F, 13.539232F);
      ((Path)localObject).lineTo(27.0F, 13.539232F);
      ((Path)localObject).lineTo(27.0F, 12.001665F);
      ((Path)localObject).cubicTo(27.0F, 10.33902F, 25.656855F, 9.0F, 24.0F, 9.0F);
      ((Path)localObject).cubicTo(22.346518F, 9.0F, 21.0F, 10.343891F, 21.0F, 12.001665F);
      ((Path)localObject).lineTo(21.0F, 13.132172F);
      ((Path)localObject).cubicTo(18.522533F, 13.46226F, 16.236237F, 14.397065F, 14.294383F, 15.783313F);
      ((Path)localObject).lineTo(5.923328F, 7.412258F);
      ((Path)localObject).cubicTo(5.149499F, 6.638429F, 3.880752F, 6.630319F, 3.103215F, 7.407856F);
      ((Path)localObject).lineTo(2.407856F, 8.103214F);
      ((Path)localObject).cubicTo(1.627709F, 8.883362F, 1.632289F, 10.14336F, 2.412258F, 10.923328F);
      ((Path)localObject).lineTo(42.400352F, 50.911423F);
      ((Path)localObject).cubicTo(43.174179F, 51.685249F, 44.442928F, 51.693359F, 45.220467F, 50.915825F);
      ((Path)localObject).lineTo(45.915825F, 50.220467F);
      ((Path)localObject).cubicTo(46.695972F, 49.440319F, 46.691391F, 48.180321F, 45.911423F, 47.400352F);
      ((Path)localObject).lineTo(41.408173F, 42.897102F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(31.48893F, 47.0F);
      ((Path)localObject).lineTo(18.014584F, 47.0F);
      ((Path)localObject).lineTo(8.999534F, 47.0F);
      ((Path)localObject).lineTo(8.999534F, 47.0F);
      ((Path)localObject).lineTo(6.606894F, 47.0F);
      ((Path)localObject).cubicTo(5.497854F, 47.0F, 4.788665F, 46.126583F, 5.014042F, 45.049168F);
      ((Path)localObject).lineTo(5.325093F, 43.562191F);
      ((Path)localObject).cubicTo(5.438215F, 43.021416F, 5.897074F, 42.33107F, 6.349618F, 42.022015F);
      ((Path)localObject).lineTo(8.0F, 40.894924F);
      ((Path)localObject).lineTo(8.0F, 27.0F);
      ((Path)localObject).lineTo(8.032805F, 27.0F);
      ((Path)localObject).cubicTo(8.099805F, 25.982077F, 8.268347F, 24.991888F, 8.528398F, 24.039469F);
      ((Path)localObject).lineTo(31.48893F, 47.0F);
      ((Path)localObject).lineTo(31.48893F, 47.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(29.0F, 49.0F);
      ((Path)localObject).cubicTo(29.0F, 51.761425F, 26.761423F, 54.0F, 24.0F, 54.0F);
      ((Path)localObject).cubicTo(21.238577F, 54.0F, 19.0F, 51.761425F, 19.0F, 49.0F);
      ((Path)localObject).lineTo(29.0F, 49.0F);
      ((Path)localObject).lineTo(29.0F, 49.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.oq
 * JD-Core Version:    0.7.0.1
 */