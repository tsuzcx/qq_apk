package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class ajr
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(54.0F, 11.199985F);
      ((Path)localObject2).lineTo(18.136274F, 6.481073F);
      ((Path)localObject2).lineTo(51.467896F, 1.851681F);
      ((Path)localObject2).cubicTo(52.866337F, 1.657453F, 54.0F, 2.636986F, 54.0F, 4.068503F);
      ((Path)localObject2).lineTo(54.0F, 11.199985F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 11.638901F);
      ((Path)localObject2).cubicTo(0.0F, 9.979069F, 1.352776F, 8.811505F, 2.984314F, 9.026181F);
      ((Path)localObject2).lineTo(54.477234F, 15.801565F);
      ((Path)localObject2).cubicTo(55.870518F, 15.984893F, 57.0F, 17.29693F, 57.0F, 18.711035F);
      ((Path)localObject2).lineTo(57.0F, 50.628117F);
      ((Path)localObject2).cubicTo(57.0F, 52.287949F, 55.647224F, 53.455513F, 54.015686F, 53.240837F);
      ((Path)localObject2).lineTo(2.522766F, 46.46545F);
      ((Path)localObject2).cubicTo(1.129481F, 46.282124F, 0.0F, 44.970085F, 0.0F, 43.555981F);
      ((Path)localObject2).lineTo(0.0F, 11.638901F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ajr
 * JD-Core Version:    0.7.0.1
 */