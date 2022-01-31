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

public final class em
  extends c
{
  private final int height = 58;
  private final int width = 58;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 58;
      return 58;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Object localObject3 = c.k(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.k(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.a((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      localObject4 = c.a((float[])localObject2, 1.0F, 0.0F, -249.0F, 0.0F, 1.0F, -79.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject3, paramVarArgs);
      localObject3 = c.a((float[])localObject4, 0.7071068F, 0.7071068F, 4.642571F, -0.7071068F, 0.7071068F, 229.20816F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(277.0F, 118.906F);
      ((Path)localObject1).lineTo(277.0F, 141.0F);
      ((Path)localObject1).lineTo(283.0F, 141.0F);
      ((Path)localObject1).lineTo(283.0F, 118.61951F);
      ((Path)localObject1).cubicTo(292.68488F, 116.75179F, 300.0F, 108.23016F, 300.0F, 98.0F);
      ((Path)localObject1).cubicTo(300.0F, 86.402023F, 290.59799F, 77.0F, 279.0F, 77.0F);
      ((Path)localObject1).cubicTo(267.40201F, 77.0F, 258.0F, 86.402023F, 258.0F, 98.0F);
      ((Path)localObject1).cubicTo(258.0F, 108.92341F, 266.34015F, 117.89888F, 277.0F, 118.906F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(279.0F, 113.0F);
      ((Path)localObject1).cubicTo(287.28427F, 113.0F, 294.0F, 106.28427F, 294.0F, 98.0F);
      ((Path)localObject1).cubicTo(294.0F, 89.715729F, 287.28427F, 83.0F, 279.0F, 83.0F);
      ((Path)localObject1).cubicTo(270.71573F, 83.0F, 264.0F, 89.715729F, 264.0F, 98.0F);
      ((Path)localObject1).cubicTo(264.0F, 106.28427F, 270.71573F, 113.0F, 279.0F, 113.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.em
 * JD-Core Version:    0.7.0.1
 */