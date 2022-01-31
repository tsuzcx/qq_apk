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

public final class mo
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint.setColor(-352965);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(27.466667F, 17.799999F);
      ((Path)localObject).lineTo(27.466667F, 23.379999F);
      ((Path)localObject).cubicTo(27.466667F, 23.877056F, 27.063723F, 24.280001F, 26.566668F, 24.280001F);
      ((Path)localObject).lineTo(4.9F, 24.280001F);
      ((Path)localObject).cubicTo(4.402944F, 24.280001F, 4.0F, 23.877056F, 4.0F, 23.379999F);
      ((Path)localObject).lineTo(4.0F, 17.799999F);
      ((Path)localObject).cubicTo(5.178207F, 17.799999F, 6.133333F, 16.832935F, 6.133333F, 15.64F);
      ((Path)localObject).cubicTo(6.133333F, 14.447065F, 5.178207F, 13.48F, 4.0F, 13.48F);
      ((Path)localObject).lineTo(4.0F, 7.9F);
      ((Path)localObject).cubicTo(4.0F, 7.402944F, 4.402944F, 7.0F, 4.9F, 7.0F);
      ((Path)localObject).lineTo(26.566668F, 7.0F);
      ((Path)localObject).cubicTo(27.063723F, 7.0F, 27.466667F, 7.402944F, 27.466667F, 7.9F);
      ((Path)localObject).lineTo(27.466667F, 13.48F);
      ((Path)localObject).cubicTo(26.28846F, 13.48F, 25.333334F, 14.447065F, 25.333334F, 15.64F);
      ((Path)localObject).cubicTo(25.333334F, 16.832935F, 26.28846F, 17.799999F, 27.466667F, 17.799999F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.783334F, 11.32F);
      ((Path)localObject).cubicTo(9.534805F, 11.32F, 9.333333F, 11.521472F, 9.333333F, 11.77F);
      ((Path)localObject).lineTo(9.333333F, 13.03F);
      ((Path)localObject).cubicTo(9.333333F, 13.278528F, 9.534805F, 13.48F, 9.783334F, 13.48F);
      ((Path)localObject).lineTo(18.483334F, 13.48F);
      ((Path)localObject).cubicTo(18.731861F, 13.48F, 18.933332F, 13.278528F, 18.933332F, 13.03F);
      ((Path)localObject).lineTo(18.933332F, 11.77F);
      ((Path)localObject).cubicTo(18.933332F, 11.521472F, 18.731861F, 11.32F, 18.483334F, 11.32F);
      ((Path)localObject).lineTo(9.783334F, 11.32F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.783334F, 15.64F);
      ((Path)localObject).cubicTo(9.534805F, 15.64F, 9.333333F, 15.841472F, 9.333333F, 16.09F);
      ((Path)localObject).lineTo(9.333333F, 17.35F);
      ((Path)localObject).cubicTo(9.333333F, 17.598528F, 9.534805F, 17.799999F, 9.783334F, 17.799999F);
      ((Path)localObject).lineTo(15.283333F, 17.799999F);
      ((Path)localObject).cubicTo(15.531861F, 17.799999F, 15.733334F, 17.598528F, 15.733334F, 17.35F);
      ((Path)localObject).lineTo(15.733334F, 16.09F);
      ((Path)localObject).cubicTo(15.733334F, 15.841472F, 15.531861F, 15.64F, 15.283333F, 15.64F);
      ((Path)localObject).lineTo(9.783334F, 15.64F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.mo
 * JD-Core Version:    0.7.0.1
 */