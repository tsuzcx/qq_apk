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

public final class btd
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
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 0.96F, 0.0F, 0.0F, 0.0F, 0.96F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a(arrayOfFloat, 1.0F, 0.0F, -16.0F, 0.0F, 1.0F, -229.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 229.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16268960);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 12.148149F);
      ((Path)localObject2).cubicTo(24.0F, 5.372445F, 18.627556F, 0.0F, 11.851851F, 0.0F);
      ((Path)localObject2).cubicTo(5.372445F, 0.0F, 0.0F, 5.372445F, 0.0F, 12.148149F);
      ((Path)localObject2).cubicTo(0.0F, 18.627556F, 5.372445F, 24.0F, 11.851851F, 24.0F);
      ((Path)localObject2).cubicTo(18.627556F, 24.0F, 24.0F, 18.627556F, 24.0F, 12.148149F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(10.363961F, 15.313708F);
      ((Path)localObject1).lineTo(7.06066F, 12.010407F);
      ((Path)localObject1).lineTo(6.0F, 13.071068F);
      ((Path)localObject1).lineTo(9.656855F, 16.727922F);
      ((Path)localObject1).cubicTo(10.047379F, 17.118446F, 10.680544F, 17.118446F, 11.071068F, 16.727922F);
      ((Path)localObject1).lineTo(18.738329F, 9.06066F);
      ((Path)localObject1).lineTo(17.67767F, 8.0F);
      ((Path)localObject1).lineTo(10.363961F, 15.313708F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.btd
 * JD-Core Version:    0.7.0.1
 */