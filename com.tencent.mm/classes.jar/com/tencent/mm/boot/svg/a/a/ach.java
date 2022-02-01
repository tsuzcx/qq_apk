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

public final class ach
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(120.0F, 0.0F);
      localPath.lineTo(120.0F, 120.0F);
      localPath.lineTo(0.0F, 120.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15432210);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(60.597374F, 19.200624F);
      ((Path)localObject2).lineTo(36.0F, 33.401924F);
      ((Path)localObject2).lineTo(11.402575F, 19.200594F);
      ((Path)localObject2).cubicTo(11.464108F, 19.16046F, 11.526233F, 19.122423F, 11.588874F, 19.086618F);
      ((Path)localObject2).lineTo(33.411125F, 6.612736F);
      ((Path)localObject2).cubicTo(34.840923F, 5.795446F, 37.160156F, 5.796063F, 38.588875F, 6.612736F);
      ((Path)localObject2).lineTo(60.411125F, 19.086618F);
      ((Path)localObject2).cubicTo(60.473751F, 19.122416F, 60.535858F, 19.160461F, 60.597374F, 19.200624F);
      ((Path)localObject2).lineTo(60.597374F, 19.200624F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-372399);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(62.968868F, 23.027594F);
      ((Path)localObject2).cubicTo(62.989361F, 23.187063F, 63.0F, 23.344381F, 63.0F, 23.49818F);
      ((Path)localObject2).lineTo(63.0F, 48.50182F);
      ((Path)localObject2).cubicTo(63.0F, 50.120968F, 61.839844F, 52.09671F, 60.411125F, 52.913383F);
      ((Path)localObject2).lineTo(38.588875F, 65.38726F);
      ((Path)localObject2).cubicTo(38.480747F, 65.449074F, 38.367531F, 65.506203F, 38.25F, 65.558655F);
      ((Path)localObject2).lineTo(38.25F, 37.299038F);
      ((Path)localObject2).lineTo(62.968868F, 23.027594F);
      ((Path)localObject2).lineTo(62.968868F, 23.027594F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-15616);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(33.75F, 65.558647F);
      ((Path)localObject1).cubicTo(33.632458F, 65.506195F, 33.519241F, 65.449066F, 33.411125F, 65.38726F);
      ((Path)localObject1).lineTo(11.588874F, 52.913383F);
      ((Path)localObject1).cubicTo(10.159078F, 52.096092F, 9.0F, 50.107227F, 9.0F, 48.50182F);
      ((Path)localObject1).lineTo(9.0F, 23.49818F);
      ((Path)localObject1).cubicTo(9.0F, 23.344044F, 9.010513F, 23.186676F, 9.030771F, 23.027386F);
      ((Path)localObject1).lineTo(33.75F, 37.299038F);
      ((Path)localObject1).lineTo(33.75F, 65.558647F);
      ((Path)localObject1).lineTo(33.75F, 65.558647F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ach
 * JD-Core Version:    0.7.0.1
 */