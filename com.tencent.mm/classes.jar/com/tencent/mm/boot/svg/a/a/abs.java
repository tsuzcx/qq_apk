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

public final class abs
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
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(32.294998F, 25.140745F);
      ((Path)localObject).cubicTo(32.056602F, 24.991747F, 31.78113F, 24.912743F, 31.5F, 24.912743F);
      ((Path)localObject).cubicTo(30.671574F, 24.912743F, 30.0F, 25.584316F, 30.0F, 26.412743F);
      ((Path)localObject).lineTo(30.0F, 45.587257F);
      ((Path)localObject).cubicTo(30.0F, 45.868385F, 30.079004F, 46.14386F, 30.228003F, 46.382256F);
      ((Path)localObject).cubicTo(30.667068F, 47.084759F, 31.592493F, 47.298321F, 32.294998F, 46.859253F);
      ((Path)localObject).lineTo(47.634609F, 37.271999F);
      ((Path)localObject).cubicTo(47.827763F, 37.151276F, 47.990887F, 36.988152F, 48.11161F, 36.794998F);
      ((Path)localObject).cubicTo(48.550674F, 36.092495F, 48.337116F, 35.167068F, 47.634609F, 34.728001F);
      ((Path)localObject).lineTo(32.294998F, 25.140745F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abs
 * JD-Core Version:    0.7.0.1
 */