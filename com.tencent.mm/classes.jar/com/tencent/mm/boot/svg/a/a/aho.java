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

public final class aho
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.757333F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.464519F, 1.464466F);
      ((Path)localObject2).cubicTo(3.41714F, -0.4881554F, 6.582965F, -0.4881554F, 8.535586F, 1.464466F);
      ((Path)localObject2).cubicTo(8.718393F, 1.647273F, 8.954096F, 1.874633F, 9.242693F, 2.146546F);
      ((Path)localObject2).cubicTo(9.531291F, 1.874633F, 9.766994F, 1.647273F, 9.949801F, 1.464466F);
      ((Path)localObject2).cubicTo(11.902422F, -0.4881554F, 15.068247F, -0.4881554F, 17.020868F, 1.464466F);
      ((Path)localObject2).cubicTo(18.955326F, 3.398924F, 18.97332F, 6.52412F, 17.07485F, 8.480731F);
      ((Path)localObject2).lineTo(9.949763F, 15.606565F);
      ((Path)localObject2).cubicTo(9.559297F, 15.997147F, 8.926131F, 15.99718F, 8.535586F, 15.606676F);
      ((Path)localObject2).cubicTo(8.535574F, 15.606664F, 8.535562F, 15.606651F, 8.535586F, 15.606602F);
      ((Path)localObject2).lineTo(1.410126F, 8.481141F);
      ((Path)localObject2).cubicTo(-0.487934F, 6.52412F, -0.4699394F, 3.398924F, 1.464519F, 1.464466F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aho
 * JD-Core Version:    0.7.0.1
 */