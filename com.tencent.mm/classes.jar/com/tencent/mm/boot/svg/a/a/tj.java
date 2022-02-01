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

public final class tj
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
      ((Path)localObject).moveTo(24.743999F, 14.0F);
      ((Path)localObject).lineTo(55.703999F, 14.0F);
      ((Path)localObject).lineTo(55.703999F, 20.912001F);
      ((Path)localObject).lineTo(31.08F, 20.912001F);
      ((Path)localObject).lineTo(29.568001F, 35.743999F);
      ((Path)localObject).lineTo(29.784F, 35.743999F);
      ((Path)localObject).cubicTo(31.368F, 34.088001F, 33.167999F, 32.936001F, 35.256001F, 32.216F);
      ((Path)localObject).cubicTo(37.127998F, 31.424F, 39.287998F, 31.063999F, 41.591999F, 31.063999F);
      ((Path)localObject).cubicTo(46.416F, 31.063999F, 50.375999F, 32.647999F, 53.400002F, 35.816002F);
      ((Path)localObject).cubicTo(56.424F, 38.984001F, 58.007999F, 43.304001F, 58.007999F, 48.848F);
      ((Path)localObject).cubicTo(58.007999F, 54.175999F, 55.992001F, 58.495998F, 52.104F, 61.880001F);
      ((Path)localObject).cubicTo(48.431999F, 64.903999F, 44.040001F, 66.416F, 38.928001F, 66.416F);
      ((Path)localObject).cubicTo(34.32F, 66.416F, 30.360001F, 65.120003F, 27.048F, 62.599998F);
      ((Path)localObject).cubicTo(23.375999F, 59.863998F, 21.360001F, 56.048F, 21.0F, 51.296001F);
      ((Path)localObject).lineTo(28.704F, 51.296001F);
      ((Path)localObject).cubicTo(28.992001F, 54.175999F, 30.143999F, 56.408001F, 32.088001F, 57.848F);
      ((Path)localObject).cubicTo(33.816002F, 59.144001F, 36.119999F, 59.792F, 39.0F, 59.792F);
      ((Path)localObject).cubicTo(42.167999F, 59.792F, 44.832001F, 58.784F, 46.992001F, 56.84F);
      ((Path)localObject).cubicTo(49.152F, 54.824001F, 50.231998F, 52.231998F, 50.231998F, 48.919998F);
      ((Path)localObject).cubicTo(50.231998F, 45.32F, 49.296001F, 42.512001F, 47.424F, 40.495998F);
      ((Path)localObject).cubicTo(45.551998F, 38.48F, 42.959999F, 37.472F, 39.504002F, 37.472F);
      ((Path)localObject).cubicTo(37.200001F, 37.472F, 35.256001F, 37.832001F, 33.528F, 38.695999F);
      ((Path)localObject).cubicTo(31.656F, 39.560001F, 30.288F, 40.928001F, 29.280001F, 42.799999F);
      ((Path)localObject).lineTo(21.936001F, 42.799999F);
      ((Path)localObject).lineTo(24.743999F, 14.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.tj
 * JD-Core Version:    0.7.0.1
 */