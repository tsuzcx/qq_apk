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

public final class abo
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
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(54.0F, 12.926538F);
      ((Path)localObject).lineTo(24.0F, 19.503462F);
      ((Path)localObject).lineTo(24.0F, 54.587288F);
      ((Path)localObject).lineTo(24.0F, 57.603806F);
      ((Path)localObject).cubicTo(24.0F, 60.412968F, 22.11874F, 63.152088F, 19.588413F, 64.332199F);
      ((Path)localObject).cubicTo(19.118036F, 64.551575F, 16.14658F, 65.215721F, 15.758582F, 65.293777F);
      ((Path)localObject).cubicTo(12.030496F, 66.043785F, 9.166035F, 62.850475F, 9.008285F, 59.621342F);
      ((Path)localObject).cubicTo(8.850535F, 56.392208F, 10.96819F, 53.699585F, 13.425209F, 53.205288F);
      ((Path)localObject).lineTo(17.218742F, 52.253464F);
      ((Path)localObject).cubicTo(18.559702F, 51.917004F, 19.5F, 50.711636F, 19.5F, 49.329109F);
      ((Path)localObject).lineTo(19.5F, 18.935236F);
      ((Path)localObject).lineTo(19.5F, 17.881247F);
      ((Path)localObject).cubicTo(19.5F, 16.471695F, 20.481295F, 15.252241F, 21.858213F, 14.950698F);
      ((Path)localObject).lineTo(56.679108F, 7.324965F);
      ((Path)localObject).cubicTo(57.488354F, 7.14774F, 58.288048F, 7.660097F, 58.465275F, 8.469345F);
      ((Path)localObject).cubicTo(58.488358F, 8.574749F, 58.5F, 8.682337F, 58.5F, 8.790238F);
      ((Path)localObject).lineTo(58.5F, 10.462189F);
      ((Path)localObject).lineTo(58.5F, 46.601345F);
      ((Path)localObject).lineTo(58.5F, 49.617863F);
      ((Path)localObject).cubicTo(58.5F, 52.427025F, 56.602406F, 55.166145F, 54.050106F, 56.346252F);
      ((Path)localObject).cubicTo(53.575645F, 56.565632F, 50.578388F, 57.229782F, 50.187023F, 57.307838F);
      ((Path)localObject).cubicTo(46.426563F, 58.057846F, 43.537231F, 54.864536F, 43.378109F, 51.635403F);
      ((Path)localObject).cubicTo(43.21899F, 48.406269F, 45.355034F, 45.713642F, 47.833385F, 45.219345F);
      ((Path)localObject).lineTo(51.70845F, 44.261543F);
      ((Path)localObject).cubicTo(53.054424F, 43.928856F, 54.0F, 42.721104F, 54.0F, 41.334625F);
      ((Path)localObject).lineTo(54.0F, 12.926538F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abo
 * JD-Core Version:    0.7.0.1
 */