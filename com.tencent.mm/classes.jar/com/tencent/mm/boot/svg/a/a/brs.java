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

public final class brs
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
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
      localPaint1.setColor(-27648);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(26.41996F, 1.7124F);
      ((Path)localObject2).cubicTo(42.029785F, -1.784037F, 59.069595F, 7.946046F, 64.089539F, 23.090612F);
      ((Path)localObject2).cubicTo(69.899475F, 38.474934F, 61.969563F, 57.265781F, 46.919731F, 63.879044F);
      ((Path)localObject2).cubicTo(32.549892F, 71.011772F, 13.600102F, 65.467422F, 5.210196F, 51.841309F);
      ((Path)localObject2).cubicTo(-2.909714F, 39.703682F, -1.379731F, 22.281437F, 8.690157F, 11.712208F);
      ((Path)localObject2).cubicTo(13.340105F, 6.617401F, 19.670034F, 3.110974F, 26.41996F, 1.7124F);
      ((Path)localObject2).lineTo(26.41996F, 1.7124F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 32.0F);
      ((Path)localObject2).lineTo(12.0F, 36.0F);
      ((Path)localObject2).lineTo(54.0F, 36.0F);
      ((Path)localObject2).lineTo(54.0F, 32.0F);
      ((Path)localObject2).lineTo(12.0F, 32.0F);
      ((Path)localObject2).lineTo(12.0F, 32.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.brs
 * JD-Core Version:    0.7.0.1
 */