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

public final class rj
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      localPaint.setColor(-1);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(40.223999F, 13.0F);
      ((Path)localObject).cubicTo(50.16F, 13.0F, 55.848F, 17.608F, 57.144001F, 26.968F);
      ((Path)localObject).lineTo(49.512001F, 26.968F);
      ((Path)localObject).cubicTo(48.431999F, 21.927999F, 45.335999F, 19.48F, 40.152F, 19.48F);
      ((Path)localObject).cubicTo(36.551998F, 19.48F, 33.743999F, 21.208F, 31.656F, 24.736F);
      ((Path)localObject).cubicTo(29.568001F, 28.048F, 28.559999F, 32.152F, 28.559999F, 37.192001F);
      ((Path)localObject).cubicTo(28.559999F, 37.408001F, 28.559999F, 37.695999F, 28.632F, 38.127998F);
      ((Path)localObject).lineTo(28.92F, 38.127998F);
      ((Path)localObject).cubicTo(30.360001F, 35.824001F, 32.16F, 34.167999F, 34.391998F, 33.088001F);
      ((Path)localObject).cubicTo(36.408001F, 32.007999F, 38.784F, 31.504F, 41.52F, 31.504F);
      ((Path)localObject).cubicTo(46.560001F, 31.504F, 50.591999F, 33.088001F, 53.616001F, 36.256001F);
      ((Path)localObject).cubicTo(56.568001F, 39.495998F, 58.080002F, 43.672001F, 58.080002F, 48.712002F);
      ((Path)localObject).cubicTo(58.080002F, 53.824001F, 56.352001F, 58.071999F, 52.967999F, 61.383999F);
      ((Path)localObject).cubicTo(49.512001F, 64.695999F, 45.192001F, 66.424004F, 40.152F, 66.424004F);
      ((Path)localObject).cubicTo(33.816002F, 66.424004F, 29.063999F, 64.120003F, 25.752001F, 59.512001F);
      ((Path)localObject).cubicTo(22.584F, 55.119999F, 21.0F, 49.0F, 21.0F, 41.152F);
      ((Path)localObject).cubicTo(21.0F, 32.799999F, 22.656F, 26.032F, 26.112F, 20.848F);
      ((Path)localObject).cubicTo(29.568001F, 15.592F, 34.32F, 13.0F, 40.223999F, 13.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.936001F, 37.84F);
      ((Path)localObject).cubicTo(36.695999F, 37.84F, 34.175999F, 38.848F, 32.304001F, 40.863998F);
      ((Path)localObject).cubicTo(30.431999F, 42.880001F, 29.496F, 45.543999F, 29.496F, 48.928001F);
      ((Path)localObject).cubicTo(29.496F, 52.240002F, 30.431999F, 54.903999F, 32.375999F, 56.919998F);
      ((Path)localObject).cubicTo(34.248001F, 58.936001F, 36.768002F, 59.944F, 39.863998F, 59.944F);
      ((Path)localObject).cubicTo(43.032001F, 59.944F, 45.551998F, 58.863998F, 47.424F, 56.776001F);
      ((Path)localObject).cubicTo(49.368F, 54.616001F, 50.375999F, 51.952F, 50.375999F, 48.712002F);
      ((Path)localObject).cubicTo(50.375999F, 45.400002F, 49.439999F, 42.736F, 47.568001F, 40.863998F);
      ((Path)localObject).cubicTo(45.695999F, 38.848F, 43.104F, 37.84F, 39.936001F, 37.84F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.rj
 * JD-Core Version:    0.7.0.1
 */