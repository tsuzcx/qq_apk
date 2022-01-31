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

public final class nj
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 26.0F, 0.0F, 1.0F, 13.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(7.54F, 0.56F);
      ((Path)localObject3).cubicTo(9.03F, -0.52F, 11.01F, 0.49F, 11.71F, 2.02F);
      ((Path)localObject3).cubicTo(12.07F, 3.88F, 10.53F, 5.18F, 9.6F, 6.56F);
      ((Path)localObject3).cubicTo(5.87F, 11.22F, 4.8F, 17.83F, 6.84F, 23.440001F);
      ((Path)localObject3).cubicTo(7.6F, 25.870001F, 9.29F, 27.83F, 10.47F, 30.049999F);
      ((Path)localObject3).cubicTo(11.03F, 31.940001F, 9.0F, 33.560001F, 7.24F, 32.919998F);
      ((Path)localObject3).cubicTo(-1.92F, 24.68F, -1.65F, 8.7F, 7.54F, 0.56F);
      ((Path)localObject3).lineTo(7.54F, 0.56F);
      ((Path)localObject3).lineTo(7.54F, 0.56F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(16.629999F, 7.39F);
      ((Path)localObject2).cubicTo(18.52F, 5.6F, 22.110001F, 7.44F, 21.66F, 10.01F);
      ((Path)localObject2).cubicTo(21.07F, 12.61F, 18.209999F, 14.23F, 18.25F, 17.08F);
      ((Path)localObject2).cubicTo(17.82F, 19.77F, 20.27F, 21.5F, 20.98F, 23.860001F);
      ((Path)localObject2).cubicTo(21.370001F, 26.540001F, 17.58F, 28.309999F, 15.8F, 26.27F);
      ((Path)localObject2).cubicTo(11.33F, 20.870001F, 12.03F, 12.48F, 16.629999F, 7.39F);
      ((Path)localObject2).lineTo(16.629999F, 7.39F);
      ((Path)localObject2).lineTo(16.629999F, 7.39F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.nj
 * JD-Core Version:    0.7.0.1
 */