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

public final class yt
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(3.207107F, 14.207107F);
      ((Path)localObject).cubicTo(2.816582F, 13.816583F, 2.816582F, 13.183417F, 3.207107F, 12.792893F);
      ((Path)localObject).lineTo(12.707107F, 3.292893F);
      ((Path)localObject).cubicTo(12.894643F, 3.105357F, 13.148997F, 3.0F, 13.414213F, 3.0F);
      ((Path)localObject).lineTo(20.0F, 3.0F);
      ((Path)localObject).cubicTo(20.552284F, 3.0F, 21.0F, 3.447715F, 21.0F, 4.0F);
      ((Path)localObject).lineTo(21.0F, 10.585787F);
      ((Path)localObject).cubicTo(21.0F, 10.851003F, 20.894644F, 11.105357F, 20.707108F, 11.292893F);
      ((Path)localObject).lineTo(11.207107F, 20.792892F);
      ((Path)localObject).cubicTo(10.816583F, 21.183418F, 10.183417F, 21.183418F, 9.792893F, 20.792892F);
      ((Path)localObject).lineTo(3.207107F, 14.207107F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.0F, 10.0F);
      ((Path)localObject).cubicTo(17.10457F, 10.0F, 18.0F, 9.104569F, 18.0F, 8.0F);
      ((Path)localObject).cubicTo(18.0F, 6.895431F, 17.10457F, 6.0F, 16.0F, 6.0F);
      ((Path)localObject).cubicTo(14.895431F, 6.0F, 14.0F, 6.895431F, 14.0F, 8.0F);
      ((Path)localObject).cubicTo(14.0F, 9.104569F, 14.895431F, 10.0F, 16.0F, 10.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.yt
 * JD-Core Version:    0.7.0.1
 */