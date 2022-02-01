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

public final class beg
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
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16726153);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(54.0F, 3.068503F);
      ((Path)localObject2).cubicTo(54.0F, 1.636985F, 52.866337F, 0.657453F, 51.467896F, 0.8516811F);
      ((Path)localObject2).lineTo(2.532104F, 7.648319F);
      ((Path)localObject2).cubicTo(1.127867F, 7.843352F, 0.0F, 9.149959F, 0.0F, 10.568503F);
      ((Path)localObject2).lineTo(3.6F, 11.134557F);
      ((Path)localObject2).lineTo(50.400002F, 4.634556F);
      ((Path)localObject2).lineTo(50.400002F, 14.487597F);
      ((Path)localObject2).lineTo(54.0F, 14.961282F);
      ((Path)localObject2).lineTo(54.0F, 3.068503F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-15365900);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(3.6F, 11.738222F);
      ((Path)localObject1).lineTo(3.6F, 41.976162F);
      ((Path)localObject1).lineTo(53.400002F, 48.528793F);
      ((Path)localObject1).lineTo(53.400002F, 18.290854F);
      ((Path)localObject1).lineTo(3.6F, 11.738222F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(0.0F, 10.638901F);
      ((Path)localObject1).cubicTo(0.0F, 8.979069F, 1.352776F, 7.811505F, 2.984314F, 8.026181F);
      ((Path)localObject1).lineTo(54.477234F, 14.801565F);
      ((Path)localObject1).cubicTo(55.870518F, 14.984893F, 57.0F, 16.29693F, 57.0F, 17.711035F);
      ((Path)localObject1).lineTo(57.0F, 49.628117F);
      ((Path)localObject1).cubicTo(57.0F, 51.287949F, 55.647224F, 52.455513F, 54.015686F, 52.240837F);
      ((Path)localObject1).lineTo(2.522766F, 45.46545F);
      ((Path)localObject1).cubicTo(1.129481F, 45.282124F, 0.0F, 43.970085F, 0.0F, 42.555981F);
      ((Path)localObject1).lineTo(0.0F, 10.638901F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.beg
 * JD-Core Version:    0.7.0.1
 */