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

public final class to
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
      ((Path)localObject).moveTo(40.007999F, 13.0F);
      ((Path)localObject).cubicTo(45.192001F, 13.0F, 49.296001F, 14.224F, 52.464001F, 16.743999F);
      ((Path)localObject).cubicTo(55.487999F, 19.264F, 57.071999F, 22.719999F, 57.071999F, 27.112F);
      ((Path)localObject).cubicTo(57.071999F, 32.728001F, 54.192001F, 36.543999F, 48.576F, 38.416F);
      ((Path)localObject).cubicTo(51.599998F, 39.352001F, 53.903999F, 40.792F, 55.487999F, 42.664001F);
      ((Path)localObject).cubicTo(57.216F, 44.608002F, 58.080002F, 47.127998F, 58.080002F, 50.152F);
      ((Path)localObject).cubicTo(58.080002F, 54.903999F, 56.424F, 58.792F, 53.183998F, 61.816002F);
      ((Path)localObject).cubicTo(49.728001F, 64.839996F, 45.192001F, 66.424004F, 39.720001F, 66.424004F);
      ((Path)localObject).cubicTo(34.464001F, 66.424004F, 30.216F, 65.056F, 27.048F, 62.391998F);
      ((Path)localObject).cubicTo(23.448F, 59.368F, 21.431999F, 54.976002F, 21.0F, 49.216F);
      ((Path)localObject).lineTo(28.92F, 49.216F);
      ((Path)localObject).cubicTo(29.063999F, 52.672001F, 30.143999F, 55.335999F, 32.304001F, 57.208F);
      ((Path)localObject).cubicTo(34.175999F, 58.936001F, 36.624001F, 59.799999F, 39.647999F, 59.799999F);
      ((Path)localObject).cubicTo(42.959999F, 59.799999F, 45.624001F, 58.792F, 47.639999F, 56.919998F);
      ((Path)localObject).cubicTo(49.368F, 55.192001F, 50.304001F, 53.104F, 50.304001F, 50.512001F);
      ((Path)localObject).cubicTo(50.304001F, 47.487999F, 49.368F, 45.256001F, 47.495998F, 43.816002F);
      ((Path)localObject).cubicTo(45.768002F, 42.375999F, 43.175999F, 41.655998F, 39.792F, 41.655998F);
      ((Path)localObject).lineTo(36.048F, 41.655998F);
      ((Path)localObject).lineTo(36.048F, 35.751999F);
      ((Path)localObject).lineTo(39.720001F, 35.751999F);
      ((Path)localObject).cubicTo(42.888F, 35.751999F, 45.264F, 35.032001F, 46.848F, 33.664001F);
      ((Path)localObject).cubicTo(48.431999F, 32.296001F, 49.296001F, 30.280001F, 49.296001F, 27.688F);
      ((Path)localObject).cubicTo(49.296001F, 25.096001F, 48.504002F, 23.152F, 47.063999F, 21.784F);
      ((Path)localObject).cubicTo(45.48F, 20.344F, 43.104F, 19.695999F, 40.080002F, 19.695999F);
      ((Path)localObject).cubicTo(36.984001F, 19.695999F, 34.535999F, 20.488001F, 32.807999F, 22.072001F);
      ((Path)localObject).cubicTo(31.08F, 23.656F, 30.0F, 26.032F, 29.712F, 29.200001F);
      ((Path)localObject).lineTo(22.007999F, 29.200001F);
      ((Path)localObject).cubicTo(22.440001F, 24.087999F, 24.312F, 20.128F, 27.695999F, 17.247999F);
      ((Path)localObject).cubicTo(30.864F, 14.368F, 34.967999F, 13.0F, 40.007999F, 13.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.to
 * JD-Core Version:    0.7.0.1
 */