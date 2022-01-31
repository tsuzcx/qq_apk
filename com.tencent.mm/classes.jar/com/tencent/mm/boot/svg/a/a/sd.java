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

public final class sd
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-2565928);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(36.0F, 66.0F);
      localPath.cubicTo(52.568542F, 66.0F, 66.0F, 52.568542F, 66.0F, 36.0F);
      localPath.cubicTo(66.0F, 19.431458F, 52.568542F, 6.0F, 36.0F, 6.0F);
      localPath.cubicTo(19.431458F, 6.0F, 6.0F, 19.431458F, 6.0F, 36.0F);
      localPath.cubicTo(6.0F, 52.568542F, 19.431458F, 66.0F, 36.0F, 66.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(36.0F, 66.0F);
      localPath.cubicTo(52.568542F, 66.0F, 66.0F, 52.568542F, 66.0F, 36.0F);
      localPath.cubicTo(66.0F, 19.431458F, 52.568542F, 6.0F, 36.0F, 6.0F);
      localPath.cubicTo(19.431458F, 6.0F, 6.0F, 19.431458F, 6.0F, 36.0F);
      localPath.cubicTo(6.0F, 52.568542F, 19.431458F, 66.0F, 36.0F, 66.0F);
      localPath.close();
      Paint localPaint3 = c.i(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.FILL);
      Paint localPaint4 = c.i(paramVarArgs);
      localPaint4.setFlags(385);
      localPaint4.setStyle(Paint.Style.STROKE);
      localPaint3.setColor(-16777216);
      localPaint4.setStrokeWidth(1.0F);
      localPaint4.setStrokeCap(Paint.Cap.BUTT);
      localPaint4.setStrokeJoin(Paint.Join.MITER);
      localPaint4.setStrokeMiter(4.0F);
      localPaint4.setPathEffect(null);
      localObject2 = c.a((float[])localObject2, 66.0F, 0.0F, 6.0F, 0.0F, 66.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint2, 0.5F, 0.0F, 0.5F, 1.0F, new int[] { -9619, -15075 }, new float[] { 0.0F, 1.0F }, (Matrix)localObject1, 0);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-4819456);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(18.0F, 42.096611F);
      ((Path)localObject2).cubicTo(30.07F, 41.946609F, 42.139999F, 41.996613F, 54.209999F, 42.076611F);
      ((Path)localObject2).cubicTo(52.740002F, 46.706612F, 50.150002F, 51.266613F, 45.720001F, 53.62661F);
      ((Path)localObject2).cubicTo(38.470001F, 57.526611F, 28.389999F, 56.726612F, 22.610001F, 50.55661F);
      ((Path)localObject2).cubicTo(20.32F, 48.21661F, 19.129999F, 45.106609F, 18.0F, 42.096611F);
      ((Path)localObject2).lineTo(18.0F, 42.096611F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-8301568);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 25.0F);
      ((Path)localObject2).cubicTo(26.209139F, 25.0F, 28.0F, 27.014719F, 28.0F, 29.5F);
      ((Path)localObject2).cubicTo(28.0F, 31.985281F, 26.209139F, 34.0F, 24.0F, 34.0F);
      ((Path)localObject2).cubicTo(21.790861F, 34.0F, 20.0F, 31.985281F, 20.0F, 29.5F);
      ((Path)localObject2).cubicTo(20.0F, 27.014719F, 21.790861F, 25.0F, 24.0F, 25.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8301568);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(48.0F, 25.0F);
      ((Path)localObject1).cubicTo(50.209141F, 25.0F, 52.0F, 27.014719F, 52.0F, 29.5F);
      ((Path)localObject1).cubicTo(52.0F, 31.985281F, 50.209141F, 34.0F, 48.0F, 34.0F);
      ((Path)localObject1).cubicTo(45.790859F, 34.0F, 44.0F, 31.985281F, 44.0F, 29.5F);
      ((Path)localObject1).cubicTo(44.0F, 27.014719F, 45.790859F, 25.0F, 48.0F, 25.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sd
 * JD-Core Version:    0.7.0.1
 */