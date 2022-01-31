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

public final class aqy
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-9473160);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(96.0F, 48.0F);
      ((Path)localObject3).cubicTo(96.0F, 21.490332F, 74.509666F, 0.0F, 48.0F, 0.0F);
      ((Path)localObject3).cubicTo(21.490332F, 0.0F, 0.0F, 21.490332F, 0.0F, 48.0F);
      ((Path)localObject3).cubicTo(0.0F, 74.509666F, 21.490332F, 96.0F, 48.0F, 96.0F);
      ((Path)localObject3).cubicTo(74.509666F, 96.0F, 96.0F, 74.509666F, 96.0F, 48.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(2.232558F, 48.0F);
      ((Path)localObject3).cubicTo(2.232558F, 22.723339F, 22.723339F, 2.232558F, 48.0F, 2.232558F);
      ((Path)localObject3).cubicTo(73.276657F, 2.232558F, 93.767441F, 22.723339F, 93.767441F, 48.0F);
      ((Path)localObject3).cubicTo(93.767441F, 73.276657F, 73.276657F, 93.767441F, 48.0F, 93.767441F);
      ((Path)localObject3).cubicTo(22.723339F, 93.767441F, 2.232558F, 73.276657F, 2.232558F, 48.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(52.426956F, 73.072449F);
      ((Path)localObject2).cubicTo(58.939968F, 66.878403F, 63.0F, 58.129028F, 63.0F, 48.431385F);
      ((Path)localObject2).cubicTo(63.0F, 38.842663F, 59.030663F, 30.181034F, 52.645496F, 24.0F);
      ((Path)localObject2).lineTo(48.402168F, 28.243324F);
      ((Path)localObject2).cubicTo(53.701862F, 33.337967F, 57.0F, 40.499516F, 57.0F, 48.431385F);
      ((Path)localObject2).cubicTo(57.0F, 56.472187F, 53.610649F, 63.721367F, 48.182682F, 68.828178F);
      ((Path)localObject2).lineTo(52.426956F, 73.072449F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(42.522125F, 63.167622F);
      ((Path)localObject2).cubicTo(46.504047F, 59.511826F, 49.0F, 54.263084F, 49.0F, 48.431385F);
      ((Path)localObject2).cubicTo(49.0F, 42.708645F, 46.596447F, 37.547287F, 42.743767F, 33.90173F);
      ((Path)localObject2).lineTo(38.498798F, 38.146698F);
      ((Path)localObject2).cubicTo(41.266747F, 40.704395F, 43.0F, 44.365479F, 43.0F, 48.431385F);
      ((Path)localObject2).cubicTo(43.0F, 52.606312F, 41.17255F, 56.354416F, 38.273926F, 58.919418F);
      ((Path)localObject2).lineTo(42.522125F, 63.167622F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.30555F, 53.951042F);
      ((Path)localObject2).cubicTo(34.945602F, 52.669918F, 36.0F, 50.673786F, 36.0F, 48.431385F);
      ((Path)localObject2).cubicTo(36.0F, 46.298347F, 35.045944F, 44.388142F, 33.541275F, 43.104218F);
      ((Path)localObject2).lineTo(28.0F, 48.645496F);
      ((Path)localObject2).lineTo(33.30555F, 53.951042F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqy
 * JD-Core Version:    0.7.0.1
 */