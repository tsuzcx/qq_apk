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

public final class se
  extends c
{
  private final int height = 80;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-12206054);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(46.16F, 67.690002F);
      ((Path)localObject).cubicTo(68.720001F, 45.130001F, 91.279999F, 22.57F, 113.84F, 0.01F);
      ((Path)localObject).cubicTo(115.9F, 2.05F, 117.95F, 4.1F, 119.99F, 6.16F);
      ((Path)localObject).cubicTo(95.389999F, 30.780001F, 70.769997F, 55.380001F, 46.16F, 79.989998F);
      ((Path)localObject).cubicTo(30.77F, 64.620003F, 15.38F, 49.240002F, 0.01F, 33.849998F);
      ((Path)localObject).cubicTo(2.05F, 31.790001F, 4.1F, 29.74F, 6.16F, 27.709999F);
      ((Path)localObject).cubicTo(19.5F, 41.02F, 32.810001F, 54.369999F, 46.16F, 67.690002F);
      ((Path)localObject).lineTo(46.16F, 67.690002F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.se
 * JD-Core Version:    0.7.0.1
 */