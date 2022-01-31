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

public final class jg
  extends c
{
  private final int height = 12;
  private final int width = 12;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 12;
      return 12;
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
      localCanvas.saveLayerAlpha(null, 76, 4);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject2 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.3622318F);
      ((Path)localObject1).lineTo(8.0F, 0.3622318F);
      ((Path)localObject1).lineTo(8.0F, 1.562232F);
      ((Path)localObject1).lineTo(0.0F, 1.562232F);
      ((Path)localObject1).lineTo(0.0F, 0.3622318F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(0.0F, 3.556521F);
      ((Path)localObject1).lineTo(8.0F, 3.556521F);
      ((Path)localObject1).lineTo(8.0F, 4.756521F);
      ((Path)localObject1).lineTo(0.0F, 4.756521F);
      ((Path)localObject1).lineTo(0.0F, 3.556521F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(0.0F, 6.694589F);
      ((Path)localObject1).lineTo(8.0F, 6.694589F);
      ((Path)localObject1).lineTo(8.0F, 7.894589F);
      ((Path)localObject1).lineTo(0.0F, 7.894589F);
      ((Path)localObject1).lineTo(0.0F, 6.694589F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 230, 4);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.jg
 * JD-Core Version:    0.7.0.1
 */