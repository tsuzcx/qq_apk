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

public final class kr
  extends c
{
  private final int height = 117;
  private final int width = 117;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 117;
      return 117;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -323.0F, 0.0F, 1.0F, -139.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 323.0F, 0.0F, 1.0F, 139.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-2565928);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(117.0F, 0.0F);
      ((Path)localObject2).lineTo(117.0F, 117.0F);
      ((Path)localObject2).lineTo(0.0F, 117.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 0, 4);
      localCanvas.drawPath((Path)localObject2, c.a((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-2606050);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(9.0F, 4.0F);
      ((Path)localObject2).cubicTo(9.0F, 1.790861F, 10.790861F, 0.0F, 13.0F, 0.0F);
      ((Path)localObject2).lineTo(104.0F, 0.0F);
      ((Path)localObject2).cubicTo(106.20914F, 0.0F, 108.0F, 1.790861F, 108.0F, 4.0F);
      ((Path)localObject2).lineTo(108.0F, 113.0F);
      ((Path)localObject2).cubicTo(108.0F, 115.20914F, 106.20914F, 117.0F, 104.0F, 117.0F);
      ((Path)localObject2).lineTo(13.0F, 117.0F);
      ((Path)localObject2).cubicTo(10.790861F, 117.0F, 9.0F, 115.20914F, 9.0F, 113.0F);
      ((Path)localObject2).lineTo(9.0F, 4.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1029075);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(58.0F, -158.0F);
      ((Path)localObject2).cubicTo(115.9899F, -158.0F, 163.0F, -110.9899F, 163.0F, -53.0F);
      ((Path)localObject2).cubicTo(163.0F, 4.989903F, 115.9899F, 52.0F, 58.0F, 52.0F);
      ((Path)localObject2).cubicTo(0.0100975F, 52.0F, -47.0F, 4.989903F, -47.0F, -53.0F);
      ((Path)localObject2).cubicTo(-47.0F, -110.9899F, 0.0100975F, -158.0F, 58.0F, -158.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-600934);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(58.5F, 31.0F);
      ((Path)localObject2).cubicTo(68.164986F, 31.0F, 76.0F, 38.835014F, 76.0F, 48.5F);
      ((Path)localObject2).cubicTo(76.0F, 58.164986F, 68.164986F, 66.0F, 58.5F, 66.0F);
      ((Path)localObject2).cubicTo(48.835014F, 66.0F, 41.0F, 58.164986F, 41.0F, 48.5F);
      ((Path)localObject2).cubicTo(41.0F, 38.835014F, 48.835014F, 31.0F, 58.5F, 31.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1604553);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(61.1106F, 46.0F);
      ((Path)localObject1).lineTo(66.0F, 46.0F);
      ((Path)localObject1).lineTo(66.0F, 49.0F);
      ((Path)localObject1).lineTo(60.0F, 49.0F);
      ((Path)localObject1).lineTo(60.0F, 52.0F);
      ((Path)localObject1).lineTo(66.0F, 52.0F);
      ((Path)localObject1).lineTo(66.0F, 55.0F);
      ((Path)localObject1).lineTo(60.0F, 55.0F);
      ((Path)localObject1).lineTo(60.0F, 59.0F);
      ((Path)localObject1).lineTo(57.0F, 59.0F);
      ((Path)localObject1).lineTo(57.0F, 55.0F);
      ((Path)localObject1).lineTo(51.0F, 55.0F);
      ((Path)localObject1).lineTo(51.0F, 52.0F);
      ((Path)localObject1).lineTo(57.0F, 52.0F);
      ((Path)localObject1).lineTo(57.0F, 49.0F);
      ((Path)localObject1).lineTo(51.0F, 49.0F);
      ((Path)localObject1).lineTo(51.0F, 46.0F);
      ((Path)localObject1).lineTo(55.878681F, 46.0F);
      ((Path)localObject1).lineTo(51.707108F, 41.828426F);
      ((Path)localObject1).cubicTo(51.316582F, 41.437904F, 51.316582F, 40.804737F, 51.707108F, 40.414215F);
      ((Path)localObject1).lineTo(52.414215F, 39.707108F);
      ((Path)localObject1).lineTo(52.414215F, 39.707108F);
      ((Path)localObject1).cubicTo(52.804737F, 39.316582F, 53.437904F, 39.316582F, 53.828426F, 39.707108F);
      ((Path)localObject1).lineTo(53.828426F, 39.707108F);
      ((Path)localObject1).lineTo(58.49464F, 44.373318F);
      ((Path)localObject1).lineTo(63.160851F, 39.707108F);
      ((Path)localObject1).lineTo(63.160851F, 39.707108F);
      ((Path)localObject1).cubicTo(63.551376F, 39.316582F, 64.18454F, 39.316582F, 64.575066F, 39.707108F);
      ((Path)localObject1).lineTo(64.575066F, 39.707108F);
      ((Path)localObject1).lineTo(65.282173F, 40.414215F);
      ((Path)localObject1).cubicTo(65.672699F, 40.804737F, 65.672699F, 41.437904F, 65.282173F, 41.828426F);
      ((Path)localObject1).lineTo(65.282173F, 41.828426F);
      ((Path)localObject1).lineTo(61.1106F, 46.0F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.kr
 * JD-Core Version:    0.7.0.1
 */