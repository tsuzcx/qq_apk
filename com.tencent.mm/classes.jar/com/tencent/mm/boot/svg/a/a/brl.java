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

public final class brl
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      ((Paint)localObject).setColor(637534208);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(60.0F, 0.0F);
      localPath.cubicTo(93.137085F, 0.0F, 120.0F, 26.862915F, 120.0F, 60.0F);
      localPath.cubicTo(120.0F, 93.137085F, 93.137085F, 120.0F, 60.0F, 120.0F);
      localPath.cubicTo(26.862915F, 120.0F, 0.0F, 93.137085F, 0.0F, 60.0F);
      localPath.cubicTo(0.0F, 26.862915F, 26.862915F, 0.0F, 60.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(60.0F, 0.0F);
      ((Path)localObject).cubicTo(93.137085F, 0.0F, 120.0F, 26.862915F, 120.0F, 60.0F);
      ((Path)localObject).cubicTo(120.0F, 93.137085F, 93.137085F, 120.0F, 60.0F, 120.0F);
      ((Path)localObject).cubicTo(26.862915F, 120.0F, 0.0F, 93.137085F, 0.0F, 60.0F);
      ((Path)localObject).cubicTo(0.0F, 26.862915F, 26.862915F, 0.0F, 60.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.0F, 3.6F);
      ((Path)localObject).cubicTo(28.851141F, 3.6F, 3.6F, 28.851141F, 3.6F, 60.0F);
      ((Path)localObject).cubicTo(3.6F, 91.148857F, 28.851141F, 116.4F, 60.0F, 116.4F);
      ((Path)localObject).cubicTo(91.148857F, 116.4F, 116.4F, 91.148857F, 116.4F, 60.0F);
      ((Path)localObject).cubicTo(116.4F, 28.851141F, 91.148857F, 3.6F, 60.0F, 3.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 38.16954F);
      ((Path)localObject).cubicTo(48.522079F, 38.16954F, 49.035122F, 38.305786F, 49.488419F, 38.564808F);
      ((Path)localObject).lineTo(82.441727F, 57.395271F);
      ((Path)localObject).cubicTo(83.88028F, 58.2173F, 84.380066F, 60.049866F, 83.558037F, 61.488419F);
      ((Path)localObject).cubicTo(83.292267F, 61.95351F, 82.906815F, 62.338963F, 82.441727F, 62.604729F);
      ((Path)localObject).lineTo(49.488419F, 81.435188F);
      ((Path)localObject).cubicTo(48.049866F, 82.257217F, 46.2173F, 81.757431F, 45.395271F, 80.318878F);
      ((Path)localObject).cubicTo(45.136246F, 79.865585F, 45.0F, 79.352539F, 45.0F, 78.83046F);
      ((Path)localObject).lineTo(45.0F, 41.16954F);
      ((Path)localObject).cubicTo(45.0F, 39.512684F, 46.343147F, 38.16954F, 48.0F, 38.16954F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.brl
 * JD-Core Version:    0.7.0.1
 */