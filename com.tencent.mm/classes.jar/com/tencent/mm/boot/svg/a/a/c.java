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

public final class c
  extends com.tencent.mm.svg.c
{
  private final int height = 25;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 25;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = com.tencent.mm.svg.c.j(paramVarArgs);
      float[] arrayOfFloat = com.tencent.mm.svg.c.i(paramVarArgs);
      Object localObject2 = com.tencent.mm.svg.c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = com.tencent.mm.svg.c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      com.tencent.mm.svg.c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = com.tencent.mm.svg.c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-3684404);
      arrayOfFloat = com.tencent.mm.svg.c.a(arrayOfFloat, 1.0F, 0.0F, -666.0F, 0.0F, 1.0F, -269.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = com.tencent.mm.svg.c.a(arrayOfFloat, 1.0F, 0.0F, 30.0F, 0.0F, 1.0F, 208.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = com.tencent.mm.svg.c.a(arrayOfFloat, 1.0F, 0.0F, 30.0F, 0.0F, 1.0F, 48.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = com.tencent.mm.svg.c.a((Paint)localObject2, paramVarArgs);
      localObject2 = com.tencent.mm.svg.c.n(paramVarArgs);
      ((Path)localObject2).moveTo(622.0F, 25.531904F);
      ((Path)localObject2).lineTo(609.32074F, 38.0F);
      ((Path)localObject2).lineTo(606.38727F, 34.988819F);
      ((Path)localObject2).lineTo(616.13208F, 25.4053F);
      ((Path)localObject2).lineTo(606.0F, 16.074991F);
      ((Path)localObject2).lineTo(609.12708F, 13.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      com.tencent.mm.svg.c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.c
 * JD-Core Version:    0.7.0.1
 */