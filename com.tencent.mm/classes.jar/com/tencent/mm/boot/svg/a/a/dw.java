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

public final class dw
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -134.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 134.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-789517);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 60.0F);
      ((Path)localObject2).cubicTo(0.0F, 26.862915F, 26.862915F, 0.0F, 60.0F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 0.0F);
      ((Path)localObject2).cubicTo(93.137085F, 0.0F, 120.0F, 26.862915F, 120.0F, 60.0F);
      ((Path)localObject2).lineTo(120.0F, 60.0F);
      ((Path)localObject2).cubicTo(120.0F, 93.137085F, 93.137085F, 120.0F, 60.0F, 120.0F);
      ((Path)localObject2).lineTo(60.0F, 120.0F);
      ((Path)localObject2).cubicTo(26.862915F, 120.0F, 0.0F, 93.137085F, 0.0F, 60.0F);
      ((Path)localObject2).lineTo(0.0F, 60.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-3552823);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(51.0F, 61.0F);
      ((Path)localObject1).cubicTo(54.701481F, 67.458328F, 48.275417F, 70.242233F, 45.0F, 72.0F);
      ((Path)localObject1).cubicTo(34.045288F, 78.357491F, 29.0F, 80.817688F, 29.0F, 84.0F);
      ((Path)localObject1).lineTo(29.0F, 88.0F);
      ((Path)localObject1).cubicTo(29.0F, 89.783974F, 30.049908F, 91.0F, 32.0F, 91.0F);
      ((Path)localObject1).lineTo(88.0F, 91.0F);
      ((Path)localObject1).cubicTo(89.950096F, 91.0F, 91.0F, 89.783974F, 91.0F, 88.0F);
      ((Path)localObject1).lineTo(91.0F, 84.0F);
      ((Path)localObject1).cubicTo(91.0F, 80.817688F, 85.954712F, 78.357491F, 75.0F, 72.0F);
      ((Path)localObject1).cubicTo(71.724586F, 70.242233F, 65.298523F, 67.458328F, 69.0F, 61.0F);
      ((Path)localObject1).cubicTo(72.606285F, 56.205429F, 75.288353F, 54.126183F, 76.0F, 45.0F);
      ((Path)localObject1).cubicTo(75.288353F, 37.48938F, 69.296677F, 29.0F, 60.0F, 29.0F);
      ((Path)localObject1).cubicTo(50.703327F, 29.0F, 44.711647F, 37.48938F, 45.0F, 45.0F);
      ((Path)localObject1).cubicTo(44.711647F, 54.126183F, 47.393715F, 56.205429F, 51.0F, 61.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.dw
 * JD-Core Version:    0.7.0.1
 */