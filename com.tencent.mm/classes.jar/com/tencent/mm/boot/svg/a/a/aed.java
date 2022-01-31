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

public final class aed
  extends c
{
  private final int height = 210;
  private final int width = 210;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 210;
      return 210;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-13327053);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(105.0F, 0.0F);
      localPath.cubicTo(162.9899F, 0.0F, 210.0F, 47.010098F, 210.0F, 105.0F);
      localPath.cubicTo(210.0F, 162.9899F, 162.9899F, 210.0F, 105.0F, 210.0F);
      localPath.cubicTo(47.010098F, 210.0F, 0.0F, 162.9899F, 0.0F, 105.0F);
      localPath.cubicTo(0.0F, 47.010098F, 47.010098F, 0.0F, 105.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(1275068416);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(105.0F, 0.0F);
      localPath.cubicTo(162.9899F, 0.0F, 210.0F, 47.010098F, 210.0F, 105.0F);
      localPath.cubicTo(210.0F, 162.9899F, 162.9899F, 210.0F, 105.0F, 210.0F);
      localPath.cubicTo(47.010098F, 210.0F, 0.0F, 162.9899F, 0.0F, 105.0F);
      localPath.cubicTo(0.0F, 47.010098F, 47.010098F, 0.0F, 105.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(96.494316F, 113.50568F);
      ((Path)localObject).cubicTo(104.60257F, 121.61394F, 112.28522F, 125.41699F, 115.1263F, 125.19428F);
      ((Path)localObject).cubicTo(117.96738F, 124.97158F, 125.04247F, 120.10603F, 128.38249F, 120.17079F);
      ((Path)localObject).cubicTo(129.98773F, 120.20192F, 140.47748F, 127.29613F, 141.74727F, 128.11635F);
      ((Path)localObject).cubicTo(143.01704F, 128.93655F, 144.19443F, 129.89465F, 143.97304F, 131.10704F);
      ((Path)localObject).cubicTo(143.75165F, 132.31943F, 139.14153F, 145.67386F, 127.37189F, 143.82458F);
      ((Path)localObject).cubicTo(115.60224F, 141.9753F, 99.193718F, 129.28743F, 89.843742F, 120.15626F);
      ((Path)localObject).lineTo(96.494316F, 113.50568F);
      ((Path)localObject).lineTo(96.494316F, 113.50568F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(96.494316F, 113.50568F);
      ((Path)localObject).cubicTo(88.386063F, 105.39743F, 84.583008F, 97.714775F, 84.805717F, 94.873695F);
      ((Path)localObject).cubicTo(85.028419F, 92.032608F, 89.893974F, 84.957527F, 89.829208F, 81.617516F);
      ((Path)localObject).cubicTo(89.79808F, 80.012268F, 82.703865F, 69.522522F, 81.883659F, 68.252739F);
      ((Path)localObject).cubicTo(81.063446F, 66.982948F, 80.105347F, 65.80558F, 78.89296F, 66.026962F);
      ((Path)localObject).cubicTo(77.680565F, 66.248352F, 64.326141F, 70.858475F, 66.175423F, 82.628113F);
      ((Path)localObject).cubicTo(68.024704F, 94.397758F, 80.71257F, 110.80628F, 89.843742F, 120.15626F);
      ((Path)localObject).lineTo(96.494316F, 113.50568F);
      ((Path)localObject).lineTo(96.494316F, 113.50568F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 179, 4);
      localPaint = c.a(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aed
 * JD-Core Version:    0.7.0.1
 */