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

public final class tg
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(40.504002F, 14.0F);
      ((Path)localObject).cubicTo(45.400002F, 14.0F, 49.504002F, 15.368F, 52.672001F, 18.247999F);
      ((Path)localObject).cubicTo(55.768002F, 21.128F, 57.352001F, 24.799999F, 57.352001F, 29.336F);
      ((Path)localObject).cubicTo(57.352001F, 33.799999F, 55.624001F, 37.832001F, 52.312F, 41.504002F);
      ((Path)localObject).cubicTo(50.296001F, 43.591999F, 46.768002F, 46.327999F, 41.655998F, 49.784F);
      ((Path)localObject).cubicTo(36.112F, 53.456001F, 32.799999F, 56.695999F, 31.719999F, 59.504002F);
      ((Path)localObject).lineTo(57.424F, 59.504002F);
      ((Path)localObject).lineTo(57.424F, 66.416F);
      ((Path)localObject).lineTo(22.0F, 66.416F);
      ((Path)localObject).cubicTo(22.0F, 61.304001F, 23.656F, 56.84F, 27.112F, 52.952F);
      ((Path)localObject).cubicTo(28.983999F, 50.720001F, 32.872002F, 47.624001F, 38.703999F, 43.591999F);
      ((Path)localObject).cubicTo(42.16F, 41.144001F, 44.608002F, 39.200001F, 46.048F, 37.688F);
      ((Path)localObject).cubicTo(48.352001F, 35.096001F, 49.576F, 32.287998F, 49.576F, 29.264F);
      ((Path)localObject).cubicTo(49.576F, 26.384001F, 48.784F, 24.224001F, 47.200001F, 22.784F);
      ((Path)localObject).cubicTo(45.616001F, 21.344F, 43.240002F, 20.624001F, 40.216F, 20.624001F);
      ((Path)localObject).cubicTo(36.976002F, 20.624001F, 34.528F, 21.704F, 32.872002F, 23.936001F);
      ((Path)localObject).cubicTo(31.143999F, 26.096001F, 30.280001F, 29.191999F, 30.136F, 33.368F);
      ((Path)localObject).lineTo(22.288F, 33.368F);
      ((Path)localObject).cubicTo(22.360001F, 27.608F, 24.016001F, 23.0F, 27.256001F, 19.544001F);
      ((Path)localObject).cubicTo(30.568001F, 15.8F, 35.032001F, 14.0F, 40.504002F, 14.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.tg
 * JD-Core Version:    0.7.0.1
 */