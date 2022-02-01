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

public final class bmu
  extends c
{
  private final int height = 36;
  private final int width = 36;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 36;
      return 36;
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
      localPaint.setColor(-3833595);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(30.0F, 18.0F);
      ((Path)localObject).cubicTo(30.0F, 18.0F, 26.249992F, 20.250055F, 23.249962F, 23.249962F);
      ((Path)localObject).cubicTo(20.250055F, 26.249992F, 18.0F, 30.0F, 18.0F, 30.0F);
      ((Path)localObject).cubicTo(18.0F, 30.0F, 15.698808F, 26.198854F, 12.750039F, 23.249962F);
      ((Path)localObject).cubicTo(9.801146F, 20.301191F, 6.0F, 18.0F, 6.0F, 18.0F);
      ((Path)localObject).cubicTo(6.0F, 18.0F, 9.750008F, 15.749946F, 12.750039F, 12.750039F);
      ((Path)localObject).cubicTo(15.749946F, 9.750008F, 18.0F, 6.0F, 18.0F, 6.0F);
      ((Path)localObject).cubicTo(18.0F, 6.0F, 20.223738F, 9.723691F, 23.249962F, 12.750039F);
      ((Path)localObject).cubicTo(26.27631F, 15.776262F, 30.0F, 18.0F, 30.0F, 18.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bmu
 * JD-Core Version:    0.7.0.1
 */