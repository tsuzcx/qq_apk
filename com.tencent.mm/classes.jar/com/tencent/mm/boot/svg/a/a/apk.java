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

public final class apk
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
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(30.0F, 56.400002F);
      ((Path)localObject3).cubicTo(44.580318F, 56.400002F, 56.400002F, 44.580318F, 56.400002F, 30.0F);
      ((Path)localObject3).cubicTo(56.400002F, 15.419683F, 44.580318F, 3.6F, 30.0F, 3.6F);
      ((Path)localObject3).cubicTo(15.419683F, 3.6F, 3.6F, 15.419683F, 3.6F, 30.0F);
      ((Path)localObject3).cubicTo(3.6F, 44.580318F, 15.419683F, 56.400002F, 30.0F, 56.400002F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(30.0F, 60.0F);
      ((Path)localObject3).cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      ((Path)localObject3).cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject3).cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      ((Path)localObject3).cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(28.199982F, 28.199982F);
      ((Path)localObject2).lineTo(28.199982F, 15.0F);
      ((Path)localObject2).lineTo(31.799982F, 15.0F);
      ((Path)localObject2).lineTo(31.799982F, 28.199982F);
      ((Path)localObject2).lineTo(45.0F, 28.199982F);
      ((Path)localObject2).lineTo(45.0F, 31.799982F);
      ((Path)localObject2).lineTo(31.799982F, 31.799982F);
      ((Path)localObject2).lineTo(31.799982F, 45.0F);
      ((Path)localObject2).lineTo(28.199982F, 45.0F);
      ((Path)localObject2).lineTo(28.199982F, 31.799982F);
      ((Path)localObject2).lineTo(15.0F, 31.799982F);
      ((Path)localObject2).lineTo(15.0F, 28.199982F);
      ((Path)localObject2).lineTo(28.199982F, 28.199982F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.apk
 * JD-Core Version:    0.7.0.1
 */