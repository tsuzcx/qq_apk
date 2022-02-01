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

public final class avl
  extends c
{
  private final int height = 26;
  private final int width = 26;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 26;
      return 26;
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
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(22.799999F, 12.148149F);
      ((Path)localObject2).cubicTo(22.799999F, 6.035186F, 17.964813F, 1.2F, 11.851851F, 1.2F);
      ((Path)localObject2).cubicTo(5.994383F, 1.2F, 1.2F, 6.076857F, 1.2F, 12.148149F);
      ((Path)localObject2).cubicTo(1.2F, 17.964813F, 6.035186F, 22.799999F, 11.851851F, 22.799999F);
      ((Path)localObject2).cubicTo(17.923143F, 22.799999F, 22.799999F, 18.005617F, 22.799999F, 12.148149F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.0F, 12.148149F);
      ((Path)localObject2).cubicTo(24.0F, 18.627556F, 18.627556F, 24.0F, 11.851851F, 24.0F);
      ((Path)localObject2).cubicTo(5.372445F, 24.0F, 0.0F, 18.627556F, 0.0F, 12.148149F);
      ((Path)localObject2).cubicTo(0.0F, 5.372445F, 5.372445F, 0.0F, 11.851851F, 0.0F);
      ((Path)localObject2).cubicTo(18.627556F, 0.0F, 24.0F, 5.372445F, 24.0F, 12.148149F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.avl
 * JD-Core Version:    0.7.0.1
 */