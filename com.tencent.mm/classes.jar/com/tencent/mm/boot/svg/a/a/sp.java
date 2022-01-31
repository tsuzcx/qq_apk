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

public final class sp
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      Paint localPaint3 = c.a(localPaint2, paramVarArgs);
      localPaint3.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint3 = c.a(localPaint3, paramVarArgs);
      localPaint2.setColor(-1);
      localPaint3.setColor(-789517);
      localPaint3.setStrokeWidth(3.0F);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(192.0F, 0.0F);
      localPath.lineTo(192.0F, 192.0F);
      localPath.lineTo(0.0F, 192.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 29.0F, 0.0F, 1.0F, 27.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1766893);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(117.54472F, 97.456635F);
      ((Path)localObject2).cubicTo(113.77624F, 90.830521F, 105.46905F, 88.537315F, 98.990112F, 92.33461F);
      ((Path)localObject2).cubicTo(92.511169F, 96.131905F, 46.925743F, 136.63382F, 3.317807F, 94.430313F);
      ((Path)localObject2).cubicTo(46.147934F, 163.20174F, 106.74126F, 123.1558F, 112.63702F, 116.32988F);
      ((Path)localObject2).cubicTo(118.53277F, 109.50396F, 121.31321F, 104.08274F, 117.54472F, 97.456635F);
      ((Path)localObject2).lineTo(117.54472F, 97.456635F);
      ((Path)localObject2).lineTo(117.54472F, 97.456635F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-13651898);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(64.687798F, 8.543366F);
      ((Path)localObject2).cubicTo(60.919312F, 15.169477F, 63.11657F, 23.619318F, 69.595512F, 27.416613F);
      ((Path)localObject2).cubicTo(76.074455F, 31.213909F, 133.41934F, 51.039238F, 119.21951F, 110.47878F);
      ((Path)localObject2).cubicTo(156.47333F, 38.439091F, 92.013481F, 5.191617F, 83.242416F, 3.421343F);
      ((Path)localObject2).cubicTo(74.471352F, 1.651069F, 68.456291F, 1.917256F, 64.687798F, 8.543366F);
      ((Path)localObject2).lineTo(64.687798F, 8.543366F);
      ((Path)localObject2).lineTo(64.687798F, 8.543366F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-10239);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(28.981264F, 85.794235F);
      ((Path)localObject2).cubicTo(28.981264F, 78.199638F, 17.043631F, 17.872393F, 75.727272F, 0.6363636F);
      ((Path)localObject2).cubicTo(-5.570061F, 3.904629F, -1.644966F, 77.198036F, 1.273912F, 85.794235F);
      ((Path)localObject2).cubicTo(4.19279F, 94.390427F, 7.476414F, 99.545456F, 15.127588F, 99.545456F);
      ((Path)localObject2).cubicTo(22.778761F, 99.545456F, 28.981264F, 93.388824F, 28.981264F, 85.794235F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16735005);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(89.169281F, 71.512398F);
      ((Path)localObject1).cubicTo(87.175812F, 67.22876F, 85.37822F, 64.089333F, 85.758621F, 59.78788F);
      ((Path)localObject1).cubicTo(85.178078F, 49.662067F, 77.040192F, 41.448841F, 67.0F, 41.363636F);
      ((Path)localObject1).cubicTo(56.960056F, 41.448841F, 48.822174F, 49.662067F, 48.241379F, 59.78788F);
      ((Path)localObject1).cubicTo(48.620693F, 64.089333F, 46.823097F, 67.22876F, 44.830723F, 71.512398F);
      ((Path)localObject1).cubicTo(41.104324F, 77.520454F, 42.159588F, 85.539589F, 43.978058F, 85.749313F);
      ((Path)localObject1).cubicTo(45.028515F, 85.539589F, 47.160461F, 84.274345F, 49.094044F, 82.399452F);
      ((Path)localObject1).cubicTo(49.748249F, 84.716492F, 51.227226F, 87.040382F, 53.357368F, 89.099174F);
      ((Path)localObject1).cubicTo(50.386162F, 89.726799F, 48.476444F, 91.217392F, 48.241379F, 92.449036F);
      ((Path)localObject1).cubicTo(48.676922F, 95.152611F, 52.903332F, 96.84816F, 57.620689F, 96.63636F);
      ((Path)localObject1).cubicTo(61.953903F, 96.433647F, 65.259254F, 95.14077F, 66.147339F, 93.286499F);
      ((Path)localObject1).cubicTo(66.660583F, 93.487663F, 66.824249F, 93.497528F, 67.0F, 93.286499F);
      ((Path)localObject1).cubicTo(67.181023F, 93.497528F, 67.348701F, 93.487663F, 67.852661F, 93.286499F);
      ((Path)localObject1).cubicTo(68.752037F, 95.14077F, 72.052376F, 96.433647F, 76.379311F, 96.63636F);
      ((Path)localObject1).cubicTo(81.097252F, 96.84816F, 85.322327F, 95.152611F, 85.758621F, 92.449036F);
      ((Path)localObject1).cubicTo(85.523468F, 91.216736F, 83.61409F, 89.726799F, 80.642632F, 89.099174F);
      ((Path)localObject1).cubicTo(82.774696F, 87.040382F, 84.249992F, 84.718796F, 84.905952F, 82.399452F);
      ((Path)localObject1).cubicTo(86.842468F, 84.27533F, 88.970734F, 85.539589F, 90.021942F, 85.749313F);
      ((Path)localObject1).cubicTo(91.841331F, 85.539589F, 92.895927F, 77.520454F, 89.169281F, 71.512398F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sp
 * JD-Core Version:    0.7.0.1
 */