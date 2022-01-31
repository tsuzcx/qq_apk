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

public final class as
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localCanvas.saveLayerAlpha(null, 128, 4);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 7.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(35.0F, 65.800003F);
      ((Path)localObject2).cubicTo(52.010372F, 65.800003F, 65.800003F, 52.010372F, 65.800003F, 35.0F);
      ((Path)localObject2).cubicTo(65.800003F, 17.98963F, 52.010372F, 4.2F, 35.0F, 4.2F);
      ((Path)localObject2).cubicTo(17.98963F, 4.2F, 4.2F, 17.98963F, 4.2F, 35.0F);
      ((Path)localObject2).cubicTo(4.2F, 52.010372F, 17.98963F, 65.800003F, 35.0F, 65.800003F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(35.0F, 70.0F);
      ((Path)localObject2).cubicTo(15.670033F, 70.0F, 0.0F, 54.329967F, 0.0F, 35.0F);
      ((Path)localObject2).cubicTo(0.0F, 15.670033F, 15.670033F, 0.0F, 35.0F, 0.0F);
      ((Path)localObject2).cubicTo(54.329967F, 0.0F, 70.0F, 15.670033F, 70.0F, 35.0F);
      ((Path)localObject2).cubicTo(70.0F, 54.329967F, 54.329967F, 70.0F, 35.0F, 70.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(35.0F, 53.549999F);
      ((Path)localObject2).cubicTo(42.828125F, 53.549999F, 49.405746F, 48.195953F, 51.270725F, 40.950001F);
      ((Path)localObject2).lineTo(18.729273F, 40.950001F);
      ((Path)localObject2).cubicTo(20.594254F, 48.195953F, 27.171875F, 53.549999F, 35.0F, 53.549999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.0F, 36.75F);
      ((Path)localObject2).lineTo(56.0F, 36.75F);
      ((Path)localObject2).cubicTo(56.0F, 48.34798F, 46.59798F, 57.75F, 35.0F, 57.75F);
      ((Path)localObject2).cubicTo(23.40202F, 57.75F, 14.0F, 48.34798F, 14.0F, 36.75F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(22.75F, 29.75F);
      ((Path)localObject1).cubicTo(19.850506F, 29.75F, 17.5F, 27.399494F, 17.5F, 24.5F);
      ((Path)localObject1).cubicTo(17.5F, 21.600506F, 19.850506F, 19.25F, 22.75F, 19.25F);
      ((Path)localObject1).cubicTo(25.649494F, 19.25F, 28.0F, 21.600506F, 28.0F, 24.5F);
      ((Path)localObject1).cubicTo(28.0F, 27.399494F, 25.649494F, 29.75F, 22.75F, 29.75F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(47.25F, 29.75F);
      ((Path)localObject1).cubicTo(44.350506F, 29.75F, 42.0F, 27.399494F, 42.0F, 24.5F);
      ((Path)localObject1).cubicTo(42.0F, 21.600506F, 44.350506F, 19.25F, 47.25F, 19.25F);
      ((Path)localObject1).cubicTo(50.149494F, 19.25F, 52.5F, 21.600506F, 52.5F, 24.5F);
      ((Path)localObject1).cubicTo(52.5F, 27.399494F, 50.149494F, 29.75F, 47.25F, 29.75F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.as
 * JD-Core Version:    0.7.0.1
 */