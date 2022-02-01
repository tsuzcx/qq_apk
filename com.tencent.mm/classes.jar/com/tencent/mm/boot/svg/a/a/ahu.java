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

public final class ahu
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localPaint.setColor(-436207616);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(7.363961F, 15.22F);
      ((Path)localObject).lineTo(4.78F, 15.22F);
      ((Path)localObject).lineTo(4.78F, 13.22F);
      ((Path)localObject).lineTo(9.78F, 13.22F);
      ((Path)localObject).cubicTo(10.332285F, 13.22F, 10.78F, 13.667715F, 10.78F, 14.22F);
      ((Path)localObject).lineTo(10.78F, 19.220001F);
      ((Path)localObject).lineTo(8.78F, 19.220001F);
      ((Path)localObject).lineTo(8.78F, 16.63364F);
      ((Path)localObject).lineTo(4.414214F, 20.998175F);
      ((Path)localObject).lineTo(3.0F, 19.583961F);
      ((Path)localObject).lineTo(7.363961F, 15.22F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.63604F, 8.778174F);
      ((Path)localObject).lineTo(19.220001F, 8.778174F);
      ((Path)localObject).lineTo(19.220001F, 10.778174F);
      ((Path)localObject).lineTo(14.22F, 10.778174F);
      ((Path)localObject).cubicTo(13.667715F, 10.778174F, 13.22F, 10.33046F, 13.22F, 9.778174F);
      ((Path)localObject).lineTo(13.22F, 4.778174F);
      ((Path)localObject).lineTo(15.22F, 4.778174F);
      ((Path)localObject).lineTo(15.22F, 7.364534F);
      ((Path)localObject).lineTo(19.585787F, 3.0F);
      ((Path)localObject).lineTo(21.0F, 4.414214F);
      ((Path)localObject).lineTo(16.63604F, 8.778174F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahu
 * JD-Core Version:    0.7.0.1
 */