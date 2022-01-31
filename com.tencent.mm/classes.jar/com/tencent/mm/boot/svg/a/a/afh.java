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

public final class afh
  extends c
{
  private final int height = 45;
  private final int width = 45;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 45;
      return 45;
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-16139513);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 1.991658F);
      localPath.cubicTo(0.0F, 0.8916954F, 0.8988921F, 0.0F, 1.991658F, 0.0F);
      localPath.lineTo(43.008343F, 0.0F);
      localPath.cubicTo(44.108303F, 0.0F, 45.0F, 0.8988921F, 45.0F, 1.991658F);
      localPath.lineTo(45.0F, 43.008343F);
      localPath.cubicTo(45.0F, 44.108303F, 44.101109F, 45.0F, 43.008343F, 45.0F);
      localPath.lineTo(1.991658F, 45.0F);
      localPath.cubicTo(0.8916954F, 45.0F, 0.0F, 44.101109F, 0.0F, 43.008343F);
      localPath.lineTo(0.0F, 1.991658F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(31.0F, 29.0F);
      ((Path)localObject).lineTo(27.0F, 29.0F);
      ((Path)localObject).lineTo(27.0F, 27.0F);
      ((Path)localObject).lineTo(31.0F, 27.0F);
      ((Path)localObject).lineTo(31.0F, 23.0F);
      ((Path)localObject).lineTo(33.0F, 23.0F);
      ((Path)localObject).lineTo(33.0F, 27.0F);
      ((Path)localObject).lineTo(37.0F, 27.0F);
      ((Path)localObject).lineTo(37.0F, 29.0F);
      ((Path)localObject).lineTo(33.0F, 29.0F);
      ((Path)localObject).lineTo(33.0F, 33.0F);
      ((Path)localObject).lineTo(31.0F, 33.0F);
      ((Path)localObject).lineTo(31.0F, 29.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(25.730555F, 35.0F);
      ((Path)localObject).lineTo(6.130553F, 35.0F);
      ((Path)localObject).cubicTo(5.440284F, 35.0F, 5.0F, 34.490055F, 5.0F, 33.845936F);
      ((Path)localObject).lineTo(5.0F, 32.114639F);
      ((Path)localObject).cubicTo(5.0F, 30.729998F, 7.115766F, 29.698303F, 11.782929F, 27.036438F);
      ((Path)localObject).cubicTo(13.08324F, 26.29513F, 15.77804F, 25.127686F, 14.031632F, 22.438671F);
      ((Path)localObject).cubicTo(12.713493F, 20.408728F, 11.588755F, 19.536785F, 11.588755F, 16.113152F);
      ((Path)localObject).cubicTo(11.588755F, 12.560062F, 14.101395F, 9.0F, 18.0F, 9.0F);
      ((Path)localObject).cubicTo(21.898605F, 9.0F, 24.411245F, 12.560062F, 24.411245F, 16.113152F);
      ((Path)localObject).cubicTo(24.411245F, 19.536785F, 23.286507F, 20.408728F, 21.968369F, 22.438671F);
      ((Path)localObject).cubicTo(20.814322F, 24.215603F, 21.599625F, 25.328108F, 22.640343F, 26.092281F);
      ((Path)localObject).cubicTo(22.548069F, 26.631046F, 22.5F, 27.184908F, 22.5F, 27.75F);
      ((Path)localObject).cubicTo(22.5F, 29.225077F, 22.827538F, 30.623629F, 23.413855F, 31.876896F);
      ((Path)localObject).cubicTo(23.971626F, 33.069145F, 24.763592F, 34.129913F, 25.730555F, 35.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 28.125736F);
      ((Path)localObject).cubicTo(24.0F, 28.536228F, 24.030445F, 28.939606F, 24.089201F, 29.333736F);
      ((Path)localObject).cubicTo(24.672707F, 33.24789F, 28.048365F, 36.25F, 32.125F, 36.25F);
      ((Path)localObject).cubicTo(36.612865F, 36.25F, 40.25F, 32.612865F, 40.25F, 28.125736F);
      ((Path)localObject).cubicTo(40.25F, 23.637873F, 36.612865F, 20.0F, 32.125F, 20.0F);
      ((Path)localObject).cubicTo(27.637873F, 20.0F, 24.0F, 23.637873F, 24.0F, 28.125736F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.afh
 * JD-Core Version:    0.7.0.1
 */