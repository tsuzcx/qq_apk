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

public final class bat
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
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(3.75F, 2.0F);
      ((Path)localObject2).cubicTo(3.75F, 2.96635F, 2.96635F, 3.75F, 2.0F, 3.75F);
      ((Path)localObject2).cubicTo(1.03365F, 3.75F, 0.25F, 2.96635F, 0.25F, 2.0F);
      ((Path)localObject2).cubicTo(0.25F, 1.0333F, 1.03365F, 0.25F, 2.0F, 0.25F);
      ((Path)localObject2).cubicTo(2.96635F, 0.25F, 3.75F, 1.0333F, 3.75F, 2.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.0F, 0.25F);
      ((Path)localObject2).cubicTo(9.96635F, 0.25F, 10.75F, 1.0333F, 10.75F, 2.0F);
      ((Path)localObject2).cubicTo(10.75F, 2.96635F, 9.96635F, 3.75F, 9.0F, 3.75F);
      ((Path)localObject2).cubicTo(8.03365F, 3.75F, 7.25F, 2.96635F, 7.25F, 2.0F);
      ((Path)localObject2).cubicTo(7.25F, 1.0333F, 8.03365F, 0.25F, 9.0F, 0.25F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.0F, 0.25F);
      ((Path)localObject2).cubicTo(16.966351F, 0.25F, 17.75F, 1.0333F, 17.75F, 2.0F);
      ((Path)localObject2).cubicTo(17.75F, 2.96635F, 16.966351F, 3.75F, 16.0F, 3.75F);
      ((Path)localObject2).cubicTo(15.03365F, 3.75F, 14.25F, 2.96635F, 14.25F, 2.0F);
      ((Path)localObject2).cubicTo(14.25F, 1.0333F, 15.03365F, 0.25F, 16.0F, 0.25F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bat
 * JD-Core Version:    0.7.0.1
 */