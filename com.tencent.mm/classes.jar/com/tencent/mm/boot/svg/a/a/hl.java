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

public final class hl
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
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(30.0F, 56.400002F);
      ((Path)localObject2).cubicTo(44.580318F, 56.400002F, 56.400002F, 44.580318F, 56.400002F, 30.0F);
      ((Path)localObject2).cubicTo(56.400002F, 15.419683F, 44.580318F, 3.6F, 30.0F, 3.6F);
      ((Path)localObject2).cubicTo(15.419683F, 3.6F, 3.6F, 15.419683F, 3.6F, 30.0F);
      ((Path)localObject2).cubicTo(3.6F, 44.580318F, 15.419683F, 56.400002F, 30.0F, 56.400002F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 60.0F);
      ((Path)localObject2).cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      ((Path)localObject2).cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject2).cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      ((Path)localObject2).cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 44.400002F);
      ((Path)localObject2).cubicTo(37.9529F, 44.400002F, 44.400002F, 37.9529F, 44.400002F, 30.0F);
      ((Path)localObject2).cubicTo(44.400002F, 22.0471F, 37.9529F, 15.6F, 30.0F, 15.6F);
      ((Path)localObject2).cubicTo(22.0471F, 15.6F, 15.6F, 22.0471F, 15.6F, 30.0F);
      ((Path)localObject2).cubicTo(15.6F, 37.9529F, 22.0471F, 44.400002F, 30.0F, 44.400002F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 48.0F);
      ((Path)localObject2).cubicTo(20.058874F, 48.0F, 12.0F, 39.941124F, 12.0F, 30.0F);
      ((Path)localObject2).cubicTo(12.0F, 20.058874F, 20.058874F, 12.0F, 30.0F, 12.0F);
      ((Path)localObject2).cubicTo(39.941124F, 12.0F, 48.0F, 20.058874F, 48.0F, 30.0F);
      ((Path)localObject2).cubicTo(48.0F, 39.941124F, 39.941124F, 48.0F, 30.0F, 48.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.hl
 * JD-Core Version:    0.7.0.1
 */