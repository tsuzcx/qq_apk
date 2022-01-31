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

public final class gh
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617594);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 37.0F, 0.0F, 1.0F, 57.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(64.0F, 39.599926F);
      ((Path)localObject2).lineTo(64.0F, 49.099926F);
      ((Path)localObject2).cubicTo(64.0F, 51.073624F, 62.65501F, 52.407425F, 61.0F, 52.099926F);
      ((Path)localObject2).lineTo(3.0F, 52.099926F);
      ((Path)localObject2).cubicTo(1.341462F, 52.407425F, 0.0F, 51.07877F, 0.0F, 49.099926F);
      ((Path)localObject2).lineTo(0.0F, 5.099926F);
      ((Path)localObject2).cubicTo(0.0F, 3.094035F, 1.344991F, 1.760234F, 3.0F, 2.099926F);
      ((Path)localObject2).lineTo(61.0F, 2.099926F);
      ((Path)localObject2).cubicTo(62.658539F, 1.760234F, 64.0F, 3.08889F, 64.0F, 5.099926F);
      ((Path)localObject2).lineTo(64.0F, 14.099925F);
      ((Path)localObject2).lineTo(64.0F, 39.599926F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(70.0F, 35.626068F);
      ((Path)localObject2).cubicTo(77.765816F, 42.808117F, 88.739769F, 53.013004F, 90.0F, 54.099926F);
      ((Path)localObject2).cubicTo(91.915451F, 54.668461F, 94.0F, 53.152363F, 94.0F, 51.099926F);
      ((Path)localObject2).lineTo(94.0F, 3.099926F);
      ((Path)localObject2).cubicTo(94.0F, 0.7384861F, 91.694824F, -0.3512091F, 90.0F, 0.09992552F);
      ((Path)localObject2).cubicTo(88.3209F, 1.364696F, 77.582428F, 11.272879F, 70.0F, 17.971575F);
      ((Path)localObject2).lineTo(70.0F, 35.626068F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.gh
 * JD-Core Version:    0.7.0.1
 */