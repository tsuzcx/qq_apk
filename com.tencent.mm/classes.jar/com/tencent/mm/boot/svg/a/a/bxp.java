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

public final class bxp
  extends c
{
  private final int height = 11;
  private final int width = 6;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 6;
      return 11;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Object localObject3 = c.m(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.m(paramVarArgs);
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
      ((Paint)localObject3).setColor(-855310);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -80.0F, 0.0F, 1.0F, -322.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.a((float[])localObject2, 1.0F, 0.0F, 34.0F, 0.0F, 1.0F, 318.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject3, paramVarArgs);
      localObject3 = c.a((float[])localObject4, -1.0F, 0.0F, 98.0F, 0.0F, -1.0F, 19.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(52.0F, 14.3125F);
      ((Path)localObject1).lineTo(51.303509F, 15.0F);
      ((Path)localObject1).lineTo(46.164169F, 9.927012F);
      ((Path)localObject1).cubicTo(45.928337F, 9.694224F, 45.925869F, 9.314333F, 46.158653F, 9.078502F);
      ((Path)localObject1).cubicTo(46.16048F, 9.076652F, 46.162319F, 9.074814F, 46.164169F, 9.072989F);
      ((Path)localObject1).lineTo(51.303509F, 4.0F);
      ((Path)localObject1).lineTo(52.0F, 4.6875F);
      ((Path)localObject1).lineTo(47.124554F, 9.5F);
      ((Path)localObject1).lineTo(52.0F, 14.3125F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bxp
 * JD-Core Version:    0.7.0.1
 */