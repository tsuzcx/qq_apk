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

public final class th
  extends c
{
  private final int height = 54;
  private final int width = 54;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 54;
      return 54;
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
      localPaint.setColor(-10658467);
      localCanvas.saveLayerAlpha(null, 51, 4);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(27.0F, 10.48036F);
      ((Path)localObject).cubicTo(28.520756F, 7.518707F, 31.927713F, 3.0F, 38.559685F, 3.0F);
      ((Path)localObject).cubicTo(48.424431F, 3.0F, 55.286037F, 9.86097F, 53.796867F, 19.960094F);
      ((Path)localObject).cubicTo(51.854919F, 31.372169F, 31.893957F, 47.352608F, 27.419691F, 51.072113F);
      ((Path)localObject).cubicTo(27.187933F, 51.264778F, 26.997726F, 51.424545F, 26.853727F, 51.549076F);
      ((Path)localObject).cubicTo(26.85368F, 51.566315F, 26.853643F, 51.58329F, 26.853621F, 51.599998F);
      ((Path)localObject).cubicTo(26.844093F, 51.591694F, 26.834339F, 51.583206F, 26.824354F, 51.574547F);
      ((Path)localObject).cubicTo(26.819895F, 51.578423F, 26.815485F, 51.582264F, 26.811125F, 51.586067F);
      ((Path)localObject).cubicTo(26.811113F, 51.578449F, 26.8111F, 51.570774F, 26.811085F, 51.563046F);
      ((Path)localObject).cubicTo(23.89057F, 49.03434F, 2.245681F, 31.963354F, 0.203133F, 19.960094F);
      ((Path)localObject).cubicTo(-1.286039F, 9.86097F, 5.57557F, 3.0F, 15.440317F, 3.0F);
      ((Path)localObject).cubicTo(22.072287F, 3.0F, 25.479244F, 7.518707F, 27.0F, 10.48036F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.th
 * JD-Core Version:    0.7.0.1
 */